<%-- sl_ccm_treatment_report.jsp --%>
<%-- CCM Treatment Report Generation Page. --%>
<%-- Author: Timothy O'Sullivan --%>
<%-- Last Updated: 26/01/2014. --%>

<%--  Include SL Header --%>
<%@include file="headers/sl_header.jspf"%>

<%--  Include 'sl_ccm_treatment_report_header' header --%>
<%@include file="headers/sl_ccm_treatment_report_header.jspf"%>

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

	<h1>CCM Treatment Search</h1>
	
	<!-- using accordion to display sticky post-it note about the ccm treatment report -->
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
	<form:form method="POST" action="../reports/ccm_treatment_report" modelAttribute="ccmTreatmentFormBean" class="form-horizontal" id="ccm-treatment-report-form">	
		<!-- treatment list -->
		<div id="checkbox-list-container" class="row">
			<div id="treatment-list" class="col-lg-12 sl-table-container">
				<table id="treatment-table" class="table-hover table-striped sl-table">
					<thead>
						<tr>
							<th>TREATMENT</th>
							<th>CATEGORY</th>
							<th>SELECT</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${ccmTreatmentFormBean.treatments}" var="treatment" varStatus="status">
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


<!--  Include 'sl_ccm_treatment_report_footer' footer -->
<%@include file="footers/sl_ccm_treatment_report_footer.jspf"%>

<!--  Include SL footer -->
<%@include file="footers/sl_footer.jspf"%>