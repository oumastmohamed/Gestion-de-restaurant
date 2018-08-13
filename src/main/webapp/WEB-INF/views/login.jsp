<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
      <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Authentification</title>

    <!-- BOOTSTRAP STYLES-->
    <link href="<%= request.getContextPath() %>/resources/template/css/bootstrap.css" rel="stylesheet" />
    <!-- FONTAWESOME STYLES-->
    <link href="<%= request.getContextPath() %>/resources/template/css/font-awesome.css" rel="stylesheet" />
    <!-- GOOGLE FONTS-->
    <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
    <%@ include file="/WEB-INF/include/css.jsp"%>

</head>
<body style="background-color: #E2E2E2;">
    <div class="container">
        <div class="row text-center " style="padding-top:100px;">
            <div class="col-md-12">
                <h1><strong>RESTAURANT EL-BARAKA</strong></h1>
            </div>
        </div>
         <div class="row ">
               
                <div class="col-md-4 col-md-offset-4 col-sm-6 col-sm-offset-3 col-xs-10 col-xs-offset-1">
                           
                            <div class="panel-body">
                                <form action="authentification" method="get">
                                    <hr />
                                    <h5>Entrez les détails pour ouvrir une session</h5>
                                       <br />
                                     <div class="form-group input-group">
                                            <span class="input-group-addon"><i class="fa fa-tag"  ></i></span>
                                            <input type="text" name="Nom" class="form-control" placeholder="Votre nom d'utilisateur " />
                                        </div>
                                                                              <div class="form-group input-group">
                                            <span class="input-group-addon"><i class="fa fa-lock"  ></i></span>
                                            <input type="password" name="Passe" class="form-control"  placeholder="Votre mot de passe" />
                                        </div>
                                        <input type="submit" value="Login" class="btn btn-primary "/>
                                    <hr />
                                    <p align="center" class="errors">${errorNom}</p>${nomUs}
                                    </form>
                            </div>
                           
                        </div>
        </div>
    </div>
</body>
</html>
