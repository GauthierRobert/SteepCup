<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security"  uri="http://www.springframework.org/security/tags" %>


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
 <style>

.info {
    border-left: 6px solid #2196F3;
    background-color: #e7f3fe;
    width : 
}

</style> 
<body id="myPage" data-spy="scroll" data-target=".navbar">

<%@include file="navbar.jsp" %> 

<div class="container" style="background-color: #400808ab; margin-top: 100px; margin-bottom:50px;  padding-bottom:50px; opacity: 0.9;">
<div class="col-xs-12" style="height:48px;"></div>


<h2>Rules</h2>

<h3>Before Tournament start</h3>  
<h4>groups phase</h4>
<ul>
<li> 2 points correct result (Victory, draw or defeat) </li>  
<li> 3 points correct goal difference</li> 
<li> 5 points correct score</li> 

</ul>


<p>I said Russia 3 - 0 Saudi Arabia and it is a victory 1 - 0 for Russia then 2 points</p> 

<p>I said Russia 2 - 1 Saudi Arabia and it is a victory 1 - 0 for Russia then 3 points</p> 

<p>I said Russia 1 - 0 Saudi Arabia and it is a victory 1 - 0 for Russia then 5 points</p>


<h4>Final phase</h4>
Still before the start, for each team well pronosticed :
<ul>
<li>in the round of 16 : gives you 5 points </li> 
<li>in the quarter-finals : gives you 8 points </li> 
<li>in the semi-final : gives you 15 points </li> 
<li>in the final : gives you 30 points </li> 
</ul>
If you give the correct winner of the WORLD CUP you get 50 points.

<h3>After group phase</h3> 

<p>Once group phase is completed, you can bet on the games of the knockout phase. The rules are the same but all the points are doubled.
</p>
<div class="alert alert-warning" style="width: fit-content;">
  <strong>Warning!</strong> All the calculation is done for the score after 90 minutes !
</div>
<ul>
<li> 4 points correct result (Victory, draw or defeat) </li>  
<li> 6 points correct goal difference</li> 
<li> 10 points correct score</li> 
</ul>
<h1>Ranking</h1>
 <form:form modelAttribute="ranking"  method="GET">

	<table class="table" id="Ranking">
	
		<tr><th width="5%">#</th>
			<th width="20%">Username</th>
			<th>#G</th>
			<th>#S</th>
			<th>#D</th>
			<th>#R</th>
			<th>pts KO</th>
			<th>total pts</th>
			<th>Details</th>
		</tr>
		<c:forEach items="${ranking}" var="player" varStatus="status">
			<tr>
				<td>${status.index + 1}</td>
				<td>${player.username}</td>
				<td>${player.nbrGames}</td>
				<td>${player.nbrGoodScore}</td>
				<td>${player.nbrGoodDiff}</td>
				<td>${player.nbrGoodResult}</td>
				<td>${player.pointsKO}</td>
				<td>${player.points}</td>
				<td><a href="otherPlayers/${player.username}.html" ><span class="glyphicon glyphicon-stats"></span> See ${player.username}'s games</a></td>
			</tr>
		</c:forEach>
	</table>
</form:form>

<div class="alert alert-info" style="width: fit-content;  ">
<h4  style="text-align: center;">Info! </h4>
  <p><strong>#G : </strong>Number of games </p> 
  <p><strong>#S : </strong>number of games with the correct score (5 or 10 points) </p> 
  <p><strong>#D : </strong>number of games with the correct goal difference (3 or 6 points) </p> 
  <p><strong>#R : </strong>number of games with the correct result (2 or 4 points) </p> 
  <p><strong>pts KO : </strong>points from the final phase before tounament starts </p>   
</div>

</div>

</body>
</html>