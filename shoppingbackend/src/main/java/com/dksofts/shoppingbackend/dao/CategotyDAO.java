package com.dksofts.shoppingbackend.dao;

import java.util.List;

import com.dksofts.shoppingbackend.dto.Category;

public interface CategotyDAO {

	 List<Category> list();
	 Category get(int id);
}
