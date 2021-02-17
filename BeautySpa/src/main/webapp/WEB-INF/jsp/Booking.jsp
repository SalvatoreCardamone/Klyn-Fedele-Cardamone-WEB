<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="it">
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
	
	<link rel="stylesheet" href="../CSS/bookingStyle.css">


</head>

<body>

	<!--  NAV -->
	<jsp:include page="nav.jsp"/>
	<!-- /NAV -->

<div id="booking" class="section">
		<div class="section-center">
			<div class="container">
				<div class="row">
					<div class="col-md-7 col-md-push-5">
						<div class="booking-cta">
							<h1>Il tuo giorno di relax attende</h1>
							<p>Pronto a dedicarti una giornata di salute e benessere? La Beauty SPA è pronta ad accoglierti e a 
							dedicarti i suoi migliori servizi: massaggi rilassanti, sauna finlandese, docce emozionali e molto altro ancora.
							Seleziona un giorno per poter scegliere come regalarti un'esperienza indimenticabile presso il nostro centro benessere.
							</p>
						</div>
					</div>
					<div class="col-md-4 col-md-pull-7"> 
						<div class="booking-form">
						
						 <c:if test="${utente != null}">
							<form method="GET" action="/Treatments">
								<div class="form-group">
									<span class="form-label">Prenotazione a nome di: </span>
									<input class="form-control" type="text" placeholder="Mario Rossi" value="${utente.nome} ${utente.cognome}" name="nome">
								</div>
								<div class="row">
									<div class="col">
										<div class="form-group">
											<span class="form-label">Data Check-In:</span>
											<input class="form-control" type="date" required name="data">
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col">
										<div class="form-group">
											<span class="form-label">Numero persone: </span>
											<select class="form-control" name="numeroPersone">
												<option>1</option>
												<option>2</option>
												<option>3</option>
												<option>4</option>
											</select>
											<span class="select-arrow"></span>
										</div>
									</div>
								</div>
								<div class="form-btn">
									<button class="submit-btn" type="submit">Controlla disponibilità</button>
								</div>
								</form>
							</c:if>
							
						 <c:if test="${utente == null}">
						 <div class="card">
							  <div class="card-body">
							    <h5 class="card-title">Attenzione</h5>
							    <p class="card-text">Effettua il login per poter procedere con la tua prenotazione!</p>
								    <div class="row justify-content-center">
									  <button type="button" class="btn btn-primary my-2 my-sm-0" data-toggle="modal" data-target="#loginModal" id="loginButton"> Accedi </button>
									</div>
							 </div>
						</div>
						 </c:if>	
						 
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!--  FOOTER -->
	<jsp:include page="footer.jsp"/>
	<!-- /FOOTER -->

</body>

</html>