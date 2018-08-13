<!-- /. NAV TOP  -->
        <nav class="navbar-default navbar-side" role="navigation">
            <div class="sidebar-collapse">
                <ul class="nav" id="main-menu">
                    <li>
                        <div class="user-img-div">
                            <img src="<%= request.getContextPath() %>/resources/template/img/adm.png" class="img-thumbnail" />

                            <div class="inner-text">
                                ${nomPrenom}
                            <br/>
                            </div>
                        </div>
                    </li>
					  
                    <li>
                        <a class="active-menu" href="AccueilAd"><i class="fa fa-square-o "></i>Menu Principale</a>
                    </li>
                   
                    <li>
                        <a href="#"><i class="fa fa-sitemap "></i>Gérer Catégorie et Produits<span class="fa arrow"></span></a>
                         <ul class="nav nav-second-level">
                            <li>
                                <a href="pageAdminCatAd">Catégorie</a>
                            </li>
                            
                            <li>
                                <a href="#">Produits<span class="fa arrow"></span></a>
                                <ul class="nav nav-third-level">
                                    <li>
                                        <a href="pageAdminNvProdAd"><i class="fa fa-circle-o "></i>Nouveau Produit</a>
                                    </li>
                                    <li>
                                        <a href="pageAdminListProdAd"><i class="fa fa-desktop "></i>Liste des Produits</a>
                                    </li>
                                </ul>

                            </li>
                        </ul>
                    </li>
                   
                   <li>
                        <a href="pageSuperAdminListFacturesAd"><i class="fa fa-sitemap "></i>Liste des factures</a>
                   </li>
                   
                   <li>
                        <a href="listToutCommandeAd"><i class="fa fa-desktop "></i>Liste des commandes</a>
                    </li>
                    
                </ul>

            </div>
        </nav>
        <!-- /. NAV SIDE  -->