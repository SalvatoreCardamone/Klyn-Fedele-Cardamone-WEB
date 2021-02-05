/**
 * 
 */

function registraUtente()
{
	
	var email= document.querySelector("#Email").value;
	var password= document.querySelector("#Password").value;
	//var matricola=$("#matricola").val();//uguale con quello di sopra(JQuery)
	var nome= document.querySelector("#Nome").value;
	var cogn= document.querySelector("#Cognome").value;
	
	var utente= new Utente(email, password, nome, cogn, false);
	
	
	//{matr:matr, cognome:cogn, nome:nome, date:date, scuolaId:scuola}
	
	$.ajax(
	{
		//eticketta ,variabbile
		url: "registraUtenteObj",
		method: "POST",
		//data: studente,
		//contentType:"json",
		data: JSON.stringify(utente),
		contentType: "application/json",
		success: function(responce)
		{
		console.log(JSON.stringify(responce));
		/*
			if(responce==="SUCCESS")
			{
			
			var studente= new Studente(matr, nome, cogn, date, scuola);
	
			aggiungiStudente(studente);
			
			
			//qui viene richiamato da ServizziController con "SUCCESS" importante mettere il parametro succes
			}
			//alert(responce);
		*/
		},
		fail:function(jqXHR, textStatus)
		{
			alert("Request failed:"+ textStatus);
		}
	}
	);
	alert("Utente Iscritto passato")
	//alert("studente iscritto "+nome);
}
