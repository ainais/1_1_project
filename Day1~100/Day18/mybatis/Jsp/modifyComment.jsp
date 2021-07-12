<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
  <%@ page import="mybatis.guest.model.Comment" %>
 <%@ page import="mybatis.guest.service.CommentService" %>  
 <%
 request.setCharacterEncoding("UTF-8");
 long commentNo = Integer.parseInt( request.getParameter("cId"));
 String userId = request.getParameter("cWriter");
 String commentContent = request.getParameter("cContent");
 String regDate = request.getParameter("cRegdate");
 
 Comment comment = new Comment();
 comment.setCommentNo((int)commentNo);
 comment.setUserId(userId);
 comment.setCommentContent(commentContent);
 comment.setRegDate(regDate);
 
 CommentService.getInstance().updateCommentByPK(comment);
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>수정이 완료되었습니다.</h2>
<a href="listComment.jsp">목록으로 돌아가기</a>
</body>
</html>