<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
int i=1;
while(i<=10){
	int j=1;
	while(j<=i){
		out.println("*");
		j++;
	}
	out.println("<br>");
	i++;
}
%>
</body>
</html>