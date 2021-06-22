<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Validation</title>
<script>
	function checkLogin(){
		var form = document.loginForm;
		if (form.id.value == ""){
			alert("아이디를 입력해주세요.");
			form.id.focus();
			return false;
		} 
		else if (form.passwd.value == ""){
			alert("비밀번호를 입력해주세요.");
			form.passwd.focus();
			return false;
		}
		form.submit();
	}
</script>
</head>
<body>
	<form name="loginForm" action="validation02_process.jsp" method="post">
	<p> 아이디 : <input type="text" name="id"> </p>
	<p> 비밀번호 : <input type="password" name="passwd"> </p>
	<p> <input type="button" value="전송" onclick="checkLogin()"> </p>
	</form>
</body>
</html>