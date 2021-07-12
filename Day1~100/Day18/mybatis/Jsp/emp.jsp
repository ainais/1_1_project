<%@ page language="java" contentType="text/html; charset=utf-8" %>
 <%@ page import="java.util.*" %> 
 <%@ page import="mybatis.guest.model.Comment" %>  
 <%@ page import="mybatis.guest.service.CommentService" %>  
 <%@page import="mybatis.guest.session.CommentRepository"%>
  
  <!-- 서비스의 메소드 호출  -->
 <%
 request.setCharacterEncoding("UTF-8");

 List<HashMap<String,String>> mList = CommentService.getInstance().empSelect(); 

 %>
   
<!DOCTYPE html>
<html> 
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>목록보기</title>
</head>
<body> 
<table border="1">
	<tr>
	<td>사원번호</td>
	<td>사원명</td>
	<td>직업</td>
	<td>부서명</td>	
	</tr>
	<%for(int i=0; i<mList.size(); i++){%>
	
	<tr>
		<td><%=mList.get(i).get("eno")%></td>
		<td><%=mList.get(i).get("ename").hashCode()%></td>
		<td><%=mList.get(i).get("job")%></td>
		<td><%=mList.get(i).get("dname")%></td>

	</tr>
	<%} // end of for %>
</table>

</body>
</html>
