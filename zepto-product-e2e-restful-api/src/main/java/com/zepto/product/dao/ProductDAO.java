package com.zepto.product.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zepto.product.entity.Product;
import com.zepto.product.exception.ProductNotFoundException;

@Repository
public class ProductDAO 
{
	@Autowired
	SessionFactory sessionFactory;
	
	
	public void addProduct(Product product)
	{
		System.out.println("ProductDAO - addProduct(): "+product.getItemName());
		Session session= sessionFactory.openSession();
		Transaction trxn= session.beginTransaction();
		session.save(product);
		trxn.commit();
		
		System.out.println("ProductDAO - Product added...");
	}
	
	public List<Product> searchProduct(String searchString)
	{
	    System.out.println("ProductDAO - searchProduct(): " + searchString);
		    Session session = sessionFactory.openSession();
		    List<Product> list = session
		            .createQuery("FROM Product WHERE itemName LIKE :name", Product.class)
		            .setParameter("name", "%" + searchString + "%")
		            .list();
		    session.close();
		    if(list.isEmpty()||list==null){
		    	throw new ProductNotFoundException("Product not found");
		    }else {
		    	return list;
		    }
	}
}
