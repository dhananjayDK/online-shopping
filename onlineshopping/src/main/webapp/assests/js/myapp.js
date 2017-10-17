$(function() {
	switch (menu) {

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

})