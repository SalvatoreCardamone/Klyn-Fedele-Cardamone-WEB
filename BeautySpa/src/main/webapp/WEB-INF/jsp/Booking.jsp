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
		$("#prenota").attr("id","selectedItem");
	});
	</script>
</head>

<body>

	<!--  NAV -->
	<jsp:include page="nav.jsp"/>
	<!-- /NAV -->

<h1 style="text-align: center;"> WORK IN PROGRESS .. </h1>
<img src="../image/maintenance.png" class="rounded mx-auto d-block">

	<!--  FOOTER -->
	<jsp:include page="footer.jsp"/>
	<!-- /FOOTER -->

</body>

</html>