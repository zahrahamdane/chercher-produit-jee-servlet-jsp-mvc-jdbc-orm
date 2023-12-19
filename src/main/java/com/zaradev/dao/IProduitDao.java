package com.zaradev.dao;

import java.util.List;

import com.zaradev.bo.Produit;

public interface IProduitDao {
	
	public Produit save(Produit produit);
	public List<Produit> produitParMC(String mc);
	public Produit getProduit(Long id);
	public Produit update(Produit produit);
	public void deleteProduit(Long id);

}
