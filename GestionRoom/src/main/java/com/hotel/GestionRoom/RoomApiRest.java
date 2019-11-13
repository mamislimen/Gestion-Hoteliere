package com.hotel.GestionRoom;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoomApiRest {

	@Autowired
	private RoomService roomService;


	@GetMapping("/rooms")
	@ResponseStatus(HttpStatus.OK)
	public List<Room> listRooms()
	{
		return roomService.listRooms();
	}


	@RequestMapping(value="/rooms/{param:[A-Za-z]+}", method=RequestMethod.GET)
	public List<Room> getRoomsByVue(@PathVariable("param") String vue) {
		return this.roomService.getByVue(vue);
	}

	@RequestMapping(value="/rooms/{param:[0-9]+}", method=RequestMethod.GET)
	public Room getRoomByNum(@PathVariable("param") int num) {
		return this.roomService.roomByNum(num);
	}


	@RequestMapping(value="/rooms/{param:[true|false]}", method=RequestMethod.GET)
	public List<Room> getRoomsByStatus(@PathVariable("param") String status) {
		return this.roomService.roomByStatus(Boolean.parseBoolean(status));
	}


	@PostMapping("/rooms")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Room> ajouter(@RequestBody Room room)
	{
		return new ResponseEntity<> (roomService.addRoom(room),HttpStatus.OK);
	}



	@PutMapping(value = "/rooms/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Room> updateRoom(@PathVariable(value = "id") int id, @RequestBody Room room)
	{
		return new ResponseEntity<>(roomService.updateRoom(id, room),HttpStatus.OK);
	}


	@DeleteMapping(value = "/rooms/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<String> deleteRoom(@PathVariable(value = "id") int id)
	{
		return new ResponseEntity<> (roomService.deleteRoom(id),HttpStatus.OK);
	}
}
