package com.user.scheduling.contreoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.scheduling.entity.UserEntity;
import com.user.scheduling.service.BirthdayService;

@RestController
public class BirthdayWisheshController 
{
	@Autowired
	BirthdayService birthdayService;
	
	
	@GetMapping("/sendBirthdayWish")
	public ResponseEntity<List<UserEntity>> sendBirthdayEmails()
	{
		List<UserEntity> users = birthdayService.sendBirthdayWishes();
		
		
		return ResponseEntity.ok(users);
	}

}
