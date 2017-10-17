package com.dksofts.shoppingbackend.dao;

import java.util.List;

import com.dksofts.shoppingbackend.dto.Category;

public interface CategotyDAO {

	 Category get(int id);
	 List<Category> list();
	 
	 
	 boolean addCategory(Category category);
	 boolean updateCategory(Category category);
	 boolean deleteCategory(Category category);
}
