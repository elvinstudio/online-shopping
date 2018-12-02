<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<div class="container">
	<div class="row">
		<c:if test="${not empty message}">
			<div class="col-xs-12">
				<div class="alert alert-success alert-dimissible">
					<button type="button" class="close" data-dismiss="alert">&times;</button>
					${message}
				</div>
			</div>
		</c:if>

		<div class="col-md-offset-2 col-md-8">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h4>Product Management</h4>
				</div>

				<div class="panel-body">

					<sf:form class="form-horizontal" modelAttribute="product"
						action="${contextRoot}/manage/products" method="POST">


						<div class="from-group">
							<label class="control-label col-md-4" for="name">Enter
								Product Name:</label>
							<div class="col-md-8">
								<sf:input type="text" path="productName" id="name"
									placeholder="Product Name" class="from-control" />
								<sf:errors path="productName" cssClass="help-block" element="em" />
							</div>
						</div>

						<div class="from-group">
							<label class="control-label col-md-4" for="brand">Enter
								Brand Name:</label>
							<div class="col-md-8">
								<sf:input type="text" path="productBrand" id="brand"
									placeholder="Brand Name" class="from-control" />
								<sf:errors path="productBrand" cssClass="help-block"
									element="em" />
							</div>
						</div>

						<div class="from-group">
							<label class="control-label col-md-4" for="description">Enter
								Description:</label>
							<div class="col-md-8">
								<sf:textarea path="productDescription" id="description" row="4"
									placeholder="write a description" class="from-control" />
								<sf:errors path="productDescription" cssClass="help-block"
									element="em" />
							</div>
						</div>

						<div class="from-group">
							<label class="control-label col-md-4" for="image">Enter
								Image:</label>
							<div class="col-md-8">
								<sf:input type="file" path="productImage" id="image"
									placeholder="Image" class="from-control" />
								<sf:errors path="productImage" cssClass="help-block"
									element="em" />
							</div>
						</div>

						<div class="from-group">
							<label class="control-label col-md-4" for="price">Enter
								Price:</label>
							<div class="col-md-8">
								<sf:input type="text" path="price" id="price"
									placeholder="Price" class="from-control" />
								<sf:errors path="price" cssClass="help-block" element="em" />
							</div>
						</div>

						<div class="from-group">
							<label class="control-label col-md-4" for="inventory">Inventory:</label>
							<div class="col-md-8">
								<sf:input type="text" path="inventory" id="inventory"
									placeholder="Inventory" class="from-control" />
								<sf:errors path="inventory" cssClass="help-block" element="em" />
								<sf:input type="text" path="sold" id="sold" placeholder="sold"
									class="from-control" />
							</div>
						</div>

						<div class="from-group">
							<label class="control-label col-md-4" for="active">Status:</label>
							<div class="col-md-8">
								<select type="text" path="productActive" id="active"
									placeholder="active" class="from-control">
								</select>
								<sf:errors path="productActive" cssClass="help-block"
									element="em" />
							</div>
						</div>

						<div class="from-group">
							<label class="control-label col-md-4" for="category">Enter
								Category:</label>
							<div class="col-md-8">
								<sf:select path="categoryid" id="category" class="from-control"
									items="${categories}" itemLabel="name" itemValue="id" />
								<sf:errors path="categoryid" cssClass="help-block" element="em" />
							</div>
						</div>

						<div class="from-group">
							<label class="control-label col-md-4" for="supplier">Enter
								Supplier:</label>
							<div class="col-md-8">
								<select type="text" path="productSupplier" id="supplier"
									placeholder="Supplier" class="from-control">
								</select>
								<sf:errors path="productSupplier" cssClass="help-block"
									element="em" />
							</div>
						</div>

						<div class="from-group">
							<div class="cold-md-offset-4 col-md-8">
								<input type="submit" name="submit" id="submit" value="Submit"
									class="btn btn-primary" />

								<sf:hidden path="productId" />
								<sf:hidden path="productCode" />
								<sf:hidden path="productView" />
							</div>
						</div>

					</sf:form>
				</div>
			</div>
		</div>
	</div>
</div>