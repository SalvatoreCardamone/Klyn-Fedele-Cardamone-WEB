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
				<input type="password" class="form-control" type="text" id="Password" placeholder="Inserisci Password" name="password" pattern="^([a-zA-Z0-9@*#]{6,30})$"  oninvalid="this.setCustomValidity('Perfavore inserire corettamente la password (da 6 a 30 caratteri comprsi(@*#))')"
 					oninput="setCustomValidity('')" required/>
			</div>
	
			<div  class="form-group">
				<input class="form-control" type="text" id="Nome" name="nome" placeholder="Inserisci Nome." required/>
			</div>
	
			<div  class="form-group">
				<input class="form-control" type="text" id="Cognome" name="cognome" placeholder="Inserisci Cognome" required/>
			</div>
			<div  class="form-group">
				<input class="form-control" type="tel" id="Telefono" name="telefono" placeholder="Inserisci Numero di Telefono." pattern="^(\(?\+?[0-9]*\)?)?[0-9_\- \(\)]{10,20}$"  oninvalid="this.setCustomValidity('Perfavore inserire corettamente il numero di telefono(da 10a 20 cifre compreso(+_))')"
 					oninput="setCustomValidity('')"  />
			</div>
			
			<div  class="form-group">
			<!--  button class="btn btn-warning">Verifica dati inseriti</button-->
			<input class="btn btn-success" value="Registra Utente" type="submit"></input>
			</div>
	
          </form>
          

		<div class="text-center text-muted delimiter">oppure usa un social network!</div>
   		   <div class="d-flex justify-content-center social-buttons">
   		   	    <div class="g-signin2" onclick="ClickLogin()" data-onsuccess="onSignUp"></div>

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


var clicked=false;//Global Variable
var primoContr=false;//Global Variable
function ClickLogin()
{
    clicked=true;
}
   


function onSignUp(googleUser) {
	
 if (clicked) {
  var profile = googleUser.getBasicProfile();
	  var email=profile.getEmail();
  	  var password=profile.getId();
  	  var nomeCognome=profile.getName();
  	  
      var form = document.createElement("form");
      var element1 = document.createElement("input"); 
      var element2 = document.createElement("input");  
      var element3 = document.createElement("input"); 
      
      form.method = 'POST';
      form.action = '/loginGoogle';   

      element1.value = email;
      element1.name='email';
      form.appendChild(element1);  

      element2.value = password;
      element2.name = 'password';
      form.appendChild(element2);

      element3.value = nomeCognome;
      element3.name = 'nomeCognome';
      form.appendChild(element3);
      
      document.body.appendChild(form);

      form.submit();
        }
	  
}
</script>

<script>
$('#registerModal').on('shown.bs.modal', function () {
	$("body").addClass("modal-open");
	});
</script>


 <script src="https://apis.google.com/js/platform.js?onload=renderButton" async defer></script>
