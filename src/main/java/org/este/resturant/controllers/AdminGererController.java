package org.este.resturant.controllers;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.io.IOUtils;
import org.este.resturant.entities.Admin;
import org.este.resturant.entities.Cassier;
import org.este.resturant.entities.Categorie;
import org.este.resturant.entities.Client;
import org.este.resturant.entities.Commande;
import org.este.resturant.entities.Cuisinier;
import org.este.resturant.entities.Encryptor;
import org.este.resturant.entities.Facture;
import org.este.resturant.entities.LigneCommande;
import org.este.resturant.entities.Panier;
import org.este.resturant.entities.Produit;
import org.este.resturant.entities.Role;
import org.este.resturant.entities.Serveur;
import org.este.resturant.entities.User;
import org.este.resturant.entities.Utilisateur;
import org.este.resturant.metier.IAdminResturantMetier;
import org.hibernate.Session;
import org.junit.runner.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
@Controller
@RequestMapping(value="/adminGerer")
@SessionAttributes({"ObjetClient", "ObjetUser", "nomPrenom"})
public class AdminGererController implements HandlerExceptionResolver{
	@Autowired
	private IAdminResturantMetier metier;
	HttpServletRequest request;
	HttpSession session;
	Encryptor enc = new Encryptor();
	String key = "Bar12345Bar12345"; // 128 bit key
    String initVector = "RandomInitVector"; // 16 bytes IV
    String res = null;
    
    
    @RequestMapping(value="/Accueil")
	public String accueil(Model model){
    	if(model.asMap().get("ObjetUser")!=null){
    		
    		res = "accueil";
		}else{
			res = pageErrors(model);
		}
		return res;
    }
    
    @RequestMapping(value="/AccueilAd")
	public String accueilAd(Model model){
    	if(model.asMap().get("ObjetUser")!=null){
    		
    		res = "acctueilAd";
		}else{
			res = pageErrors(model);
		}
		return res;
    }
	//------------------Gestion des Categories------------------------
	//Pricipale Super-Admin categorie
	@RequestMapping(value="/pageAdminCat")
	public String pageCat(Model model){
		//virifierLogin(model)
		if(model.asMap().get("ObjetUser")!=null){
		model.addAttribute("categorie", new Categorie());
		model.addAttribute("categories", metier.listCategories());
		res = "AdminNvListCategorie";
		}else{
			res = pageErrors(model);
		}
		return res;
	}
	//Pricipale Admin categorie
	@RequestMapping(value="/pageAdminCatAd")
	public String pageCatAd(Model model){
		if(model.asMap().get("ObjetUser")!=null){
		model.addAttribute("categorie", new Categorie());
		model.addAttribute("categories", metier.listCategories());
		res= "AdminNvListCategorieAd";
		}else{
			res = pageErrors(model);
		}
		return res;
	}
	
	@RequestMapping(value="/saveCat")
	public String saveCat(@Valid Categorie c, BindingResult bindingResult,
			 Model model) throws IOException{
		if(model.asMap().get("ObjetUser")!=null){
		if(bindingResult.hasErrors()){
			model.addAttribute("categories", metier.listCategories());
			return "AdminNvListCategorie";
		}
		if(c.getIdCategorie()!=null)
			metier.modifierCategorie(c);
		else
		metier.ajouterCategorie(c);
		model.addAttribute("categorie", new Categorie());
		model.addAttribute("categories", metier.listCategories());
		res = "AdminNvListCategorie";
		}else{
			res = pageErrors(model);
		}
		return res;
	}
	
	@RequestMapping(value="/saveCatAd")
	public String saveCatAd(@Valid Categorie c, BindingResult bindingResult,
			 Model model) throws IOException{
		if(model.asMap().get("ObjetUser")!=null){
		if(bindingResult.hasErrors()){
			model.addAttribute("categories", metier.listCategories());
			return "AdminNvListCategorie";
		}
		if(c.getIdCategorie()!=null)
			metier.modifierCategorie(c);
		else
		metier.ajouterCategorie(c);
		model.addAttribute("categorie", new Categorie());
		model.addAttribute("categories", metier.listCategories());
		res = "AdminNvListCategorieAd";
		}else{
			res = pageErrors(model);
		}
		return res;
	}
	
	@RequestMapping(value="/suppCat")
	public String suppCat(Long idCat, Model model){
		if(model.asMap().get("ObjetUser")!=null){
		metier.supprimerCategrorie(idCat);
		model.addAttribute("categorie", new Categorie());
		model.addAttribute("categories", metier.listCategories());
		res = "AdminNvListCategorie";
		}else{
			res = pageErrors(model);
		}
		return res;
	}
	
	@RequestMapping(value="/suppCatAd")
	public String suppCatAd(Long idCat, Model model){
		if(model.asMap().get("ObjetUser")!=null){
		metier.supprimerCategrorie(idCat);
		model.addAttribute("categorie", new Categorie());
		model.addAttribute("categories", metier.listCategories());
		res = "AdminNvListCategorieAd";
		}else{
			res = pageErrors(model);
		}
		return res;
	}
	
	@RequestMapping(value="/editCat")
	public String editCat(Long idCat, Model model){
		if(model.asMap().get("ObjetUser")!=null){
		Categorie c = metier.getCategorie(idCat);
		
		model.addAttribute("categorie", c);
		model.addAttribute("categories", metier.listCategories());
		res = "AdminNvListCategorie";
		}else{
			res = pageErrors(model);
		}
		return res;
	}
	
	@RequestMapping(value="/editCatAd")
	public String editCatAd(Long idCat, Model model){
		if(model.asMap().get("ObjetUser")!=null){
		Categorie c = metier.getCategorie(idCat);
		
		model.addAttribute("categorie", c);
		model.addAttribute("categories", metier.listCategories());
		res = "AdminNvListCategorieAd";
		}else{
			res = pageErrors(model);
		}
		return res;
	}
	
	@RequestMapping(value="/CategorieRechercher")
	public String rechercherCat(HttpServletRequest request, Model model){
		if(model.asMap().get("ObjetUser")!=null){
		model.addAttribute("mcCat", request.getParameter("mcRechCat"));
		model.addAttribute("categorie", new Categorie());
		model.addAttribute("categories", metier.categoriesParMotCle(request.getParameter("mcRechCat")));
		res = "AdminNvListCategorie";
		}else{
			res = pageErrors(model);
		}
		return res;
	}
	
	@RequestMapping(value="/CategorieRechercherAd")
	public String rechercherCatAd(HttpServletRequest request, Model model){
		if(model.asMap().get("ObjetUser")!=null){
		model.addAttribute("mcCat", request.getParameter("mcRechCat"));
		model.addAttribute("categorie", new Categorie());
		model.addAttribute("categories", metier.categoriesParMotCle(request.getParameter("mcRechCat")));
		res = "AdminNvListCategorieAd";
		}else{
			res = pageErrors(model);
		}
		return res;
	}
	
	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object arg2,
			Exception ex) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("categorie", new Categorie());
		mv.addObject("categories", metier.listCategories());
		mv.addObject("exception", ex);
		//mv.setViewName(arg2.toString());
		return mv;
	}
	//------------------Gestion des Produits------------------------
	
	//Pricipale Super-Admin nouveau produit
	@RequestMapping(value="/pageAdminNvProd")
	public String pageAdminNvProduit(Model model){
		if(model.asMap().get("ObjetUser")!=null){
		model.addAttribute("produit", new Produit());
		model.addAttribute("categories", metier.listCategories());
		res = "AdminNvProduit";
		}else{
			res = pageErrors(model);
		}
		return res;
	}
	//Pricipale Admin nouveau produit
	@RequestMapping(value="/pageAdminNvProdAd")
	public String pageAdminNvProduitAd(Model model){
		if(model.asMap().get("ObjetUser")!=null){
		model.addAttribute("produit", new Produit());
		model.addAttribute("categories", metier.listCategories());
		res = "AdminNvProduitAd";
		}else{
			res = pageErrors(model);
		}
		return res;
	}
	//Pricipale Super-Admin list produit
	@RequestMapping(value="/pageAdminListProd")
	public String pageAdminListProduit(Model model){
		if(model.asMap().get("ObjetUser")!=null){
		model.addAttribute("produits", metier.listproduits());
		res = "AdminListProduit";
		}else{
			res = pageErrors(model);
		}
		return res;
	}
	//Pricipale Admin list produit
	@RequestMapping(value="/pageAdminListProdAd")
	public String pageAdminListProduitAd(Model model){
		if(model.asMap().get("ObjetUser")!=null){
		model.addAttribute("produits", metier.listproduits());
		res = "AdminListProduitAd";
		}else{
			res = pageErrors(model);
		}
		return res;
	}
	
	@RequestMapping(value="/saveProd")
	public String saveProd(@Valid Produit p, BindingResult bindingResult,
			 Model model, MultipartFile file) throws IOException{
		if(model.asMap().get("ObjetUser")!=null){
		if(bindingResult.hasErrors()){
			model.addAttribute("categories", metier.listCategories());
			return "AdminNvProduit";
		}
		if(!file.isEmpty()){
			BufferedImage bi = ImageIO.read(file.getInputStream());
			p.setPhoto(file.getBytes());
		}
		if(p.getIdProduit()!=null){
			if(file.isEmpty()){
				Produit prod = metier.getProduit(p.getIdProduit());
				p.setPhoto(prod.getPhoto());
			}
			metier.modifierProduit(p);
		}else
		metier.ajouterProduit(p, p.getCategorie().getIdCategorie());
		model.addAttribute("produit", new Produit());
		model.addAttribute("categories", metier.listCategories());
		res = "AdminNvProduit";
		}else{
			res = pageErrors(model);
		}
		return res;
	}
	
	@RequestMapping(value="/saveProdAd")
	public String saveProdAd(@Valid Produit p, BindingResult bindingResult,
			 Model model, MultipartFile file) throws IOException{
		if(model.asMap().get("ObjetUser")!=null){
		if(bindingResult.hasErrors()){
			model.addAttribute("categories", metier.listCategories());
			return "AdminNvProduitAd";
		}
		if(!file.isEmpty()){
			BufferedImage bi = ImageIO.read(file.getInputStream());
			p.setPhoto(file.getBytes());
		}
		if(p.getIdProduit()!=null){
			if(file.isEmpty()){
				Produit prod = metier.getProduit(p.getIdProduit());
				p.setPhoto(prod.getPhoto());
			}
			metier.modifierProduit(p);
		}else
		metier.ajouterProduit(p, p.getCategorie().getIdCategorie());
		model.addAttribute("produit", new Produit());
		model.addAttribute("categories", metier.listCategories());
		res = "AdminNvProduitAd";
		}else{
			res = pageErrors(model);
		}
		return res;
	}
	
	@RequestMapping(value="photoProd", produces=MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody
	public byte[] photoCat(Long idProd) throws IOException{
		Produit p = metier.getProduit(idProd);
		return IOUtils.toByteArray(new ByteArrayInputStream(p.getPhoto()));
	}
	
	@RequestMapping(value="/suppProd")
	public String suppProd(Long idProd, Model model){
		if(model.asMap().get("ObjetUser")!=null){
		metier.supprimerProduit(idProd);
		model.addAttribute("produits", metier.listproduits());
		res = "AdminListProduit";
		}else{
			res = pageErrors(model);
		}
		return res;
	}
	
	@RequestMapping(value="/suppProdAd")
	public String suppProdAd(Long idProd, Model model){
		if(model.asMap().get("ObjetUser")!=null){
		metier.supprimerProduit(idProd);
		model.addAttribute("produits", metier.listproduits());
		res = "AdminListProduitAd";
		}else{
			res = pageErrors(model);
		}
		return res;
	}
	
	@RequestMapping(value="/editProd")
	public String editProd(Long idProd, Model model){
		if(model.asMap().get("ObjetUser")!=null){
		Produit p = metier.getProduit(idProd);
		
		model.addAttribute("produit", p);
		model.addAttribute("categories", metier.listCategories());
		res = "AdminNvProduit";
		}else{
			res = pageErrors(model);
		}
		return res;
	}
	
	@RequestMapping(value="/editProdAd")
	public String editProdAd(Long idProd, Model model){
		if(model.asMap().get("ObjetUser")!=null){
		Produit p = metier.getProduit(idProd);
		
		model.addAttribute("produit", p);
		model.addAttribute("categories", metier.listCategories());
		res = "AdminNvProduitAd";
		}else{
			res = pageErrors(model);
		}
		return res;
	}
	
	@RequestMapping(value="/ProduitRechercher")
	public String rechercherProd(HttpServletRequest request, Model model){
		if(model.asMap().get("ObjetUser")!=null){
		model.addAttribute("mcProd", request.getParameter("mcRechProd"));
		model.addAttribute("produits", metier.produitsParMotCle(request.getParameter("mcRechProd")));
		res = "AdminListProduit";
		}else{
			res = pageErrors(model);
		}
		return res;
	}
	
	@RequestMapping(value="/ProduitRechercherAd")
	public String rechercherProdAd(HttpServletRequest request, Model model){
		if(model.asMap().get("ObjetUser")!=null){
		model.addAttribute("mcProd", request.getParameter("mcRechProd"));
		model.addAttribute("produits", metier.produitsParMotCle(request.getParameter("mcRechProd")));
		res = "AdminListProduitAd";
		}else{
			res = pageErrors(model);
		}
		return res;
	}
	//------------------Gestion des Commandes------------------------------
	
	//---------Debut de List des commande pour le cuisinier
	@RequestMapping(value="/pageAdminListCommCuis")
	public String pageAdminListCommCuisinier(Model model){
		if(model.asMap().get("ObjetUser")!=null){
		model.addAttribute("commandesC", metier.listCommandeNoDisponible());
		res = "AdminListCommandePourCuisinier";
		}else{
			res = pageErrors(model);
		}
		return res;
	}
	
	@RequestMapping(value="/DisponibiliteCom")
	public String disponibiliteCommandeCuis(Long idComm, Model model){
		if(model.asMap().get("ObjetUser")!=null){
		Commande c = metier.getCommande(idComm);
		c.setEtatCommande("Oui");
		metier.modifierCommande(c);
		model.addAttribute("commandesC", metier.listCommandeNoDisponible());
		res = "AdminListCommandePourCuisinier";
		}else{
			res = pageErrors(model);
		}
		return res;
	}
	
	@RequestMapping(value="/detailCom")
	public String detailCommande(Long idComm, Model model){
		if(model.asMap().get("ObjetUser")!=null){
		model.addAttribute("idComm", idComm);
		model.addAttribute("ListligneCommandes", metier.listLigneCommandeParIdCommande(idComm));
		res = "AdminDetailCommandeCuisinier";
		}else{
			res = pageErrors(model);
		}
		return res;
	}
	
	@RequestMapping(value="/RouteurListCommCuis")
	public String routeurPageListCommCuis(Model model){
		if(model.asMap().get("ObjetUser")!=null){
		model.addAttribute("commandesC", metier.listCommandeNoDisponible());
		res = "AdminListCommandePourCuisinier";
		}else{
			res = pageErrors(model);
		}
		return res;
	}
	
	//---------Fin de List des commande pour le cuisinier
	
	//---------------------------------------------------
	
	//---------Debut de List des commande pour le serveur
	
	@RequestMapping(value="/pageAdminListCommServ")
	public String pageAdminListCommServeur(Model model){
		if(model.asMap().get("ObjetUser")!=null){
		model.addAttribute("commandesS", metier.listCommandeDisponible());
		res = "AdminListCommandePourServeur";
		}else{
			res = pageErrors(model);
		}
		return res;
	}
	
	@RequestMapping(value="/DisponibiliteComServ")
	public String disponibiliteCommandeServ(Long idComm, Model model){
		if(model.asMap().get("ObjetUser")!=null){
		Commande c = metier.getCommande(idComm);
		c.setEtatCommande("Passe");
		metier.modifierCommande(c);
		model.addAttribute("commandesS", metier.listCommandeDisponible());
		res = "AdminListCommandePourServeur";
		}else{
			res = pageErrors(model);
		}
		return res;
	}
	
	@RequestMapping(value="/detailComServ")
	public String detailCommandeServ(Long idComm, Model model){
		if(model.asMap().get("ObjetUser")!=null){
		model.addAttribute("idComm", idComm);
		model.addAttribute("ListligneCommandes", metier.listLigneCommandeParIdCommande(idComm));
		res = "AdminDetailCommandeServeur";
		}else{
			res = pageErrors(model);
		}
		return res;
	}
	
	@RequestMapping(value="/RouteurListCommServ")
	public String routeurPageListCommServ(Model model){
		if(model.asMap().get("ObjetUser")!=null){
		model.addAttribute("commandesS", metier.listCommandeDisponible());
		res = "AdminListCommandePourServeur";
		}else{
			res = pageErrors(model);
		}
		return res;
	}
	
	//---------Fin de List des commande pour le serveur
	
	Panier pan;
	//Principale Super-Admin Nouveau Commande
	@RequestMapping(value="/pageAdminNvComm")
	public String pageAdminNvCommandes(Model model){
		if(model.asMap().get("ObjetUser")!=null){
		model.addAttribute("client", new Client());
		pan = new Panier();
		res = "AdminNvCommandeFormClient";
		}else{
			res = pageErrors(model);
		}
		return res;
	}
	//Principale Serveur Nouveau Commande
	@RequestMapping(value="/pageAdminNvCommSer")
	public String pageAdminNvCommandesServeur(Model model){
		if(model.asMap().get("ObjetUser")!=null){
		model.addAttribute("client", new Client());
		pan = new Panier();
		res = "AdminNvCommandeFormClientSer";
		}else{
			res = pageErrors(model);
		}
		return res;
	}
	
	@RequestMapping(value="/confirmerEnregistrerPanier")
	public String confirmerPanier(Model model){
		if(model.asMap().get("ObjetUser")!=null){
		Client c = (Client) model.asMap().get("ObjetClient");
		Commande cmd =metier.enregistrerCommande(pan, c);
		//la facture
		Facture f = new Facture();
		f.setClient(c);
		f.setCommande(cmd);
		f.setDateFacture(new Date());
		f.setTotal(pan.getTotal());
		metier.ajouterFacture(f);
		pan = new Panier();
		model.addAttribute("client", new Client());
		res = "AdminNvCommandeFormClient";
		}else{
			res = pageErrors(model);
		}
		return res;
	}
	
	@RequestMapping(value="/confirmerEnregistrerPanierSer")
	public String confirmerPanierServeur(Model model){
		if(model.asMap().get("ObjetUser")!=null){
		Client c = (Client) model.asMap().get("ObjetClient");
		Commande cmd =metier.enregistrerCommande(pan, c);
		//la facture
		Facture f = new Facture();
		f.setClient(c);
		f.setCommande(cmd);
		f.setDateFacture(new Date());
		f.setTotal(pan.getTotal());
		metier.ajouterFacture(f);
		pan = new Panier();
		model.addAttribute("client", new Client());
		res = "AdminNvCommandeFormClientSer";
		}else{
			res = pageErrors(model);
		}
		return res;
	}
	
	@RequestMapping(value="/pageAdminListProdPanier")
	public String pageAdminListProduitPanier(Model model){
		if(model.asMap().get("ObjetUser")!=null){
		model.addAttribute("produits", metier.produitsDisponible());
		res = "AdminNvCommandeListProd";
		}else{
			res = pageErrors(model);
		}
		return res;
	}
	
	@RequestMapping(value="/saveCl")
	public String saveClient(@Valid Client c, BindingResult bindingResult,
			 Model model) throws IOException{
		if(model.asMap().get("ObjetUser")!=null){
		if(bindingResult.hasErrors()){
			return "AdminNvCommandeFormClient";
		}
		metier.ajouterClient(c);
		model.addAttribute("ObjetClient", c);
		model.addAttribute("produits", metier.produitsDisponible());
		res = "AdminNvCommandeListProd";
		}else{
			res = pageErrors(model);
		}
		return res;
	}
	
	@RequestMapping(value="/saveClSer")
	public String saveClientServeur(@Valid Client c, BindingResult bindingResult,
			 Model model) throws IOException{
		if(model.asMap().get("ObjetUser")!=null){
		if(bindingResult.hasErrors()){
			return "AdminNvCommandeFormClientSer";
		}
		metier.ajouterClient(c);
		model.addAttribute("ObjetClient", c);
		model.addAttribute("produits", metier.produitsDisponible());
		res = "AdminNvCommandeListProdServeur";
		}else{
			res = pageErrors(model);
		}
		return res;
	}
	
	@RequestMapping(value="/ProduitCommandRechercher")
	public String rechercherProdCommande(HttpServletRequest request, Model model){
		if(model.asMap().get("ObjetUser")!=null){
		model.addAttribute("mcProd", request.getParameter("mcRechProd"));
		model.addAttribute("produits", metier.produitsParMotCle(request.getParameter("mcRechProd")));
		res = "AdminNvCommandeListProd";
		}else{
			res = pageErrors(model);
		}
		return res;
	}
	
	@RequestMapping(value="/ProduitCommandRechercherSer")
	public String rechercherProdCommandeServeur(HttpServletRequest request, Model model){
		if(model.asMap().get("ObjetUser")!=null){
		model.addAttribute("mcProd", request.getParameter("mcRechProd"));
		model.addAttribute("produits", metier.produitsParMotCle(request.getParameter("mcRechProd")));
		res = "AdminNvCommandeListProdServeur";
		}else{
			res = pageErrors(model);
		}
		return res;
	}
	
	
	@RequestMapping(value="/ajouterPanier")
	public String ajouterPanier(Long idProd, Model model){
		if(model.asMap().get("ObjetUser")!=null){
		Produit p = metier.getProduit(idProd);
		pan.addArticle(p, 1);
		model.addAttribute("sizePanier", "Ajouter "+pan.getSize()+" Produits avec succées");
		model.addAttribute("produits", metier.produitsDisponible());
		res = "AdminNvCommandeListProd";
		}else{
			res = pageErrors(model);
		}
		return res;
	}
	
	@RequestMapping(value="/ajouterPanierSer")
	public String ajouterPanierServeur(Long idProd, Model model){
		if(model.asMap().get("ObjetUser")!=null){
		Produit p = metier.getProduit(idProd);
		pan.addArticle(p, 1);
		model.addAttribute("sizePanier", "Ajouter "+pan.getSize()+" Produits avec succées");
		model.addAttribute("produits", metier.produitsDisponible());
		res = "AdminNvCommandeListProdServeur";
		}else{
			res = pageErrors(model);
		}
		return res;
	}
	
	@RequestMapping(value="/RouteurPanier")
	public String routeurPanier(Model model){
		if(model.asMap().get("ObjetUser")!=null){
		model.addAttribute("sizePanier", "Ajouter "+pan.getSize()+" Produits avec succées");
		model.addAttribute("produits", metier.produitsDisponible());
		res = "AdminNvCommandeListProd";
		}else{
			res = pageErrors(model);
		}
		return res;
	}
	
	@RequestMapping(value="/RouteurPanierSer")
	public String routeurPanierServeur(Model model){
		if(model.asMap().get("ObjetUser")!=null){
		model.addAttribute("sizePanier", "Ajouter "+pan.getSize()+" Produits avec succées");
		model.addAttribute("produits", metier.produitsDisponible());
		res = "AdminNvCommandeListProdServeur";
		}else{
			res = pageErrors(model);
		}
		return res;
	}
	
	@RequestMapping(value="/consulterPanier")
	public String consulterPanier(Model model){
		if(model.asMap().get("ObjetUser")!=null){
		Client c = (Client) model.asMap().get("ObjetClient");
		model.addAttribute("NomClient", c.getNomClient()+" "+c.getPrenomClient());
		model.addAttribute("total", "Le prix total : "+pan.getTotal()+" DH");
		model.addAttribute("ligneCommande", pan.getItems());
		res = "AdminNvCommandeConsultPanier";
		}else{
			res = pageErrors(model);
		}
		return res;
	}
	
	@RequestMapping(value="/consulterPanierSer")
	public String consulterPanierServeur(Model model){
		if(model.asMap().get("ObjetUser")!=null){
		Client c = (Client) model.asMap().get("ObjetClient");
		model.addAttribute("NomClient", c.getNomClient()+" "+c.getPrenomClient());
		model.addAttribute("total", "Le prix total : "+pan.getTotal()+" DH");
		model.addAttribute("ligneCommande", pan.getItems());
		res = "AdminNvCommandeConsultPanierServeur";
		}else{
			res = pageErrors(model);
		}
		return res;
	}
	
	@RequestMapping(value="/suppProdPanier")
	public String suppProdPanier(Long idProd, Model model){
		if(model.asMap().get("ObjetUser")!=null){
		pan.deleteItems(idProd);
		model.addAttribute("total", "Le prix total : "+pan.getTotal()+" DH");
		model.addAttribute("ligneCommande", pan.getItems());
		res = "AdminNvCommandeConsultPanier";
		}else{
			res = pageErrors(model);
		}
		return res;
	}
	
	@RequestMapping(value="/suppProdPanierSer")
	public String suppProdPanierServeur(Long idProd, Model model){
		if(model.asMap().get("ObjetUser")!=null){
		pan.deleteItems(idProd);
		model.addAttribute("total", "Le prix total : "+pan.getTotal()+" DH");
		model.addAttribute("ligneCommande", pan.getItems());
		res = "AdminNvCommandeConsultPanierServeur";
		}else{
			res = pageErrors(model);
		}
		return res;
	}
	
	//Pricipale Super-Admin list commandes
	@RequestMapping(value="/listToutCommande")
	public String listToutCommande(Model model){
		if(model.asMap().get("ObjetUser")!=null){
		model.addAttribute("toutCommandes", metier.listToutCommande());
		res = "AdminListToutCommande";
		}else{
			res = pageErrors(model);
		}
		return res;
	}
	
	//Pricipale Admin list commandes
		@RequestMapping(value="/listToutCommandeAd")
		public String listToutCommandeAd(Model model){
			if(model.asMap().get("ObjetUser")!=null){
			model.addAttribute("toutCommandes", metier.listToutCommande());
			res = "AdminListToutCommandeAd";
			}else{
				res = pageErrors(model);
			}
			return res;
		}
	
	@RequestMapping(value="/suppComm")
	public String suppCommande(Long idComm, Model model){
		if(model.asMap().get("ObjetUser")!=null){
		for(Facture f : metier.getFactureParIdCommande(idComm)){
			metier.supprimerFacture(f);
		}
		for(LigneCommande l : metier.listLigneCommandeParIdCommande(idComm)){
			metier.supprimerLigneCommande(l);
		}
		
		metier.supprimerCommande(idComm);
		model.addAttribute("toutCommandes", metier.listToutCommande());
		res = "AdminListToutCommande";
		}else{
			res = pageErrors(model);
		}
		return res;
	}
	
	@RequestMapping(value="/suppCommAd")
	public String suppCommandeAd(Long idComm, Model model){
		if(model.asMap().get("ObjetUser")!=null){
		for(Facture f : metier.getFactureParIdCommande(idComm)){
			metier.supprimerFacture(f);
		}
		for(LigneCommande l : metier.listLigneCommandeParIdCommande(idComm)){
			metier.supprimerLigneCommande(l);
		}
		
		metier.supprimerCommande(idComm);
		model.addAttribute("toutCommandes", metier.listToutCommande());
		res = "AdminListToutCommandeAd";
		}else{
			res = pageErrors(model);
		}
		return res;
	}
	
	@RequestMapping(value="/CommandeRechercher")
	public String rechercherCommande(HttpServletRequest request, Model model){
		if(model.asMap().get("ObjetUser")!=null){
		model.addAttribute("mcComm", request.getParameter("mcRechComm"));
		model.addAttribute("toutCommandes", metier.commandesParMC(request.getParameter("mcRechComm")));
		res = "AdminListToutCommande";
		}else{
			res = pageErrors(model);
		}
		return res;
	}
	
	@RequestMapping(value="/CommandeRechercherAd")
	public String rechercherCommandeAd(HttpServletRequest request, Model model){
		if(model.asMap().get("ObjetUser")!=null){
		model.addAttribute("mcComm", request.getParameter("mcRechComm"));
		model.addAttribute("toutCommandes", metier.commandesParMC(request.getParameter("mcRechComm")));
		res = "AdminListToutCommandeAd";
		}else{
			res = pageErrors(model);
		}
		return res;
	}
	
	@RequestMapping(value="/detailComSuper")
	public String detailCommandeSuper(Long idComm, Model model){
		if(model.asMap().get("ObjetUser")!=null){
		model.addAttribute("idComm", idComm);
		model.addAttribute("ListligneCommandes", metier.listLigneCommandeParIdCommande(idComm));
		res = "AdminDetailCommandeSuperAd";
		}else{
			res = pageErrors(model);
		}
		return res;
	}
	
	@RequestMapping(value="/detailComAd")
	public String detailCommandeSuperAd(Long idComm, Model model){
		if(model.asMap().get("ObjetUser")!=null){
		model.addAttribute("idComm", idComm);
		model.addAttribute("ListligneCommandes", metier.listLigneCommandeParIdCommande(idComm));
		res = "AdminDetailCommandeSuperAdAd";
		}else{
			res = pageErrors(model);
		}
		return res;
	}
	
	@RequestMapping(value="/RouteurListCommSuper")
	public String routeurPageListCommSuperAdAd(Model model){
		if(model.asMap().get("ObjetUser")!=null){
		model.addAttribute("toutCommandes", metier.listToutCommande());
		res = "AdminListToutCommande";
		}else{
			res = pageErrors(model);
		}
		return res;
	}
	
	@RequestMapping(value="/RouteurListCommAd")
	public String routeurPageListCommSuperAd(Model model){
		if(model.asMap().get("ObjetUser")!=null){
		model.addAttribute("toutCommandes", metier.listToutCommande());
		res = "AdminListToutCommandeAd";
		}else{
			res = pageErrors(model);
		}
		return res;
	}
	
	
	//------------------Gestion des Admins---------------------------------
		
		
		@RequestMapping(value="/pageSuperAdmin")
		public String pageAdmin(Model model){
			if(model.asMap().get("ObjetUser")!=null){
			model.addAttribute("admin", new Admin());
			model.addAttribute("admins", metier.listAdmins());
			res = "SuperAdminNvListAdmin";
			}else{
				res = pageErrors(model);
			}
			return res;
		}
		
	
		@RequestMapping(value="/saveAd")
		public String saveAd(@Valid Admin a, BindingResult bindingResult,
				 Model model) throws IOException{
			if(model.asMap().get("ObjetUser")!=null){
			if(bindingResult.hasErrors()){
				model.addAttribute("admins", metier.listAdmins());
				return "SuperAdminNvListAdmin";
			}
			//virifier saveAdmin
			if(a.getIdAdmin()!=null)
				metier.modifierAdmin(a);
			else
			metier.ajouterAdmin(a);
			model.addAttribute("admin", new Admin());
			model.addAttribute("admins", metier.listAdmins());
			res = "SuperAdminNvListAdmin";
			}else{
				res = pageErrors(model);
			}
			return res;
		}
		
		@RequestMapping(value="/suppAd")
		public String suppAd(Long idAd, Model model){
			if(model.asMap().get("ObjetUser")!=null){
			metier.supprimerAdmin(idAd);
			model.addAttribute("admin", new Admin());
			model.addAttribute("admins", metier.listAdmins());
			res = "SuperAdminNvListAdmin";
			}else{
				res = pageErrors(model);
			}
			return res;
		}
		
		@RequestMapping(value="/editAd")
		public String editAd(Long idAd, Model model){
			if(model.asMap().get("ObjetUser")!=null){
			Admin a = metier.getAdmin(idAd);
			
			model.addAttribute("admin", a);
			model.addAttribute("admins", metier.listAdmins());
			res = "SuperAdminNvListAdmin";
			}else{
				res = pageErrors(model);
			}
			return res;
		}
		//------------------Gestion des Caissier----------------------------
		
		@RequestMapping(value="/pageSuperAdminCa")
		public String pageSuperAdminCassier(Model model){
			if(model.asMap().get("ObjetUser")!=null){
			model.addAttribute("cassier", new Cassier());
			model.addAttribute("cassiers", metier.listCassiers());
			res = "SuperAdminNvListCassier";
			}else{
				res = pageErrors(model);
			}
			return res;
		}
	
		@RequestMapping(value="/saveCa")
		public String saveCa(@Valid Cassier ca, BindingResult bindingResult,
				 Model model) throws IOException{
			if(model.asMap().get("ObjetUser")!=null){
			if(bindingResult.hasErrors()){
				model.addAttribute("cassiers", metier.listCassiers());
				return "SuperAdminNvListCassier";
			}
			//virifier saveAdmin
			if(ca.getIdCassier()!=null)
				metier.modifeirCassier(ca);
			else
			metier.ajouterCassier(ca);
			model.addAttribute("cassier", new Cassier());
			model.addAttribute("cassiers", metier.listCassiers());
			res = "SuperAdminNvListCassier";
			}else{
				res = pageErrors(model);
			}
			return res;
		}
		
		@RequestMapping(value="/suppCa")
		public String suppCa(Long idCa, Model model){
			if(model.asMap().get("ObjetUser")!=null){
			metier.supprimerCassier(idCa);
			model.addAttribute("cassier", new Cassier());
			model.addAttribute("cassiers", metier.listCassiers());
			res = "SuperAdminNvListCassier";
			}else{
				res = pageErrors(model);
			}
			return res;
		}
		
		@RequestMapping(value="/editCa")
		public String editCa(Long idCa, Model model){
			if(model.asMap().get("ObjetUser")!=null){
			Cassier ca = metier.getCassier(idCa);
			
			model.addAttribute("cassier", ca);
			model.addAttribute("cassiers", metier.listCassiers());
			res = "SuperAdminNvListCassier";
			}else{
				res = pageErrors(model);
			}
			return res;
		}
		//------------------Gestion des Serveurs------------------------------
		
		@RequestMapping(value="/pageSuperAdminSeN")
		public String pageSuperAdminServeurNv(Model model){
			if(model.asMap().get("ObjetUser")!=null){
			model.addAttribute("serveur", new Serveur());
			model.addAttribute("serveurs", metier.listServeurs());
			res = "SuperAdminNvServeur";
			}else{
				res = pageErrors(model);
			}
			return res;
		}
		
		@RequestMapping(value="/pageSuperAdminSeL")
		public String pageSuperAdminServeurList(Model model){
			if(model.asMap().get("ObjetUser")!=null){
			model.addAttribute("serveur", new Serveur());
			model.addAttribute("serveurs", metier.listServeurs());
			res = "SuperAdminListServeur";
			}else{
				res = pageErrors(model);
			}
			return res;
		}
		
		@RequestMapping(value="/saveSe")
		public String saveSe(@Valid Serveur se, BindingResult bindingResult,
				 Model model) throws IOException{
			if(model.asMap().get("ObjetUser")!=null){
			if(bindingResult.hasErrors()){
				model.addAttribute("serveurs", metier.listServeurs());
				return "SuperAdminNvServeur";
			}
			boolean bol=false;
			//virifier saveAdmin
			if(se.getIdServeur()!=null){
				metier.modifierServeur(se);
				bol=true;
			}else{
			metier.ajouterServeur(se);
				bol=false;
			}
			model.addAttribute("serveur", new Serveur());
			model.addAttribute("serveurs", metier.listServeurs());
			if(bol==true){
				res = "SuperAdminListServeur";
			}else{
				res = "SuperAdminNvServeur";
			}
			}else{
				res = pageErrors(model);
			}
			return res;
		}
		
		@RequestMapping(value="/suppSe")
		public String suppSe(Long idSe, Model model){
			if(model.asMap().get("ObjetUser")!=null){
			metier.supprimerServeur(idSe);
			model.addAttribute("serveur", new Serveur());
			model.addAttribute("serveurs", metier.listServeurs());
			res = "SuperAdminListServeur";
			}else{
				res = pageErrors(model);
			}
			return res;
		}
		
		@RequestMapping(value="/editSe")
		public String editSe(Long idSe, Model model){
			if(model.asMap().get("ObjetUser")!=null){
			Serveur se = metier.getServeur(idSe);
			model.addAttribute("serveur", se);
			model.addAttribute("serveurs", metier.listServeurs());
			res = "SuperAdminNvServeur";
			}else{
				res = pageErrors(model);
			}
			return res;
		}
		
		@RequestMapping(value="/ServeurRechercher")
		public String rechercherSe(HttpServletRequest request, Model model){
			if(model.asMap().get("ObjetUser")!=null){
			model.addAttribute("mc", request.getParameter("mcRech"));
			model.addAttribute("serveurs", metier.serveursParMotCle(request.getParameter("mcRech")));
			res = "SuperAdminListServeur";
			}else{
				res = pageErrors(model);
			}
			return res;
		}
		
		//------------------Gestion des Cuisiniers------------------------------
		@RequestMapping(value="/pageSuperAdminCuN")
		public String pageSuperAdminCuisinierNv(Model model){
			if(model.asMap().get("ObjetUser")!=null){
			model.addAttribute("cuisinier", new Cuisinier());
			model.addAttribute("cuisiniers", metier.listCuisinier());
			res = "SuperAdminNvCuisinier";
			}else{
				res = pageErrors(model);
			}
			return res;
		}
		
		@RequestMapping(value="/pageSuperAdminCuL")
		public String pageSuperAdminCuisinierList(Model model){
			if(model.asMap().get("ObjetUser")!=null){
			model.addAttribute("cuisiniers", metier.listCuisinier());
			res = "SuperAdminListCuisinier";
			}else{
				res = pageErrors(model);
			}
			return res;
		}
		
		@RequestMapping(value="/saveCu")
		public String saveCu(@Valid Cuisinier c, BindingResult bindingResult,
				 Model model) throws IOException{
			if(model.asMap().get("ObjetUser")!=null){
			if(bindingResult.hasErrors()){
				//model.addAttribute("cuisiniers", metier.listCuisinier());
				return "SuperAdminNvCuisinier";
			}
			boolean bol=false;
			//virifier saveAdmin
			if(c.getIdCuisinier()!=null){
				metier.modifierCuisinier(c);
				bol=true;
			}else{
			metier.ajouterCuisinier(c);
				bol=false;
			}
			model.addAttribute("cuisinier", new Cuisinier());
			model.addAttribute("cuisiniers", metier.listCuisinier());
			if(bol==true){
				res = "SuperAdminListCuisinier";
			}else{
				res = "SuperAdminNvCuisinier";
			}
			}else{
				res = pageErrors(model);
			}
			return res;
		}
		
		@RequestMapping(value="/suppCu")
		public String suppCu(Long idCu, Model model){
			if(model.asMap().get("ObjetUser")!=null){
			metier.supprimerCuisinier(idCu);
			model.addAttribute("cuisinier", new Cuisinier());
			model.addAttribute("cuisiniers", metier.listCuisinier());
			res = "SuperAdminListCuisinier";
			}else{
				res = pageErrors(model);
			}
			return res;
		}
		
		@RequestMapping(value="/editCu")
		public String editCu(Long idCu, Model model){
			if(model.asMap().get("ObjetUser")!=null){
			Cuisinier c = metier.getCuisinier(idCu);
			model.addAttribute("cuisinier", c);
			model.addAttribute("cuisiniers", metier.listCuisinier());
			res = "SuperAdminNvCuisinier";
			}else{
				res = pageErrors(model);
			}
			return res;
		}
		
		@RequestMapping(value="/CuisinierRechercher")
		public String rechercherCu(HttpServletRequest request, Model model){
			if(model.asMap().get("ObjetUser")!=null){
			model.addAttribute("mcCu", request.getParameter("mcRechCu"));
			model.addAttribute("cuisiniers", metier.cuisiniersParMotCle(request.getParameter("mcRechCu")));
			res = "SuperAdminListCuisinier";
			}else{
				res = pageErrors(model);
			}
			return res;
		}
		//------------------Gestion des Utilisateurs---------------------------------
		
		@RequestMapping(value="/pageSuperAdminUtilisateur")
		public String pageUtilisateur(Model model){
			if(model.asMap().get("ObjetUser")!=null){
			model.addAttribute("user", new User());
			model.addAttribute("utilisateurs", metier.ListEmailUtilisateurs());
			model.addAttribute("listUtilisateurs", metier.AffichlistUsers());
			res = "SuperAdminNvListUtilisateurs";
			}else{
				res = pageErrors(model);
			}
			return res;
		}
		
		@RequestMapping(value="/saveUs")
		public String saveUs(@Valid User u, BindingResult bindingResult,
				 Model model) throws IOException{
			if(model.asMap().get("ObjetUser")!=null){
			
			if(bindingResult.hasErrors()){
				model.addAttribute("utilisateurs", metier.ListEmailUtilisateurs());
				model.addAttribute("listUtilisateurs", metier.AffichlistUsers());
				return "SuperAdminNvListUtilisateurs";
			}
			//Problems
			
			if(u.getIdUser()!=null){
				if(u.getNomroleUtil().equals("ROLE_ADMIN_GERER")){
					u.setPasswordByte(enc.encrypt(key, initVector, u.getPassword()));
					u.setPassword(null);
					Admin a = metier.getAdmin(u.getEmailUserUtil());
					u.setNomPrenomUtil(a.getEmail());
					u.setAdmin(a);
					metier.modifierUser(u);
				}else if(u.getNomroleUtil().equals("ROLE_ADMIN_CAISSIER")){
					u.setPasswordByte(enc.encrypt(key, initVector, u.getPassword()));
					u.setPassword(null);
					Cassier ca = metier.getCassier(u.getEmailUserUtil());
					u.setNomPrenomUtil(ca.getEmail());
					u.setCassier(ca);
					metier.modifierUser(u);
				}else if(u.getNomroleUtil().equals("ROLE_ADMIN_SERVEUR")){
					u.setPasswordByte(enc.encrypt(key, initVector, u.getPassword()));
					u.setPassword(null);
					Serveur s = metier.getServeur(u.getEmailUserUtil());
					u.setNomPrenomUtil(s.getEmail());
					u.setServeur(s);
					metier.modifierUser(u);
				}else if(u.getNomroleUtil().equals("ROLE_ADMIN_CUISINIER")){
					u.setPasswordByte(enc.encrypt(key, initVector, u.getPassword()));
					u.setPassword(null);
					Cuisinier cu = metier.getCuisinier(u.getEmailUserUtil());
					u.setNomPrenomUtil(cu.getEmail());
					u.setCuisinier(cu);
					metier.modifierUser(u);
				}
			}
			else{
				if(u.getNomroleUtil().equals("ROLE_ADMIN_GERER")){
					u.setPasswordByte(enc.encrypt(key, initVector, u.getPassword()));
					u.setPassword(null);
					Admin a = metier.getAdmin(u.getEmailUserUtil());
					u.setNomPrenomUtil(a.getEmail());
					u.setAdmin(a);
					metier.ajouterUser(u);
				}else if(u.getNomroleUtil().equals("ROLE_ADMIN_CAISSIER")){
					u.setPasswordByte(enc.encrypt(key, initVector, u.getPassword()));
					u.setPassword(null);
					Cassier ca = metier.getCassier(u.getEmailUserUtil());
					u.setNomPrenomUtil(ca.getEmail());
					u.setCassier(ca);
					metier.ajouterUser(u);
				}else if(u.getNomroleUtil().equals("ROLE_ADMIN_SERVEUR")){
					u.setPasswordByte(enc.encrypt(key, initVector, u.getPassword()));
					u.setPassword(null);
					Serveur s = metier.getServeur(u.getEmailUserUtil());
					u.setNomPrenomUtil(s.getEmail());
					u.setServeur(s);
					metier.ajouterUser(u);
				}else if(u.getNomroleUtil().equals("ROLE_ADMIN_CUISINIER")){
					u.setPasswordByte(enc.encrypt(key, initVector, u.getPassword()));
					u.setPassword(null);
					Cuisinier cu = metier.getCuisinier(u.getEmailUserUtil());
					u.setNomPrenomUtil(cu.getEmail());
					u.setCuisinier(cu);
					metier.ajouterUser(u);
				}
				User ur = metier.getUserDansListParRoleEtEmailId(u.getNomroleUtil(),u.getEmailUserUtil());
				metier.attribuerRole(new Role(u.getNomroleUtil()), ur.getIdUser());
			}
			
			model.addAttribute("user", new User());
			model.addAttribute("utilisateurs", metier.ListEmailUtilisateurs());
			model.addAttribute("listUtilisateurs", metier.AffichlistUsers());
			res = "SuperAdminNvListUtilisateurs";
			}else{
				res = pageErrors(model);
			}
			return res;
		}
		
		@RequestMapping(value="/suppUs")
		public String suppUs(Long idUs, Model model){
			if(model.asMap().get("ObjetUser")!=null){
			metier.supprimerUser(idUs);
			model.addAttribute("user", new User());
			model.addAttribute("utilisateurs", metier.ListEmailUtilisateurs());
			model.addAttribute("listUtilisateurs", metier.AffichlistUsers());
			res = "SuperAdminNvListUtilisateurs";
			}else{
				res = pageErrors(model);
			}
			return res;
		}
		
		@RequestMapping(value="/editUs")
		public String editUs(Long idUs, Model model){
			if(model.asMap().get("ObjetUser")!=null){
			User u = metier.getUser(idUs);
			u.setPassword(enc.decrypt(key, initVector, u.getPasswordByte()));
			model.addAttribute("user", u);
			model.addAttribute("utilisateurs", metier.ListEmailUtilisateurs());
			model.addAttribute("listUtilisateurs", metier.AffichlistUsers());
			res = "SuperAdminNvListUtilisateurs";
			}else{
				res = pageErrors(model);
			}
			return res;
		}
		//------------------Gestion des factures---------------------------------
		
		//Principale Super-Admin factures
		@RequestMapping(value="/pageSuperAdminListFactures")
		public String pageFactures(Model model){
			if(model.asMap().get("ObjetUser")!=null){
			model.addAttribute("factures", metier.listFactures());
			res = "SuperAdminListFactures";
			}else{
				res = pageErrors(model);
			}
			return res;
		}
		
		@RequestMapping(value="/detailComSuperFact")
		public String detailCommandeSuperFacture(Long idComm, Model model){
			if(model.asMap().get("ObjetUser")!=null){
			model.addAttribute("idComm", idComm);
			model.addAttribute("ListligneCommandes", metier.listLigneCommandeParIdCommande(idComm));
			res = "AdminDetailCommandeSuperAdFactures";
			}else{
				res = pageErrors(model);
			}
			return res;
		}
		
		@RequestMapping(value="/routeurSuperListFactures")
		public String routeurSuperListFactures(Model model){
			if(model.asMap().get("ObjetUser")!=null){
			model.addAttribute("factures", metier.listFactures());
			res = "SuperAdminListFactures";
			}else{
				res = pageErrors(model);
			}
			return res;
		}
		
		@RequestMapping(value="/FacturesRechercher")
		public String rechercherFactures(HttpServletRequest request, Model model){
			if(model.asMap().get("ObjetUser")!=null){
			model.addAttribute("mc", request.getParameter("mcRech"));
			model.addAttribute("factures", metier.facturesParMotCle(request.getParameter("mcRech")));
			res = "SuperAdminListFactures";
			}else{
				res = pageErrors(model);
			}
			return res;
		}
		//Principale Admin factures
		@RequestMapping(value="/pageSuperAdminListFacturesAd")
		public String pageFacturesAd(Model model){
			if(model.asMap().get("ObjetUser")!=null){
			model.addAttribute("factures", metier.listFactures());
			res = "SuperAdminListFacturesAd";
			}else{
				res = pageErrors(model);
			}
			return res;
		}

		@RequestMapping(value="/detailComSuperFactAd")
		public String detailCommandeSuperFactureAd(Long idComm, Model model){
			if(model.asMap().get("ObjetUser")!=null){
			model.addAttribute("idComm", idComm);
			model.addAttribute("ListligneCommandes", metier.listLigneCommandeParIdCommande(idComm));
			res = "AdminDetailCommandeSuperAdFacturesAd";
			}else{
				res = pageErrors(model);
			}
			return res;
		}
		
		@RequestMapping(value="/routeurSuperListFacturesAd")
		public String routeurSuperListFacturesAd(Model model){
			if(model.asMap().get("ObjetUser")!=null){
			model.addAttribute("factures", metier.listFactures());
			res = "SuperAdminListFacturesAd";
			}else{
				res = pageErrors(model);
			}
			return res;
		}
		
		@RequestMapping(value="/FacturesRechercherAd")
		public String rechercherFacturesAd(HttpServletRequest request, Model model){
			if(model.asMap().get("ObjetUser")!=null){
			model.addAttribute("mc", request.getParameter("mcRech"));
			model.addAttribute("factures", metier.facturesParMotCle(request.getParameter("mcRech")));
			res = "SuperAdminListFacturesAd";
			}else{
				res = pageErrors(model);
			}
			return res;
		}
		//--------------------------------------------------------------------------------------------
		//Cassier
		//Principale Caissier factures
		
		@RequestMapping(value="/pageSuperAdminListFacturesCa")
		public String pageFacturesCa(Model model){
			if(model.asMap().get("ObjetUser")!=null){
			model.addAttribute("factures", metier.listFactures());
			res = "SuperAdminListFacturesCa";
			}else{
				res = pageErrors(model);
			}
			return res;
		}
		
		@RequestMapping(value="/detailComSuperFactCa")
		public String detailCommandeSuperFactureCa(Long idComm, Model model){
			if(model.asMap().get("ObjetUser")!=null){
			model.addAttribute("idComm", idComm);
			model.addAttribute("ListligneCommandes", metier.listLigneCommandeParIdCommande(idComm));
			res = "AdminDetailCommandeSuperAdFacturesCa";
			}else{
				res = pageErrors(model);
			}
			return res;
		}
		
		@RequestMapping(value="/routeurSuperListFacturesCa")
		public String routeurSuperListFacturesCa(Model model){
			if(model.asMap().get("ObjetUser")!=null){
			model.addAttribute("factures", metier.listFactures());
			res = "SuperAdminListFacturesCa";
			}else{
				res = pageErrors(model);
			}
			return res;
		}
		
		@RequestMapping(value="/FacturesRechercherCa")
		public String rechercherFacturesCa(HttpServletRequest request, Model model){
			if(model.asMap().get("ObjetUser")!=null){
			model.addAttribute("mc", request.getParameter("mcRech"));
			model.addAttribute("factures", metier.facturesParMotCle(request.getParameter("mcRech")));
			res = "SuperAdminListFacturesCa";
			}else{
				res = pageErrors(model);
			}
			return res;
		}
		//-----------Login-------------------------------------
		
		@RequestMapping(value="/login")
		public String login(Model model){
			
			return "login";
		}
		
		@RequestMapping(value="/error")
		public String erreurLogin(Model model){
			
			model.addAttribute("errorNom", "le nom ou le mot de passe est incorrect");
			return "login";
		}
		
		@RequestMapping(value="/authentification")
		public String Authentification(HttpServletRequest request, Model model){
			String nomPrenom="";
			String res ="Resultat";
			String nom = request.getParameter("Nom");
			String passe = request.getParameter("Passe");
			User u = metier.getUserNomEtPasse(nom, passe);
			if(u == null){
				res = erreurLogin(model);
			}else {
				model.addAttribute("ObjetUser", u);
				if(u.getNomroleUtil().equals("ROLE_ADMIN_GERER")){
					Admin a = u.getAdmin();
					nomPrenom = a.getNomAdmin()+" "+a.getPrenomAdmin();
					res = accueilAd(model);
				}else if(u.getNomroleUtil().equals("ROLE_ADMIN_CAISSIER")){
					Cassier ca = u.getCassier();
					nomPrenom = ca.getNomCassier()+" "+ca.getPrenomCassier();
					res = pageFacturesCa(model);
				}else if(u.getNomroleUtil().equals("ROLE_ADMIN_SERVEUR")){
					Serveur s = u.getServeur();
					nomPrenom = s.getNomServeur()+" "+s.getPrenomServeur();
					res = pageAdminNvCommandesServeur(model);
				}else if(u.getNomroleUtil().equals("ROLE_ADMIN_CUISINIER")){
					Cuisinier cu = u.getCuisinier();
					nomPrenom = cu.getNomCuisinier()+" "+cu.getPrenomCuisinier();
					res = pageAdminListCommCuisinier(model);
				}else if(u.getNomroleUtil().equals("SUPER_ADMIN")){
					res = accueil(model);
				}
				model.addAttribute("nomPrenom", nomPrenom);
			}
			return res;
		}
		
		@RequestMapping(value="/deconnecter")
		public String deconnecter(Model model, SessionStatus status){
			//HttpServletRequest request, HttpSession session
			//model.addAttribute("ObjetUser", null);
			status.setComplete();
			return "login";
		}
		
		@RequestMapping(value="/Error")
		public String pageErrors(Model model){
			
			return "pageErreur";
		}
		
}
