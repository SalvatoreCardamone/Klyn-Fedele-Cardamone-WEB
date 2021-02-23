/**
 * 
 */


var listaUtenti= [];

function visualizzaUtente()
{
	$.ajax({
	url: "adminListaUtenti",
	method: "POST",
	//data: {id: idBiglietto},<- passo io al servlet
	success: function(response){
		listaUtenti=responce;
		
	},
	fail: function() {
	alert("errore");
	}
});
}