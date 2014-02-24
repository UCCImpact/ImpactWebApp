<%-- sl_header.jsp --%>
<%-- Navigation menu bar --%>
<%-- author: James Flynn, Timothy O Sullivan --%>
<%-- Last Updated: 20/01/2014 --%>

<!-- =================================================== NAVIGATION BAR ================================================ -->
<body>
	<div class="navbar-wrapper">
		<div class="container">
			<div class="navbar navbar-inverse navbar-static-top">
				<div class="container">
					<div class="navbar-header">
						<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
						  <span class="icon-bar"></span>
						  <span class="icon-bar"></span>
						  <span class="icon-bar"></span>
						  <span class="icon-bar"></span>
						  <span class="icon-bar"></span>
						  <span class="icon-bar"></span>
						</button>		
						<label class="navbar-brand">Supporting LIFE
							<br id="slogan-line-spacing">
							<i id="bulb-icon" class="fa fa-lightbulb-o"><span id="slogan"> Technology</span></i>
						</label>
					</div>
					
					<div class="navbar-collapse collapse">
						<ul class="nav navbar-nav pull-right">
							<li class="active">																						<!-- HOME -->
								<a href="${pageContext.request.contextPath}/welcome"><i id="home-icon" class="fa fa-home"></i> Home</a>
							</li>								

							<li class="dropdown">
								<a href="#" class="dropdown-toggle" data-toggle="dropdown">Reporting<b class="caret"></b></a>		<!-- REPORTING -->
								<ul class="dropdown-menu">
									<li class="dropdown-header">Custom Reports</li>							
									<li><a href="${pageContext.request.contextPath}/reports/ccm_custom_report_form">CCM Custom Report</a></li>
									<li class="divider"></li>
									<li class="dropdown-header">Pre-defined Reports</li>
									<li><a href="#">Village Register</a></li>
									<li><a href="#">Form 1A</a></li>
									<li class="divider"></li>
									<li class="dropdown-header">Usage Analytics</li>
									<li><a href="#">Android App Analytics</a></li>
								</ul>
							</li> <!-- END: REPORTING -->

							<li><a data-toggle="tab" href="#contact">Surveillance</a></li>											<!-- SURVEILLANCE -->
							
							<li><a data-toggle="tab" href="#contact">Training</a></li>												<!-- TRAINING -->
							
		
							<li class="dropdown">																					<!-- ADMIN -->
								<a href="#" class="dropdown-toggle"	data-toggle="dropdown">Admin<b class="caret"></b></a>
								<ul class="dropdown-menu">
									<li class="dropdown-header">User Management</li>
									<li><a href="#">Register User</a></li>
									<li><a href="#">Modify User</a></li>
									<li class="divider"></li>
									<li class="dropdown-header">Account Settings</li>
									<li><a href="#">View Account</a></li>
								</ul>
							</li> <!-- END: ADMIN -->
							
							<li><a  data-toggle="tab" href="#about">About</a></li>													<!-- ABOUT -->
							
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>