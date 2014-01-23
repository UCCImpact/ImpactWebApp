<%-- sl_ccm_custom_report.jsp --%>
<%-- CCM Custom Report Generation Page. --%>
<%-- Author: Timothy O' Sullivan, James Flynn --%>
<%-- Last Updated: 23/01/2014. --%>

<%--  Include SL Header --%>
<%@include file="headers/sl_header.jspf"%>

<%--  Include 'sl_ccm_custom_report_header' header --%>
<%@include file="headers/sl_ccm_custom_report_header.jspf"%>

<%--  Include sl_header (i.e. main navigation bar) --%>
<jsp:include page="sl_top_level_navigation.jsp" /> 


<!-- CCM Custom Report Body -->
<div id="report-ccm-container" class="container">
	<h1>CCM Custom Report</h1>
	 	        
	<div class="form-group">
		<!-- three columns for user/patient identifier input -->
		<div id="patient-identifier-container" class="row">
			<div class="col-lg-4">
				<p>
					<!-- Number input, maximum value = 1, minimum value = 10000000 (max. 8 characters, as per Functional Specification.) -->
					<label>National ID: </label>
					<input id="national-id" type="number" min="0" max="10000000" placeholder="Enter National Id"></input>
				</p>
			</div>
			<div class="col-lg-4">
				<p>
					<!-- Number input, maximum value = 1, minimum value = 10000000 (max. 8 characters, as per Functional Specification.) -->
					<label>National Health ID: </label> 
					<input id = "national-health-id" type="number" min="0" max="10000000" placeholder="Enter National Health Id"></input>
				</p>
			</div>
			<div class="col-lg-4">
				<p>
					<label>HSA User ID: </label>
					<input id="hsa-user-id" type="text" placeholder="Enter HSA User Id"></input>
				</p>
			</div>
		</div> <!-- end row -->

		<!-- two columns for assessment date range -->
		<div id="assessment-date-container" class="row">
			<div class="col-lg-6">
				<p>
					<label>From: </label>
					<input id="assessment-date-from" class="assessment-datepicker" type="text" data-format="dd-MM-yyyy" placeholder="Assessment Date From"/>
				</p>
			</div>
			<div class="col-lg-6">
				<p>
					<label>To: </label>
					<input	id="assessment-date-to" class="assessment-datepicker" type="text" data-format="dd-MM-yyyy" placeholder="Assessment Date To"/>
				</p>
			</div>
		</div> <!-- end row -->

		<!-- two columns for assessment date range -->
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




	</div>	<!-- END: form containing all fields --> 
</div> <!--  END: report-ccm-container --> 

<!--  Include 'sl_ccm_custom_report_footer' footer -->
<%@include file="footers/sl_ccm_custom_report_footer.jspf"%>

<!--  Include SL footer -->
<%@include file="footers/sl_footer.jspf"%>