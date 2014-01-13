<%-- sl_header.jsp --%>
<%-- Top navigation menu bar. --%>
<%-- author: James Flynn --%>
<%-- Last Updated: 09/01/2014 --%>

<!-- Include <head> in jspf, including JS Script refs. -->
	<body>
		<nav>
			<!-- HTML 5 element: Nav Replaces divs for menus, improving GoogleBot searches -->
			<ul class="topLevelMenuBar">
				<li><a href="#">Generate Reports</a>
	
					<ul class="secondLevelMenuBar">
						<li><a href="#">Pre-defined Report</a>
							<ul class="thirdLevelMenuBar">
								<c:forEach var="preDefinedReport" items="${preDefinedReports}">
	
									<li><a href="#">${preDefinedReport}</a></li>
	
								</c:forEach>
							</ul>
						</li> <!-- END: Pre-Defined Reports -->
						
						<li><a href="#">Custom Report</a>
							<ul class="thirdLevelMenuBar">
								<c:forEach var="customReport" items="${customReports}">
									<li><a href="#">${customReport}</a></li>
								</c:forEach>
							</ul>
						</li> <!-- END: Custom Reports -->	
					</ul> 				
				</li>  <!-- END: Generate Reports -->
	
				<!-- Contains tooltip stating that "Feature Is Not Implemented Yet." -->
				<li class="disabledButton" id="disabledRegisterUserFeature"><a id="open-event" href="#" >Register User</a></li> <!-- END: Register User -->
				
				<li class="disabledButton" id="disabledAccountSettingsFeature"><a id="open-event" href="#">Account Settings</a></li> <!-- END: Account Settings -->

				<li class="disabledButton" id="disabledTrainingFeature"><a id="open-event" href="#">Training</a></li> <!-- END: Training -->

				<li class="disabledButton" id="disabledAboutFeature"><a id="open-event" href="#">About</a></li> <!-- END: About -->

				<li class="disabledButton" id="disabledLogOutFeature"><a id="open-event" href="#">Log Out</a></li> <!-- END: Log Out -->
			</ul> <!-- END: Top Level Menu Bar -->
		</nav>