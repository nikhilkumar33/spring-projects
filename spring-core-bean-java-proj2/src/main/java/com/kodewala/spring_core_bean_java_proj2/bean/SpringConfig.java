package com.kodewala.spring_core_bean_java_proj2.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SpringConfig {

	@Bean("family")
	public FamilyStar createFamilyBean()
	{
		FamilyStar familyStar =new FamilyStar("Soumyadeep Ghosh", "Soumya Ghosh", "Somita Ghosh");
		return familyStar;
	}
}
