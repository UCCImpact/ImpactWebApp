/* **************************************************************************
 ** Filename: sl_login.js
 ** 
 ** SL Login Form JS Functionality
 **
 ** Author: Timothy O' Sullivan
 **
 ** Last Updated: 18/11/2014.
 ** *************************************************************************/


$(document).ready(function() {
		
	$('#username').focus();
	
	// Enable Bootstrap checkbox styling
	$('.prettyCheckable').prettyCheckable();
	
	/* when reset button is clicked, perform the following: */
	/* 1. clear all checkboxes and unhighlight rows			*/
	/* 2. remove any validation messages					*/
	/*														*/
	$('#reset-button').click(function(){		
		var validator = jQuery('#login-form').validate();			/* remove any validation errors */ 
		validator.resetForm();
		
		/* need to explicitly set labels to valid to get them */
		/* back to black colour from red					  */
		$('.control-label').each(function(event) {
			$(this).removeClass('error').addClass('valid');	
		});
		
		/* remove error message from any previous login attempt */
		$('#login-error-message').empty();		
	});

});
 
/* Form Validation */
$(document).ready(function () {

	/* 
	 * add validation criteria to the login form
	 */

	/* 
	 * Validation method using a regular expression to check value consists
	 * only of letters and numbers
	 */
    $.validator.addMethod("lettersAndDigitsRegex", function(value, element) {
        return this.optional(element) || /^[a-z0-9]+$/i.test(value);
    });
	
	$('#login-form').validate({
		rules: {
			"j_username": {
				required: true,
				lettersAndDigitsRegex: true
			},
			"j_password": {
				required: true
			}
		},
		messages: {
			"j_username": {
				lettersAndDigitsRegex: "Username is composed of letters and numbers only"
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
		},
		errorPlacement: function(error, element) {
	    	error.insertAfter(element.parent("div"));
		}
	});
});