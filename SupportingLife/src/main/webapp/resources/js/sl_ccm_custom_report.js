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
	$('.assessment-datepicker').datepicker({
		format: 'dd-mm-yyyy'
	});
	
});

