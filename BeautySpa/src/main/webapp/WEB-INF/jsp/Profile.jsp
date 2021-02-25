<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
    
    
<!DOCTYPE html>
<html>
<head>
    <!-- Importing resources -->
    <jsp:include page="imports.jsp"/>
    
</head>
<body>

 

    <!--  NAV -->
    <jsp:include page="nav.jsp"/>
    <!-- /NAV -->
    
<c:if test="${utente != null}">
<div class="container bootstrap snippets bootdey">
    <hr>
    <div class="row">
        <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
            <div class="well profile">
                <h3 class="name pull-left clearfix">Il tuo profilo</h3>
                <div class="clearfix"></div>
                <ul class="nav nav-pills mb-3" id="pills-tab" role="tablist">
                    <li class="nav-item">
                        <a class="nav-link active" data-toggle="pill" href="#tab-prenotazioni" role="tab"  aria-selected="true">
                        Prenotazioni
                        </a>
                    </li>
                    
                    <li class="nav-item">
                        <a class="nav-link" id="pills-profile-tab" data-toggle="pill" href="#tab-account" role="tab" aria-selected="false">
                        Account
                        </a>
                    </li>
                </ul>
                <hr/>
                <div class="tab-content">
                    <div class="tab-pane active" id="tab-prenotazioni">
                    <div class="container-fluid">
                        <div class="row">
                               <table class="table table-hover">
							   <thead class="thead-light">
							    <tr>
							      <th scope="col">Data:</th>
							      <th scope="col">Ora:</th>
							      <th scope="col">Trattamento:</th>
							      <th scope="col" colspan="2">N. Persone:</th>
							    </tr>
							  </thead>
                              
                              <tbody>
                        			<c:forEach items="${bookingList}" var="tmp" varStatus="loopBooking">
                        				<tr>
                        					<td scope="row"> 
                        						${tmp.date}
                        					</td>
                        					<td> 
                        						${tmp.time}
                        					</td>
                        					<td> 
                        						<c:forEach items="${serviceList}" var="tmpY">
                        							<c:choose>
                        								<c:when test="${tmpY.id == tmp.trattamento}">
                        									${tmpY.nome}
                        								</c:when>	
                        							</c:choose>
                        						</c:forEach>
                        					</td>
                        					<td>
                        						<div class="col-sm" >
                        							${tmp.persone}
                        						</div>
                        					</td>
                        					<th>
                        						<form action="/DeleteBooking">
                        							<input type="number" id="id" name="id" value="${tmp.id}" style="display:none">
                        							<button type="submit" class="btn btn-outline-danger"> cancella</button>
                        						</form>
                        					</th>
                        				</tr>
                        				<c:forEach items="${listaCount}" var="tmpCount"> 
               								<c:if test="${tmpCount.value == loopBooking.count}">
               									<tr style="background-color: #FFFFFF !important"> 
	               									<th colspan="6">  
                        								<form action="/PrintBooking" target="_blank">
                        									<input type="date" name="idDataDaStampare" value="${tmpCount.key}" style="display:none">
                        									<button type="submit" class="btn btn-outline-success btn-block btn-lg"> stampa prenotazione del ${tmpCount.key} </button>
                        								</form>
	                        						</th>
                        						</tr>
                        					</c:if>
                        				</c:forEach>
                        				
                        			</c:forEach>
                        		</tbody>
                        		</table>
                                <hr>
                        </div>
                    </div>
                    </div>
                    <div class="tab-pane" id="tab-account">
                    <div class="row">
                    	<div class="input-group form-group">
	                         <label for="input_email" class="col-lg-2 control-label">Email:</label>
	                         <div class="col-5">
								<input type="text" class="form-control" placeholder="${utente.email}" disabled>
							 </div>
						</div>
                    </div>
                        <div class="row">
                           <div class="input-group form-group">
                             <label for="input_password" class="col-lg-2 control-label">Password:</label>
                             <form method="POST" action="/modificaPassword">
							 <div class="input-group-append">
							 
								  <input type="password" id="vecPassword" name="vecchiaPassword" class="form-control" placeholder="Vecchia Password" required>
								  <input type="password" id="nowPassword" name="nuovaPassword" class="form-control" placeholder="Nuova Password" pattern="^([a-zA-Z0-9@*#]{6,30})$"  oninvalid="this.setCustomValidity('Perfavore inserire correttamente la password (da 6 a 30 caratteri compresi(@*#))')" oninput="setCustomValidity('')" required>
								  <button type="submit" id="buttonPasModifica" class="btn btn-outline-primary" type="button">Modifica</button>
							
							 </div>
							 </form>
							</div> 
						</div>
					<div class="row">
                           <div class="input-group form-group">
                             <label for="input_name" class="col-lg-2 control-label">Nome:</label>
                              <form method="POST" action="/modificaCredenziali">
							 <div class="input-group-append">
							 
								  <input  name="nome" type="text" class="form-control" placeholder="${utente.nome}"  required>
								  <input name="cognome" type="text" class="form-control" placeholder="${utente.cognome}" required>
								  <button type="submit" class="btn btn-outline-primary" type="button">Modifica</button>
								  
							 </div>
							  </form>
							</div>     
                     </div>
                     <div class="row">
                           <div class="input-group form-group">
                             <label for="input_telephone" class="col-lg-2 control-label">Telefono:</label>
                              <form method="POST" action="/modificaTelefono">
							 <div class="input-group-append">
							 	<input name="telefono" type="tel" class="form-control" placeholder="${utente.numero}" pattern="^(\(?\+?[0-9]*\)?)?[0-9_\- \(\)]{10,20}$"  oninvalid="this.setCustomValidity('Perfavore inserire corettamente il numero di telefono(da 10a 20 cifre compreso(+_))')"
 									oninput="setCustomValidity('')"  required>
								<button type="submit" class="btn btn-outline-primary" type="button">Modifica</button>
							 </div>
							 </form>
							</div>     
                     </div>
                     
                    </div>
                  </div>
                        </div>
                    </div>
                </div>
            </div>      
</c:if>

<c:if test="${utente == null}">
	<div class="row justify-content-center">
		 <div class="card">
			  <div class="card-body">
			    <h5 class="card-title">Attenzione</h5>
			    <p class="card-text">Effettua il login per poter visualizzare il tuo profilo!</p>
				    <div class="row justify-content-center">
					  <button type="button" class="btn btn-primary my-2 my-sm-0" data-toggle="modal" data-target="#loginModal" id="loginButton"> Accedi </button>
					</div>
			 </div>
		</div>
	</div>
</c:if> 
    
 <c:if test="${google eq true}">
		  <script>
		  	$("#vecPassword").prop( "disabled", true );
			$("#nowPassword").prop( "disabled", true );
			$("#buttonPasModifica").prop( "disabled", true );
			document.getElementById("buttonPasModifica").innerHTML = "Entrato con google";
		  </script>
		  </c:if>
    
    <!--  FOOTER -->
    <jsp:include page="footer.jsp"/>
    <!-- /FOOTER -->

</body>

	
			

</html>

