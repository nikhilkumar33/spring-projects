package com.flipkart.search.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.flipkart.search.entity.Product;
import com.flipkart.search.repository.SearchRepository;
import com.flipkart.search.request.ProductRequest;

@Service
public class SearchServiceImplementation implements SearchService
{
	@Autowired
	SearchRepository repository;
	
	@Override
	public int saveProduct(ProductRequest productRequest) {
		Product product = new Product();
		
		product.setProdName(productRequest.getProdName());
		product.setAmount(productRequest.getAmount());
		product.setDescription(productRequest.getDescription());
		product.setQty(productRequest.getQty());

		product = repository.save(product);
		return product.getProdId();
	}
	@Cacheable(value = "products-new6", key = "#prodName", unless = "#result == null")
	@Override
	public List<Product> getProductDetails(String prodName) {

		System.out.println("Hitting db...");
		List<Product> products =  repository.findByProdName(prodName);
		return products;
	}

}
