<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String name = request.getParameter("name");
String pocketmon = request.getParameter("pocketmon");

String selectPocketmon = "";
if (pocketmon.equals("p1")) {
selectPocketmon = "피카츄";
} else if (pocketmon.equals("p2")) {
selectPocketmon = "꼬부기";
} else if (pocketmon.equals("p3")) {
selectPocketmon="이브이";
} else {
selectPocketmon="기타포켓몬";
}
%>
<!-- 출력결과 -->
<%=name %> 님이 선택한 포켓몬은 <%=selectPocketmon %> 입니다.<p>
선택한 포켓몬:<br>
<img src="<%=pocketmon +".png"%>" border="0" style="width:300px; height:300px;">

</body>
</html>