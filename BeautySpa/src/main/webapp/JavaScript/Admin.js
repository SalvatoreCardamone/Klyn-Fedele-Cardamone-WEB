
window.addEventListener("load",function()
{
	//FunzioneCaricamento();
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
	data: {idRecensione: id},
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
	$.ajax({
	url: "adminUpdateTrattamento",
	method: "POST",
	data: {idTrattamento: id, nomeTrattamento: nome, descrizioneTrattamento: descrizione},
	success: function(response){
		listaRecensioni=response;
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
	data: {idRecensione: id, descrizioneRecensione: descrizione, dateRecensione: date, scrittoRecensione: scritto, votoRecensione:voto },//<- passo io al servlet
	success: function(response){
		listaRecensioni=response;
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
	data: {idPrenotazione: id, utentePrenotazione: utente, timePrenotazione: time, datePrenotazione: date, personePrenotazione: persone, trattamentoPrenotazione: trattamento},
	success: function(response){
		listaRecensioni=response;
	},
	fail: function() {
	alert("errore");
	}
});
}
