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
		<div class="col-lg-4">
			<i id="medic-icon" class="fa fa-user-md"></i>
			<h3>Enhance Productivity</h3>
			<p class="lead">Improve productivity of medical provider by
				increasing adherence to clinical guidelines and reducing
				administrative overhead of performing patient assessments.</p>
		</div>
		<div class="col-lg-4">
			<i id="healthcare-icon" class="fa fa-plus-square"></i>
			<h3>Improve Healthcare Services</h3>
			<p class="lead">Enhance the accuracy of diagnoses, treatment and
				health outcomes by utilising automated, rigorous and robust decision
				support systems.</p>
		</div>
		<div class="col-lg-4">
			<i id="globe-icon" class="fa fa-globe"></i>
			<h3>Increase Care Coordination</h3>
			<p class="lead">Decrease the fragmentation of care by integrating
				and organising electronic health records and providing immediate
				distribution to authorised care providers.</p>
		</div>
	</div>

	<!-- =========================================== FEATURETTES ================================================= -->

	<hr class="featurette-divider">

	<div class="row featurette">
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
		</div>
		<div class="col-md-5">
			<div id="videoCarousel" class="carousel slide" data-interval="false"
				data-ride="carousel">
				<div class="carousel-inner">
					<div class="item active">
						<div class="container">
							<div class="carousel-caption">
								<h3>Latest Software Release (SL 3.0)</h3>
							</div>
						</div>
						<iframe height="200" src="//www.youtube.com/embed/n4iDDow6pxc"
							allowfullscreen></iframe>
					</div>
					<!-- end of active item -->
					<div class="item ">
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
		<div class="col-md-5">
			<a href="https://github.com/timothyosullivan" target="_blank"> <i
				id="github-icon" class="fa fa-github"></i> <br> <span
				class="text-muted"> Follow us on GitHub! </span>
			</a>
		</div>
	</div>

	<hr class="featurette-divider">

	<div class="row featurette">
		<div class="col-md-5">
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
			<h1>Where We Are</h1>
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
								<div class="col-md-12">
									<div class="team-member-header col-md-2">
										<c:choose>
											<c:when test="${teamMember.photoPresent}">
												<img alt="${teamMember.name}" src="${teamMember.imageRef}" />
											</c:when>
											<c:otherwise>
												<i id="team-member-default-icon" class="fa fa-user"></i>
											</c:otherwise>
										</c:choose>
									</div>
									<div class="team-member-body col-md-10">
										<div class="header-text">
											<h4>${teamMember.name}</h4>
											<h5>${teamMember.qualifications}</h5>
											<h5>${teamMember.role}</h5>
										</div>
										<p>${teamMember.bio}</p>
										<c:if test="${teamMember.linkedInProfilePresent}">
											<a href="${teamMember.linkedInUrl}" target="_blank">
												<i	class="fa fa-linkedin-square"></i>
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

	<!-- /END THE FEATURETTES -->

</div>

<!--  Include 'sl_welcome' footer -->
<%@include file="footers/sl_welcome_footer.jspf"%>

<!--  Include SL footer -->
<%@include file="footers/sl_footer.jspf"%>