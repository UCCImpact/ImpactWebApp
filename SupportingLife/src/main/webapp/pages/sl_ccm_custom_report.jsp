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
	<form method="POST" action="" class="form-horizontal"
		id="ccm-report-form">
		<!-- three columns for user/patient identifier input -->
		<div class="row">
			<div id="patient-identifier-container" class="col-lg-6">
				<div class="control-group">
					<!-- Number input (max. 8 characters, as per Functional Specification.) -->
					<label for="national-id" class="control-label">National
						ID: </label>
					<div class="controls">
						<input id="national-id" name="national-id" type="text"
							placeholder="Enter National Id"></input>
					</div>
				</div>
	
				<div class="control-group">
					<!-- Number input (max. 8 characters, as per Functional Specification.) -->
					<label for="national-health-id" class="control-label">National
						Health ID: </label>
					<div class="controls">
						<input id="national-health-id" name="national-health-id"
							type="text" placeholder="Enter National Health Id"></input>
					</div>
				</div>
	
				<div class="control-group">
					<label for="hsa-user-id" class="control-label">HSA User
						ID: </label>
					<div class="controls">
						<input id="hsa-user-id" name="hsa-user-id" type="text"
							placeholder="Enter HSA User Id"></input>
					</div>
				</div>
			</div>
			<!-- end column -->
	
			<div id="assessment-date-container" class="col-lg-6">
				<div class="control-group">
					<!-- assessment date range -->
					<label for="assessment-date-from" class="control-label">From:
					</label>
					<div class="controls">
						<input id="assessment-date-from" name="assessment-date-from"
							class="assessment-datepicker" type="text"
							data-format="dd-MM-yyyy" placeholder="Assessment Date From" />
					</div>
				</div>
				<div class="control-group">
					<label for="assessment-date-to" class="control-label">To:
					</label>
					<div class="controls">
						<input id="assessment-date-to" name="assessment-date-to"
							class="assessment-datepicker" type="text"
							data-format="dd-MM-yyyy" placeholder="Assessment Date To" />
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
						<c:forEach var="symptom" items="${symptoms}">
							<tr>
								<td>${symptom.value}</td>
								<td class="symptom-checkbox-column"><input type="checkbox"
									value="${symptom.key}"></td>
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
						<c:forEach var="classification" items="${classifications}">
							<tr>
								<td>${classification.value}</td>
								<td class="classification-checkbox-column"><input
									type="checkbox" value="${classification.key}"></td>
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
						<c:forEach var="treatment" items="${treatments}">
							<tr>
								<td>${treatment.value.treatment}</td>
								<td>${treatment.value.associatedClassification}</td>
								<td class="treatment-checkbox-column"><input
									type="checkbox" value="${treatment.key}"></td>
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
	</form>
</div><!--  END: report-ccm-container -->


<!--  Include 'sl_ccm_custom_report_footer' footer -->
<%@include file="footers/sl_ccm_custom_report_footer.jspf"%>

<!--  Include SL footer -->
<%@include file="footers/sl_footer.jspf"%>