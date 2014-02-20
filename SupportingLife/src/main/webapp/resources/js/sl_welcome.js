/* **************************************************************************
 ** Filename: sl_welcome.js
 ** 
 ** Welcome Page JS Functionality
 **
 ** Author: Timothy O' Sullivan
 **
 ** Last Updated: 20/02/2014.
 ** *************************************************************************/


$(document).ready(function() {

	/* Responsible for highlighting the background colour of  
	 * all child elements of video carousel on a hover event
	 */
	$('#videoCarousel').hover(
		function() 
		{
			$('#videoCarousel .carousel-inner').children().css('background-color', '#077204'); /* SL Green */
		}, 
		function() {
			$('#videoCarousel .carousel-inner').children().css('background-color', '#777'); /* Grey */
		}
	);

});