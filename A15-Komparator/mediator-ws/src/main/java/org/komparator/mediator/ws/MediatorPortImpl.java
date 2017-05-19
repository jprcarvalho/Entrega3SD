package org.komparator.mediator.ws;


import static javax.xml.ws.BindingProvider.ENDPOINT_ADDRESS_PROPERTY;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.sql.Timestamp;
import java.io.File;
import java.io.FileNotFoundException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;

import java.security.UnrecoverableKeyException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import static javax.xml.bind.DatatypeConverter.parseBase64Binary;
import static javax.xml.bind.DatatypeConverter.printBase64Binary;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.jws.HandlerChain;
import javax.jws.Oneway;
import javax.jws.WebService;
import javax.xml.ws.BindingProvider;

import org.komparator.mediator.ws.cli.MediatorClientException;
import org.komparator.security.CryptoUtil;
import org.komparator.supplier.ws.BadProduct;
import org.komparator.supplier.ws.BadProductId;
import org.komparator.supplier.ws.BadProductId_Exception;
import org.komparator.supplier.ws.BadProduct_Exception;
import org.komparator.supplier.ws.BadQuantity;
import org.komparator.supplier.ws.BadQuantity_Exception;
import org.komparator.supplier.ws.BadText;
import org.komparator.supplier.ws.BadText_Exception;
import org.komparator.supplier.ws.InsufficientQuantity;
import org.komparator.supplier.ws.InsufficientQuantity_Exception;
import org.komparator.supplier.ws.ProductView;
import org.komparator.supplier.ws.SupplierPortType;
import org.komparator.supplier.ws.SupplierService;
import org.komparator.supplier.ws.cli.SupplierClient;

import pt.ulisboa.tecnico.sdis.ws.CreditCard;
import pt.ulisboa.tecnico.sdis.ws.CreditCardImplService;
import pt.ulisboa.tecnico.sdis.ws.cli.CreditCardClient;
import pt.ulisboa.tecnico.sdis.ws.cli.CreditCardClientException;
import pt.ulisboa.tecnico.sdis.ws.uddi.UDDINaming;
import pt.ulisboa.tecnico.sdis.ws.uddi.UDDINamingException;
/*
import org.komparator.supplier.domain.Product;
import org.komparator.supplier.domain.Purchase;
import org.komparator.supplier.domain.QuantityException;
import org.komparator.supplier.domain.Supplier;
*/
import pt.ulisboa.tecnico.sdis.ws.uddi.UDDIRecord;
import pt.ulisboa.tecnico.sdis.cert.CertUtil;
// TODO annotate to bind with WSDL
// TODO implement port type interface
@WebService(
		endpointInterface = "org.komparator.mediator.ws.MediatorPortType", 
		wsdlLocation = "mediator.1_0.wsdl", 
		name = "MediatorWebService", 
		portName = "MediatorPort", 
		targetNamespace = "http://ws.mediator.komparator.org/", 
		serviceName = "MediatorService"
)
@HandlerChain(file="/mediator-ws_handler-chain.xml")
public class MediatorPortImpl implements MediatorPortType {
	//Price comparator needs testing
	public class ItemViewComparatorDesc implements Comparator<ItemView> {
		
	    @Override
	    public int compare(ItemView o1, ItemView o2) {
	    	//System.out.println(o1.getDesc() + " compareTo " + o2.getDesc());
	        int i = o1.getItemId().getProductId().compareTo(o2.getItemId().getProductId());
	        if (i != 0) 
	        	return i;
	        else 
	        	return o1.getPrice()-o2.getPrice();
	    }
	}
	public class ItemViewComparatorPrice implements Comparator<ItemView> {
	
	    @Override
	    public int compare(ItemView o1, ItemView o2) {
	        return o1.getPrice()-o2.getPrice();
	    }
	}
	/*
	public class ShoppingCart{
		private String cartName;
		private HashMap<ItemView,Integer> contents = new HashMap<ItemView,Integer>();
		public ShoppingCart(String name){
			this.cartName = name;
		}
		public String getName(){return this.cartName;}
		public void addToCart(ItemView thing,int amount){
			if(this.contents.containsKey(thing)){
				this.contents.replace(thing, amount + this.contents.get(thing));
			}
			else{
				this.contents.put(thing, amount);
			}
		}
	}*/
	// end point manager
	
	//crypto
	private CryptoUtil cryptkeeper = null; //spooky//	  .-.
													//	 (o o) boo!
													//	 | O \
													//	  \   \
													//	   `~~~'
    private KeyStore keys = null;
    private char[] keystorePassword = "7Nhx1rNT".toCharArray();
    private PrivateKey privateKey =null;
    private PublicKey publicKey = null;
	private Certificate cert =null;
	private boolean isPrimary = false;
	private int i=0;
	private ArrayList<ShoppingResultView> history = new ArrayList<ShoppingResultView>();
	private MediatorEndpointManager endpointManager;
	private Collection<UDDIRecord> records;
	private HashMap<SupplierPortType,String> ports;
	private ArrayList<CartView> carts = new ArrayList<CartView>();
	private HashMap<SupplierClient,String> suppliers;
	private Stack<Timestamp> heartbeats; 
	private LifeProof lp; 
	public MediatorPortImpl(MediatorEndpointManager endpointManager) {
		File certificateFile = new File("A15_Mediator.cer");
		heartbeats = new Stack<Timestamp>();
		KeystoreSetup();
			try {
				this.cert = CertUtil.getX509CertificateFromFile(certificateFile);
				this.publicKey = (PublicKey)cert.getPublicKey();
			} catch (FileNotFoundException | CertificateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println("Certificate is setup, public key is: "+ publicKey.toString());
			this.cryptkeeper = new CryptoUtil();
		this.endpointManager = endpointManager;
		
		
		/*crypto tests*/
		String data = "ABC123TEST";
		System.out.println("Encoding " + data);
		try {
			String cipheredData = cryptkeeper.asymCipherString(data.getBytes(), publicKey);
			System.out.println("Encrypted data is:"+ cipheredData + "\nDecrypted data is:" +cryptkeeper.asymDecipherString(cipheredData, privateKey,true));
		} catch (InvalidKeyException | NoSuchPaddingException | NoSuchAlgorithmException | IllegalBlockSizeException
				| BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
	public MediatorEndpointManager getMediatorEndpointManager(){return this.endpointManager;}
	public void setPrimary(boolean val){
		
		this.isPrimary =val; 

	}
	
	public boolean getPrimary(){return this.isPrimary;}
	public void LifeProofBoot() throws MediatorClientException{
		this.lp = new LifeProof(this);
		lp.run();
	}
	public void killLifeProof(){
		lp.kill();
	}
	// Main operations -------------------------------------------------------



	@Override
	@Oneway
	public void updateShoppingHistory(List<ShoppingResultView> shoppingHistory) {
		this.history = (ArrayList<ShoppingResultView>) shoppingHistory;
		
	}
	

	@Override
	@Oneway
	public void updateCart(List<CartView> carts) {
			this.carts =(ArrayList<CartView>)carts;
	}
	
	public void KeystoreSetup(){
			
			try {
				this.keys=CertUtil.readKeystoreFromFile("A15_Mediator.jks", keystorePassword);
			} catch (FileNotFoundException | KeyStoreException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 try {
					this.privateKey = (PrivateKey)keys.getKey("a15_mediator", keystorePassword);
				} catch (UnrecoverableKeyException | KeyStoreException | NoSuchAlgorithmException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    }
	
	
	
	public List<ItemView> getItems(String productId) throws InvalidItemId_Exception {
		
		if (productId == null)
			throwInvalidItemId("Product identifier cannot be null!");
		
		System.out.println("Looking for items with " + productId + " productId");	

		List<ItemView> result = new ArrayList<ItemView>();
		ItemView currentItem=null;
		uddiRefreshSuppliers();
		for(SupplierClient i : suppliers.keySet()){
			try{
				currentItem=CreateItemView(i.getProduct(productId), suppliers.get(i));
				if(currentItem != null){
					result.add(currentItem);
				}
			}catch(BadProductId_Exception e){
				throwInvalidItemId("Bad item id");
			}
		}
		result.sort(new ItemViewComparatorPrice());
		return result;
	}
	
	
	public List<ItemView> searchItems(String productId) throws InvalidText_Exception {
		

	
		System.out.println("Looking for items with " + productId+" in their description");	
		List<ItemView> result = new ArrayList<ItemView>();
		List<ProductView> thing = new ArrayList<ProductView>();
		ItemView currentItem=null;
		uddiRefreshSuppliers();
		for(SupplierClient i : suppliers.keySet()){
			try{
				thing=i.searchProducts(productId);
				for(ProductView p : thing){
					currentItem=CreateItemView(p,suppliers.get(i));		
				if(currentItem != null){
					result.add(currentItem);
					}
				}
	
			}catch(BadText_Exception e){
				throwInvalidText(productId +" isn't a well formed search query.");
			}
		
		}
		
		result.sort(new ItemViewComparatorDesc());
		
		for (ItemView item : result)
			System.out.println("Item Description:" + item.getDesc() + "\n" + "Price:" + item.getPrice());
		return result;
	}
	
	public String getCartPurchaseIdentifier(){
		this.i++;
		return (new Integer(i)).toString();
	}
	
	
	
	@Override
	public void addToCart(String cartId, ItemIdView itemId,int itemQty) throws InvalidCartId_Exception, InvalidItemId_Exception, InvalidQuantity_Exception, NotEnoughItems_Exception {
		
		if (noproperText(cartId)) {
			throwInvalidCartId(cartId +" isn't a well formed search query and cannot be null");
		}
		
		if (itemId == null)
			throwInvalidItemId(itemId +" isn't a well formed search query and cannot be null");
		

		if (noproperText(itemId.getSupplierId())) {
			throwInvalidItemId(itemId +" isn't a well formed search query and cannot be null");
		}
		
		if(itemQty <= 0){
			throwInvalidQuantity("Quantity must be a positive number!");
		}
		
		boolean cartExists = false;
		
		SupplierPortType supplier = null;
		uddiRefreshSuppliers();
		for(SupplierClient p : suppliers.keySet()){
			if(suppliers.get(p).equals(itemId.getSupplierId())){
				supplier = p;
			}
		}
		if(supplier==null){
			System.out.println("No such supplier " + itemId.getSupplierId());
			return;
		}
		

		try{
			ProductView product = supplier.getProduct(itemId.getProductId());
			if (product == null)
				throwInvalidItemId(itemId +" isn't a well formed search query and cannot be null");
			ItemView purchaseTarget = CreateItemView(product, itemId.getSupplierId());
			for(CartView cart : carts){
				if(cart.getCartId().equals(cartId)){
					cartExists = true;
					ShopItem(cart, product, purchaseTarget, itemQty);
				}
			}
			if(!cartExists){
				CartView newCart = CreateCartView(cartId);
				carts.add(newCart);
				ShopItem(newCart, product, purchaseTarget, itemQty);
			}
		}catch(BadProductId_Exception e){
			throwInvalidItemId(itemId +" isn't a well formed search query and cannot be null");
		}
	}
	
	
	public ShoppingResultView buyCart(String cartID, String cipheredCreditCardNumber) throws EmptyCart_Exception, InvalidCartId_Exception, InvalidCreditCard_Exception {
		
		if (noproperText(cartID)) {
			throwInvalidCartId(cartID +" isn't a well formed search query and cannot be null");
		}
		
		if(getCart(cartID) == null)
			throwInvalidCartId("Cart doesn't exist");
		
		try {
			String creditCardNumber = cryptkeeper.asymDecipherString(cipheredCreditCardNumber, privateKey,true);
		
		if (noproperText(creditCardNumber)) {
			throwInvalidCreditCard(creditCardNumber +" isn't a well formed search query and cannot be null");
		}
		
		if (creditCardNumber.length() != 16) {
			throwInvalidCreditCard(creditCardNumber +" isn't a well formed search query and cannot be null");
		}
		
		
		ShoppingResultView result = null;
		List<CartItemView> droppedItems = new ArrayList<CartItemView>();
		List<CartItemView> purchasedItems = new ArrayList<CartItemView>();
		int price = 0;
		try{
			if (checkCard(creditCardNumber)) {
				uddiRefreshSuppliers();
				System.out.println(getCart(cartID));
				if(getCart(cartID).getItems().isEmpty()){
					throwEmptyCart("No items in the cart");
				}
				for(CartItemView i : getCart(cartID).getItems()){
					try{
						getPortFromName(i.getItem().getItemId().getSupplierId()).buyProduct(i.getItem().getItemId().getProductId(), i.getQuantity());
						price += (i.getQuantity() * i.getItem().getPrice());
						purchasedItems.add(i);
					}catch(Exception e){
						droppedItems.add(i);
						
					}
				};
				
			}
			
		}
		catch(CreditCardClientException e){
			throwInvalidCreditCard("Bad credit card");
		}
		catch(UDDINamingException e){
			throwInvalidCreditCard("Bad credit card");
		}
		

		if(droppedItems.isEmpty()){
			result = CreateShoppingResultView(Result.COMPLETE,getCartPurchaseIdentifier(), purchasedItems,droppedItems,price);
		}else if (purchasedItems.isEmpty()){
			result = CreateShoppingResultView(Result.EMPTY,getCartPurchaseIdentifier(), purchasedItems,droppedItems,price);
		}else{
			result = CreateShoppingResultView(Result.PARTIAL,getCartPurchaseIdentifier(), purchasedItems,droppedItems,price);
		}
		return result;
		}catch(InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException | IllegalBlockSizeException
				| BadPaddingException e1){
			e1.printStackTrace();
			return null;
		}
		
	}
	
	public boolean checkCard(String creditCardNumber) throws CreditCardClientException, UDDINamingException {
		 String uddiURL = endpointManager.getuddiURL();
		 UDDINaming uddiNaming = endpointManager.getUddiNaming();
		 try {
			 CreditCardClient CC = new CreditCardClient(uddiNaming.lookup(uddiURL));
			 return CC.validateNumber(creditCardNumber);
		 }
		 catch (UDDINamingException e) {return false;}
	}

	public List<CartView> listCarts(){ 
		ArrayList<CartView> result = new ArrayList<CartView>();
		for(CartView c : carts){
			result.add(c);
		}
		Collections.reverse(result);
		return result;
	}
	
	public List<ShoppingResultView> shopHistory(){ return history;}
	
	public void uddiRefreshSuppliers() {
		UDDINaming naming = null;
		//SupplierPortType port = null;
		SupplierClient succ= null;
        try {
            naming = new UDDINaming(this.endpointManager.getuddiURL());
            records = naming.listRecords("A15_Supplier%" );
          //  ports = new HashMap<SupplierPortType,String>();
            suppliers = new HashMap<SupplierClient,String>();
            for(UDDIRecord i : records ){
            	succ = new SupplierClient(i.getUrl());
            	this.suppliers.put(succ, i.getOrgName());
            	
            	/*
            	port = createStub(i.getUrl());
            	 this.ports.put(port, i.getOrgName());*/
            }
        } catch (Exception e) {
            e.printStackTrace();
        }		
	}
	@Deprecated
	public void uddiRefreshSuppliers(boolean a) {
		UDDINaming naming = null;
		SupplierPortType port = null;
        try {
            naming = new UDDINaming(this.endpointManager.getuddiURL());
            records = naming.listRecords("A15_Supplier%" );
            ports = new HashMap<SupplierPortType,String>();
            for(UDDIRecord i : records ){
            	 port = createStub(i.getUrl());
            	 this.ports.put(port, i.getOrgName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }		
	}
	
	
  /*  private void createCC() {

        CreditCardImplService service = new CreditCardImplService();
        CreditCard port = service.getCreditCardImplPort();

        if (wsURL != null) {
                System.out.println("Setting endpoint address ...");
            BindingProvider bindingProvider = (BindingProvider) port;
            Map<String, Object> requestContext = bindingProvider
                    .getRequestContext();
            requestContext.put(ENDPOINT_ADDRESS_PROPERTY, wsURL);
        }
    }*/

	private SupplierPortType createStub(String wsURL) {
		//System.out.println("Creating stub ...");
		SupplierService service = new SupplierService();
		SupplierPortType port = service.getSupplierPort();

		if (wsURL != null) {
			
				//System.out.println("Setting endpoint address ...");
			BindingProvider bindingProvider = (BindingProvider) port;
			Map<String, Object> requestContext = bindingProvider.getRequestContext();
			requestContext.put(ENDPOINT_ADDRESS_PROPERTY, wsURL);
		}
		return port;
	}
	
	
	
	// Auxiliary operations --------------------------------------------------	
	
	@Override
	public void goPrimary() {
		//Needs further fixing
		this.setPrimary(true);
		
	}
	
	@Override
	public void imAlive() {
		if(!this.isPrimary){
			
			System.out.println("Bla\n");
			Timestamp time = new Timestamp(System.currentTimeMillis());
			this.heartbeats.push(time);
		}
		/*
		
		if(!this.isPrimary){
			heartbeats.push(new Timestamp(System.currentTimeMillis()));
					}
		*/
	}
	
	public boolean noproperText(String text){
		//Checks if the string has whitespace then matches it against alphanumeric REGEX 
		if (text==null ){return true;}
		return (text.matches(" ") || text.matches("") || text.matches("\n") || text.matches("\t")/*&& text.matches("^[a-zA-Z0-9]*$")*/);
	}
	
	public String ping(String message){
		String result = "";
		//maybe lock
		//System.out.println("Test \n\n\n\n\n\n\n");
		uddiRefreshSuppliers();		
		for(SupplierClient i : suppliers.keySet()){
	
			result+=i.ping("From" + suppliers.get(i));
			System.out.println("Pinged " + suppliers.get(i) );
		}
		return result;		
	}
	
	public void clear(){
		uddiRefreshSuppliers();
		System.out.println("Clear suppliers!!");
		for(SupplierClient i : suppliers.keySet()){
			i.clear();
		}
		carts.clear();
	}
	
	
	// View helpers -----------------------------------------------------
	public boolean EqualItems(ItemView i1,ItemView i2){
		return i1.getDesc()==i2.getDesc() && i1.getPrice() == i2.getPrice() && EqualItemIds(i1.getItemId(),i2.getItemId());
	}
	public boolean EqualItemIds(ItemIdView i1, ItemIdView i2){
		return i1.getProductId() == i2.getProductId() && i1.getSupplierId() == i2.getSupplierId();
	}
	public CartView CreateCartView(String cartName){
		CartView newCart = new CartView();
		newCart.setCartId(cartName);
		return newCart;
		
	}
	public CartItemView CreateCartItemView(ItemView item){
		if(item==null){return null;}
		CartItemView result = new CartItemView();
		result.quantity = 0;
		result.item = item;
		return result;
	}
	public ItemView CreateItemView(ProductView product,String supplierName ){
		if(product==null){return null;}
		ItemView result = new ItemView();
		result.setDesc(product.getDesc());
		result.setPrice(product.getPrice());
		result.setItemId(CreateItemIdView(product,supplierName));
		return result ;
	}
	public ItemIdView CreateItemIdView(ProductView product,String supplierName){
		if(product==null){return null;}

		ItemIdView result = new ItemIdView();
		result.setProductId(product.getId());
		result.setSupplierId(supplierName);
		return result;
	}
	
	public ShoppingResultView CreateShoppingResultView(Result result,String id, List<CartItemView> PurchasedItems, List<CartItemView> DroppedItems, int price ){
		
		ShoppingResultView res = new ShoppingResultView();
		res.purchasedItems = new ArrayList<CartItemView>();
		res.droppedItems = new ArrayList<CartItemView>();
		res.setResult(result);
		res.setId(id);
		res.setTotalPrice(price);
		res.purchasedItems.addAll(PurchasedItems);
		res.droppedItems.addAll(DroppedItems);
		return res;
	}
	public CartView getCart(String cartId){
		for(CartView i : carts){
			if(i.getCartId().equals(cartId) ){
				return i;	
			}
		}
		return null;
	}
	public SupplierPortType getPortFromName(String supplierId){
		for(SupplierPortType i : ports.keySet()){
			if(ports.get(i).equals(supplierId) ){
				return i;
			}
		}
		return null;
	}
	
	public void ShopItem(CartView cart, ProductView product, ItemView purchaseTarget, int itemQty) throws NotEnoughItems_Exception, InvalidItemId_Exception {
		boolean itemExists = false;
		for(CartItemView item : cart.getItems()) {
			//since we cant override the equals method on the sources we have to pull this kind of stunt
			if(item.getItem().getDesc().equals(purchaseTarget.getDesc())){
				itemExists = true;
				if (product.getQuantity() - itemQty < 0 || product.getQuantity() == item.getQuantity())
					throwNotEnoughItems("Not enough quantity in stock");
				item.setQuantity(item.getQuantity() + itemQty);
			}
		}
		if(!itemExists){
			CartItemView newItem = CreateCartItemView(purchaseTarget);
			if (product.getQuantity() - itemQty < 0)
				throwNotEnoughItems("Not enough quantity in stock");
			newItem.setQuantity(newItem.getQuantity() + itemQty);
			cart.getItems().add(newItem);
		}
	}
    // TODO

    
	// Exception helpers -----------------------------------------------------

	/** Helper method to throw new InvalidItemId exception */
	private void throwInvalidItemId(final String message) throws InvalidItemId_Exception {
		InvalidItemId faultInfo = new InvalidItemId();
		faultInfo.message = message;
		throw new InvalidItemId_Exception(message, faultInfo);
	}
	
	/** Helper method to throw new InvalidText exception */
	private void throwInvalidText(final String message) throws InvalidText_Exception {
		InvalidText faultInfo = new InvalidText();
		faultInfo.message = message;
		throw new InvalidText_Exception(message, faultInfo);
	}
	
	/** Helper method to throw new InvalidCartId exception */
	private void throwInvalidCartId(final String message) throws InvalidCartId_Exception {
		InvalidCartId faultInfo = new InvalidCartId();
		faultInfo.message = message;
		throw new InvalidCartId_Exception(message, faultInfo);
	}
	
	/** Helper method to throw new InsufficientQuantity exception */
	private void throwInvalidQuantity(final String message) throws InvalidQuantity_Exception {
		InvalidQuantity faultInfo = new InvalidQuantity();
		faultInfo.message = message;
		throw new InvalidQuantity_Exception(message, faultInfo);
	}
	
	/** Helper method to throw new NotEnoughItems exception */
	private void throwNotEnoughItems(final String message) throws NotEnoughItems_Exception {
		NotEnoughItems faultInfo = new NotEnoughItems();
		faultInfo.message = message;
		throw new NotEnoughItems_Exception(message, faultInfo);
	}
	
	/** Helper method to throw new EmptyCart exception */
	private void throwEmptyCart(final String message) throws EmptyCart_Exception {
		EmptyCart faultInfo = new EmptyCart();
		faultInfo.message = message;
		throw new EmptyCart_Exception(message, faultInfo);
	}
	private void throwInvalidCreditCard(final String message) throws InvalidCreditCard_Exception {
		InvalidCreditCard faultInfo = new InvalidCreditCard();
		faultInfo.message = message;
		throw new InvalidCreditCard_Exception(message, faultInfo);
	}



	



}
