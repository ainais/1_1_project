<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Validation</title>
<script>
	function CheckForm(){
		alert("아이디 :" + document.loginForm.id.value + "\n" + "비밀번호 :" + document.loginForm.password.value);
	}
</script>
</head>
<body>
	<form name="loginForm">
	<p> 아이디 : <input type="text" name="id"> </p>
	<p> 비밀번호 : <input type="password" name="password"> </p>
	<p> <input type="submit" onclick="CheckForm()"> </p>
	
	</form>
</body>
</html>