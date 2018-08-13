package org.este.resturant.metier;

import java.util.List;

import org.este.resturant.entities.Client;
import org.este.resturant.entities.Commande;
import org.este.resturant.entities.Panier;
import org.este.resturant.entities.Serveur;
import org.este.resturant.entities.Tables;

public interface IServeurResturantMetier extends ICuisinierResturantMetier{
	public Commande enregistrerCommande(Panier p, Client c);
	public void ajouterTable(Tables t);
	public void modifierTable(Tables t);
	public void supprimerTable(Long idTable);
	public List<Tables> listTables();
	public Tables getTable(Long idTable);
	public List<Tables> tablesDisponible();
	public List<Tables> tablesParMC(String mc);
	public Commande getCommande(Long idCommande);
	public void modifierCommande(Commande c);
	public void supprimerCommande(Long idCommande);
}
