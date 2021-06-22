<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.Product" %>
<%@ page import="dao.ProductRepository" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel = "stylesheet"
	href = "https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>상품등록처리</title>
</head>
<body>
<%
request.setCharacterEncoding("UTF-8");

String productId=request.getParameter("productId");
String name=request.getParameter("name");
String unitPrice=request.getParameter("unitPrice");
String description=request.getParameter("description");
String manufacturer=request.getParameter("manufacturer");
String category=request.getParameter("category");
String unitsInStock=request.getParameter("unitsInStock");
String condition=request.getParameter("condition");

Integer price;

if(unitPrice.isEmpty()){
	price = 0;
}
else{
	price = Integer.valueOf(unitPrice);
}

long stock;

if(unitsInStock.isEmpty()){
	stock=0;
}
else{
	stock=Long.valueOf(unitsInStock);
}

ProductRepository dao = ProductRepository.getInstance();

Product newProduct = new Product();
newProduct.setProductId(productId);
newProduct.setPname(name);
newProduct.setUnitPrice(price);
newProduct.setDescription(description);
newProduct.setManufacturer(manufacturer);
newProduct.setCategory(category);
newProduct.setUnitsInStock(stock);
newProduct.setCondition(condition);

dao.addProduct(newProduct);

response.sendRedirect("products.jsp");
%>
</body>
</html>
