<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>

<!-- Importing resources -->
	<jsp:include page="imports.jsp"/>

<link href="https://cdn.jsdelivr.net/gh/gitbrent/bootstrap4-toggle@3.6.1/css/bootstrap4-toggle.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/gh/gitbrent/bootstrap4-toggle@3.6.1/js/bootstrap4-toggle.min.js"></script>

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
		<td scope="col" class="table-success" id="${item.id}${ora}">
			 <input id="${item.id}${ora}button" type="checkbox" class="gruppo" data-toggle="toggle" data-on="Prenotato" data-off="Disponibile" data-onstyle="success" data-offstyle="light">
		</td>
		</c:forEach>	
    </tr>
  </c:forEach>
  </tbody>
</table>
	
	<!--  FOOTER -->
	<jsp:include page="footer.jsp"/>
	<!-- /FOOTER -->
		
</body>

<script>
//Rimpiazza i : per consentire a jquery di accedere con caratteri speciali
function jq( myid ) {
	 return "#" + myid.replace( /(:|\.|\[|\]|,|=|@)/g, "\\:" );
}

var lista = [
	<c:forEach items="${listaPrenotazioni}" var="item">
		<c:forEach items="${item.lista}" var="trattamento">
			"${trattamento.id}${item.time}",
		</c:forEach>
	</c:forEach>
	];

	$(document).ready(function()
	{
		for (var i=0; i<lista.length; i++)
			{ 
				
				$(jq(lista[i])).attr("class","table-danger");
				$(jq(lista[i]+"button")).parent().remove();
				$(jq(lista[i])).append('<div class="row justify-content-center"> <button type="button" class="btn btn-danger">Occupato</button> </div>');
			}
		
		
		$( ".toggle" ).click(function() {
			  alert("ah!");
			});
				
			$( ".gruppo" ).each(function( index ) {
				});
	
	});
	
</script>

</html>