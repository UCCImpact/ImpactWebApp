<%-- sl_ccm_symptom_classification_report.jsp --%>
<%-- CCM Symptom / Classification Report Generation Page. --%>
<%-- Author: Timothy O'Sullivan --%>
<%-- Last Updated: 02/09/2014. --%>

<%--  Include SL Header --%>
<%@include file="headers/sl_header.jspf"%>

<%--  Include 'sl_ccm_symptom_classification_report_header' header --%>
<%@include file="headers/sl_ccm_symptom_classification_report_header.jspf"%>

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

	<div id="user-welcome" class="row">
		<div class="col-lg-9"></div>
		<div class="col-lg-3">
			<sec:authorize access="isAuthenticated()">
				<h1>Welcome User:&nbsp;&nbsp;<span id="user-identifier"><sec:authentication property="principal.username"/></span></h1>
			</sec:authorize>
		</div>
	</div>

	<h1>CCM Symptom / Classification Search</h1>
	
	<!-- using accordion to display sticky post-it note about the ccm symptom / classification report -->
	<div class="panel-group center" id="report-note-accordion">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h5 class="panel-title">
					Report Note
					<a data-toggle="collapse" class="report-note-title" data-parent="#report-note-accordion" href="#report-note-collapse">
						<i id="report-note-expand-icon" class="fa fa-plus-square pull-right"></i>
					</a>
				</h5>
			</div>
			<div id="report-note-collapse" class="panel-collapse collapse">
				<div class="panel-body">
					<div class="sticky-note">
						<p>
							<strong>Note</strong>
						</p>
						<span class="sticky-note-content">
							Please note that in order to obtain a meaningful set of results,
							the criteria selected must represent a valid combination.
						</span>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<!-- CCM report form -->
	<form:form method="POST" action="../reports/ccm_symptom_classification_report" modelAttribute="ccmSymptomsClassificationsFormBean" 
				class="form-horizontal" id="ccm-symptom-classification-report-form">
	
		<div id="checkbox-list-container" class="row">
	
			<!-- symptom list -->
			<div id="symptom-list" class="col-lg-6 sl-table-container">
				<table id="symptom-table" class="table-hover table-striped sl-table">
					<thead>
						<tr>
							<th>SYMPTOM</th>
							<th>SELECT</th>
						</tr>
					</thead>
					<tbody> 
						<!-- 'Ask Look Symptoms' First -->
						<c:forEach items="${ccmSymptomsClassificationsFormBean.askLookSymptoms}" var="askLookSymptom" varStatus="status">
							<tr>
								<td>${askLookSymptom.value}</td>
								<td class="symptom-checkbox-column">
									<form:checkbox path="askLookSymptoms[${status.index}].checked"/>
								</td>
								<form:input type="hidden" path="askLookSymptoms[${status.index}].key" value="${askLookSymptom.key}"/>
								<form:input type="hidden" path="askLookSymptoms[${status.index}].value" value="${askLookSymptom.value}"/>
							</tr>
						</c:forEach>
						<!-- 'Look Symptoms' Second -->
						<c:forEach items="${ccmSymptomsClassificationsFormBean.lookSymptoms}" var="lookSymptom" varStatus="status">
							<tr>
								<td>${lookSymptom.value}</td>
								<td class="symptom-checkbox-column">
									<form:checkbox path="lookSymptoms[${status.index}].checked"/>
								</td>
								<form:input type="hidden" path="lookSymptoms[${status.index}].key" value="${lookSymptom.key}"/>
								<form:input type="hidden" path="lookSymptoms[${status.index}].value" value="${lookSymptom.value}"/>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
	
			<!-- classification list -->
			<div id="classification-list" class="col-lg-6 sl-table-container">
				<table id="classification-table" class="table-hover table-striped sl-table">
					<thead>
						<tr>
							<th>CLASSIFICATION</th>
							<th>SELECT</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${ccmSymptomsClassificationsFormBean.classifications}" var="classification" varStatus="status">
							<tr>
								<td>${classification.value}</td>
								<td class="classification-checkbox-column">
									<form:checkbox path="classifications[${status.index}].checked"/>
								</td>
								<form:input type="hidden" path="classifications[${status.index}].key" value="${classification.key}"/>
								<form:input type="hidden" path="classifications[${status.index}].value" value="${classification.value}"/>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		<!-- end row -->

		<div class="form-actions">
			<input type="hidden" name="save" value="contact">
			<button id="submit-button" type="submit" class="btn btn-success">Submit</button>
			<button id="reset-button" type="reset" class="btn">Reset</button>
		</div>
	</form:form>
</div><!--  END: report-ccm-container -->


<!--  Include 'sl_ccm_symptom_classification_report_footer' footer -->
<%@include file="footers/sl_ccm_symptom_classification_report_footer.jspf"%>

<!--  Include SL footer -->
<%@include file="footers/sl_footer.jspf"%>