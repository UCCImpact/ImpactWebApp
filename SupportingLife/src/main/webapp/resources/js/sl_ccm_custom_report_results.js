/* **************************************************************************
 ** Filename: sl_ccm_custom_report_results.js
 ** 
 ** CCM Custom Report Results JS Functionality
 **
 ** Author: Timothy O' Sullivan
 **
 ** Last Updated: 06/02/2014.
 ** *************************************************************************/


/*********************************************************/
/**	Function: displaySymptomIcon						**/
/**														**/
/**	Desc: Responsible for rendering postive or negative **/
/**		  icon for each patient symptom in either the   **/
/**		  the 'look' or the 'ask + look' symptom tables **/
/**														**/
/** Param: 
/*********************************************************/
function displaySymptomIcon(tableCellElement, symptomCondition) {
	var positiveIcon = "fa fa-check positive-indicator-icon ";	/* font awesome check/tick icon rendered green*/ 
	var negativeIcon = "fa fa-circle negative-indicator-icon ";  /* font awesome circle icon rendered red */
	
	if (symptomCondition === 'true') {
		$(tableCellElement).find("i").addClass(positiveIcon);
	}
	else {
		$(tableCellElement).find("i").addClass(negativeIcon);
	}
}

$(document).ready(function() {
	
	/**************************************/
	/**        TABLE HANDLING            **/
	/**************************************/
	
	/* Add a click handler to the rows of the 'Patient Visit Table' */
	$('#patient-visit-table tbody tr').click(function(event) {
		if ($(this).hasClass('row_selected')) {
			$(this).removeClass('row_selected');
			$(this).closest('tr').find('[type=checkbox]').prop('checked', false); /* toggle the checkbox on the row off */
		}
		else {
			$(this).addClass('row_selected');
			$(this).closest('tr').find('[type=checkbox]').prop('checked', true); /* toggle the checkbox on the row on */
		}
	});
	
	
	/**************************************/
	/**  POPULATING DEPENDENT TABLES     **/
	/**************************************/
	/* Add a click handler to the rows of the 'Patient Visit Table' */
	/* such that:													*/
	/*			1. Look Symptoms Table is populated					*/
	$('#patient-visit-table tbody tr').click(function(event) {	
		// obtain symptoms associated with patient visit
		// chest indrawing symptom
		var symptom = $('#chest-indrawing-symptom').val();
		var tableCellElement = $('#chest-indrawing-cell');
		displaySymptomIcon(tableCellElement, symptom);
		
		// breaths per minute symptom
		symptom = $('#breaths-per-minute-symptom').val();
		tableCellElement = $('#breaths-per-minute-cell');
		tableCellElement.append(symptom);

		// sleepy unconscious symptom
		symptom = $('#sleepy-unconscious-symptom').val();
		tableCellElement = $('#sleepy-unconscious-cell');
		displaySymptomIcon(tableCellElement, symptom);
		
		// palmar pallor symptom
		symptom = $('#palmar-pallor-symptom').val();
		tableCellElement = $('#palmar-pallor-cell');
		displaySymptomIcon(tableCellElement, symptom);

		// muac tape colour symptom
		symptom = $('#muac-tape-colour-symptom').val();
		tableCellElement = $('#muac-tape-colour-cell');
		displaySymptomIcon(tableCellElement, symptom);

		// swelling feet symptom
		symptom = $('#swelling-feet-symptom').val();
		tableCellElement = $('#swelling-feet-cell');
		displaySymptomIcon(tableCellElement, symptom);
	});	
	
	
	
	/* initialise the 'Patient Visits' table */
	$('#patient-visit-table').dataTable( {
		"bFilter": false,
		"bPaginate": false,
		"bInfo": true,
		"sScrollY": "150px",
		"bJQueryUI": true
	});
	
	/* initialise the 'Look Symptoms' table  */
	$('#look-symptom-table').dataTable( {
		"bFilter": false,
		"bPaginate": false,
		"bInfo": true,
		"sScrollY": "50px",
		"bJQueryUI": true
	});
	
});
 
