<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %> 
<%@ page import="sample.*" %>
<%
	EmpDAO dao = EmpDAO.getInstance();
	List<EmpVO> list = dao.selectEmp();
%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원목록보기</title>
</head>
<body>
<a href="start.jsp">처음화면으로 돌아가기</a>
<table border="2">
	<tr>
		<td>사번</td>
		<td>사원명</td>
		<td>매니저</td>
		<td>업무</td>
	</tr>
	<% for(EmpVO vo : list){ %>
	<tr>
		<td><%=vo.getEno() %></td>
		<td><a href='viewEmp.jsp?eno=<%=vo.getEno() %>'><%=vo.getEname() %></a></td>
		<td><%=vo.getJob() %></td>
		<td><%=vo.getManager() %></td>
	</tr>
	<%} // end of for %>
</table>
</body>
</html>
