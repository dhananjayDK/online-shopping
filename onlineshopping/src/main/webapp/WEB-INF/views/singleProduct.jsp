<div class="container">
	<!-- breadcrumb -->
	<div class="row">
		<div class="col-xs-12">
			<ol class="breadcrumb">
				<li><a href="${contextRoot}/home">Home</a></li>
				<li><a href="${contextRoot}/show/all/listOfProduct">Products</a></li>
				<li class="active">${product.name}</li>
			</ol>
		</div>
	</div>

	<!-- Display single product image -->
	<div class="row">
		<div class="col-xs-12 col-md-4">
			<div class="thumbnail">
				<img src="${images}/${product.code}.jpg" class="img img-responsive" />
			</div>
		</div>
		<div class="col-xs-12 col-md-8">
			<h3>${product.name}</h3>
			<hr />
			<p>${product.description}</p>
			<hr />
			<h4>
				Price: <strong>&#8377 ${product.unit_price}</strong>
			</h4>
			<hr />

			<c:choose>
				<c:when test="${product.quantity<1}">
					<h6>
						Qty. Available: <span style="color: red;">Out Of Stock</span>
					</h6>
				</c:when>
				<c:otherwise>
					<h6>Qty. Available: ${product.quantity}</h6>
				</c:otherwise>
			</c:choose>
			<c:choose>
				<c:when test="${product.quantity<1}">
					<h6>
						<a href="javascript: void(0)" class="btn btn-success disabled">
							<span class="glyphicon glyphicon-shopping-cart">Add to
								Cart</span>
					</h6>
				</c:when>
				<c:otherwise>
					<a href="${contextRoot}/cart/add/${product.id}"
						class="btn btn-success"> <strike> <span
							class="glyphicon glyphicon-shopping-cart">Add to Cart</span>
					</strike>
				</c:otherwise>
			</c:choose>

			</a> &nbsp&nbsp <a href="${contextRoot}/show/all/listOfProduct"
				class="btn btn-primary"> <span class="">Back</span>
			</a>


		</div>
	</div>
</div>