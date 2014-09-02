/* **************************************************************************
 ** Filename: sl_ccm_treatment_report.js
 ** 
 ** CCM Treatment Report JS Functionality
 **
 ** Author: Timothy O' Sullivan
 **
 ** Last Updated: 02/09/2014.
 ** *************************************************************************/


$(document).ready(function() {
		
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
		
		var validator = jQuery('#ccm-treatment-report-form').validate();			/* remove any validation errors */ 
		validator.resetForm();
		
		/* need to explicitly set labels to valid to get them */
		/* back to black colour from red					  */
		$('.control-label').each(function(event) {
			$(this).removeClass('error').addClass('valid');	
		});
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