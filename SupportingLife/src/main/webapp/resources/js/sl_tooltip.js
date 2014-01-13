/* **************************************************************************
 ** Filename: sl_tooltip.js
 ** 
 ** Description: This file uses the JQuery tooltip functionality to replace native
 **              tooltip functionality within our web pages. The primary rationale for 
 **              this is that it removes the time delay in displaying the tooltip on hover.
 **
 **				 Additionally, this file dicates the positioning of the tooltip.
 **
 ** Author: James Flynn
 **
 ** Last Updated: 09/01/2014.
 ** *************************************************************************/

$(function() {
	$( document ).tooltip({
		// Identifies the position of the tooltip in relation to the associated target element
		position: {
			// my = Define where the tooltip pointer originates from (in relation to the tooltip)
			my: "top center",
			// at = Define where tooltip pop-up box should be positioned in relation to the object hovered on.
			at: "bottom center-30",
		}
	});
});