package com.dksofts.onlineshopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dksofts.shoppingbackend.dao.ProductDAO;
import com.dksofts.shoppingbackend.dto.Product;

@RestController
@RequestMapping("/json/data")
public class JsonDataController {

	@Autowired
	private ProductDAO productDAO;
	
	@RequestMapping("/all/products")
	public List<Product> getAllProducts(){
		return productDAO.listActiveProducts(); 
	}
	
	@RequestMapping("/category/{id}/products")
	public List<Product> getProductByCategory(@PathVariable("id") int id){
		return productDAO.listActiveProductsByCategory(id); 
	}
}
