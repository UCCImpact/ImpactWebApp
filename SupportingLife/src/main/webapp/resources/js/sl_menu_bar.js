/* **************************************************************************
** Filename: sl_menu_bar.js
** 
** Description: This file provide general menu bar functionality
**
** Author: James Flynn
**
** Last Updated: 10/01/2014.
** *************************************************************************/

$(document).ready(function () {
	
/***************************************************************************
 * Associate a tooltip title with all features not currently implemented
 * These features are identified through a unique id
 ***************************************************************************/
$("#disabledRegisterUserFeature").attr("title", "Feature Not Yet Implemented");
$("#disabledAccountSettingsFeature").attr("title", "Feature Not Yet Implemented");
$("#disabledTrainingFeature").attr("title", "Feature Not Yet Implemented");
$("#disabledAboutFeature").attr("title", "Feature Not Yet Implemented");
$("#disabledLogOutFeature").attr("title", "Feature Not Yet Implemented");


/***************************************************************************
 * Provide functionality to allow the menu bar dropdown menus to slide down when 
 * hovered on, and to slide up when hovered out.
 ***************************************************************************/
	var secondLevelMenuBarShown = false;
	var thirdLevelMenuBarShown = false;
	
	/**** When the Top Level menu Bar is hovered ON, the Second Level Menu Bar fades in. *****/
    $("ul.topLevelMenuBar li").mouseenter(function () { // When the Top Level Menu Bar LI is hovered on...
        $("ul.secondLevelMenuBar", this).fadeIn(); // The children of the Second Level Menu Bar fade in.
        secondLevelMenuBarShown = true; // Set the secondLevelMenuBarShown indicator to true.
    });
    
    /**** When the Top Level menu Bar is hovered OFF, the Second Level Menu Bar slides up. *****/
    $("ul.topLevelMenuBar li").mouseleave(function () { // When the Top Level Menu Bar LI is hovered off...
    	if (secondLevelMenuBarShown == true) { // If the secondLevelMenuBarShown indicator is false, *************CHANGES: CHANGED TO TRUE, second level menu now fades on mouseleave.
    		$("ul.secondLevelMenuBar", this).fadeOut(); // The children of the Second Level Menu Bar fade out.
    	}
    });
    
    /**** When the Second Level menu Bar is hovered ON, the Third Level Menu Bar slides down.
	 **** When the Second Level menu Bar is hovered OFF, the Third Level Menu Bar slides up. *****/
    $("ul.secondLevelMenuBar li").mouseenter(function () { // When the Second Level Menu Bar LI is hovered on...
        $("ul.thirdLevelMenuBar", this).fadeIn(); // The children of the Third Level Menu Bar slide down.
        secondLevelMenuBarShown = true; //Set the secondLevelMenuBarShown indicator to true.
        thirdLevelMenuBarShown = true; //Set the thirdLevelMenuBarShown indicator to true.
    });

   
    /****  MORE HANDLING HERE - ADD COMMENT HERE *****/
    /**** When the Second Level menu Bar is hovered ON, the Third Level Menu Bar slides down.
	 **** When the Second Level menu Bar is hovered OFF, the Third Level Menu Bar slides up. *****/
    $("ul.thirdLevelMenuBar li").mouseleave(function () { // When the Second Level Menu Bar LI is hovered on...
        $("ul.thirdLevelMenuBar", this).fadeOut(); // The children of the Third Level Menu Bar slide down.
        secondLevelMenuBarShown = true; //Set the secondLevelMenuBarShown indicator to true.
        thirdLevelMenuBarShown = true; //Set the thirdLevelMenuBarShown indicator to true.
    });

    
    /**** If the Second Level Menu Bar List Item has a UL within it, then append a right-angled bracket. *****/
    $("ul.Second Level Menu Bar li:has(ul)").find("a:first").append(" &raquo; ");
});