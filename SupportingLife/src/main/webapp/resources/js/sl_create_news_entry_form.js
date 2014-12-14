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

	if($('#newsEntryCreated').val() == "true") {
		$('#page-header-title').notify('News entry has been successfully recorded!', 
    			{className: 'success', style: 'bootstrap', autoHideDelay: 2000, showDuration: 500, elementPosition: 'top center'});
	}
		
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

/* Form Validation */
$(document).ready(function () {

	/* 
	 * add validation criteria to the news entry creation form
	 */
	$('#news-entry-creation-form').validate({
		rules: {
			"headline": {
				required: true
			},
			"entry": {
				required: true
			}
		},
		messages: {
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
