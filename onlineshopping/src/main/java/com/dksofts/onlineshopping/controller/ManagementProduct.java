package com.dksofts.onlineshopping.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dksofts.onlineshopping.util.FileUploadUtitlty;
import com.dksofts.onlineshopping.validator.ProductValidator;
import com.dksofts.shoppingbackend.dao.CategotyDAO;
import com.dksofts.shoppingbackend.dao.ProductDAO;
import com.dksofts.shoppingbackend.dto.Category;
import com.dksofts.shoppingbackend.dto.Product;

@Controller  
@RequestMapping(value="/management/controller/handle")
public class ManagementProduct {
    
	@Autowired
	private CategotyDAO categoryDAO;
	
	@Autowired
	private ProductDAO productDAO;
	
	private static final Logger logger = LoggerFactory.getLogger(ManagementProduct.class);
	@RequestMapping(value="/products")
	public ModelAndView showManageProducts(@RequestParam(name="operation" ,required=false) String operation){
		System.out.println("\n\nHiiiiiiiiiii\n\n");
      ModelAndView mv = new ModelAndView("page");
      mv.addObject("userClickManageProducts", true);
      mv.addObject("title", "Manage Products");
    
      
      
      Product nProduct = new Product();
      nProduct.setSupplier_id(1);
      nProduct.setIs_active(true);
      mv.addObject("product", nProduct);
      if(operation != null){
    	  if(operation.equals("product")){
    		  
    		  mv.addObject("message", "Product Submitted Successfully");
    	  }
    	  else if(operation.equals("category")){
    		  mv.addObject("message", "Category Submitted Successfully");
    	  }
      }
      return mv;
	}
	
	@RequestMapping(value="/addProduct",method=RequestMethod.POST)
	public String addProductForm(@Valid @ModelAttribute("product") Product mproduct , BindingResult result , Model model
			,HttpServletRequest request){
		
		//validate image file selected or not
		new ProductValidator().validate(mproduct, result);
		
		//check if an error 
		if(result.hasErrors()){
			model.addAttribute("userClickManageProducts", true);
		      model.addAttribute("title", "Manage Products");
		      model.addAttribute("message", "Product validation Failed for Submittion ");
			return "page";
		}
		logger.info(mproduct.toString()); 
		productDAO.add(mproduct);
		
		if(!mproduct.getFile().getOriginalFilename().equals("")){
			FileUploadUtitlty.uploadFile(request,mproduct.getFile(),mproduct.getCode());
		}
		
		return "redirect:/management/controller/handle/products?operation=product";
	}
	//returning categories for all request
	
	@ModelAttribute("categories")
	public List<Category> getCategories(){
		System.out.println("88888888888888888888888888");
		System.out.println(categoryDAO.list());
		return categoryDAO.list();
	}
	
	@ModelAttribute(value="category")
	public Category getCategory(){
		return new Category();
	}
	//handling category submission
	@RequestMapping(value="/category",method=RequestMethod.POST)
	public String categorySubmission(@ModelAttribute Category category){
		categoryDAO.addCategory(category);
		return "redirect:/management/controller/handle/products?operation=category";
	}
}
