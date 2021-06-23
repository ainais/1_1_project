<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Internationalization</title>
</head>
<body>
<p>------------------------fmt:bundle-------------------------
<fmt:bundle basename = "bundle.myBundle" >
	<p>제목 : <fmt:message key="title" var="title" /> ${title}
	<p><fmt:message key="username" var="userMsg" /> 이름 :  ${userMsg}
	<p> <fmt:message key="password" var="pwd" /> 패스워드 : ${pwd}
</fmt:bundle>

<p>------------------------fmt:ko_bundle-------------------------
<fmt:bundle basename = "bundle.myBundle_ko" >
	<p>제목 : <fmt:message key="title2" var="title2" /> ${title2}
	<p><fmt:message key="username2" var="userMsg2" /> 이름 :  ${userMsg2}
	<p> <fmt:message key="password2" var="pwd2" /> 패스워드 : ${pwd2}
</fmt:bundle>
</body>
</html>