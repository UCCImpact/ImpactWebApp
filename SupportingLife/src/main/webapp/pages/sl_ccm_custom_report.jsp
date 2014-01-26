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

	<!-- Canvas to maintain visual consistency from carousel -->
	<!-- screen to reporting screens -->
 	<canvas id="sl-report-canvas"></canvas>
	
	<h1>CCM Custom Report</h1>
	 	        
 	<form method="POST" action="" class="form-horizontal" id="ccm-report-form">	        
		<!-- three columns for user/patient identifier input -->
		<div class="row">
			<div id="patient-identifier-container" class="col-lg-6">
				<div class="control-group">
					<!-- Number input (max. 8 characters, as per Functional Specification.) -->
					<label for="national-id" class="control-label">National ID: </label>
					<div class="controls">
						<input id="national-id" name="national-id" type="text" placeholder="Enter National Id"></input>
					</div>
				</div>
			
				<div class="control-group">
					<!-- Number input (max. 8 characters, as per Functional Specification.) -->
					<label for="national-health-id" class="control-label">National Health ID: </label>
					<div class="controls">
						<input id="national-health-id" name="national-health-id" type="text" placeholder="Enter National Health Id"></input>
					</div>
				</div>

				<div class="control-group">
					<label for="hsa-user-id" class="control-label">HSA User ID: </label>
					<div class="controls">
						<input id="hsa-user-id" name="hsa-user-id" type="text" placeholder="Enter HSA User Id"></input>
					</div>
				</div>
			</div> <!-- end column -->

			<div id="assessment-date-container" class="col-lg-6">
				<div class="control-group">
					<!-- assessment date range -->
					<label for="assessment-date-from" class="control-label">From: </label>
					<div class="controls">
						<input id="assessment-date-from" name="assessment-date-from" class="assessment-datepicker" type="text" data-format="dd-MM-yyyy" placeholder="Assessment Date From"/>
					</div>
				</div>
				<div class="control-group">
					<label for="assessment-date-to" class="control-label">To: </label>
					<div class="controls">
						<input	id="assessment-date-to" name="assessment-date-to" class="assessment-datepicker" type="text" data-format="dd-MM-yyyy" placeholder="Assessment Date To"/>
					</div>
				</div>
			</div> <!-- end column -->
		</div> <!-- end row -->

		<!-- classification list -->
		<div id="checkbox-list-container" class="row">
			<div class="col-lg-4 sl-table-container">
				<table class="table-hover sl-table">
					<thead>
						<tr>
							<th>CLASSIFICATION</th>
							<th>SELECT</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="classification" items="${classifications}">
							<tr>
								<td>${classification.value} </td>
								<td> <input type="checkbox" value="${classification.key}"> </td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<div class="col-lg-4">
			</div>
			<div class="col-lg-4">
			</div>
		</div> <!-- end row -->
		
        <div class="form-actions">
            <input type="hidden" name="save" value="contact">
            <button type="submit" class="btn btn-success">Submit</button>
            <button type="reset" class="btn">Cancel</button>
        </div>
	</form>
</div> <!--  END: report-ccm-container --> 


<!--  Include 'sl_ccm_custom_report_footer' footer -->
<%@include file="footers/sl_ccm_custom_report_footer.jspf"%>

<!--  Include SL footer -->
<%@include file="footers/sl_footer.jspf"%>