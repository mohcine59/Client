package fr.dev.client.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Produit implements Serializable{

	@Id
	@GeneratedValue
	private Long id;
	private String description;
	private double prix;
	private int quantite;
	
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public double getPrix() {
		return prix;
	}


	public void setPrix(double prix) {
		this.prix = prix;
	}


	public int getQuantite() {
		return quantite;
	}


	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}


	public Produit(String description, double prix, int quantite) {
		super();
		this.description = description;
		this.prix = prix;
		this.quantite = quantite;
	}


	public Produit() {
		// TODO Auto-generated constructor stub
	}

}
