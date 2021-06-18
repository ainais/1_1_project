<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>useBean을 이용한 성적처리</title>
<style>
	th,td{
	text-align:center;
	font-size:20px;
	font-weight:bold;
	width:70px;
	height:70px;
	}
</style>
</head>
<body>
<jsp:useBean id="grade" class="a2021_06_18_Fri.Grade" />
<h3>useBean을 이용한 성적처리</h3>
<hr>
<table border="1px solid black">
	<tr>
		<th>번호</th>
		<th>이름</th>
		<th>국어</th>
		<th>영어</th>
		<th>수학</th>
		<th>합계</th>
		<th>평균</th>
		<th>학점</th>
	</tr>
	<tr>
		<td><%=grade.getBunho() %></td>
		<td><%=grade.getName() %></td>
		<td><%=grade.getKor() %></td>
		<td><%=grade.getEng() %></td>
		<td><%=grade.getMath() %></td>
		<td><%=grade.getTot() %></td>
		<td><%=grade.getAvg() %></td>
		<td><%=grade.fGrade() %></td>
	</tr>
	<!-- 필드 변환하기  -->
	<%
	grade.setBunho("2");
	grade.setName("홍길동");
	grade.setKor(11);
	grade.setEng(22);
	grade.setMath(33);
	%>
	<tr>
		<td><%=grade.getBunho() %></td>
		<td><%=grade.getName() %></td>
		<td><%=grade.getKor() %></td>
		<td><%=grade.getEng() %></td>
		<td><%=grade.getMath() %></td>
		<td><%=grade.fTot() %></td>
		<td><%=grade.fAvg() %></td>
		<td><%=grade.fGrade() %></td>
	</tr>
</table>

</body>
</html>