<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>


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
<%/* include Banner.jsp in translation time, to ensure the username is dynamic */ %>
		<jsp:include page="Banner.jsp" /> 
        <br>
<%/* *********************************************************** */ %>

<!-- Station By Org LOV population -->
	<script type="text/javascript">
	function PopulateStationListLOV_func_01(){
	document.getElementById("selected_station_id").value=document.getElementById("StationsList_select_01").value;
	document.PopulateStationListLOV_form_name_01.submit();
	return true;
	}
	</script>	



 	<form id="PopulateStationListLOV_form_id_01" method="POST" action="SelectStationServlet" name="PopulateStationListLOV_form_name_01">
 	     <Select name="StationsList_select_01" size="1" id="StationsList_select_01" onchange=" return PopulateStationListLOV_func_01 ();">   
    	        	<option 
    	        	value="No_Station"
            		<c:if test="${selected_station_id eq 'No_Station'}">
        		 	selected="selected" 
        			</c:if>>    	        
        			<c:out value="Please Select a Station"/></option>
      			<c:forEach items="${stationListBean.getListOfData(sessionScope.organization)}" var="st">
            		<option 
            		value="${st.getStationID()}" 
    	        	<c:if test="${selected_station_id eq st.getStationID()}">
        		 	selected="selected" 
        			</c:if>>
        			<c:out value="${st.getStationName()}"/></option>
      			</c:forEach>
      	</select>
       	<input type="hidden" name="form_indicator_flag" value="form_populate_station_list_LOV_01" /> 
      	<input type="hidden" name="selected_station_id" id="selected_station_id">
      	<!-- the first input is the indicator for which form this is, I need to put this in all the forms and give them different values -->
      	<!-- the second input is the variable that will hold the value selected from the LOV, and it will be set and submitted by the javascript -->
</form>
<!-- /Station By Org LOV population -->

<c:choose>
	<c:when test="${stationSelectedFlag=='false'}">
	No Station Selected
	</c:when>
	<c:otherwise>
  Alex Station
  	</c:otherwise>
</c:choose>






















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