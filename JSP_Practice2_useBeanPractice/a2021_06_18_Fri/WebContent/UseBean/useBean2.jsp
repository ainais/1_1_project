<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>UseBean2</title>
</head>
<body>
	<jsp:useBean id="person" class="a2021_06_18_Fri.Person" scope="request"/>
	<p> 아이디 : <%=person.getId() %></p>
	<p> 이름 : <%=person.getName() %></p>
</body>
</html>