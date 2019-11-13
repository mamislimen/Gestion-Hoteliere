package com.hotel.personnel;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Personnel implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private int id;
	private String nom;
	private String prenom;
	private String birthDate;
	private double salaire;
	private String sexe;
	private String StringEmbauche;
	@ManyToOne
	private Departement departement;
	public Personnel() {
		super();
	}
	public Personnel(String nom, String prenom, String birthDate, double salaire, String sexe, String StringEmbauche,
			Departement departement) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.birthDate = birthDate;
		this.salaire = salaire;
		this.sexe = sexe;
		this.StringEmbauche = StringEmbauche;
		this.departement = departement;
	}
	public int getId() {
		return id;
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
	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthString) {
		this.birthDate = birthString;
	}
	public double getSalaire() {
		return salaire;
	}
	public void setSalaire(double salaire) {
		this.salaire = salaire;
	}
	public String getSexe() {
		return sexe;
	}
	public void setSexe(String sexe) {
		this.sexe = sexe;
	}
	public String getDateEmbauche() {
		return StringEmbauche;
	}
	public void setDateEmbauche(String StringEmbauche) {
		this.StringEmbauche = StringEmbauche;
	}
	public Departement getDepartement() {
		return departement;
	}
	public void setDepartement(Departement departement) {
		this.departement = departement;
	}
}
