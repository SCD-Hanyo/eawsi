<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html> 
<head> 
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Banner</title>
<link href="css/banner.css" rel="stylesheet" type="text/css">
</head>
<body>
<%/* *********************************************************** */ %>
<%/* useless ? */ %>
		<c:if test="${!loggedInFlag}"> 
				<% response.sendRedirect("Login.jsp"); %>
		</c:if>	
<%/* *********************************************************** */ %>
<!-- *************************************************************************** -->
	<div>
		<a href="http://www.shortcircuitdesigns.com">
        <img   src="pics/website_banner.jpg" width="500" height="85"/>
        </a>
        <img src="pics/CLAC logo.png" align="right">
    </div>
	<div id="greydiv">
		<img class="centerimage"  src="pics/Capture2.JPG" width="1350" height="65" />
        <b class="bluetextbold"> Welcome</b>
        <i class="bluetextitalic"> ${currentUser} !</i>
        <br>

<%/* *********************************************************** */ %>
<%/* Logout Button */ %>        
        <form action="LoginServlet" method="post">
        <input type="hidden" name="logout"  value="logout">
		<input type="submit" value="Sign out"> 
		</form>
<%/* *********************************************************** */ %>
<!-- *************************************************************************** -->
     </div>   
     <div id='cssmenu'>
		<ul>
		    <li class='active'><a href='Welcome.jsp'><span>Home</span></a></li>
		    <li><a href='#'><span>About</span></a></li>
   			<li><a href='#'><span>Contact</span></a></li>
   			<li><a href='#'><span>FAQ</span></a></li>
   			<li class='last'><a href='#'><span>News</span></a></li>
		</ul>
	</div>
