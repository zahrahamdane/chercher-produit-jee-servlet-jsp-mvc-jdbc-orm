package com.zaradev.dao;

import java.util.List;

import com.zaradev.bo.Produit;

public class TestDao {
	
	public static void main(String[] args) {
		
		ProduitDaoImpl dao = new ProduitDaoImpl();
		
		Produit produit1 = dao.save(new Produit("HP 6580", 900, 45));
		Produit produit2 = dao.save(new Produit("Imprimente Epson 760", 900, 45));
		
		System.out.println(produit1.toString());
		System.out.println(produit2.toString());
		
		System.out.println("***********************************************");
		
		List<Produit> produitsByMC = dao.produitParMC("%H%");
		
		for(Produit produit : produitsByMC){
			System.out.println(produit);
		}
	}
	
	
}
