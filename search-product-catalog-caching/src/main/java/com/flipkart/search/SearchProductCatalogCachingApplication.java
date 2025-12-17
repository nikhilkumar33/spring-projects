package com.flipkart.search;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SearchProductCatalogCachingApplication {

	public static void main(String[] args) {
		SpringApplication.run(SearchProductCatalogCachingApplication.class, args);
	}

}
