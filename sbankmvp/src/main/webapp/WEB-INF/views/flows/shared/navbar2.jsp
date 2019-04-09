<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<link rel="stylesheet" href="webapp/assets/css/style.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"> 
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">


    <!--  <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">-->
    
    <div class="top-nav-barr">
      <li><a href="#">Contacto: +2145454546 </a></li>
                <li><a href="#">Email: commerce@standardbank.co.mz </a></li>
                <li class="log"><a href="#">Entre ou Cadastre-se</a> </li>
                <hr>
    </div>

   <div class="top-nav-bar">

  	 <div class="search-box">
   	  	 <img src="${images}/orage-logo-Copy.jpg" class="logo"> 
   	  	 
   	  	 <input type="text" style="width: 205px; padding: 7px; font-size: 12px; text-align: center; margin-left: 12%; border: 1px solid #0033a1"; placeholder="Clique aqui para pesquisar"/>  
	</div> 
	 
			 
			 <div class="menu-bar">
			 
			 
                  <ul>
				     <li><a href="index.html"><i class="fa fa-home"></i>Home</a></li>
					 <li><a href="#">Imóveis</a></li>
					 
                     <li id="listProducts">
                         <a href="${contextRoot}/show/all/products">Veículos</a>
                     </li>
                     
                    <!-- <li >
                        <a href="${contextRoot}/manage/products">Cadastrar</a>
                     </li>  --> 
                     
                     <li><a href="#"><i class="fa fa-shopping-cart"></i>Cart</a></li>
				 </ul>
			 </div>
	 </div>
	 
	 
    <!-- </nav> -->
    
    
    
	<script>
	
		window.userRole = '${userModel.role}';	
	
	</script>
	
	
	
	
	
	
