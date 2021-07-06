<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="board_ex.model.*,board_ex.service.*" %>

<%
	// 0. 넘겨받는 데이타의 한글 처리
	request.setCharacterEncoding("UTF-8");
	
	// 입력받은 비밀번호
	String inputPass = request.getParameter("password");
	
	// rec 객체 멤버 변수 설정
	BoardVO rec = new BoardVO();
	rec.setSeq(Integer.parseInt(request.getParameter("seq")));
	rec.setTitle(request.getParameter("title"));
	rec.setWriter(request.getParameter("writer"));
	rec.setContent(request.getParameter("content"));
	rec.setPass(inputPass);
	
	ModifyArticleService service = ModifyArticleService.getInstance();
	int result = service.update(rec);

%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시판글수정</title>
</head>
<body>

<%  // 게시글 수정이 성공적으로 되었다면 그 해당 게시글을 보여주는 페이지로 이동하고
    // 그렇지 않다면, "암호가 잘못 입력되었습니다"를 출력
    if(result == 0){
    	%>
    	암호가 잘못 입력 되었습니다.
    	<br>
    	<a href="BoardList.jsp">목록으로 돌아가기</a>
    	<%
    	
    }
    else{
    	response.sendRedirect("BoardView.jsp?seq=" + request.getParameter("seq"));
    }
	
%>

</body>
</html>