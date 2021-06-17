<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>표현식 예제</title>
</head>
<body>
<h2>표현식 예제 - 배열 원소 출력</h2>
<%
String[] str = {"JSP","JAVA","Android","HTML5"};
%>
<table>
<tr>
<th>배열의 철자번호</th>
<th>배열 요소의 합</th>
</tr>
<% for(int i=0; i<str.length; i++){ %>
<tr>
<td><%=i %></td>
<td><%=str[i] %></td>
</tr>
<%} %>
</table>
<h2>레퍼런스 타입의 출력</h2>
<%
StringBuffer sf = new StringBuffer("unicorn");
sf.reverse();
out.println("객체의 내용: " + sf.toString()+"<br>");

int x = 10;
int y =(x>10) ? 20:x;
out.println("y변수의 내용:" + y);

%>
</body>
</html>