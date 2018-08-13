<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ include file="/WEB-INF/include/css.jsp"%>
<title>Accueil</title>
</head>
<body>
<%@ include file="/WEB-INF/include/SuperAdmin/SuperAdHeader.jsp"%>
<%@ include file="/WEB-INF/include/SuperAdmin/SuperAdminMenu.jsp"%>
<div id="wrapper">
<div id="page-wrapper">


            <div id="page-inner">
                <div class="row">
                    <div class="col-md-12">
                        <h1 class="page-head-line">ACCUEIL</h1>
                    </div>
                </div>
                <!-- /. ROW  -->
                <div class="row">
                <div class="col-lg-4">
                <div class="widget style1">
                	<div class="row">	
                        <div class="col-xs-4 text-center">
                            <i class="fa fa-money fa-5x"></i>
                        </div>
                        <div class="col-xs-8 text-right">
                            <span> La Caisse </span>
                            <h2 class="font-bold">4,232 DH</h2>
                        </div>
                    </div>
                </div>
            </div>
            
                    <div class="col-md-4">
                        <div class="">

                                <i class="fa fa-heart fa-5x"></i>
                                <h5>Meilleur Article</h5>
                                <h2>Cafe Noir</h2>

                        </div>
                    </div>
                    
                    <div class="col-md-4">
                        <div class="">
                            <a href="#">
                                <i class="fa fa-cutlery fa-5x"></i>
                                <h5>Nombre de Commandes</h5>
                                <h2 class="font-bold">259</h2>
                            </a>
                        </div>
                    </div>
					
					<div class="col-lg-6">
            			<div class="main-box mb-red">

                        <h1 class="m-xs">Nombre de Tables Libres</h1>
                        <h3 class="font-bold no-margins"> 9 Table </h3>
                        <small>Tables utilisés : 05</small>
                		</div>
            		</div> 
            		
            		<div class="col-lg-6">
            			<div class="main-box mb-pink">

                        <h1 class="m-xs">Nombre de Produits  </h1>

                        <h3 class="font-bold no-margins">
                            Non-Valables : 05
                        </h3>
                        <small>Produits Valables : 45</small>
                		</div>
            		</div>
            		 
                </div>
                <div class="panel panel-default">

                            <div id="carousel-example" class="carousel slide" data-ride="carousel" style="border: 5px solid #000;">

                                <div class="carousel-inner">
                                    <div class="item active">

                                        <img src="<%= request.getContextPath() %>/resources/template/img/slideshow/d.jpg" alt="" />

                                    </div>
                                    <div class="item">
                                        <img src="<%= request.getContextPath() %>/resources/template/img/slideshow/b.jpg" alt="" />

                                    </div>
                                    <div class="item">
                                        <img src="<%= request.getContextPath() %>/resources/template/img/slideshow/c.jpg" alt="" />

                                    </div>
                                    <div class="item">
                                        <img src="<%= request.getContextPath() %>/resources/template/img/slideshow/a.jpg" alt="" />

                                    </div>
                                    <div class="item">
                                        <img src="<%= request.getContextPath() %>/resources/template/img/slideshow/e.jpg" alt="" />

                                    </div>
                                </div>
                                <!--INDICATORS-->
                                <ol class="carousel-indicators">
                                    <li data-target="#carousel-example" data-slide-to="0" class="active"></li>
                                    <li data-target="#carousel-example" data-slide-to="1"></li>
                                    <li data-target="#carousel-example" data-slide-to="2"></li>
                                    <li data-target="#carousel-example" data-slide-to="3"></li>
                                    <li data-target="#carousel-example" data-slide-to="4"></li>
                                </ol>
                                <!--PREVIUS-NEXT BUTTONS-->
                                <a class="left carousel-control" href="#carousel-example" data-slide="prev">
                                    <span class="glyphicon glyphicon-chevron-left"></span>
                                </a>
                                <a class="right carousel-control" href="#carousel-example" data-slide="next">
                                    <span class="glyphicon glyphicon-chevron-right"></span>
                                </a>
                            </div>
                        </div>
                </div>
            </div>
<%@ include file="/WEB-INF/include/footer.jsp"%>
<%@ include file="/WEB-INF/include/js.jsp"%>
            </div>
            <!-- /. PAGE INNER  -->

</body>
</html>