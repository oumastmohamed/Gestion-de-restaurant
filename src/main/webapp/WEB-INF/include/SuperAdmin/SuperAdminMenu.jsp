<!-- /. NAV TOP  -->
        <nav class="navbar-default navbar-side" role="navigation">
            <div class="sidebar-collapse">
                <ul class="nav" id="main-menu">
                    <li>
                        <div class="user-img-div">
                            <img src="<%= request.getContextPath() %>/resources/template/img/superAdmin.png" class="img-thumbnail" />

                            <div class="inner-text">
                                OUMAST Mohamed
                            <br />
                            </div>
                        </div>
                    </li>
					  
                    <li>
                        <a class="active-menu" href="Accueil"><i class="fa fa-square-o "></i>Menu Principale</a>
                    </li>
                    
                    <li>
                        <a href="pageSuperAdmin"><i class="fa fa-sitemap "></i>Gestion des admins</a>
                    </li>
                    
                    
                     <li>
                        <a href="pageSuperAdminCa"><i class="fa fa-sitemap "></i>Gestion des caissier</a>
                    </li>
                   
                     <li>
                        <a href="#"><i class="fa fa-sitemap "></i>Gestion des serveurs<span class="fa arrow"></span></a>
                         <ul class="nav nav-second-level">
                           
                             <li>
                                <a href="pageSuperAdminSeN"><i class="fa fa-edit"></i>Nouveau serveur </a>
                            </li>
                             <li>
                                <a href="pageSuperAdminSeL"><i class="fa fa-desktop "></i>Liste des serveurs</a>
                            </li>
                             
                        </ul>
                    </li>
                      
                    <li>
                        <a href="#"><i class="fa fa-sitemap "></i>Gestion des cuisiniers <span class="fa arrow"></span></a>
                         <ul class="nav nav-second-level">
                            <li>
                                <a href="pageSuperAdminCuN"><i class="fa fa-edit"></i>Nouveau cuisinier</a>
                            </li>
                             <li>
                                <a href="pageSuperAdminCuL"><i class="fa fa-desktop "></i>Liste des cuisiniers</a>
                            </li>
                        </ul>
                    </li>
                    
                    <li>
                        <a href="pageSuperAdminUtilisateur"><i class="fa fa-sitemap "></i>Comptes des utilisateurs</a>
                    </li>
                   
                    <li>
                        <a href="#"><i class="fa fa-sitemap "></i>Gérer Catégorie et Produits<span class="fa arrow"></span></a>
                         <ul class="nav nav-second-level">
                            <li>
                                <a href="pageAdminCat">Catégorie</a>
                            </li>
                            
                            <li>
                                <a href="#">Produits<span class="fa arrow"></span></a>
                                <ul class="nav nav-third-level">
                                    <li>
                                        <a href="pageAdminNvProd"><i class="fa fa-circle-o "></i>Nouveau Produit</a>
                                    </li>
                                    <li>
                                        <a href="pageAdminListProd"><i class="fa fa-desktop "></i>Liste des Produits</a>
                                    </li>
                                </ul>

                            </li>
                        </ul>
                    </li>
                   
                   <li>
                        <a href="pageSuperAdminListFactures"><i class="fa fa-sitemap "></i>Liste des factures</a>
                   </li>
                   
                   <li>
                        <a href="#"><i class="fa fa-sitemap "></i>Gestion des commandes <span class="fa arrow"></span></a>
                         <ul class="nav nav-second-level">
                            <li>
                                <a href="pageAdminNvComm"><i class="fa fa-edit"></i>Nouveau commande</a>
                            </li>
                             <li>
                                <a href="listToutCommande"><i class="fa fa-desktop "></i>Liste des commandes</a>
                            </li>
                        </ul>
                    </li>
                    
                </ul>

            </div>

        </nav>
        <!-- /. NAV SIDE  -->