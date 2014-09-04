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

	<div class="form-actions">
		<div id="surveillance-selection-criteria" class="row">
			<div class="col-xs-12">
				<h4>Outbreak Classifications</h4>
				<select id="surveillance-classifications" multiple="multiple">
					<c:forEach items="${classifications}" var="classification" varStatus="status">
						<option value="${classification.key}">${classification.value}</option>
					</c:forEach>
				</select>
			</div>
			<div id="surveillance-time-container" class="col-xs-12 fluid">
				<div id="surveillance-start-container" class="col-xs-5">
					<h4>Surveillance Start Date &amp; Time</h4>
					<div id="surveillanceDateStart" class="col-xs-5 input-group date surveillance-datepicker">
						<input id="surveillanceDateStartTextInput" type='text' class="form-control" placeholder="Surveillance Start Date" />
						<span class="input-group-addon">
							<span class="fa fa-calendar"></span>
						</span>
					</div>
					<div id="surveillanceTimeStart"	class="col-xs-5 input-group bootstrap-timepicker">
						<input id="surveillanceTimeStartTextInput" type='text' class="form-control" />
						<span class="input-group-addon">
							<span class="fa fa-clock-o"></span>
						</span>
					</div>
				</div>
				<div class="col-lg-2"></div>
				<div id="surveillance-end-container" class="col-xs-5">
					<h4>Surveillance End Date &amp; Time</h4>
					<div id="surveillanceDateEnd" class="col-xs-5 input-group date surveillance-datepicker">
						<input id="surveillanceDateEndTextInput" type='text' class="form-control" placeholder="Surveillance End Date" />
						<span class="input-group-addon">
							<span class="fa fa-calendar"></span>
						</span>
					</div>
					<div id="surveillanceTimeEnd" class="col-xs-5 input-group bootstrap-timepicker">
						<input id="surveillanceTimeEndTextInput" type='text' class="form-control" />
						<span class="input-group-addon">
							<span class="fa fa-clock-o"></span>
						</span>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<button id="submit-button" class="btn btn-success">Conduct Surveillance</button>
</div><!--  END: surveillance-container -->

<!--  Include 'sl_surveillance_footer' footer -->
<%@include file="footers/sl_surveillance_footer.jspf"%>

<!--  Include SL footer -->
<%@include file="footers/sl_footer.jspf"%>