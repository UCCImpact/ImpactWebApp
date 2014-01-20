<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<body>
	<div id="logo">
		<img src=<c:url value="/images/supporting_life_logo.jpg"/> alt="Supporting Life">
	</div>
	<h2>Patient Visit</h2>
	<table border="1">
		<tr>
			<td>Visit ID</td>
			<td>Patient ID</td>
			<td>Patient Name</td>
			<td>Patient Visit Date</td>
		</tr>
		<tr>
			<td>${patientVisit.visitId}</td>
			<td>${patientVisit.patient.patientId}</td>
			<td><c:out value="${patientVisit.patient.childFirstName}"/> <c:out value="${patientVisit.patient.childSurname}"/></td>
			<td>${patientVisit.visitDate}</td>
		</tr>
	</table>

	<h2>Patient Look Symptoms</h2>
	<table border="1">
		<tr>
			<td>Visit ID</td>
			<td>Patient ID</td>
			<td>Chest Indrawing?</td>
			<td>Breaths Per Minute</td>
			<td>Sleepy Unconscious?</td>
			<td>Palmar Pallor?</td>
			<td>MUAC Tape Colour</td>
			<td>Swelling of Both Feet</td>
		</tr>
		<tr>
			<td>${patientLookSymptoms.visit.visitId}</td>
			<td>${patientLookSymptoms.patient.patientId}</td>
			<td>${patientLookSymptoms.chestIndrawing}</td>
			<td>${patientLookSymptoms.breathsPerMinute}</td>
			<td>${patientLookSymptoms.sleepyUnconscious}</td>
			<td>${patientLookSymptoms.palmarPallor}</td>
			<td>${patientLookSymptoms.muacTapeColour}</td>
			<td>${patientLookSymptoms.swellingBothFeet}</td>			
		</tr>
	</table>
	
	<h2>Patient Ask Look Symptoms</h2>
	<table border="1">
		<tr>
			<td>Visit ID</td>
			<td>Patient ID</td>
			<td>Problem</td>
			<td>Cough?</td>
			<td>Cough Duration</td>
			<td>Diarrhoea?</td>
			<td>Diarrhoea Duration</td>
			<td>Blood in Stool?</td>
			<td>Fever?</td>
			<td>Fever Duration</td>
			<td>Convulsions?</td>
			<td>Difficulty Drinking or Feeding?</td>
			<td>Not Able to Drink or Feed?</td>
			<td>Vomiting?</td>
			<td>Vomits Everything?</td>
			<td>Red Eye?</td>
			<td>Red Eye Duration</td>
			<td>Difficulty in Seeing?</td>
			<td>Difficulty in Seeing Duration</td>
			<td>Other Problems</td>
		</tr>
		<tr>
			<td>${patientAskLookSymptoms.visit.visitId}</td>
			<td>${patientAskLookSymptoms.patient.patientId}</td>
			<td>${patientAskLookSymptoms.problem}</td>
			<td>${patientAskLookSymptoms.cough}</td>
			<td>${patientAskLookSymptoms.coughDuration}</td>
			<td>${patientAskLookSymptoms.diarrhoea}</td>
			<td>${patientAskLookSymptoms.diarrhoeaDuration}</td>
			<td>${patientAskLookSymptoms.bloodInStool}</td>		
			<td>${patientAskLookSymptoms.fever}</td>
			<td>${patientAskLookSymptoms.feverDuration}</td>
			<td>${patientAskLookSymptoms.convulsions}</td>
			<td>${patientAskLookSymptoms.difficultyDrinkingOrFeeding}</td>
			<td>${patientAskLookSymptoms.unableToDrinkOrFeed}</td>
			<td>${patientAskLookSymptoms.vomiting}</td>
			<td>${patientAskLookSymptoms.vomitsEverything}</td>
			<td>${patientAskLookSymptoms.redEye}</td>
			<td>${patientAskLookSymptoms.redEyeDuration}</td>
			<td>${patientAskLookSymptoms.difficultySeeing}</td>
			<td>${patientAskLookSymptoms.difficultySeeingDuration}</td>
			<td>${patientAskLookSymptoms.otherProblems}</td>
		</tr>
	</table>
	
	<h2>Patient Classifications</h2>
	<table border="1">
		<tr>
			<td>Visit ID</td>
			<td>Patient ID</td>
			<td>Classification</td>
		</tr>
		<c:forEach var="patientClassification" items="${patientClassifications}">
			<tr>
				<td>${patientClassification.visit.visitId}</td>
				<td>${patientClassification.patient.patientId}</td>		
				<td>${patientClassification.classification.name}</td>
			</tr>
		</c:forEach>
	</table>
	
</body>
</html>
