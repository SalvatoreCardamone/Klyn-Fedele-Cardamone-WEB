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
                            <div class="col-xs-12 col-sm-10 col-md-10 col-lg-10">
                                <div class="tab-content">
                                    <div class="tab-pane active" id="basic">
                                        <form class="container" method="POST" action="/modificaUtente" id="reviewFormContainer">
                                            <div class="form-group">
                                                <label for="input_email" class="col-lg-2 control-label">Email</label>
                                                <div class="col-lg-10">
                                                    <input type="email" class="form-control" id="input_email" name="Email" value="${utente.email}"  readonly>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                            <label for="input_password" class="col control-label">Password</label>
                                            <div class="row">
                                                <div class="col">
                                                    <input type="password" class="form-control" placeholder="Inserisci vecchia password" id="input_password_vecchia" name="oldPassword"  pattern="^([a-zA-Z0-9@*#]{6,30})$"  oninvalid="this.setCustomValidity('Perfavore inserire corettamente la password (da 6 a 30 caratteri comprsi(@*#))')" oninput="setCustomValidity('')" disabled required/>
                                                </div>
                                                <div class="col">
                                                 <input type="password" class="form-control" placeholder="Inserisci nuova password" id="input_password_nuova" name="Password"  pattern="^([a-zA-Z0-9@*#]{6,30})$"  oninvalid="this.setCustomValidity('Perfavore inserire corettamente la password (da 6 a 30 caratteri comprsi(@*#))')" oninput="setCustomValidity('')" disabled required/>       
                                           		</div>
                                           	</div>
                                            </div>
                                            <div class="form-group">
                                                <div class="row">
                                                    <div class="col">
                                                        <label for="input_nome" class="col control-label">Nome</label>
                                                        <input type="text" class="form-control" id="input_nome" name="Nome" value="${utente.nome}" disabled >
                                                       </div>
                                                       <div class="col">
                                                        <label for="input_cognome" class="col control-label">Cognome</label>
                                                        <input type="text" class="form-control" id="input_cognome" name="Cognome" value="${utente.cognome}"  disabled>
                                                       </div>
                                                   </div>
                                            </div>
                                            <div class="form-group">
                                                <label for="input_numero" class="col-lg-2 control-label" >Numero di Telefono</label>
                                                <div class="col-lg-10">
                                                    <input type="tel" class="form-control" id="input_telefono" name="Telefono" value="${utente.numero}" pattern="^(\(?\+?[0-9]*\)?)?[0-9_\- \(\)]{10,20}$"  oninvalid="this.setCustomValidity('Perfavore inserire corettamente il numero di telefono(da 10a 20 cifre compreso(+_))')" oninput="setCustomValidity('')" disabled/>
                                                </div>
                                            </div>     
                                        </form>
                                         <button class="btn btn-success btn-block" onclick ="Modifica()" id="bottoneModifica">Modifica</button>
                                    </div>
                                </div>
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
    
    <!--  FOOTER -->
    <jsp:include page="footer.jsp"/>
    <!-- /FOOTER -->

</body>

<script>

	function Modifica(){
	
			$("#bottoneModifica").text("Conferma modifiche");
		
			if( document.getElementById('input_password_nuova').disabled== false)
				{
				    document.getElementById("reviewFormContainer").submit();
					$("#input_password_nuova" ).prop( "disabled", true );
					$("#input_password_vecchia" ).prop( "disabled", true );
					$("#input_nome").prop( "disabled", true );
					$("#input_cognome").prop( "disabled", true );
					$("#input_telefono").prop( "disabled", true );
			}
			else{
				$("#input_password_nuova").prop( "disabled", false);
				$("#input_password_vecchia").prop( "disabled", false);
				$("#input_nome").prop( "disabled",false );
				$("#input_cognome").prop( "disabled", false );
				$("#input_telefono").prop( "disabled", false );
				document.getElementById("bottoneModifica").value = "Invia";
			}
		
		
	}
</script>

</html>

