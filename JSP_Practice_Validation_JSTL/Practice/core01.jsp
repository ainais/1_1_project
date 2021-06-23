<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSTL</title>
</head>
<body>
	browser 변수 값 설정
	<C:set var="browser" value="${header['User-Agent']}" />
	<br>
	<C:out value="${browser}" />
	<p> browser 변수 값 제거 후
		<C:remove var="browser" />
		<C:out value="${browser}" />
</body>
</html>