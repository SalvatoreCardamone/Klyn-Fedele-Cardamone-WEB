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

 

    <!--  NAV -->
    <jsp:include page="nav.jsp"/>
    <!-- /NAV -->
<div class="container bootstrap snippets bootdey">
    <hr>
    <div class="row">
        <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
            <div class="well profile">
                <img class="user img-circle pull-left clearfix" height="54" src="https://bootdey.com/img/Content/user_1.jpg" alt="">
                <h3 class="name pull-left clearfix">juan andres posada</h3>
                <div class="clearfix"></div>
                <ul class="nav nav-tabs">
                    <li class="active">
                        <a href="#tab" data-toggle="tab">
                            Account
                        </a>
                    </li>
                    <li class="">
                        <a href="#tab2" data-toggle="tab">
                            Prenotazioni
                        </a>
                    </li>
                </ul>
                <div class="tab-content">
                    <div class="tab-pane" id="tab2">
                        <div class="row">
                            <div class="col-xs-12 col-sm-8 col-md-8 col-lg-8">
                                <p>
                                    <br>
                                       Claudio Bisio
                                    <br>
                                </p>
                                <hr>
                            </div>
                        </div>
                    </div>
                    <div class="tab-pane active" id="tab">
                        <div class="row">
                            <div class="col-xs-12 col-sm-10 col-md-10 col-lg-10">
                                <div class="tab-content">
                                    <div class="tab-pane active" id="basic">
                                        <form class="container" method="POST" action="/LetReview" id="reviewFormContainer">
                                            <div class="form-group">
                                                <label for="input_email" class="col-lg-2 control-label">Email</label>
                                                <div class="col-lg-10">
                                                    <input type="email" class="form-control" id="input_email" value="${utente.email}" readonly>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label for="input_password" class="col-lg-2 control-label">Password</label>
                                                <div class="col-lg-10">
                                                    <input type="password" class="form-control" id="input_password" value="${utente.password}" pattern="^([a-zA-Z0-9@*#]{6,30})$"  oninvalid="this.setCustomValidity('Perfavore inserire corettamente la password (da 6 a 30 caratteri comprsi(@*#))')" oninput="setCustomValidity('')" required/>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class="row">
                                                    <div class="col">
                                                        <label for="input_nome" class="col-lg-2 control-label">Nome</label>
                                                        <input type="text" class="form-control" id="input_nome" value="${utente.nome}" required>
                                                       </div>
                                                       <div class="col">
                                                        <label for="input_cognome" class="col-lg-2 control-label">Cognome</label>
                                                        <input type="text" class="form-control" id="input_cognome" value="${utente.cognome}" required>
                                                       </div>
                                                   </div>
                                            </div>
                                            <div class="form-group">
                                                <label for="input_numero" class="col-lg-2 control-label">Numero di Telefono</label>
                                                <div class="col-lg-10">
                                                    <input type="tel" class="form-control" id="input_telefono" value="${utente.numero}" pattern="^(\(?\+?[0-9]*\)?)?[0-9_\- \(\)]{10,20}$"  oninvalid="this.setCustomValidity('Perfavore inserire corettamente il numero di telefono(da 10a 20 cifre compreso(+_))')" oninput="setCustomValidity('')"/>
                                                </div>
                                            </div>
                                            <div  class="form-group">
                                                <button class="btn btn-success btn-block" type="submit">Modifica</button>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>                    
    
    
    <!--  FOOTER -->
    <jsp:include page="footer.jsp"/>
    <!-- /FOOTER -->

 

</body>
</html>