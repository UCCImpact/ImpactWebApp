<%-- sl_ccm_report_results.jsp --%>
<%-- CCM Report Results Page. --%>
<%-- Author: Timothy O' Sullivan --%>
<%-- Last Updated: 29/01/2014. --%>

<%--  Include SL Header --%>
<%@include file="headers/sl_header.jspf"%>

<%--  Include 'sl_ccm_custom_report_header' header --%>
<%@include file="headers/sl_ccm_custom_report_header.jspf"%>

<%--  Include sl_header (i.e. main navigation bar) --%>
<jsp:include page="sl_top_level_navigation.jsp" />

	<h2>Patient Visits</h2>

	<table border="1">
		<tr>
			<td>Patient ID</td>
			<td>National ID</td>
			<td>National Health ID</td>
			<td>Patient Name</td>
			<td>Patient Visit Date</td>
		</tr>
		<c:forEach var="patientVisit" items="${patientVisits}">
			<tr>
				<td>${patientVisit.patient.patientId}</td>
				<td><c:out value="${patientVisit.patient.childFirstName}"/> <c:out value="${patientVisit.patient.childSurname}"/></td>
				<td>${patientVisit.patient.nationalId}</td>
				<td>${patientVisit.patient.nationalHealthId}</td>
				<td>${patientVisit.visitDate}</td>
			</tr>
		</c:forEach>
	</table>

<!--  Include SL footer -->
<%@include file="footers/sl_footer.jspf"%>
