<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    

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
        		<a class="nav-link text-white" href="/">Home</a>
      			</li>
      			<li class="nav-item" id="galleria">
        		<a class="nav-link text-white" href="/Gallery">Galleria</a>
      			</li>
      			<li class="nav-item" id="prenota">
       			<a class="nav-link text-white" href="/Booking">Prenota</a>
      			</li>
      			<li class="nav-item" id="info">
        		<a class="nav-link text-white" href="/Info">Info e Contatti</a>
      			</li>
    		</ul>
    <!-- /Nav Item List -->
  		</div>
  		

		<!-- Show login button if not logged -->

		  <c:if test="${utente == null}">
		  <button type="button" class="btn btn-outline-success my-2 my-sm-0" data-toggle="modal" data-target="#loginModal" id="loginButton">
		  Accedi
		  </button>
		  </c:if>
		  
		  <c:if test="${utente != null}">
		  <div class="dropdown">
		  <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown"> Benvenuto ${utente.nome} ${utente.cognome}!
		  <span class="caret"></span></button>
		  <ul class="dropdown-menu">
		    <li> <a class="dropdown-item" href="/Profilo">Profilo</a> </li>
		    <li> <a class="dropdown-item" href="/LeTuePrenotazioni">Prenotazioni</a> </li>
		    <li> <div class="dropdown-divider"></div>  </li>
		    <li>
		    <form method="POST" action="/logout">
		    <button type="submit" class="btn btn-outline-danger my-2 my-sm-0 mx-auto d-block">
			   Logout
			 </button>
			</form>
			</li>
		  </ul>
		</div>
		  </c:if>
		  
		  <c:if test="${erroreLogin eq true}">
		  <c:set var="erroreLogin" value="${false}" scope="session" />
		  <script>
		  alert("Attenzione: Email inserita e/o password errati!");
		  </script>
		  </c:if>
		 
	
		  
	</nav>
	<!-- /NAV -->
	
	<!-- Modal for login -->
	<jsp:include page="login.jsp"/>
	<!-- /Modal for login -->
	
	<!-- Modal for register -->
	<jsp:include page="register.jsp"/>
	<!-- /Modal for register -->
