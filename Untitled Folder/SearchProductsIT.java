package org.komparator.supplier.ws.it;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.komparator.supplier.ws.*;

/**
 * Test suite
 */
public class SearchProductsIT extends BaseIT {

	// static members

	// one-time initialization and clean-up	
	@BeforeClass
	public static void oneTimeSetUp() throws BadProductId_Exception, BadProduct_Exception {
		// clear remote service state before all tests
		client.clear();
		// fill-in test product
		// (since getProduct is read-only the initialization below
		// can be done once for all tests in this suite)
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

	// bad input tests

	@Test(expected = BadProductId_Exception.class)
	public void searchProductNullTest() throws BadProductId_Exception, BadText_Exception {
		client.searchProducts(null);
	}

	@Test(expected = BadText_Exception.class)
	public void searchProductEmptyTest() throws BadProductId_Exception, BadText_Exception {
		client.searchProducts("");
	}

	@Test(expected = BadText_Exception.class)
	public void searchProductWhitespaceTest() throws BadProductId_Exception, BadText_Exception {
		client.searchProducts(" ");
	}

	@Test(expected = BadText_Exception.class)
	public void searchProductTabTest() throws BadProductId_Exception, BadText_Exception {
		client.searchProducts("\t");
	}

	@Test(expected = BadText_Exception.class)
	public void searchProductNewlineTest() throws BadProductId_Exception, BadText_Exception {
		client.searchProducts("\n");
	}
	
	// main tests
	
	@Test
	public void searchProductExistsTest() throws BadProductId_Exception, BadText_Exception{
		List<ProductView> product = client.searchProducts("Basketball");
		for(ProductView p : product){
			assertEquals("X1", p.getId());
			assertEquals(10, p.getPrice());
			assertEquals(10, p.getQuantity());
			assertEquals("Basketball", p.getDesc());
		}
	}
	
	@Test
	public void searchAnotherProductExistsTest() throws BadProductId_Exception, BadText_Exception{
		List<ProductView> product = client.searchProducts("Basketball");
		for(ProductView p : product){
			assertEquals("Y2", p.getId());
			assertEquals(20, p.getPrice());
			assertEquals(20, p.getQuantity());
			assertEquals("Baseball", p.getDesc());
		}
	}

	@Test
	public void searchProductNotExistsTest() throws BadProductId_Exception, BadText_Exception {
		// when product does not exist, null should be returned
		List<ProductView> products = client.searchProducts("Tennis");
		assertEquals(0, products.size());
	}
	
	@Test
	public void searchProductLowercaseNotExistsTest() throws BadProductId_Exception, BadText_Exception {
		// product identifiers are case sensitive,
		// so "x1" is not the same as "X1"
		List<ProductView> products = client.searchProducts("x1");
		assertEquals(0, products.size());
	}

}
