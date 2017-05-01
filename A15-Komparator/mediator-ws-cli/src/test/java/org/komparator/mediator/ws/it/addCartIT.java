package org.komparator.mediator.ws.it;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.komparator.mediator.ws.*;
import org.komparator.supplier.ws.BadProductId_Exception;
import org.komparator.supplier.ws.BadProduct_Exception;
import org.komparator.supplier.ws.ProductView;

public class addCartIT extends BaseIT {

	protected static CartView cart1 = new CartView();
	
	@BeforeClass
	public static void oneTimeSetUp()  throws BadProductId_Exception, BadProduct_Exception {
		// clear remote service state before all tests
		mediatorClient.clear();

		// fill-in test items
		{
			ProductView product = new ProductView();
			product.setId("X1");
			product.setDesc("Basketball");
			product.setPrice(10);
			product.setQuantity(10);
			sup1.createProduct(product);
			
			ItemIdView itemid = new ItemIdView();
			itemid.setProductId("X1");
			itemid.setSupplierId("A15_Supplier1");
			ItemView item = new ItemView();
			item.setDesc("BasketBall");
			item.setItemId(itemid);
			item.setPrice(10);
			CartItemView cartItem = new CartItemView();
			cartItem.setItem(item);
			cartItem.setQuantity(10);
			cart1 = new CartView();
			cart1.setCartId("Cart1");
			cart1.getItems().add(cartItem);
		}
	}
	
	
	@AfterClass
	public static void oneTimeTearDown() {
		// clear remote service state after all tests
		mediatorClient.clear();
	}

	//Null Tests	
	
		@Test(expected = InvalidCartId_Exception.class)
		public void addToCartNullCartTest() throws InvalidText_Exception, InvalidItemId_Exception,
		InvalidCartId_Exception, InvalidQuantity_Exception, NotEnoughItems_Exception {
			ItemIdView itemid = new ItemIdView();
			itemid.setProductId("X1");
			itemid.setSupplierId("A15_Supplier1");
			mediatorClient.addToCart(null, itemid, 10);
		}

		@Test(expected = InvalidItemId_Exception.class)
		public void addToCartNullItemIdViewTest() throws InvalidText_Exception, InvalidItemId_Exception,
		InvalidCartId_Exception, InvalidQuantity_Exception, NotEnoughItems_Exception {
			mediatorClient.addToCart("Cart1", null, 10);
		}
	
	//End of Null Tests
		
	//Bad Input Tests
		
		@Test(expected = InvalidText_Exception.class)
		public void addToCartItemIdEmptyTest() throws InvalidText_Exception, InvalidItemId_Exception,
		InvalidCartId_Exception, InvalidQuantity_Exception, NotEnoughItems_Exception {
			ItemIdView itemid = new ItemIdView();
			itemid.setProductId("X1");
			itemid.setSupplierId("A15_Supplier1");
			mediatorClient.addToCart("", itemid, 10);
		}

		@Test(expected = InvalidText_Exception.class)
		public void addToCartItemIdWhitespaceTest() throws InvalidText_Exception, InvalidItemId_Exception,
		InvalidCartId_Exception, InvalidQuantity_Exception, NotEnoughItems_Exception {
			ItemIdView itemid = new ItemIdView();
			itemid.setProductId("X1");
			itemid.setSupplierId("A15_Supplier1");
			mediatorClient.addToCart(" ", itemid, 10);
		}

		@Test(expected = InvalidText_Exception.class)
		public void addToCartItemIdTabTest() throws InvalidText_Exception, InvalidItemId_Exception,
		InvalidCartId_Exception, InvalidQuantity_Exception, NotEnoughItems_Exception {
			ItemIdView itemid = new ItemIdView();
			itemid.setProductId("X1");
			itemid.setSupplierId("A15_Supplier1");
			mediatorClient.addToCart("\t", itemid, 10);
		}

		@Test(expected = InvalidText_Exception.class)
		public void addToCartItemIdNewlineTest() throws InvalidText_Exception, InvalidItemId_Exception,
		InvalidCartId_Exception, InvalidQuantity_Exception, NotEnoughItems_Exception {
			ItemIdView itemid = new ItemIdView();
			itemid.setProductId("X1");
			itemid.setSupplierId("A15_Supplier1");
			mediatorClient.addToCart("\n", itemid, 10);
		}
		
		@Test(expected = InvalidQuantity_Exception.class)
		public void addToCartInvalidQuantityTest() throws InvalidText_Exception, InvalidItemId_Exception,
		InvalidCartId_Exception, InvalidQuantity_Exception, NotEnoughItems_Exception {
			ItemIdView itemid = new ItemIdView();
			itemid.setProductId("X1");
			itemid.setSupplierId("A15_Supplier1");
			mediatorClient.addToCart("\n", itemid, -1);
		}

	//End of Bad Input Tests	
		
		// main tests

		@Test
		public void addToCartAddsNewItemTest() throws InvalidText_Exception, InvalidItemId_Exception,
		InvalidCartId_Exception, InvalidQuantity_Exception, NotEnoughItems_Exception {
			ItemIdView itemid = new ItemIdView();
			itemid.setProductId("X2");
			itemid.setSupplierId("A15_Supplier1");
			mediatorClient.addToCart("Cart1", itemid, 5);
			for (CartItemView cview: cart1.getItems()) {
				assertEquals("X2", cview.getItem().getItemId().getProductId());
				assertEquals("5", cview.getQuantity());
			}
		}
		
		@Test
		public void addToCartExistingItemTest() throws InvalidText_Exception, InvalidItemId_Exception,
		InvalidCartId_Exception, InvalidQuantity_Exception, NotEnoughItems_Exception {
			ItemIdView itemid = new ItemIdView();
			itemid.setProductId("X1");
			itemid.setSupplierId("A15_Supplier1");
			mediatorClient.addToCart("Cart1", itemid, 10);
			for (CartItemView cview: cart1.getItems()) {
				assertEquals(cview.getItem().getItemId().getProductId(), "X2");
				assertEquals(cview.getQuantity(), 20);
			}
		}
		
		public void addToCartDoesntExistCartTest() throws InvalidText_Exception, InvalidItemId_Exception,
		InvalidCartId_Exception, InvalidQuantity_Exception, NotEnoughItems_Exception {
			ItemIdView itemid = new ItemIdView();
			itemid.setProductId("X1");
			itemid.setSupplierId("A15_Supplier1");
			mediatorClient.addToCart("Cart2", itemid, 10);
		}
		
		@Test
		public void addToCartLowerCaseNotExistsTest() throws InvalidText_Exception, InvalidItemId_Exception,
		InvalidCartId_Exception, InvalidQuantity_Exception, NotEnoughItems_Exception {
			ItemIdView itemid = new ItemIdView();
			itemid.setProductId("X1");
			itemid.setSupplierId("A15_Supplier1");
			mediatorClient.addToCart("cart2", itemid, 10);
		}
		
}
