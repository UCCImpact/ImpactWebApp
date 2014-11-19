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
var googlePlusApplicationId = '115509461222989389672';
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
	 * all child elements of documentary carousel on a hover event
	 */
	$('#documentaryCarousel').hover(
		function() 
		{
			$('#documentaryCarousel .carousel-inner').children().css('background-color', '#077204'); /* SL Green */
		}, 
		function() {
			$('#documentaryCarousel .carousel-inner').children().css('background-color', '#777'); /* Grey */
		}
	);
	
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
	
	// initialise 'facebook', 'google+' and 'twitter' updates
	configureMediaUpdates();	
	
	// add event handlers to social media follow icons
	configureMediaFollowIcons();
	
	// add event handler for handling person contact
	configurePersonContactHandler();
	
	// add event handler for handling newsletter contact
	configureNewsletterContactHandler();

	// newsletter validation
	configureNewsletterValidationRules();
	
	// contact form validation
	configureContactFormValidationRules();
	
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
						
			var popUpComment = '<div class="map-scroll-fix">' + '<img' 
								+ ' width=' + institution['logoWidth'] + ' src=' +  
								institution['logo'] + '/> <br> ' + '<strong>' + institution['name'] + '</strong>' + '</div>';
												
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
    	// forces google maps to recalculate width and height
    	infoWindow.setContent(infoWindow.getContent()); 
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
		event: "click",
		collapsible: true,
		active: false,
		icons: icons,
		heightStyle: "content"	// allows the accordion panels to keep their native height
	});
	
	$('.team-member-accordion').accordion({
		collapsible: true,
		active: false,
		icons: icons,
		heightStyle: "content"	// allows the accordion panels to keep their native height
	});
}

function configureMediaUpdates() {

	// configure facebook media feed
	(function(d, s, id) {
		  var js, fjs = d.getElementsByTagName(s)[0];
		  if (d.getElementById(id)) return;
		  js = d.createElement(s); js.id = id;
		  js.src = "//connect.facebook.net/en_GB/sdk.js#xfbml=1&version=v2.0";
		  fjs.parentNode.insertBefore(js, fjs);
		}(document, 'script', 'facebook-jssdk'));
	
	// configure google+ media updates
    var version = msIeVersion();
    
    if (version == 6) {
    	$('#google-plus-updates').html('not supported in IE6');
    }
	else if (version == 7) {
		$('#google-plus-updates').html('not supported in IE7');
	}
	else if (version == 8) {
		$('#google-plus-updates').html('not supported in IE8');
	}
	else
	{
		$('#google-plus-updates').kycoGooglePlusFeed2(googlePlusApplicationId);
	}
	
	// configure twitter media feed
	(function(d,s,id){
		var js,fjs=d.getElementsByTagName(s)[0],p=/^http:/.test(d.location)?'http':'https';
		if(!d.getElementById(id)){
			js=d.createElement(s);
			js.id=id;js.src=p+"://platform.twitter.com/widgets.js";
			fjs.parentNode.insertBefore(js,fjs);
		}
	}(document,"script","twitter-wjs"));
}

function configureMediaFollowIcons() {
	$('#facebook-follow-icon').hover(
			function() 
			{
				$('#facebook-follow-icon .fa-facebook').css('color', '#3B5998'); /* facebook - dark blue */
				$('#facebook-follow-icon .fa-circle').css('color', '#000000'); /* background circle - black */
			}, 
			function() {
				$('#facebook-follow-icon .fa-facebook').css('color', '#ffffff'); /* facebook - white */
				$('#facebook-follow-icon .fa-circle').css('color', '#5a5a5a'); /* background circle - gray */
			});
	
	$('#google-plus-follow-icon').hover(
			function() 
			{
				$('#google-plus-follow-icon .fa-google-plus').css('color', '#d34836'); /* google+ - red */
				$('#google-plus-follow-icon .fa-circle').css('color', '#000000'); /* background circle - black */
			}, 
			function() {
				$('#google-plus-follow-icon .fa-google-plus').css('color', '#ffffff'); /* google+ - white */
				$('#google-plus-follow-icon .fa-circle').css('color', '#5a5a5a'); /* background circle - gray */
			});
	
	$('#twitter-follow-icon').hover(
		function() 
		{
			$('#twitter-follow-icon .fa-twitter').css('color', '#00a0d1'); /* twitter - blue */
			$('#twitter-follow-icon .fa-circle').css('color', '#000000'); /* background circle - black */
		}, 
		function() {
			$('#twitter-follow-icon .fa-twitter').css('color', '#ffffff'); /* twitter - white */
			$('#twitter-follow-icon .fa-circle').css('color', '#5a5a5a'); /* background circle - gray */
		});
}

function configurePersonContactHandler() {
	
	$('#contact-us-button').click(function() {
		
		// validate user entered data
		var valid = $('#contact-us-details').valid();
		
		if (valid) {	
		    var person = {
		        name:$('#contactFullName').val(),
		        email:$('#contactEmail').val(),
		        phone:$('#contactPhoneNumber').val(),
		        comment:$('#contactComment').val()
		    }
		
		    $.ajax({
		        url: 'welcome/addPersonContact',
		        headers: { 
		            'Accept': 'application/json',
		            'Content-Type': 'application/json' 
		        },
		        type: 'post',
		        dataType: 'json',
		        data: JSON.stringify(person),
		        success: function (response) {
		        	resetForm($('#contact-us-details'));
		        	$('#contact-us-button').notify('Thank you for contacting us!', 
		        			{className: 'success', style: 'bootstrap', autoHideDelay: 2000, showDuration: 300, elementPosition: 'right-middle'});
		        },
		        error: function (xhr, ajaxOptions, thrownError) {
		        	$('#contact-us-button').notify('Contact request communication error', 
		        			{className: 'error', style: 'bootstrap', autoHideDelay: 2000, showDuration: 300, elementPosition: 'right-middle'});
		        }
		    });	    
		} /* end if */
	    return false;
	});
}

function configureNewsletterContactHandler() {
	
	$('#subscribe-button').click(function() {
		
		// validate user entered data
		var valid = $('#newsletter-details').valid();
		
		if (valid) {
		    var emailAddress = $('#newsletterEmailContact').val();
	
		    $.ajax({
		        url: 'welcome/addNewsletterContact',
		        headers: { 
		            'Accept': 'application/json',
		            'Content-Type': 'application/json' 
		        },
		        type: 'post',
		        dataType: 'json',
		        data: emailAddress,
		        success: function (response) {
		        	resetForm($('#newsletter-details'));
		        	$('#subscribe-button').notify('Subscription request successful!', 
		        			{className: 'success', style: 'bootstrap', autoHideDelay: 2000, showDuration: 300, elementPosition: 'right-middle'});
		        },
		        error: function (xhr, ajaxOptions, thrownError) {
		        	$('#subscribe-button').notify('Contact request communication error', 
		        			{className: 'error', style: 'bootstrap', autoHideDelay: 2000, showDuration: 300, elementPosition: 'right-middle'});
		        }
		    });
		} /* end if */
	    return false;
	});
}

function configureNewsletterValidationRules() {
	/* 
	 * Validation method using a regular expression to 
	 * check valid email address
	 */
    $.validator.addMethod("emailRegex", function(value, element) {
    	var re = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
        return this.optional(element) || re.test(value);
    });
	
	$('#newsletter-details').validate({
		rules: {
			'newsletterEmailContact': {
				required: true,
				maxlength: 80,
				emailRegex: true
			}
		},
		messages: {
			'newsletterEmailContact': {
				required: 'Please enter a valid email address',
				emailRegex: 'Invalid email address'
			}
		},
		unhighlight: function(element, errorClass, validClass) {
		    $(element).addClass('valid');
		    $(element).removeClass('error');
		},
		highlight: function (element) {
			$(element).removeClass('valid').addClass('error');
		},
		success: function (element) {
			element.addClass('valid');
		},
		errorPlacement: function(error, element) {
			error.insertAfter(element);
		}
	});
}

function configureContactFormValidationRules() {
	
	/* 
	 * Validation method using a regular expression to 
	 * check valid email address
	 */
    $.validator.addMethod("emailRegex", function(value, element) {
    	var re = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
        return this.optional(element) || re.test(value);
    });
	
	/* 
	 * Validation method using a regular expression to check value consists
	 * only of letters
	 */
    $.validator.addMethod("lettersRegex", function(value, element) {
        return this.optional(element) || /^[a-z]+$/i.test(value);
    });
    
	/* 
	 * Validation method using a regular expression to check value consists
	 * only of numbers
	 */
    $.validator.addMethod("numbersRegex", function(value, element) {
        return this.optional(element) || /^[0-9]+$/i.test(value);
    });
    
	$('#contact-us-details').validate({
		rules: {
			'contactFullName': {
				required: true,
				lettersRegex: true,
				maxlength: 80
			},
			'contactEmail': {
				required: true,
				emailRegex: true,
				maxlength: 80
			},
			'contactPhoneNumber': {
				required: false,
				numbersRegex: true,
				maxlength: 30
			},
			'contactComment': {
				required: true,
				maxlength: 800
			}
		},
		messages: {
			'contactFullName': {
				required: 'Please enter your name',
				lettersRegex: 'Name with letters only'
			},
			'contactEmail': {
				required: 'Please enter a valid email address',
				emailRegex: 'Invalid email address'
			},
			'contactPhoneNumber': {
				numbersRegex: 'Please enter number using digits'
			},
			'contactComment': {
				required: 'Please enter a comment'
			}
		},
		unhighlight: function(element, errorClass, validClass) {
		    $(element).addClass('valid');
		    $(element).removeClass('error');
		},
		highlight: function (element) {
			$(element).removeClass('valid').addClass('error');
		},
		success: function (element) {
			element.addClass('valid');
		},
		errorPlacement: function(error, element) {
			error.insertAfter(element);
		}
	});
}

/* utility method to reset input fields of a form */
function resetForm(formElement) {
	$(':input', formElement)
	.not(':button, :submit, :reset, :hidden')
	.val('')
	.removeAttr('checked')
	.removeAttr('selected');
}

