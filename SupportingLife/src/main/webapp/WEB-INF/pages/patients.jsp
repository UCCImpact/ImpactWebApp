<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<body>
	<div id="logo">
		<img src="/SupportingLife/resources/images/SupportingLifeLogo.jpg" alt="Supporting Life">
	</div>
	<h2>Patients</h2>
	<table border="1">
		<tr>
			<td>Patient ID</td>
			<td>Patient First Name</td>
			<td>Patient Surname</td>
		</tr>
		<c:forEach var="patient" items="${patients}">
			<tr>
				<td>${patient.patientId}</td>
				<td>${patient.firstName}</td>
				<td>${patient.surname}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
