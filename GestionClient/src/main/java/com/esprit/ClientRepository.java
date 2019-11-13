package com.esprit;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ClientRepository extends JpaRepository<Client,Integer> {

	@Query("select c from Client c where LOWER(c.type) like LOWER(:type)")
	public List<Client> clientByType(@Param("type") String type);
	
	
	@Query("select c from Client c where c.cin like :cin")
	public Client clientByCin(@Param("cin") String cin);
}
