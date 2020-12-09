package com.firas.telephones;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.firas.telephones.entities.Telephone;
import com.firas.telephones.service.TelephoneService;

@SpringBootApplication
public class TelephonesApplication /*implements CommandLineRunner*/ {
	
	@Autowired
	TelephoneService telephoneService;

	public static void main(String[] args) {
		SpringApplication.run(TelephonesApplication.class, args);
	}
	
	/*@Override
	public void run(String... args) throws Exception {
		telephoneService.saveTelephone(new Telephone("Samsung Galaxy S8", 1650.0, new Date()));
		telephoneService.saveTelephone(new Telephone("OPPO Reno 8", 860.0, new Date()));
		telephoneService.saveTelephone(new Telephone("Nokia 4.2", 900.0, new Date()));

	}*/

}
