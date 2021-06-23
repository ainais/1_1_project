<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Validation</title>
<script type="text/javascript">
	function checkLogin(){
		var form = document.loginForm;
		
		if(form.id.value.length <4 || form.id.value.length > 12){
			alert("아이디는 4~12자 이내로 입력 가능합니다.");
			form.id.select();
			return;
		}
		
		if(form.passwd.value.length <4){
			alert("비밀번호는 4자 이상으로 입력해야 합니다.");
			form.passwd.select();
			return;
		}
		form.submit();
	}
</script>
</head>
<body>
	<form name = "loginForm" action="dataLengthValidation02_process.jsp" method="post">
		<p> 아이디 : <input type="text" name="id">
		<p> 비밀번호 : <input type="password" name="passwd">
		<p> <input type="button" value="전송" onclick="checkLogin()">
	</form>
</body>
</html>