
function verificaLogin()
{
	var ema= document.querySelector("#email").value;
	var pass= document.querySelector("#password").value;
	
	$.ajax(
	{
		url: "verificaLogin",
		method: "POST",
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
	);​​
}