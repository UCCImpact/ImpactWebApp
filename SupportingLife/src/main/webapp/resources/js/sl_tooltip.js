/* **************************************************************************
 ** Filename: sl_tooltip.js
 ** 
 ** Description: Tooltip to highlight nav bar elements which do not currently
 **              have an associated feature.
 **
 ** Author: Tim O Sullivan / James Flynn
 **
 ** Last Updated: 24/02/2014.
 ** *************************************************************************/

$(function() {
	// tooltip content
	$('.unimplemented-feature').tooltip({
		title: 'Feature not yet implemented',
		trigger: 'hover',
		placement:'bottom'
	})	
});