<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="com.weatherstation.service.GenerateTableService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:useBean id="stationListBean" scope="session"
	class="com.weatherstation.service.StationLOVPopulateService" />
<jsp:useBean id="GenerateHeaderBean" scope="session"
	class="com.weatherstation.service.GenerateTableService" />
<html>
<head>
<title>Welcome</title>
<script src="JS/jquery.min.js" type="text/javascript"> </script>
<script src="JS/jquery.fixedtableheader.min.js" type="text/javascript"> </script>


<script type="text/javascript"> 
		$(document).ready(function() { 
  		 $('#StationTable').fixedtableheader(); 
		}); 
</script>
</head>
<body>
	<%
	/* *********************************************************** */
%>
	<%
	/*   
	check if loggedInflag==false, then go login
	this flag is set to true in LoginServlet after a successfull login
	this is the effective code, not the one in the banner,jsp, dunno why
*/
%>
	<c:if test="${!loggedInFlag}">
		<%
					response.sendRedirect("Login.jsp");
				%>
	</c:if>
	<%
		/* include Banner.jsp in translation time, to ensure the username is dynamic */
	%>
	<jsp:include page="Banner.jsp" />
	<br>
	<%
	/* *********************************************************** */
%>

	<!-- Station By Org LOV population -->
	<script type="text/javascript">
	function PopulateStationListLOV_func_01(){
	document.getElementById("selected_station_id").value=document.getElementById("StationsList_select_01").value;
	document.PopulateStationListLOV_form_name_01.submit();
	return true;
	}
	</script>
	<script type="text/javascript">
	function PopulatePageNumberLOV_func_01(){
	document.getElementById("selected_page_id").value=document.getElementById("select_PageNumber").value;
	document.PopulatePageListLOV_form_name_01.submit();
	return true;
	}
	</script>





	<form id="PopulateStationListLOV_form_id_01" method="POST"
		action="SelectStationServlet"
		name="PopulateStationListLOV_form_name_01">
		<Select name="StationsList_select_01" size="1"
			id="StationsList_select_01"
			onchange=" return PopulateStationListLOV_func_01 ();">
			<option value="No_Station"
				<c:if test="${selected_station_id eq 'No_Station'}">
        		 	selected="selected" 
        			</c:if>>
				<c:out value="Please Select a Station" /></option>
			<c:forEach
				items="${stationListBean.getListOfData(sessionScope.organization)}"
				var="st">
				<option value="${st.getStationID()}"
					<c:if test="${selected_station_id eq st.getStationID()}">
        		 	selected="selected" 
        			</c:if>>
					<c:out value="${st.getStationName()}" /></option>
			</c:forEach>
		</select> <input type="hidden" name="form_indicator_flag"
			value="form_populate_station_list_LOV_01" /> 
			<input type="hidden"name="selected_station_id" id="selected_station_id">
		<!-- the first input is the indicator for which form this is, I need to put this in all the forms and give them different values -->
		<!-- the second input is the variable that will hold the value selected from the LOV, and it will be set and submitted by the javascript -->
	</form>
	<!-- /Station By Org LOV population -->

	<c:choose>
		<c:when test="${stationSelectedFlag=='false'}">
		</c:when>
		<c:otherwise>
			<br>
			<%
    		GenerateTableService Gen2= new GenerateTableService ();
			Long NumberOfReadings=Gen2.getNumberOfReadings((String)(session.getAttribute("selected_station_id")));
			Long NumberOfPages=((NumberOfReadings/100));
			request.setAttribute("NumberOfPages", NumberOfPages);
			%>
			<form id="PopulatePageListLOV_form_id_01"
				name="PopulatePageListLOV_form_name_01" method="POST"
				action="SelectStationServlet">
				Page 
				<Select name="select_PageNumber" size="1" id="select_PageNumber"
					onchange=" return PopulatePageNumberLOV_func_01 ();">
					<c:forEach begin="0" end="${NumberOfPages}" varStatus="PageNumber">
						<option value="${PageNumber.index}"
							<c:if test="${selected_page_id eq PageNumber.index}"> selected="selected" </c:if>>
							${PageNumber.index+1}
					</c:forEach>
				</select> <input type="hidden" name="form_indicator_flag"
					value="form_populate_page_list_LOV_01" /> <input type="hidden"
					name="selected_page_id" id="selected_page_id">
			out of <%=NumberOfPages+1%>
			</form>
	<c:choose>
		<c:when test="${pageSelectedFlag=='false'}">
		</c:when>
		<c:otherwise>

		<%
			if (session.getAttribute("selected_page_id")=="")
			{
				session.setAttribute("selected_page_id", "0");
			}
	    	out.println(Gen2.GenerateTableHeadArrayMethod((String)(session.getAttribute("selected_station_id"))));  
	    	out.println(Gen2.GenerateTableBodyArrayMethod((String)(session.getAttribute("selected_station_id")),(String)(session.getAttribute("selected_page_id")),"100"));				
    	%>
    	</c:otherwise>
    	</c:choose>
		</c:otherwise>
	</c:choose>























</body>
</html>