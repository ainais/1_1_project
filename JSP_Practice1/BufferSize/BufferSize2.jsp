<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 <%@ page buffer="1kb" autoFlush="true" %> <!-- 디폴트는 8kb이다. -->
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>autoFlush 속성값 예제</title>
</head>
<body>

<% for(int i=0;i<1000;i++){ %>
 1234
<% } %>

</body>
</html>