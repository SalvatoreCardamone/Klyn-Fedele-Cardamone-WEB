<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<head>
  <meta charset="UTF-8">
  <link rel="stylesheet" type="text/css" href="../CSS/stelle.css">
  <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
</head>

<!--  login popup -->
<div class="modal fade" id="ReviewModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered" role="document">
		<div class="modal-content">
			<div class="modal-header border-bottom-0">
				<button type="button" class="close" data-dismiss="modal"> x</button>
			</div>
			<div class="modal-body">
				<div class="form-title text-center">
					<h4>Lascia Qui la tua Opinione</h4>
				</div>
				<div class="d-flex flex-column text-center">
					<form class="container" method="POST" action="/LetReview" id="reviewFormContainer">
						<div class="form-group">
							<input type="number" class="form-control" id="id" name="id" value="0" style="display:none">
						</div>
						<div class="form-group">
							<textarea rows="3" cols="50" maxlength="100"  class="form-control" id="descrizione" name="descrizione" placeholder="Inserisci qui la tua opinione (Max 100 caratteri)"></textarea>
						</div>
						<div class="form-group">
							<input type="date" class="form-control" id="data" name="data" value="2005-06-07" style="display:none">
						</div>
						<div class="form-group">
							<input type="text" class="form-control" id="autore" value="${utente.email}" name="autore" style="display:none">
						</div>
						<div class="form-group">
							<div class="star-rating">
						      <div class="star-rating__wrap">
						        <input class="star-rating__input" id="star-rating-5" type="radio" name="voto" value="5" required>
						        <label class="star-rating__ico fa fa-star-o fa-lg" for="star-rating-5" title="Eccellente" ></label>
						        <input class="star-rating__input" id="star-rating-4" type="radio" name="voto" value="4" required>
						        <label class="star-rating__ico fa fa-star-o fa-lg" for="star-rating-4" title="Ottimo"></label>
						        <input class="star-rating__input" id="star-rating-3" type="radio" name="voto" value="3" required>
						        <label class="star-rating__ico fa fa-star-o fa-lg" for="star-rating-3" title="Buono"></label>
						        <input class="star-rating__input" id="star-rating-2" type="radio" name="voto" value="2" required>
						        <label class="star-rating__ico fa fa-star-o fa-lg" for="star-rating-2" title="Mediocre"></label>
						        <input class="star-rating__input" id="star-rating-1" type="radio" name="voto" value="1" required>
						        <label class="star-rating__ico fa fa-star-o fa-lg" for="star-rating-1" title="Terribile"></label>
						      </div>
    						</div>
						</div>		
						 <div  class="form-group">
							<button class="btn btn-success btn-block" type="submit">Invia Recensione</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>

<script>
$('#ReviewModal').on('shown.bs.modal', function () {
	$("body").addClass("modal-open");
	});

</script>






<script src="https://apis.google.com/js/platform.js?onload=renderButton" async defer></script>


