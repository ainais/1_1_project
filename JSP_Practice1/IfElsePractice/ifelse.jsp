<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>If-else 문 예제 - 좋아하는 포켓몬 선택</h2>
<form method = "get" action = "ifelse_Process.jsp">
<dl>
<dd>
<label for="name">이름</label>
<input type="text" id="name" name="name" placeholder="홍길동" autofocus required>
</dd>
<dd>
<label for="pocketmon">포켓몬 선택</label>
<select id="pocketmon" name="pocketmon" required>
<option value="p1" selected>피카츄</option>
<option value="p2">꼬부기</option>
<option value="p3">이브이</option>
</select>
</dd>
<dd>
<input type="submit" value="확인">
</dd>
</dl>
</form>

</body>
</html>