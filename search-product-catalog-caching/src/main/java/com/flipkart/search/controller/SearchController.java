package com.flipkart.search.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.flipkart.search.entity.Product;
import com.flipkart.search.request.ProductRequest;
import com.flipkart.search.service.SearchService;

@RestController
public class SearchController 
{
	@Autowired
	SearchService searchService;
	
	@PostMapping("createProduct")
	public String createProduct(@RequestBody ProductRequest productRequest)
	{
		int prodId = searchService.saveProduct(productRequest);
		return "Product is saved successfully.. Product id is: "+prodId;
	}
	
	@GetMapping("searchProduct")
	public ResponseEntity<List<Product>> searchProduct(@RequestParam String  prodName)
	{
		System.out.println("hello");
		List<Product> products = searchService.getProductDetails(prodName);
		System.out.println("hello world");
		return ResponseEntity.ok(products);
	}


}
