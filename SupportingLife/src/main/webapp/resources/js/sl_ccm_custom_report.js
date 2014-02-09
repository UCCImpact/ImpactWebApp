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

	/* 
	 * Validation method using a regular expression to check value consists
	 * only of letters and numbers
	 */
    $.validator.addMethod("lettersAndDigitsRegex", function(value, element) {
        return this.optional(element) || /^[a-z0-9]+$/i.test(value);
    });
	
	$('#ccm-report-form').validate({
		rules: {
			"patientId": {
				required: false,
				digits: true
			},
			"nationalId": {
				required: false,
				lettersAndDigitsRegex: true
			},
			"nationalHealthId": {
				required: false,
				lettersAndDigitsRegex: true
			},
			"hsaUserId": {
				required: false,
				lettersAndDigitsRegex: true,
				minlength: 8,
				maxlength: 8
			}
		},
		messages: {
			"patientId": {
				digits: "SL Patient ID is composed of numbers only"
			},
			"nationalId": {
				lettersAndDigitsRegex: "National ID is composed of letters and numbers only"
			},
			"nationalHealthId": {
				lettersAndDigitsRegex: "National Health ID is composed of letters and numbers only"
			},
			"hsaUserId": {
				minlength: "HSA User ID is 8 characters",
				lettersAndDigitsRegex: "HSA User ID is composed of letters and numbers only"
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
		},
		errorPlacement: function(error, element) {
		    if (element.attr("name") == "hsaUserId") {
		    	error.insertAfter(element.parent("div"));
		    } 
		    else {
		        error.insertAfter(element);
		    }
		}
	});
});


/* Table handling */
$(document).ready(function() {
	/* Add a click handler to the rows - this could be used as a callback */
	$('.sl-table tbody tr').click(function(event) {
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
	$('.report-note-title').click(function() {
		$(this).find('i').toggleClass('fa-plus-square fa-minus-square');
    });
});


/* Patient Identifier Lookups (Using AJAX) */
$(document).ready(function() { 
    $('#nationalHealthId').autocomplete({
    	source : function(request, response) {
    		$.ajax( {
    			url : '../reports/getFilteredNationalHealthIds',
    			datatype : 'json',
    			data : {term : request.term},
    			success : function(data) {
    				response($.map(data.nationalHealthIds, function(item) {
    					return {
    						label : item,
    						value : item
    					}
    				}));
    			}
    		});
    	},
    	minLength : 1,
    	focus: function (event, ui) {
    		$(event.target).val(ui.item.label);
    		return false;
    	},
    	open : function() {
    		$(this).removeClass('ui-corner-all').addClass('ui-corner-top');
    	},
    	close : function() {
    		$(this).removeClass('ui-corner-top').addClass('ui-corner-all');
    	}
    });
});