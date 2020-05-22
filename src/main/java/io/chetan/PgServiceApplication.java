package io.chetan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import io.chetan.model.Address;
import io.chetan.model.Owner;
import io.chetan.model.Pg;
import io.chetan.service.PgService;
import io.chetan.service.PgService;

@SpringBootApplication
public class PgServiceApplication {

	//@Autowired
	//private static PgService pgService;

	public static void main(String[] args)
	{
		//SpringApplication.run(PgServiceApplication.class, args);
ConfigurableApplicationContext configurableApplicationContext =
SpringApplication.run(PgServiceApplication.class, args);		
		PgService pgService = configurableApplicationContext.getBean("pgService", PgService.class);
		
		Pg pg = new Pg();
		pg.setName("BLENDERS PG");
		pg.setMyOwner(1L);
		
		//address
		Address address = new Address();
		address.setStreet("area");
		address.setCountry("India");
		address.setHouseNumber("#420");
		address.setDisrtict("Bangalore");
		address.setPin("560067");
		address.setState("Kar");
		
		pg.setAddress(address);
		
		
		pgService.createPg(pg);
	}

}
