package com.udemy.RestApi.config;

import java.util.concurrent.Executor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
public class AppConfig {
	static int i = 0;

	
	@Scheduled(fixedRate = 5000)
	public void cleanFile()
	{
		i++;
		System.out.println("cleaning the file::"+i);
		
	}
}
