// Toggle Function
$('.toggle').click(function(){
  // Switches the Icon
  $(this).children('i').toggleClass('fa-pencil');
  // Switches the forms  
  $('.form').animate({
    height: "toggle",
    'padding-top': 'toggle',
    'padding-bottom': 'toggle',
    opacity: "toggle"
  }, "slow");
});


$('.intercambio').click(function(){
	console.log('Switch Vista Login');
	console.log($(this).children('h3').text());
	
	if( $(this).children('h3').text() == 'Olvide mi Contraseña' ){
		 $(this).children('h3').html('Iniciar Sesión');
	}else{
		$(this).children('h3').html('Olvide mi Contraseña')
	}
	
	
	
  // Switches the forms  
  $('.form').animate({
    height: "toggle",
    'padding-top': 'toggle',
    'padding-bottom': 'toggle',
    opacity: "toggle"
  }, "slow");
});