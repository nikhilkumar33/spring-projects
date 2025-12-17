package com.flipkart.search.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.flipkart.search.entity.Product;

@Repository
public interface SearchRepository extends CrudRepository<Product, Integer>
{
	List<Product> findByProdName(String prodName);
}
