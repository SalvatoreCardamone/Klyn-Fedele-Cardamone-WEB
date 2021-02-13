<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!--  login popup -->
<div class="modal fade" id="loginModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-header border-bottom-0">
        <button type="button" class="close" data-dismiss="modal">
          x
        </button>
      </div>
      <div class="modal-body">
        <div class="form-title text-center">
          <h4>Accedi</h4>
        </div>
        <div class="d-flex flex-column text-center">
          <form class="container" method="POST" action="/login">
            <div class="form-group">
              <input type="email" class="form-control" id="email" placeholder="Inserisci il tuo indirizzo e-mail..." name="email">
            </div>
            <div class="form-group">
              <input type="password" class="form-control" id="password" placeholder="Inserisci la tua password..." name="password">
            </div>
            <button class="btn btn-success btn-block" type="submit">Login</button>
          </form>
          
          <c:if test ="${ utente!=null}"> 
          <div class="text-center text-muted delimiter">  Benvenuto ${utente} </div>
		  </c:if>
          </div>   
        <div class="modal-footer d-flex justify-content-center">
        <div class="signup-section">Non hai un account? <br/> <button type="button" class="btn btn-link" data-toggle="modal" data-target="#registerModal" data-dismiss="modal" id="registerButton">Registrati Ora</button></div>
 
     	 </div>
        </div>
      </div>
    </div>

  </div>

<script>
$('#loginModal').on('shown.bs.modal', function () {
	$("body").addClass("modal-open");
	});
</script>
