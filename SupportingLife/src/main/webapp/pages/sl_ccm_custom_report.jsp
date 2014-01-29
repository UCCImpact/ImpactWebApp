<%-- sl_ccm_custom_report.jsp --%>
<%-- CCM Custom Report Generation Page. --%>
<%-- Author: Timothy O' Sullivan, James Flynn --%>
<%-- Last Updated: 26/01/2014. --%>

<%--  Include SL Header --%>
<%@include file="headers/sl_header.jspf"%>

<%--  Include 'sl_ccm_custom_report_header' header --%>
<%@include file="headers/sl_ccm_custom_report_header.jspf"%>

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

	<h1>CCM Custom Report</h1>
	
	<!-- using accordion to display sticky post-it note about the ccm custom report -->
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
	<form:form method="POST" action="../reports/ccm_custom_report" modelAttribute="ccmCustomFormBean" class="form-horizontal" id="ccm-report-form">
		<!-- three columns for user/patient identifier input -->
		<div class="row">
			<div id="patient-identifier-container" class="col-lg-6">
				<div class="control-group">
					<!-- Number input (max. 8 characters, as per Functional Specification.) -->
					<form:label for="national-id" class="control-label" path="nationalId">National ID: </form:label>
					<div class="controls">
						<form:input type="text" path="nationalId" placeholder="Enter National Id"/>
					</div>
				</div>
	
				<div class="control-group">
					<!-- Number input (max. 8 characters, as per Functional Specification.) -->
					<form:label for="national-health-id" class="control-label" path="nationalHealthId">National	Health ID: </form:label>
					<div class="controls">
						<form:input type="text"	path="nationalHealthId" placeholder="Enter National Health Id"/>
					</div>
				</div>
	
				<div class="control-group">
					<form:label for="hsa-user-id" class="control-label" path="hsaUserId">HSA User ID: </form:label>
					<div class="controls">
						<form:input type="text"	path="hsaUserId" placeholder="Enter HSA User Id"/>
					</div>
				</div>
			</div>
			<!-- end column -->
	
			<div id="assessment-date-container" class="col-lg-6">
				<div class="control-group">
					<!-- assessment date range -->
					<form:label for="assessment-date-from" class="control-label" path="assessmentDateFrom">From: </form:label>
					<div class="controls">
						<form:input class="assessment-datepicker"
							data-format="dd-MM-yyyy" path="assessmentDateFrom" placeholder="Assessment Date From" />
					</div>
				</div>
				<div class="control-group">
					<form:label for="assessment-date-to" class="control-label" path="assessmentDateTo">To: </form:label>
					<div class="controls">
						<form:input class="assessment-datepicker"
							data-format="dd-MM-yyyy" path="assessmentDateTo" placeholder="Assessment Date To" />
					</div>
				</div>
			</div>
			<!-- end column -->
		</div>
		<!-- end row -->
	
		<div id="checkbox-list-container" class="row">
	
			<!-- symptom list -->
			<div id="symptom-list" class="col-lg-6 sl-table-container">
				<table id="symptom-table" class="table-hover sl-table display">
					<thead>
						<tr>
							<th>SYMPTOM</th>
							<th>SELECT</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${ccmCustomFormBean.symptoms}" var="symptom" varStatus="status">
							<tr>
								<td>${symptom.value}</td>
								<td class="symptom-checkbox-column">
									<form:checkbox path="symptoms[${status.index}].checked"/>
								</td>
								<form:input type="hidden" path="symptoms[${status.index}].key" value="${symptom.key}"/>
								<form:input type="hidden" path="symptoms[${status.index}].value" value="${symptom.value}"/>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
	
			<!-- classification list -->
			<div id="classification-list" class="col-lg-6 sl-table-container">
				<table id="classification-table" class="table-hover sl-table display">
					<thead>
						<tr>
							<th>CLASSIFICATION</th>
							<th>SELECT</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${ccmCustomFormBean.classifications}" var="classification" varStatus="status">
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
	
		<!-- treatment list -->
		<div id="checkbox-list-container" class="row">
			<div id="treatment-list" class="col-lg-12 sl-table-container">
				<table id="treatment-table" class="table-hover sl-table display">
					<thead>
						<tr>
							<th>TREATMENT</th>
							<th>CATEGORY</th>
							<th>SELECT</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${ccmCustomFormBean.treatments}" var="treatment" varStatus="status">
							<tr>
								<td>${treatment.value}</td>
								<td>${treatment.associatedClassification}</td>
								<td class="treatment-checkbox-column">
									<form:checkbox path="treatments[${status.index}].checked"/>
								</td>
								<form:input type="hidden" path="treatments[${status.index}].key" value="${treatment.key}"/>
								<form:input type="hidden" path="treatments[${status.index}].value" value="${treatment.value}"/>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		<div class="form-actions">
			<input type="hidden" name="save" value="contact">
			<button id="submit-button" type="submit" class="btn btn-success">Submit</button>
			<button id="reset-button" type="reset" class="btn">Reset</button>
		</div>
	</form:form>
</div><!--  END: report-ccm-container -->


<!--  Include 'sl_ccm_custom_report_footer' footer -->
<%@include file="footers/sl_ccm_custom_report_footer.jspf"%>

<!--  Include SL footer -->
<%@include file="footers/sl_footer.jspf"%>