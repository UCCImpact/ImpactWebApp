/* **************************************************************************
 ** Filename: sl_welcome.js
 ** 
 ** Welcome Page JS Functionality
 **
 ** Author: Timothy O' Sullivan
 **
 ** Last Updated: 20/02/2014.
 ** *************************************************************************/

/* map variable stores a reference to the Google Map object */
var myLatLng = new google.maps.LatLng(32.485701, 15.651460); // North Africa (Sudan) - used for centering team map
var teamMap = {map: null, bounds: null};
var markers = [];
var redMapIcon = {path: google.maps.SymbolPath.CIRCLE, scale: 5, fillColor: 'red', fillOpacity: 0.8, strokeWeight: 1};
var blueMapIcon = {path: google.maps.SymbolPath.CIRCLE, scale: 5, fillColor: 'blue', fillOpacity: 0.8, strokeWeight: 1};
var teamInstitutions = { 
			'UoW': 		{'name': 'University of Washington', 'accordionPos' : 1, 'logo' : 'images/partners/washington-university-logo.png', 'logoWidth' : '60px', 'longitude': -122.303574, 'latitude': 47.655519},
			'UCC': 		{'name': 'University College Cork', 'accordionPos' : 0, 'logo' : 'images/partners/university-college-cork-logo.png', 'logoWidth' : '60px', 'longitude': -8.492860, 'latitude': 51.892332},
			'Lund': 	{'name': 'Lund University', 'accordionPos' : 5, 'logo' : 'images/partners/lund-university-logo.png', 'logoWidth' : '60px', 'longitude': 13.203547, 'latitude': 55.712132},
			'Mal': 		{'name': 'Malawi Partners', 'accordionPos' : 3, 'logo' : 'images/partners/malawi-flag.png', 'logoWidth' : '60px', 'longitude': 33.995486, 'latitude': -11.421107},
			'Acc': 		{'name': '', 'accordionPos' : 4, 'logo' : 'images/partners/accelopment-logo.png', 'logoWidth' : '120px', 'longitude': 8.557988, 'latitude': 47.354077},
			'ICL': 		{'name': '', 'accordionPos' : 2, 'logo' : 'images/partners/imperial-college-london-logo.png', 'logoWidth' : '120px', 'longitude': -0.174845, 'latitude': 51.498993}};

$(document).ready(function() {
	
	// initialise map - using coordinate values of Lilongwe, Malawi
	teamMap.init('#team-map', myLatLng, 4);
	teamMap.placeLocationMarkers();
	
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
				
	// initialise 'team members' accordion
	configureTeamMembersAccordion();
	
});

/* initialises the google map with a given center and zoom level */
teamMap.init = function(selector, latLng, initialZoomLevel) {
	
	var mapStyle = [{'featureType': 'water', 'stylers': [{'color': '#021019'}]},
	                {'featureType': 'landscape', 'stylers': [{'color': '#074a04'}]},
	                {'featureType': 'administrative.country', 'elementType': 'geometry',
	            	  'stylers': [{'color': '#808080'}, {'gamma': 2.44}, {'lightness': -45}, {'saturation': -46}, {'weight': 0.9}, {'visibility': 'on'}]},
	                {'featureType': 'administrative.province', 'stylers': [{'visibility': 'off'}]},
	                {'featureType': 'administrative', 'elementType': 'labels.text.fill', 'stylers': [{'visibility': 'simplified'}, {'invert_lightness': true}]},
	                {'featureType': 'administrative.country', 'stylers': [{'lightness': -35}]}]
	
	var mapOptions = {zoom:initialZoomLevel, center: latLng, mapTypeId: google.maps.MapTypeId.ROADMAP, minZoom: 2, maxZoom: 14, styles: mapStyle}
	this.map = new google.maps.Map($(selector)[0], mapOptions);
	this.bounds = new google.maps.LatLngBounds();	
}

/* loads in consortium partner coordinate data to place a series of location markers on the map */
teamMap.placeLocationMarkers = function() {
		for (idx in teamInstitutions) {
			var institution = teamInstitutions[idx];
			
			// create a new LatLng point for the marker
			var point = new google.maps.LatLng(parseFloat(institution['latitude']), parseFloat(institution['longitude']));
	
			// extend the bounds to include the new location point
			teamMap.bounds.extend(point);
	
			// create a marker on the map at this location point
			var markerSize = 25;
				
			var marker = new google.maps.Marker({position: point,
											 	map: teamMap.map,
											 	icon: redMapIcon});
	
			// have tool-tip bubble appear on user click event
			var infoWindow = new google.maps.InfoWindow();
						
			var popUpComment = '<img height=100%' 
								+ ' width=' + institution['logoWidth'] + ' src=' +  
								institution['logo'] + '/> <br> ' + '<strong>' + institution['name'] + '</strong>';
									
			bindInfoWindow(marker, teamMap.map, infoWindow, popUpComment, institution['accordionPos']);
			
			// fit the map to the markers
			teamMap.map.fitBounds(teamMap.bounds);
		}
		teamMap.map.panTo(myLatLng);
	}

function bindInfoWindow(marker, map, infoWindow, html, accordionPos) { 
    
	google.maps.event.addListener(marker, 'mouseover', function() {
    	marker.setIcon(blueMapIcon);
    	infoWindow.setContent(html); 
    	infoWindow.open(map, marker); 
    });
    
    google.maps.event.addListener(marker, 'mouseout', function() {
    	marker.setIcon(redMapIcon);
    	infoWindow.close();
    }); 
    
    google.maps.event.addListener(marker, 'click', function() {
    	$(".partner-accordion").accordion({ active: accordionPos });
        $('html, body').animate({
            scrollTop: $(".partner-accordion").offset().top
        }, 2000);
    }); 
    
    
}

//initialise 'team members' accordion
function configureTeamMembersAccordion() {
	var icons = {header: "ui-icon-circle-arrow-e", activeHeader: "ui-icon-circle-arrow-s"};

	$('.partner-accordion').accordion({
//		event: "click hoverintent",
		collapsible: true,
		active: false,
		icons: icons,
		heightStyle: "content"	// allows the accordion panels to keep their native height
	});
	
	$('.team-member-accordion').accordion({
//		event: "click hoverintent",
		collapsible: true,
		active: false,
		icons: icons,
		heightStyle: "content"	// allows the accordion panels to keep their native height
	});
}
