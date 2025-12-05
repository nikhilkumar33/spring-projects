package com.flipkart.service;

import org.springframework.stereotype.Service;

import com.flipkart.request.UserInfo;

@Service
public interface RegisterService 
{
	 int registerUserService(UserInfo userInfo);
}
