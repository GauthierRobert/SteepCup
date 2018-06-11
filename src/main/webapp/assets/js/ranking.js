function hideAllExeptElem() {
var E = "A"
	for(I = 0; I < listOfGames.length; I++) {
        var type = document.getElementById("games["+I+"].type").value;
        console.log(type)
        if (type != E) {
        	document.getElementById("games["+I+"].gameTr").style.visibility = "hidden";
        }
	  	 		
	}
};

function findIndexInData(data, property, value) {
	  for(var i = 0, l = data.length ; i < l ; i++) {
	    if(data[i][property] === value) {
	      return i;
	    }
	  }
	  return -1;
};


function getRanking(group){
	if (group == "A"){
		var ranking = [
			{name:"Russia", flag:"ru", point:0, Games:0, Vic:0, Def:0, Nul:0, butp:0, butm:0 ,butdiff:0},
			{name:"Egypt", flag:"eg", point:0, Games:0, Vic:0, Def:0, Nul:0, butp:0, butm:0 ,butdiff:0},
			{name:"Saudi Arabia", flag:"sa", point:0, Games:0, Vic:0, Def:0, Nul:0, butp:0, butm:0 ,butdiff:0},
			{name:"Uruguay", flag:"uy", point:0, Games:0, Vic:0, Def:0, Nul:0, butp:0, butm:0 ,butdiff:0},
	];		
	} else if (group == "B") {	  
		var ranking = [
			{name:"Spain", flag:"es",  point:0, Games:0, Vic:0, Def:0, Nul:0, butp:0, butm:0 ,butdiff:0},
			{name:"Portugal", flag:"pt", point:0, Games:0, Vic:0, Def:0, Nul:0, butp:0, butm:0 ,butdiff:0},
			{name:"Morocco", flag:"ma", point:0, Games:0, Vic:0, Def:0, Nul:0, butp:0, butm:0 ,butdiff:0},
			{name:"Iran", flag:"ir", point:0, Games:0, Vic:0, Def:0, Nul:0, butp:0, butm:0 ,butdiff:0},
		];	
	} else if (group == "C") {
		var ranking = [
			{name:"France", flag:"fr", point:0, Games:0, Vic:0, Def:0, Nul:0, butp:0, butm:0 ,butdiff:0},
			{name:"Australia", flag:"au", point:0, Games:0, Vic:0, Def:0, Nul:0, butp:0, butm:0 ,butdiff:0},
			{name:"Peru", flag:"pe", point:0, Games:0, Vic:0, Def:0, Nul:0, butp:0, butm:0 ,butdiff:0},
			{name:"Denmark", flag:"dk", point:0, Games:0, Vic:0, Def:0, Nul:0, butp:0, butm:0 ,butdiff:0},
		];	
	} else if (group == "D") {
		var ranking = [
			{name:"Argentina", flag:"ar", point:0, Games:0, Vic:0, Def:0, Nul:0, butp:0, butm:0 ,butdiff:0},
			{name:"Iceland", flag:"is", point:0, Games:0, Vic:0, Def:0, Nul:0, butp:0, butm:0 ,butdiff:0},
			{name:"Croatia", flag:"hr", point:0, Games:0, Vic:0, Def:0, Nul:0, butp:0, butm:0 ,butdiff:0},
			{name:"Nigeria", flag:"ng", point:0, Games:0, Vic:0, Def:0, Nul:0, butp:0, butm:0 ,butdiff:0},
		];			
	} else if (group == "E") {
		var ranking = [
			{name:"Brazil", flag:"br", point:0, Games:0, Vic:0, Def:0, Nul:0, butp:0, butm:0 ,butdiff:0},
			{name:"Switzerland", flag:"ch", point:0, Games:0, Vic:0, Def:0, Nul:0, butp:0, butm:0 ,butdiff:0},
			{name:"Costa Rica", flag:"cr", point:0, Games:0, Vic:0, Def:0, Nul:0, butp:0, butm:0 ,butdiff:0},
			{name:"Serbia", flag:"rs", point:0, Games:0, Vic:0, Def:0, Nul:0, butp:0, butm:0 ,butdiff:0},
		];			
	} else if (group == "F") {
		var ranking = [
			{name:"Germany",flag:"de", point:0, Games:0, Vic:0, Def:0, Nul:0, butp:0, butm:0 ,butdiff:0},
			{name:"Mexico", flag:"mx", point:0, Games:0, Vic:0, Def:0, Nul:0, butp:0, butm:0 ,butdiff:0},
			{name:"Sweden", flag:"se", point:0, Games:0, Vic:0, Def:0, Nul:0, butp:0, butm:0 ,butdiff:0},
			{name:"South Korea", flag:"kr", point:0, Games:0, Vic:0, Def:0, Nul:0, butp:0, butm:0 ,butdiff:0},
		];		
	} else if (group == "G") {
		var ranking = [
			{name:"Belgium", flag:"be", point:0, Games:0, Vic:0, Def:0, Nul:0, butp:0, butm:0 ,butdiff:0},
			{name:"Panama", flag:"pa", point:0, Games:0, Vic:0, Def:0, Nul:0, butp:0, butm:0 ,butdiff:0},
			{name:"Tunisia", flag:"tn", point:0, Games:0, Vic:0, Def:0, Nul:0, butp:0, butm:0 ,butdiff:0},
			{name:"England", flag:"gb", point:0, Games:0, Vic:0, Def:0, Nul:0, butp:0, butm:0 ,butdiff:0},
		];	
	} else if (group == "H") {
		var ranking = [
			{name:"Poland", flag:"pl", point:0, Games:0, Vic:0, Def:0, Nul:0, butp:0, butm:0 ,butdiff:0},
			{name:"Senegal", flag:"sn", point:0, Games:0, Vic:0, Def:0, Nul:0, butp:0, butm:0 ,butdiff:0},
			{name:"Colombia", flag:"co", point:0, Games:0, Vic:0, Def:0, Nul:0, butp:0, butm:0 ,butdiff:0},
			{name:"Japan", flag:"jp", point:0, Games:0, Vic:0, Def:0, Nul:0, butp:0, butm:0 ,butdiff:0},
		];		
	}

	
	for(i = 0; i < 6; i++){
		
		var point; var Games; var Vic; var Def; var Nul; var butp; var butm;  var butdiff;
        
		if (document.getElementById('games['+i+'].scoreHome').value 
				&& document.getElementById('games['+i+'].scoreAway').value){
		
        var gameHome  =  document.getElementById('games['+i+'].gameHome').innerText;
        var scoreHome =  parseInt(document.getElementById('games['+i+'].scoreHome').value);
        var gameAway  =  document.getElementById('games['+i+'].gameAway').innerText;
        var scoreAway =  parseInt(document.getElementById('games['+i+'].scoreAway').value); 
        
        
        var iH = findIndexInData(ranking,'name',gameHome);	     
    	var iA = findIndexInData(ranking,'name',gameAway);
    	
    	ranking[iH]['Games']++;
  		ranking[iA]['Games']++;
  		
  		ranking[iH]['butp'] = ranking[iH]['butp'] + scoreHome;
  		ranking[iH]['butm'] = ranking[iH]['butm'] + scoreAway;
  		ranking[iH]['butdiff'] = ranking[iH]['butp'] - ranking[iH]['butm'];
  		
  		ranking[iA]['butp'] = ranking[iA]['butp'] + scoreAway;
  		ranking[iA]['butm'] = ranking[iA]['butm'] + scoreHome;
  		ranking[iA]['butdiff'] = ranking[iA]['butp'] - ranking[iA]['butm'];
  		
  		if (scoreHome > scoreAway){
      		ranking[iH]['Vic']++;
      		ranking[iA]['Def']++;
        } else if (scoreHome == scoreAway) {
      		ranking[iH]['Nul']++;
      		ranking[iA]['Nul']++;
        } else if (scoreHome < scoreAway) {
      		ranking[iA]['Vic']++;
      		ranking[iH]['Def']++;
        }
  		
  		ranking[iH]['point'] = ranking[iH]['Vic']*3 + ranking[iH]['Nul'];
  		ranking[iA]['point'] = ranking[iA]['Vic']*3 + ranking[iA]['Nul'];
	
	}
	}
	ranking.sort(function(b, a) { 
	    return a.point - b.point || a.butdiff - b.butdiff;
	});
    var k = '<tbody>'
        for(i = 0; i < ranking.length; i++){
            k+= '<tr>';
            k+= '<td><span class="flag-icon flag-icon-' +  ranking[i].flag + ' flag-icon-squared"></span></td>';
            k+= '<td>' + ranking[i].name + '</td>';
            k+= '<td>' + ranking[i].Games + '</td>';
            k+= '<td>' + ranking[i].Vic + '</td>';
            k+= '<td>' + ranking[i].Nul + '</td>';
            k+= '<td>' + ranking[i].Def + '</td>';
            k+= '<td>' + ranking[i].butp + '</td>';
            k+= '<td>' + ranking[i].butm + '</td>';
            k+= '<td>' + ranking[i].butdiff + '</td>';
            k+= '<td>' + ranking[i].point + '</td>';
            k+= '</tr>';
        } 
        k+='</tbody>';
        document.getElementById("Ranking").innerHTML = k;
	
};

function alert2(i)    {
alert(document.getElementById('games['+i+'].gameHome').innerText);

	};