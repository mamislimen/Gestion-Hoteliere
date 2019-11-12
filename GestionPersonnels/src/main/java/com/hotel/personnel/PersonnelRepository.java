package com.hotel.personnel;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PersonnelRepository extends JpaRepository<Personnel , Integer> {
	@Query("select p from Personnel p where lower(p.departement.nom) like lower(concat('%', :departement,'%'))")
	public List<Personnel> pesonnelByDepartement (@Param("departement") String n);
	
	@Query("select p from Personnel p where lower(p.nom) like lower(concat('%',:nom,'%')) or lower(p.prenom) like lower(concat('%',:nom,'%')) ")
	public List<Personnel> pesonnelByNom (@Param("nom") String n);
}
