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
			CCM Results <i class="header-icon fa fa-clipboard"></i>
		</h1>
	</div>

	<!-- patient visits list -->
	<div id="patient-visit-list" class="col-lg-12 sl-table-container">
		<h4>PATIENT VISITS</h4>
		<table id="patient-visit-table" class="table-hover sl-table display">
			<thead>
				<tr>
					<th>PATIENT ID</th>
					<th>NATIONAL ID</th>
					<th>NATIONAL HEALTH ID</th>
					<th>PATIENT NAME</th>
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
						<td>
							${patientVisit.visitDate}
							<input type="hidden" name="chest-indrawing-symptom" id="chest-indrawing-symptom" value="${patientVisit.ccmPatientLookSymptoms.chestIndrawing}"/>
							<input type="hidden" name="breaths-per-minute-symptom" id="breaths-per-minute-symptom" value="${patientVisit.ccmPatientLookSymptoms.breathsPerMinute}"/>
							<input type="hidden" name="sleepy-unconscious-symptom" id="sleepy-unconscious-symptom" value="${patientVisit.ccmPatientLookSymptoms.sleepyUnconscious}"/>
							<input type="hidden" name="palmar-pallor-symptom" id="palmar-pallor-symptom" value="${patientVisit.ccmPatientLookSymptoms.palmarPallor}"/>
							<input type="hidden" name="muac-tape-colour-symptom" id="muac-tape-colour-symptom" value="${patientVisit.ccmPatientLookSymptoms.muacTapeColour}"/>
							<input type="hidden" name="swelling-feet-symptom" id="swelling-feet-symptom" value="${patientVisit.ccmPatientLookSymptoms.swellingBothFeet}"/>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div> <!-- end 'patient-visit-list' -->

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
						<i class="indicator-icon"></i>
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
