$(function(){
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
	    $("#a_"+menu).addClass('active');
		break;
	}
})