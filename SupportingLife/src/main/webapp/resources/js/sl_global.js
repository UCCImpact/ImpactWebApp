/* **************************************************************************
 ** Filename: sl_global.js
 ** 
 ** Description: Global JS applied to all pages
 **
 ** Author: Timothy O'Sullivan
 **
 ** Last Updated: 19/08/2014.
 ** *************************************************************************/

function msIeVersion()
// Return Microsoft Internet Explorer (major) version number, or 0 for others.
// This function works by finding the 'MSIE' string and extracting the version number
// following the space, up to the semicolon
{
    var ua = window.navigator.userAgent;
    var msie = ua.indexOf('MSIE');
    
    if ( msie > 0 )        // is Microsoft Internet Explorer; return version number
        return parseFloat (ua.substring(msie+5, ua.indexOf (';', msie)));
    else
        return 0;    // is other browser
}