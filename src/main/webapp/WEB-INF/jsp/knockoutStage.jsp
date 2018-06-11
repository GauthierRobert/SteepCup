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

.btn {
	color: #000;
	width: 200px;
}



</style>
  
<body id="myPage" data-spy="scroll" data-target=".navbar">

<%@include file="navbar.jsp" %> 

<div class="container" style="background-color: #400808ab; margin-top: 100px; margin-bottom:50px;  padding-bottom:50px; opacity: 0.9;">
<div class="col-xs-12" style="height:48px;"></div>

Please submit for each step !!! Clic on winner

<h2>Knock Out Phase</h2>
 <form:form modelAttribute="gameForm"  method="POST" id="MyGameForm">
	<table class="table" id="listOfGames">
	<thead>
	<tr> 
		<th width="25%">Date and time</th>
		<th width="65%" style="text-align: center;">Home - Away</th>
		<th width="10%" style="text-align: center;" hidden="true">Winner</th>
	</tr>
	</thead>
	<tbody>
	<tr>
		<td>Round of 16</td><td></td><td></td>
	</tr>
	<c:forEach items="${gameForm.games}"  var="game" varStatus="status" begin="0" end="7">
		<tr>
		
			<td>${status.index + 49} - ${game.gameDate} - ${game.gameTime}</td>
			<td align="center" id="games[${status.index}]">
				<button class="btn" id = "btn[${status.index}].H" type="button" onclick="c(${status.index})">${game.home}</button> - 
				<button class="btn" id = "btn[${status.index}].A" type="button" onclick="d(${status.index})">${game.away}</button>
			</td>
			<td align="center" hidden="true">
				<input id="games[${status.index}].scoreHome" 
				name="games[${status.index}].scoreHome" 
				value="${game.scoreHome}" />
				-
				<input  id="games[${status.index}].scoreAway" 
				name="games[${status.index}].scoreAway" 
				value="${game.scoreAway}" />
			</td>
			<td hidden="true">
				<input id="games[${status.index}].Winner" name="games[${status.index}].winner" value="${game.winner}" />
			</td>
		</tr>
	</c:forEach>
	<tr>
		<td>Quarter-finals</td><td></td><td></td>
	</tr>
	<c:forEach items="${gameForm.games}"  var="game" varStatus="status" begin="8" end="11">
		<tr>
			<td>${status.index + 49} - ${game.gameDate} - ${game.gameTime}</td>
			<td align="center" id="games[${status.index}]">
				<button class="btn" id = "btn[${status.index}].H" type="button" onclick="c(${status.index})">${game.home}</button> 
				<input id="games[${status.index}].Home" name="games[${status.index}].home" value="${game.home}" hidden="true"/>
				- 
				<button class="btn" id = "btn[${status.index}].A" type="button" onclick="d(${status.index})">${game.away}</button>
				<input id="games[${status.index}].Away" name="games[${status.index}].away" value="${game.away}" hidden="true"/>
			</td>
			<td hidden="true">
				<input id="games[${status.index}].scoreHome" 
				name="games[${status.index}].scoreHome" 
				value="${game.scoreHome}"/>
				-
				<input  id="games[${status.index}].scoreAway" 
				name="games[${status.index}].scoreAway" 
				value="${game.scoreAway}"/>
			</td>
			<td hidden="true">
				<input id="games[${status.index}].Winner" name="games[${status.index}].winner" value="${game.winner}" />
			</td>
		</tr>
	</c:forEach>
	<tr>
		<td>Semi-finals</td><td></td><td></td>
	</tr>
	
	<c:forEach items="${gameForm.games}"  var="game" varStatus="status" begin="12" end="13">
		<tr>
			<td>${status.index + 49} - ${game.gameDate} - ${game.gameTime}</td>
			<td align="center" id="games[${status.index}]">
				<button class="btn" id = "btn[${status.index}].H" type="button" onclick="c(${status.index})">${game.home}</button> 
				<input id="games[${status.index}].Home" name="games[${status.index}].home" value="${game.home}" hidden="true"/>
				- 
				<button class="btn" id = "btn[${status.index}].A" type="button" onclick="d(${status.index})">${game.away}</button>
				<input id="games[${status.index}].Away" name="games[${status.index}].away" value="${game.away}" hidden="true"/>
			</td>
			<td align="center" hidden="true">
				<input id="games[${status.index}].scoreHome" 
				name="games[${status.index}].scoreHome" 
				value="${game.scoreHome}"/>
				-
				<input  id="games[${status.index}].scoreAway" 
				name="games[${status.index}].scoreAway" 
				value="${game.scoreAway}"/>
			</td>
			<td hidden="true">
				<input id="games[${status.index}].Winner" name="games[${status.index}].winner" value="${game.winner}" />
			</td>
		</tr>
	</c:forEach>
	
	<tr>
		<td>Winner and loser final</td><td></td><td></td>
	</tr>
	<c:forEach items="${gameForm.games}"  var="game" varStatus="status" begin="14" end="15">
		<tr>
			<td>${status.index + 49} - ${game.gameDate} - ${game.gameTime}</td>
			<td align="center" id="games[${status.index}]">
				<button class="btn" id = "btn[${status.index}].H" type="button" onclick="c(${status.index})">${game.home}</button> 
				<input id="games[${status.index}].Home" name="games[${status.index}].home" value="${game.home}" hidden="true"/>
				- 
				<button class="btn" id = "btn[${status.index}].A" type="button" onclick="d(${status.index})">${game.away}</button>
				<input id="games[${status.index}].Away" name="games[${status.index}].away" value="${game.away}" hidden="true"/>
			</td>
			<td align="center" hidden="true">
				<input id="games[${status.index}].scoreHome" 
				name="games[${status.index}].scoreHome" 
				value="${game.scoreHome}"/>
				-
				<input  id="games[${status.index}].scoreAway" 
				name="games[${status.index}].scoreAway" 
				value="${game.scoreAway}"/>
			</td>
			<td hidden="true">
				<input id="games[${status.index}].Winner" name="games[${status.index}].winner" value="${game.winner}" />
			</td>
		</tr>
	</c:forEach>
	
	</tbody>
	</table>
<input type="submit" class="btn" value="Submit" id="btn_submit"/>	
</form:form>



<script>
// Add active class to the current button (highlight it)

function c(i){
	var btns1 = document.getElementById("btn["+i+"].H");
	var btns2 = document.getElementById("btn["+i+"].A");
		btns2.className = "btn btn-danger";
		btns1.className = "btn btn-success";
		document.getElementById("games["+i+"].scoreHome").value=1;
		document.getElementById("games["+i+"].scoreAway").value=0;
		document.getElementById("games["+i+"].Winner").value = btns1.innerHTML;
		if (i<12){
			j = Math.round((i+1)/1.99)-1+8;
			if (i%2 ==0){
				document.getElementById("btn["+j+"].H").innerHTML=btns1.innerHTML;
				document.getElementById("games["+j+"].Home").value = btns1.innerHTML;
			} else {
				document.getElementById("btn["+j+"].A").innerHTML=btns1.innerHTML;
				document.getElementById("games["+j+"].Away").value = btns1.innerHTML;
			}
		} else if (i>11 && i <14){
			if (i == 12){
				document.getElementById("btn[15].H").innerHTML=btns1.innerHTML;
				document.getElementById("games[15].Home").value = btns1.innerHTML;
				document.getElementById("btn[14].H").innerHTML=btns2.innerHTML;
				document.getElementById("games[14].Home").value = btns2.innerHTML;
			} else {
				document.getElementById("btn[15].A").innerHTML=btns1.innerHTML;
				document.getElementById("games[15].Away").value = btns1.innerHTML;
				document.getElementById("btn[14].A").innerHTML=btns2.innerHTML;
				document.getElementById("games[14].Away").value = btns2.innerHTML;
			}
		} else {
			
		}


}

function d(i){
	var btns1 = document.getElementById("btn["+i+"].H");
	var btns2 = document.getElementById("btn["+i+"].A");
		btns1.className = "btn btn-danger";
		btns2.className = "btn btn-success";
		document.getElementById("games["+i+"].scoreHome").value=0;
		document.getElementById("games["+i+"].scoreAway").value=1;
		document.getElementById("games["+i+"].Winner").value = btns2.innerHTML;
		
		if (i<12){
			j = Math.round((i+1)/1.99)-1+8;
			if (i%2 == 0){
				document.getElementById("btn["+j+"].H").innerHTML=btns2.innerHTML;
				document.getElementById("games["+j+"].Home").value = btns2.innerHTML;
			} else {
				document.getElementById("btn["+j+"].A").innerHTML=btns2.innerHTML;
				document.getElementById("games["+j+"].Away").value = btns2.innerHTML;
			}
		} else if (i>11 && i <14){
			if (i == 12){
				document.getElementById("btn[15].H").innerHTML=btns2.innerHTML;
				document.getElementById("games[15].Home").value = btns2.innerHTML;
				document.getElementById("btn[14].H").innerHTML=btns1.innerHTML;
				document.getElementById("games[14].Home").value = btns1.innerHTML;
			} else {
				document.getElementById("btn[15].A").innerHTML=btns2.innerHTML;
				document.getElementById("games[15].Away").value = btns2.innerHTML;
				document.getElementById("btn[14].A").innerHTML=btns1.innerHTML;
				document.getElementById("games[14].Away").value = btns1.innerHTML;
			}
		} else {
			
		}
}


</script>

</div>

</body>
</html>