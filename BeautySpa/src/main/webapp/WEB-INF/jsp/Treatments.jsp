<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

<c:if test="${utente == null}">
	<div class="row justify-content-center">
		 <div class="card">
			  <div class="card-body">
			    <h5 class="card-title">Attenzione</h5>
			    <p class="card-text">Effettua il login per poter procedere con la tua prenotazione!</p>
				    <div class="row justify-content-center">
					  <button type="button" class="btn btn-primary my-2 my-sm-0" data-toggle="modal" data-target="#loginModal" id="loginButton"> Accedi </button>
					</div>
			 </div>
		</div>
	</div>
</c:if>

<c:if test="${utente != null}">
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
						  <select class="custom-select" name="trattamento${trattamento.id}">
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
</c:if>

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
			"${item.trattamento}${item.time}",
	</c:forEach>
	];

	$(document).ready(function()
	{
		for (var i=0; i<lista.length; i++)
			{ 
				$(jq(lista[i])).attr("class","table-danger");
				$(jq(lista[i])).attr("disabled","disabled");
				$(jq(lista[i])).append("<p> Non disponibile </p>");
			}
		
	
	});
	
	
</script>

</html>