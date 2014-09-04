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
/**	Function: displaySymptomText						**/
/**														**/
/**	Desc: Responsible for showing the textual output    **/
/**		  related to a patient symptom in either the    **/
/**		  the 'look' or the 'ask + look' symptom tables **/
/**														**/
/** Param: symptomCell									**/
/** 	   textToDisplay								**/
/**														**/
/*********************************************************/
function displaySymptomText(symptomCell, textToDisplay) {
	
	if (textToDisplay === '') {
		$(symptomCell).html('-');
	}
	else {
		$(symptomCell).text(textToDisplay);
	}
}



/*********************************************************/
/**	Function: renderLookSymptoms						**/
/**														**/
/**	Desc: Responsible for rendering postive or negative **/
/**		  icons for the Look symptoms 					**/
/**														**/
/** Param: patientVisitRow 	(row selected by user)		**/
/**														**/
/*********************************************************/
function renderLookSymptoms(patientVisitRow) {
	// obtain symptoms associated with patient visit
	// chest indrawing symptom
	var symptom = $(patientVisitRow).children().find('input.chest-indrawing-symptom').val();
	var tableCellElement = $('#chest-indrawing-cell');
	displaySymptomIcon(tableCellElement, symptom);
	
	// breaths per minute symptom
	symptom = $(patientVisitRow).children().find('input.breaths-per-minute-symptom').val();
	displaySymptomText($('#breaths-per-minute-cell'), symptom);

	// sleepy unconscious symptom
	symptom = $(patientVisitRow).children().find('input.sleepy-unconscious-symptom').val();
	tableCellElement = $('#sleepy-unconscious-cell');
	displaySymptomIcon(tableCellElement, symptom);
	
	// palmar pallor symptom
	symptom = $(patientVisitRow).children().find('input.palmar-pallor-symptom').val();
	tableCellElement = $('#palmar-pallor-cell');
	displaySymptomIcon(tableCellElement, symptom);

	// muac tape colour symptom
	symptom = $(patientVisitRow).children().find('input.muac-tape-colour-symptom').val();
	tableCellElement = $('#muac-tape-colour-cell');
	displaySymptomIcon(tableCellElement, symptom);

	// swelling feet symptom
	symptom = $(patientVisitRow).children().find('input.swelling-feet-symptom').val();
	tableCellElement = $('#swelling-feet-cell');
	displaySymptomIcon(tableCellElement, symptom);	
}

/*********************************************************/
/**	Function: renderAskLookGroupOneSymptoms				**/
/**														**/
/**	Desc: Responsible for rendering postive or negative **/
/**		  icons for the 'Ask Look' (Part 1) symptoms 	**/
/**														**/
/** Param: patientVisitRow 	(row selected by user)		**/
/**														**/
/*********************************************************/
function renderAskLookGroupOneSymptoms(patientVisitRow) {
	// obtain symptoms associated with patient visit
	// child problems symptom
	var symptom = $(patientVisitRow).children().find('input.child-problems-symptom').val();
	displaySymptomText($('#child-problems-cell'), symptom);
	
	// cough symptom
	symptom = $(patientVisitRow).children().find('input.cough-symptom').val();
	var tableCellElement = $('#cough-cell');
	displaySymptomIcon(tableCellElement, symptom);

	// cough duration symptom
	symptom = $(patientVisitRow).children().find('input.cough-duration-symptom').val();
	displaySymptomText($('#cough-duration-cell'), symptom);

	// diarrhoea symptom
	symptom = $(patientVisitRow).children().find('input.diarrhoea-symptom').val();
	tableCellElement = $('#diarrhoea-cell');
	displaySymptomIcon(tableCellElement, symptom);
	
	// diarrhoea duration symptom
	symptom = $(patientVisitRow).children().find('input.diarrhoea-duration-symptom').val();
	displaySymptomText($('#diarrhoea-duration-cell'), symptom);
	
	// blood in stool symptom
	symptom = $(patientVisitRow).children().find('input.blood-in-stool-symptom').val();
	tableCellElement = $('#blood-in-stool-cell');
	displaySymptomIcon(tableCellElement, symptom);

	// fever symptom
	symptom = $(patientVisitRow).children().find('input.fever-symptom').val();
	tableCellElement = $('#fever-cell');
	displaySymptomIcon(tableCellElement, symptom);
	
	// fever duration symptom
	symptom = $(patientVisitRow).children().find('input.fever-duration-symptom').val();
	displaySymptomText($('#fever-duration-cell'), symptom);

	// convulsions symptom
	symptom = $(patientVisitRow).children().find('input.convulsions-symptom').val();
	tableCellElement = $('#convulsions-cell');
	displaySymptomIcon(tableCellElement, symptom);
}

/*********************************************************/
/**	Function: renderAskLookGroupTwoSymptoms				**/
/**														**/
/**	Desc: Responsible for rendering postive or negative **/
/**		  icons for the 'Ask Look' (Part 2) symptoms 	**/
/**														**/
/** Param: patientVisitRow 	(row selected by user)		**/
/**														**/
/*********************************************************/
function renderAskLookGroupTwoSymptoms(patientVisitRow) {
	// obtain symptoms associated with patient visit
	// difficulty drinking symptom

	var symptom = $(patientVisitRow).children().find('input.difficulty-drinking-symptom').val();
	var tableCellElement = $('#difficulty-drinking-cell');
	displaySymptomIcon(tableCellElement, symptom);
	
	// not able to drink symptom
	symptom = $(patientVisitRow).children().find('input.not-able-to-drink-symptom').val();
	tableCellElement = $('#not-able-to-drink-cell');
	displaySymptomIcon(tableCellElement, symptom);

	// vomiting symptom
	symptom = $(patientVisitRow).children().find('input.vomiting-symptom').val();
	tableCellElement = $('#vomiting-cell');
	displaySymptomIcon(tableCellElement, symptom);

	// vomits everything symptom
	symptom = $(patientVisitRow).children().find('input.vomits-everything-symptom').val();
	tableCellElement = $('#vomits-everything-cell');
	displaySymptomIcon(tableCellElement, symptom);
	
	// red eye symptom
	symptom = $(patientVisitRow).children().find('input.red-eye-symptom').val();
	tableCellElement = $('#red-eye-cell');
	displaySymptomIcon(tableCellElement, symptom);
	
	// red eye duration symptom
	symptom = $(patientVisitRow).children().find('input.red-eye-duration-symptom').val();
	displaySymptomText($('#red-eye-duration-cell'), symptom);

	// difficulty seeing symptom
	symptom = $(patientVisitRow).children().find('input.difficulty-seeing-symptom').val();
	tableCellElement = $('#difficulty-seeing-cell');
	displaySymptomIcon(tableCellElement, symptom);
	
	// difficulty seeing duration symptom
	symptom = $(patientVisitRow).children().find('input.difficulty-seeing-duration-symptom').val();
	displaySymptomText($('#difficulty-seeing-duration-cell'), symptom);

	// other problems symptom
	symptom = $(patientVisitRow).children().find('input.other-problems-symptom').val();
	displaySymptomText($('#other-problems-cell'), symptom);
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
			// need to firstly unhighlight all other rows
			$(this).closest('tr').siblings().removeClass('row_selected');
			// now highlight selected row
			$(this).addClass('row_selected');

			/* Now we need to use this row to ensure that the:			*/
			/*		1. 'Ask-Look (Part 1) Symptoms table is populated	*/
			/*		2. 'Ask-Look (Part 2) Symptoms table is populated	*/
			/*		3. 'Look' Symptoms table is populated				*/
			renderLookSymptoms($(this));
			renderAskLookGroupOneSymptoms($(this));
			renderAskLookGroupTwoSymptoms($(this));		
		}
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
	
		
	/* Responsible for highlighting the search query return text */
	$('#search-query-return-container').hover(
		function() 
		{
			$('#search-query-return-container a').children().css('color', '#077204'); /* SL Green */
		}, 
		function() {
			$('#search-query-return-container a').children().css('color', '#777'); /* Grey */
		}
	);
	
});
 
