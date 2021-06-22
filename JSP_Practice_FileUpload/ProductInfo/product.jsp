<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.Product" %>
<%@ page import="dao.ProductRepository" %>
<jsp:useBean id="productDAO" class="dao.ProductRepository" scope="session" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel = "stylesheet"
	href = "https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>상품 상세 정보</title>
</head>
<body>
<!-- 메뉴바 만들기 -->
	<jsp:include page="menu.jsp" />
	
<!-- 상단 큰 사이즈 만들기 만들기 -->
	<div class="jumbotron">
		<div class="container">
			<h1 class="display-3">상품 정보</h1>
		</div>
	</div>
<!-- 해당 세부정보와 일치시킬 수 있도록 파라미터 가져오기 -->
	<%
		String id = request.getParameter("id");
		ProductRepository dao = ProductRepository.getInstance();
		Product product = dao.getProductById(id);
	%>
<!-- 세부정보 열람하기 -->
	<div class="container">
		<div class = "row">
			<div class="col-md-5">
				<img src="./../resources/images/<%=product.getFilename() %>" style="width:100%"%>
			</div>
			<div class = "col-md-6">
				<h3><%=product.getPname() %></h3>
				<p><%=product.getDescription() %></p>
				<p> <b>상품 코드 :</b><span class="badge badge-danger"><%=product.getProductId() %></span></p>
				<p> <b>제조사 :</b><%=product.getManufacturer() %></p>
				<p> <b>분류 :</b><%=product.getCategory() %>
				<p> <b>재고 수 :</b><%=product.getUnitsInStock() %>
				<h4><%=product.getUnitPrice() %>원</h4>
				<p> <a href="#" class="btn btn-info">상품 주문 &raquo;</a>
					<a href="./products.jsp" class="btn btn-secondary">상품 목록 &raquo;</a>
			</div>
		</div>
	</div>
</body>
</html>