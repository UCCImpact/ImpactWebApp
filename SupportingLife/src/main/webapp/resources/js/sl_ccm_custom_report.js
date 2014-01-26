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

	/* initialise jQuery dataTable functionality */
	$('.sl-table').dataTable( {
		"bFilter": false,
		"bPaginate": false,
		"sScrollY": "400px"
	});

	/* initialises jQuery UI datepicker functionality */
	/*												  */
	/* Note: Don't allow user to pick a future date	  */
	/*  	 beyond today							  */
	/*												  */
	$('.assessment-datepicker').datepicker({
		format: 'dd-mm-yyyy',
		endDate: '+0d'
	});

});

/* Form Validation */
$(document).ready(function () {

	/* 
	 * add validation criteria to the CCM report
	 * form
	 */
	$('#ccm-report-form').validate({
		rules: {
			"national-id": {
				digits: true
			},
			"national-health-id": {
				digits: true
			},
			"hsa-user-id": {
				minlength: 8,
				maxlength: 8
			}
		},
		messages: {
			"hsa-user-id": {
				minlength: "HSA user id is 8 characters"
			},
		},
		highlight: function (element) {
			$(element).closest('.control-group').removeClass('success').addClass('error');
		},
		success: function (element) {
			element.addClass('valid')
			.closest('.control-group').removeClass('error').addClass('success');
		}
	});
});

