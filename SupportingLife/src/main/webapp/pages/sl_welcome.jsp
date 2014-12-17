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
						Empowering Health Care Providers in the remotest regions of Africa
					</p>
					<p>
						<a class="btn btn-lg btn-primary" target="_blank"
								href="https://sourceforge.net/projects/supportinglife/files/SupportingLifeAndroid.apk/download">
							<i id="android-phone-icon" class="fa fa-mobile">
							</i>  Download the App
						</a>
					</p>
				</div>
			</div>
		</div> <!-- end of active item -->
		<div class="item">
			<img data-src="holder.js/900x500/auto/#077204:#7a7a7a/text: ">
			<div class="container">
				<div class="carousel-caption">
					<h2>Electronic Health Record</h2>
					<p>
						Health Record Access <i class="fa fa-arrows-h"></i> Anywhere &amp; Anytime
					</p>
					<p>
						<a class="btn btn-lg btn-primary unimplemented-feature" href="#">Learn More</a>
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
						Real-Time Tracking of Disease Outbreaks in rural districts of Africa
					</p>
					<p>
						<a class="btn btn-lg btn-primary unimplemented-feature" href="#">Launch Surveillance</a>
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
		<h1>What We Do</h1>
		<div class="col-lg-4">
			<i id="mobile-icon" class="fa fa-cogs"></i>
			<h3>Technological</h3>
			<p class="lead">Enhances user productivity, improves
							healthcare services and increases care
							coordination.</p>
		</div>
		<div class="col-lg-4">
			<i id="healthcare-icon" class="fa fa-plus-square"></i>
			<h3>Clinical Impact</h3>
			<p class="lead">Improves the accuracy of diagnoses, treatment and
				health outcomes by utilising automated, rigorous and robust decision
				support systems.</p>
		</div>
		<div class="col-lg-4">
			<i id="research-icon" class="fa fa-cubes"></i>
			<h3>Research</h3>
			<p class="lead">Investigates the impact of the technology from a user and
							community perspective.</p>
		</div>
	</div>

	<hr class="featurette-divider">
	
	<div class="row featurette">
		<h1>About Supporting LIFE</h1>
		<div class="col-md-5">
			<div id="documentaryCarousel" class="carousel slide" data-interval="false" data-ride="carousel">
				<div class="carousel-inner">
					<div class="item active">
						<div>
							<div class="carousel-caption">
								<h3>Laying the Foundations</h3>
							</div>
							<iframe height="200" src="//www.youtube.com/embed/J7bSm2ARzs4"	allowfullscreen></iframe>
						</div>
					</div>	
				</div><!-- end of carousel inner -->
				
				<a class="left carousel-control" href="#documentaryCarousel" data-slide="prev">
					<span class="glyphicon glyphicon-chevron-left"></span>
				</a> 
				<a class="right carousel-control" href="#documentaryCarousel" data-slide="next">
					<span class="glyphicon glyphicon-chevron-right"></span>
				</a>
			</div> <!-- end of documentary carousel slide -->
		</div>	<!-- end of col-md-5 -->
		<div class="col-md-7">
			<h2>Documentary Videos</h2>
			<h3>
				<span class="text-muted">Follow our exciting journey</span>
			</h3>
			<br>
			<p class="lead">
				We're documenting each step of the Supporting LIFE project. 
				These documentaries are intended to capture and communicate the obstacles
				and successes of the  Supporting LIFE project.
				<br><br>
			</p>
			<p class="lead feature-text-centered">	
				Tune in and see the progress that we're making!
			</p>
		</div>
	</div>
		
	<!-- =========================================== FEATURETTES ================================================= -->

	<hr class="featurette-divider">

	<div class="row featurette">
		<h1>Technology</h1>
		<div class="col-md-7">
			<h2>Software Release Videos</h2>
			<h3>
				<span class="text-muted">See the tools we're delivering for
					yourself</span>
			</h3>
			<br>
			<p class="lead">
				Supporting LIFE is an entirely open source project which hopes to
				make a substantial difference in the remotest parts of Africa. <br>
				<br> We follow an agile scrum-based development methodology
				aiming to deliver frequent and regular software updates throughout
				the development lifecycle. Track our progress, as well as sneak
				previews!, by checking out our latest release videos.
			</p>
			<div class="col-md-12">
				<div class="col-md-6">
					<h3>
						<span class="text-muted">Scan QR code <br> for SL App</span>
					</h3>
					<div>
						<i class="fa fa-share qr-arrow-icon"></i>
						<img id="app-qr-code" src="images/app-download-qrcode.png" />
						<i class="fa fa-reply qr-arrow-icon"></i>
					</div>
				</div>
				<div class="col-md-6">
					<h3>
						<span class="text-muted">Scan QR code <br> for SL Reporting Web App</span>
					</h3>
					<div>
						<i class="fa fa-share qr-arrow-icon"></i>
						<img id="reporting-app-qr-code" src="images/reporting-app-download-qrcode.png" />
						<i class="fa fa-reply qr-arrow-icon"></i>
					</div>
				</div>
			</div>
		</div>
		<div class="col-md-5">
			<div id="videoCarousel" class="carousel slide" data-interval="false"
				data-ride="carousel">
				<div class="carousel-inner">
					<div class="item active">
						<div class="container">
							<div class="carousel-caption">
								<h3>Latest Software Release (SL 5.0)</h3>
							</div>
						</div>
						<iframe height="200" src="//www.youtube.com/embed/wbhDalQ5exc"
							allowfullscreen></iframe>
					</div>
					<!-- end of active item -->
					<div class="item">
						<div class="container">
							<div class="carousel-caption">
								<h3>Fourth Software Release (SL 4.0)</h3>
							</div>
						</div>
						<iframe height="200" src="//www.youtube.com/embed/nrNzS5hsFv4"
							allowfullscreen></iframe>
					</div>					
					<div class="item">
						<div class="container">
							<div class="carousel-caption">
								<h3>Third Software Release (SL 3.0)</h3>
							</div>
						</div>
						<iframe height="200" src="//www.youtube.com/embed/n4iDDow6pxc"
							allowfullscreen></iframe>
					</div>
					<!-- end of item -->
					<div class="item">
						<div class="container">
							<div class="carousel-caption">
								<h3>Health Record Data Management</h3>
							</div>
						</div>
						<iframe height="200" src="//www.youtube.com/embed/Q0ay6UMF0I4"
							allowfullscreen></iframe>
					</div>
					<!-- end of item -->
					<div class="item">
						<div class="container">
							<div class="carousel-caption">
								<h3>App Installation Guidelines (SL 3.0)</h3>
							</div>
						</div>
						<iframe height="200" src="//www.youtube.com/embed/GFRJ1mzw0mY"
							allowfullscreen></iframe>
					</div>
					<!-- end of item -->
					<div class="item">
						<div class="container">
							<div class="carousel-caption">
								<h3>Second Software Release (SL 2.0)</h3>
							</div>
						</div>
						<iframe height="200" src="//www.youtube.com/embed/l-ZCJyhlpX4"
							allowfullscreen></iframe>
					</div>
					<!-- end of item -->
					<div class="item">
						<div class="container">
							<div class="carousel-caption">
								<h3>Interim Software Release (SL 1.1)</h3>
							</div>
						</div>
						<iframe height="200" src="//www.youtube.com/embed/RZiRm17b-3c"
							allowfullscreen></iframe>
					</div>
					<!-- end of item -->
					<div class="item">
						<div class="container">
							<div class="carousel-caption">
								<h3>Initial Software Release (SL 1.0)</h3>
							</div>
						</div>
						<iframe height="200" src="//www.youtube.com/embed/G6TLIgKuB9I"
							allowfullscreen></iframe>
					</div>
					<!-- end of item -->
				</div>
				<!-- end of carousel inner -->
				<a class="left carousel-control" href="#videoCarousel"
					data-slide="prev"> <span
					class="glyphicon glyphicon-chevron-left"></span>
				</a> <a class="right carousel-control" href="#videoCarousel"
					data-slide="next"> <span
					class="glyphicon glyphicon-chevron-right"></span>
				</a>
			</div>
			<!-- end of video carousel slide -->
		</div>
		<!-- end of col-md-5 -->
	</div>

	<hr class="featurette-divider">

	<div class="row featurette">
		<div class="col-md-7">
			<h2>Join the Coding Adventure!</h2>
			<h3>
				<span class="text-muted">Technologies we love to use</span>
			</h3>
			<br>
			<p class="lead">
				Supporting LIFE uses mobile and web-based architectural solutions.
				We develop in Java for android-based devices to create dynamic and
				robust decision-making tools to assist medical professionals out in
				the field. <br>
				<br> We use RESTful web services to coordinate medical data
				flow to our web servers running on Amazon EC2 instances. Our
				middle-tier is constructed using the Spring framework, JPA and
				Maven. The web-based front-end uses HTML 5.0, Bootstrap, JQuery,
				Ajax, with a little bit of CSS 3.0 animation thrown in for good
				measure. <br>
				<br> We're big fans of automated testing, and especially
				Jenkins, to ensure the logical sanity of our android and middle-tier
				solutions! If any of the above sounds interesting, we're always
				excited in hearing from individuals who would like to help us out!.
			</p>
		</div>
		<div id="github-icon-container" class="col-md-5">
			<a href="https://bitbucket.org/healthresearch" target="_blank"> <i
				id="github-icon" class="fa fa-bitbucket"></i> <br> <span
				class="text-muted"> Follow us on Bitbucket! </span>
			</a>
		</div>
	</div>

	<hr class="featurette-divider">

	<div class="row featurette">
		<div id="knowledge-base-icon-container" class="col-md-5">
			<a href="http://supportinglife.github.io/" target="_blank">
				<i id="knowledge-bulb-icon" class="fa flaticon-idea"></i>
				<br><br><br>
				<span class="text-muted"> Check out our Knowledge Repository </span>
			</a>
		</div>
		<div class="col-md-7">
			<h2>Technology Knowledge Base</h2>
			<h3>
				<span class="text-muted">Knowledge at your finger tips</span>
			</h3>
			<br>
			<p class="lead">
				Supporting LIFE has a rich technological knowledge base to help
				adopters understand our approach and to reduce time to uptake. <br>
				<br> Our knowledge base provides clear guidelines on how to
				build and contribute to the Supporting LIFE codebase. It also shows
				those who are just interested in using the app, how to get up and
				running quickly. <br>
				<br> For anyone who would like to see where our technological
				journey will take us, there is a product roadmap of up and coming
				features.
			</p>
		</div>
	</div>

	<hr class="featurette-divider">

	<!-- TEAM MAP -->
	<div class="row featurette">
		<div class="col-md-12">
			<h1>Team Locations</h1>
			<div id="team-map"></div>
		</div>
	</div>
	<!-- /END THE TEAM MAP -->

	<hr class="featurette-divider">

	<!-- MEET THE TEAM -->
	<div class="row featurette">
		<div class="col-md-12">
			<h1>Meet The Team</h1>
			<div class="partner-accordion">
				<c:forEach items="${teamMembers.partnerGroups}" var="partnerGroup">
					<h3>${partnerGroup.partnerName}</h3>
					<div>
						<div class="team-member-accordion">
							<c:forEach items="${partnerGroup.teamMembers}" var="teamMember">
								<h4>${teamMember.name}</h4>
								<div>
									<div class="team-member-header">
										<c:choose>
											<c:when test="${teamMember.photoPresent}">
												<img alt="${teamMember.name}" src="${teamMember.imageRef}" />
											</c:when>
											<c:otherwise>
												<i id="team-member-default-icon" class="fa fa-user"></i>
											</c:otherwise>
										</c:choose>
									</div>
									<div class="team-member-body">
										<div class="header-text">
											<h4>${teamMember.name}</h4>
											<h5>${teamMember.role}</h5>
											<h6>${teamMember.qualifications}</h6>							
										</div>
										<p>${teamMember.bio}</p>
										<c:if test="${teamMember.linkedInProfilePresent}">
											<a href="${teamMember.linkedInUrl}" target="_blank">
												<i class="fa fa-linkedin-square"></i>
											</a>
										</c:if>
										<c:if test="${teamMember.researchProfilePresent}">
											<a href="${teamMember.researchUrl}" target="_blank">
												<i class="fa flaticon-research-profile"></i>
											</a>
										</c:if>
									</div>
								</div>
							</c:forEach>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
	<!-- /END MEET THE TEAM -->
	
	<hr class="featurette-divider">

	<!-- MEDIA UPDATES -->
	<div id="fb-root"></div>
	<div class="row featurette">
		<div id="social-media-updates" class="col-md-12">
			<h1>Social Media Updates</h1>
			<div id="facebook-wrapper" class="col-md-4">
				<i id="facebook-icon" class="fa fa-facebook-square"></i>
				<!-- facebook media updates -->
				<div class="fb-like-box" data-href="https://www.facebook.com/pages/Supporting-LIFE/389448601170394" data-colorscheme="light" 
						data-show-faces="false" data-header="true" data-stream="true" data-show-border="true">
				</div>
			</div>
			<div class="col-md-4">
				<i id="google-plus-icon" class="fa fa-google-plus"></i>
				<div id="google-plus-updates"></div>
			</div>
			<div class="col-md-4">
				<i id="twitter-icon" class="fa fa-twitter"></i>
				<a class="twitter-timeline" href="https://twitter.com/lifesupporting" data-widget-id="499968069653917696">Tweets by @lifesupporting</a>
			</div>			
		</div>
		
		<div id="social-media-follow-options" class="col-md-12">
			<div class="col-md-4"></div>
			<div class="col-md-4"></div>
			<div class="col-md-4">
				<h2>Follow us on</h2>
				<a href="https://www.facebook.com/pages/Supporting-LIFE/389448601170394" target="_blank">
					<span id="facebook-follow-icon" class="fa-stack fa-lg social-media-follow-roll">
			  			<i class="fa fa-circle fa-stack-2x"></i>
			  			<i class="fa fa-facebook fa-stack-1x"></i>
					</span>
				</a>
				<a href="https://plus.google.com/+SupportinglifeEu/posts" target="_blank">
					<span id="google-plus-follow-icon" class="fa-stack fa-lg social-media-follow-roll">
			  			<i class="fa fa-circle fa-stack-2x"></i>
			  			<i class="fa fa-google-plus fa-stack-1x"></i>
					</span>
				</a>
				<a href="https://twitter.com/lifesupporting" target="_blank">
					<span id="twitter-follow-icon" class="fa-stack fa-lg social-media-follow-roll">
						<i class="fa fa-circle fa-stack-2x"></i>
			 			<i class="fa fa-twitter fa-stack-1x"></i>
					</span>
				</a>
			</div>
		</div>
		
	</div>
	<!-- /END MEDIA UPDATES -->
	
	<hr class="featurette-divider">

	<!-- NEWSLETTER / CONTACT US -->
	<div class="row featurette">
		<div class="col-md-12">
			<h1>Find Out More</h1>
			<!-- Tab panes -->
			<ul id="find-out-more-tabs" class="nav nav-tabs">
				<li class="active">
					<a href="#newsletter" data-toggle="tab">Newsletter</a>
				</li>
				<li>
					<a href="#contact-us" data-toggle="tab">Contact Us</a>
				</li>
			</ul>
			<div id="find-out-more-tab-content" class="tab-content">
				<div class="tab-pane fade in active" id="newsletter">
					<div class="form-actions">
						<form id="newsletter-details">
							<div class="row">
								<div class="col-md-6 col-md-offset-3">
									<h3>Be among the first to know about upcoming features and news</h3>
									<!-- email address -->
									<div class="input-group newsletter-standard-level-item">
										<span class="input-group-addon">
											<span class="fa fa-envelope"></span>
										</span>
										<input id="newsletterEmailContact" name="newsletterEmailContact" type="email" class="form-control" placeholder="Enter Email"/>
									</div>
									<div>
										<button id="subscribe-button" class="btn btn-success">Subscribe</button>
									</div>
								</div>
							</div>
						</form>
					</div>
				</div>
				<div class="tab-pane fade" id="contact-us">
					<div class="form-actions">
						<form id="contact-us-details">
							<div class="row">
								<div class="col-md-6 col-md-offset-3">
									<h3>Let us know what's on your mind</h3>
									<!-- full name -->
									<div class="input-group contact-us-top-level-item">
										<span class="input-group-addon">
											<span class="fa fa-user"></span>
										</span>
										<input id="contactFullName" name="contactFullName" type='text' class="form-control" placeholder="Enter Full Name"/>
									</div>
					
									<!-- email address -->
									<div class="input-group contact-us-standard-level-item">
										<span class="input-group-addon">
											<span class="fa fa-envelope"></span>
										</span>
										<input id="contactEmail" name="contactEmail" type="email" class="form-control" placeholder="Enter Email"/>
									</div>
				
									<!-- telephone number -->
									<div class="input-group contact-us-standard-level-item">
										<span class="input-group-addon">
											<span class="fa fa-phone"></span>
										</span>
										<input id="contactPhoneNumber" name="contactPhoneNumber" type="tel" class="form-control" placeholder="Enter Telephone Number"/>
									</div>
				
									<!-- comment/message -->
									<div class="input-group contact-us-standard-level-item">
										<textarea id="contactComment" name="contactComment" class="form-control" placeholder="Enter Your Message" rows="5"></textarea>
									</div>
									<div>
										<button id="contact-us-button" class="btn btn-success">Contact Us</button>
									</div>
								</div>						
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<!-- /END THE NEWSLETTER / CONTACT US -->

	<!-- /END THE FEATURETTES -->

</div>

<!--  Include 'sl_welcome' footer -->
<%@include file="footers/sl_welcome_footer.jspf"%>

<!--  Include SL footer -->
<%@include file="footers/sl_footer.jspf"%>