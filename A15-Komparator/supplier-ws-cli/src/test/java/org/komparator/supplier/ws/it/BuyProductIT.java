package org.komparator.supplier.ws.it;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.komparator.supplier.ws.*;

/**
 * Test suite
 */
public class BuyProductIT extends BaseIT {

	// static members

	// one-time initialization and clean-up
	@BeforeClass
	public static void oneTimeSetUp() throws BadProductId_Exception, BadProduct_Exception  {

		{
			ProductView product = new ProductView();
			product.setId("X1");
			product.setDesc("Basketball");
			product.setPrice(10);
			product.setQuantity(10);
			client.createProduct(product);
		}
		{
			ProductView product = new ProductView();
			product.setId("Y2");
			product.setDesc("Baseball");
			product.setPrice(20);
			product.setQuantity(20);
			client.createProduct(product);
		}
	}

	@AfterClass
	public static void oneTimeTearDown() {
		// clear remote service state after all tests
		client.clear();
	}

	// members

	// initialization and clean-up for each test
	@Before
	public void setUp() throws BadProductId_Exception, BadProduct_Exception  {
	}

	@After
	public void tearDown() {
	}

	// bad input tests

	@Test(expected = BadProductId_Exception.class)
	public void buyProductNullTest() throws BadProductId_Exception, InsufficientQuantity_Exception, BadQuantity_Exception {
		client.buyProduct(null, 1);
	}

	@Test(expected = BadQuantity_Exception.class)
	public void buyProductNoQuantityTest() throws BadProductId_Exception, InsufficientQuantity_Exception, BadQuantity_Exception {
		client.buyProduct("X1", 0);
	}

	@Test(expected = BadText_Exception.class)
	public void buyProductWhitespaceTest() throws BadProductId_Exception, InsufficientQuantity_Exception, BadQuantity_Exception, BadText_Exception {
		client.buyProduct(" ", 1);
	}

	@Test(expected = BadText_Exception.class)
	public void buyProductTabTest() throws BadProductId_Exception, InsufficientQuantity_Exception, BadQuantity_Exception, BadText_Exception {
		client.buyProduct("\t", 1);
	}

	@Test(expected = BadText_Exception.class)
	public void buyProductNewlineTest() throws BadProductId_Exception, InsufficientQuantity_Exception, BadQuantity_Exception, BadText_Exception {
		client.buyProduct("\n", 1);
	}
	

	// main tests
	@Test
	public void buyProductOneTest() throws Exception {
		assertEquals(10, client.getProduct("X1").getQuantity());

		String result = client.buyProduct("X1", 1);
		assertNotNull(result);

		assertEquals(9, client.getProduct("X1").getQuantity());
	}
	
	@Test
	public void buyProductAllTest() throws Exception {
		assertEquals(20, client.getProduct("Y2").getQuantity());

		String result = client.buyProduct("Y2", 20);
		assertNotNull(result);

		assertEquals(0, client.getProduct("Y2").getQuantity());
	}
	
	@Test
	public void buyProductNotExistsTest() throws BadText_Exception, BadProductId_Exception, InsufficientQuantity_Exception, BadQuantity_Exception{
		// when product does not exist, null should be returned
		String product = client.buyProduct("A0", 1);
		assertNull(product);
	}
	
	@Test
	public void buyProductLowercaseNotExistsTest() throws BadText_Exception, BadProductId_Exception, InsufficientQuantity_Exception, BadQuantity_Exception {
		// product identifiers are case sensitive,
		// so "x1" is not the same as "X1"
		String product = client.buyProduct("x1", 1);
		assertNull(product);
	}
	
	@Test
	public void buyProductNotEnoughQuantityTest() throws BadText_Exception, BadProductId_Exception, InsufficientQuantity_Exception, BadQuantity_Exception{
		// when product does not exist, null should be returned
		String product = client.buyProduct("X1", 20);
		assertNull(product);
	}
	
	@Test
	public void buyProductNegativeQuantityTest() throws BadText_Exception, BadProductId_Exception, InsufficientQuantity_Exception, BadQuantity_Exception{
		// when product does not exist, null should be returned
		String product = client.buyProduct("X1", -1);
		assertNull(product);
	}
	
}
