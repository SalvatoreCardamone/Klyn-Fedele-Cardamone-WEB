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
							<p>Pronto a dedicarti una giornata di salute e benessere? La Beauty SPA � pronta ad accoglierti e a 
							dedicarti i suoi migliori servizi: massaggi rilassanti, sauna finlandese, docce emozionali e molto altro ancora.
							Seleziona un giorno per poter scegliere come regalarti un'esperienza indimenticabile presso il nostro centro benessere.
							</p>
						</div>
					</div>
					<div class="col-md-4 col-md-pull-7">
						<div class="booking-form">
							<form>
								<div class="form-group">
									<span class="form-label">Your Destination</span>
									<input class="form-control" type="text" placeholder="Enter a destination or hotel name">
								</div>
								<div class="row">
									<div class="col-sm-6">
										<div class="form-group">
											<span class="form-label">Check In</span>
											<input class="form-control" type="date" required>
										</div>
									</div>
									<div class="col-sm-6">
										<div class="form-group">
											<span class="form-label">Check out</span>
											<input class="form-control" type="date" required>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-sm-4">
										<div class="form-group">
											<span class="form-label">Rooms</span>
											<select class="form-control">
												<option>1</option>
												<option>2</option>
												<option>3</option>
											</select>
											<span class="select-arrow"></span>
										</div>
									</div>
									<div class="col-sm-4">
										<div class="form-group">
											<span class="form-label">Adults</span>
											<select class="form-control">
												<option>1</option>
												<option>2</option>
												<option>3</option>
											</select>
											<span class="select-arrow"></span>
										</div>
									</div>
									<div class="col-sm-4">
										<div class="form-group">
											<span class="form-label">Children</span>
											<select class="form-control">
												<option>0</option>
												<option>1</option>
												<option>2</option>
											</select>
											<span class="select-arrow"></span>
										</div>
									</div>
								</div>
								<div class="form-btn">
									<button class="submit-btn">Check availability</button>
								</div>
							</form>
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