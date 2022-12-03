package com.nanlabs.trellomanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@EnableCaching
@SpringBootApplication
public class TrelloManagementApplication {

	public static void main(String[] args) {
		try{
		SpringApplication.run(TrelloManagementApplication.class, args);

		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

}
