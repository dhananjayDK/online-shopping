package com.dksofts.onlineshopping.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dksofts.onlineshopping.exception.ProductNotFoundException;
import com.dksofts.shoppingbackend.dao.CategotyDAO;
import com.dksofts.shoppingbackend.dao.ProductDAO;
import com.dksofts.shoppingbackend.dto.Category;
import com.dksofts.shoppingbackend.dto.Product;

@Controller
public class PageController {

	private static final Logger logger = LoggerFactory.getLogger(PageController.class);
	
	@Autowired
	CategotyDAO categoryDAO;
	
	@Autowired
	ProductDAO productDAO;
	
	@RequestMapping({"/","/home","/index.html"})
	public ModelAndView index(){
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Home");
		
		logger.info("Inside Page controller index method - Info");
		logger.debug("Inside Page controller index method - debbug");
		
		mv.addObject("userClickHome",true);
		List<Category> categories = categoryDAO.list();
		mv.addObject("categories", categories);
		return mv;
	}
	
	@RequestMapping("/about")
	public ModelAndView about(){
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "About Us");
		mv.addObject("userClickAbout",true);
		return mv;
	}
	
	@RequestMapping("/contact")
	public ModelAndView contact(){
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Contact Us");
		mv.addObject("userClickContact",true);
		return mv;
	}
	
	@RequestMapping("/show/all/listOfProduct")
	public ModelAndView viewAllProduct(){
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "All Product");
		mv.addObject("categories", categoryDAO.list());
		mv.addObject("userClickAllProduct",true);
		return mv;
	}
	
	@RequestMapping("/show/category/{id}/Products")
	public ModelAndView viewCategoryProduct(@PathVariable("id") int id){
		ModelAndView mv = new ModelAndView("page");
		Category category = null;
		category = categoryDAO.get(id);
		mv.addObject("title", category.getName());
		mv.addObject("categories", categoryDAO.list());
		mv.addObject("category", category);
		mv.addObject("userClickCategoryProduct",true);
		return mv;
	}
	@RequestMapping("/showby/{id}/product")
	public ModelAndView viewProductById(@PathVariable("id") int id)throws ProductNotFoundException{
		System.out.println("Running view product by id");
		ModelAndView mv = new ModelAndView("page");
		Product product = productDAO.get(id);
		if(product==null) throw new ProductNotFoundException();
		//update the views
		product.setViews(product.getViews()+1);
		productDAO.update(product);
		////////
		mv.addObject("title", product.getName());
		mv.addObject("product", product);
		mv.addObject("userClickShowProduct",true);
		System.out.println("Running view product by id");
		System.out.println("Running view product by id");
		return mv;
	}
	
	
}
