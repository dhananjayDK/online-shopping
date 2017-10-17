package com.dksofts.shoppingbackend.test;

import javax.naming.Context;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.dksofts.shoppingbackend.dao.ProductDAO;
import com.dksofts.shoppingbackend.dto.Product;

public class ProductTestCase {

	private static AnnotationConfigApplicationContext context;

	private Product product;

	private static ProductDAO productDAO;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.dksofts.shoppingbackend");
		context.refresh();
		productDAO = context.getBean("productDAO", ProductDAO.class);
	}

	/*@Test
	public void testProductCrud() {
		// creaate Product
		product = new Product();

		product.setBrand("Oppo");
		product.setCategory_id(3);
		product.setSupplier_id(3);
		product.setDescription("Best For Selfie");
		product.setIs_active(true);
		product.setName("Oppo Selfie 342");
		product.setUnit_price(40000);

		assertEquals("Something went wrong while inserting Record", true,
				productDAO.add(product));

		// read update delete

		product = productDAO.get(2);
		product.setName("Samsung 8");
		assertEquals("Something went wrong while Updating Record", true,
				productDAO.update(product));

		assertEquals("Something went wrong while Updating Record", true,
				productDAO.delete(product));

		assertEquals("Something went wrong while getting List of Record", 6,
				productDAO.list().size());

	}*/
	
	@Test
	public void testListOfActiveProduct(){
		assertEquals("Something went wrong while getting List of Active Product", 6,
				productDAO.listActiveProducts().size());
		
		assertEquals("Something went wrong while getting List of Active Product by Category", 2,
				productDAO.listActiveProductsByCategory(1).size());
	}
	
	@Test
	public void testListLatestActiveProduct(){
		assertEquals("Something went wrong while getting List of Latest Active Product by Category", 4,
				productDAO.listActiveProductsByCategory(3).size());
	}
}
