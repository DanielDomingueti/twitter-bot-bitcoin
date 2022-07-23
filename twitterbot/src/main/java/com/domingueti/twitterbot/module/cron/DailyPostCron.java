package com.domingueti.twitterbot.module.cron;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.domingueti.twitterbot.module.tweet.services.InsertTweetService;

@EnableScheduling
@Component
public class DailyPostCron {

	@Autowired
	private InsertTweetService service;
	
	@Scheduled(cron = "0 0 16/3 * * *", zone = "UTC")
	public void execute() {
		service.execute();
		System.out.println("teste" + Instant.now());
	}
	
}
