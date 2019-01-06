$(function() {
	switch (menu) {
	case 'Home':
		$('#home').addClass('active');
		break;
	case 'About Us':
		$('#about').addClass('active');
		break;
	case 'Contact':
		$('#contact').addClass('active');
		break;
	case 'All Products':
		$('#listProducts').addClass('active');
		break;
	case 'Manage Products':
		$('#manageProducts').addClass('active');
		break;
	default:
		if (menu == 'Home')
			break;
		$('#listProducts').addClass('active');
		$('#a_' + menu).addClass('active');
		break;
	}

	// var products = [ [ '1', 'ABC' ], [ '21', 'DEF' ], [ '13', 'GHI' ],
	// [ '04', 'JKL' ], [ '5', 'MNO' ], [ '76', 'PQS' ], [ '57', 'OPQ' ],
	// [ '8', 'RST' ] ];

	var $table = $('#productListTable');

	if ($table.length) {
		// console.log('Inside the table!');

		var jsonUrl = '';
		if (window.categoryId == '') {
			jsonUrl = window.contextRoot + '/json/data/all/products'
		} else {
			jsonUrl = window.contextRoot + '/json/data/category/'
					+ window.categoryId + '/products'
		}

		$table
				.DataTable({
					lengthMenu : [ [ 3, 5, 10, -1 ],
							[ '3 Records', '5 Records', '10 Records', 'All' ] ],
					pageLength : 5,
					dom : 'lfrt<ip>',
					ajax : {
						url : jsonUrl,
						dataSrc : ''
					},
					columns : [
							{
								data : 'productImage',
								bSortable : false,
								mRender : function(data, type, row) {
									return '<img src="' + data
											+ '" class="dataTableImg"/>'
								}
							},
							{
								data : 'productName'
							},
							{
								data : 'productBrand'
							},
							{
								data : 'price',
								mRender : function(data, type, row) {
									return '&#xFFE5; ' + data
								}
							},
							{
								data : 'remains',
								mRender : function(data, type, row) {
									if (data < 1) {
										return '<span style="color:red">Out of Stock!</span>'
									}
									return data
								}
							},
							{
								data : 'productId',
								bSortable : false,
								mRender : function(data, type, row) {
									var str = '';
									str += '<a href="'
											+ window.contextRoot
											+ '/show/'
											+ data
											+ '/product" class="btn btn-primary"><span class="glyphicon glyphicon-eye-open"/>View</a> &nbsp;';
									if (row.remains < 1) {
										str += '<a href="javascript:void(0)" class="btn btn-success"><span class="glyphicon glyphicon-shopping-cart disabled"/><strike>Add to cart</strike></a>';
									} else {
										str += '<a href="'
												+ window.contextRoot
												+ '/cart/add/'
												+ data
												+ '/product" class="btn btn-success"><span class="glyphicon glyphicon-shopping-cart"/>Add to cart</a>';

									}
									return str;
								}
							} ]
				});
	}

	var $alert = $('.alert');
	if ($alert.length) {
		setTimeout(function() {
			$alert.fadeOut('slow');
		}, 3000)
	}

	var $adminProductTable = $('#adminProductTable');

	if ($adminProductTable.length) {
		// console.log('Inside the table!');

		var jsonUrl = window.contextRoot + '/json/data/admin/all/products';

		$adminProductTable
				.DataTable({
					lengthMenu : [ [ 10, 30, 50, -1 ],
							[ '10 Records', '30 Records', '50 Records', 'All' ] ],
					pageLength : 30,
					dom : 'lfrt<ip>',
					ajax : {
						url : jsonUrl,
						dataSrc : ''
					},
					columns : [
							{
								data : 'productId'
							},
							{
								data : 'productImage',
								bSortable : false,
								mRender : function(data, type, row) {
									return '<img src="' + data
											+ '" class="dataTableImg"/>'
								}
							},
							{
								data : 'productName'
							},
							{
								data : 'productBrand'
							},
							{
								data : 'remains',
								mRender : function(data, type, row) {
									if (data < 1) {
										return '<span style="color:red">Out of Stock!</span>'
									}
									return data
								}
							},
							{
								data : 'price',
								mRender : function(data, type, row) {
									return '&#xFFE5; ' + data
								}
							},
							{
								data : 'productActive',
								bSortable : false,
								mRender : function(data, type, row) {
									var str = '';
									str += '<label class="switch">';
									if (data) {
										str += '<input type="checkbox" checked="checked" '
												+ 'value="'
												+ row.productId
												+ '" />';
									} else {
										str += '<input type="checkbox" '
												+ 'value="' + row.productId
												+ '" />';
									}

									return str
											+ '<div class="slider"></div> </label>';
								}
							},
							{
								data : 'productId',
								bSortable : false,
								mRender : function(data, type, row) {

									var str = '<a href="'
											+ window.contextRoot
											+ '/manage/'
											+ data
											+ '/product" class="btn btn-warning">'
											+ '<span class="glyphicon glyphicon-pencil"></span></a>';

									return str;

								}
							} ],
					initComplete : function() {
						var api = this.api();
						api
								.$('.switch input[type="checkbox"]')
								.on(
										'change',
										function() {

											var checkbox = $(this);
											var checked = checkbox
													.prop('checked');
											var dMsg = (checked) ? 'You want to activate the product?'
													: 'You want to deactivate the produt?';
											var value = checkbox.prop('value');

											bootbox
													.confirm({
														size : 'medium',
														title : 'Product Activation & Deactivation',
														message : dMsg,
														callback : function(
																confirmed) {
															if (confirmed) {
																console
																		.log(value);

																var activationUrl = window.contextRoot
																		+ '/manage/product/'
																		+ value
																		+ '/activation';
																$
																		.post(
																				activationUrl,
																				function(
																						data) {
																					bootbox
																							.alert({
																								size : 'medium',
																								title : 'Information',
																								message : data
																							});
																				});

															} else {
																checkbox
																		.prop(
																				"checked",
																				!checked);
															}
														}
													});
										});
					}
				});
	}
});

function errorPlacement(error, element) {
	// Add the 'help-block' class to the error element
	error.addClass("help-block");

	// add the error label after the input element
	error.insertAfter(element);

	// add the has-feedback class to the
	// parent div.validate in order to add icons to inputs
	element.parents(".validate").addClass("has-feedback");

}

// validating the product form element
// fetch the form element
$categoryForm = $('#categoryForm');

if ($categoryForm.length) {

	$categoryForm.validate({
		rules : {
			name : {
				required : true,
				minlength : 3
			},
			description : {
				required : true,
				minlength : 3
			}
		},
		messages : {
			name : {
				required : 'Please enter product name!',
				minlength : 'Please enter atleast five characters'
			},
			description : {
				required : 'Please enter product name!',
				minlength : 'Please enter atleast five characters'
			}
		},
		errorElement : "em",
		errorPlacement : function(error, element) {
			errorPlacement(error, element);
		}
	}

	);

}

/* validating the loginform */

// validating the product form element
// fetch the form element
$loginForm = $('#loginForm');

if ($loginForm.length) {

	$loginForm.validate({
		rules : {
			username : {
				required : true,
				email : true

			},
			password : {
				required : true
			}
		},
		messages : {
			username : {
				required : 'Please enter your email!',
				email : 'Please enter a valid email address!'
			},
			password : {
				required : 'Please enter your password!'
			}
		},
		errorElement : "em",
		errorPlacement : function(error, element) {
			// Add the 'help-block' class to the error element
			error.addClass("help-block");

			// add the error label after the input element
			error.insertAfter(element);
		}
	}

	);

}