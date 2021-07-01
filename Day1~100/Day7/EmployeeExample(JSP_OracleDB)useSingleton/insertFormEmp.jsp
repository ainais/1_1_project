<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원등록화면</title>
</head>
<body>
	<a href="start.jsp">처음화면으로 돌아가기</a>
	<form method="post" action="saveEmp.jsp">
	<table >
		<tr>
			<td><label for= "eno">사번</label></td>
			<td><input type = "text" id ="eno" name ="eno" placeholder="사번" required ></td>
		</tr>
		<tr>
			<td><label for= "ename">이름</label></td>
			<td><input type = "text" id ="ename" name ="ename" placeholder="이름" required></td>
		</tr>
		<tr>
			<td><label for= "job">직업</label></td>
			<td><input type = "text" id ="job" name ="job" placeholder="직업" required></td>
		</tr>
		<tr>
			<td><label for= "manager">매니저 번호</label></td>
			<td><input type = "text" id ="manager" name ="manager" placeholder="매니저 번호" required></td>
		</tr>
		<tr>
			<td colspan="2" align="center"><input type="submit" value ="입력"><input type="reset" value ="초기화"></td>
		</tr>
	</table>
	</form>

</body>
</html>