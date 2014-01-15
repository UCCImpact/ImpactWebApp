<%-- sl_ccm_custom_report.jsp --%>
<%-- CCM Custom Report Generation Page. --%>
<%-- author: James Flynn --%>
<%-- Last Updated: 09/01/2014. --%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%-- JSTL FMT supports time, number and localisation formats. --%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"
	prefix="fmt"%>
<%-- JSTL Functions allow for String manipulation. --%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<html lang="en">
<!--  Include Top Level Menu Bar -->
<%@include file="sl_header.jspf"%>
<!--  Include sl_ccm_custom_report header -->
<%@include file="sl_ccm_custom_report.jspf"%>

<!--  Include sl_header (i.e. main Toolbar) -->
<jsp:include page="sl_header.jsp" />

<!-- CCM Custom Report Body -->
<div class="report_ccm_container">
	<h1>CCM Custom Report</h1>

	<form>
		<div class="report_ccm_id">
			<table class="input_table">
				<tr>
					<!-- Number input, maximum value = 1, minimum value = 10000000 (max. 8 characters, as per Functional Specification.) -->
					<td>National ID: <input type="number" min="0" max="10000000"></td>
					<td>National Health ID: <input type="number" min="0"
						max="10000000"></td>
					<td>HSA User: <input type="text"></td>
				</tr>
			</table> <!-- END: input table -->
		</div> <!--  END: report_ccm_id -->

		<div class="report_ccm_dates">
			<table class="input_table">
				<tr>
					<td>Assessment Date Range:</td>
					<!-- HTML5 date picker, not compatible with Firefox or IE. -->
					<td><span id="report_ccm_dates_from">From: <input
							type="text" class="datepicker"></span></td>
					<td><span id="report_ccm_dates_to">To: <input
							type="text" class="datepicker"></span></td>
				</tr>
			</table> <!-- END: input table -->
		</div> <!--  END: report_ccm_dates -->

		<div class="report_ccm_checkbox_lists">
			<div class="report_ccm_checkbox_list">
				<table>
					<tr class="report_ccm_checkbox_list_header">
						<td>'ASK and LOOK Assessment' Symptoms</td>
					</tr>
					<c:forEach var="askLookSymptom" items="${askLookSymptoms}">
						<tr>
							<td>${askLookSymptom.value} <input type="checkbox"
								value="${askLookSymptom.key}">
							</td>
						</tr>
					</c:forEach>
				</table> <!--  END: checkbox table -->
			</div> <!--  END: report_ccm_ask_look -->

			<div class="report_ccm_checkbox_list">	
				<table>
					<tr class="report_ccm_checkbox_list_header">
						<td>Classifications</td>
					</tr>
					<c:forEach var="classification" items="${classifications}">
						<tr>
							<td>${classification.value} <input type="checkbox"
								value="${classification.key}">
							</td>
						</tr>
					</c:forEach>
				</table> <!--  END: checkbox table -->
			</div> <!--  END: report_ccm_classification -->

			<div class="report_ccm_checkbox_list">
				<table>
					<tr class="report_ccm_checkbox_list_header">
						<td>Classification Types</td>
					</tr>
					<c:forEach var="classificationType" items="${classificationTypes}">
						<tr>
							<td>${classificationType.value} <input type="checkbox"
								value="${classificationType.key}">
							</td>
						</tr>
					</c:forEach>
				</table> <!--  END: checkbox table -->
			</div> <!--  END: report_ccm_classification_types -->
		</div> <!--  END: report_checkbox_lists -->

		<div class="report_ccm_generate_report">
			<input type="submit" id="generate_excel_button"
				value="Generate Excel Report"> <input type="submit"
				id="generate_pdf_button" value="Generate PDF Report"> <input
				type="reset" id="clear_fields_button" value="Clear Fields">
		</div>
		<!--  END: report_ccm_generate_report -->
	</form>
	<!-- END: form containing all fields -->
</div>
<!--  END: report_ccm_container -->
</body>
</html>