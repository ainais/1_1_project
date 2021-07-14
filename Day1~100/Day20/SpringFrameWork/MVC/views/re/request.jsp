<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>request.do 요청에 의한 뷰페이지</h1>
<hr>
아이디:${memberVO.getId()}<br>
이름:${param.name}<br>
나이:${memberVO.age}
</body>
</html>