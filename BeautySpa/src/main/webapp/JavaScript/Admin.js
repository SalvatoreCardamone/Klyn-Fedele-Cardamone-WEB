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