<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="it">
<head>

	<!-- Importing resources -->
	<jsp:include page="imports.jsp"/>

	<!-- Do When page is loaded -->
	<script>
	$(document).ready(function()
	{
		$("#home").attr("id","selectedItem");
	});
	</script>
</head>

<body>

	<!--  NAV -->
	<jsp:include page="nav.jsp"/>
	<!-- /NAV -->
	
<div class="bgimg-1">
  <div class="caption">
  <span class="border" id="block">Benvenuto su Beauty SPA</span>
  </div>
</div>

<div class="description">
  <h3 style="text-align:center;">Entra nel mondo del relax</h3>
  <p>La Beauty SPA, un ambiente accogliente e rilassante, è ideale per ritrovare relax e benessere. Il Percorso benessere SPA comprende due piscine con acqua termale dalle proprietà benefiche e salutari, una piscina esterna con idromassaggio e vista sul parco termale, sauna finlandese, bagno turco, bagno mediterraneo, docce emozionali, percorso Kneipp, cascata di ghiaccio, area relax e la stanza del sale, dove l'aria satura di iodio dona sollievo alle vie respiratorie.</p>
</div>

<div class="bgimg-2">
  <div class="caption">
  <span class="border" id="block">Il benessere attende</span>
  </div>
</div>

<div style="position:relative;">
  <div class="stripe">
  <p>I nostri ospiti potranno gustare delle calde tisane e mangiare delle gelatine di frutta nella sala relax o, in estate, nel solarium. Una giornata da dedicare alla cura del corpo e della mente per riscoprire equilibrio ed energia e godere dei benefici del relax. Il benessere degli ospiti si arricchisce di trattamenti estetici per il corpo e il viso, massaggi e rituali che regalano sensazioni indimenticabili.</p>
  </div>
</div>

<div class="bgimg-3">
  <div class="caption">
  <span class="border" id="block">Cura il corpo e la mente</span>
  </div>
</div>

<div style="position:relative;">
  <div class="stripe">
  <p>Arricchisci la tua giornata di benessere con un trattamento estetico pensato per la tua bellezza. Nella sezione Prenota troverai tanti massaggi, trattamenti viso e corpo rilassanti, tonificanti e snellenti.</p>
  </div>
</div>

<div class="bgimg-4">
  <div class="caption">
  <a href="/Booking"><button type="button" class="btn btn-outline-primary btn-lg" style="font-size: 2em;">PRENOTA ORA</button> </a>
  </div>
</div>

	<!--  FOOTER -->
	<jsp:include page="footer.jsp"/>
	<!-- /FOOTER -->
	<a href="/PageAdmin"><button type="button" class="btn btn-outline-primary btn-lg" style="font-size: 2em;">Area riservata</button> </a>
</body>

</html>