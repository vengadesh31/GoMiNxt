<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">


<div class="container">
	<div class="row">
		<div class="col-sm-5 ">
			<div>
				<img src="resources/productimage/${p.productId}.jpg" width="400px" height="300px">
			</div>
		</div>
		<div class="col-sm-7">
			<div class="card-body p-5">
				<h3 class="title mb-3">${p.productName}</h3>

				<p class="price-detail-wrap">
					<span class="price h3 text-warning"> <span class="currency">&#8377</span><span
						class="num">${p.price}</span>
					</span>
				</p>
				<!-- price-detail-wrap .// -->
				<dl class="item-property">
					<dt>Description</dt>
					<dd>
						<p>${p.productDesc}</p>
					</dd>
				</dl>


				<dl class="param param-feature">
					<dt>Delivery</dt>
					<dd>Free Shipping And COD For COIMBATORE,CHENNAI AND BANGALORE</dd>
				</dl>
				<c:if test="${p.quantity != 0 }">
					<label>Enter Quantity</label>
					<input type="number" min="1" name="upqty" id="upqty"
						class="text-center" value="1">
				</c:if>
				<p id="demo"></p>
				<br>
				<c:if test="${msg}">
					<span class="alert alert-danger">Requested quantity not
						available</span>
				</c:if>
				<br>

				<hr>
				<c:if test="${p.quantity == 0 }">
					<span class="btn btn-primary btn-product ">Out of Stock</span>
				</c:if>
		
				<a href="viewallProduct" class="btn btn-success btn-product"><span
					class="glyphicon glyphicon-shopping-cart"></span>BACK</a>
				
				<c:if test="${p.quantity != 0 }">					
					<a name="refreshcart" id="refreshcart"
						href="addToCart?productName=${p.productName}"
						class="btn btn-success btn-product">
						<span class="glyphicon glyphicon-shopping-cart"></span>Add to Cart
					</a>
				</c:if>
				
			</div>
		</div>
	</div>
</div>


