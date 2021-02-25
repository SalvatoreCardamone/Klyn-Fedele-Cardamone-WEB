<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
    
    
<!DOCTYPE html>
<html>
<head>
    <!-- Importing resources -->
    <jsp:include page="imports.jsp"/>
    <script src='../JavaScript/Admin.js'></script>
</head>
<body>         		
	
	<!--  button onclick="visualizzaUtente();">Visualizza Utenti</button>
	
	<table id="tabellaUtenti">
	</table>
	
	
	<button onclick="tableCreateUtenti()">CreaTabella</button-->
	
	<h2> Lista Utenti </h2>
	<table class="table" >
  <thead class="thead-light">
    <tr>
      <th scope="col">EMAIL</th>
      <th scope="col">NOME</th>
      <th scope="col">COGNOME</th>
      <th scope="col">TELEFONO</th>
    </tr>
  </thead>
  <tbody>
  
  <c:forEach items="${listaUtenti}" var="utente">
    <tr id="${utente.email}">
      <th scope="row" >${utente.email}</th>
      <td>${utente.nome}</td>
      <td>${utente.cognome}</td>
      <td>${utente.numero}</td>
    </tr>
 </c:forEach>
  </tbody>
</table>
<hr/>
  
  
  <!--  button onclick="visualizzaRecensioni()"> visualizza recensioni</button>
  
  <table id="tabellaRecensioni">
	</table-->
  
 <h2> Lista Recensioni </h2>
	<table class="table" >
  <thead class="thead-light">
    <tr>
      <th scope="col">ID Recensione</th>
      <th scope="col">Descrizione</th>
      <th scope="col">Data</th>
      <th scope="col">Creatore</th>
      <th scope="col">Voto</th>
      <th scope="col">Cancella</th>
      <th scope="col">Modifica</th>
    </tr>
  </thead>
  <tbody>
  
  <c:forEach items="${listaRecensioni}" var="recensione">
    <tr id="listaRecensioni${recensione.idRecensione}">
      <th scope="row">${recensione.idRecensione}</th>
      
      <td><input type="text" class="form-control" id="input_recensione_descrizione${recensione.idRecensione}" name="Nome" value="${recensione.descrizione}" disabled ></td>
      <td><input type="date" class="form-control" id="input_recensione_data${recensione.idRecensione}" name="Nome" value="${recensione.data}" disabled ></td>
      <td><input type="text" class="form-control" id="input_recensione_scrittoDa${recensione.idRecensione}" name="Nome" value="${recensione.scrittoDa}" disabled ></td>
      <td><input type="number" class="form-control" id="input_recensione_voto${recensione.idRecensione}" name="Nome" value="${recensione.voto}" disabled ></td>
      <td>
		<button type="button" onclick="eliminaRecensione(${recensione.idRecensione})" id="booking-review_button"> cancella</button>
      </td>
      
      <td>
		<button type="button"  id="bottoneModificaRecensione${recensione.idRecensione}" onclick ="modificaRecensione(${recensione.idRecensione})"> modifica </button>      </td>
    </tr>
 </c:forEach>
  </tbody>
</table>



<h2> Lista Prenotazioni </h2>
	<table class="table" >
  <thead class="thead-light">
    <tr>
      <th scope="col">ID Prenotazione</th>
      <th scope="col">Utente</th>
      <th scope="col">Time</th>
      <th scope="col">Data</th>
      <th scope="col">Persone</th>
      <th scope="col">Trattamento</th>
      <th scope="col">Cancella</th>
      <th scope="col">Modifica</th>
    </tr>
  </thead>
  <tbody>
  
  <c:forEach items="${listaPrenotazioni}" var="prenotazione">
    <tr id="listaPrenotazione${prenotazione.id}">
      <th scope="row">${prenotazione.id}</th>
      <td><input type="text" class="form-control" id="input_prenotazione_utente${prenotazione.id}" name="Nome" value="${prenotazione.utente}" disabled ></td>
      <td><input type="time" step="1" class="form-control" id="input_prenotazione_time${prenotazione.id}" name="Nome" value="${prenotazione.time}" disabled ></td>
      <td><input type="date" class="form-control" id="input_prenotazione_date${prenotazione.id}" name="Nome" value="${prenotazione.date}" disabled ></td>
      <td><input type="number" class="form-control" id="input_prenotazione_persone${prenotazione.id}" name="Nome" value="${prenotazione.persone}" disabled ></td>
      <td><input type="number" class="form-control" id="input_prenotazione_trattamento${prenotazione.id}" name="Nome" value="${prenotazione.trattamento}" disabled ></td>
      
      <td>
		<button type="button"  id="booking-review_button" onclick="eliminaPrenotazione(${prenotazione.id})"> cancella</button>
      </td>
      
      <td>
		<button type="button"  id="bottoneModificaPrenotazione${prenotazione.id}" onclick="modificaPrenotazione(${prenotazione.id})"> modifica</button>
      </td>
    </tr>
 </c:forEach>
  </tbody>
</table>



<h2> Lista Trattamenti </h2>
	<table class="table" id="trattamentiContainer" >
  <thead class="thead-light">
    <tr>
      <th scope="col">ID Trattamento</th>
      <th scope="col">Nome</th>
      <th scope="col">Descrizione</th>
      <th scope="col">Modifica</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${listaTrattamenti}" var="trattamento">
    <tr id="listaTrattamenti${trattamento.id}">
      <th scope="row">${trattamento.id}</th>
      <td><input type="text" class="form-control" id="input_trattamento_nome${trattamento.id}" name="Nome" value="${trattamento.nome}" disabled ></td>
      
      <td><textarea id="input_trattamento_descrizione${trattamento.id}" name="Name" rows="5" cols="50" disabled>${trattamento.descrizione}</textarea></td>
      
      <!--  td><!--  input type="text" class="form-control" id="input_trattamento_descrizione${trattamento.id}" name="Nome" value="${trattamento.descrizione}" disabled ></td-->
      <td>
		<button type="button"  id="bottoneModificaTrattamento${trattamento.id}" onclick ="modificaTrattamento(${trattamento.id})"> modifica </button>
      </td>
    </tr>
 </c:forEach>
  </tbody>
</table>

<hr/>
  
  
<script type="text/javascript">
function modificaTrattamento(id)
{			 
	if( document.getElementById("input_trattamento_nome"+id).disabled== false)
				{
				    $("#input_trattamento_nome"+id).prop( "disabled", true );
				    var nome = document.getElementById("input_trattamento_nome"+id);
				    
					$("#input_trattamento_descrizione"+id).prop( "disabled", true );
					var descrizione = document.getElementById("input_trattamento_descrizione"+id);
					
				    document.getElementById("bottoneModificaTrattamento"+id).innerHTML = "modifica";
				    modificaTrattamentoJS(id, nome.value, descrizione.value);
				}
				else{
				$("#input_trattamento_nome"+id).prop( "disabled", false );
				$("#input_trattamento_descrizione"+id).prop( "disabled", false );
				document.getElementById("bottoneModificaTrattamento"+id).innerHTML = "conferma";
			}
}


function modificaRecensione(id)
{
	
	if( document.getElementById("input_recensione_descrizione"+id).disabled== false)
				{ 
					$("#input_recensione_descrizione"+id).prop( "disabled", true );
					var descrizione = document.getElementById("input_recensione_descrizione"+id);
					
					$("#input_recensione_data"+id).prop( "disabled", true );
					var date = document.getElementById("input_recensione_data"+id);
					
					$("#input_recensione_scrittoDa"+id).prop( "disabled", true );
					var scritto = document.getElementById("input_recensione_scrittoDa"+id);
					
					$("#input_recensione_voto"+id).prop( "disabled", true );
					var voto = document.getElementById("input_recensione_voto"+id);
					
				    document.getElementById("bottoneModificaRecensione"+id).innerHTML = "modifica";
				    modificaRecensioneJS(id,descrizione.value,date.value,scritto.value,voto.value);
				}
				else{
				$("#input_recensione_descrizione"+id).prop( "disabled", false );
				$("#input_recensione_data"+id).prop( "disabled", false );
				$("#input_recensione_scrittoDa"+id).prop( "disabled", false );
				$("#input_recensione_voto"+id).prop( "disabled", false );
				document.getElementById("bottoneModificaRecensione"+id).innerHTML = "conferma";
			}
	
}



function modificaPrenotazione(id)
{
	
	if( document.getElementById("input_prenotazione_time"+id).disabled== false)
				{ 
					//$("#input_prenotazione_utente"+id).prop( "disabled", true );
					var utente = document.getElementById("input_prenotazione_utente"+id);
					
					$("#input_prenotazione_time"+id).prop( "disabled", true );
					var time = document.getElementById("input_prenotazione_time"+id);
					
					$("#input_prenotazione_date"+id).prop( "disabled", true );
					var date = document.getElementById("input_prenotazione_date"+id);
					
					$("#input_prenotazione_persone"+id).prop( "disabled", true );
					var persone = document.getElementById("input_prenotazione_persone"+id);
					
					$("#input_prenotazione_trattamento"+id).prop( "disabled", true );
					var trattamento = document.getElementById("input_prenotazione_trattamento"+id);
					
				    document.getElementById("bottoneModificaPrenotazione"+id).innerHTML = "modifica";
				    
				    modificaPrenotazioneJS(id,utente.value,time.value,date.value,persone.value,trattamento.value)
				    //modificaRecensioneJS(id,descrizione.value,date.value,scritto.value,voto.value);
				}
				else{
				//$("#input_prenotazione_utente"+id).prop( "disabled", false );
				$("#input_prenotazione_time"+id).prop( "disabled", false );
				$("#input_prenotazione_date"+id).prop( "disabled", false );
				$("#input_prenotazione_persone"+id).prop( "disabled", false );
				$("#input_prenotazione_trattamento"+id).prop( "disabled", false );
				document.getElementById("bottoneModificaPrenotazione"+id).innerHTML = "conferma";
			}
}

</script>
	
</body>
</html>

