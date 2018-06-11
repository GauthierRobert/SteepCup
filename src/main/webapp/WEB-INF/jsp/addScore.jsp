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
  	<script src="<c:url value="/assets/js/ranking.js" />"></script>

<script>
function validateForm() {
	for(i = 0; i < 6; i++){
    	var x = document.forms["MyGameForm"]["games["+i+"].scoreAway"].value;
    	var y = document.forms["MyGameForm"]["games["+i+"].scoreHome"].value;
    	if (x == "" || y== "") {
        	alert("Every games must be filled out");
        	return false;
    	}
	}
}
</script>

<style type="text/css">

#listOfGames input {
    background:rgba(255,255,255,0.2);;
    border: 0px solid;
    height: 20px;
    width: 50px;
    text-align:center;
    
}

#btn_submit {
	color: #000;
}

</style>
  	
</head>
  
  
<body id="myPage" data-spy="scroll" data-target=".navbar">

<%@include file="navbarAddScore.jsp" %> 
<div class="container" style="background-color: #400808ab; margin-top: 100px; margin-bottom:50px; padding-bottom:50px; opacity: 0.9;">
<div class="col-xs-12" style="height:48px;"></div>
The 2018 World Cup draw is done and dusted, the groups have been decided and all eyes have turned to this summer's tournament. 
Will England bow out in the quarter-finals? Will Germany triumph again? Can Belgium spring a surprise?
<form:form modelAttribute="group"><h1><span id="groupN">Group ${group}</span></h1></form:form>
<h4>Please enter the score for each game of this group</h4>
<div class="col-xs-12" style="height:12px;"></div>

 <form:form modelAttribute="gameForm"  method="POST" onsubmit="return validateForm()" id="MyGameForm">
	<table class="table" id="listOfGames">
	<thead>
	<tr> 
		<th width="15%">Date and time</th>
		<th width="25%" style="text-align: right;">Home</th>
		<th width="35%" style="text-align: center;">Score</th>
		<th width="25%" style="text-align: left;">Away</th>
	</tr>
	</thead>
	<tbody>
	<c:forEach items="${gameForm.games}"  var="game" varStatus="status">
		<tr>
			<td>${game.gameDate}   ${game.gameTime}</td>
			<td align="right">
				<span id = "games[${status.index}].gameHome">${game.home}</span> 
			</td>
			<td align="center">
				<input id="games[${status.index}].scoreHome" 
				name="games[${status.index}].scoreHome" 
				value="${game.scoreHome}"/>
				-
				<input  id="games[${status.index}].scoreAway" 
				name="games[${status.index}].scoreAway" 
				value="${game.scoreAway}"/>
			</td>
			<td align="left">
				<span id = "games[${status.index}].gameAway">${game.away}</span>
			</td>
		</tr>
	</c:forEach>
	</tbody>
	</table>
	
	
<div class="col-xs-12" style="height:12px;"></div>

<table class="table" >
	<thead>
   	 	<tr>
   		 	<th> </th>
        	<th width="60%">Country</th>
        	<th>Games</th>
        	<th>Win</th>
        	<th>Draw</th>
        	<th>Lose</th>
        	<th>GF</th>
        	<th>GA</th>
        	<th>+/-</th>
        	<th>Pts</th>  
    	</tr>
	</thead>
    <tbody id="Ranking"> </tbody>
</table>

<input type="submit" class="btn" value="Submit" id="btn_submit"/>
	
</form:form>

</div>

<script type="text/javascript">

	var str = document.getElementById("groupN").innerText;
	var gr = str.slice(-1);	
	getRanking(gr);

	document.getElementById("listOfGames").onchange = function(){getRanking(gr)};

</script>

</body>
</html>


