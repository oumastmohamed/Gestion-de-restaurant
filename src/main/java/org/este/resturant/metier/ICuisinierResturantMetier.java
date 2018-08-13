package org.este.resturant.metier;

import java.util.List;

import org.este.resturant.entities.Categorie;
import org.este.resturant.entities.Commande;
import org.este.resturant.entities.LigneCommande;
import org.este.resturant.entities.Produit;

public interface ICuisinierResturantMetier {
	public List<Produit> listproduits();
	public List<Produit> produitsParMotCle(String mc);
	public List<Produit> produitsParCategorie(Long idCat);
	public List<Produit> produitsDisponible();
	public List<Categorie> listCategories();
	public List<Commande> listCommandeParServeur(Long idServ);
	public List<LigneCommande> listLigneCommandeParCommande(Long idCommande);
	public List<Commande> listCommande();
	public List<Commande> listCommandeNoDisponible();
	public List<Commande> listCommandeDisponible();
	public List<Commande> listToutCommande();
	public List<LigneCommande> listLigneCommandeParIdCommande(Long idComm);
}
