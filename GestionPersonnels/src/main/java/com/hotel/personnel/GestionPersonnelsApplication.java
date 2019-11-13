package com.hotel.personnel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GestionPersonnelsApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionPersonnelsApplication.class, args);
	}
	@Bean
	ApplicationRunner init (PersonnelRepository pRepository, DepartementRepository dRepository)
	{
		return args -> {
		Departement d1 = new Departement("Reception");
		Departement d2 = new Departement("Maintenance");
		Departement d3 = new Departement("Restauration");
		dRepository.save(d1);
		dRepository.save(d2);
		dRepository.save(d3);
		Personnel p1 = new Personnel("Mami", "Slimen", "22/03/1994", 1500, "Homme", "10/10/2016", d2);
		Personnel p2 = new Personnel("Abdelhafidh", "Mohammed", "01/05/1995", 1350, "Homme", "05/06/2017", d2);
		Personnel p3 = new Personnel("Hbibi", "Ines", "07/11/1996", 1900, "Femme", "02/03/2018", d1);
		Personnel p4 = new Personnel("Jrad", "Elyes", "13/09/1996", 2300, "Homme", "09/06/2012", d1);
		Personnel p5 = new Personnel("Mrad", "Firas", "10/12/1993", 2000, "Homme", "26/08/2011", d3);
		Personnel p6 = new Personnel("Mrad", "Yassine", "14/02/1994", 1500, "Homme", "31/07/2014", d3);
		pRepository.save(p1);
		pRepository.save(p2);
		pRepository.save(p3);
		pRepository.save(p4);
		pRepository.save(p5);
		pRepository.save(p6); 
		dRepository.findAll().forEach(System.out::println);
		pRepository.findAll().forEach(System.out::println);
		};
	}
}
