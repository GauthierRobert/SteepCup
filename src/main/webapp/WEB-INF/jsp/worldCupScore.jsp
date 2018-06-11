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

<style type="text/css">

#listOfWorldCup0 input {
    background:rgba(255,255,255,0.2);;
    border: 0px solid;
    height: 20px;
    width: 50px;
    text-align:center;
    
}
#listOfWorldCup1 input {
    background:rgba(255,255,255,0.2);;
    border: 0px solid;
    height: 20px;
    width: 50px;
    text-align:center;
    
}

#listOfWorldCup2 input {
    background:rgba(255,255,255,0.2);;
    border: 0px solid;
    height: 20px;
    width: 50px;
    text-align:center;
    
}

#listOfWorldCup3 input {
    background:rgba(255,255,255,0.2);;
    border: 0px solid;
    height: 20px;
    width: 50px;
    text-align:center;
    
}

#listOfWorldCup4 input {
    background:rgba(255,255,255,0.2);;
    border: 0px solid;
    height: 20px;
    width: 50px;
    text-align:center;
    
}


.btn {
	color: #000;
	width: 150px;
	height: 30px;
	
}

</style>
  	
</head>
  
  
<body id="myPage" data-spy="scroll" data-target=".navbar">

<%@include file="navbar.jsp" %> 
<div class="container" style="background-color: #400808ab; margin-top: 100px; margin-bottom:50px;  padding-bottom:50px; opacity: 0.9;">
<div class="col-xs-12" style="height:48px;"></div>

<h1>World Cup scores</h1>

<div class="col-xs-12" style="height:12px;"></div>


 <form:form modelAttribute="worldCupForm"  method="POST">
 <input type="submit" class="btn" value="Submit" id="btn_submit"/>
 <div class="col-xs-12" style="height:12px;"></div>
 <h2>Group phase</h2>
 <h4>Please enter the correct score for each World Cup Game</h4>
	<table class="table" id="listOfWorldCup0">
	<thead>
	<tr> 
		<th width="17%">Date and time</th>
		<th width="25%" style="text-align: right;">Home</th>
		<th width="30%" style="text-align: center;">Score</th>
		<th width="25%" style="text-align: left;">Away</th>
		<th width="8%" style="text-align: center;">Type</th>
	</tr>
	</thead>
	<tbody>
	<c:forEach items="${worldCupForm.worldCupGames}"  var="worldCup" varStatus="status" begin="0" end="47">
		<tr>
			<td style ="vertical-align: middle;">${worldCup.gameDate} ${worldCup.gameTime}</td>
			<td align="right">${worldCup.home}</td>
			<td align="center">
				<input name="worldCupGames[${status.index}].scoreHome" 
				value="${worldCup.scoreHome}"/>
				-
				<input name="worldCupGames[${status.index}].scoreAway" 
				value="${worldCup.scoreAway}"/>
			</td >
			<td align="left">${worldCup.away}</td>
			<td align="center">${worldCup.type}</td>
		</tr>
	</c:forEach>
		</tbody>
	</table>
	<div >
<h2>Round of 16</h2>
<h4>Please enter the correct score (AFTER 90 MINUTES !) for each World Cup Game and also the correct winner</h4>
	<table class="table" id="listOfWorldCup1">
	<thead>
	<tr> 
		<th width="17%">Date and time</th>
		<th width="25%" style="text-align: right;">Home</th>
		<th width="30%" style="text-align: center;">Score</th>
		<th width="25%" style="text-align: left;">Away</th>
		<th width="8%" style="text-align: center;">Type</th>
	</tr>
	</thead>
	<tbody>
	<c:forEach items="${worldCupForm.worldCupGames}"  var="worldCup" varStatus="status" begin="48" end="55">
		<tr>
		
			<td style ="vertical-align: middle;">${worldCup.gameDate} ${worldCup.gameTime}</td>
			<td align="right">
				<button class="btn" id = "btn[${status.index}].H" type="button" onclick="c(${status.index})">${worldCup.home}</button>
			</td>
			<td align="center">
				<input name="worldCupGames[${status.index}].scoreHome"	value="${worldCup.scoreHome}"/>
				-
				<input name="worldCupGames[${status.index}].scoreAway"	value="${worldCup.scoreAway}"/>
			</td >
			<td align="left">
				<button class="btn" id = "btn[${status.index}].A" type="button" onclick="d(${status.index})">${worldCup.away}</button>
			</td>
			<td align="center">${worldCup.type}</td>
			<td hidden="true">
				<input id="worldCupGames[${status.index}].Winner" name="worldCupGames[${status.index}].winner" value="${worldCup.winner}" />
			</td>
		</tr>
	</c:forEach>
	</tbody>
	</table>
<h2>Quarter-finals</h2>
	<table class="table" id="listOfWorldCup2">
	<thead>
	<tr> 
		<th width="17%">Date and time</th>
		<th width="25%" style="text-align: right;">Home</th>
		<th width="30%" style="text-align: center;">Score</th>
		<th width="25%" style="text-align: left;">Away</th>
		<th width="8%" style="text-align: center;">Type</th>
	</tr>
	</thead>
	<tbody>
	<c:forEach items="${worldCupForm.worldCupGames}"  var="worldCup" varStatus="status" begin="56" end="59">
		<tr>
		
			<td style ="vertical-align: middle;">${worldCup.gameDate} ${worldCup.gameTime}</td>
			<td align="right">
				<button class="btn" id = "btn[${status.index}].H" type="button" onclick="c(${status.index})">${worldCup.home}</button>
				<input id="worldCupGames[${status.index}].Home" name="worldCupGames[${status.index}].home" value="${worldCup.home}" hidden="true"/>
			</td>
			<td align="center">
				<input name="worldCupGames[${status.index}].scoreHome" value="${worldCup.scoreHome}"/>
				-
				<input name="worldCupGames[${status.index}].scoreAway" value="${worldCup.scoreAway}"/>
			</td >
			<td align="left">
				<button class="btn" id = "btn[${status.index}].A" type="button" onclick="d(${status.index})">${worldCup.away}</button>
				<input id="worldCupGames[${status.index}].Away" name="worldCupGames[${status.index}].away" value="${worldCup.away}" hidden="true"/>
			</td>
			<td align="center">${worldCup.type}</td>
			<td hidden="true">
				<input id="worldCupGames[${status.index}].Winner" name="worldCupGames[${status.index}].winner" value="${worldCup.winner}" />
			</td>
		</tr>
	</c:forEach>
	</tbody>
	</table>
<h2>Semi-finals</h2>
	<table class="table" id="listOfWorldCup3">
	<thead>
	<tr> 
		<th width="17%">Date and time</th>
		<th width="25%" style="text-align: right;">Home</th>
		<th width="30%" style="text-align: center;">Score</th>
		<th width="25%" style="text-align: left;">Away</th>
		<th width="8%" style="text-align: center;">Type</th>
	</tr>
	</thead>
	<tbody>
	<c:forEach items="${worldCupForm.worldCupGames}"  var="worldCup" varStatus="status" begin="60" end="61">
		<tr>
		
			<td style ="vertical-align: middle;">${worldCup.gameDate} ${worldCup.gameTime}</td>
			<td align="right">
				<button class="btn" id = "btn[${status.index}].H" type="button" onclick="c(${status.index})">${worldCup.home}</button>
				<input id="worldCupGames[${status.index}].Home" name="worldCupGames[${status.index}].home" value="${worldCup.home}" hidden="true"/>
			</td>
			<td align="center">
				<input name="worldCupGames[${status.index}].scoreHome" 
				value="${worldCup.scoreHome}"/>
				-
				<input name="worldCupGames[${status.index}].scoreAway" 
				value="${worldCup.scoreAway}"/>
			</td >
			<td align="left">
				<button class="btn" id = "btn[${status.index}].A" type="button" onclick="d(${status.index})">${worldCup.away}</button>
				<input id="worldCupGames[${status.index}].Away" name="worldCupGames[${status.index}].away" value="${worldCup.away}" hidden="true"/>
			</td>
			<td align="center">${worldCup.type}</td>
			<td hidden="true">
				<input id="worldCupGames[${status.index}].Winner" name="worldCupGames[${status.index}].winner" value="${worldCup.winner}" />
			</td>
		</tr>
	</c:forEach>
	</tbody>
	</table>
<h2>Winner and loser final</h2>
	<table class="table" id="listOfWorldCup4">
	<thead>
	<tr> 
		<th width="17%">Date and time</th>
		<th width="25%" style="text-align: right;">Home</th>
		<th width="30%" style="text-align: center;">Score</th>
		<th width="25%" style="text-align: left;">Away</th>
		<th width="8%" style="text-align: center;">Type</th>
	</tr>
	</thead>
	<tbody>
	<c:forEach items="${worldCupForm.worldCupGames}"  var="worldCup" varStatus="status" begin="62" end="63">
		<tr>
		
			<td style ="vertical-align: middle;">${worldCup.gameDate} ${worldCup.gameTime}</td>
			<td align="right">
				<button class="btn" id = "btn[${status.index}].H" type="button" onclick="c(${status.index})">${worldCup.home}</button>
				<input id="worldCupGames[${status.index}].Home" name="worldCupGames[${status.index}].home" value="${worldCup.home}" hidden="true"/>
			</td>
			<td align="center">
				<input name="worldCupGames[${status.index}].scoreHome" 
				value="${worldCup.scoreHome}"/>
				-
				<input name="worldCupGames[${status.index}].scoreAway" 
				value="${worldCup.scoreAway}"/>
			</td >
			<td align="left">
				<button class="btn" id = "btn[${status.index}].A" type="button" onclick="d(${status.index})">${worldCup.away}</button>
				<input id="worldCupGames[${status.index}].Away" name="worldCupGames[${status.index}].away" value="${worldCup.away}" hidden="true"/>
			</td>
			<td align="center">${worldCup.type}</td>
			<td hidden="true">
				<input id="worldCupGames[${status.index}].Winner" name="worldCupGames[${status.index}].winner" value="${worldCup.winner}" />
			</td>
		</tr>
	</c:forEach>
	</tbody>
	</table>
</div>	
</form:form>

<h1>The winner of the World Cup is <span id="demo"></span></h1>
<script type="text/javascript">
	document.getElementById("demo").innerText=document.getElementById("worldCupGames[63].winner").value;
</script>
<script>
// Add active class to the current button (highlight it)


function c(i){
	var btns1 = document.getElementById("btn["+i+"].H");
	var btns2 = document.getElementById("btn["+i+"].A");
		btns2.className = "btn btn-danger";
		btns1.className = "btn btn-success";
		document.getElementById("worldCupGames["+i+"].Winner").value = btns1.innerHTML;
		
		if (i<60){
			j = Math.round((i-48+1)/1.99)-1+8+48;
			if (i%2 == 0){
				document.getElementById("btn["+j+"].H").innerHTML=btns1.innerHTML;
				document.getElementById("worldCupGames["+j+"].Home").value = btns1.innerHTML;
			} else {
				document.getElementById("btn["+j+"].A").innerHTML=btns1.innerHTML;
				document.getElementById("worldCupGames["+j+"].Away").value = btns1.innerHTML;
			}
		} else if (i>59 && i <62){
			if (i == 60){
				document.getElementById("btn[63].H").innerHTML=btns1.innerHTML;
				document.getElementById("worldCupGames[63].Home").value = btns1.innerHTML;
				document.getElementById("btn[62].H").innerHTML=btns2.innerHTML;
				document.getElementById("worldCupGames[62].Home").value = btns2.innerHTML;
			} else {
				document.getElementById("btn[63].A").innerHTML=btns1.innerHTML;
				document.getElementById("worldCupGames[63].Away").value = btns1.innerHTML;
				document.getElementById("btn[62].A").innerHTML=btns2.innerHTML;
				document.getElementById("worldCupGames[62].Away").value = btns2.innerHTML;
			}
		} else {
			
		}
}

function d(i){
	var btns1 = document.getElementById("btn["+i+"].H");
	var btns2 = document.getElementById("btn["+i+"].A");
		btns1.className = "btn btn-danger";
		btns2.className = "btn btn-success";
		document.getElementById("worldCupGames["+i+"].Winner").value = btns2.innerHTML;
		
		if (i<60){
			j = Math.round((i-48+1)/1.99)-1+8+48;
			if (i%2 == 0){
				document.getElementById("btn["+j+"].H").innerHTML=btns2.innerHTML;
				document.getElementById("worldCupGames["+j+"].Home").value = btns2.innerHTML;
			} else {
				document.getElementById("btn["+j+"].A").innerHTML=btns2.innerHTML;
				document.getElementById("worldCupGames["+j+"].Away").value = btns2.innerHTML;
			}
		} else if (i>59 && i <62){
			if (i == 60){
				document.getElementById("btn[63].H").innerHTML=btns2.innerHTML;
				document.getElementById("worldCupGames[63].Home").value = btns2.innerHTML;
				document.getElementById("btn[62].H").innerHTML=btns1.innerHTML;
				document.getElementById("worldCupGames[62].Home").value = btns1.innerHTML;
			} else {
				document.getElementById("btn[63].A").innerHTML=btns2.innerHTML;
				document.getElementById("worldCupGames[63].Away").value = btns2.innerHTML;
				document.getElementById("btn[62].A").innerHTML=btns1.innerHTML;
				document.getElementById("worldCupGames[62].Away").value = btns1.innerHTML;
			}
		} else {
			
		}
}

</script>
<script type="text/javascript">

if(!(${isGroupCompleted})){	
	var header = document.getElementById("listOfWorldCup1")
	var btns = header.getElementsByClassName("btn");
	for (var i = 0; i < btns.length; i++) {
	 	btns[i].disabled = true;
	  }
}
if(!(${isGroupCompleted8})){
	var header =document.getElementById("listOfWorldCup2");
	var btns = header.getElementsByClassName("btn");
	for (var i = 0; i < btns.length; i++) {
	 	btns[i].disabled = true;
	  }
}
if(!(${isGroupCompleted4})){
	var header =document.getElementById("listOfWorldCup3");
	var btns = header.getElementsByClassName("btn");
	for (var i = 0; i < btns.length; i++) {
	 	btns[i].disabled = true;
	  }
}
if(!(${isGroupCompleted2})){
	var header =document.getElementById("listOfWorldCup4");
	var btns = header.getElementsByClassName("btn");
	for (var i = 0; i < btns.length; i++) {
	 	btns[i].disabled = true;
	  }
}
</script>

</div>


</body>
</html>


