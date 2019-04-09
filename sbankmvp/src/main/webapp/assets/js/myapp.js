$(function() {
	// solving the active menu problem
	switch(menu) {
	
		case 'About Us':
			$('#about').addClass('active');
			break;
			
		case 'Contact Us':
			$('#contact').addClass('active');
			break;
			
		case 'All Products':
			$('#listProducts').addClass('active');
			break;
			
		case 'All Propriets':
			$('#listPropriets').addClass('active');
			break;
			
		case 'Manage Products':
			$('#manageProducts').addClass('active');
			break;
			
		case 'Manage Propriets':
			$('#managePropriets').addClass('active');
			break;
			
		case 'User Cart':
			$('#userCart').addClass('active');
			break;
		default:	
			if(menu == "Home") break;
			$('#listProducts').addClass('active');
			$('#a_'+menu).addClass('active');
			break;		
	}

	// to tackle the csrf token
	var token = $('meta[name="_csrf"]').attr('content');
	var header = $('meta[name="_csrf_header"]').attr('content');
	
	if(token.length > 0 && header.length > 0) {		
		// set the token header for the ajax request
		$(document).ajaxSend(function(e, xhr, options) {			
			xhr.setRequestHeader(header,token);
			
		});				
	}
	
	
	// code for jquery dataTable

	
	
	
	// --------------------------------
	
	
	
	// --------------------------------
	// data table for admin
	//---------------------------------
	
	var $adminProductsTable = $('#adminProductsTable');
	// execute the below code only where we have this table
	if ($adminProductsTable.length) {
	    //console.log('Inside the table!');
	    var jsonUrl = window.contextRoot + '/json/data/admin/all/products';
	    $adminProductsTable.DataTable({

	        lengthMenu: [[10, 30, 50, -1], ['10 Records', '30 Records', '50 Records', 'ALL']],
	        pageLength: 30,
	        ajax: {
	            url: jsonUrl,
	            dataSrc: ''
	        },
	        columns: [
	            {
	                data: 'id'
	            },
	            {
	                data: 'code',
	                bSortable: false,
	                mRender: function (data, type, row) {
	                    return '<img src="' + window.contextRoot + '/resources/images/' + data + '.jpg" class="adminDataTableImg"/>';
	                }
	            },
	            {
	                data: 'name'
	            },
	            {
	                data: 'brand'
	            },
	            {
	                data: 'ano'
	            },
	            {
	                data: 'motor'
	            },
	            
	            {
	                data: 'quantity',
	                mRender: function (data, type, row) {
	                    if (data < 1) {
	                        return '<span style="color:red">Out of Stock!</span>';
	                    }
	                    return data;
	                }
	            },
	            {
	                data: 'unitPrice',
	                mRender: function (data, type, row) {
	                    return '&#8377; ' + data
	                }
	            },
	            {
	                data: 'active',
	                bSortable: false,
	                mRender: function (data, type, row) {
	                    var str = '';
	                    str += '<label class="switch">';
	                    if (data) {
	                        str += '<input type="checkbox" checked="checked" value="' + row.id + '" />';
	                    }
	                    else {
	                        str += '<input type="checkbox" value="' + row.id + '" />';
	                    }
	                    str += '<div class="slider"></div></label>';
	                    return str;
	                }
	            },
	            {
	                data: 'id',
	                bSortable: false,
	                mRender: function (data, type, row) {
	                    var str = '';
	                    str += '<a href="'+window.contextRoot+'/manage/' + data + '/product" class="btn btn-warning">';
	                    str += '<span class="glyphicon glyphicon-pencil"></span></a>';
	                    return str;
	                }
	            }
	        ],
	        initComplete: function () {
	            var api = this.api();
	            api.$('.switch input[type="checkbox"]').on('change', function () {
	                var checkbox = $(this);
	                var checked = checkbox.prop('checked');
	                var dMsg = (checked) ? 'Quer activar o Carro?' :
	                    'Pretende desactivar o Carros?';
	                var value = checkbox.prop('value');
	                bootbox.confirm({
	                    size: 'medium',
	                    title: 'Activar e Desativar Carro',
	                    message: dMsg,
	                    callback: function (confirmed) {
	                        if (confirmed) {
	                            console.log(value);	                            
	                            var activationUrl = window.contextRoot + '/manage/product/' + value + '/activation';	                            
	                            $.post(activationUrl, function(data) {
		                            bootbox.alert({
		                                size: 'medium',
		                                title: 'Informacao',
		                                message: data
		                            });	                            	
	                            });
	                            
	                        }
	                        else {
	                            checkbox.prop('checked', !checked);
	                        }
	                    }
	                });
	            });
	        }
	    });
	}

	
	//--------------------------------
	// validation code for category
	
	var $categoryForm = $('#categoryForm');
	
	if($categoryForm.length) {
		
		$categoryForm.validate({
			
			rules : {
				
				name : {
					
					required: true,
					minlength: 2
					
				},
				
				description: {
					required: true
				}
				
			},
			
			messages : {
				
				name : {
					
					required: 'Adiciona o nome da categoria!',
					minlength: 'O nome de categoria deve ser maior que 2 caracter'
					
				},
				
				description: {
					
					required: 'Adiciona a descricao da Categoria!'
				}
				
				
			},
			errorElement: 'em',
			errorPlacement: function(error, element) {
				// add the class of help-block
				error.addClass('help-block');
				// add the error element after the input element
				error.insertAfter(element);				
			}
		});
		
		
	}
	
	
	//-----------------

	//--------------------------------
	// validation code for login
	
	var $loginForm = $('#loginForm');
	
	if($loginForm.length) {
		
		$loginForm.validate({
			
			rules : {
				
				username : {
					
					required: true,
					email: true
					
				},
				
				password: {
					required: true
				}
				
			},
			
			messages : {
				
				username : {
					
					required: 'Please enter the username!',
					email: 'Please enter valid email address!'
					
				},
				
				password: {
					
					required: 'Please enter the password!'
				}
				
				
			},
			errorElement: 'em',
			errorPlacement: function(error, element) {
				// add the class of help-block
				error.addClass('help-block');
				// add the error element after the input element
				error.insertAfter(element);				
			}
		});
		
		
	}
	
	
	//-----------------	
	// handling the click event of refresh cart button
	$('button[name="refreshCart"]').click(function() {
		
		// fetch the cart line id
		var cartLineId = $(this).attr('value');
		var countElement = $('#count_' + cartLineId);
		
		var originalCount = countElement.attr('value');
		var currentCount = countElement.val();
		
		// work only when the count has changed
		if(currentCount !== originalCount) {
			if(currentCount < 1 || currentCount > 3) {
				// reverting back to the original count
				// user has given value below 1 and above 3
				countElement.val(originalCount);
				bootbox.alert({
					size: 'medium',
					title: 'Error',
					message: 'Product count should be minimum 1 and maximum 3!'
				});
			}
			else {
				var updateUrl = window.contextRoot + '/cart/' + cartLineId + '/update?count=' + currentCount;
				// forward it to the controller
				window.location.href = updateUrl;
			}
		}
	});
	//-----------------
	
});