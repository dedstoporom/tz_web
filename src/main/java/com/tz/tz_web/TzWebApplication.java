package com.tz.tz_web;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableCaching
public class TzWebApplication
{
	public static void main(String[] args)
	{
		SpringApplication.run(TzWebApplication.class, args);
	}

}

