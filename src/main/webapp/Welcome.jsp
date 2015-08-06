<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<jsp:useBean id="stationListBean" scope="session" class="com.weatherstation.service.StationLOVPopulateService"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
</head>
<body>
<%/* *********************************************************** */ %>
<%/*   
	check if loggedInflag==false, then go login
	this flag is set to true in LoginServlet after a successfull login
	this is the effective code, not the one in the banner,jsp, dunno why
*/ %>
		<c:if test="${!loggedInFlag}">
				<% response.sendRedirect("Login.jsp"); %>
		</c:if>	
<%/* *********************************************************** */ %>
<!--   *************************************************************************** -->
<%/* *********************************************************** */ %>
<%/* include Banner.jsp in translation time, to ensure the username is dynamic */ %>
		<jsp:include page="Banner.jsp" /> 
        <br>
<%/* *********************************************************** */ %>
<!--   *************************************************************************** -->


 <form id="test" method="POST" action="">
      <Select name="Stations" size="1" id="Stations_List">
      <c:forEach items="${stationListBean.ListOfData()}" var="st">
            <option value="1"><c:out value="${st.StationName}"/></option>
      </c:forEach>
      </select>
      <br>
      <input type="Submit" name="cmdSub" value="SUBMIT">
      <input type="Reset" name="cmdReset" value="RESET">
    </form>

























<%/* *********************************************************** */ %>
<%/* 
	choose a station from dropdown list, send selected choice 
	to SelectStationServlet, return SelectedStation option
	very stupid, needs improvment !
	
	the javascript below replaces the submit button, 
	plus it helps keeping the choice selected in the drop down list
*/ %>


<script type="text/javascript">
function setValue1(){
document.getElementById("dropdown").value=document.getElementById("SelectedStation").value;
document.SelectStationForm.submit();
return true;
}
		function setValue() {
			document.DateForm.submit();
			return true;
		}
		function setFilterBy() {
			if (document.getElementById('chk1').checked
					&& document.getElementById('chk2').checked) {
				document.getElementById('chk1').value = 5;
				document.FilterByForm.submit();
			} else if (document.getElementById('chk1').checked) {
				document.FilterByForm.submit();
			} else if (document.getElementById('chk2').checked) {
				document.FilterByForm.submit();
			}
			return true;
		}
		function setDisplayOrFilter() {
			if (document.getElementById('chk3').checked
					&& document.getElementById('chk4').checked) {
				document.getElementById('chk3').value = 5;
				document.FilterOrDisplayForm.submit();
			} else if (document.getElementById('chk3').checked) {
				document.FilterOrDisplayForm.submit();
			} else if (document.getElementById('chk4').checked) {
				document.FilterOrDisplayForm.submit();
			}
			return true;
		}
	</script>
<form action="SelectStationServlet" name="SelectStationForm" method="post">
    <select id="SelectedStation" name="SelectedStation" onchange="return setValue1();">
        <option value="none" 
        	<c:if test="${SelectedStation eq 'none'}">
        		 selected="selected" 
        	</c:if>
        	> Please select a station</option>

        <option value="October" 
        	<c:if test="${SelectedStation eq 'October'}">
        		 selected="selected" 
        	</c:if>
        	> 1-October Station</option>

        <option value="Dokki" 
        	<c:if test="${SelectedStation eq 'Dokki'}">
        		 selected="selected" 
        	</c:if>
        	> 2-Dokki Station</option>

        <option value="Alex" 
        	<c:if test="${SelectedStation eq 'Alex'}">
        		 selected="selected" 
        	</c:if>
        	> 3-Alex Station</option>
    </select>
    <input type="hidden" name="dropdown" id="dropdown">
    </form>
<%/* *********************************************************** */ %>
<!--   *************************************************************************** -->


<%/* *********************************************************** */ %>
<%/* 
	if SelectedStation == null => came from refresh or first time
	if SelectedStation == none => the empty option was selected
	if SelectedStation == October => Display october Station Table Here
	else put an empty table					
*/ %>
<%/* *********************************************************** */ %>
<c:choose>
  <c:when test="${SelectedStation==NULL}">
  </c:when>	
  <c:when test="${SelectedStation=='none'}">
    No Station Selected
  </c:when>
  <c:when test="${SelectedStation=='October'}">
  
  	<form action="SelectStationServlet" method="get" name="FilterOrDisplayForm">
		<input type="hidden" name="form" value="FilterOrDisplayForm" />
		Display All Readings
		<input type="radio" name="FilterOrDisplay" value="Display"id="chk3"
			<c:if test="${FilterOrDisplayFormInputFlag eq 'Display'  }">
				checked="checked"
			</c:if>
		onchange="return setDisplayOrFilter();" />
		<input type="hidden" name="form" value="FilterByForm" /> 
		<br> 
		Filter by Date And/Or Parameter
		 <input type="radio" name="FilterOrDisplay" value="Filter" id="chk4"
			<c:if test="${FilterOrDisplayFormInputFlag eq 'Filter' }">
				checked="checked"
			</c:if>
		onchange="return setDisplayOrFilter();" /> 
	</form>
   	<c:if test="${FilterOrDisplayFormInputFlag eq 'Filter'}">
   	      <jsp:include page="Filter.jsp" /> 
   	</c:if>
   	<c:if test="${FilterOrDisplayFormInputFlag eq 'Error'}">
		<b> Error ! try again </b>
	</c:if>
 	<c:if test="${FilterOrDisplayFormInputFlag=='Display'}">
   	<jsp:include page="Readings.jsp" /> 
   	</c:if>
  	</c:when>
  	<c:when test="${SelectedStation=='Dokki'}">
   Dokki Station
		<jsp:include page="TableHeader.jsp" />

  </c:when>
  <c:otherwise>
  Alex Station
  <jsp:include page="TableHeader.jsp"/>

</c:otherwise>
</c:choose>
<!--   *************************************************************************** -->

</body>
</html>