/**
 * 
 */


window.addEventListener("load",function()
{
	//inizializzaDati();
	//popolaTabella();
	//visualizzaUtente();
	//visualizzaRecensioni();
});

var listaUtenti= [];
var listaRecensioni= [];



function eliminaRecensione(id)
{
	$.ajax({
	url: "adminEliminaRecensione",
	method: "POST",
	data: {idRecensione: id},//<- passo io al servlet
	success: function(response){
		listaRecensioni=response;
		$('#listaRecensioni'+id).remove();
	},
	fail: function() {
	alert("errore");
	}
});
}

function eliminaPrenotazione(id)
{
	$.ajax({
	url: "adminEliminaPrenotazione",
	method: "POST",
	data: {idRecensione: id},//<- passo io al servlet
	success: function(response){
		listaRecensioni=response;
		$('#listaPrenotazione'+id).remove();
	},
	fail: function() {
	alert("errore");
	}
});
}


function modificaTrattamentoJS(id, nome, descrizione)
{
	//alert("id "+id+" "+nome+" "+descrizione);
	
	$.ajax({
	url: "adminUpdateTrattamento",
	method: "POST",
	//idTrattamento,String nomeTrattamento ,String descrizioneTrattamento
	data: {idTrattamento: id, nomeTrattamento: nome, descrizioneTrattamento: descrizione},//<- passo io al servlet
	success: function(response){
		listaRecensioni=response;
		//$('#listaPrenotazione'+id).remove();
	},
	fail: function() {
	alert("errore");
	}
});
}

function modificaRecensioneJS(id,descrizione,date,scritto,voto)
{
	$.ajax({
	url: "adminUpdateRecensione",
	method: "POST",
	
	/*Integer idRecensione,
			String descrizioneRecensione,
			Date dateRecensione, 
			String scrittoRecensione,
			Integer votoRecenzione,
	*/
	data: {idRecensione: id, descrizioneRecensione: descrizione, dateRecensione: date, scrittoRecensione: scritto, votoRecensione:voto },//<- passo io al servlet
	success: function(response){
		listaRecensioni=response;
		//$('#listaPrenotazione'+id).remove();
	},
	fail: function() {
	alert("errore");
	}
});
}


function modificaPrenotazioneJS(id,utente,time,date,persone,trattamento)
{
	
	$.ajax({
	url: "adminUpdatePrenotazione",
	method: "POST",
	
	/*Integer idRecensione,
			String descrizioneRecensione,
			Date dateRecensione, 
			String scrittoRecensione,
			Integer votoRecenzione,
	*/
	data: {idPrenotazione: id, utentePrenotazione: utente, timePrenotazione: time, datePrenotazione: date, personePrenotazione: persone, trattamentoPrenotazione: trattamento},
	success: function(response){
		listaRecensioni=response;
		//$('#listaPrenotazione'+id).remove();
	},
	fail: function() {
	alert("errore");
	}
});
}

/*
function visualizzaRecensioni()
{
	$.ajax({
	url: "adminListaRecensioni",
	method: "POST",
	//data: {id: idBiglietto},<- passo io al servlet
	success: function(response){
		listaRecensioni=response;
		alert("Response visualizza");
		alert(listaRecensioni.length);
		for(var i=0; i<listaRecensioni.length; i++)
		{
		$('#tabellaRecensioni').append('<tr id=riga'+i+'>');
		$('#riga'+i).append('<td id=colonna'+ i + '0>');
		$('#colonna'+i+ '0').html(listaRecensioni[i].idRecensione);
		$('#riga'+i).append('</td>');
		$('#riga'+i).append('<td id=colonna'+ i + '1>');
		$('#colonna'+i+ '1').html(listaRecensioni[i].descrizione);
		$('#riga'+i).append('</td>');
		$('#riga'+i).append('<td id=colonna'+ i + '2>');
		$('#colonna'+i+ '2').html(listaRecensioni[i].date);
		$('#riga'+i).append('</td>');
		$('#riga'+i).append('<td id=colonna'+ i + '3>');
		$('#colonna'+i+ '3').html(listaRecensioni[i].scrittoDa);
		$('#riga'+i).append('</td>');
		$('#riga'+i).append('<td id=colonna'+ i + '4>');
		$('#colonna'+i+ '4').html(listaRecensioni[i].vot);
		$('#riga'+i).append('</td>');
		$('#riga'+i).append('<td id=colonna'+ i + '5>');
		$('#colonna'+i+ '5').html("elimina");
		$('#riga'+i).append('</td>');
		$('#tabellaRecensioni').append('</tr>');
		}
		alert("Fuori for");
	},
	fail: function() {
	alert("errore");
	}
});
}


function tableCreateUtenti(){
    var body = document.body,
        tbl  = document.createElement('table');
    tbl.style.width  = '100px';
    tbl.style.border = '1px solid black';

	listaRecensioni
    for(var i = 0; i < 3; i++){
        var tr = tbl.insertRow();
        for(var j = 0; j < 2; j++){
            
                var td = tr.insertCell();
                td.appendChild(document.createTextNode('Cell'));
                td.style.border = '1px solid black';
                
                    td.setAttribute('rowSpan', '2');
           
            
        }
    }
    body.appendChild(tbl);
}
*/

/*
function visualizzaUtente()
{
	$.ajax({
	url: "adminListaUtenti",
	method: "POST",
	//data: {id: idBiglietto},<- passo io al servlet
	success: function(response){
		listaUtenti=response;
		
		for(var i=0; i<listaUtenti.length; i++)
		{
		$('#tabellaUtenti').append('<tr id=riga'+i+'>');
		$('#riga'+i).append('<td id=colonna'+ i + '0>');
		$('#colonna'+i+ '0').html(listaUtenti[i].email);
		$('#riga'+i).append('</td>');
		$('#riga'+i).append('<td id=colonna'+ i + '1>');
		$('#colonna'+i+ '1').html(listaUtenti[i].nome);
		$('#riga'+i).append('</td>');
		$('#riga'+i).append('<td id=colonna'+ i + '2>');
		$('#colonna'+i+ '2').html(listaUtenti[i].cognome);
		$('#riga'+i).append('</td>');
		$('#riga'+i).append('<td id=colonna'+ i + '3>');
		$('#colonna'+i+ '3').html(listaUtenti[i].numero);
		$('#riga'+i).append('</td>');
		$('#tabellaUtenti').append('</tr>');
	
		}
		alert("Fuori for");
	},
	fail: function() {
	alert("errore");
	}
});
}
*/