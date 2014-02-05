<%-- sl_ccm_report_results.jsp --%>
<%-- CCM Report Results Page. --%>
<%-- Author: Timothy O' Sullivan --%>
<%-- Last Updated: 04/02/2014. --%>

<%--  Include SL Header --%>
<%@include file="headers/sl_header.jspf"%>

<%--  Include 'sl_ccm_custom_report_results_header' header --%>
<%@include file="headers/sl_ccm_custom_report_results_header.jspf"%>

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

	<h1 class="animated fadeInDown">CCM <i id="header-icon" class="fa fa-dot-circle-o"></i>
	  RESULTS</h1>
	  
	  <div class="wrap">
	  <span id="animationSandbox" style="display: block;">
	  	<h2>Animate.css</h2></span>
		</div>
	<img src="../images/supporting_life_logo.jpg" id="header-image" />


<div class="animated rotateIn"> content</div>



	<table border="1">
		<tr>
			<td>Patient ID</td>
			<td>National ID</td>
			<td>National Health ID</td>
			<td>Patient Name</td>
			<td>Patient Visit Date</td>
		</tr>
		<c:forEach var="patientVisit" items="${patientVisits}">
			<tr>
				<td>${patientVisit.patient.patientId}</td>
				<td><c:out value="${patientVisit.patient.childFirstName}"/> <c:out value="${patientVisit.patient.childSurname}"/></td>
				<td>${patientVisit.patient.nationalId}</td>
				<td>${patientVisit.patient.nationalHealthId}</td>
				<td>${patientVisit.visitDate}</td>
			</tr>
		</c:forEach>
	</table>
	
	<button class="butt js--triggerAnimation">Animate it</button>
	
</div><!--  END: report-ccm-container -->

<!--  Include 'sl_ccm_custom_report_results_footer' footer -->
<%@include file="footers/sl_ccm_custom_report_results_footer.jspf"%>

<script>
  function testAnim(x) {
    $('#animationSandbox').removeClass().addClass(' animated').one('webkitAnimationEnd mozAnimationEnd MSAnimationEnd oanimationend animationend', function(){
      $(this).removeClass();
    });
  };

  $(document).ready(function(){
    $('.js--triggerAnimation').click(function(){
      var anim = $('.js--animations').val();
      testAnim("pulse");
    });

    $('.js--animations').change(function(){
      var anim = $(this).val();
      testAnim(anim);
    });
  });

</script>

<!--  Include SL footer -->
<%@include file="footers/sl_footer.jspf"%>
