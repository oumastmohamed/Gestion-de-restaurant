package org.este.resturant.metier;

import java.util.List;

import org.este.resturant.entities.Admin;
import org.este.resturant.entities.Cassier;
import org.este.resturant.entities.Categorie;
import org.este.resturant.entities.Client;
import org.este.resturant.entities.Commande;
import org.este.resturant.entities.Cuisinier;
import org.este.resturant.entities.LigneCommande;
import org.este.resturant.entities.Produit;
import org.este.resturant.entities.Role;
import org.este.resturant.entities.Serveur;
import org.este.resturant.entities.User;
import org.este.resturant.entities.Utilisateur;

public interface IAdminResturantMetier extends ICassierResturantMetier{
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
	public Categorie getCategorie(Long idCat);
	public void supprimerCategrorie(Long idcat);
	public void modifierCategorie(Categorie c);
	public Long ajouterProduit(Produit p, Long idCat);
	public Produit getProduit(Long idProd);
	public void supprimerProduit(Long idProd);
	public void modifierProduit(Produit p);
	public void attribuerRole(Role r,Long idUser);
	public List<String> listEmailAdmins();
	public List<Utilisateur> ListEmailUtilisateurs();
	public List<Role> listRoles();
	public List<Utilisateur> ListRoleUtilisateurs();
	public List<User> getUserParRoleEtEmailId(String role, Long idUtil);
	public User getUserDansListParRoleEtEmailId(String role, Long idUtil);
	public String getEncodedPassword(String key);
	public List<Serveur> serveursParMotCle(String mc);
	public List<Cuisinier> cuisiniersParMotCle(String mc);
	public void supprimerRolesParIdUser(Long idUser);
	public List<Categorie> categoriesParMotCle(String mc);
	public Long ajouterClient(Client c);
	public Client getClient(Long idCl);
	public void supprimerLigneCommande(LigneCommande l);
	public List<Commande> commandesParMC(String mc);
	public List<User> getUserParNomEtPasse(String nom, String passe);
	public boolean vérifierLoginPasseRoleSuper(User u);
	public boolean vérifierLoginPasseRoleAdmin(User u);
	public boolean vérifierLoginPasseRoleCassier(User u);
	public boolean vérifierLoginPasseRoleServeur(User u);
	public boolean vérifierLoginPasseRoleCuisinier(User u);
	public User getUserNomEtPasse(String nom, String passe);
	public List<User> AffichlistUsers();
}
