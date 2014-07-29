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
var surveillanceMap = {map: null, bounds: null, markerCluster: null}

$(document).ready(function() {
	
	// initialize filtering on the classification checkbox drop-down
	$('#surveillance-classifications').multiselect().multiselectfilter();

	/* initialises jQuery UI datepicker functionality */
	/*												  */
	/* Note: Don't allow user to pick a future date	  */
	/*  	 beyond today							  */
	/*												  */
	$('.assessment-datepicker').datepicker({
		format: 'dd-mm-yyyy',
		endDate: '+0d'
	});
	
	// initialise map - using coordinate values of Lilongwe, Malawi
	var myLatLng = new google.maps.LatLng(-13.957, 33.7881);
	surveillanceMap.init('#surveillance-map', myLatLng, 4);

	$('#submit-button').click(function(e) {
		var classificationKeys = new Array();
		var startSurveillanceDate, endSurveillanceDate;
		// retrieve classifications selected	
		$('#surveillance-classifications > option:selected').each(function() {
			classificationKeys.push($(this).val());
		});
		
		// retrieve surveillance date range
		startSurveillanceDate = $('#surveillanceDateStart').val();
		endSurveillanceDate = $('#surveillanceDateEnd').val();
		
		// perform ajax call
		surveillanceMap.placeLocationMarkers('surveillance/getSurveillanceRecords', classificationKeys, startSurveillanceDate, endSurveillanceDate);
	});
});

/* initialises the google map with a given center and zoom level */
surveillanceMap.init = 
	function(selector, latLng, initialZoomLevel) {
		var mapOptions = {zoom:initialZoomLevel, center: latLng, mapTypeId: google.maps.MapTypeId.HYBRID, minZoom: 2, maxZoom: 18}		

		this.map = new google.maps.Map($(selector)[0], mapOptions);
		this.bounds = new google.maps.LatLngBounds();
	}

/* loads in coordinate data to place a series of location markers on the map */
surveillanceMap.placeLocationMarkers = 
	function(requestUrl, classificationKeys, startSurveillanceDate, endSurveillanceDate) {		
		var surveillanceRequestComms = {}
		surveillanceRequestComms['classificationKeys'] = classificationKeys;
		surveillanceRequestComms['startSurveillanceDate'] = startSurveillanceDate;
		surveillanceRequestComms['endSurveillanceDate'] = endSurveillanceDate;
	
		$.ajax( {
			url : requestUrl,
			type : 'post',
			contentType: 'application/json',
			data : JSON.stringify(surveillanceRequestComms),
			success : function(data) {
				var markers = [];
				$.each(data, function(idx, obj) {
					var patientId, assessmentDate, lat, lng;
			        $.each(obj, function(key, value) {
			        	if (key === 'patientId') {
			        		patientId = value;
			        	}
			        	else if (key === 'assessmentDate') {
			        		assessmentDate = value;
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
					markers.push(marker);

					// have tool-tip bubble appear on user click event
					var infoWindow = new google.maps.InfoWindow();
					var html='<strong>SL Patient ID: '+patientId+'</strong><br><strong>Assessment Date: '+assessmentDate+'</strong>';
					google.maps.event.addListener(marker, 'click', function() {
						infoWindow.setContent(html);
						infoWindow.open(surveillanceMap.map, marker);
					});
					
					// fit the map to the markers
					surveillanceMap.map.fitBounds(surveillanceMap.bounds);
				});
				// configure the MarkerClusterer feature on the map
				var markerClustererOptions = {gridSize: 25, maxZoom: 14};
				surveillanceMap.markerCluster = new MarkerClusterer(surveillanceMap.map, markers, markerClustererOptions);
			}
		});
	}

