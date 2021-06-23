<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html><head>
<title>Internationalization</title>
</head>
<body>
<%= response.getLocale() %>

<fmt:setLocale value="ko"/>
<p><%= response.getLocale() %>

<fmt:setLocale value="ja"/>
<p><%= response.getLocale() %>

<fmt:setLocale value="en"/>
<p><%= response.getLocale() %>

</body></html>
