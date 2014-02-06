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
/** Param: tableCellElement								**/
/** 	   symptomCondition								**/
/**														**/
/*********************************************************/
function displaySymptomIcon(tableCellElement, symptomCondition) {
	var positiveIcon = "fa fa-check positive-indicator-icon ";	/* font awesome check/tick icon rendered green*/ 
	var negativeIcon = "fa fa-circle negative-indicator-icon ";  /* font awesome circle icon rendered red */
	
	if (symptomCondition === 'true') {
		$(tableCellElement).find("i").removeClass(negativeIcon).addClass(positiveIcon);
	}
	else if (symptomCondition === 'false') {
		$(tableCellElement).find("i").removeClass(positiveIcon).addClass(negativeIcon);
	}
}


/*********************************************************/
/**	Function: renderLookSymptoms						**/
/**														**/
/**	Desc: Responsible for rendering postive or negative **/
/**		  icons for the Look symptoms 					**/
/**														**/
/*********************************************************/
function renderLookSymptoms() {
	// obtain symptoms associated with patient visit
	// chest indrawing symptom
	var symptom = $('#chest-indrawing-symptom').val();
	var tableCellElement = $('#chest-indrawing-cell');
	displaySymptomIcon(tableCellElement, symptom);
	
	// breaths per minute symptom
	symptom = $('#breaths-per-minute-symptom').val();
	$('#breaths-per-minute-cell').text(symptom);

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
}

/*********************************************************/
/**	Function: renderAskLookGroupOneSymptoms				**/
/**														**/
/**	Desc: Responsible for rendering postive or negative **/
/**		  icons for the 'Ask Look' (Part 1) symptoms 	**/
/**														**/
/*********************************************************/
function renderAskLookGroupOneSymptoms() {
	// obtain symptoms associated with patient visit
	// child problems symptom
	var symptom = $('#child-problems-symptom').val();
	$('#child-problems-cell').text(symptom);
	
	// cough symptom
	symptom = $('#cough-symptom').val();
	var tableCellElement = $('#cough-cell');
	displaySymptomIcon(tableCellElement, symptom);

	// cough duration symptom
	var symptom = $('#cough-duration-symptom').val();
	$('#cough-duration-cell').text(symptom);;

	// diarrhoea symptom
	symptom = $('#diarrhoea-symptom').val();
	tableCellElement = $('#diarrhoea-cell');
	displaySymptomIcon(tableCellElement, symptom);
	
	// diarrhoea duration symptom
	var symptom = $('#diarrhoea-duration-symptom').val();
	$('#diarrhoea-duration-cell').text(symptom);
	
	// blood in stool symptom
	symptom = $('#blood-in-stool-symptom').val();
	tableCellElement = $('#blood-in-stool-cell');
	displaySymptomIcon(tableCellElement, symptom);

	// fever symptom
	symptom = $('#fever-symptom').val();
	tableCellElement = $('#fever-cell');
	displaySymptomIcon(tableCellElement, symptom);
	
	// fever duration symptom
	var symptom = $('#fever-duration-symptom').val();
	('#fever-duration-cell').text(symptom);

	// convulsions symptom
	symptom = $('#convulsions-symptom').val();
	tableCellElement = $('#convulsions-cell');
	displaySymptomIcon(tableCellElement, symptom);
}

/*********************************************************/
/**	Function: renderAskLookGroupTwoSymptoms				**/
/**														**/
/**	Desc: Responsible for rendering postive or negative **/
/**		  icons for the 'Ask Look' (Part 2) symptoms 	**/
/**														**/
/*********************************************************/
function renderAskLookGroupTwoSymptoms() {
	// obtain symptoms associated with patient visit
	// difficulty drinking symptom
	var symptom = $('#difficulty-drinking-symptom').val();
	var tableCellElement = $('#difficulty-drinking-cell');
	displaySymptomIcon(tableCellElement, symptom);
	
	// not able to drink symptom
	symptom = $('#not-able-to-drink-symptom').val();
	tableCellElement = $('#not-able-to-drink-cell');
	displaySymptomIcon(tableCellElement, symptom);

	// vomiting symptom
	var symptom = $('#vomiting-symptom').val();
	var tableCellElement = $('#vomiting-cell');
	displaySymptomIcon(tableCellElement, symptom);

	// vomits everything symptom
	symptom = $('#vomits-everything-symptom').val();
	tableCellElement = $('#vomits-everything-cell');
	displaySymptomIcon(tableCellElement, symptom);
	
	// red eye symptom
	var symptom = $('#red-eye-symptom').val();
	var tableCellElement = $('#red-eye-cell');
	displaySymptomIcon(tableCellElement, symptom);
	
	// red eye duration symptom
	symptom = $('#red-eye-duration-symptom').val();
	$('#red-eye-duration-cell').text(symptom);

	// difficulty seeing symptom
	symptom = $('#difficulty-seeing-symptom').val();
	tableCellElement = $('#difficulty-seeing-cell');
	displaySymptomIcon(tableCellElement, symptom);
	
	// difficulty seeing duration symptom
	var symptom = $('#difficulty-seeing-duration-symptom').val();
	$('#difficulty-seeing-duration-cell').text(symptom);

	// other problems symptom
	symptom = $('#other-problems-symptom').val();
	$('#other-problems-cell').text(symptom);
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
	/*			1. 'Ask-Look (Part 1) Symptoms table is populated	*/
	/*			2. 'Ask-Look (Part 2) Symptoms table is populated	*/
	/*			3. 'Look' Symptoms table is populated				*/
	
	$('#patient-visit-table tbody tr').click(function(event) {	
		renderLookSymptoms();
		renderAskLookGroupOneSymptoms();
		renderAskLookGroupTwoSymptoms();
	});	
	
	
	
	/* initialise the 'Patient Visits' table */
	$('#patient-visit-table').dataTable( {
		"bFilter": false,
		"bPaginate": false,
		"bInfo": true,
		"sScrollY": "150px",
		"bJQueryUI": true
	});

	/* initialise the 'Ask-Look Symptoms (Part 1)' table  */
	$('#ask-look-symptom-table-one').dataTable( {
		"bFilter": false,
		"bPaginate": false,
		"bInfo": true,
		"sScrollY": "48px",
		"bJQueryUI": true
	});
	
	/* initialise the 'Ask-Look Symptoms (Part 2)' table  */
	$('#ask-look-symptom-table-two').dataTable( {
		"bFilter": false,
		"bPaginate": false,
		"bInfo": true,
		"sScrollY": "48px",
		"bJQueryUI": true
	});
	
	/* initialise the 'Look Symptoms' table  */
	$('#look-symptom-table').dataTable( {
		"bFilter": false,
		"bPaginate": false,
		"bInfo": true,
		"sScrollY": "48px",
		"bJQueryUI": true
	});
	
});
 
