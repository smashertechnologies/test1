$(document).ready(function(){
	
	$("#div_logo").slideDown("fast");
	$( "#menu" ).menu();
	$("div#home_div").fadeIn(1000);
	$('a.logout-window').hide();
	$("#loginmessage").hide();
	$("#registermessage").hide();
	$('a.register-window').click(function() {
		var registerBox = $(this).attr('href');
		$(registerBox).fadeIn(1000);
		//Set the center alignment padding + border
		var popMargTop = ($(registerBox).height() + 24) / 2; 
		var popMargLeft = ($(registerBox).width() + 24) / 2;
		$(registerBox).css({ 
			'margin-top' : -popMargTop,
			'margin-left' : -popMargLeft
		});
		
		// Add the mask to body
		$('body').append('<div id="mask"></div>');
		$("#newpassword").val('');
		$("#retypepassword").val('');
		$('#mask').fadeIn(1000);
	});
	
	function showDiv(divObjName){
		var divObj = $("div#home_div");
		if ( divObjName=="home_div")
			divObj = $("div#home_div");
		else if ( divObjName =="listing_div" )
			divObj = $("div#listing_div");
		else if (divObjName == "beauticians_div")
			divObj = $("div#beauticians_div");
		else if(divObjName == "experts_div")
			divObj = $("div#experts_div");
		else if (divObjName == "promo_div")
			divObj = $("div#promo_div");
		else if (divObjName == "contactus_div")
			divObj = $("div#contactus_div");
		else if (divObjName == "aboutus_div")
			divObj = $("div#aboutus_div");
		divObj.fadeIn(1000);
	}
	
	function hideAllMenus(){
		var divObj = $("div#home_div");divObj.fadeOut(100);
			divObj = $("div#listing_div");divObj.fadeOut(100);
			divObj = $("div#beauticians_div");divObj.fadeOut(100);
			divObj = $("div#experts_div");divObj.fadeOut(100);
			divObj = $("div#promo_div");divObj.fadeOut(100);
			divObj = $("div#contactus_div");divObj.fadeOut(100);
			divObj = $("div#aboutus_div");divObj.fadeOut(100);
		
		
	}
	
	$('a.menu').click(function(){
		
		$('a.menu span').each(function(){
			 $(this).removeClass("ui-menu-icon");
			 $(this).addClass("ui-menu-no-icon");
		});
		
		$(this).find('span').addClass('ui-menu-icon');
		/*$('div#content_div div').each(function(){
			 $(this).fadeOut(200);
		});*/
		hideAllMenus();
		
		
	});

	$("a#home").click(function(){
		var divObj = $("div#home_div");
		divObj.fadeIn("slow");
		$("div#searchresultdiv").hide();
	});
	
	$("a#listing").click(function(){
		//var divObj = $("div#listing_div");
		//divObj.fadeIn("slow");
		var divObj = $("div#home_div");
		divObj.fadeIn("slow");
		$("div#searchresultdiv").show();
		$("#searchsubmit").click();
	});
	
	$("a#beauticians").click(function(){
		var divObj = $("div#beauticians_div");
		divObj.fadeIn("slow");
	});
	
	$("a#experts").click(function(){
		var divObj = $("div#experts_div");
		divObj.fadeIn("slow");
	});
	
	$("a#promo").click(function(){
		var divObj = $("div#promo_div");
		divObj.fadeIn("slow");
	});

	$("a#contactus").click(function(){
		var divObj = $("div#contactus_div");
		divObj.fadeIn("slow");
	});
	
	$("a#aboutus").click(function(){
		var divObj = $("div#aboutus_div");
		divObj.fadeIn("slow");
	});

	$('a.login-window').click(function() {
		
		// Getting the variable's value from a link 
		var loginBox = $(this).attr('href');

		//Fade in the Popup and add close button
		
		$(loginBox).fadeIn(1000);
		
		//Set the center alignment padding + border
		var popMargTop = ($(loginBox).height() + 24) / 2; 
		var popMargLeft = ($(loginBox).width() + 24) / 2; 
		
		$(loginBox).css({ 
			'margin-top' : -popMargTop,
			'margin-left' : -popMargLeft
		});
		
		// Add the mask to body
		$('body').append('<div id="mask"></div>');
		$('#mask').fadeIn(1000);
		$("#password").val('');
		return false;
	});
	
	$('a.logout-window').click(function() {
		
		// Getting the variable's value from a link 
		var loginBox = $(this).attr('href');

		//Fade in the Popup and add close button
		
		$(loginBox).fadeIn(1000);
		
		//Set the center alignment padding + border
		var popMargTop = ($(loginBox).height() + 24) / 2; 
		var popMargLeft = ($(loginBox).width() + 24) / 2; 
		
		$(loginBox).css({ 
			'margin-top' : -popMargTop,
			'margin-left' : -popMargLeft
		});
		
		// Add the mask to body
		$('body').append('<div id="mask"></div>');
		$('#mask').fadeIn(1000);
		
		return false;
	});
	
	// When clicking on the button close or the mask layer the popup closed
	$('a.close, #mask').bind('click', function() { 
	  $('#mask , .login-popup').fadeOut(300 , function() {
		$('#mask').remove();  
	}); 
	return false;
	});
	
	// When clicking on the button close or the mask layer the popup closed
	$('a.registerclose, #mask').bind('click', function() { 
	  $('#mask , .register-popup').fadeOut(300 , function() {
		$('#mask').remove();  
	}); 
	  return false;
	});
	 $('a.logoutclose, #mask').bind('click', function() { 
		  $('#mask , .logout-popup').fadeOut(300 , function() {
			$('#mask').remove();  
		});   
	  
	  
	return false;
	});
	
	 $("#btnSignOut").click(function(){
			var params = $("#signin").serialize();
			$.ajax({
				type: "post",
				url: "logout.jsp",
				data: params,
				cache: false, 
				success: function(html)
				{
					$("#message").html("");
					$('#mask').remove();
					$("#login-box").hide();
					$("#logout-box").hide();
					$('a.login-window').show();
					$('a.register-window').show();
					$('a.logout-window').hide();
				}
				});
		});
	 
	 $("#btnSignOutCancel").click(function(){
		 $('#mask').remove();
		 $("#logout-box").hide();
	 });
	 
	
	$("#signin").validate({
		    
	        // Specify the validation rules
	        rules: {
		 		username: "required",
		 		password: {
	                required: true,
	                minlength: 5
	            }/*,
	            email: {
	                required: true,
	                email: true
	            },
	            password: {
	                required: true,
	                minlength: 5
	            },
	            agree: "required"*/
	        },
	        // Specify the validation error messages
	        messages: {
	        	username: "Username required",
	            password: {
	                required: "Password required",
	                minlength: "Must be at least 5 characters long"
	            }
	        }
	    });
	$("#register").validate({
	    
        // Specify the validation rules
        rules: {
			firstname: "required",
			lastname: "required",
			mobileno:{
				required:true,
				number: true,
				maxlength :10
			},
			newusername: "required",
			newpassword: {
                required: true,
                minlength: 5
            },
            retypepassword: {
                required: true,
                minlength: 5,
                equalTo :"#newpassword"
            },
            email: {
                required: true,
                email: true
            }
        },
        // Specify the validation error messages
        messages: {
        	firstname: "Firstname required",
        	lastname: "Lastname required",
        	mobileno: {
        		required: "Mobile no required",
        		number : "Only numbers allowed",
        		maxlength:"Maximum 10 digits allowed."
        	},
        	newusername  :"Username required",
        	newpassword: {
                required: "Password required",
                minlength: "Must be at least 5 characters long"
            },
            retypepassword: {
                required: "Password required",
                minlength: "Must be at least 5 characters long"
            },
            email: {
            	required :"Email required."
            }
            
        }
    });

	
	$("#btnSignIn").click(function(){
		var uName = $("#username").val();
		var params = $("#signin").serialize();
		if (!$("#signin").valid()) { // Not Valid
			return false;
    	}
		
		$.ajax({
			type: "post",
			url: "login.jsp",
			data: params,
			cache: false, 
			success: function(html)
			{
				var result = $.trim(html);
				if ("success" == result) {
					$("#message").html("Welcome," + uName);
					$('#mask').remove();
					$("#login-box").hide();
					$('a.login-window').hide();
					$('a.register-window').hide();
					$('a.logout-window').show();
				} else if ("fail" == result) {
					$("#loginmessage").show();
					$("#login-box").effect('shake',250);
					$("#loginmessage").fadeOut(5000);
					
				}
			}
			});
	});
	
	$("#btnRegister").click(function(){
		
		
		var uName = $("#newusername").val();
		var params = $("#register").serialize();
		if (!$("#register").valid()) { // Not Valid
			return false;
    	}
		var validData = true;
		
		$.ajax({
			type: "post",
			url: "exists.jsp",
			data: params,
			async: false,
			cache: false, 
			success: function(html) {
				var result = $.trim(html);
				if ( "true" == result) {
					$("#registermessage").html("Username or email already registered.");
					$("#registermessage").show();
					$("#register-box").effect('shake',1500);
					validData=false;
				}
			}
			});
		if(!validData)
			return false;
		
		$.ajax({
			type: "post",
			url: "register.jsp",
			data: params,
			cache: false, 
			success: function(html)
			{
				var result = $.trim(html);
				if ("success" == result) {
					$("#message").html("Welcome, "+uName);
					$('#mask').remove();
					$("#login-box").hide();
					$("#register-box").hide();
					$('a.login-window').hide();
					$('a.register-window').hide();
					$('a.logout-window').show();
				} else if ("fail" == result) {
					
					$("#registermessage").html("Registration could not be completed.Please try again.");
					$("#registermessage").show();
					$("#register-box").effect('shake',250);
					$("#registermessage").fadeOut(5000);
					
				}
			}
			});
	});

	function split( val ) {
		return val.split( /,\s*/ );
	}
	
	function extractLast( term ) {
		return split( term ).pop();
	}
		
	$(function() {
		
		$( "#searchnamevalues" )
		// don't navigate away from the field on tab when selecting an item
		.bind( "keydown", function( event ) {
			if ( event.keyCode === $.ui.keyCode.TAB &&
					$( this ).data( "ui-autocomplete" ).menu.active ) {
				event.preventDefault();
			}
			}).autocomplete({
				minLength: 3,
				source: function( request, response ) {
				// delegate back to autocomplete, but extract the last term
				//response( $.ui.autocomplete.filter(availableNames, extractLast( request.term ) ) );
				 $.getJSON('list.jsp?data=names',{q:request.term},function(result){
					 var names = $.map(result,function(item){return item.value;});
					 response( $.ui.autocomplete.filter(names, extractLast( request.term ) ) );
			        });
		}
			});
		});
	
	
	
			$(function() {
		
		$( "#searchservicevalues" )
		// don't navigate away from the field on tab when selecting an item
		.bind( "keydown", function( event ) {
			if ( event.keyCode === $.ui.keyCode.TAB &&
					$( this ).data( "ui-autocomplete" ).menu.active ) {
				event.preventDefault();
			}
			}).autocomplete({
				minLength: 3,
				source: function( request, response ) {
				// delegate back to autocomplete, but extract the last term
				//response( $.ui.autocomplete.filter(availableNames, extractLast( request.term ) ) );
				 $.getJSON('list.jsp?data=services',{q:request.term},function(result){
					 var services = $.map(result,function(item){return item.value;});
					 response( $.ui.autocomplete.filter(services, extractLast( request.term ) ) );
			        });
		},focus: function() {
		// prevent value inserted on focus
		return false;
		},
		select: function( event, ui ) {
			var terms = split( this.value );
			// remove the current input
			terms.pop();
			// add the selected item
			if($(this).val().indexOf(ui.item.value)==-1)
				terms.push( ui.item.value );
			else
				alert("Alreday added!");
			// add placeholder to get the comma-and-space at the end
			terms.push( "" );
			this.value = terms.join( ", " );
			return false;
			}
			});
		});
	
	$(function() {
		
		$( "#searchplacevalues" )
		// don't navigate away from the field on tab when selecting an item
		.bind( "keydown", function( event ) {
			if ( event.keyCode === $.ui.keyCode.TAB &&
					$( this ).data( "ui-autocomplete" ).menu.active ) {
				event.preventDefault();
			}
			}).autocomplete({
				minLength: 3,
				source: function( request, response ) {
				// delegate back to autocomplete, but extract the last term
				//response( $.ui.autocomplete.filter(availableNames, extractLast( request.term ) ) );
				 $.getJSON('list.jsp?data=places',{q:request.term},function(result){
					 var places = $.map(result,function(item){return item.value;});
					 response( $.ui.autocomplete.filter(places, extractLast( request.term ) ) );
			        });
		}
			});
		});
	
	function getData(e) {

		//$("div#searchdiv").fadeOut(200);
		//$("div#searchresultdiv").fadeIn(1000);
		 e.preventDefault();
	     var nameData = 'names='+ $("#searchnamevalues").val();
	     var serviceData = 'services='+ $("#searchservicevalues").val();
	     var locationData = 'places='+$("#searchplacevalues").val();
	     var value = nameData +"&"+serviceData+"&"+locationData;
	     //alert("Param List : " + value);
	     $.ajax({
	     url: "searchListings.jsp",
	     //type: "post",
	     data: value,
	     cache: false,
	     success: function(data) {
	    	$("div#searchresultdiv").html(data).slideDown('slow');
	     }
	     });
	     //$("div#searchdiv").fadeOut(200);
	     //$("div#searchresultdiv").fadeIn(1000);
	
	}
	$("#searchplacevalues").bind("blur",getData);
	$("#searchnamevalues").bind("blur",getData);
	$("#searchservicevalues").bind("blur",getData);
	$("#searchsubmit").bind("click",getData);
});