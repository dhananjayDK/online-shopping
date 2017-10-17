package com.dksofts.shoppingbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dksofts.shoppingbackend.dao.CategotyDAO;
import com.dksofts.shoppingbackend.dto.Category;

@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategotyDAO {
    private static List<Category> categories = new ArrayList<>();
	
    @Autowired
    private SessionFactory sessionFactory;
    /*static {
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
    	
    	
    }*/
    @Override
	public List<Category> list() {
		// TODO Auto-generated method stub
    	return sessionFactory.getCurrentSession().createQuery("From Category").list();
	/*	String query = "From Category where active = :active";
		Query<Category> query2 = sessionFactory.getCurrentSession().createQuery(query);
		return query2.getResultList();*/
	}
    /*
     * Getting Single Category
     */
	@Override
	public Category get(int id) {
		// TODO Auto-generated method stub
		/*for(Category c : categories){
			if(c.getId()== id){
				return c;
			}
		}*/
		return sessionFactory.getCurrentSession().get(Category.class, Integer.valueOf(id));
		 
	}
	@Override
	public boolean addCategory(Category category) {
		try{
		// add category
	   sessionFactory.getCurrentSession().persist(category); 	
		return true;
		}catch(Exception ex){
			ex.printStackTrace();
			return false;
		}
	}
	/*
	 * update a single category
	 * */
	@Override
	public boolean updateCategory(Category category) {
		try{
			// update category
		   sessionFactory.getCurrentSession().update(category); 	
			return true;
			}catch(Exception ex){
				ex.printStackTrace();
				return false;
			}
	}
	/*
	 * delete single record
	 * */
	@Override
	public boolean deleteCategory(Category category) {
		category.setActive(false);
		try{
			// update category
		   sessionFactory.getCurrentSession().update(category); 	
			return true;
			}catch(Exception ex){
				ex.printStackTrace();
				return false;
			}
		
	}
}
