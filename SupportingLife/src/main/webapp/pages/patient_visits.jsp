<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<body>
	<div id="logo">
		<img src=<c:url value="/images/supporting_life_logo.jpg"/> alt="Supporting Life">
	</div>
	<h2>Patient Visits</h2>
	<table border="1">
		<tr>
			<td>Patient ID</td>
			<td>Patient Name</td>
			<td>Patient Visit Date</td>
		</tr>
		<c:forEach var="patientVisit" items="${patientVisits}">
			<tr>
				<td>${patientVisit.patient.patientId}</td>
				<td><c:out value="${patientVisit.patient.childFirstName}"/> <c:out value="${patientVisit.patient.childSurname}"/></td>
				<td>${patientVisit.visitDate}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
