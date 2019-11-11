package com.hotel.economat;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProduitService {


	@Autowired
	private ProduitRepoitory produitRepoitory;
	

	public List<Produit> listProduits ()
	{
		return produitRepoitory.findAll();
		
	}
	
	public Optional<Produit> getById(int id) {
	 	
	 		return produitRepoitory.findById(id);
		
	}
	public Produit getByNom(String nom) {
		
		return 	produitRepoitory.ProduitByNom(nom)		;	
		}
	
	public Produit AjouterProduit(Produit produit)
	{
		 return produitRepoitory.save(produit);
		
	
	}
	
	public Produit updateProduit(int id,Produit newProduit)
	{
		if(produitRepoitory.findById(id).isPresent())
		{
		Produit existProduit = produitRepoitory.findById(id).get();
		existProduit.setNom(newProduit.getNom());
		existProduit.setCategorie(newProduit.getCategorie());
		existProduit.setDescription(newProduit.getDescription());
		existProduit.setFournisseur(newProduit.getFournisseur());
		existProduit.setQuantite(newProduit.getQuantite());
		existProduit.setPrixUnitaire(newProduit.getPrixUnitaire());

		return produitRepoitory.save(existProduit);
		
		}else
			return null;
		
	}
	
	public String supprimerProduit(int id)
	{
		produitRepoitory.deleteById(id);
		return "le produit a été supprimé ";
	
	}
	
}
