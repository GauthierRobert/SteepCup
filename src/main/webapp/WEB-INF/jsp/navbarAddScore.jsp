
<%@ taglib prefix="security"  uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script type="text/javascript">
                
                function t()
                {
            var compteur=document.getElementById('compteur');
            s=duree;
            s2=duree2;
            m=0;h=0,j=0;
            m2=0;h2=0,j2=0;
            if(s<0 || s2<0)
                        {

            			}
                        else
                        {
                                if(s>59)
                                {
                                        m=Math.floor(s/60);
                                        s=s-m*60
                				}
                                if(m>59)
                                {
                                        h=Math.floor(m/60);
                   						m=m-h*60
                                }
                                if(h>23)
                                {
                                	j=Math.floor(h/24);
               						h=h-j*24	
                                }
                               
               					 if(s<10)
                                {
                                        s="0"+s
               					 }
                				if(m<10)
                                {
                    					m="0"+m
                				}
                
                       			if(s2>59)
                        		{
                               		 m2=Math.floor(s2/60);
                                	s2=s2-m2*60
        						}
                       		 	if(m2>59)
                        		{
                                	h2=Math.floor(m2/60);
           							m2=m2-h2*60
                        		}
                        		if(h2>23)
                        		{
                        			j2=Math.floor(h2/24);
       								h2=h2-j2*24	
                        		}
                       
        						if(s2<10)
                        		{
                                	s2="0"+s2
        						}
        						if(m2<10)
                       			{
          						 	m2="0"+m2
        			
                				}
                  compteur.innerHTML="World Cup starts in :<br />" +j + "j "+h+"h "+m+"m "+s+"s <br /><br /> Inscription will close in :<br /> "+j2 + "j "+h2+"h "+m2+"m "+s2+"s <br />"; 

            }
            duree=duree-1;
            duree2=duree2-1;
            window.setTimeout("t();",1000);
        }
                
</script>

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
            <li><a href="A.html">Group A</a></li>
            <li><a href="B.html">Group B</a></li>
            <li><a href="C.html">Group C</a></li>
            <li><a href="D.html">Group D</a></li>
            <li><a href="E.html">Group E</a></li>
            <li><a href="F.html">Group F</a></li>
            <li><a href="G.html">Group G</a></li>
            <li><a href="H.html">Group H</a></li>
            <li><a href="../knockoutStage.html">Knockout stage </a></li>
          </ul>
        </li>
        <li><a href="../addFinalPhase.html">Pronostics phase 2</a></li>
        <security:authorize access="hasRole('ADMIN')">
			<li><a href="worldCupScore.html">Enter World Cup Scores</a></li> 
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
       		<li><a href="../login.html" ><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
		</security:authorize>
      </ul>
      </div>
  </div>
<div class="container-fluid" id="navbarfluid2" style="background-color: transparent;">
	<security:authorize access="isAuthenticated()">
  	<p class="navbar-text" style="color: #fff;  font-size: 14px; ">Logged in as <security:authentication property="principal.username" /></p>
  	</security:authorize> 
</div>	
  	<p class="navbar-text" style="color: #fff;  font-size: 20px; aligntext:left;" id="compteur"></p>
  	
  	                <script type="text/javascript">
                var today = Date.now();
                var wcstart = new Date("2018","05", "14","17", "00", "00", "0000");
                var difftime = Math.floor((wcstart-today)/1000);
                
                var today2 = Date.now();
                var wcstart2 = new Date("2018","05", "13","23", "59", "59", "9999");
                var difftime2 = Math.floor((wcstart2-today2)/1000);
                
                        duree=difftime.toString();
                        duree2=difftime2.toString();
						t();

                        
</script>


</nav> 