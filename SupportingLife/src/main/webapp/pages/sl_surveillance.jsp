<%-- sl_surveillance.jsp --%>
<%-- SL Disease Surveillance Page. --%>
<%-- Author: Timothy O' Sullivan --%>
<%-- Last Updated: 21/07/2014. --%>

<%--  Include SL Header --%>
<%@include file="headers/sl_header.jspf"%>

<%--  Include 'sl_surveillance_header' header --%>
<%@include file="headers/sl_surveillance_header.jspf"%>

<%--  Include sl_header (i.e. main navigation bar) --%>
<jsp:include page="sl_top_level_navigation.jsp" /> 

<div id="surveillance-container" class="container">

	<!-- coloured banner to maintain visual consistency from carousel -->
	<!-- screen to reporting screens -->
     <div class="row-fluid">
       <div class="span12 item">
         <div id="sl-report-banner" class="box"></div>
       </div>
      </div>

	<h1>Disease Surveillance</h1>

     <div class="row-fluid">
       <div class="span12 item">
         <div id="sl-surveillance-map-separator" class="box"></div>
       </div>
      </div>

	<div class="row-fluid">
		<div class="span12 item">
			<div id="surveillance-map"></div>
		</div>
	</div>

     <div class="row-fluid">
       <div class="span12 item">
         <div id="sl-surveillance-map-separator" class="box"></div>
       </div>
      </div>

	<div id="surveillance-selection-criteria" class="row">
		<div class="col-lg-6">
			<select id="surveillance-classifications" multiple="multiple">
				<c:forEach items="${classifications}" var="classification" varStatus="status">
					<option value="${classification.key}">${classification.value}</option>
				</c:forEach>
			</select>
		</div>
		<div class="col-lg-6">
		</div>
	</div>

	<div class="form-actions">
		<button id="submit-button" class="btn btn-success">Submit</button>
	</div>

</div><!--  END: surveillance-container -->

<!--  Include 'sl_surveillance_footer' footer -->
<%@include file="footers/sl_surveillance_footer.jspf"%>

<!--  Include SL footer -->
<%@include file="footers/sl_footer.jspf"%>