<!-- BOOTSTRAP STYLES-->
    <link href="<%= request.getContextPath() %>/resources/template/css/bootstrap.css" rel="stylesheet" />
    <!-- FONTAWESOME STYLES-->
    <link href="<%= request.getContextPath() %>/resources/template/css/font-awesome.css" rel="stylesheet" />
       <!--CUSTOM BASIC STYLES-->
    <link href="<%= request.getContextPath() %>/resources/template/css/basic.css" rel="stylesheet" />
    <!--CUSTOM MAIN STYLES-->
    <link href="<%= request.getContextPath() %>/resources/template/css/custom.css" rel="stylesheet" />
    <!-- GOOGLE FONTS-->
    <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
    <script type="text/javascript">
    function confirmer(url){
    	var rep = confirm("Etes vous sûre de vouloir supprimer?");
    	if(rep==true){
    		document.location=url;
    	}
    }
	</script>
    