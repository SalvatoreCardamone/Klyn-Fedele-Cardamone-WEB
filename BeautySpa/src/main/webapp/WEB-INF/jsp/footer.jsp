<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- Footer -->
<footer class="page-footer font-small mdb-color pt-4">

  <div class="container text-center text-md-left">

    <div class="row text-center text-md-left mt-3 pb-3">

      <div class="col-md-3 col-lg-3 col-xl-3 mx-auto mt-3">
        <h6 class="text-uppercase mb-4 font-weight-bold">Beauty SPA S.r.l</h6>
        <p> P.IVA: 01234567890</p>
        <img src="../image/logo.png">
      </div>

      <hr class="w-100 clearfix d-md-none">

      <div class="col-md-4 col-lg-3 col-xl-3 mx-auto mt-3">
        <h6 class="text-uppercase mb-4 font-weight-bold">Contatti</h6>
        <p>
          <i class="fas fa-home mr-3"></i> Via Nome Finto 123</p>
        <p>
          <i class="fas fa-envelope mr-3"></i> info@gmail.com</p>
        <p>
          <i class="fas fa-phone mr-3"></i> + 01 234 567 88</p>
        <p>
          <i class="fas fa-print mr-3"></i> + 01 234 567 89</p>
      </div>

    </div>

    <hr>

    <div class="row d-flex align-items-center">

      <div class="col-md-7 col-lg-8">

        <p class="text-center text-md-left"><span class="copyright">&copy;</span>
        	 2021 Copyright:
            <strong> TUTTI I DIRITTI RISERVATI. </strong>
        </p>

		<div class="dropdown dropup">
		  <button class="btn btn-outline-primary dropdown-toggle" type="button" id="dropdownMenu2" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
		    Area Riservata
		  </button>
		  
			<form class="dropdown-menu p-4" method="POST" action="/PageAdmin">
			  <div class="form-group">
			    <input type="text" class="form-control"  placeholder="Nome" name="nomeAdmin">
			  </div>
			  <div class="form-group">
			    <input type="password" class="form-control"  placeholder="Password" name="passwordAdmin">
			  </div>

			  <button type="submit" class="btn btn-primary">Accedi</button>
			</form>
		</div>

      </div>
      
      <div class="col-md-5 col-lg-4 ml-lg-0">

        <div class="text-center text-md-right">
          <ul class="list-unstyled list-inline">
            <li class="list-inline-item">
              <a class="socialButton" href="https://www.facebook.com/">
                <i class="fab fa-facebook-f" ></i>
              </a>
            </li>
            <li class="list-inline-item">
              <a class="socialButton" href="https://www.youtube.com/">
                <i class="fab fa-youtube" id="socialButton"></i>
              </a>
            </li>
            <li class="list-inline-item">
              <a class="socialButton" href="https://www.tripadvisor.it/">
				<i class="fab fa-tripadvisor" id="socialButton"></i>
              </a>
            </li>
            <li class="list-inline-item">
              <a class="socialButton" href="https://www.instagram.com/">
                <i class="fab fa-instagram" id="socialButton"></i>
              </a>
            </li>
          </ul>
        </div>

      </div>

    </div>

  </div>

</footer>
<!-- Footer -->

