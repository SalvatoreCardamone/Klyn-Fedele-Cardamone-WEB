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
		<c:choose>
		  <c:when test="${utente == null}">
		  <button type="button" class="btn btn-outline-success my-2 my-sm-0" data-toggle="modal" data-target="#loginModal" id="loginButton">
		  Accedi
		  </button>
		  </c:when>
		  <c:when test="${utente != null}">
		  <div class="dropdown">
		  <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown"> Benvenuto ${utente}!
		  <span class="caret"></span></button>
		  <ul class="dropdown-menu">
		    <li> <a class="dropdown-item" href="#">Profilo</a> </li>
		    <li> <a class="dropdown-item" href="#">Prenotazioni</a> </li>
		    <li> <div class="dropdown-divider"></div>  </li>
		    <li>
		    <button type="button" class="btn btn-outline-danger my-2 my-sm-0 mx-auto d-block">
			   Logout
			 </button>
			</li>
		  </ul>
		</div>
		    
		  </c:when>
		  <c:otherwise>
		    <!-- Default -->
		  </c:otherwise>
		</c:choose>
	
	</nav>
	<!-- /NAV -->
	
	<!-- Modal for login -->
	<jsp:include page="login.jsp"/>
	<!-- /Modal for login -->
	
	<!-- Modal for register -->
	<jsp:include page="register.jsp"/>
	<!-- /Modal for register -->

