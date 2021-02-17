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
		$("#galleria").attr("id","selectedItem");
	});
	</script>
</head>

<body>

	<!--  NAV -->
	<jsp:include page="nav.jsp"/>
	<!-- /NAV -->

 <div id="Slider" class="carousel slide" data-ride="carousel" data-interval="3000">
    <!-- Indicators -->
  <ul class="carousel-indicators">
    <li data-target="#Slider" data-slide-to="0" class="active"></li>
    <li data-target="#Slider" data-slide-to="1"></li>
    <li data-target="#Slider" data-slide-to="2"></li>
    <li data-target="#Slider" data-slide-to="3"></li>
  </ul>

  <!-- SliderShower -->
  <div class="carousel-inner">
    <div class="carousel-item active">
      <img src="../image/ads1.jpg" class="slider_image">
    </div>
    <div class="carousel-item">
      <img src="../image/ads2.jpg" class="slider_image">
    </div>
    <div class="carousel-item">
      <img src="../image/stock3.jpg" class="slider_image">
    </div>
    <div class="carousel-item">
      <img src="../image/stock2.jpg" class="slider_image">
    </div>
  </div>

  <!-- Slider Controls -->
  <a class="carousel-control-prev" href="#Slider" data-slide="prev">
    <span class="carousel-control-prev-icon"></span>
  </a>
  <a class="carousel-control-next" href="#Slider" data-slide="next">
    <span class="carousel-control-next-icon"></span>
  </a>
</div>

<div>
	<h1 class="gallery_title">PHOTO GALLERY
	</h1>
</div>


<!-- FOTO GALLERY -->
<div class="row">
  <div class="column">
    <img class="gallery_pic" src="../image/gallery1.jpg">
    <img class="gallery_pic" src="../image/gallery2.jpg">
    <img class="gallery_pic" src="../image/gallery3.jpg">
    <img class="gallery_pic" src="../image/gallery4.jpg">
    <img class="last_gallery_pic" src="../image/gallery5.jpg">
    
  </div>
  <div class="column">
    <img class="gallery_pic" src="../image/gallery9.jpg">
	<img class="gallery_pic" src="../image/gallery1.jpg">
    <img class="gallery_pic" src="../image/gallery2.jpg">
    <img class="gallery_pic" src="../image/gallery3.jpg">
    <img class="last_gallery_pic" src="../image/gallery4.jpg">
  </div>
  <div class="column">
	<img class="gallery_pic" src="../image/gallery3.jpg">
    <img class="gallery_pic" src="../image/gallery4.jpg">
    <img class="gallery_pic" src="../image/gallery5.jpg">
    <img class="gallery_pic" src="../image/gallery6.jpg">
    <img class="last_gallery_pic" src="../image/gallery6.jpg">
  </div>
  <div class="column">
   	<img class="gallery_pic" src="../image/gallery7.jpg">
    <img class="gallery_pic" src="../image/gallery3.jpg">
    <img class="gallery_pic" src="../image/gallery4.jpg">
    <img class="gallery_pic" src="../image/gallery6.jpg">
  </div>
  
</div>
	<!--  REVIEW -->
	<jsp:include page="review.jsp"/>

	<!--  FOOTER -->
	<jsp:include page="footer.jsp"/>
	<!-- /FOOTER -->


</body>

</html>