package org.komparator.mediator.ws.it;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.komparator.mediator.ws.*;
import org.komparator.supplier.ws.BadProductId_Exception;
import org.komparator.supplier.ws.BadProduct_Exception;
import org.komparator.supplier.ws.ProductView;

public class getItemsIT extends BaseIT {
	
	@BeforeClass
	public static void oneTimeSetUp() throws BadProductId_Exception, BadProduct_Exception {
		// clear remote service state before all tests
		mediatorClient.clear();
		sup1.clear();
		sup2.clear();

		// fill-in test products
		// (since getProduct is read-only the initialization below
		// can be done once for all tests in this suite)
		{
			ProductView product = new ProductView();
			product.setId("X1");
			product.setDesc("Basketball");
			product.setPrice(20);
			product.setQuantity(10);
			sup2.createProduct(product);
		}
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
			product.setDesc("Baseball");
			product.setPrice(20);
			product.setQuantity(20);
			sup2.createProduct(product);
		}
	}

	@AfterClass
	public static void oneTimeTearDown() {
		// clear remote service state after all tests
		sup1.clear();
		mediatorClient.clear();
	}
	
	// bad input tests

		@Test(expected = InvalidItemId_Exception.class)
		public void getItemNullTest() throws InvalidText_Exception, InvalidItemId_Exception {
			mediatorClient.getItems(null);
		}

		@Test(expected = InvalidText_Exception.class)
		public void getItemEmptyTest() throws InvalidText_Exception, InvalidItemId_Exception {
			mediatorClient.getItems("");
		}

		@Test(expected = InvalidText_Exception.class)
		public void getItemWhitespaceTest() throws InvalidText_Exception, InvalidItemId_Exception {
			mediatorClient.getItems(" ");
		}

		@Test(expected = InvalidText_Exception.class)
		public void getItemTabTest() throws InvalidText_Exception, InvalidItemId_Exception {
			mediatorClient.getItems("\t");
		}

		@Test(expected = InvalidText_Exception.class)
		public void getItemNewlineTest() throws InvalidText_Exception, InvalidItemId_Exception {
			mediatorClient.getItems("\n");
		}

		// main tests
		
		@Test
		public void success() throws InvalidText_Exception, InvalidItemId_Exception {
			List<ItemView> items = mediatorClient.getItems("X1");
			for (ItemView item: items) {
				assertEquals("X1", item.getItemId().getProductId());
				assertEquals("Basketball", item.getDesc());
			}
		}
		
		@Test
		public void success2() throws InvalidText_Exception, InvalidItemId_Exception {
			List<ItemView> items = mediatorClient.getItems("Y2");
			for (ItemView item: items) {
				assertEquals(20, item.getPrice());
				assertEquals("Y2", item.getItemId().getProductId());
				assertEquals("A15_Supplier2", item.getItemId().getSupplierId());
				assertEquals("Baseball", item.getDesc());
			}
		}
		
		@Test
		public void listOrganizedTest() throws InvalidText_Exception, InvalidItemId_Exception {
			List<ItemView> items = mediatorClient.getItems("Y2");
			assertEquals(10, items.get(0).getPrice());
			assertEquals(20, items.get(1).getPrice());
		}

		@Test
		public void getItemNotExistsTest() throws InvalidText_Exception, InvalidItemId_Exception {
			List<ItemView> items = mediatorClient.getItems("A0");
			assertNull(items);
		}

		@Test
		public void getItemLowerCaseNotExistsTest() throws InvalidText_Exception, InvalidItemId_Exception {
			List<ItemView> items = mediatorClient.getItems("x1");
			assertNull(items);
		}
	
}
