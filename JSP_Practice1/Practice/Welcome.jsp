<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<meta charset="UTF-8">
<title>시작페이지</title>
</head>
<body style="text-align:center;">
<nav class="navbar navbar-expand  navbar-dark bg-dark">
<div class="container">
<div class="navbar-header">
     <a class="navbar-brand" href="Welcome.jsp">Home</a>
</div>
</div>
</nav>
	
	<%! String greeting = "웹 쇼핑몰에 오신 것을 환영합니다.";
		String tagline = "Welcome to Web Market!";%>
		
<div class="jumbotron">
    <div class="container">
       <h1 class="display-3">
            <%=greeting%>
        </h1>
    </div>
</div>
<div class="container">
         <div class="text-center">
               <h3>
                <%=tagline%>
               </h3>
          </div>
   <hr>
</div>

<jsp:include page="WelcomeTime.jsp" />

<footer class="container" style="text-align:center;">
       <p>&copy; WebMarket</p>
 </footer>

</body>
</html>