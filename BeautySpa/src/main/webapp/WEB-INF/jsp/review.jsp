<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>












<div class="col-sm-10 ml-auto mr-auto text-center" id="Review">
	<h2 class="" id="review_head">Leggi le recensioni dei nostri clienti</h2>
	<div id="SliderReview" class="carousel slide" data-ride="carousel" data-interval="8000">
	
	<!-- Indicators -->
    	<ul class="carousel-indicators">
    		<li data-target="#Slider" data-slide-to="0" class="active"></li>
    		<li data-target="#Slider" data-slide-to="1"></li>
    		<li data-target="#Slider" data-slide-to="2"></li>
   			<li data-target="#Slider" data-slide-to="3"></li>
    		<li data-target="#Slider" data-slide-to="4"></li>
    		<li data-target="#Slider" data-slide-to="5"></li>
    	</ul>
	<!-- SliderShower --> 
		<div class="carousel-inner" >
 				<c:forEach items="${reviewList}" var="tmp" varStatus="loopCounter">
 					<c:choose>
 						<c:when test = "${loopCounter.count == 1}">
 							<div class="carousel-item active"> 
 							
 							<!-- REVIEW TEXT PRINT -->
								<div id="review_text"> 
									<i class="fa fa-quote-left" id="quotes"></i>
										${tmp.descrizione}
									<i class="fa fa-quote-right" id="quotes"></i> 
								</div> 
								<div class="row"> 
									<div class="col" id="review_author"> ${tmp.scrittoDa} </div>
									<div class="col" id="review_date"> ${tmp.data} </div>
 								</div>
 							<!-- STAR PRINT -->
 								<div class="raw" id="review_star">
 									<c:forEach begin="0" end="4" varStatus="starLoop">
 										<c:choose>
   											<c:when test="${starLoop.count <= tmp.voto}">
   											<i class="fa fa-star fa-3x checked" aria-hidden="true"></i>
   											</c:when>
   											<c:otherwise>
   											<i class="fa fa-star fa-3x" aria-hidden="true"></i>
   											</c:otherwise>
   										</c:choose>
									</c:forEach>
								</div>
							</div>	
 						</c:when>
 						<c:otherwise>
 							<div class="carousel-item"> 
 								<!-- REVIEW TEXT PRINT -->
								<div id="review_text"> 
									<i class="fa fa-quote-left" id="quotes" ></i>
										${tmp.descrizione}
									<i class="fa fa-quote-right" id="quotes"></i> 
								</div> 
								<div class="row"> 
									<div class="col" id="review_author"> ${tmp.scrittoDa} </div>
									<div class="col" id="review_date"> ${tmp.data} </div>
 								</div>
 							<!-- STAR PRINT -->
 								<div class="raw" id="review_star">
 									<c:forEach begin="0" end="4" varStatus="starLoop">
 										<c:choose>
   											<c:when test="${starLoop.count <= tmp.voto}">
   											<i class="fa fa-star fa-3x checked" aria-hidden="true"></i>
   											</c:when>
   											<c:otherwise>
   											<i class="fa fa-star fa-3x" aria-hidden="true"></i>
   											</c:otherwise>
   										</c:choose>
									</c:forEach>
								</div>
							</div>
						</c:otherwise>
					</c:choose>
 				</c:forEach>
 				
 				<c:if test="${utente != null}">
					  <button type="button" class="btn btn-outline-success my-2 my-sm-0" data-toggle="modal" data-target="#ReviewModal" id="review_button"> LASCIA QUI LA TUA RECENSIONE </button>
				</c:if>
				<c:if test="${utente == null}">
					<div class="row justify-content-center">
						<button type="button" class="btn btn-primary my-2 my-sm-0" data-toggle="modal" data-target="#loginModal" id="review_button"> ACCEDI PER SCRIVERE UNA RECENSIONE </button>
					</div>
				</c:if>	
 		</div>

  	<!-- Slider Controls -->
  		<a class="carousel-control-prev" href="#SliderReview" data-slide="prev">
    	<span class="carousel-control-prev-icon"></span>
  		</a>
  		<a class="carousel-control-next" href="#SliderReview" data-slide="next">
    	<span class="carousel-control-next-icon"></span>
  		</a>
 
  
	</div>
</div>


<!-- Modal for Review PopUp -->
	<jsp:include page="reviewPopUp.jsp"/>
<!-- /Modal for Review PopUP -->