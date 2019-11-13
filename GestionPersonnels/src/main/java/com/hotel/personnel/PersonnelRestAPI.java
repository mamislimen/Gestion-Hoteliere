package com.hotel.personnel;

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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonnelRestAPI {
	@Autowired
	private PersonnelService pService;
	
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping("personnel/all")
	@ResponseStatus(HttpStatus.FOUND)
	public  List<Personnel> getAllPersonnel(){
		return pService.getAllPersonnel();
	}

	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping("departement/all")
	@ResponseStatus(HttpStatus.OK)
	public  List<Departement> getAllDepartement(){
		return pService.getAllDepartement();
	}
	
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping("personnel/id/{id}")
	@ResponseStatus(HttpStatus.FOUND)
	public  Optional<Personnel> getPersonnelById(@PathVariable(value = "id") int id){
		return pService.getPersonnelById(id);
	}
	
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping("personnel/departement/{departement}")
	@ResponseStatus(HttpStatus.FOUND)
	public  List<Personnel> getPersonnelByDepartement(@PathVariable(value = "departement") String departement){
		return pService.getPersonnelByDepartement(departement);
	}
	
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping("personnel/nom/{nom}")
	@ResponseStatus(HttpStatus.FOUND)
	public  List<Personnel> getPersonnelByNom(@PathVariable(value = "nom") String nom){
		return pService.getPersonnelByNom(nom);
	}
	
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping("departement/id/{id}")
	@ResponseStatus(HttpStatus.FOUND)
	public  Optional<Departement> getDepartementById(@PathVariable(value = "id") int id){
		return pService.getDepartementById(id);
	}
	
	@PostMapping(value = "/personnel",produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Personnel> addPersonnel(@RequestBody Personnel p)
	{
		return new ResponseEntity<>(pService.addPersonnel(p),HttpStatus.OK);	
	}
	
	@PutMapping(value = "/personnel/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Personnel> updatePersonnel(@PathVariable(value = "id") int id,@RequestBody Personnel p)
	{
		return new ResponseEntity<>(pService.updatePersonnel(id, p),HttpStatus.OK);	
	}
	
	@DeleteMapping(value = "/personnel/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public String deletePersonnel(@PathVariable(value = "id") int id)
	{
		return pService.deletePersonnel(id);	
	}
}
