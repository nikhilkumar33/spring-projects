package com.flipkart.search.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.flipkart.search.entity.Product;
import com.flipkart.search.request.ProductRequest;

@Service
public interface SearchService 
{
	public int saveProduct(ProductRequest productRequest);

	public List<Product> getProductDetails(String prodName);
}
