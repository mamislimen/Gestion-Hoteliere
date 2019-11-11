package com.hotel.economat;

import java.util.stream.Stream;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient

public class GestionStockEconomatApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionStockEconomatApplication.class, args);
	}
	
	@Bean
	ApplicationRunner init (ProduitRepoitory repository)
	{
		return args->{
			Produit p1=new Produit("viande","viande de vache","Boucherie",150,25900,"falla7");
			Produit p2=new Produit("pomme de terre","Pomme de terre tunisie","Legume",1500,1200,"falla7");
			Produit p3=new Produit("bannane","Bannane","Fruit",250,3900,"falla7");

			repository.save(p1);

			repository.save(p2);

			repository.save(p3);
		};
	}

}
