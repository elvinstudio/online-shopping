<div class="row">
	<c:forEach items="${products}" var="product">
		<div class="col-lg-4 col-md-6 mb-4">
			<div class="card h-100">
				<a href="#"><img class="card-img-top"
					src="${product.productImage}" alt=""></a>
				<div class="card-body">
					<h4 class="card-title">
						<a href="#">${product.productName}</a>
					</h4>
					<h5>${product.price}</h5>
					<p class="card-text">${product.productDescription}</p>
				</div>
				<c:if
					test="${((product.inventory-product.sold)*100/product.inventory)<11}">
					<div class="card-footer">
						<small class="text-muted">
							&#20165;&#21097;${(product.inventory-product.sold)}&#20214;&#65281;</small>
					</div>
				</c:if>
			</div>
		</div>
	</c:forEach>
</div>
<!-- /.row -->