<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<table border="1">
	<tr>
		<td colspan="3" align="center" bgcolor="orange">사진첩</td>
	</tr>
	<c:forEach items="${boardList}" var="board" varStatus="status" step="3">
	<tr>
		<c:forEach items="${boardList}" var="boa" varStatus="stat" begin="${status.index}" end="${status.index+2}" step="1">
		<td>
			<c:choose>
			    <c:when test="${boa.b_fsize==0}">
			    <a href='getBoard.do?b_id=${boa.b_id }'><img alt="첨부파일 없음" width="100" height="100"/></a>
			    </c:when>
			    <c:otherwise>		
			    		<a href='getBoard.do?b_id=${boa.b_id }'><img src='resources/upload/${boa.b_fname}' width="100" height="100"/></a>	    	
			    </c:otherwise>
			 </c:choose>
		</td>
		</c:forEach>
	</tr>
	</c:forEach>
	</table>

</body>
</html>