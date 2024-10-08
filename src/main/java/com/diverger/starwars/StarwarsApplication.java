package com.diverger.starwars;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@Slf4j
@EnableFeignClients
@SpringBootApplication
public class StarwarsApplication {

	public static void main(String[] args)
	{
		log.info("Starting Star Wars Person Information service");
		SpringApplication.run(StarwarsApplication.class, args);
	}

}
