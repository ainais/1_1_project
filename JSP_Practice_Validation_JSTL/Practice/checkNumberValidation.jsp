<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Check Number Validation</title>
<script type="text/javascript">
	function checkLogin(){
		var form = document.loginForm;
		
		for(i=0; i<form.id.value.length; i++){
			var ch = form.id.value.charAt(i);
			
			// Ascii 코드 표 : https://shaeod.tistory.com/760
			if ( (ch < 'a' || ch > 'z') && (ch>'A' || ch<'Z') && (ch>'0' || ch<'9') ){
				alert("아이디는 영문 소문자만 입력 가능합니다!");
				form.id.select();
				return;
			}
		}
		
		if(isNaN(form.passwd.value)){
			alert("비밀번호는 숫자만 입력 가능합니다!");
			form.passwd.select();
			return;
		}
		if(form.passwd.value == ""){
			alert("비밀번호의 공백은 허용되지 않습니다.");
			form.passwd.select();
			return;
		}
		form.submit();
	}

</script>
</head>
<body>
	<form name="loginForm" action="checkNumberValidation_process.jsp" method="post">
		<p>아이디 : <input type="text" name="id"></p>
		<p>비밀번호 : <input type="password" name="passwd"></p>
		<p><input type="button" value="검사하기" onclick="checkLogin()"></p>
	</form>
</body>
</html>