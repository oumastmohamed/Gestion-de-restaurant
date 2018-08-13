package org.este.resturant.dao;

import java.util.List;

import org.este.resturant.entities.*;

public interface IResturantDao {
	public void ajouterUser(User u);
	public Long ajouterAdmin(Admin a);
	public Long ajouterCassier(Cassier ca);
	public Long ajouterCuisinier(Cuisinier cu);
	public Long ajouterServeur(Serveur s);
	
	public void modifierUser(User u);
	public void modifierAdmin(Admin a);
	public void modifeirCassier(Cassier ca);
	public void modifierCuisinier(Cuisinier cu);
	public void modifierServeur(Serveur s);
	
	public void supprimerUser(Long idUser);
	public void supprimerAdmin(Long idAdmin);
	public void supprimerCassier(Long idCass);
	public void supprimerCuisinier(Long idCuis);
	public void supprimerServeur(Long idServ);
	
	public List<User> listUsers();
	public List<Admin> listAdmins();
	public List<Cassier> listCassiers();
	public List<Cuisinier> listCuisinier();
	public List<Serveur> listServeurs();
	
	public User getUser(Long idUser);
	public Admin getAdmin(Long idAdmin);
	public Cassier getCassier(Long idCass);
	public Cuisinier getCuisinier(Long idCuis);
	public Serveur getServeur(Long idServ);
	
	public Long ajouterCategorie(Categorie c);
	public List<Categorie> listCategories();
	public Categorie getCategorie(Long idCat);
	public void supprimerCategrorie(Long idcat);
	public void modifierCategorie(Categorie c);
	public Long ajouterProduit(Produit p, Long idCat);
	public List<Produit> listproduits();
	public List<Produit> produitsParMotCle(String mc);
	public List<Produit> produitsParCategorie(Long idCat);
	public List<Produit> produitsDisponible();
	public Produit getProduit(Long idProd);
	public void supprimerProduit(Long idProd);
	public void modifierProduit(Produit p);
	
	public void attribuerRole(Role r,Long idUser);
	public Commande enregistrerCommande(Panier p, Client c);
	
	public void ajouterTable(Tables t);
	public void modifierTable(Tables t);
	public void supprimerTable(Long idTable);
	public List<Tables> listTables();
	public Tables getTable(Long idTable);
	public List<Tables> tablesDisponible();
	public List<Tables> tablesParMC(String mc);
	public List<Commande> listCommande();
	public Commande getCommande(Long idCommande);
	public void modifierCommande(Commande c);
	public void supprimerCommande(Long idCommande);
	public List<Commande> listCommandeParServeur(Long idServ);
	public List<LigneCommande> listLigneCommandeParCommande(Long idCommande);
	
	public List<Facture> listFactures();
	public List<Facture> listFactureParClient(Long idClient);
	public List<String> listEmailAdmins();
	public List<Role> listRoles();
	public List<User> getUserParRoleEtEmailId(String role, Long idUtil);
	public List<Serveur> serveursParMotCle(String mc);
	public List<Cuisinier> cuisiniersParMotCle(String mc);
	public List<Role> listeRolesParIdUser(Long idUser);
	public void supprimerRolesParIdUser(Long idUser);
	public List<Categorie> categoriesParMotCle(String mc);
	public Long ajouterClient(Client c);
	public Client getClient(Long idCl);
	public Long ajouterFacture(Facture f);
	public void modifierFacture(Facture f);
	public List<Commande> listCommandeNoDisponible();
	public List<Commande> listCommandeDisponible();
	public List<Commande> listToutCommande();
	public List<LigneCommande> listLigneCommandeParIdCommande(Long idComm);
	public void supprimerLigneCommande(LigneCommande l);
	public List<Facture> getFactureParIdCommande(Long idComm);
	public void supprimerFacture(Facture f);
	public List<Commande> commandesParMC(String mc);
	public List<Facture> facturesParMotCle(String mc);
	public List<User> getUserParNomEtPasse(String nom, String passe);
}
