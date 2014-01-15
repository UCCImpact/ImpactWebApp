<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%-- JSTL FMT supports time, number and localisation formats. --%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%-- JSTL Functions allow for String manipulation. --%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<html lang="en">
	<!--  Include Top Level Menu Bar -->
	<%@include file="sl_header.jspf"%>
	<!--  Include sl_ccm_custom_report header -->
	<%@include file="sl_ccm_custom_report.jspf"%>

	<!--  Include sl_header (i.e. main Toolbar) -->
	<jsp:include page="sl_header.jsp"/>
	
	<h2>Let's Do This.....</h2>
	<h4>${message}</h4>
</body>
</html>