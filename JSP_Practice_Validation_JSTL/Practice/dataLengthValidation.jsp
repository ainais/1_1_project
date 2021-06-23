<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Validation</title>
<script type="text/javascript">
	function checkForm(){
		if(document.frm.name.value.length<6 || document.frm.name.value.length >12){
			alert("이름을 6~12자 이내로 입력해주세요.");
			document.frm.name.select();
		}
	}
</script>
</head>
<body>
	<form name = "frm">
		<p> 이름 : <input type="text" name="name">
			<input type="submit" value="전송" onclick="checkForm()">
	</form>
</body>
</html>