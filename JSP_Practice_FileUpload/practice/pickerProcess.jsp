<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Picker 데이터 받기</title>
</head>
<body>
<hr>
<h3>request를 이용하여 Picker 데이터 받기</h3>
<hr>
<table border="1">
	<tr>
		<td><%=request.getParameter("pdate") %></td>
	</tr>
	<tr>
		<td><%= request.getParameter("pdatetimeLocal")%></td>
	</tr>
	<tr>
		<td><%= request.getParameter("pmonth")%></td>
	</tr>
	<tr>
		<td><%= request.getParameter("ptime")%></td>
	</tr>
	<tr>
		<td><%= request.getParameter("pweek")%></td>
	</tr>
</table>

<jsp:useBean id="pc" class="practice.Picker" />
<jsp:setProperty property="*" name="pc" />
<hr>
<h3>useBean을 이용하여 Picker 데이터 받기</h3>
<hr>
<table border="1">
	<tr>
		<td><jsp:getProperty name="pc" property="pdate" /></td>
	</tr>
	<tr>
		<td><jsp:getProperty name="pc" property="pdatetimeLocal" /></td>
	</tr>
	<tr>
		<td><jsp:getProperty name="pc" property="pmonth" /></td>
	</tr>
	<tr>
		<td><jsp:getProperty name="pc" property="ptime" /></td>
	</tr>
	<tr>
		<td><jsp:getProperty name="pc" property="pweek" /></td>
	</tr>
</table>

<hr>
<h3>객체 선언을 이용하여 Picker 데이터 받기</h3>
<hr>
<%@ page import = "practice.Picker" %>
<%
Picker pck = new Picker();
pck.setPdate( request.getParameter("pdate") );
pck.setPdatetimeLocal( request.getParameter("pdatetimeLocal") );
pck.setPmonth( request.getParameter("pmonth") );
pck.setPtime( request.getParameter("ptime") );
pck.setPweek( request.getParameter("pweek") );
%>
<table border="1">
	<tr>
		<td><%=pck.getPdate() %></td>
	</tr>
	<tr>
		<td><%=pck.getPdatetimeLocal() %></td>
	</tr>
	<tr>
		<td><%=pck.getPmonth() %></td>
	</tr>
	<tr>
		<td><%=pck.getPtime() %></td>
	</tr>
	<tr>
		<td><%=pck.getPweek() %></td>
	</tr>
</table>
</body>
</html>