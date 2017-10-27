$(function() {
	switch (menu) {
	
	case 'Manage Products':
		$("#manageProduct").addClass('active');
		$("#home").removeClass('active');
		break;
	case 'About Us':
		$("#about").addClass('active');
		$("#home").removeClass('active');
		break;
	case 'Contact Us':
		$("#contact").addClass('active');
		$("#home").removeClass('active');
		break;
	case 'All Product':
		$("#listOfProduct").addClass('active');
		$("#home").removeClass('active');
		break;
	default:
		$("#home").addClass('active');
		$("#a_" + menu).addClass('active');
		break;
	}

	// code for jquery datatable
	// create dataset
	var jsonURL = '';
	if (window.categoryId == '') {
		jsonURL = 'http://localhost:1188/onlineshopping/json/data/all/products';
	} else {
		jsonURL = 'http://localhost:1188/onlineshopping/json/data/category/'
				+ window.categoryId+'/products';
	}
	var $table = $("#listTable");
	// only executed if data is available
	if ($table.length) {
		$table.DataTable({
			lengthMenu : [ [ 3, 5, 10, -1 ],
					[ '3 Records', '5 Records', '10 Records', 'All' ] ],
			pageLength : 5,
			ajax : {
				url : jsonURL,
				dataSrc : ''
			},
			columns : [ {
                  data: 'code',
                  mRender: function(data,type,row){
                	  return '<img src="'+window.contextRoot+'/resources/images/'+data+'.jpg" class="datatableimg"/>';
                  }
			},{
                  data: 'name' 
			}, { 
				data: 'brand'	
			} , {
				data: 'unit_price',	
				mRender: function(data,type,row){
					return '&#8377 '+data;
				}	
			}, {
				data: 'quantity',
				mRender: function(data,type,row){
					if(data<1){
						return '<span style="color:red;">Out Of Stock!</span>';
					}
					return data; 
				}
			}, {
				data: 'id',
				mRender: function(data,type,row){
					var str = '';
					var span1='<span class="glyphicon glyphicon-eye-open"></span>';
					var span2='<span class="glyphicon glyphicon-shopping-cart"></span>';
					str += '<a href="'+window.contextRoot+'/showby/'+data+'/product" class="btn btn-primary">'+span1+'</a>'+'&nbsp&nbsp';
				    //In row all data is available
					if(row.quantity < 1 ){
				    return str += '<a href="javascript:void(0)" class="btn btn-success disabled">'+span2+'</a>';	
				    }else{
					str += '<a href="'+window.contextRoot+'/cart/add/'+data+'/product" class="btn btn-success">'+span2+'</a>';
					return str;
				    }
				}
			}]
		});
	}
  //dismissing alert message
	var $alert = $('.alert');
	
	if($alert.length){
		setTimeOut(function(){
			$alert.fadeOut(slow);
		},6000);
	}
	
	//----------------selecting switch
	$('.switch input[type="checkbox"]').on('change',function(){
		var checkbox = $(this);
		var checked = checkbox.prop('checked');
		var dMsg = (checked)? 'You want to activate the Product?':'You want to deactivate the Product?';
		
		var value = checkbox.prop('value');
		
		bootbox.confirm({
			size:'medium',
			title:'product Activation & Deactivation',
			message:dMsg,
			callback: function(confirmed){
				if(confirmed){
					console.log(value);
					bootbox.alert({
						size:'medium',
						title:'Information',
						message:'You are going to perform action on product '+value
					});
				}else{
					checkbox.prop('checked',!checked);
				}
			}
		});
	});
	//
	//Data table for admin
	//
	
	var $adminProductTable = $("#adminProductTable");
	// only executed if data is available
	if ($adminProductTable.length) {
		var jsonURL = "http://localhost:1188/onlineshopping/json/data/admin/all/products";
		$adminProductTable.DataTable({
			lengthMenu : [ [ 10, 30, 50, -1 ],
					[ '10 Records', '30 Records', '50 Records', 'All' ] ],
			pageLength : 30,
			ajax : {
				url : jsonURL,
				dataSrc : ''
			},
			columns : [ 
			            {
			            	data: 'id'
			            }
			            ,{
                  data: 'code',
                  mRender: function(data,type,row){
                	  return '<img src="'+window.contextRoot+'/resources/images/'+data+'.jpg" class="adminProductTableImg"/>';
                  }
			},{
                  data: 'name' 
			}, { 
				data: 'brand'	
			} ,
			{
				data: 'quantity',
				mRender: function(data,type,row){
					if(data<1){
						return '<span style="color:red;">Out Of Stock!</span>';
					}
					return data; 
				}
			},
			{
				data: 'unit_price',	
				mRender: function(data,type,row){
					return '&#8377 '+data;
				}	
			},  {
				data: 'is_active',
				bSortable:false,
				mRender:function(data,type,row){
					var str = '';
					
					str += '<label class="switch">';
					if(data){
                    str += '<input type="checkbox" checked="checked" value="'+row.id+'"/>';
					}else{
						str += '<input type="checkbox" value="'+row.id+'"/>';
					}
                    str += '<span class="slider round"></span></label>';
                   return str;
				}
			},
			  {
				data: 'id',
				bSortable:false,
				mRender:function(data,type,row){
			        var str = '';
			       str +=' <a href="${contextRoot}/manage/'+data+'/product" class="btn btn-warning">'
                    str +='<span class="glyphicon glyphicon-pencil"></span></a>'
                   return str;
				}
			  }],
			initComplete: function(){
				var api=this.api();
				api.$('.switch input[type="checkbox"]').on('change',function(){
					var checkbox = $(this);
					var checked = checkbox.prop('checked');
					var dMsg = (checked)? 'You want to activate the Product?':'You want to deactivate the Product?';
					
					var value = checkbox.prop('value');
					
					bootbox.confirm({
						size:'medium',
						title:'product Activation & Deactivation',
						message:dMsg,
						callback: function(confirmed){
							if(confirmed){
								console.log(value);
								var activationURL ='http://localhost:1188/onlineshopping/json/data/product/'+value+'/activation';
								$.post(activationURL,function(data){
									bootbox.alert({
										size:'medium',
										title:'Information',
										message:data
									});	
								});
								
							}else{
								checkbox.prop('checked',!checked);
							}
						}
					});
				});
			}
		});
	}
	///// categoryForm validator
	    var $categoryForm = $("#categoryForm");
	    if($categoryForm.length){
	    	$categoryForm.validate({
	    		rules :{
	    			name:{
	    				required: true,
	    				minlength: 2
	    			},
	    	        description:{
	    	        	required: true
	    	        }
	    		},
	    	 messages: {
	    		  name:{
	    			  required:"Please add the category Name!",
	    			  minlength:"The category name should not be less than 2 characters"
	    		  },
	    		  description:{
	    	        	required: "Please add the discription for Product!"
	    	        }
	    	 },
	    	errorElement:"em",
	    	errorplacement:function(error,element){
	    		//add error display class
	    		error.addClass('emclass');
	    		//add the error element after the input element
	    		error.insertAfter(element);
	    	}
	    	});
	    }
	/////
});