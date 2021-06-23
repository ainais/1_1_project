<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html><head>
<title>Internationalization</title>
</head>
<body>

<fmt:requestEncoding value="euc-kr"/>
요청 파라미터:
<%   out.print(request.getParameter("id")); %>
<p><%= response.getLocale() %>

<form action="#" method="post">
<p>아이디:<input type="text" name="id">
<input type="submit" value="전송">
</form>

</body></html>
