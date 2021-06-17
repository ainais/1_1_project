<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Star(do-While)</title>
</head>
<body>
<%
int i =0;
do{
	i++;
	int j =1;
	do{
		out.println("*");
		j++;
	} while(j<=i);
	out.println("<br>");
} while(i<10);
%>
</body>
</html>