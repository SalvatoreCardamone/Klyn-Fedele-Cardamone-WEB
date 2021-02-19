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
	
	
	<style>
	html {
    height: 100%;
	}

	.card-header .fa {
	  transition: .3s transform ease-in-out;
	}
	.card-header .collapsed .fa {
	  transform: rotate(-90deg);
	}
	
	body {
		background-color: #0812ea;
		background-image: linear-gradient(0deg, #0812ea 0%, #22ced6 100%);
		height: 100%;
	    margin: 0;
	    background-repeat: no-repeat;
	    background-attachment: fixed;
	}
	</style>
	
</head>
<body>

	<!--  NAV -->
	<jsp:include page="nav.jsp"/>
	<!-- /NAV -->

<form method="POST" action="/confermaPrenotazione">
	<c:forEach items="${listaTrattamenti}" var="trattamento">
		<div class="container-lg row justify-content-center" >
			<div class="card border-primary" style="width: 30rem;">
		  	<img class="card-img-top" src="../image/trattamento${trattamento.id}.png" alt="">
			  <div class="card-body">
			    <h5 class="card-title">${trattamento.nome}</h5>
			    <p class="card-text">${trattamento.descrizione}</p>
			    	
			    	<div class="input-group">
			    	<div class="input-group-prepend">
						<span class="input-group-text">Seleziona un orario:</span>
					</div>
					  <select class="custom-select" name="${trattamento.id}">
					    <option selected value="no">Non prenotare, grazie</option>
					     <c:forEach items="${orariDisponibili}" var="ora">
					    	<option value="${ora}" id="${trattamento.id}${ora}">${ora}</option>
					     </c:forEach>
					  </select>
			    </div>
			  </div>
			</div>
		</div>
	</c:forEach>
	
	<div class="container-fluid">
	<button class="btn btn-success btn-lg btn-block" type="submit">Continua</button>
	</div>
	<hr/>
</form>

<!-- versione vecchia
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
			 <input id="${item.id}${ora}button" type="checkbox" class="gruppo" data-toggle="toggle" data-on="Prenotato" data-off="Disponibile" data-onstyle="success" data-offstyle="outline-light">
		</td>
		</c:forEach>	
    </tr>
  </c:forEach>
  </tbody>
</table>
	
	
-->

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
				$(jq(lista[i])).attr("disabled","disabled");
				$(jq(lista[i])).append("<p> Non disponibile </p>")
				//$(jq(lista[i]+"button")).parent().remove();
				//$(jq(lista[i])).append('<div class="row justify-content-center"> <button type="button" class="btn btn-danger">Occupato</button> </div>');
			}
		
	
	});
	
	
</script>

</html>