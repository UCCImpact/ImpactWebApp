/* **************************************************************************
 ** Filename: sl_surveillance.js
 ** 
 ** SL Disease Surveillance JS Functionality
 **
 ** Author: Timothy O'Sullivan
 **
 ** Last Updated: 21/07/2014.
 ** *************************************************************************/
/* map variable stores a reference to the Google Map object */
/* bounds variable will store a bounding box that contains all location markers */
var surveillanceMap = {map: null, bounds: null}

$(document).ready(function() {
	
	// initialize filtering on the classification checkbox drop-down
	$('#surveillance-classifications').multiselect().multiselectfilter();

	// initialise map
	var myLatLng = new google.maps.LatLng(51.8926846, -8.490176);
	surveillanceMap.init('#surveillance-map', myLatLng, 4);
	
	$('#submit-button').click(function(e){
			surveillanceMap.placeLocationMarkers('surveillance/getSurveillanceRecords');
	});
});

/* initialises the google map with a given center and zoom level */
surveillanceMap.init = 
	function(selector, latLng, zoom) {
		var myOptions = {zoom:zoom, center: latLng, mapTypeId: google.maps.MapTypeId.ROADMAP}
		this.map = new google.maps.Map($(selector)[0], myOptions);
		this.bounds = new google.maps.LatLngBounds();
	}

/* loads in coordinate data to place a series of location markers on the map */
surveillanceMap.placeLocationMarkers = 
	function(url) {
		$.getJSON(url, function(xml) {						/* method parameters: 1) url to request 2) callback function to execute when request concludes */
			$.each(xml, function(idx, obj) {
				var name, lat, lng;
		        $.each(obj, function(key, value) {
		        	if (key === 'classificationName') {
		        		name = value;
		        	}
		        	else if (key === 'latitude') {
		        		lat = value;
		        	}
		        	else if (key === 'longitude') {
		        		lng = value;
		        	}
		        });
				// create a new LatLng point for the marker
				var point = new google.maps.LatLng(parseFloat(lat),parseFloat(lng));

				// extend the bounds to include the new location point
				surveillanceMap.bounds.extend(point);

				// create a marker on the map at this location point
				var marker = new google.maps.Marker({
					position: point,
					map: surveillanceMap.map
				});

				// have tool-tip bubble appear on user click event
				var infoWindow = new google.maps.InfoWindow();
				var html='<strong>'+name+'</strong>';
				google.maps.event.addListener(marker, 'click', function() {
					infoWindow.setContent(html);
					infoWindow.open(surveillanceMap.map, marker);
				});
				
				// fit the map to the markers
				surveillanceMap.map.fitBounds(surveillanceMap.bounds);
			});
		});
	}

