<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>

<!-- Importing resources -->
	<jsp:include page="imports.jsp"/>

	<!-- Do When page is loaded -->
	<script>
	$(document).ready(function()
	{
		$("#prenota").attr("id","selectedItem");
	});
	</script>
	
</head>
<body>

	<!--  NAV -->
	<jsp:include page="nav.jsp"/>
	<!-- /NAV -->
	
	<h1> Trattamenti disponibili: </h1>
	<c:forEach items="${trattamenti}" var="item">
		<p> ${item.id} </p>
		<p> ${item.nome} </p>
		<p> ${item.disponibile} </p>
		<p> ${item.descrizione} </p>
	</c:forEach>
	
		<h2> Prenotazioni effettuate: </h2>
	<c:forEach items="${prenotazioni}" var="item">
		<p> ${item.id} </p>
		<p> ${item.utente} </p>
		<p> ${item.time} </p>
		<p> ${item.date} </p>
		<p> ${item.persone} </p>
		<p> ${item.trattamenti} </p>
		
	</c:forEach>

		<!--  FOOTER -->
	<jsp:include page="footer.jsp"/>
	<!-- /FOOTER -->
		
</body>
</html>