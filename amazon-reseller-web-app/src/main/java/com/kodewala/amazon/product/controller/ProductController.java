package com.kodewala.amazon.product.controller;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kodewala.amazon.entity.Product;
import com.kodewala.amazon.hibernate.config.ConnectHibernate;

@Controller
public class ProductController 
{
	
	@RequestMapping("/showAddProductPage")
	public String showAddProductPage()
	{
		return "addProduct";
	}
	
	@PostMapping("/addProduct")
	public String addNewProduct(@ModelAttribute Product product)
	{
		ConnectHibernate connect = new ConnectHibernate();
		Session session = connect.getHibernateConnection();
		Transaction txn = session.beginTransaction();
		session.save(product);
		txn.commit();
		return "amazon-reseller-home";
	}
	
	@RequestMapping("/showUpdateProductPage")
	public String showUpdateProductPage()
	{
		return "updateProduct";
	}
	
	@RequestMapping("/showDeleteProductPage")
	public String showDeleteProductPage()
	{
		return "deleteProduct";
	}
	
	@RequestMapping("/showViewProductPage")
	public String showViewProductPage()
	{
		return "viewProduct";
	}
	
	
	
}
