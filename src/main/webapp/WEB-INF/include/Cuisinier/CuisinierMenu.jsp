<!-- /. NAV TOP  -->
        <nav class="navbar-default navbar-side" role="navigation">
            <div class="sidebar-collapse">
                <ul class="nav" id="main-menu">
                    <li>
                        <div class="user-img-div">
                            <img src="<%= request.getContextPath() %>/resources/template/img/cuis.png" class="img-thumbnail" />

                            <div class="inner-text">
                                ${nomPrenom}
                            <br/>
                            </div>
                        </div>
                    </li>
					  
                    <li>
                        <a class="active-menu" href=""><i class="fa fa-square-o "></i>Menu Principale</a>
                    </li>
                   
                   <li>
                        <a href="pageAdminListCommCuis"><i class="fa fa-desktop "></i>Liste des commandes</a>
                   </li>
                    
                </ul>

            </div>

        </nav>
        <!-- /. NAV SIDE  -->