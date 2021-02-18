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
	<c:forEach items="${listaTrattamenti}" var="item">
		<p> ${item} </p>
		<hr/>
	</c:forEach>
	
		<h2> Prenotazioni effettuate: </h2>
	<c:forEach items="${listaPrenotazioni}" var="item">
		<p> ${item} </p>
		<hr/>
	</c:forEach>


	<table class="table table-bordered table-dark">
  <thead>
    <tr>
      <th scope="col">-</th>
      	<c:forEach items="${listaTrattamenti}" var="item">
      	<th scope="col" id="${item.id}">${item.nome}</th>
		</c:forEach>
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${orariDisponibili}" var="ora">
    <tr>
      <th scope="row">${ora}</th>
		<c:forEach items="${listaTrattamenti}" var="item">
      	<td scope="col" id="${item.id} ${ora}"> test </td>
		</c:forEach>
		
    </tr>
  </c:forEach>

  </tbody>
</table>

	<!--  FOOTER -->
	<jsp:include page="footer.jsp"/>
	<!-- /FOOTER -->
		
</body>
</html>