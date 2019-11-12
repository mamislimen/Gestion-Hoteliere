package com.hotel.personnel;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonnelService {
	@Autowired
	private PersonnelRepository pRepository;
	@Autowired
	private DepartementRepository dRepository;
	
	public List<Personnel> getAllPersonnel(){
		return pRepository.findAll();
	}
	public List<Departement> getAllDepartement(){
		return dRepository.findAll();
	}
	public Optional<Personnel> getPersonnelById(int id) {
		return pRepository.findById(id);
	}
	public Optional<Departement> getDepartementById(int id) {
		return dRepository.findById(id);
	}
	public List<Personnel> getPersonnelByDepartement(String departemnt) {
		return pRepository.pesonnelByDepartement(departemnt);
	}
	public List<Personnel> getPersonnelByNom(String nom) {
		return pRepository.pesonnelByNom(nom);
	}
	public Personnel updatePersonnel(int id,Personnel newPersonnel)
	{
		if(pRepository.findById(id).isPresent())
		{
		Personnel existintPersonnel= pRepository.findById(id).get();
		existintPersonnel.setNom(newPersonnel.getNom());
		existintPersonnel.setPrenom(newPersonnel.getPrenom());
		existintPersonnel.setSexe(newPersonnel.getSexe());
		existintPersonnel.setBirthDate(newPersonnel.getBirthDate());
		existintPersonnel.setDateEmbauche(newPersonnel.getDateEmbauche());
		existintPersonnel.setSalaire(newPersonnel.getSalaire());
		existintPersonnel.setDepartement(newPersonnel.getDepartement());
		return pRepository.save(existintPersonnel);
		
		}else
			return null;
		
	}
	
	public Personnel addPersonnel(Personnel p)
	{
		return pRepository.save(p);
	}
	
	public String deletePersonnel(int id)
	{
		if(pRepository.findById(id).isPresent())
		{
		pRepository.delete(pRepository.findById(id).get());
		return "Personnel supprimé avec succes";
		
		}else
			return "Personnel avec id: "+ id +" n'exite pas";
		
	}
}
