package com.dksofts.shoppingbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.dksofts.shoppingbackend.dao.CategotyDAO;
import com.dksofts.shoppingbackend.dto.Category;

@Repository("categoryDAO")
public class CategoryDAOImpl implements CategotyDAO {
    private static List<Category> categories = new ArrayList<>();
	
    static {
    	//first product
    	Category category = new Category();
    	category.setId(1);
    	category.setName("Television");
    	category.setDescription("This is description for Television Category");
    	category.setImageURL("CAT_1.jpg");
    	
    	categories.add(category);
    	//second product
    	category = new Category();
    	category.setId(2);
    	category.setName("LapTop");
    	category.setDescription("This is description for LapTop Category");
    	category.setImageURL("CAT_2.jpg");
    	
    	categories.add(category);
    	//third product
    	category = new Category();
    	category.setId(3);
    	category.setName("Mobile");
    	category.setDescription("This is description for Mobile Category");
    	category.setImageURL("CAT_3.jpg");
    	
    	categories.add(category);
    	
    	
    }
    @Override
	public List<Category> list() {
		// TODO Auto-generated method stub
		return categories;
	}
	@Override
	public Category get(int id) {
		// TODO Auto-generated method stub
		for(Category c : categories){
			if(c.getId()== id){
				return c;
			}
		}
		return null;
	}

}
