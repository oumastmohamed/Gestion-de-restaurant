package org.este.resturant.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.collections.buffer.CircularFifoBuffer;
import org.este.resturant.entities.Admin;
import org.este.resturant.entities.Cassier;
import org.este.resturant.entities.Categorie;
import org.este.resturant.entities.Client;
import org.este.resturant.entities.Commande;
import org.este.resturant.entities.Cuisinier;
import org.este.resturant.entities.Facture;
import org.este.resturant.entities.Panier;
import org.este.resturant.entities.Produit;
import org.este.resturant.entities.Role;
import org.este.resturant.entities.Serveur;
import org.este.resturant.entities.Tables;
import org.este.resturant.entities.User;
import org.este.resturant.entities.LigneCommande;

public class ResturantDaoImpl implements IResturantDao{
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void ajouterUser(User u) {
		em.persist(u);
	}

	@Override
	public Long ajouterAdmin(Admin a) {
		em.persist(a);
		return a.getIdAdmin();
	}

	@Override
	public Long ajouterCassier(Cassier ca) {
		em.persist(ca);
		return ca.getIdCassier();
	}

	@Override
	public Long ajouterCuisinier(Cuisinier cu) {
		em.persist(cu);
		return cu.getIdCuisinier();
	}

	@Override
	public Long ajouterServeur(Serveur s) {
		em.persist(s);
		return s.getIdServeur();
	}

	@Override
	public void modifierUser(User u) {
		em.merge(u);
	}

	@Override
	public void modifierAdmin(Admin a) {
		em.merge(a);
	}

	@Override
	public void modifeirCassier(Cassier ca) {
		em.merge(ca);
	}

	@Override
	public void modifierCuisinier(Cuisinier cu) {
		em.merge(cu);
	}

	@Override
	public void modifierServeur(Serveur s) {
		em.merge(s);
	}

	@Override
	public void supprimerUser(Long idUser) {
		User u = em.find(User.class, idUser);
		em.remove(u);
	}

	@Override
	public void supprimerAdmin(Long idAdmin) {
		Admin a = em.find(Admin.class, idAdmin);
		em.remove(a);
	}

	@Override
	public void supprimerCassier(Long idCass) {
		Cassier ca = em.find(Cassier.class, idCass);
		em.remove(ca);
	}

	@Override
	public void supprimerCuisinier(Long idCuis) {
		Cuisinier cu = em.find(Cuisinier.class, idCuis);
		em.remove(cu);
	}

	@Override
	public void supprimerServeur(Long idServ) {
		Serveur s = em.find(Serveur.class, idServ);
		em.remove(s);
	}

	@Override
	public List<User> listUsers() {
		Query req= em.createQuery("select u from User u");
		return req.getResultList();
	}

	@Override
	public List<Admin> listAdmins() {
		Query req= em.createQuery("select a from Admin a");
		return req.getResultList();
	}

	@Override
	public List<Cassier> listCassiers() {
		Query req= em.createQuery("select ca from Cassier ca");
		return req.getResultList();
	}

	@Override
	public List<Cuisinier> listCuisinier() {
		Query req= em.createQuery("select cu from Cuisinier cu");
		return req.getResultList();
	}

	@Override
	public List<Serveur> listServeurs() {
		Query req= em.createQuery("select s from Serveur s");
		return req.getResultList();
	}

	@Override
	public User getUser(Long idUser) {
		return em.find(User.class, idUser);
	}

	@Override
	public Admin getAdmin(Long idAdmin) {
		// TODO Auto-generated method stub
		return em.find(Admin.class, idAdmin);
	}

	@Override
	public Cassier getCassier(Long idCass) {
		// TODO Auto-generated method stub
		return em.find(Cassier.class, idCass);
	}

	@Override
	public Cuisinier getCuisinier(Long idCuis) {
		// TODO Auto-generated method stub
		return em.find(Cuisinier.class, idCuis);
	}

	@Override
	public Serveur getServeur(Long idServ) {
		// TODO Auto-generated method stub
		return em.find(Serveur.class, idServ);
	}

	@Override
	public Long ajouterCategorie(Categorie c) {
		em.persist(c);
		return c.getIdCategorie();
	}

	@Override
	public List<Categorie> listCategories() {
		Query req= em.createQuery("select c from Categorie c");
		return req.getResultList();
	}

	@Override
	public Categorie getCategorie(Long idCat) {
		// TODO Auto-generated method stub
		return em.find(Categorie.class, idCat);
	}

	@Override
	public void supprimerCategrorie(Long idcat) {
		Categorie c = em.find(Categorie.class, idcat);
		em.remove(c);
	}

	@Override
	public void modifierCategorie(Categorie c) {
		em.merge(c);
	}

	@Override
	public Long ajouterProduit(Produit p, Long idCat) {
		Categorie c = getCategorie(idCat);
		p.setCategorie(c);
		em.persist(p);
		return p.getIdProduit();
	}

	@Override
	public List<Produit> listproduits() {
		Query req= em.createQuery("select p from Produit p");
		return req.getResultList();
	}

	@Override
	public List<Produit> produitsParMotCle(String mc) {
		Query req= em.createQuery("select p from Produit p where p.nomProduit like :x or p.description like :x or p.prix like :x or p.categorie.nomCategorie like :x");
		req.setParameter("x", "%"+mc+"%");
		return req.getResultList();
	}

	@Override
	public List<Produit> produitsParCategorie(Long idCat) {
		Query req= em.createQuery("select p from Produit p where p.categorie.idCategorie=:x");
		req.setParameter("x", idCat);
		return req.getResultList();
	}

	@Override
	public List<Produit> produitsDisponible() {
		Query req= em.createQuery("select p from Produit p where p.etatProduit=true");
		return req.getResultList();
	}

	@Override
	public Produit getProduit(Long idProd) {
		// TODO Auto-generated method stub
		return em.find(Produit.class, idProd);
	}

	@Override
	public void supprimerProduit(Long idProd) {
		Produit p = getProduit(idProd);
		em.remove(p);
	}

	@Override
	public void modifierProduit(Produit p) {
		em.merge(p);
	}

	@Override
	public void attribuerRole(Role r, Long idUser) {
		User u = em.find(User.class, idUser);
		u.getRoles().add(r);
		em.persist(r);
	}

	@Override
	public Commande enregistrerCommande(Panier p, Client c) {
		if(em.find(Client.class, c.getIdClient()) == null){
			em.persist(c);
		}
		Commande cmd=new Commande();
		cmd.setClient(c);
		cmd.setEtatCommande("Non");
		cmd.setDateCommande(new Date());
		cmd.setItems(p.getItems());
		for(LigneCommande lc : p.getItems()){
			lc.setCommande(cmd);
			em.persist(lc);
		}
		em.persist(cmd);
		return cmd;
	}

	@Override
	public void ajouterTable(Tables t) {
		em.persist(t);
	}

	@Override
	public void modifierTable(Tables t) {
		em.merge(t);
	}

	@Override
	public void supprimerTable(Long idTable) {
		Tables t = em.find(Tables.class, idTable);
		em.remove(t);
	}

	@Override
	public List<Tables> listTables() {
		Query req= em.createQuery("select t from Tables t");
		return req.getResultList();
	}

	@Override
	public Tables getTable(Long idTable) {
		// TODO Auto-generated method stub
		return em.find(Tables.class, idTable);
	}

	@Override
	public List<Tables> tablesDisponible() {
		Query req= em.createQuery("select t from Tables t where t.etatTable=true");
		return req.getResultList();
	}

	@Override
	public List<Tables> tablesParMC(String mc) {
		Query req= em.createQuery("select t from Tables t where t.typeTable like :x");
		req.setParameter("x", "%"+mc+"%");
		return req.getResultList();
	}

	@Override
	public List<Commande> listCommande() {
		Query req= em.createQuery("select c from Commande c");
		return req.getResultList();
	}

	@Override
	public Commande getCommande(Long idCommande) {
		// TODO Auto-generated method stub
		return em.find(Commande.class,	idCommande);
	}

	@Override
	public void modifierCommande(Commande c) {
		em.merge(c);
	}

	@Override
	public void supprimerCommande(Long idCommande) {
		Commande c = getCommande(idCommande);
		em.remove(c);
	}

	@Override
	public List<Commande> listCommandeParServeur(Long idServ) {
		Query req= em.createQuery("select c from Commande c where c.serveur.idServeur =:x");
		req.setParameter("x", idServ);
		return req.getResultList();
	}

	@Override
	public List<LigneCommande> listLigneCommandeParCommande(Long idCommande) {
		Query req= em.createQuery("select l from LigneCommande l where l.commande.idCommande =:x");
		req.setParameter("x", idCommande);
		return req.getResultList();
	}

	@Override
	public List<Facture> listFactures() {
		Query req= em.createQuery("select f from Facture f");
		return req.getResultList();
	}

	@Override
	public List<Facture> listFactureParClient(Long idClient) {
		Query req= em.createQuery("select f from Facture f where f.client.idClient =:x");
		req.setParameter("x", idClient);
		return req.getResultList();
	}

	@Override
	public List<String> listEmailAdmins() {
		Query req= em.createQuery("select f.email from Admin f ");
		return req.getResultList();
	}

	@Override
	public List<Role> listRoles() {
		Query req= em.createQuery("select r from Role r ");
		return req.getResultList();
	}

	@Override
	public List<User> getUserParRoleEtEmailId(String role, Long idUtil) {
		Query req= em.createQuery("select u from User u where u.emailUserUtil =:x and u.nomroleUtil =:y");
		req.setParameter("x", idUtil);
		req.setParameter("y", role);
		return req.getResultList();
	}

	@Override
	public List<Serveur> serveursParMotCle(String mc) {
		Query req= em.createQuery("select s from Serveur s where s.nomServeur like :x or s.prenomServeur like :x or s.adresse like :x or s.tel like :x or s.email like :x or s.sexe like :x or s.salaire like :x");
		req.setParameter("x", "%"+mc+"%");
		return req.getResultList();
	}

	@Override
	public List<Cuisinier> cuisiniersParMotCle(String mc) {
		Query req= em.createQuery("select c from Cuisinier c where c.nomCuisinier like :x or c.prenomCuisinier like :x or c.adresse like :x or c.tel like :x or c.email like :x or c.sexe like :x or c.salaire like :x or c.grade like :x");
		req.setParameter("x", "%"+mc+"%");
		return req.getResultList();
	}

	@Override
	public List<Role> listeRolesParIdUser(Long idUser) {
		Query req= em.createQuery("select r from Role r where r.user.idUser =:x");
		req.setParameter("x", idUser);
		return req.getResultList();
	}

	@Override
	public void supprimerRolesParIdUser(Long idUser) {
		List<Role> lr = listeRolesParIdUser(idUser);
		for(Role r: lr){
			em.remove(r);
		}
	}

	@Override
	public List<Categorie> categoriesParMotCle(String mc) {
		Query req= em.createQuery("select c from Categorie c where c.nomCategorie like :x or c.description like :x");
		req.setParameter("x", "%"+mc+"%");
		return req.getResultList();
	}

	@Override
	public Long ajouterClient(Client c) {
		em.persist(c);
		return c.getIdClient();
	}

	@Override
	public Client getClient(Long idCl) {
		return em.find(Client.class, idCl);
	}

	@Override
	public Long ajouterFacture(Facture f) {
		em.persist(f);
		return f.getIdFacture();
	}

	@Override
	public void modifierFacture(Facture f) {
		em.merge(f);
	}

	@Override
	public List<Commande> listCommandeNoDisponible() {
		Query req= em.createQuery("select c from Commande c where c.etatCommande like :x");
		req.setParameter("x", "Non");
		return req.getResultList();
	}

	@Override
	public List<Commande> listCommandeDisponible() {
		Query req= em.createQuery("select c from Commande c where c.etatCommande like :x ");
		req.setParameter("x", "Oui");
		return req.getResultList();
	}

	@Override
	public List<Commande> listToutCommande() {
		Query req= em.createQuery("select c from Commande c ");
		return req.getResultList();
	}

	@Override
	public List<LigneCommande> listLigneCommandeParIdCommande(Long idComm) {
		Query req= em.createQuery("select lc from LigneCommande lc where lc.commande.idCommande =:x ");
		req.setParameter("x", idComm);
		return req.getResultList();
	}

	@Override
	public void supprimerLigneCommande(LigneCommande l) {
		em.remove(l);
	}

	@Override
	public List<Facture> getFactureParIdCommande(Long idComm) {
		Query req= em.createQuery("select f from Facture f where f.commande.idCommande =:x ");
		req.setParameter("x", idComm);
		return req.getResultList();
	}

	@Override
	public void supprimerFacture(Facture f) {
		em.remove(f);
	}

	@Override
	public List<Commande> commandesParMC(String mc) {
		Query req= em.createQuery("select c from Commande c where c.client.nomClient like :x or c.client.prenomClient like :x ");
		req.setParameter("x", "%"+mc+"%");
		return req.getResultList();
	}

	@Override
	public List<Facture> facturesParMotCle(String mc) {
		Query req= em.createQuery("select f from Facture f where f.client.nomClient like :x or f.client.prenomClient like :x or f.client.tel like :x ");
		req.setParameter("x", "%"+mc+"%");
		return req.getResultList();
	}

	@Override
	public List<User> getUserParNomEtPasse(String nom, String passe) {
		Query req= em.createQuery("select u from User u where u.login =:x and u.password =:y and u.actived = :w");
		req.setParameter("x", nom);
		req.setParameter("y", passe);
		req.setParameter("w", true);
		return req.getResultList();
	}

}
