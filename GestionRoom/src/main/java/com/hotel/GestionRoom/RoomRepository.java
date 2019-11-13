package com.hotel.GestionRoom;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {

	 @Query("select r from Room r where r.vue like :vue")
		public List<Room> roomByVue(@Param("vue") String vue);

	@Query("select r from Room r where r.num = :num")
	public Room roomByNum(@Param("num") int num);


	@Query("select r from Room r where r.status = :status")
	public List<Room> roomByStatus(@Param("status") boolean status);


}
