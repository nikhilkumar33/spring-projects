package com.zepto.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zepto.product.bean.ProductInfo;
import com.zepto.product.dao.ProductDAO;
import com.zepto.product.entity.Product;

@Service
public class ProductService 
{
	@Autowired
	ProductDAO productDAO;
	
	
	public void addProductService(ProductInfo productInfo)
	{
		System.out.println("Inside addProductService()....");
		
		Product product = new Product();
		product.setItemName(productInfo.getItemName());
		product.setDescription(productInfo.getDescription());
		product.setQty(productInfo.getQty());
		product.setPrice(productInfo.getPrice());
		
		productDAO.addProduct(product);
		
	}


	public List<Product> findProductBySearchString(String searchString) {
		
		 return productDAO.searchProduct(searchString);
	}

}
