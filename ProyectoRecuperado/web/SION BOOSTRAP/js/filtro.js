$(document).ready(function(){
	//color alert todo
	$('.categoria .categoriaitem[category="all"]').addClass('categoriaitem-active');
	$('.categoriaitem').click(function(){
		var catProduct = $(this).attr('category');
		console.log(catProduct);


		//active en clase seleccionada
		$('.categoriaitem').removeClass('categoriaitem-active');
        $(this).addClass('categoriaitem-active');

        //ocultando productos
        $('.productoitem').hide();
        //ocultando productos
        $('.productoitem[category="'+catProduct+'"]').show();

    });
    $('.categoriaitem[category="all"]').click(function(){
    	$('.productoitem').show();
  });  	
});
 