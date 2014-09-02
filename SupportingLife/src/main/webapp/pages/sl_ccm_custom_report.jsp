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

	<h1>CCM Custom Report</h1>

	<!-- ====================================== MARKETING MESSAGING  ======================================== -->
	<!-- Wrap the rest of the page in another container to center all the content. -->
	
	<div class="container marketing">
	
		<!-- Three columns of text below the carousel -->
		<div class="row">
			<h1>What We Do</h1>
			<div class="col-lg-4">
				<i id="mobile-icon" class="fa fa-cogs"></i>
				<h3>Technological</h3>
				<p class="lead">Enhances user productivity, improves
								healthcare services and increases care
								coordination.</p>
			</div>
			<div class="col-lg-4">
				<i id="healthcare-icon" class="fa fa-plus-square"></i>
				<h3>Clinical Impact</h3>
				<p class="lead">Improves the accuracy of diagnoses, treatment and
					health outcomes by utilising automated, rigorous and robust decision
					support systems.</p>
			</div>
			<div class="col-lg-4">
				<i id="research-icon" class="fa fa-cubes"></i>
				<h3>Research</h3>
				<p class="lead">Investigates the impact of the technology from a user and
								community perspective.</p>
			</div>
		</div>
	</div>
</div><!--  END: report-ccm-container -->


<!--  Include 'sl_ccm_custom_report_footer' footer -->
<%@include file="footers/sl_ccm_custom_report_footer.jspf"%>

<!--  Include SL footer -->
<%@include file="footers/sl_footer.jspf"%>