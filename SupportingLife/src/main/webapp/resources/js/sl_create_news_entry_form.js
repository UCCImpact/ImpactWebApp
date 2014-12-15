/* **************************************************************************
 ** Filename: sl_create_news_entry_form.js
 ** 
 ** SL News Entry Creation Form
 **
 ** Author: Timothy O' Sullivan
 **
 ** Last Updated: 13/12/2014.
 ** *************************************************************************/


$(document).ready(function() {
	
	var todaysDate = new Date();
	todaysDate.setDate(todaysDate.getDate());

	if($('#newsEntryCreated').val() == "true") {
		$('#page-header-title').notify('News entry has been successfully recorded!', 
    			{className: 'success', style: 'bootstrap', autoHideDelay: 2000, showDuration: 500, elementPosition: 'top center'});
	}

	/* initialises jQuery UI datepicker functionality */
	/*												  */
	/* Note: Don't allow user to pick a future date	  */
	/*  	 beyond today							  */
	/*												  */
	$('.news-datepicker').datepicker({
		format: 'dd-mm-yyyy',
		endDate: '+0d'
	});
	$('.news-datepicker').datepicker('setDate', todaysDate);
	$('.news-datepicker').datepicker('update');
	
	$('#headline').focus();
	
	/* when reset button is clicked, perform the following: */
	/* 1. clear all checkboxes and unhighlight rows			*/
	/* 2. remove any validation messages					*/
	/*														*/
	$('#reset-button').click(function(){		
		var validator = jQuery('#news-entry-creation-form').validate();			/* remove any validation errors */ 
		validator.resetForm();
		
		/* need to explicitly set labels to valid to get them */
		/* back to black colour from red					  */
		$('.control-label').each(function(event) {
			$(this).removeClass('error').addClass('valid');	
		});
	});
});

/* 
 * Validation method using a regular expression to check image file extension
 * consists of correct syntax
 */
$.validator.addMethod("hasExtension", function(value, element) {
	var fileName = $(element).val();
	var extension = fileName.split('.').pop().toLowerCase();
	if ($.inArray(extension, ['jpg', 'jpeg', 'gif', 'png'])) {
		return false;
	}
	else {
		return true;
	}
});

/* Form Validation */
$(document).ready(function () {

	/* 
	 * add validation criteria to the news entry creation form
	 */
	$('#news-entry-creation-form').validate({
		rules: {
			"headline": {
				required: true,
				maxlength: 250
			},
			"entry": {
				required: true,
				maxlength: 1000
			},
			"newsDate": {
				required: true
			},
			"picture": {
				hasExtension: true
			}
		},
		messages: {
			"headline": {
				maxlength: "Maximum of 250 characters"
			},
			"entry": {
				maxlength: "Maximum of 1000 characters"
			},
			"picture": {
				hasExtension: "Only images of type jpg and png can be uploaded"
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
