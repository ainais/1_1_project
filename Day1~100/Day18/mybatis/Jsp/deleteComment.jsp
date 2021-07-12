<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
  <%@ page import="mybatis.guest.model.Comment" %>
 <%@ page import="mybatis.guest.service.CommentService" %>   
 <%
 long commentNo = Integer.parseInt( request.getParameter("cId"));
 CommentService.getInstance().deleteCommentByPK(commentNo);
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h3>삭제완료 되었습니다.</h3>

<a href="listComment.jsp">목록으로 돌아가기</a>
</body>
</html>