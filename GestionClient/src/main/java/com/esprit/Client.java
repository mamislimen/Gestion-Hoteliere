package com.esprit;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.*;

@Entity
public class Client implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private int id;
	private String cin;
	
    private String nom;
    private String prenom;
    private String tel;
    private String email;
    private String adresse;
    @Enumerated(EnumType.STRING)
    private TypeClient type;



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getCin() {
		return cin;
	}



	public void setCin(String cin) {
		this.cin = cin;
	}



	public String getNom() {
		return nom;
	}



	public void setNom(String nom) {
		this.nom = nom;
	}



	public String getPrenom() {
		return prenom;
	}



	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}



	public String getTel() {
		return tel;
	}



	public void setTel(String tel) {
		this.tel = tel;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getAdresse() {
		return adresse;
	}



	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}



	public TypeClient getType() {
		return type;
	}



	public void setType(TypeClient type) {
		this.type = type;
	}



	public Client() {
		super();
	}
    
    
	

}
