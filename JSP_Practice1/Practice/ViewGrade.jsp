<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Grade</title>
</head>
<body>
	<%
		// 정보 및 점수 가져오기
		int bunho = Integer.parseInt(request.getParameter("bunho"));
		String name = request.getParameter("name");
		int kor = Integer.parseInt(request.getParameter("kor"));
		int eng = Integer.parseInt(request.getParameter("eng"));
		int math = Integer.parseInt(request.getParameter("math"));
		int tot = kor + eng + math;
		double avg = (kor + eng + math) / 3.0;

		// 등급 평가하기
		String grade;
		switch ((tot / 3) / 10) {
		case 10:
		case 9:	grade = "A등급";	break;
		case 8:	grade = "B등급";	break;
		case 7:	grade = "C등급";	break;
		case 6:	grade = "D등급";	break;
		case 5:	grade = "E등급";	break;
		case 4:
		case 3:
		case 2:
		case 1:	grade = "F등급";	break;
		default: grade = "잘못된 점수 값 입니다.";	break;
		}
	%>
	<table border="1px solid black"	style="border-collapse: collapse; text-align: center;">
		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>국어</th>
			<th>영어</th>
			<th>수학</th>
			<th>합계</th>
			<th>평균</th>
			<th>등급</th>
		</tr>
		<tr>
			<td><%=bunho%></td>
			<td><%=name%></td>
			<td><%=kor%></td>
			<td><%=eng%></td>
			<td><%=math%></td>
			<td><%=tot%></td>
			<td><%=avg%></td>
			<td><%=grade%></td>
		</tr>
	</table>
</body>
</html>