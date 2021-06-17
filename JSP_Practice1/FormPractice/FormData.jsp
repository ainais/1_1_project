<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 <%
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FormData</title>
</head>
<body>
<%
String name = request.getParameter("name");
int age = Integer.parseInt(request.getParameter("age"));
String gender = request.getParameter("gender");
String hobby = request.getParameter("hobby");
%>
<h1><%=name %>님의 정보는 다음과 같습니다.</h1>
<hr>
나이 : <%=age %><br>
성별 : <%=gender %><br>
취미 : <%=hobby %><br>
</body>
</html>