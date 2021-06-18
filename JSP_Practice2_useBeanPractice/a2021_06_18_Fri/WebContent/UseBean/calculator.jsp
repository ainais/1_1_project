<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Use Calculator</title>
</head>
<body>
	<jsp:useBean id="bean" class="a2021_06_18_Fri.Calculator" />
	<%
	int m = bean.process(5);
	out.print("5의 3제곱 : " + m);
	%>
	<jsp:setProperty property="" name="bean" />
	<jsp:getProperty property="" name="bean" />
</body>
</html>