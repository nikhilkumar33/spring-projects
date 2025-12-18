package com.user.scheduling.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.scheduling.entity.UserEntity;
import com.user.scheduling.repository.UserRepository;

@Service
public class BirthdayServiceImpl implements BirthdayService
{
	@Autowired
	UserRepository userRepository;
	
	@Override
	public List<UserEntity> sendBirthdayWishes() {
		List<UserEntity> users = userRepository.findTodayBirthdays();
		int count = 0;
		for(UserEntity user: users)
		{
			System.out.println("Happy Birthday to you.... "+user.getFirstname()+"!");
			
			count++;
		}
		return users;
	}

}
