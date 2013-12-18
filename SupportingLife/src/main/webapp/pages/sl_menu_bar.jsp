<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%-- JSTL FMT supports time, number and localisation formats. --%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"
	prefix="fmt"%>
<%-- JSTL Functions allow for String manipulation. --%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html lang="en">
<!-- Include <head> in jspf, including JS Script refs. -->
<%@include file="sl_menu_bar.jspf"%>
<body>
	<nav>
		<!-- HTML 5 element: Nav Replaces divs for menus, improving GoogleBot searches -->
		<ul id="menubar">
			<li><c:url value="#">Generate Reports</c:url></li>
			<li><c:url value="#">Custom Report</c:url></li>

			<!-- Restores proper scaling when relative positioning is used in UL. -->
			<!-- END Produce Reports dropdown menu. -->

			<li><c:url value="#">Register User</c:url></li>
			<li><c:url value="#">Account Settings</c:url></li>
			<li><c:url value="#">Training</c:url></li>
			<li><c:url value="#">About</c:url></li>
			<li><c:url value="#">Log Out</c:url></li>
		</ul>
		<!-- END menubar -->
		<div class="clear"></div>
		<!-- Restores proper scaling when relative positioning is used in UL. -->
	</nav>

	<div class="content">
		<h1>Welcome to the Supporting LIFE admin website.</h1>
		<p>Please choose an option from the menu, above.</p>
	</div>
	<!-- END content -->
</body>
</html>