<%-- sl_header.jsp --%>
<%-- Navigation menu bar --%>
<%-- author: Timothy O'Sullivan --%>
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
						<label class="navbar-brand">Supporting LIFE</label>
					</div>
					
					<div class="navbar-collapse collapse">
						<ul class="nav navbar-nav pull-right">
							<li>																											<!-- HOME -->
								<a href="${pageContext.request.contextPath}/welcome"><i id="home-icon" class="fa fa-home"></i> Home</a>
							</li>								

							<li class="dropdown">
								<a href="#" class="dropdown-toggle" data-toggle="dropdown">Reporting<b class="caret"></b></a>				<!-- REPORTING -->
								<ul class="dropdown-menu">
									<li class="dropdown-header">Custom Reports</li>
									<li><a href="${pageContext.request.contextPath}/reports/ccm_custom_report_form">CCM Report</a></li>
									<li><a class="trigger right-caret">CCM Advanced Search</a>
										<ul class="dropdown-menu sub-menu">
											<li class="dropdown-header">CCM Advanced Search Reports</li>
											<li><a href="${pageContext.request.contextPath}/reports/ccm_demographic_report_form">CCM Demographic Search</a></li>
											<li><a href="${pageContext.request.contextPath}/reports/ccm_symptom_classification_report_form">CCM Symptom/Classification Search</a></li>
											<li><a href="${pageContext.request.contextPath}/reports/ccm_treatment_report_form">CCM Treatment Search</a></li>
										</ul>
									</li>
									<li class="divider"></li>
									<li class="dropdown-header">Usage Analytics</li>
										<li class="disabled"><a href="#" class="unimplemented-feature">Android App Analytics</a></li>
								</ul>
							</li> <!-- END: REPORTING -->

							<li><a href="${pageContext.request.contextPath}/surveillance">Surveillance</a></li>								<!-- SURVEILLANCE -->
							
							<li class="disabled"><a data-toggle="tab" href="#contact" class="unimplemented-feature">Training</a></li>		<!-- TRAINING -->
							
		
							<li class="dropdown">																							<!-- ADMIN -->
								<a href="#" class="dropdown-toggle"	data-toggle="dropdown">Admin<b class="caret"></b></a>
								<ul class="dropdown-menu">
									<li class="dropdown-header">User Management</li>
										<li class="disabled"><a href="#" class="unimplemented-feature">Register User</a></li>
										<li class="disabled"><a href="#" class="unimplemented-feature">Modify User</a></li>
									<li class="divider"></li>
									<li class="dropdown-header">Account Settings</li>
										<li class="disabled"><a href="#" class="unimplemented-feature">View Account</a></li>
								</ul>
							</li> <!-- END: ADMIN -->
							
							<li class="disabled"><a  data-toggle="tab" href="#about" class="unimplemented-feature">About</a></li>					<!-- ABOUT -->
							
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>