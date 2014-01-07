<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%-- JSTL FMT supports time, number and localisation formats. --%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%-- JSTL Functions allow for String manipulation. --%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<html lang="en">
<!-- Include <head> in jspf, including JS Script refs. -->
<%@include file="sl_header.jspf"%>
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
	
				<li><a href="#">Register User</a></li> <!-- END: Register User -->
				
				<li><a href="#">Account Settings</a></li> <!-- END: Account Settings -->

				<li><a href="#">Training</a></li> <!-- END: Training -->

				<li><a href="#">About</a></li> <!-- END: About -->

				<li><a href="#">Log Out</a></li> <!-- END: Log Out -->
			</ul> <!-- END: Top Level Menu Bar -->
		</nav>
	
		<div class="mainPageContent">
			<h1>Welcome to the Supporting LIFE admin website.</h1>
			<p>Please choose an option from the menu, above.</p>
		</div> <!-- END Main Page Content -->
		
	</body>
</html>