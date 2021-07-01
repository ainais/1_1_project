<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %> 
<%@ page import="sample.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	// 1. 이전 화면에서 사용자 입력 값을 얻어오기
	String eno = request.getParameter("eno");
	String ename = request.getParameter("ename");
	String job = request.getParameter("job");
	String manager = request.getParameter("manager");

	// 2. 입력 값을 VO객체의 변수로 지정하기
	EmpVO vo = new EmpVO();
	vo.setEno(Integer.parseInt(eno));
	vo.setEname(ename);
	vo.setJob(job);
	vo.setManager(Integer.parseInt(manager));
	
	// 3. DAO의 insert함수를 호출
	EmpDAO dao = EmpDAO.getInstance();
	dao.insertEmp(vo);
	
	// Insert가 완료되면 자동으로 목록으로 돌아가기
	response.sendRedirect("selectEmp.jsp");
%>

</body>
</html>