<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Picker 만들기</title>
<style>
	td{
	width:150px;
	}
</style>
</head>
<body>
<h3>Picker 만들기</h3>
<hr>
<form action="pickerProcess.jsp" method="post" >
	<table border="1" style="text-align:center;">
		<tr>
			<td>date</td>
			<td><input type="date" name="pdate"></td>
		</tr>
		<tr>
			<td>datetime-local</td>
			<td><input type="datetime-local" name="pdatetimeLocal"></td>
		</tr>
		<tr>
			<td>month</td>
			<td><input type="month" name="pmonth"></td>
		</tr>
		<tr>
			<td>time</td>
			<td><input type="time" name="ptime"></td>
		</tr>
		<tr>
			<td>week</td>
			<td><input type="week" name="pweek"></td>
		</tr>
		<tr>
			<td><input type="submit" value="확인"></td>
			<td><input type="reset" value="취소"></td>
		</tr>
	</table>
</form>
</body>
</html>