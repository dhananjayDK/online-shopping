package com.dksofts.shoppingbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dksofts.shoppingbackend.dao.ProductDAO;
import com.dksofts.shoppingbackend.dto.Product;

@Repository("productDAO")
@Transactional
public class ProductDAOImpl implements ProductDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
    
	/*
	 * get Single
	 */
	@Override
	public Product get(int productId) {
		// TODO Auto-generated method stub
		try{
		 return	sessionFactory.getCurrentSession()
			.get(Product.class, Integer.valueOf(productId));
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}

	/*
	 * Add Product
	 */
	@Override
	public boolean add(Product product) {
		try{
			 	sessionFactory.getCurrentSession()
				.persist(product);
			 	return true;
			}catch(Exception ex){
				ex.printStackTrace();
			}
			return false;
	}

	@Override
	public boolean update(Product product) {
		try{
		 	sessionFactory.getCurrentSession()
			.update(product);
		 	return true;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(Product product) {
		try{
		 	product.setIs_active(false);
		 	this.update(product);
		 	return true;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return false;
	}
    
	/*
	 * List
	 */

	@Override
	public List<Product> list() {
		return sessionFactory
				.getCurrentSession()
				.createQuery("From Product",Product.class)
				.getResultList();
	}
	
	@Override
	public List<Product> listActiveProducts() {
	  String selectListOfActiveProduct ="From Product where is_active= :active";
	  return sessionFactory.getCurrentSession()
	      .createQuery(selectListOfActiveProduct,Product.class)
	        .setParameter("active", true)
	          .getResultList();
	    
	}

	@Override
	public List<Product> listActiveProductsByCategory(int categoryId) {
		String selectListOfActiveProductByCategory ="From Product where is_active= :active and category_id = :category_id";
		  return sessionFactory.getCurrentSession()
		      .createQuery(selectListOfActiveProductByCategory,Product.class)
		        .setParameter("active", true)
		         .setParameter("category_id", categoryId)
		          .getResultList();
	}

	@Override
	public List<Product> getLatestActiveProduct(int count) {
		String selectListOfActiveProductByCategory ="From Product where is_active= :active ORDER BY id";
		  return sessionFactory.getCurrentSession()
		      .createQuery(selectListOfActiveProductByCategory,Product.class)
		        .setParameter("active", true)
		         .setFirstResult(0)
		          .setMaxResults(count)
		          .getResultList();
	}
}
