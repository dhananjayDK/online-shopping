package com.dksofts.shoppingbackend.test;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.assertEquals;

import com.dksofts.shoppingbackend.dao.CategotyDAO;
import com.dksofts.shoppingbackend.daoimpl.CategoryDAOImpl;
import com.dksofts.shoppingbackend.dto.Category;

public class CategoryTestCase {
  
  private static AnnotationConfigApplicationContext applicationContext;
  
  private static CategotyDAO categotyDAO;
  
  private Category category;
  
  @BeforeClass
  public static void init(){
	  applicationContext = new AnnotationConfigApplicationContext();
	  applicationContext.scan("com.dksofts.shoppingbackend");
	  applicationContext.refresh();
	  categotyDAO = applicationContext.getBean("categoryDAO",CategotyDAO.class);
	  
  }
  
  /*@Test
  public void testAddCategory(){
	  category = new Category();
  	category.setName("Laptop");
  	category.setDescription("This is description for Laptop Category");
  	category.setImageURL("CAT_3.jpg");
    
  	assertEquals("SuccessFully added category inside table", true,categotyDAO.addCategory(category));
  }*/
  
  
/*  @Test
  public void testGetCategory(){
	  category = categotyDAO.get(3);
	  assertEquals("SuccessFully get category from table", "Laptop",category.getName());
  }
  */

  /*@Test
  public void testUpdateRecord(){
	  category = categotyDAO.get(3);
	  category.setName("LapTops");
	  assertEquals("SuccessFully updated category inside table", true,categotyDAO.updateCategory(category));
  }*/
  
/*  @Test
  public void testDeleteRecord(){
	  category = categotyDAO.get(3);
	  assertEquals("SuccessFully Delete category from table", true,categotyDAO.deleteCategory(category));
  }*/
  
  @Test
  public void testDeleteRecord(){
	 
	  assertEquals("SuccessFully Delete category from table", 3,categotyDAO.list().size());
  }
}
