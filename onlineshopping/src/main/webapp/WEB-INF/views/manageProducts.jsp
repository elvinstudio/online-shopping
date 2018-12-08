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
						action="${contextRoot}/manage/products" method="POST"
						enctype="multipart/form-data">


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
							<label class="control-label col-md-4" for="file">Select
								an Image:</label>
							<div class="col-md-8">
								<sf:input type="file" path="file" id="file" class="from-control" />
								<sf:errors path="file" cssClass="help-block" element="em" />
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

								<c:if test="${product.productId==0}">
									<div class="text-right">
										<br />
										<button type="button" data-toggle="modal"
											data-target="#myCategoryModal" class="btn btn-warning btn-sm">Add
											Category</button>
									</div>
								</c:if>
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
								<sf:hidden path="productImage" />
							</div>
						</div>

					</sf:form>
				</div>
			</div>
		</div>
	</div>

	<div class="modal fade" id="myCategoryModal" role="dialog"
		tabindex="-1">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span>&times;</span>
					</button>
					<h4 class="modal-title">Add New Category</h4>
				</div>
				<div class="modal-body">
					<sf:form id="categoryForm" modelAttribute="category"
						action="${contextRoot}/manage/category" method="POST"
						class="form-horizontal">
						<div class="form-group">
							<label class="control-label col-md-4">Category
								Name</label>
							<div class="col-md-8 validate">
								<sf:input type="text" path="name"
									class="form-control" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4">Category
								Description</label>
							<div class="col-md-8 validate">
								<sf:textarea rows="2" path="description"
									class="form-control" />
							</div>
						</div>

						<div class="form-group">

							<div class="col-md-offset-4 col-md-8">
								<input type="submit" value="Add Category"
									class="btn btn-primary">
							</div>
						</div>
					</sf:form>
				</div>
			</div>
		</div>

	</div>

	<div class="row">
		<div class="row">
			<div class="col-xs-12">
				<h3>Available Products</h3>
				<hr />
			</div>
			<br />
		</div>
	</div>
	<div class="row">
		<div class="col-xs-12">
			<div style="overflow: auto">

				<table id="adminProductTable"
					class="table table-striped table-bordered">
					<thead>
						<tr>
							<th>Id</th>
							<th>&#168;</th>
							<th>Name</th>
							<th>Brand</th>
							<th>Quantity</th>
							<th>Unit Price</th>
							<th>Active</th>
							<th>Edit</th>
						</tr>
					</thead>
					<tfoot>
						<tr>
							<th>Id</th>
							<th>&#168;</th>
							<th>Name</th>
							<th>Brand</th>
							<th>Quantity</th>
							<th>Unit Price</th>
							<th>Active</th>
							<th>Edit</th>
						</tr>
					</tfoot>
				</table>
			</div>
		</div>
	</div>
</div>

