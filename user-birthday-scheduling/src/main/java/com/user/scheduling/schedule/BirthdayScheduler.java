package com.user.scheduling.schedule;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.user.scheduling.service.BirthdayService;

@Component
public class BirthdayScheduler
{
	@Autowired
	BirthdayService birthdayService;
	
	@Scheduled(cron = "0 09 16 * * ?")
    public void sendBirthdayEmails() {
		 System.out.println("Scheduler triggered at: " + LocalDateTime.now());
        birthdayService.sendBirthdayWishes();
    }

}
