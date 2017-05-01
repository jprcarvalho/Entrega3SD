package org.komparator.mediator.ws;


import static javax.xml.ws.BindingProvider.ENDPOINT_ADDRESS_PROPERTY;

import java.security.Key;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

import javax.jws.HandlerChain;
import javax.jws.WebService;
import javax.xml.ws.BindingProvider;

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
	public class ItemViewComparator implements Comparator<ItemView> {
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
	//private Key publicKey;
	private int i=0;
	private ArrayList<ShoppingResultView> history = new ArrayList<ShoppingResultView>();
	private MediatorEndpointManager endpointManager;
	private Collection<UDDIRecord> records;
	private HashMap<SupplierPortType,String> ports;
	private ArrayList<CartView> carts = new ArrayList<CartView>();
	public MediatorPortImpl(MediatorEndpointManager endpointManager) {
		this.endpointManager = endpointManager;
	}

	// Main operations -------------------------------------------------------
	//Function prototypes
	
	
	public List<ItemView> getItems(String productId) throws InvalidItemId_Exception {
		
		if (productId == null)
			throwInvalidItemId("Product identifier cannot be null!");
		
		System.out.println("Looking for items with " + productId + " productId");	

		List<ItemView> result = new ArrayList<ItemView>();
		ItemView currentItem=null;
		uddiRefreshSuppliers();
		for(SupplierPortType i : ports.keySet()){
			try{
				currentItem=CreateItemView(i.getProduct(productId), ports.get(i));
				if(currentItem != null){
					result.add(currentItem);
				}
			}catch(BadProductId_Exception e){
				throwInvalidItemId("Bad item id");
			}
		}
		result.sort(new ItemViewComparator());
		return result;
	}

	
	public List<ItemView> searchItems(String productId) throws InvalidText_Exception {
		

	
		System.out.println("Looking for items with " + productId+" in their description");	
		List<ItemView> result = new ArrayList<ItemView>();
		List<ProductView> thing = new ArrayList<ProductView>();
		ItemView currentItem=null;
		uddiRefreshSuppliers();
		for(SupplierPortType i : ports.keySet()){
			try{
				thing=i.searchProducts(productId);
				for(ProductView p : thing){
					currentItem=CreateItemView(p,ports.get(i));		
				if(currentItem != null){
					result.add(currentItem);
					}
				}
	
			}catch(BadText_Exception e){
				throwInvalidText(productId +" isn't a well formed search query.");
			}
		
		}
		result.sort(new ItemViewComparator());
		return result;
	}
	
	public String getCartPurchaseIdentifier(){
		this.i++;
		return (new Integer(i)).toString();
	}
	@Override
	public void addToCart(String cartId, ItemIdView itemId,int itemQty) throws InvalidCartId_Exception, InvalidItemId_Exception, InvalidQuantity_Exception, NotEnoughItems_Exception {
		
		if(!properText(cartId) && cartId == null){
			throwInvalidCartId(cartId +" isn't a well formed search query and cannot be null");
		}
		
		
		if(itemQty <= 0){
			throwInvalidQuantity("Quantity must be a positive number!");
		}
		
		boolean cartExists = false;
		boolean itemExists = false;	
		
		SupplierPortType supplier = null;
		uddiRefreshSuppliers();
		for(SupplierPortType p : ports.keySet()){
			if(ports.get(p).equals(itemId.getSupplierId())){
				System.out.println("Found supplier: " + itemId.getSupplierId());
				supplier = p;
			}		
		}
		if(supplier==null){
			System.out.println("No such supplier " +itemId.getSupplierId());
			return;
		}
		try{
			ItemView purchaseTarget = CreateItemView(supplier.getProduct(itemId.getProductId()),itemId.getSupplierId());
			for(CartView cart : carts){
				if(cart.getCartId() == cartId ){
					cartExists = true;
					for(CartItemView item : cart.getItems()){
						//since we cant override the equals method on the sources we have to pull this kind of stunt
						if(EqualItems(item.getItem(),purchaseTarget) ){
							itemExists = true;
							item.setQuantity(item.getQuantity() + itemQty); 
						}
					}
					if(!itemExists){
	
						cart.getItems().add(CreateCartItemView(purchaseTarget, itemQty));
					}
				}
			}
			if(!cartExists){
				//TODO
				CartView newCart = CreateCartView(cartId);
				newCart.getItems().add(CreateCartItemView(purchaseTarget,itemQty));
				carts.add(newCart);
				//add item to new cart
			}
		}catch(BadProductId_Exception e){
			throwInvalidItemId(itemId +" isn't a well formed search query and cannot be null");
		}
	}
	
	
	public ShoppingResultView buyCart(String cartID, String creditCardNumber) throws EmptyCart_Exception,InvalidCreditCard_Exception{
		ShoppingResultView result= null;
		List<CartItemView> droppedItems = new ArrayList<CartItemView>();
		List<CartItemView> purchasedItems = new ArrayList<CartItemView>();
		int price = 0;
		try{
			if (checkCard(creditCardNumber)){
				uddiRefreshSuppliers();
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
			
		}catch(CreditCardClientException e){
			throwInvalidCreditCard("Bad credit card");
		}
		if(droppedItems.isEmpty()){
			CreateShoppingResultView(Result.COMPLETE,getCartPurchaseIdentifier(), purchasedItems,droppedItems,price);
		}else if (purchasedItems.isEmpty()){
			CreateShoppingResultView(Result.EMPTY,getCartPurchaseIdentifier(), purchasedItems,droppedItems,price);
		}else{
			CreateShoppingResultView(Result.PARTIAL,getCartPurchaseIdentifier(), purchasedItems,droppedItems,price);
		}
		return result;
		
	}
	public boolean checkCard(String creditCardNumber) throws CreditCardClientException{
		 String uddiURL = endpointManager.getuddiURL();
		 String wsName = endpointManager.getWsName();
		 CreditCardClient CC = new CreditCardClient(uddiURL,wsName);	
		 return CC.validateNumber(creditCardNumber);


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
		SupplierPortType port = null;
        try {
            naming = new UDDINaming(this.endpointManager.getuddiURL());
            records = naming.listRecords("A15_Supplier%" );
            ports = new HashMap<SupplierPortType,String>();
         //   System.out.println("Listing uddi records");
            for(UDDIRecord i : records ){
            	//System.out.println("Generating port from " + i);
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
	
	public boolean properText(String text){
		//Checks if the string has whitespace then matches it against alphanumeric REGEX 
		if (text==null ){return false;}
		return (!text.matches(" ") && !text.matches("") && !text.matches("\n") && !text.matches("\t")/*&& text.matches("^[a-zA-Z0-9]*$")*/);
	}
	
	public String ping(String message){
		String result = "";
		//maybe lock
		uddiRefreshSuppliers();		
		for(SupplierPortType i : ports.keySet()){
			result+=i.ping("From" + ports.get(i));
			System.out.println("Pinged " + ports.get(i) );
		}
		return result;		
	}
	public void clear(){
		uddiRefreshSuppliers();
		for(SupplierPortType i : ports.keySet()){
			i.clear();
		}
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
	public CartItemView CreateCartItemView(ItemView item, int quantity){
		if(item==null){return null;}
		CartItemView result = new CartItemView();
		result.quantity = quantity;
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
