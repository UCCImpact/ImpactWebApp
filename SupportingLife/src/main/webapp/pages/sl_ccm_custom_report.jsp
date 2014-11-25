<%-- sl_ccm_custom_report.jsp --%>
<%-- CCM Custom Report Generation Page. --%>
<%-- Author: Timothy O'Sullivan --%>
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

	<div id="user-welcome" class="row">
		<div class="col-lg-9"></div>
		<div class="col-lg-3">
			<sec:authorize access="isAuthenticated()">
				<h1>Welcome User:&nbsp;&nbsp;<span id="user-identifier"><sec:authentication property="principal.username"/></span></h1>
			</sec:authorize>
		</div>
	</div>

	<h1>CCM Report</h1>

	<!-- ====================================== MARKETING MESSAGING  ======================================== -->
	<!-- Wrap the rest of the page in another container to center all the content. -->
	
	<div class="container marketing">
	
		<!-- Three columns of text below the carousel -->
		<div class="row">
			<div class="report-icon-container col-md-4">
				<a href="${pageContext.request.contextPath}/reports/ccm_demographic_report_form">
					<i id="demographic-icon" class="fa fa-group"></i>
					<br> 
					<span class="text-muted"> Demographic Search </span>
				</a>
			</div>
			<div class="report-icon-container col-md-4">
				<a href="${pageContext.request.contextPath}/reports/ccm_symptom_classification_report_form">
					<i id="symptom-classification-icon" class="fa fa-plus-square"></i>
					<br> 
					<span class="text-muted"> Symptom / Classification Search </span>
				</a>
			</div>
			<div class="report-icon-container col-md-4">
				<a href="${pageContext.request.contextPath}/reports/ccm_treatment_report_form">
					<i id="treatment-icon" class="fa fa-stethoscope"></i>
					<br> 
					<span class="text-muted"> Treatment Search </span>
				</a>
			</div>
		</div>
	</div>
</div><!--  END: report-ccm-container -->


<!--  Include 'sl_ccm_custom_report_footer' footer -->
<%@include file="footers/sl_ccm_custom_report_footer.jspf"%>

<!--  Include SL footer -->
<%@include file="footers/sl_footer.jspf"%>