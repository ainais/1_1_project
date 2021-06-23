<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.Locale" %>
<%
Locale locale = response.getLocale();
String displayLanguage = locale.getDisplayLanguage();
String language = locale.getLanguage();
String displayCountry = locale.getDisplayCountry();
String country = locale.getCountry();
			
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Locale1</title>
</head>
<body>

	<h3>로케일 언어 : <% out.print(displayLanguage); %></h3>
	<h3>로케일 언어 코드 : <% out.print(language); %></h3>
	<h3>로케일 국가 : <% out.print(displayCountry); %></h3>
	<h3>로케일 국가 코드 : <% out.print(country); %></h3>
</body>
</html>