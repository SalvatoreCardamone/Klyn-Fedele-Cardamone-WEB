<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

	<!-- Loading resources -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script>
	$(function(){ $("head").load("../HTML/imports.html") });
	</script>
	
	
</head>
<body>

<!--  NAV -->
	<nav class="navbar navbar-expand-sm navbar-light bg-dark" id="navbar"> 
  	<a class="navbar-brand text-white" href="index.html ">Beauty SPA</a>
  		<!-- Collapse Button -->
  		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
   		<span class="navbar-toggler-icon"></span>
  		</button>
 		<!--  Nav Item List -->
  		<div class="collapse navbar-collapse" id="navbarSupportedContent" >
   			<ul class="navbar-nav mr-auto">
      			<li class="nav-item" id="home">
        		<a class="nav-link text-white" href="Home.html">Home</a>
      			</li>
      			<li class="nav-item" id="galleria">
        		<a class="nav-link text-white" href="Gallery.html">Galleria</a>
      			</li>
      			<li class="nav-item" id="prenota">
       			<a class="nav-link text-white" href="Booking.html">Prenota</a>
      			</li>
      			<li class="nav-item" id="info">
        		<a class="nav-link text-white" href="Info.html">Info e Contatti</a>
      			</li>
    		</ul>
    <!-- /Nav Item List -->
  		</div>
  		

		<c:choose>
		  <c:when test="${utente == null}">
		  <button type="button" class="btn btn-outline-success my-2 my-sm-0" data-toggle="modal" data-target="#loginModal" id="loginButton">
		  Accedi
		  </button>
		  </c:when>
		  <c:when test="${utente != null}">
		  <p> Benvenuto ${utente}    </p>
		  <button type="button" class="btn btn-outline-danger my-2 my-sm-0" data-toggle="modal" data-target="#loginModal" id="loginButton">
		   Logout
		  </button>  
		  </c:when>
		  <c:otherwise>
		    <!-- corrisponde al default -->
		  </c:otherwise>
		</c:choose>

		
		
	</nav>
	<!-- /NAV -->
	<jsp:include page="login.jsp"/>

	
	<div id="register-popup-placeholder"> </div>

</body>

<script>
$(document).ready(function() {    
	$('#register-popup-placeholder').load("../HTML/Registrazione.html");
	
	});
	
</script>

</html>