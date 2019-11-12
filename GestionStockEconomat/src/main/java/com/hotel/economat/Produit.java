package com.hotel.economat;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Produit implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@GeneratedValue
	@Id
	private int id;
	
	private String nom;
	private String description ;
	private String categorie;
	private int quantite;
	private float prixUnitaire;
	private String fournisseur;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCategorie() {
		return categorie;
	}
	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	public float getPrixUnitaire() {
		return prixUnitaire;
	}
	public void setPrixUnitaire(float prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}
	public String getFournisseur() {
		return fournisseur;
	}
	public void setFournisseur(String fournisseur) {
		this.fournisseur = fournisseur;
	}
	public Produit() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Produit(String nom, String categorie, int quantite, float prixUnitaire, String fournisseur) {
		super();
		this.nom = nom;
		this.categorie = categorie;
		this.quantite = quantite;
		this.prixUnitaire = prixUnitaire;
		this.fournisseur = fournisseur;
	}
	public Produit(String nom, String description, String categorie, int quantite, float prixUnitaire,
			String fournisseur) {
		super();
		this.nom = nom;
		this.description = description;
		this.categorie = categorie;
		this.quantite = quantite;
		this.prixUnitaire = prixUnitaire;
		this.fournisseur = fournisseur;
	}
	
	
	
}
