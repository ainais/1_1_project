<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="board_ex.service.*, board_ex.model.*" %>
<%
	// 1. 수정할 레코드의 게시글번호를 넘겨받기
	String seq = request.getParameter("seq");

	// 2. Service에 getArticleById()함수를 호출하여 그 게시글번호의 레코드를 검색
	BoardDao service = BoardDao.getInstance();
	BoardVO vo = service.selectById(Integer.parseInt(seq));
%>   
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시글 수정하기</title>
</head>
 <body>
	<h4> 게시판 글 수정하기 </h4><br/>
	<form name='frm' method='post' action="BoardModify.jsp">
	<table>
	<tr>
		<td>제목</td>
		<td><input type='text' value="<%=vo.getTitle() %>" name = "title"></td>
	</tr>
	<tr>
		<td>작성자</td>
		<td><input type='text' value="<%=vo.getWriter() %>" name="writer"></td>
	</tr>
	<tr>
		<td>패스워드</td>
		<td><input type='password' name="password"></td>
	</tr>
	<tr>
		<td>내용</td>
		<td><textarea name='content' rows='10' cols='40'><%=vo.getContent() %></textarea></td>
	</tr>	
	<tr>
		<td><input type='submit' value='수정하기'></td>
		<td><input type='button' value='목록보기' onclick="window.location='BoardList.jsp'"></td>
	</tr>
	</table>
	<input type="hidden" value='<%=seq %>' name="seq">
	</form>

</body>
</html>