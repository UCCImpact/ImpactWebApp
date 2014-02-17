<%--  Include SL Header --%>
<%@include file="headers/sl_header.jspf"%>
<%--  Include 'sl_welcome' header --%>
<%@include file="headers/sl_welcome_header.jspf"%>

<%--  Include sl_header (i.e. main navigation bar) --%>
<jsp:include page="sl_top_level_navigation.jsp" />


<!-- =================================================== CAROUSEL ================================================ -->
<div id="myCarousel" class="carousel slide" data-ride="carousel">

	<div class="carousel-inner">
		<div class="item active">
			<img data-src="holder.js/900x500/auto/#077204:#7a7a7a/text: ">
			<div class="container">
				<div class="carousel-caption">		
					<h1>Supporting LIFE</h1>
					<p>
						Empowering Health Care Professionals in the remotest regions of Africa
					</p>
					<p>
						<a class="btn btn-lg btn-primary" href="#"><i id="android-phone-icon" class="fa fa-mobile"></i>  Download the App</a>
					</p>
				</div>
			</div>
		</div> <!-- end of active item -->
		<div class="item">
			<img data-src="holder.js/900x500/auto/#077204:#7a7a7a/text: ">
			<div class="container">
				<div class="carousel-caption">
					<h2>Electronic Patient Records</h2>
					<p>
						Patient Record Access <i class="fa fa-arrows-h"></i> Anywhere &amp; Anytime
					</p>
					<p>
						<a class="btn btn-lg btn-primary" href="#">Learn More</a>
					</p>
				</div>
			</div>
		</div> <!-- end of item -->
		<div class="item">
			<img data-src="holder.js/900x500/auto/#077204:#7a7a7a/text: ">
			<div class="container">
				<div class="carousel-caption">
					<h2>Disease Outbreak Surveillance</h2>
					<p>
						Real-Time Tracking of Disease Outbreaks
					</p>
					<p>
						<a class="btn btn-lg btn-primary" href="#">Launch Surveillance</a>
					</p>
				</div>
			</div>
		</div> <!-- end of item -->
	</div> <!-- end of carousel inner --> 
	
	<a class="left carousel-control" href="#myCarousel" data-slide="prev">
		<span class="glyphicon glyphicon-chevron-left"></span>
	</a> 
	<a class="right carousel-control" href="#myCarousel" data-slide="next">
		<span class="glyphicon glyphicon-chevron-right"></span>
	</a>
</div> <!-- end of carousel slide -->


<!-- ====================================== MARKETING MESSAGING  ======================================== -->
<!-- Wrap the rest of the page in another container to center all the content. -->

<div class="container marketing">

	<!-- Three columns of text below the carousel -->
	<div class="row">
		<div class="col-lg-4">
			<i id="medic-icon" class="fa fa-user-md"></i>
			<h3>Enhance Productivity</h3>
			<p class="lead">Improve productivity of medical professionals through reducing the administrative
			   overhead of performing patient assessments.</p>
		</div>
		<div class="col-lg-4">
			<i id="healthcare-icon" class="fa fa-plus-square"></i>
			<h3>Improve Diagnosis</h3>
			<p class="lead">Enhance the accuracy of diagnoses and health outcomes by utilising automated, rigorous 
			   and robust decision support systems.
			</p>
		</div>
		<div class="col-lg-4">
			<i id="globe-icon" class="fa fa-globe"></i>
			<h3>Increase Care Coordination</h3>
			<p class="lead">Decrease the fragmentation of care by integrating and organising patient health records
			   and providing immediate distribution to authorised care providers.
			</p>
		</div>
	</div>

<!-- =========================================== FEATURETTES ================================================= -->

	<hr class="featurette-divider">

	<div class="row featurette">
		<div class="col-md-7">
			<h2 class="featurette-heading">
				Knowledge Base &amp; Software Release Videos . <span class="text-muted">See for
					yourself.</span>
			</h2>
			<p class="lead">Donec ullamcorper nulla non metus auctor
				fringilla. Vestibulum id ligula porta felis euismod semper. Praesent
				commodo cursus magna, vel scelerisque nisl consectetur. Fusce
				dapibus, tellus ac cursus commodo.</p>
		</div>
		<div class="col-md-5">
			<div id="videoCarousel" class="carousel slide" data-ride="carousel">
				<div class="carousel-inner">
					<div class="item active">
						<div class="container">
							<div class="carousel-caption">		
								<h3>Initial Software Release</h3>
							</div>
						</div>
						<iframe height="200" frameborder="0" webkitAllowFullScreen mozallowfullscreen allowFullScreen src="//www.youtube.com/embed/G6TLIgKuB9I?feature=player_detailpage"></iframe>
					</div> <!-- end of active item -->
					<div class="item">
						<div class="container">
							<div class="carousel-caption">
								<h3>Second Software Release</h3>
							</div>
						</div>
						<iframe height="200" frameborder="0" webkitAllowFullScreen mozallowfullscreen allowFullScreen src="//www.youtube.com/embed/RZiRm17b-3c?feature=player_detailpage"></iframe>
					</div> <!-- end of item -->
				</div> <!-- end of carousel inner --> 
				<a class="left carousel-control" href="#videoCarousel" data-slide="prev">
					<span class="glyphicon glyphicon-chevron-left"></span>
				</a> 
				<a class="right carousel-control" href="#videoCarousel" data-slide="next">
					<span class="glyphicon glyphicon-chevron-right"></span>
				</a>
			</div> <!-- end of video carousel slide -->
		</div> <!-- end of col-md-5 -->
	</div>

	<hr class="featurette-divider">

	<div class="row featurette">
		<div class="col-md-5">
			<a href="https://github.com/timothyosullivan">
				<i id="github-icon" class="fa fa-github"></i>
				<br>
				<span class="text-muted">
					Follow us on GitHub!
				</span>
				
			</a>
		</div>
		<div class="col-md-7">
			<h1 class="featurette-heading">Join the Coding Adventure!</h1>
			<h3>
				<span class="text-muted">Technologies we love to use</span>
			</h3>
			<br>
			<p class="lead">
			Supporting LIFE is an entirely open source project which hopes to make a substantial difference in the remotest parts of Africa.  
			Supporting LIFE uses mobile and web-based architectural solutions. We develop in Java for android-based devices to create dynamic and robust 
			decision-making tools to assist medical professionals out in the field. 
			<br><br>
			We use RESTful web services to coordinate medical data flow to our web servers running on Amazon EC2 instances. Our middle-tier is constructed using 
			the Spring framework, JPA and Maven. The web-based front-end uses HTML 5.0, Bootstrap, JQuery, Ajax, with a little bit of CSS 3.0 animation thrown in
			for good measure. 
			<br><br>
			We're big fans of automated testing, and especially Jenkins, to ensure the logical sanity of  our android and middle-tier solutions!
			If any of the above sounds interesting, we're always excited in hearing from individuals who would like to help us out!.
			</p>
		</div>
	</div>

	<hr class="featurette-divider">

	<!-- /END THE FEATURETTES -->

</div>

<!--  Include 'sl_welcome' footer -->
<%@include file="footers/sl_welcome_footer.jspf"%>

<!--  Include SL footer -->
<%@include file="footers/sl_footer.jspf"%>
