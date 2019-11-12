package com.hotel.economat;

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
public class ProduitApiRest {

	@Autowired
	private ProduitService produitService;
	
	
	@GetMapping("/produits")
	@ResponseStatus(HttpStatus.OK)
	public List<Produit> listProduits()
	{
		return produitService.listProduits();
	}
	
	
	@RequestMapping(value="/produits/{param:[A-Za-z]+}", method=RequestMethod.GET)
	public Produit getJobsByid(@PathVariable("param") String nom) {
	   return this.produitService.getByNom(nom);
	}

	@RequestMapping(value="/produits/{param:[0-9]+}", method=RequestMethod.GET)
	public Optional<Produit> getJobsBynom(@PathVariable("param") int id) {
	   return this.produitService.getById(id);
	}
	
	
	@PostMapping("/produits")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Produit> ajouter(@RequestBody Produit produit)
	{
		return new ResponseEntity<> (produitService.AjouterProduit(produit),HttpStatus.OK);
	}

	
	
	@PutMapping(value = "/produits/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Produit> updateProduit(@PathVariable(value = "id") int id,@RequestBody Produit produit)
	{
	return new ResponseEntity<>(produitService.updateProduit(id, produit),HttpStatus.OK);	
	}
	

	@DeleteMapping(value = "/produits/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<String> deleteCandidat(@PathVariable(value = "id") int id)
	{
		return new ResponseEntity<> (produitService.supprimerProduit(id),HttpStatus.OK);
	}
}
