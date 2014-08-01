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
var surveillanceMap = {map: null, bounds: null, markerCluster: null};
var markers = [];

$(document).ready(function() {
	// initialize filtering on the classification checkbox drop-down
	$('#surveillance-classifications').multiselect().multiselectfilter();

	// initialise date/time surveillance options
	initialiseSurveillanceDateTime();
	
	// initialise map - using coordinate values of Lilongwe, Malawi
	var myLatLng = new google.maps.LatLng(-13.957, 33.7881);
	surveillanceMap.init('#surveillance-map', myLatLng, 4);

	$('#submit-button').click(function(e) {
		var classificationKeys = new Array();
		var startSurveillanceDate, endSurveillanceDate, startSurveillanceTime, endSurveillanceTime;
		var startSurveillance, endSurveillance;
		
		// retrieve classifications selected	
		$('#surveillance-classifications > option:selected').each(function() {
			classificationKeys.push($(this).val());
		});
		
		// retrieve start surveillance date/time
		startSurveillanceDate = $('#surveillanceDateStartTextInput').val();
		startSurveillanceTime = $('#surveillanceTimeStartTextInput').val();
		startSurveillance = new Date(startSurveillanceDate + ' ' + startSurveillanceTime + ':00');
		stSurveillance = startSurveillance.toISOString();
		
		// retrieve end surveillance date/time
		endSurveillanceDate =  $('#surveillanceDateEndTextInput').val();
		endSurveillanceTime = $('#surveillanceTimeEndTextInput').val();
		endSurveillance = new Date(endSurveillanceDate + ' ' + endSurveillanceTime + ':00');
		edSurveillance = endSurveillance.toISOString();
		
		// perform ajax call
		surveillanceMap.placeLocationMarkers('surveillance/getSurveillanceRecords', classificationKeys, stSurveillance, edSurveillance);
	});
});

function initialiseSurveillanceDateTime() {
	
	var todaysDate = new Date();
	var yesterdaysDate = new Date();
	yesterdaysDate.setDate(todaysDate.getDate() - 1);
	
	var weekOldDate = new Date();
	weekOldDate.setDate(todaysDate.getDate() - 7);
    
	/* initialises jQuery UI datepicker functionality */
	/*												  */
	/* initialises jQuery UI timepicker functionality */
	/*												  */
	/* Note: Don't allow user to pick a future date	  */
	/*  	 beyond today							  */
	/*												  */
	
	/* Surveillance Start Date */
	$('#surveillanceDateStart').datepicker({autoclose: true,
											format: 'yyyy-mm-dd',
											endDate: '+0d'});
	$('#surveillanceDateStart').datepicker('setDate', weekOldDate);
	$('#surveillanceDateStart').datepicker('update');
	$('#surveillanceDateStartTextInput').prop('disabled', true);
	
	/* Surveillance Start Time */
	$('#surveillanceTimeStartTextInput').timepicker({showSeconds: false,
        											 showMeridian: false});
	$('#surveillanceTimeStartTextInput').prop('readonly', 'readonly');
	
	/* Surveillance End Date */
	$('#surveillanceDateEnd').datepicker({autoclose: true,
										  format: 'yyyy-mm-dd',
										  endDate: '+0d'});
	$('#surveillanceDateEnd').datepicker('setDate', yesterdaysDate);
	$('#surveillanceDateEnd').datepicker('update');
	$('#surveillanceDateEndTextInput').prop('disabled', true);
	

	/* Surveillance End Time */
	$('#surveillanceTimeEndTextInput').timepicker({showSeconds: false,
        										   showMeridian: false});
	$('#surveillanceTimeEndTextInput').prop('readonly', 'readonly');
}

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
		var surveillanceRequestComms = {};
		surveillanceRequestComms['classificationKeys'] = classificationKeys;
		surveillanceRequestComms['startSurveillanceDate'] = startSurveillanceDate;
		surveillanceRequestComms['endSurveillanceDate'] = endSurveillanceDate;
			
		$.ajax( {
			url : requestUrl,
			type : 'post',
			contentType: 'application/json',
			data : JSON.stringify(surveillanceRequestComms),
			success : function(data) {
				clearOverlays();
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
				var markerClustererOptions = {gridSize: 10};
				surveillanceMap.markerCluster = new MarkerClusterer(surveillanceMap.map, markers, markerClustererOptions);
			}
		});
	}

function clearOverlays() {
	if (markers) {
		for (i in markers) {
			markers[i] = null;
		}
	}
	markers = [];

	// Clears all clusters and markers from the clusterer
	if (surveillanceMap.markerCluster) {
		surveillanceMap.markerCluster.clearMarkers();
	}
}