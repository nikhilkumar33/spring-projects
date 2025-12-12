package com.family.profile.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.family.profile.request.FamilyInfo;

@RestController
public class FamilyController 
{
	@PostMapping("processFamily")
	public ResponseEntity createFamilyInfo(@RequestBody FamilyInfo familyInfo)
	{
		System.out.println(familyInfo.getFatherName());
		return ResponseEntity.ok(familyInfo);
	}
}
