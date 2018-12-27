<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="utf-8">
<link rel="shortcut icon" href="resources/images/logo1.ico"/>
<meta name="viewport" content="width=devicse-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>${title}</title>
</head>

<body>
	<c:import url="navbar.jsp"></c:import>
	<div style="min-height: 500px;">
	<c:if test="${carouselpage}">
	<c:import url="carousel.jsp"></c:import>
	</c:if>
	<c:if test="${aboutuspage}">
	<c:import url="aboutus.jsp"></c:import>
	</c:if>
	<c:if test="${contactuspage}">
	<c:import url="contactus.jsp"></c:import>
	</c:if>
	<c:if test="${Loginpage}">
	<c:import url="Login.jsp"></c:import>
	</c:if>
	<c:if test="${floginpage}">
	<c:import url="Login.jsp"></c:import>
	</c:if>
	<c:if test="${regPage}">
	<c:import url="register1.jsp"></c:import>
	</c:if>
	<c:if test="${cartpage}">
	<c:import url="cart.jsp"></c:import>
	</c:if>
	<c:if test="${addresspage}">
	<c:import url="address.jsp"></c:import>
	</c:if>
	<c:if test="${orderpage}">
	<c:import url="order.jsp"></c:import>
	</c:if>
	<c:if test="${billpage}">
	<c:import url="invoice.jsp"></c:import>
	</c:if>
	<c:if test="${categorypage}">
	<c:import url="category.jsp"></c:import>
	</c:if>
 	<c:if test="${productpage}"> 
	<c:import url="product.jsp"></c:import>
	</c:if>  
	<c:if test="${viewallProduct}"> 
	<c:import url="viewallProduct.jsp"></c:import>
	</c:if> 
	<c:if test="${viewoneProduct}"> 
	<c:import url="viewoneProduct.jsp"></c:import>
	</c:if> 
	</div>
	<c:import url="footer.jsp"></c:import>
</body>

</html>
