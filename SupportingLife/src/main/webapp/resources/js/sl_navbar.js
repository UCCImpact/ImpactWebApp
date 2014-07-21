/* **************************************************************************
 ** Filename: sl_navbar.js
 ** 
 ** Description: JS related to top-level navigation bar
 **
 ** Author: Timothy O'Sullivan
 **
 ** Last Updated: 21/07/2014.
 ** *************************************************************************/

/* NavBar 'Active' Display handling - Part 1 */
/* Fix for bug SL-138 - 'Home' header button remains active when the 'Reporting' drop down menu is active. */
$(function() {
	$('.navbar-nav .dropdown').click(function(event) {
		$(this).siblings().removeClass('active');
		$(this).addClass('active');
	});
});	

/* NavBar 'Active' Display handling - Part 2 */
$(document).ready(function () {
    // dealing with second level sub-menu e.g. 'CCM Custom Report' Navigation Bar Selection
	$('a[href="' + this.location.pathname + '"]').parent().parent().parent().siblings().removeClass('active');
    $('a[href="' + this.location.pathname + '"]').parent().parent().parent().addClass('active');
	
    // dealing with first level sub-menu e.g. currently we don't have any options fulfilling this criteria
	$('a[href="' + this.location.pathname + '"]').parent().parent().siblings().removeClass('active');
    $('a[href="' + this.location.pathname + '"]').parent().parent().addClass('active');
    
	// dealing with top-level menu e.g. 'Surveillance' Navigation Bar Selection
	$('a[href="' + this.location.pathname + '"]').parent().siblings().removeClass('active');
    $('a[href="' + this.location.pathname + '"]').parent().addClass('active');
});


/* NavBar ToolTip Handling */
$(function() {
	// tooltip content
	$('.unimplemented-feature').tooltip({
		title: 'Feature not yet implemented',
		trigger: 'hover',
		placement:'bottom'
	})	
});