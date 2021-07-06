<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="board_ex.model.*,board_ex.service.*" %>

<%
	request.setCharacterEncoding("utf-8");
	String writer = request.getParameter("writer");
	String title = request.getParameter("title");
	String content = request.getParameter("content");
	String password = request.getParameter("password");
%>

<%
	WriteArticleService service = WriteArticleService.getInstance();
	BoardVO vo = new BoardVO(); 
	vo.setWriter(writer);
	vo.setTitle(title);
	vo.setContent(content);
	vo.setPass(password);

	service.write(vo);
	
	int id = vo.getSeq();
	response.sendRedirect("BoardList.jsp");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>게시판글저장</title>
</head>
<body>
</body>
</html>