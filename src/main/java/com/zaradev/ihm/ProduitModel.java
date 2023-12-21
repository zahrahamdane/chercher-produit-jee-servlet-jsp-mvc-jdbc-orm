package com.zaradev.ihm;

import java.util.ArrayList;
import java.util.List;

import com.zaradev.bo.Produit;

public class ProduitModel {
	private String motCle;
	private List<Produit> produitsByMC = new ArrayList<Produit>();
	private Produit produit;
	
	public String getMotCle() {
		return motCle;
	}
	public void setMotCle(String motCle) {
		this.motCle = motCle;
	}
	public List<Produit> getProduitsByMC() {
		return produitsByMC;
	}
	public void setProduitsByMC(List<Produit> produitsByMC) {
		this.produitsByMC = produitsByMC;
	}
	public Produit getProduit() {
		return produit;
	}
	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	
	
}
