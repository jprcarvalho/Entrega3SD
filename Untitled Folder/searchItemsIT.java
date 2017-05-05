package org.komparator.mediator.ws.it;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.komparator.mediator.ws.*;
import org.komparator.supplier.ws.BadProductId_Exception;
import org.komparator.supplier.ws.BadProduct_Exception;
import org.komparator.supplier.ws.ProductView;

public class searchItemsIT extends BaseIT {

	@BeforeClass
	public static void oneTimeSetUp() throws BadProductId_Exception, BadProduct_Exception {
		// clear remote service state before all tests
		mediatorClient.clear();
		sup1.clear();

		// fill-in test products
		// (since getProduct is read-only the initialization below
		// can be done once for all tests in this suite)
		{
			ProductView product = new ProductView();
			product.setId("X1");
			product.setDesc("Basketball");
			product.setPrice(10);
			product.setQuantity(10);
			sup1.createProduct(product);
		}
		{
			ProductView product = new ProductView();
			product.setId("Y2");
			product.setDesc("BasketBall");
			product.setPrice(20);
			product.setQuantity(20);
			sup2.createProduct(product);
		}
		{
			ProductView product = new ProductView();
			product.setId("X1");
			product.setDesc("Football");
			product.setPrice(0);
			product.setQuantity(0);
			sup1.createProduct(product);
		}
	}

	@AfterClass
	public static void oneTimeTearDown() {
		// clear remote service state after all tests
		sup1.clear();
		mediatorClient.clear();
	}
		
		@Test(expected = InvalidText_Exception.class)
		public void searchItemsNullTest() throws InvalidText_Exception, InvalidItemId_Exception {
			mediatorClient.searchItems(null);
		}

		@Test(expected = InvalidText_Exception.class)
		public void searchItemsEmptyTest() throws InvalidText_Exception, InvalidItemId_Exception {
			mediatorClient.searchItems("");
		}

		@Test(expected = InvalidText_Exception.class)
		public void searchItemsWhitespaceTest() throws InvalidText_Exception, InvalidItemId_Exception {
			mediatorClient.searchItems(" ");
		}

		@Test(expected = InvalidText_Exception.class)
		public void searchItemsTabTest() throws InvalidText_Exception, InvalidItemId_Exception {
			mediatorClient.searchItems("\t");
		}

		@Test(expected = InvalidText_Exception.class)
		public void searchItemsNewlineTest() throws InvalidText_Exception, InvalidItemId_Exception {
			mediatorClient.searchItems("\n");
		}
		
		// main tests
		
		@Test
		public void success() throws InvalidText_Exception, InvalidItemId_Exception {
			List<ItemView> item = mediatorClient.searchItems("Football");
			for(ItemView i : item) {
				assertEquals(10, i.getPrice());
				assertEquals("X1", i.getItemId().getProductId());
				assertEquals("A15_Supplier1", i.getItemId().getSupplierId());
				assertEquals("Football", i.getDesc());
			}
		}
		
		@Test
		public void listOrganizedTest() throws InvalidText_Exception, InvalidItemId_Exception {
			List<ItemView> items = mediatorClient.searchItems("Basketball");
			assertEquals("X1", items.get(0).getItemId().getProductId());
			assertEquals("Y2", items.get(1).getItemId().getProductId());
			assertEquals(10, items.get(0).getPrice());
			assertEquals(20, items.get(1).getPrice());
		}

		@Test
		public void searchItemsNotExistsTest() throws InvalidText_Exception, InvalidItemId_Exception {
			// when product does not exist, empty list should be returned
			List<ItemView> items = mediatorClient.searchItems("Tennis");
			assertEquals(0, items.size());
		}
		
		@Test
		public void searchItemLowerCaseNotExistsTest() throws InvalidText_Exception, InvalidItemId_Exception {
			// when product has a different letter case, empty list should be returned
			List<ItemView> items = mediatorClient.searchItems("basketball");
			assertEquals(0, items.size());
		}
	
}
