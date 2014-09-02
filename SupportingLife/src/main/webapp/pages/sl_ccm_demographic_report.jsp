<%-- sl_ccm_demographic_report.jsp --%>
<%-- CCM Demographic Report Generation Page. --%>
<%-- Author: Timothy O'Sullivan --%>
<%-- Last Updated: 02/09/2014. --%>

<%--  Include SL Header --%>
<%@include file="headers/sl_header.jspf"%>

<%--  Include 'sl_ccm_demographic_report_header' header --%>
<%@include file="headers/sl_ccm_demographic_report_header.jspf"%>

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

	<h1>CCM Demographic Search</h1>
	
	<!-- using accordion to display sticky post-it note about the ccm demographic report -->
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
	
	<!-- CCM Demographic report form -->
	<form:form method="POST" action="../reports/ccm_demographic_report" modelAttribute="ccmDemographicFormBean" class="form-horizontal" id="ccm-demographic-report-form">
		<!-- three columns for user/patient identifier input -->
		<div class="row">
			<div id="patient-identifier-container" class="col-lg-6">
				<div class="control-group">
					<!-- Number input (max. 8 characters, as per Functional Specification.) -->
					<form:label for="patient-id" class="control-label" path="patientId">SL Patient ID: </form:label>
					<div class="controls">
						<form:input type="text" path="patientId" placeholder="Enter SL Patient Id"/>
					</div>
				</div>
			
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
			</div>
			<!-- end column -->
	
			<div id="right-side-container" class="col-lg-6">
				<div class="control-group">
					<form:label for="hsa-user-id" class="control-label" path="hsaUserId">HSA User ID: </form:label>
					<div class="controls">
						<form:input type="text"	path="hsaUserId" placeholder="Enter HSA User Id"/>
					</div>
				</div>
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
	
		<div class="form-actions">
			<input type="hidden" name="save" value="contact">
			<button id="submit-button" type="submit" class="btn btn-success">Submit</button>
			<button id="reset-button" type="reset" class="btn">Reset</button>
		</div>
	</form:form>
</div><!--  END: ccm-demographic-report-form -->

<!--  Include 'sl_ccm_demographic_report_footer' footer -->
<%@include file="footers/sl_ccm_demographic_report_footer.jspf"%>

<!--  Include SL footer -->
<%@include file="footers/sl_footer.jspf"%>