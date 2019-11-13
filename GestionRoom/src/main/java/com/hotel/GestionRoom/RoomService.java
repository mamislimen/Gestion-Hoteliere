package com.hotel.GestionRoom;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomService {


	@Autowired
	private RoomRepository roomRepository;
	

	public List<Room> listRooms ()
	{
		return roomRepository.findAll();
		
	}
	
	public Optional<Room> getById(int id) {
	 	
	 		return roomRepository.findById(id);
		
	}
	public List<Room> getByVue(String vue) {
		
		return roomRepository.roomByVue(vue);
		}

	public Room roomByNum(int num) {

		return 	roomRepository.roomByNum(num);
	}

	public List<Room> roomByStatus(boolean status) {

		return roomRepository.roomByStatus(status);
	}



	public Room addRoom(Room room)
	{
		 return roomRepository.save(room);
	}
	
	public Room updateRoom(int id, Room newRoom)
	{
		if(roomRepository.findById(id).isPresent())
		{
		Room existRoom = roomRepository.findById(id).get();
		existRoom.setVue(newRoom.getVue());
		existRoom.setBlock(newRoom.getBlock());
		existRoom.setFloor(newRoom.getFloor());
		existRoom.setNum(newRoom.getNum());
		existRoom.setStatus(newRoom.getStatus());

		return roomRepository.save(existRoom);
		
		}
			return null;
	}
	
	public String deleteRoom(int id)
	{
		roomRepository.deleteById(id);
		return "Room has been deleted successfully !";
	
	}
	
}
