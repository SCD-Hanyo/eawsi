<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome to the SCD Weather Station Portal</title>
<link href="css/Login.css" rel="stylesheet" type="text/css">

</head>
<body>
<body>
	<div id="bannerid1">
		
			<a href="http://www.shortcircuitdesigns.com">
				<img src="pics/website_banner.jpg" width="500" height="85" />
			</a>
			<img class="bannerclass1" src="pics/CLAC logo.png" align="right"/>
			<img src="pics/Capture2.JPG" width="1356" height="65"/>		
	</div>


	<div id="logintextid" class="logintextclass">
		<form action="LoginServlet" method="post">
			<h1 class="logintextclass">Welcome to the First Egyptian Weather Station
			</h1> <br>
			<h2 class="logintextclass">Designed,Implemented and Manufactured by  
			<a href="http://www.shortcircuitdesigns.com">Short circuit Designs</a>
			</h2>
			
			<h2 class="logintextclass">Please enter your user name and password below:
			</h2>
<%/* *********************************************************** */ %>
<%/*  
	check if login failed, then display message to try again
*/ %>
			
			<c:if test="${tryAgainFlag}"> 
				<h4 class="logintextclass"> Error ! Please try again</h4>
				<% session.setAttribute("tryAgainFlag", false); %>
			</c:if>	 
<%/* *********************************************************** */ %>
			
			<table align="center">	
			<tr align="center">	
			<td>	
			<label class="logintextclass">user name </td>
			<td>	<input class="logintextclass" type="text" name="UserName" size="19" maxlength="50"> </td>
			</label>
			</tr align="center">
			<td><label class="logintextclass">password </td>
			<td>	<input class="logintextclass" type="password" name="Password" size="19" maxlength="50"> <td>
			</label>
			
<%/* *********************************************************** */ %>
<%/*  
	this dummy is needed to avoid null pointer exception.
	need to ensure it dosn't happen with the logout button
*/ %>				
				<input type="hidden" name="logout" value="dummy">
<%/* *********************************************************** */ %>
				
				<br>
				<tr align="center">	
				<td> </td> 
				<td>
					<input class="logintextclass2" type="submit" value="Sign In"></label>
				</td>
				</tr>
		</form>
		</table>
		
	</div>
</body>


</body>
</html>