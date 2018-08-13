package org.este.resturant.metier;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import org.este.resturant.dao.IResturantDao;
import org.este.resturant.entities.*;
import org.springframework.transaction.annotation.Transactional;
@Transactional
public class ResturantMetierImpl implements IAdminResturantMetier{
	private IResturantDao dao;
	
	public void setDao(IResturantDao dao) {
		this.dao = dao;
	}
	Encryptor enc = new Encryptor();
	String key = "Bar12345Bar12345"; // 128 bit key
    String initVector = "RandomInitVector"; // 16 bytes IV
    
	@Override
	public List<Facture> listFactures() {
		// TODO Auto-generated method stub
		return dao.listFactures();
	}

	@Override
	public List<Facture> listFactureParClient(Long idClient) {
		// TODO Auto-generated method stub
		return dao.listFactureParClient(idClient);
	}

	@Override
	public Commande enregistrerCommande(Panier p, Client c) {
		// TODO Auto-generated method stub
		return dao.enregistrerCommande(p, c);
	}

	@Override
	public void ajouterTable(Tables t) {
		dao.ajouterTable(t);
		
	}

	@Override
	public void modifierTable(Tables t) {
		dao.modifierTable(t);
		
	}

	@Override
	public void supprimerTable(Long idTable) {
		dao.supprimerTable(idTable);
		
	}

	@Override
	public List<Tables> listTables() {
		// TODO Auto-generated method stub
		return dao.listTables();
	}

	@Override
	public Tables getTable(Long idTable) {
		// TODO Auto-generated method stub
		return dao.getTable(idTable);
	}

	@Override
	public List<Tables> tablesDisponible() {
		// TODO Auto-generated method stub
		return dao.tablesDisponible();
	}

	@Override
	public List<Tables> tablesParMC(String mc) {
		// TODO Auto-generated method stub
		return dao.tablesParMC(mc);
	}

	@Override
	public Commande getCommande(Long idCommande) {
		// TODO Auto-generated method stub
		return dao.getCommande(idCommande);
	}

	@Override
	public void modifierCommande(Commande c) {
		dao.modifierCommande(c);
	}

	@Override
	public void supprimerCommande(Long idCommande) {
		dao.supprimerCommande(idCommande);
	}

	@Override
	public List<Produit> listproduits() {
		// TODO Auto-generated method stub
		return dao.listproduits();
	}

	@Override
	public List<Produit> produitsParMotCle(String mc) {
		// TODO Auto-generated method stub
		return dao.produitsParMotCle(mc);
	}

	@Override
	public List<Produit> produitsParCategorie(Long idCat) {
		// TODO Auto-generated method stub
		return dao.produitsParCategorie(idCat);
	}

	@Override
	public List<Produit> produitsDisponible() {
		// TODO Auto-generated method stub
		return dao.produitsDisponible();
	}

	@Override
	public List<Categorie> listCategories() {
		// TODO Auto-generated method stub
		return dao.listCategories();
	}

	@Override
	public List<Commande> listCommandeParServeur(Long idServ) {
		// TODO Auto-generated method stub
		return dao.listCommandeParServeur(idServ);
	}

	@Override
	public List<LigneCommande> listLigneCommandeParCommande(Long idCommande) {
		// TODO Auto-generated method stub
		return dao.listLigneCommandeParCommande(idCommande);
	}

	@Override
	public List<Commande> listCommande() {
		// TODO Auto-generated method stub
		return dao.listCommande();
	}

	@Override
	public void ajouterUser(User u) {
		dao.ajouterUser(u);
	}

	@Override
	public Long ajouterAdmin(Admin a) {
		// TODO Auto-generated method stub
		return dao.ajouterAdmin(a);
	}

	@Override
	public Long ajouterCassier(Cassier ca) {
		// TODO Auto-generated method stub
		return dao.ajouterCassier(ca);
	}

	@Override
	public Long ajouterCuisinier(Cuisinier cu) {
		// TODO Auto-generated method stub
		return dao.ajouterCuisinier(cu);
	}

	@Override
	public Long ajouterServeur(Serveur s) {
		// TODO Auto-generated method stub
		return dao.ajouterServeur(s);
	}

	@Override
	public void modifierUser(User u) {
		dao.modifierUser(u);
	}

	@Override
	public void modifierAdmin(Admin a) {
		dao.modifierAdmin(a);
	}

	@Override
	public void modifeirCassier(Cassier ca) {
		dao.modifeirCassier(ca);
	}

	@Override
	public void modifierCuisinier(Cuisinier cu) {
		dao.modifierCuisinier(cu);
	}

	@Override
	public void modifierServeur(Serveur s) {
		dao.modifierServeur(s);
	}

	@Override
	public void supprimerUser(Long idUser) {
		dao.supprimerUser(idUser);
	}

	@Override
	public void supprimerAdmin(Long idAdmin) {
		dao.supprimerAdmin(idAdmin);
	}

	@Override
	public void supprimerCassier(Long idCass) {
		dao.supprimerCassier(idCass);
	}

	@Override
	public void supprimerCuisinier(Long idCuis) {
		dao.supprimerCuisinier(idCuis);
	}

	@Override
	public void supprimerServeur(Long idServ) {
		dao.supprimerServeur(idServ);
	}

	@Override
	public List<User> listUsers() {
		// TODO Auto-generated method stub
		return dao.listUsers();
	}

	@Override
	public List<Admin> listAdmins() {
		// TODO Auto-generated method stub
		return dao.listAdmins();
	}

	@Override
	public List<Cassier> listCassiers() {
		// TODO Auto-generated method stub
		return dao.listCassiers();
	}

	@Override
	public List<Cuisinier> listCuisinier() {
		// TODO Auto-generated method stub
		return dao.listCuisinier();
	}

	@Override
	public List<Serveur> listServeurs() {
		// TODO Auto-generated method stub
		return dao.listServeurs();
	}

	@Override
	public User getUser(Long idUser) {
		// TODO Auto-generated method stub
		return dao.getUser(idUser);
	}

	@Override
	public Admin getAdmin(Long idAdmin) {
		// TODO Auto-generated method stub
		return dao.getAdmin(idAdmin);
	}

	@Override
	public Cassier getCassier(Long idCass) {
		// TODO Auto-generated method stub
		return dao.getCassier(idCass);
	}

	@Override
	public Cuisinier getCuisinier(Long idCuis) {
		// TODO Auto-generated method stub
		return dao.getCuisinier(idCuis);
	}

	@Override
	public Serveur getServeur(Long idServ) {
		// TODO Auto-generated method stub
		return dao.getServeur(idServ);
	}

	@Override
	public Long ajouterCategorie(Categorie c) {
		// TODO Auto-generated method stub
		return dao.ajouterCategorie(c);
	}

	@Override
	public Categorie getCategorie(Long idCat) {
		// TODO Auto-generated method stub
		return dao.getCategorie(idCat);
	}

	@Override
	public void supprimerCategrorie(Long idcat) {
		dao.supprimerCategrorie(idcat);
	}

	@Override
	public void modifierCategorie(Categorie c) {
		dao.modifierCategorie(c);
	}

	@Override
	public Long ajouterProduit(Produit p, Long idCat) {
		// TODO Auto-generated method stub
		return dao.ajouterProduit(p, idCat);
	}

	@Override
	public Produit getProduit(Long idProd) {
		// TODO Auto-generated method stub
		return dao.getProduit(idProd);
	}

	@Override
	public void supprimerProduit(Long idProd) {
		dao.supprimerProduit(idProd);
	}

	@Override
	public void modifierProduit(Produit p) {
		dao.modifierProduit(p);
	}

	@Override
	public void attribuerRole(Role r, Long idUser) {
		dao.attribuerRole(r, idUser);
	}

	@Override
	public List<String> listEmailAdmins() {
		return dao.listEmailAdmins();
	}
	public List<Utilisateur> ListEmailUtilisateurs(){
		Utilisateur ut;
		List<Utilisateur> list = new ArrayList<Utilisateur>();
		Utilisateur u= new Utilisateur();
		Utilisateur n= new Utilisateur();
		u.setEmailUtil("-Les emails des admins :");
		u.setIdUtil(999955L);
		list.add(u);
		List<Admin> ListAdmin = dao.listAdmins();
		for(Admin a : ListAdmin){
			ut = new Utilisateur();
			ut.setIdUtil(a.getIdAdmin());
			ut.setEmailUtil(a.getEmail());
			list.add(ut);
		}
		list.add(n);
		Utilisateur ca= new Utilisateur();
		ca.setEmailUtil("-Les emails des caissiers :");
		ca.setIdUtil(999966L);
		list.add(ca);
		List<Cassier> listCassier = dao.listCassiers();
		for(Cassier c : listCassier){
			ut = new Utilisateur();
			ut.setIdUtil(c.getIdCassier());
			ut.setEmailUtil(c.getEmail());
			list.add(ut);
		}
		list.add(n);
		Utilisateur se= new Utilisateur();
		se.setEmailUtil("-Les emails des serveurs :");
		se.setIdUtil(999966L);
		list.add(se);
		List<Serveur> listServeur = dao.listServeurs();
		for(Serveur s : listServeur){
			ut = new Utilisateur();
			ut.setIdUtil(s.getIdServeur());
			ut.setEmailUtil(s.getEmail());
			list.add(ut);
		}
		list.add(n);
		Utilisateur cu= new Utilisateur();
		cu.setEmailUtil("-Les emails des cuisinier :");
		cu.setIdUtil(999977L);
		list.add(cu);
		List<Cuisinier> listCuisinier = dao.listCuisinier();
		for(Cuisinier cui : listCuisinier){
			ut = new Utilisateur();
			ut.setIdUtil(cui.getIdCuisinier());
			ut.setEmailUtil(cui.getEmail());
			list.add(ut);
		}
		return list;
	}

	public List<Utilisateur> ListRoleUtilisateurs(){
		Utilisateur ut;
		List<Utilisateur> list = new ArrayList<Utilisateur>();
		List<Role> listRoles = dao.listRoles();
		for(Role r : listRoles){
			ut = new Utilisateur();
			ut.setIdRole(r.getIdRole());
			ut.setNomRole(r.getNomRole());
			list.add(ut);
		}
		return list;
	}
	
	@Override
	public List<Role> listRoles() {
		return dao.listRoles();
	}

	@Override
	public List<User> getUserParRoleEtEmailId(String role, Long idUtil) {
		return dao.getUserParRoleEtEmailId(role, idUtil);
	}

	@Override
	public User getUserDansListParRoleEtEmailId(String role, Long idUtil) {
		List<User> list = dao.getUserParRoleEtEmailId(role, idUtil);
		User ur=null;
		for(User u : list){
			ur = new User();
			ur=u;
		}
		return ur;
	}

	@Override
	public String getEncodedPassword(String key) {
		  byte[] uniqueKey = key.getBytes();
		  byte[] hash = null;
		  try {
			hash = MessageDigest.getInstance("MD5").digest(uniqueKey);
		  } catch (NoSuchAlgorithmException e) {
			throw new Error("no MD5 support in this VM");
		  }
		  StringBuffer hashString = new StringBuffer();
		  for ( int i = 0; i < hash.length; ++i ) {
			String hex = Integer.toHexString(hash[i]);
			if ( hex.length() == 1 ) {
			  hashString.append('0');
			  hashString.append(hex.charAt(hex.length()-1));
			} else {
			  hashString.append(hex.substring(hex.length()-2));
			}
		  }
		  return hashString.toString();
		}

	@Override
	public List<Serveur> serveursParMotCle(String mc) {
		return dao.serveursParMotCle(mc);
	}

	@Override
	public List<Cuisinier> cuisiniersParMotCle(String mc) {
		return dao.cuisiniersParMotCle(mc);
	}

	@Override
	public void supprimerRolesParIdUser(Long idUser) {
		dao.supprimerRolesParIdUser(idUser);
	}

	@Override
	public List<Categorie> categoriesParMotCle(String mc) {
		return dao.categoriesParMotCle(mc);
	}

	@Override
	public Long ajouterClient(Client c) {
		return dao.ajouterClient(c);
	}

	@Override
	public Client getClient(Long idCl) {
		return dao.getClient(idCl);
	}

	@Override
	public Long ajouterFacture(Facture f) {
		return dao.ajouterFacture(f);
	}

	@Override
	public void modifierFacture(Facture f) {
		dao.modifierFacture(f);
	}

	@Override
	public List<Commande> listCommandeNoDisponible() {
		// TODO Auto-generated method stub
		return dao.listCommandeNoDisponible();
	}

	@Override
	public List<Commande> listCommandeDisponible() {
		// TODO Auto-generated method stub
		return dao.listCommandeDisponible();
	}

	@Override
	public List<Commande> listToutCommande() {
		// TODO Auto-generated method stub
		return dao.listToutCommande();
	}

	@Override
	public List<LigneCommande> listLigneCommandeParIdCommande(Long idComm) {
		// TODO Auto-generated method stub
		return dao.listLigneCommandeParIdCommande(idComm);
	}

	@Override
	public void supprimerLigneCommande(LigneCommande l) {
		dao.supprimerLigneCommande(l);
	}

	@Override
	public List<Facture> getFactureParIdCommande(Long idComm) {
		// TODO Auto-generated method stub
		return dao.getFactureParIdCommande(idComm);
	}

	@Override
	public void supprimerFacture(Facture f) {
		dao.supprimerFacture(f);
	}

	@Override
	public List<Commande> commandesParMC(String mc) {
		// TODO Auto-generated method stub
		return dao.commandesParMC(mc);
	}

	@Override
	public List<Facture> facturesParMotCle(String mc) {
		// TODO Auto-generated method stub
		return dao.facturesParMotCle(mc);
	}

	@Override
	public List<User> getUserParNomEtPasse(String nom, String passe) {
		// TODO Auto-generated method stub
		return dao.getUserParNomEtPasse(nom, passe);
	}

	@Override
	public boolean vérifierLoginPasseRoleSuper(User u) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean vérifierLoginPasseRoleAdmin(User u) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean vérifierLoginPasseRoleCassier(User u) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean vérifierLoginPasseRoleServeur(User u) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean vérifierLoginPasseRoleCuisinier(User u) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User getUserNomEtPasse(String nom, String passe) {
		User user=null;
		for(User u : dao.getUserParNomEtPasse(nom, passe)){
			user = new User();
			user = u;
		}
		return user;
	}

	@Override
	public List<User> AffichlistUsers() {
		
		List<User> list = new ArrayList<User>();
		for(User u : dao.listUsers()){
			if(u.getPasswordByte()!=null){
				u.setPassword(enc.decrypt(key, initVector, u.getPasswordByte()));
			}
			list.add(u);
		}
		return list;
	}
}
