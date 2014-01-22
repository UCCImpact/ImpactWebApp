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
						<a class="btn btn-lg btn-primary" href="#" role="button"><i id="android-phone" class="fa fa-mobile"></i>  Download the App</a>
					</p>
				</div>
			</div>
		</div> <!-- end of active item -->
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
		<div class="item">
			<img data-src="holder.js/900x500/auto/#666:#6a6a6a/text:Second slide"
				alt="Second slide">
			<div class="container">
				<div class="carousel-caption">
					<h1>Another example headline.</h1>
					<p>Cras justo odio, dapibus ac facilisis in, egestas eget quam.
						Donec id elit non mi porta gravida at eget metus. Nullam id dolor
						id nibh ultricies vehicula ut id elit.</p>
					<p>
						<a class="btn btn-lg btn-primary" href="#" role="button">Learn
							more</a>
					</p>
				</div>
			</div>
		</div> <!-- end of item -->
		<div class="item">
			<img data-src="holder.js/900x500/auto/#555:#5a5a5a/text:Third slide"
				alt="Third slide">
			<div class="container">
				<div class="carousel-caption">
					<h1>One more for good measure.</h1>
					<p>Cras justo odio, dapibus ac facilisis in, egestas eget quam.
						Donec id elit non mi porta gravida at eget metus. Nullam id dolor
						id nibh ultricies vehicula ut id elit.</p>
					<p>
						<a class="btn btn-lg btn-primary" href="#" role="button">Browse
							gallery</a>
					</p>
				</div>
			</div>
		</div> <!-- end of item -->
	</div> <!-- end of carousel inner --> 
	
	<a class="left carousel-control" href="#myCarousel" data-slide="prev"><span
		class="glyphicon glyphicon-chevron-left"></span></a> <a
		class="right carousel-control" href="#myCarousel" data-slide="next"><span
		class="glyphicon glyphicon-chevron-right"></span></a>
</div> <!-- end of carousel slide -->



<!-- Marketing messaging and featurettes
    ================================================== -->
<!-- Wrap the rest of the page in another container to center all the content. -->

<div class="container marketing">

	<!-- Three columns of text below the carousel -->
	<div class="row">
		<div class="col-lg-4">
			<span class="glyphicon glyphicon-5x glyphicon-star"></span> 
			<h2>Heading</h2>
			<p>Donec sed odio dui. Etiam porta sem malesuada magna mollis
				euismod. Nullam id dolor id nibh ultricies vehicula ut id elit.
				Morbi leo risus, porta ac consectetur ac, vestibulum at eros.
				Praesent commodo cursus magna.</p>
			<p>
				<a class="btn btn-default" href="#" role="button">View details
					&raquo;</a>
			</p>
		</div>
		<!-- /.col-lg-4 -->
		<div class="col-lg-4">
			<img class="img-circle" data-src="holder.js/140x140"
				alt="Generic placeholder image">
			<h2>Heading</h2>
			<p>Duis mollis, est non commodo luctus, nisi erat porttitor
				ligula, eget lacinia odio sem nec elit. Cras mattis consectetur
				purus sit amet fermentum. Fusce dapibus, tellus ac cursus commodo,
				tortor mauris condimentum nibh.</p>
			<p>
				<a class="btn btn-default" href="#" role="button">View details
					&raquo;</a>
			</p>
		</div>
		<!-- /.col-lg-4 -->
		<div class="col-lg-4">
			<img class="img-circle" data-src="holder.js/140x140"
				alt="Generic placeholder image">
			<h2>Heading</h2>
			<p>Donec sed odio dui. Cras justo odio, dapibus ac facilisis in,
				egestas eget quam. Vestibulum id ligula porta felis euismod semper.
				Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum
				nibh, ut fermentum massa justo sit amet risus.</p>
			<p>
				<a class="btn btn-default" href="#" role="button">View details
					&raquo;</a>
			</p>
		</div>
		<!-- /.col-lg-4 -->
	</div>
	<!-- /.row -->


	<!-- START THE FEATURETTES -->

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
