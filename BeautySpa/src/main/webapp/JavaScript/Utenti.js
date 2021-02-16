
function verificaLogin()
{
	var ema= document.querySelector("#email").value;
	var pass= document.querySelector("#password").value;
	//var studente= new Studente(matr, nome, cogn, date, scuola);
	
	$.ajax(
	{
		//eticketta ,variabbile
		url: "verificaLogin",
		method: "POST",
		//data: studente,
		//contentType:"json",
		data: {email: ema, password: pass},
		success: function(responce)
		{
			if(responce==="SUCCESS")
			{
				alert("ha funzionato");
			}
			else
				alert("non funziona!");
		
		},
		fail:function(jqXHR, textStatus)
		{
			alert("Request failed:"+ textStatus);
		}
	}
	);
	
	
	function mySubmitFunction()
{​​
  someBug()
  return false;
}​​
}