<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %> 
<%@ page import="sample.*" %>
<%
	// 이전 화면에서 넘겨주는 값을 받기
	String eno = request.getParameter("eno");

	// DAO에 viewEmp() 호출
	EmpDAO dao = EmpDAO.getInstance();
	List<EmpVO> list = dao.viewEmp(Integer.parseInt(eno));
	
	// 아래 화면에 해당 사원의 각각의 정보를 출력
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="selectEmp.jsp">사원목록보기</a>
<table border="2">
	<tr>
		<td>사번</td>
		<td>사원명</td>
		<td>매니저</td>
		<td>업무</td>
		<td>고용일</td>
		<td>월급</td>
		<td>커미션</td>
		<td>부서번호</td>
	</tr>
	<% for(EmpVO vo : list){ %>
	<tr>
		<td><%=vo.getEno() %></td>
		<td><%=vo.getEname() %></a></td>
		<td><%=vo.getJob() %></td>
		<td><%=vo.getManager() %></td>
		<td><%=vo.getHiredate() %></td>
		<td><%=vo.getSalary() %></td>
		<td><%=vo.getCommission() %></td>
		<td><%=vo.getDno() %></td>
	</tr>
	<%} // end of for %>
</table>
</body>
</html>