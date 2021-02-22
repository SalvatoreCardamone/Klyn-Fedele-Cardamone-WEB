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
		$("#info").attr("id","selectedItem");
	});
	</script>
</head>


<body>

	<!--  NAV -->
	<jsp:include page="nav.jsp"/>
	<!-- /NAV -->

<h1 class="info_header"> Domande? Vieni a trovarci! </h1>
<hr>
<div class="container-fluid">
  <div class="row">
    <div class="col-sm">
      <!-- Google Maps -->
      <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3084.6973402171243!2d16.223897114716916!3d39.363090026965295!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x133f99a1baaf0ed1%3A0xa62faf0948d171d1!2sMatematica%20e%20Informatica!5e0!3m2!1sit!2sit!4v1597998577511!5m2!1sit!2sit" width="100%" height="450px"  aria-hidden="false"></iframe>
    </div>
    <div class="col-sm">
      <!-- Street View -->
      <iframe src="https://www.google.com/maps/embed?pb=!4v1597998841332!6m8!1m7!1sCAoSLEFGMVFpcE14RTFoYUdqQ3Uzc0tlQk82bU0yU3oxZEdEUTB1c21zTEZjX2l1!2m2!1d39.36306857872535!2d16.22591447085142!3f92.65801780756429!4f6.042643709089475!5f0.7820865974627469" width="100%" height="450px" aria-hidden="false"></iframe>
    </div>
  </div>
</div>
<hr>

<h2 class="info_header"> Dubbi? Scrivici una e-mail! </h2>
                <div class="container">
                        <form action="/sendEmail" method="POST" >
                            <div class="form-group">
                                <input type="text" name="name" class="form-control rounded-0" placeholder="Nome e Cognome" required="required" />
                            </div>
                            <div class="form-group">
                                <input type="email" name="email" class="form-control rounded-0" placeholder="Email" required="required" />
                            </div>
                            <div class="form-group">
                                <select class="form-control" name="inquiry" required>
                                    <option value="" selected> -- Tipo di domanda -- </option>
                                    <option value="prenotazione">Prenotazioni</option>
                                    <option value="servizio">Servizi</option>
                                    <option value="altro">Altro</option>
                                </select>
                            </div>
                            <div class="form-group">
                                <textarea rows="8" name="message" class="form-control rounded-0" placeholder="Scrivi qui..." required="required"></textarea>
                            </div>
			
							<div class="form-group">
							<div class="g-recaptcha" data-sitekey="6LcNNGAaAAAAAHhayc8JNhQDpfZPH8ROarU-qtrD" data-callback="enableSend" data-expired-callback="disableSend"></div>
							</div>
							
                            <div class="form-group mb-0">
                                <button class="btn btn-primary btn-lg btn-block" id="sendButton" type="submit" disabled>INVIA</button>
                            </div>
                        </form>
                </div>
                
                <hr>
                
                
	<!--  FOOTER -->
	<jsp:include page="footer.jsp"/>
	<!-- /FOOTER -->
	
</body>

<script>
function enableSend()
{
    $('#sendButton').removeAttr("disabled");
}

function disableSend()
{
    $('#sendButton').attr("disabled", "disabled");
}
</script>

</html>