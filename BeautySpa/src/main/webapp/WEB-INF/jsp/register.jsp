<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!--  login popup -->
<div class="modal fade" id="registerModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-header border-bottom-0">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">x</span>
        </button>
      </div>
      <div class="modal-body">
        <div class="form-title text-center">
          <h4>Registrati</h4>
        </div>
        <div class="d-flex flex-column text-center">
        <form  class="container" method="POST" action="/registrazione">
            <div class="form-group">
				<input type="email" class="form-control" type="text" id="Email" name="email" placeholder="Inserisci Email." required/>
			</div>
	
			<div  class="form-group">
				<input type="password" class="form-control" type="text" id="Password" placeholder="Inserisci Password" name="password" required/>
			</div>
	
			<div  class="form-group">
				<input class="form-control" type="text" id="Nome" name="nome" placeholder="Inserisci Nome." required/>
			</div>
	
			<div  class="form-group">
				<input class="form-control" type="text" id="Cognome" name="cognome" placeholder="Inserisci Cognome" required/>
			</div>
			<div  class="form-group">
				<input class="form-control" type="tel" id="Telefono" name="telefono" placeholder="Inserisci Numero di Telefono."  required />
			</div>
			
			<div  class="form-group">
			<!--  button class="btn btn-warning">Verifica dati inseriti</button-->
			<input class="btn btn-success" value="Registra Utente" type="submit"></input>
			</div>
	
          </form>
          

		<div class="text-center text-muted delimiter">oppure usa un social network!</div>
   		   <div class="d-flex justify-content-center social-buttons">
   		   	 <div class="g-signin2" data-onsuccess="onSignIn"></div>
          </div>   
        <div class="modal-footer d-flex justify-content-center">
        <div class="signup-section">Hai gia un account? <br/> <button type="button" class="btn btn-link" data-toggle="modal" data-target="#loginModal" data-dismiss="modal" id="loginButton">Accedi</button> </div>
     	</div>
        </div>
      </div>
    </div>

  </div>
</div>

<script>
$('#registerModal').on('shown.bs.modal', function () {
	$("body").addClass("modal-open");
	});
</script>
<script>
function onSignIn(googleUser) {
  var profile = googleUser.getBasicProfile();
  console.log('ID: ' + profile.getId()); // Do not send to your backend! Use an ID token instead.
  console.log('Name: ' + profile.getName());
  console.log('Email: ' + profile.getEmail()); // This is null if the 'email' scope is not present.
  
  //Per richiamare la servlet, necessario Ajax
  //$.Ajax (...)
}
</script>

 <script src="https://apis.google.com/js/platform.js?onload=renderButton" async defer></script>
