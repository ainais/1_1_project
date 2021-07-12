<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
  <%@ page import="mybatis.guest.model.Comment" %>
 <%@ page import="mybatis.guest.service.CommentService" %>  
  <% 
  long commentNo = Integer.parseInt( request.getParameter("cId"));
  String userId = request.getParameter("cWriter");
  String commentContent = request.getParameter("cContent");
  String regDate = request.getParameter("cRegdate");
  
  Comment comment = new Comment();
  comment.setCommentNo((int)commentNo);
  comment.setUserId(userId);
  comment.setCommentContent(commentContent);
  comment.setRegDate(regDate);
  %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="modifyComment.jsp" method="post">
<table border="1">
		<tr><td>글번호</td><td><input type="text" name="cId" readonly value="<%=comment.getCommentNo()%>"></td></tr>
		<tr><td>작성자</td><td><input type="text" name="cWriter" value="<%=comment.getUserId()%>"></td></tr>
		<tr><td>메세지</td>
		<td>
		<textarea name="cContent"><%=comment.getCommentContent()%></textarea>
		</td></tr>
		<tr><td>등록일</td><td><input type="text" name="cRegdate" readonly value="<%=comment.getRegDate()%>"></td></tr>
		<tr><td colspan="2">
				<input type="submit" id="btnModify" value="수정하기"/>
				</td></tr>
</table>
</form>

</body>
</html>