package org.este.resturant.metier;

import java.util.List;

import org.este.resturant.entities.Facture;

public interface ICassierResturantMetier extends IServeurResturantMetier{
	public List<Facture> listFactures();
	public List<Facture> listFactureParClient(Long idClient);
	public Long ajouterFacture(Facture f);
	public void modifierFacture(Facture f);
	public List<Facture> getFactureParIdCommande(Long idComm);
	public void supprimerFacture(Facture f);
	public List<Facture> facturesParMotCle(String mc);
}
