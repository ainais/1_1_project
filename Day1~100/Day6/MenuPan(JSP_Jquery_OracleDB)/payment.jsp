<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import = "java.sql.*" %>
<%@ page import = "java.util.Date" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
  <title> 상품주문 처리 </title>
  
  <link rel="stylesheet" href="css/base.css" type="text/css" media="screen"  />  
  <link rel="stylesheet" href="css/form.css" type="text/css" media="screen"  />  
  <script src="/webUI/5_jquery_class/lib/jquery-2.0.1.min.js" type="text/javascript" charset="utf-8"></script>

</head>
<body>
<jsp:include page="header.jsp" />
<h3>오늘의 판매 기록(ORACLE DB와 연동되어 데이터를 가져옴)</h3>
<br>
<form>
<%
	//CREATE TABLE sales( today VARCHAR2(30), totalprice VARCHAR2(30) ); 가 있다고 가정
	String url="jdbc:oracle:thin:@localhost:1521:xe";
	String user = "HR";
	String pass = "1234";
	Connection conn;
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;
	
	Class.forName("oracle.jdbc.driver.OracleDriver");
	conn = DriverManager.getConnection(url,user,pass);
	stmt = conn.createStatement();
	
	Date now = new Date();
	String finalPrice = request.getParameter("total");
	
	pstmt = conn.prepareStatement("INSERT INTO sales VALUES('" + now + "','" + finalPrice + "')");
	rs = pstmt.executeQuery();
	
	pstmt = conn.prepareStatement("SELECT * FROM sales");
	rs = pstmt.executeQuery();
	out.println("<table>");
	out.println("<tr>");
	out.println("<th>판매 날짜</th>");
	out.println("<th>판매 가격</th>");
	out.println("</tr>");
	while(rs.next()){
		out.println("<tr>");
		out.println("<td>"+rs.getString("TODAY")+"</td>");
		out.println("<td>"+rs.getString("TOTALPRICE")+" 원</td>");
		out.println("</tr>");		
	}
	out.println("<tr>");
	out.println("<td>============</td>");
	out.println("<td>============</td>");
	out.println("</tr>");
%>

<%
pstmt = conn.prepareStatement("SELECT sum(TOTALPRICE) FROM sales");
rs = pstmt.executeQuery();
while(rs.next()){
	out.println("<tr>");
	out.println("<td>총 판매량 : </td>");
	out.println("<td>"+rs.getString("sum(TOTALPRICE)")+"원</td>");
	out.println("</tr>");	
}
out.println("</table>");
%>
</form>
<br>
<jsp:include page="footer.jsp" />
</body>
</html>
