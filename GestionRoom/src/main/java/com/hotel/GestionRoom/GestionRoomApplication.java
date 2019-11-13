package com.hotel.GestionRoom;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class GestionRoomApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionRoomApplication.class, args);
	}

	@Bean
	ApplicationRunner init (RoomRepository repository)
	{
		return args->{
			Room room1 =new Room(127,"A","Single",false,"Bitch",1);
			Room room2 =new Room(512,"B","Double",true,"Normal",5);
			Room room3 =new Room(632,"C","Triple",true,"Grass",6);

			repository.save(room1);

			repository.save(room2);

			repository.save(room3);
		};
	}
}



