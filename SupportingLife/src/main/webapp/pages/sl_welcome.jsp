<!--  Include SL Header -->
<%@include file="headers/sl_header.jspf"%>
<!--  Include 'sl_welcome' header -->
<%@include file="headers/sl_welcome_header.jspf"%>

<!--  Include sl_header (i.e. main navigation bar) -->
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
						<a class="btn btn-lg btn-primary" href="#" role="button"><i id="android-phone-icon" class="fa fa-mobile"></i>  Download the App</a>
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
						<a class="btn btn-lg btn-primary" href="#" role="button">Learn More</a>
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
						<a class="btn btn-lg btn-primary" href="#" role="button">Launch Surveillance</a>
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
			<p>Improve productivity of medical professionals through reducing the administrative
			   overhead of performing patient assessments.</p>
		</div>
		<div class="col-lg-4">
			<i id="healthcare-icon" class="fa fa-plus-square"></i>
			<h3>Improve Diagnosis</h3>
			<p>Enhance the accuracy of diagnoses and health outcomes by utilising automated, rigorous 
			   and robust decision support systems.
			</p>
		</div>
		<div class="col-lg-4">
			<i id="globe-icon" class="fa fa-globe"></i>
			<h3>Increase Care Coordination</h3>
			<p>Decrease the fragmentation of care by integrating and organising patient health records
			   and providing immediate distribution to authorised care providers.
			</p>
		</div>
	</div>

<!-- =========================================== FEATURETTES ================================================= -->

	<hr class="featurette-divider">

	<div class="row featurette">
		<div class="col-md-7">
			<h2 class="featurette-heading">
				First featurette heading. <span class="text-muted">It'll blow
					your mind.</span>
			</h2>
			<p class="lead">Donec ullamcorper nulla non metus auctor
				fringilla. Vestibulum id ligula porta felis euismod semper. Praesent
				commodo cursus magna, vel scelerisque nisl consectetur. Fusce
				dapibus, tellus ac cursus commodo.</p>
		</div>
		<div class="col-md-5">
			<img class="featurette-image img-responsive"
				data-src="holder.js/500x500/auto" alt="Generic placeholder image">
		</div>
	</div>

	<hr class="featurette-divider">

	<div class="row featurette">
		<div class="col-md-5">
			<img class="featurette-image img-responsive"
				data-src="holder.js/500x500/auto" alt="Generic placeholder image">
		</div>
		<div class="col-md-7">
			<h2 class="featurette-heading">
				Oh yeah, it's that good. <span class="text-muted">See for
					yourself.</span>
			</h2>
			<p class="lead">Donec ullamcorper nulla non metus auctor
				fringilla. Vestibulum id ligula porta felis euismod semper. Praesent
				commodo cursus magna, vel scelerisque nisl consectetur. Fusce
				dapibus, tellus ac cursus commodo.</p>
		</div>
	</div>

	<hr class="featurette-divider">

	<div class="row featurette">
		<div class="col-md-7">
			<h2 class="featurette-heading">
				And lastly, this one. <span class="text-muted">Checkmate.</span>
			</h2>
			<p class="lead">Donec ullamcorper nulla non metus auctor
				fringilla. Vestibulum id ligula porta felis euismod semper. Praesent
				commodo cursus magna, vel scelerisque nisl consectetur. Fusce
				dapibus, tellus ac cursus commodo.</p>
		</div>
		<div class="col-md-5">
			<img class="featurette-image img-responsive"
				data-src="holder.js/500x500/auto" alt="Generic placeholder image">
		</div>
	</div>

	<hr class="featurette-divider">

	<!-- /END THE FEATURETTES -->

</div>
<!-- /.container -->

<!--  Include 'sl_welcome' footer -->
<%@include file="footers/sl_welcome_footer.jspf"%>

<!--  Include SL footer -->
<%@include file="footers/sl_footer.jspf"%>
