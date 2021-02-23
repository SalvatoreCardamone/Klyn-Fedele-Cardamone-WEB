<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
    
    
<!DOCTYPE html>
<html>
<head>
    <!-- Importing resources -->
    <jsp:include page="imports.jsp"/>
    <script src='../JavaScript/Admin.js'></script>
</head>
<body>         		
	
	<button onclick="visualizzaUtente();">Visualizza Utenti</button>
	
	
	
	<h2> Lista Utenti </h2>
	<table class="table" var=>
  <thead class="thead-light">
    <tr>
      <th scope="col">EMAIL</th>
      <th scope="col">NOME</th>
      <th scope="col">COGNOME</th>
      <th scope="col">TELEFONO</th>
    </tr>
  </thead>
  <tbody>
  
  <c:forEach items="${listaUtenti}" var="utente">
    <tr id="${utente.email}">
      <th scope="row" >${utente.email}</th>
      <td>${utente.nome}</td>
      <td>${utente.cognome}</td>
      <td>${utente.numero}</td>
    </tr>
 </c:forEach>
  </tbody>
</table>
<hr/>
  
  
 <h2> Lista Recensioni </h2>
	<table class="table">
  <thead class="thead-light">
    <tr>
      <th scope="col">ID Recensione</th>
      <th scope="col">Descrizione</th>
      <th scope="col">Data</th>
      <th scope="col">Creatore</th>
      <th scope="col">Voto</th>
    </tr>
  </thead>
  <tbody>
  
  <c:forEach items="${listaRecensioni}" var="recensione">
    <tr>
      <th scope="row">${recensione.idRecensione}</th>
      <td>${recensione.descrizione}</td>
      <td>${recensione.data}</td>
      <td>${recensione.scrittoDa}</td>
      <td>${recensione.voto}</td>
    </tr>
 </c:forEach>
  </tbody>
</table>
<hr/>
  
	
</body>
</html>

