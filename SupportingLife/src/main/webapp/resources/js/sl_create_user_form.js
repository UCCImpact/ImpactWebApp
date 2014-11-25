/* **************************************************************************
 ** Filename: sl_create_user_form.js
 ** 
 ** SL User Creation Form
 **
 ** Author: Timothy O' Sullivan
 **
 ** Last Updated: 20/11/2014.
 ** *************************************************************************/


$(document).ready(function() {

	if($('#userCreated').val() == "true") {
		$('#page-header-title').notify('User has been successfully created!', 
    			{className: 'success', style: 'bootstrap', autoHideDelay: 2000, showDuration: 500, elementPosition: 'top center'});
	}
	
	// Enable Bootstrap checkbox styling
	$('.prettyCheckable').prettyCheckable();
	// need to manually hack the labels on the checkboxes to display correctly
	$('#ccmRole').closest('div').find('label').html("CCM Role");
	$('#imciRole').closest('div').find('label').html("IMCI Role");
	$('#adminRole').closest('div').find('label').html("Admin Role");

	
	
	// hide user-id valid/invalid icons
	$('#valid-userid-icon').hide();
	$('#invalid-userid-icon').hide();
	
	$('#userId').focus();
	
	/* when reset button is clicked, perform the following: */
	/* 1. clear all checkboxes and unhighlight rows			*/
	/* 2. remove any validation messages					*/
	/*														*/
	$('#reset-button').click(function(){		
		var validator = jQuery('#user-creation-form').validate();			/* remove any validation errors */ 
		validator.resetForm();
		
		/* need to explicitly set labels to valid to get them */
		/* back to black colour from red					  */
		$('.control-label').each(function(event) {
			$(this).removeClass('error').addClass('valid');	
		});
	});
});

function username_check() {
	var username = $('#userId').val();
	var USER_ID_LENGTH = 8;
	
	if ((username.length < USER_ID_LENGTH) || (username.length > USER_ID_LENGTH)) {
		$('#userId').css('border', '3px #C33 solid');
		$('#valid-userid-icon').hide();
		$('#invalid-userid-icon').fadeIn();
		$('#userIdValid').val("false");
	}
	else {
		$.ajax({
			url: '../user/checkUserIdExistence',
	        headers: { 
	            'Accept': 'application/json',
	            'Content-Type': 'application/json' 
	        },
	        type: 'post',
	        dataType: 'json',
			data: username,
			success: function(response) {
				if(response == true) {
					$('#userId').css('border', '3px #C33 solid');
					$('#valid-userid-icon').hide();
					$('#invalid-userid-icon').fadeIn();
					$('#userIdValid').val("false");
				}
				else {
					$('#userId').css('border', '3px #090 solid');
					$('#invalid-userid-icon').hide();
					$('#valid-userid-icon').fadeIn();
					$('#userIdValid').val("true");
				}
			}
		});
	}
	return Boolean($('#userIdValid').val());
};

/* Form Validation */
$(document).ready(function () {

	/* 
	 * add validation criteria to the user creation form
	 */
    $.validator.addMethod("lettersAndDigitsRegex", function(value, element) {
        return this.optional(element) || /^[a-z0-9]+$/i.test(value);
    });
    
    $.validator.addMethod("usernameExists", function(value, element) {
        return username_check();
    });
	
    $.validator.addMethod("lettersRegex", function(value, element) {
        return this.optional(element) || /^[a-z]+$/i.test(value);
    });
    
	$('#user-creation-form').validate({
		rules: {
			"userId": {
				required: true,
				minlength: 8,
				maxlength: 8,
				usernameExists: true,
				lettersAndDigitsRegex: true
			},
			"password": {
				required: true,
				minlength: 8,
				maxlength: 8
			},
			"firstName": {
				required: true,
				lettersRegex: true
			},
			"surname": {
				required: true,
				lettersRegex: true
			}
		},
		messages: {
			"userId": {
				lettersAndDigitsRegex: "User ID can be composed of letters and numbers only",
				minlength: "Please enter 8 characters for userId",
				maxlength: "Please enter 8 characters for userId",
				usernameExists: ""
			},
			"firstName": {
				lettersRegex: "First name can be composed of letters only"
			},
			"surname": {
				lettersRegex: "Surname can be composed of letters only"
			}
		},
		unhighlight: function(element, errorClass, validClass) {
		    $(element).removeClass('error').addClass('valid');
		    $(element).closest('.control-group').removeClass('error');
		},
		highlight: function (element) {
			$(element).closest('.control-group').removeClass('valid').addClass('error');
		},
		success: function (element) {
			element.addClass('valid').closest('.control-group').removeClass('error').addClass('valid');
		}
	});
});
