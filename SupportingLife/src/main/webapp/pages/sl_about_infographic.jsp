<%-- sl_about_infographic.jsp --%>
<%-- About 'Infographic' Page. --%>
<%-- Author: Timothy O'Sullivan --%>
<%-- Last Updated: 04/09/2014. --%>

<%--  Include SL Header --%>
<%@include file="headers/sl_header.jspf"%>

<%--  Include 'sl_about_infographic_header' header --%>
<%@include file="headers/sl_about_infographic_header.jspf"%>

<%--  Include sl_header (i.e. main navigation bar) --%>
<jsp:include page="sl_top_level_navigation.jsp" /> 

<div id="sl-about-infographic-container" class="container">

	<!-- coloured banner to maintain visual consistency from carousel -->
	<!-- screen to reporting screens -->
	<div class="row-fluid">
		<div class="span12 item">
			<div id="sl-report-banner" class="box"></div>
		</div>
	</div>

	<h1>Supporting LIFE</h1>

	<h3>Reshaping eHealth</h3>

	<div class="col-xs-12 fluid">
		<!-- SL Infographic -->
		<div class="col-xs-1"></div>
		<div id="sl-infographic-container" class="col-xs-10">
			<iframe id="sl-infographic-graphic" class="iframe" src="http://sharp-shooter-powders-77413.bitballoon.com/"></iframe>
		</div>
		<div class="col-xs-1"></div>
	</div>
	<p id="graphic-creation-text" class="lead">
		infographic created by accelopment
	</p>
</div>

<!--  Include 'sl_about_infographic_footer' footer -->
<%@include file="footers/sl_about_infographic_footer.jspf"%>

<!--  Include SL footer -->
<%@include file="footers/sl_footer.jspf"%>