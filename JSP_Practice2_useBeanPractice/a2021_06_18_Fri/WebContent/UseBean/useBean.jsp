<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "a2021_06_18_Fri.Person"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>UseBean</title>
</head>
<body>
<h3>UseBean을 이용</h3>
<jsp:useBean id="person" class="a2021_06_18_Fri.Person" scope="request"/>
	<p> 아이디 : <%=person.getId() %></p>
	<p> 이름 : <%=person.getName() %></p>
<hr>
<h3>UseBean을 내용을 setId,setName으로 변경</h3>
<%
	person.setId("12");
	person.setName("홍길동");
%>
	<p> 아이디 : <%=person.getId() %></p>
	<p> 이름 : <%=person.getName() %></p>
<hr>
<h3>@import로 가져온 객체를 직접 선언하고 데이터 가져오기</h3>
<%
	Person person2 = new Person();
	out.print( person2.getId() + "   " +person2.getName());
%>
<hr>
<h3>setProperty 액션으로 변경하기</h3>
	<jsp:setProperty property="id" name="person" value="34" />
	<jsp:setProperty property="name" name="person" value="이정성" />
	<p> 아이디 : <%=person.getId() %></p>
	<p> 이름 : <%=person.getName() %></p>
<hr>
<h3>getProperty 액션으로 정보 가져오기</h3>
<jsp:getProperty name = "person" property="id" /><br>
<jsp:getProperty name = "person" property="name" />
</body>
</html>