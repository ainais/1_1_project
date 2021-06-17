<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>First Action Tag</title>
</head>
<body>
	<h3>이 파일은 first.jsp입니다.</h3>
	<jsp:forward page="second.jsp" />
	
	<p>first.jsp는 foward 액션태그시 비워지며 결과 값은 second.jsp만 출력됩니다.</p>
</body>
</html>