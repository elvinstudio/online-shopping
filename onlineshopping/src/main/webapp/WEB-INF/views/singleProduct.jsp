<div class="container">
	<div class="row">
		<div class="col-xs-12">
			<ol class="breadcrumb">
				<li><a href="${contextRoot}/home">Home</a></li>
				<li><a href="${contextRoot}/show/all/products">Products</a></li>
				<li><a class="active">${product.productName}</a></li>
			</ol>
		</div>
	</div>
	<div class="row">
		<!-- display image -->
		<div class="col-xs-12 col-sm-4">
			<div class="thumbnail">
				<img src="${product.productImage}" class="img img-responsive" />
			</div>

		</div>
		<!-- display description -->
		<div class="col-xs-12 col-sm-8">
			<h3>${product.productName}</h3>
			<hr />
			<p>${product.productDescription}</p>
			<hr />
			<h4>
				Price: <strong>&#xFFE5; ${product.price} /-</strong>
			</h4>
			<hr />

			<c:choose>
				<c:when test="${product.remains<1}">
					<h6>
						Qty. Availabile: <span color="red">Out of Stock!</span>
					</h6>
				</c:when>
				<c:otherwise>
					<h6>Qty. Availabile: ${product.remains}</h6>
				</c:otherwise>
			</c:choose>
			
			<c:choose>
				<c:when test="${product.remains<1}">
					<a href="javascript:void(0)" class="btn btn-success disable"><span
						class="glyphicon glyphicon-shopping-cart"></span><strike>Add to cart</strike></a>
					<a href="${contextRoot}/show/all/products" class="btn btn-primary">Back</a>
				</c:when>
				<c:otherwise>
					<a href="${contextRoot}/cart/add/${product.productId}/product"
						class="btn btn-success"><span
						class="glyphicon glyphicon-shopping-cart"></span>Add to cart</a>
					<a href="${contextRoot}/show/all/products" class="btn btn-primary">Back</a>
				</c:otherwise>
			</c:choose>

		</div>
	</div>
</div>
