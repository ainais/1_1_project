<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>목록 보기</title>
</head>
<body>
		<h1>목록보기</h1>

		
	<table border="1">
			<tr>
				<th bgcolor="orange" width="100">seq</th>
				<th bgcolor="orange" width="200">title</th>
				<th bgcolor="orange" width="150">writer</th>
				<th bgcolor="orange" width="150">regDate</th>
				<th bgcolor="orange" width="100">cnt</th>
			</tr>
			<c:forEach items="${boardList }" var="board">
				<tr>
					<td>${board.seq }</td>
					<td align="left"><a href="getBoard.do?seq=${board.seq }">
							${board.title }</a></td>
					<td>${board.writer }</td>
					<td><fmt:formatDate value="${board.regDate }" pattern="yyyy-MM-dd"/></td>
					<td>${board.cnt }</td>
				</tr>
			</c:forEach>
		</table>
		<br> <a href="insertBoard.do">글 쓰러가기</a>
</body>
</html>