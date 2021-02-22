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
<div class="container bootstrap snippets bootdey">
    <hr>
    <div class="row">
        <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
            <div class="well profile">
                <img class="user img-circle pull-left clearfix" height="54" src="https://bootdey.com/img/Content/user_1.jpg" alt="">
                <h3 class="name pull-left clearfix">juan andres posada</h3>
                <div class="clearfix"></div>
                <ul class="nav nav-tabs">
                    <li class="active">
                        <a href="#tab" data-toggle="tab">
                            Account
                        </a>
                    </li>
                    <li class="">
                        <a href="#tab2" data-toggle="tab">
                            Prenotazioni
                        </a>
                    </li>
                </ul>
                <div class="tab-content">
                    <div class="tab-pane" id="tab2">
                    <div class="container-fluid">
                        <div class="row">
                               	<table>
                        			<c:forEach items="${bookingList}" var="tmp" varStatus="loopBooking">
                        				<tr>
                        					<th> 
                        						<div class="col-sm" id="booking-review_element">
                        							${tmp.date}
                        						</div>
                        					</th>
                        					<th> 
                        						<div class="col-sm" id="booking-review_element">
                        							${tmp.time}
                        						</div>
                        					</th>
                        					<th> 
                        						<c:forEach items="${serviceList}" var="tmpY">
                        							<c:choose>
                        								<c:when test="${tmpY.id == tmp.trattamento}">
                        									<div class="col-sm" id="booking-review_element">
                        									${tmpY.nome}
                        									</div>
                        								</c:when>	
                        							</c:choose>
                        						</c:forEach>
                        					</th>
                        					<th>
                        						<div class="col-sm" id="booking-review_element">
                        							${tmp.persone} &nbsp Persone
                        						</div>
                        					</th>
                        					<th>
                        						<form action="/DeleteBooking">
                        							<input type="number" id="id" name="id" value="${tmp.id}" style="display:none">
                        							<button type="submit" onclick="deleteBooking()" id="booking-review_button"> cancella</button>
                        						</form>
                        					</th>
                        					<th>
                        						<c:forEach items="${listaCount}" var="tmpCount"> 
               										<c:if test="${tmpCount.value == loopBooking.count}">
                        								<form action="/PrintBooking">
                        									<input type="number" name="idStampa" value="${tmp.id}" style="display:none">
                        									<input type="date" name="idDataDaStampare" value="${tmpCount.key}" style="display:none">
                        									<button type="submit" onclick="PrintBooking()" id="booking-review_button"> stampa</button>
                        							</form>
                        							</c:if>
                        						</c:forEach>
                        					</th>
                        				</tr>
                        			</c:forEach>
                        		</table>
                                <hr>
                        </div>
                    </div>
                    </div>
                    <div class="tab-pane active" id="tab">
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
                                             	<label for="input_password" class="col-lg-2 control-label" disabled="true">Vechia password</label>
                                                <div class="col-lg-10">
                                                    <input type="password" class="form-control" placeholder="Inserisci password vechia" id="input_password_vecchia" name="oldPassword"  pattern="^([a-zA-Z0-9@*#]{6,30})$"  oninvalid="this.setCustomValidity('Perfavore inserire corettamente la password (da 6 a 30 caratteri comprsi(@*#))')" oninput="setCustomValidity('')" disabled/>
                                                </div>
                                                <label for="input_password" class="col-lg-2 control-label" disabled>Nuova password</label>
                                                <div class="col-lg-10">
                                                    <input type="password" class="form-control" placeholder="Inserisci nuova password" id="input_password_nuova" name="Password"  pattern="^([a-zA-Z0-9@*#]{6,30})$"  oninvalid="this.setCustomValidity('Perfavore inserire corettamente la password (da 6 a 30 caratteri comprsi(@*#))')" oninput="setCustomValidity('')" disabled/>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class="row">
                                                    <div class="col">
                                                        <label for="input_nome" class="col-lg-2 control-label">Nome</label>
                                                        <input type="text" class="form-control" id="input_nome" name="Nome" value="${utente.nome}" disabled >
                                                       </div>
                                                       <div class="col">
                                                        <label for="input_cognome" class="col-lg-2 control-label">Cognome</label>
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
    
    
    <!--  FOOTER -->
    <jsp:include page="footer.jsp"/>
    <!-- /FOOTER -->

</body>

<script>

	function Modifica(){
	
			
		
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

