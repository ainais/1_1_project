<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Star(For)</title>
</head>
<body>
<%
for(int i =1; i<=10; i++){
	for(int j=1; j<=i; j++){
		out.println("*");
	}
	out.println("<br>");
}
%>
</body>
</html>