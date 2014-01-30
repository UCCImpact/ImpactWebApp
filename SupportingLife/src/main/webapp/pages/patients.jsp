<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<body>
	<div id="logo">
		<img src=<c:url value="/images/supporting_life_logo.jpg"/> alt="Supporting Life">
	</div>
	<h2>Patients</h2>
	<table border="1">
		<tr>
			<td>Patient ID</td>
			<td>Patient First Name</td>
			<td>Patient Surname</td>
			<td>Patient Date of Birth</td>
			<td>HSA Responsible for Assessment</td>
			<td>CCM User?</td>
			<td>IMCI User?</td>
			<td>Classifications</td>
		</tr>
		<c:forEach var="patient" items="${patients}">
			<tr>
				<td>${patient.patientId}</td>
				<td>${patient.childFirstName}</td>
				<td>${patient.childSurname}</td>
				<td>${patient.birthDate}</td>
				<td><c:out value="${patient.user.firstName}"/> <c:out value="${patient.user.surname}"/></td>
				<td>${patient.user.ccmUser}</td>
				<td>${patient.user.imciUser}</td>
				<td>
					<c:forEach var="patientClassification" items="${patient.ccmPatientClassificationList}">
						<c:out value="${patientClassification.classification.classificationName}" />
						<br>						
					</c:forEach>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
