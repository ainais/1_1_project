<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "java.util.ArrayList" %>
<%@ page import = "dao.Product" %>
<%@ page import = "dao.ProductRepository" %>
<jsp:useBean id="productExample" class="dao.ProductRepository" scope="session" />
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<meta charset="UTF-8">

<title>상품 목록</title>
</head>
<body>
<!-- 메뉴바 만들기 -->
<jsp:include page="menu.jsp" />

<!-- 상단 큰 사이즈 만들기 만들기 -->
	<div class = "jumbotron">
		<div class="container">
			<h1 class="display-3">상품 목록</h1>
			<form action="addProduct.jsp">
				<input type="submit" value="상품 등록하기" class="btn btn-secondary">
			</form>
		</div>
	</div>

<!-- 상품 목록 만들기 -->
	<%
		ProductRepository dao = ProductRepository.getInstance();
		ArrayList<Product> listOfProducts = dao.getAllProducts();
	%>
	<div class="container">
		<div class="row" align="center">
			<%
				for(int i=0; i<listOfProducts.size(); i++){
					Product product = listOfProducts.get(i);
			%>
			<div class="col-md-4">
				<img src="./../resources/images/<%=product.getFilename() %>" style="width:100%"%>
				<h3><%=product.getPname() %></h3>
				<p><%=product.getDescription() %></p>
				<p><%=product.getUnitPrice() %></p>
				<!-- 버튼을 만들어서 상품 정보의 세부정보 열람하기 -->
				<p><a href="./product.jsp?id=<%=product.getProductId() %>"
				class="btn btn-secondary" role="button">상세 정보 &raquo;</a>
			</div>
			<%
				}
			%>
		</div>
		<hr>
	</div>
</body>
</html>