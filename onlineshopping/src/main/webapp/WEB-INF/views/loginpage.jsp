
<div class="content">

	<div class="container">

		<c:if test="${not empty message}">
			<div class="row">
				<div class="col-xs-12 col-md-offset-2 col-md-8">
					<div class="alert alert-danger fade in">${message}</div>
				</div>
			</div>
		</c:if>

		<c:if test="${not empty logout}">
			<div class="row">
				<div class="col-xs-12 col-md-offset-2 col-md-8">
					<div class="alert alert-success">${logout}</div>
				</div>
			</div>
		</c:if>

		<div class="row">

			<div class="col-md-offset-3 col-md-6">

				<div class="panel panel-primary">

					<div class="panel-heading">
						<h4>Login</h4>
					</div>

					<div class="panel-body">
						<form action="${contextRoot}/login" method="POST"
							class="form-horizontal" id="loginForm">
							<div class="form-group">
								<label for="username" class="col-md-4 control-label">Email:
								</label>
								<div class="col-md-8">
									<input type="text" name="username" id="username"
										class="form-control" />
								</div>
							</div>
							<div class="form-group">
								<label for="password" class="col-md-4 control-label">Password:
								</label>
								<div class="col-md-8">
									<input type="password" name="password" id="password"
										class="form-control" />
								</div>
							</div>
							<div class="form-group">
								<div class="col-md-offset-4 col-md-8">
									<input type="submit" value="Login" class="btn btn-primary" />
									<input type="hidden" name="${_csrf.parameterName}"
										value="${_csrf.token}" />
								</div>
							</div>
						</form>

					</div>
					<div class="panel-footer">
						<div class="text-right">
							New User - <a href="${contextRoot}/register">Register Here</a>
						</div>
					</div>

				</div>

			</div>

		</div>

	</div>
</div>