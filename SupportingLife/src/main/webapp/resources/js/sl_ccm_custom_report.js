/* **************************************************************************
 ** Filename: sl_ccm_custom_report.js
 ** 
 ** CCM Custom Report JS Functionality
 **
 ** Author: Timothy O' Sullivan
 **
 ** Last Updated: 23/01/2014.
 ** *************************************************************************/


$(document).ready(function() {

	/* initialises jQuery UI datepicker functionality */
	/*												  */
	/* Note: Don't allow user to pick a future date	  */
	/*  	 beyond today							  */
	/*												  */
	$('.assessment-datepicker').datepicker({
		format: 'dd-mm-yyyy',
		endDate: '+0d'
	});
		
	/* when reset button is clicked, perform the following: */
	/* 1. clear all checkboxes and unhighlight rows			*/
	/* 2. remove any validation messages					*/
	/*														*/
	$('#reset-button').click(function(){
		$('input[type=checkbox]').each(function () {					/* uncheck boxes */
			$(this).prop('checked', false);
		});
		
		$('.sl-table tbody tr').each(function(event) {					/* unhighlight rows */
			$(this).removeClass('row_selected');
		});
		
		var validator = jQuery('#ccm-report-form').validate();			/* remove any validation errors */ 
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
	 * add validation criteria to the CCM report
	 * form
	 * 
	 * Note: Spring tagged elements means that Spring will generate 
	 * 		 an id and an name for the element in the following case:
	 * 
	 * 		<form: type="text" path="nationalId" placeholder="Enter National Id"/>
	 * 				
	 * 		The following html would be generated:
	 * 
	 * 		<form:input id="nationalId" name="nationalId" 
	 * 				type="text"	path="nationalId" placeholder="Enter National Id"/>		
	 * 
	 */
	$('#ccm-report-form').validate({
		rules: {
			"nationalId": {
				required: true // this means the field cannot be left empty
			},
			"nationalHealthId": {
				required: false,
				digits: true
			},
			"hsaUserId": {
				required: false,
				minlength: 8,
				maxlength: 8
			}
		},
		messages: {
			"hsaUserId": {
				minlength: "HSA User ID is 8 characters"
			},
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


/* Table handling */
$(document).ready(function() {
	/* Add a click handler to the rows - this could be used as a callback */
	$(".sl-table tbody tr").click(function(event) {
		if ($(this).hasClass('row_selected')) {
			$(this).removeClass('row_selected');
			$(this).closest('tr').find('[type=checkbox]').prop('checked', false); /* toggle the checkbox on the row off */
		}
		else {
			$(this).addClass('row_selected');
			$(this).closest('tr').find('[type=checkbox]').prop('checked', true); /* toggle the checkbox on the row on */
		}
	});
	
	/* initialise the dataTable */
	oTable = $('.sl-table').dataTable( {
		"bFilter": false,
		"bPaginate": false,
		"sScrollY": "400px",
		"bJQueryUI": true
	});
});

/* Accordion Panel Handling */
$(document).ready(function() {

	/* show plus-icon when panel minimised */
	/* show minus-icon when panel maximised */
	$(".report-note-title").click(function() {
		$(this).find('i').toggleClass('fa-plus-square fa-minus-square');
    });

});