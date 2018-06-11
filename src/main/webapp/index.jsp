<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<!DOCTYPE html>
<html lang="en">
  
  <head>
    <meta charset="utf-8">
    <title>
    </title>
 	<meta charset="utf-8">
 	<meta name="viewport" content="width=device-width, initial-scale=1">
 	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  	<link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet" type="text/css">
  	<link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet" type="text/css">
  	<link href='https://fonts.googleapis.com/css?family=Aclonica' rel='stylesheet'>
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  	<link href="<c:url value="/assets/css/navbar.css" />" rel="stylesheet" type="text/css">


</head>
  
<body id="myPage" data-spy="scroll" data-target=".navbar">


<%@include file="WEB-INF/jsp/navbar.jsp" %> 


<div class="container" style="background-color: #400808ab; margin-top: 100px; margin-bottom:50px; padding-bottom:50px; opacity: 0.9;">
<div class="col-xs-12" style="height:12px;"></div>

        <div style="text-align: center">
          <h1>
            Welcome to Steep Consult WORLD CUP!
          </h1>
          <p>
           Place your bet who will be the winner of world cup 2018
          </p>
          <div class="col-xs-12" style="height:36px;"></div>
          <h3 >Phase 1 : before WORLDCUP starts</h3>
          <div class="col-xs-32" style="height:15px;"></div>
            <a href="addScore/A.html" class="btn btn-default" role="button">Group A</a>
            <a href="addScore/B.html" class="btn btn-default" role="button">Group B</a>
            <a href="addScore/C.html" class="btn btn-default" role="button">Group C</a>
            <a href="addScore/D.html" class="btn btn-default" role="button">Group D</a>
            <a href="addScore/E.html" class="btn btn-default" role="button">Group E</a>
            <a href="addScore/F.html" class="btn btn-default" role="button">Group F</a>
            <a href="addScore/G.html" class="btn btn-default" role="button">Group G</a>
            <a href="addScore/H.html" class="btn btn-default" role="button">Group H</a>
            <a href="knockoutStage.html" class="btn btn-default" role="button">Final stage </a>
            <div class="col-xs-12" style="height:32px;"></div>
            <h3 style="text-align: center" >Phase 2 : when WORLD CUP groups are completed and at each final phase step</h3>
            <h4> (Finals, semi-finals, quarters-finals and round of 16)</h4>
            <div class="col-xs-12" style="height:32px;"></div>
			<a href="addFinalPhase.html" class="btn btn-default" role="button">Pronostics phase 2</a>
        </div>
        
        <div class="col-xs-12" style="height:100px;"></div>

	<h2 style="text-align: center"> The 32 countries who made it to the World Cup</h2>         
	<img src="<c:url value="/assets/img/notitaly.PNG"/>" class="img-thumbnail center-block" alt="Cinque Terre"  width="500"> 
        
        
</div>


</body>
</html>
