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
    <form>                    		
    <button type="submit" action="/adminPrenotazioni" id="booking-review_button"> Vedi tutti utenti</button>
	<button type="submit" action="/adminTuttiPrenotazioni" id="booking-review_button"> Vedi tutti prenotazioni</button>								
	<button type="submit" action="/adminPrenotazioniUtente" id="booking-review_button"> Vedi prenotazioni di un certo utente(id)</button>
	<button type="submit" action="/adminEliminaPrenotazione" id="booking-review_button"> Elimina una prenotazione(id)</button>								
	<button type="submit" action="/adminUpdateTrattamento" id="booking-review_button"> Modifica Trattamento</button>
	</form>
	
	<table>
	
	</table>
	
</body>
</html>

