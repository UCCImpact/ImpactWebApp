<%-- sl_ccm_report_results.jsp --%>
<%-- CCM Report Results Page. --%>
<%-- Author: Timothy O' Sullivan --%>
<%-- Last Updated: 04/02/2014. --%>

<%--  Include SL Header --%>
<%@include file="headers/sl_header.jspf"%>

<%--  Include 'sl_ccm_custom_report_results_header' header --%>
<%@include file="headers/sl_ccm_custom_report_results_header.jspf"%>

<%--  Include sl_header (i.e. main navigation bar) --%>
<jsp:include page="sl_top_level_navigation.jsp" />

<div id="report-ccm-container" class="container">

	<!-- coloured banner to maintain visual consistency from carousel -->
	<!-- screen to reporting screens -->
	<div class="row-fluid">
		<div class="span12 item">
			<div id="sl-report-banner" class="box"></div>
		</div>
	</div>

	<div class="animated fadeInDown">
		<h1>
			CCM Records <i class="header-icon fa fa-clipboard"></i>
		</h1>
	</div>

	<!-- patient visits list -->
	<div id="patient-visit-list" class="col-lg-12 sl-table-container">
		<h4>PATIENT VISITS</h4>
		<table id="patient-visit-table" class="table-hover sl-table display">
			<thead>
				<tr>
					<th>PATIENT ID</th>
					<th>PATIENT NAME</th>
					<th>NATIONAL ID</th>
					<th>NATIONAL HEALTH ID</th>
					<th>PATIENT VISIT DATE</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="patientVisit" items="${patientVisits}">
					<tr>
						<td>${patientVisit.patient.patientId}</td>
						<td>
							<c:out value="${patientVisit.patient.childFirstName}" /> 
							<c:out value="${patientVisit.patient.childSurname}" /></td>
						<td>${patientVisit.patient.nationalId}</td>
						<td>${patientVisit.patient.nationalHealthId}</td>
						<td class="dependantData">
							${patientVisit.visitDate}
							
							<!-- ask-look (part 1) symptoms associated with patient visit -->
							<input type="hidden" class="child-problems-symptom" value="${patientVisit.ccmPatientAskLookSymptoms.problem}"/>
							<input type="hidden" class="cough-symptom" value="${patientVisit.ccmPatientAskLookSymptoms.cough}"/>
							<input type="hidden" class="cough-duration-symptom" value="${patientVisit.ccmPatientAskLookSymptoms.coughDuration}"/>
							<input type="hidden" class="diarrhoea-symptom" value="${patientVisit.ccmPatientAskLookSymptoms.diarrhoea}"/>
							<input type="hidden" class="diarrhoea-duration-symptom" value="${patientVisit.ccmPatientAskLookSymptoms.diarrhoeaDuration}"/>
							<input type="hidden" class="blood-in-stool-symptom" value="${patientVisit.ccmPatientAskLookSymptoms.bloodInStool}"/>
							<input type="hidden" class="fever-symptom" value="${patientVisit.ccmPatientAskLookSymptoms.fever}"/>
							<input type="hidden" class="fever-duration-symptom" value="${patientVisit.ccmPatientAskLookSymptoms.feverDuration}"/>							
							<input type="hidden" class="convulsions-symptom" value="${patientVisit.ccmPatientAskLookSymptoms.convulsions}"/>

							<!-- ask-look (part 2) symptoms associated with patient visit -->
							<input type="hidden" class="difficulty-drinking-symptom" value="${patientVisit.ccmPatientAskLookSymptoms.difficultyDrinkingOrFeeding}"/>
							<input type="hidden" class="not-able-to-drink-symptom" value="${patientVisit.ccmPatientAskLookSymptoms.unableToDrinkOrFeed}"/>
							<input type="hidden" class="vomiting-symptom" value="${patientVisit.ccmPatientAskLookSymptoms.vomiting}"/>
							<input type="hidden" class="vomits-everything-symptom" value="${patientVisit.ccmPatientAskLookSymptoms.vomitsEverything}"/>
							<input type="hidden" class="red-eye-symptom" value="${patientVisit.ccmPatientAskLookSymptoms.redEye}"/>
							<input type="hidden" class="red-eye-duration-symptom" value="${patientVisit.ccmPatientAskLookSymptoms.redEyeDuration}"/>
							<input type="hidden" class="difficulty-seeing-symptom" value="${patientVisit.ccmPatientAskLookSymptoms.difficultySeeing}"/>
							<input type="hidden" class="difficulty-seeing-duration-symptom" value="${patientVisit.ccmPatientAskLookSymptoms.difficultySeeingDuration}"/>
							<input type="hidden" class="other-problems-symptom" value="${patientVisit.ccmPatientAskLookSymptoms.otherProblems}"/>
																				
							<!-- look symptoms associated with patient visit -->
							<input type="hidden" class="chest-indrawing-symptom" value="${patientVisit.ccmPatientLookSymptoms.chestIndrawing}"/>
							<input type="hidden" class="breaths-per-minute-symptom" value="${patientVisit.ccmPatientLookSymptoms.breathsPerMinute}"/>
							<input type="hidden" class="sleepy-unconscious-symptom" value="${patientVisit.ccmPatientLookSymptoms.sleepyUnconscious}"/>
							<input type="hidden" class="palmar-pallor-symptom" value="${patientVisit.ccmPatientLookSymptoms.palmarPallor}"/>
							<input type="hidden" class="muac-tape-colour-symptom" value="${patientVisit.ccmPatientLookSymptoms.muacTapeColour}"/>
							<input type="hidden" class="swelling-feet-symptom" value="${patientVisit.ccmPatientLookSymptoms.swellingBothFeet}"/>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div> <!-- end 'patient-visit-list' -->

	<!-- 'ask-look' (part 1) symptom list -->
	<div id="ask-look-symptom-list-one" class="col-lg-12 sl-table-container">
		<h4>'ASK-LOOK' SYMPTOMS (Part 1)</h4>
		<table id="ask-look-symptom-table-one" class="table-hover sl-table display">
			<thead>
				<tr>
					<th>CHILD'S PROBLEMS</th>
					<th>COUGH</th>
					<th>COUGH DURATION</th>
					<th>DIARRHOEA</th>
					<th>DIARRHOEA DURATION</th>
					<th>BLOOD IN STOOL</th>
					<th>FEVER</th>
					<th>FEVER DURATION</th>
					<th>CONVULSIONS</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td id="child-problems-cell">
						<i class="indicator-icon"></i>
					</td>
					<td id="cough-cell">
						<i class="indicator-icon"></i>
					</td>
					<td id="cough-duration-cell">
					</td>
					<td id="diarrhoea-cell">
						<i class="indicator-icon"></i>
					</td>
					<td id="diarrhoea-duration-cell">
					</td>
					<td id="blood-in-stool-cell">
						<i class="indicator-icon"></i>
					</td>
					<td id="fever-cell">
						<i class="indicator-icon"></i>
					</td>
					<td id="fever-duration-cell">
					</td>
					<td id="convulsions-cell">
						<i class="indicator-icon"></i>
					</td>
				</tr>
			</tbody>
		</table>
	</div> <!-- end 'ask-look-symptom-list-one' -->
	
	<!-- 'ask-look' (part 2) symptom list -->
	<div id="ask-look-symptom-list-two" class="col-lg-12 sl-table-container">
		<h4>'ASK-LOOK' SYMPTOMS (Part 2)</h4>
		<table id="ask-look-symptom-table-two" class="table-hover sl-table display">
			<thead>
				<tr>
					<th>DIFFICULTY DRINKING OR FEEDING</th>
					<th>NOT ABLE TO DRINK OR FEED</th>
					<th>VOMITING</th>
					<th>VOMITS EVERYTHING</th>
					<th>RED EYE</th>
					<th>RED EYE DURATION</th>
					<th>DIFFICULTY IN SEEING</th>
					<th>DIFFICULTY IN SEEING DURATION</th>
					<th>OTHER PROBLEMS</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td id="difficulty-drinking-cell">
						<i class="indicator-icon"></i>
					</td>
					<td id="not-able-to-drink-cell">
						<i class="indicator-icon"></i>
					</td>
					<td id="vomiting-cell">
						<i class="indicator-icon"></i>
					</td>
					<td id="vomits-everything-cell">
						<i class="indicator-icon"></i>
					</td>
					<td id="red-eye-cell">
						<i class="indicator-icon"></i>
					</td>
					<td id="red-eye-duration-cell">
					</td>
					<td id="difficulty-seeing-cell">
						<i class="indicator-icon"></i>
					</td>
					<td id="difficulty-seeing-duration-cell">
					</td>
					<td id="other-problems-cell">
						<i class="indicator-icon"></i>
					</td>
				</tr>
			</tbody>
		</table>
	</div> <!-- end 'ask-look-symptom-list-two' -->

	<!-- look symptom list -->
	<div id="look-symptom-list" class="col-lg-12 sl-table-container">
		<h4>LOOK SYMPTOMS</h4>
		<table id="look-symptom-table" class="table-hover sl-table display">
			<thead>
				<tr>
					<th>CHEST INDRAWING</th>
					<th>BREATHS PER MINUTE</th>
					<th>SLEEPY UNCONSCIOUS</th>
					<th>PALMAR PALLOR</th>
					<th>MUAC TAPE COLOUR</th>
					<th>SWELLING OF BOTH FEET</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td id="chest-indrawing-cell">
						<i class="indicator-icon"></i>
					</td>
					<td id="breaths-per-minute-cell">
					</td>
					<td id="sleepy-unconscious-cell">
						<i class="indicator-icon"></i>
					</td>
					<td id="palmar-pallor-cell">
						<i class="indicator-icon"></i>
					</td>
					<td id="muac-tape-colour-cell">
						<i class="indicator-icon"></i>
					</td>
					<td id="swelling-feet-cell">
						<i class="indicator-icon"></i>
					</td>
				</tr>
			</tbody>
		</table>
	</div> <!-- end 'look-symptom-list' -->


</div> <!--  END: report-ccm-container -->

<!--  Include 'sl_ccm_custom_report_results_footer' footer -->
<%@include file="footers/sl_ccm_custom_report_results_footer.jspf"%>

<!--  Include SL footer -->
<%@include file="footers/sl_footer.jspf"%>
