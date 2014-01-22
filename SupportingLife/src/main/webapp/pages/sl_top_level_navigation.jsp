<%-- sl_header.jsp --%>
<%-- Navigation menu bar --%>
<%-- author: James Flynn, Timothy O Sullivan --%>
<%-- Last Updated: 20/01/2014 --%>

<!-- Include <head> in invoked jspf files -->


<!-- =================================================== NAVIGATION BAR ================================================ -->
<body>
	<div class="navbar-wrapper">
		<div class="container">
			<div class="navbar navbar-inverse navbar-static-top" role="navigation">
				<div class="container">
					<div class="navbar-header">
						<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
							<span class="sr-only">Toggle navigation</span> 
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
						</button>
						<a class="navbar-brand" href="#">Supporting LIFE</a>
					</div>
					<div class="navbar-collapse collapse">
						<ul class="nav navbar-nav">
							<li class="active"><a href="#">Home</a></li>															<!-- HOME -->

							<li class="dropdown">
								<a href="#" class="dropdown-toggle"	data-toggle="dropdown">Reporting<b class="caret"></b></a>		<!-- REPORTING -->
								<ul class="dropdown-menu">
									<li class="dropdown-header">Custom Reports</li>							
									<li><a href="#">CCM Custom Report</a></li>
									<li class="divider"></li>
									<li class="dropdown-header">Pre-defined Reports</li>
									<li><a href="#">Pre-defined Report 1</a></li>
								</ul>
							</li> <!-- END: REPORTING -->

							<li><a href="#contact">Surveillance</a></li>															<!-- SURVEILLANCE -->
							
							<li><a href="#contact">Training</a></li>																<!-- TRAINING -->
							
		
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
							
							<li><a href="#about">About</a></li>																		<!-- ABOUT -->
							
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>