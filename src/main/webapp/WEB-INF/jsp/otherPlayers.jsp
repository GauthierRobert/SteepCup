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
  	<link href="<c:url value="/assets/css/navbar.css" />" rel="stylesheet" type="text/css">
  	<link href="<c:url value="/assets/css/flag-icon.css" />" rel="stylesheet" type="text/css">
  	<link href="<c:url value="/assets/css/flag-icon.min.css" />" rel="stylesheet" type="text/css">
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  	
</head>


<body onload="t()">

<%@ taglib prefix="security"  uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<nav class="navbar navbar-default navbar-fixed-top" style="background-color: transparent;">
  <div class="container-fluid" id="navbarfluid" style="background-color: #400808ab; opacity: 0.8;">
    <div class="navbar-header">
      <a class="navbar-brand" href="../index.jsp"><img src="https://www.steepconsult.com/sites/all/themes/dropsolid_theme/logo.png"></a>
    </div>
    <div id="myNavbar">
      <ul class="nav navbar-nav navbar-left">
        <li ><a href="../ranking.html">Ranking</a></li>
        <li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="#">Pronostics phase 1
          <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="../addScore/A.html">Group A</a></li>
            <li><a href="../addScore/B.html">Group B</a></li>
            <li><a href="../addScore/C.html">Group C</a></li>
            <li><a href="../addScore/D.html">Group D</a></li>
            <li><a href="../addScore/E.html">Group E</a></li>
            <li><a href="../addScore/F.html">Group F</a></li>
            <li><a href="../addScore/G.html">Group G</a></li>
            <li><a href="../knockoutStage.html">Knockout stage </a></li>
          </ul>
        </li>
        <li><a href="../addFinalPhase.html">Pronostics phase 2</a></li>
        <security:authorize access="hasRole('ADMIN')">
			<li><a href="../worldCupScore.html">Enter World Cup Scores</a></li> 
     	</security:authorize> 
     	        <security:authorize access="isAuthenticated()">
  			<li><a href="../otherPlayers/<security:authentication property="principal.username" />.html">My games</a></li>
  	    </security:authorize> 
      </ul>
       <%-- <sec:authentication property="Username"/> --%>
      <ul class="nav navbar-nav navbar-right" id="AUT">
      	<security:authorize access="isAuthenticated()">
        
        <li>
		<c:url value="/logout" var="logoutUrl" />
		<form id="logout" action="${logoutUrl}" method="post" >
 		 	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		</form>
			<a href="javascript:document.getElementById('logout').submit()">Logout </a>
				
        </li>        
       </security:authorize>
       <security:authorize access="!isAuthenticated()">
       		<li><a href="../../login.html" ><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
		</security:authorize>
      </ul>
      </div>
  </div>
<div class="container-fluid" id="navbarfluid2" style="background-color: transparent;">
	<security:authorize access="isAuthenticated()">
  	<p class="navbar-text" style="color: #fff;  font-size: 14px; ">Logged in as <security:authentication property="principal.username" /></p>
  	</security:authorize> 
</div>	

</nav> 

<div class="container" style="background-color: #400808ab; margin-top: 100px;  margin-bottom:50px;  padding-bottom:50px; opacity: 0.9;">
<div class="col-xs-12" style="height:48px;"></div>

<h1>Details of the player</h1>
<form:form modelAttribute="otherPlayers"  method="GET">
 <div class="col-xs-12" style="height:12px;"></div>
 <h3>Phase 1 : Group Phase</h3>
	<table class="table" id="listOfGamesPlayer">
	<thead>
	<tr> 
		<th width="15%">Date and time</th>
		<th width="20%" style="text-align: right;">Home</th>
		<th width="30%" style="text-align: center;">Score</th>
		<th width="20%" style="text-align: left;">Away</th>
		<th width="10%" style="text-align: center;">Type</th>
		<th width="5%" style="text-align: center;">Pts</th>
	</tr>
	</thead>
	<tbody>
	<c:forEach items="${otherPlayers}"  var="game" begin="0" end="47">
		<tr>
			<td>${game.gameDate} ${game.gameTime}</td>
			<td align="right">${game.home}</td>
			<td align="center">${game.scoreHome} - ${game.scoreAway}			</td >
			<td align="left">${game.away}</td>
			<td align="center">${game.type}</td>
			<td align="center">${game.point}</td>
		</tr>
	</c:forEach>
	</tbody>
	</table>

 <h3>Phase 1 : Knockout Phase</h3>
<table class="table" id="listOfGamesPlayer">
	<thead>
	<tr> 
		<th width="11%">Date and time</th>
		<th width="20%" style="text-align: center;">Home</th>
		<th width="20%" style="text-align: center;">Away</th>
		<th width="10%" style="text-align: center;">Type</th>

	</tr>
	</thead>
	<tbody>
	<c:forEach items="${knockOutPhase}"  var="game" varStatus="status">
		<tr>
			<td>${game.gameDate} ${game.gameTime}</td>
			<td align="center"  
			id="foo[${status.index}]">${game.home}</td>
			<td align="center" id="faa[${status.index}]">${game.away}</td>
			<td id="fee[${status.index}]" hidden="">${game.scoreHome}</td>
			<td id="fyy[${status.index}]" hidden="">${game.scoreAway}</td>
			<td align="center">${game.type}</td>	
		</tr>	
	</c:forEach>
	</tbody>
	</table>
<script type="text/javascript">
function t(){
	for (i = 0; i < 16; i++){
		var sH = parseInt(document.getElementById("fee["+ i +"]").innerText);
		var sA = parseInt(document.getElementById("fyy["+ i +"]").innerText);
		
		document.getElementById("foo["+ i +"]").style.color = '#FFFFFF';
		document.getElementById("faa["+ i +"]").style.color = '#FFFFFF';
		
		if (sA < sH){
			document.getElementById("foo["+ i +"]").style.color = '#008000';
			document.getElementById("faa["+ i +"]").style.color = 'red';
		}
		if (sA > sH){
			document.getElementById("foo["+ i +"]").style.color = 'red';
			document.getElementById("faa["+ i +"]").style.color = '#008000';
		}	
	}
}
	</script>
	
	 <h3>Phase 2 : Knockout Phase</h3>
<table class="table" id="listOfGamesPlayer" >
	<thead>
	<tr> 
		<th width="15%">Date and time</th>
		<th width="20%" style="text-align: right;">Home</th>
		<th width="30%" style="text-align: center;">Score</th>
		<th width="20%" style="text-align: left;">Away</th>
		<th width="10%" style="text-align: center;">Type</th>
		<th width="5%" style="text-align: center;">Pts</th>
	</tr>
	</thead>
	<tbody>
	<c:forEach items="${otherPlayers}"  var="game" begin="48" end="63">
		<tr>
			<td>${game.gameDate} ${game.gameTime}</td>
			<td align="right">${game.home}</td>
			<td align="center">${game.scoreHome} - ${game.scoreAway}			</td >
			<td align="left">${game.away}</td>
			<td align="center">${game.type}</td>
			<td align="center">${game.point}</td>
		</tr>
	</c:forEach>
	</tbody>
	</table>
</form:form>
</div>
</body>
</html>