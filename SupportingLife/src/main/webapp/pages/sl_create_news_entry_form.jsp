<%-- sl_create_news_entry_form.jsp --%>
<%-- SL Create News Entry Form --%>
<%-- Author: Timothy O'Sullivan --%>
<%-- Last Updated: 13/12/2014. --%>

<%--  Include SL Header --%>
<%@include file="headers/sl_header.jspf"%>

<%--  Include 'sl_create_news_entry_form_header' header --%>
<%@include file="headers/sl_create_news_entry_form_header.jspf"%>

<%--  Include sl_header (i.e. main navigation bar) --%>
<jsp:include page="sl_top_level_navigation.jsp" /> 

<div id="news-entry-creation-container" class="container">

	<!-- coloured banner to maintain visual consistency from carousel -->
	<!-- screen to reporting screens -->
	<div class="row-fluid">
		<div class="span12 item">
			<div id="sl-banner" class="box"></div>
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

	<h1 id="page-header-title">Create SL News Entry</h1>
		
	<!-- User Creation Form -->
	<form:form method="POST" action="../media/create_news_entry" enctype="multipart/form-data" modelAttribute="newsEntryCreationForm" class="form-horizontal" id="news-entry-creation-form">
		<div class="row col-md-12">
			<div class="col-md-offset-4">
				<div class="control-group input-group">
					<div class="controls">	
						<span><form:label for="headline" class="control-label" path="headline">Headline: </form:label></span>
						<span><form:input type="text" path="headline" placeholder="Enter Headline"/></span>
					</div>
				</div>
				<div class="control-group input-group">		
					<div class="controls">
						<span><label for="entry" class="control-label" id="entryLabel">Entry: </label></span>
						<span><form:textarea path="entry" rows="5" placeholder="Enter Details"/></span>
					</div>
				</div>
				<div class="control-group input-group">
					<div class="controls">
						<!-- news date -->
						<form:label for="news-date" class="control-label" path="newsDate">Date: </form:label>
						<form:input class="news-datepicker" data-format="dd-MM-yyyy" path="newsDate" placeholder="News Date" />
					</div>
				</div>
				<div class="control-group input-group">
					<!-- picture -->
					<div class="controls">
						<span><form:label for="picture" class="control-label" path="picture">Image: </form:label></span>
						<span><form:input type="file" path="picture" placeholder="Upload"/></span>
					</div>
				</div>
			</div>
		</div> <!-- end row -->
		<div class="form-actions">
			<input type="hidden" id="newsEntryCreated" value="${newsEntryCreated}">
			<button id="submit-button" type="submit" class="btn btn-success">Create</button>
			<button id="reset-button" type="reset" class="btn">Reset</button>
		</div>
	</form:form>

</div><!--  END: news-entry-creation-form -->

<!--  Include 'sl_create_news_entry_footer' footer -->
<%@include file="footers/sl_create_news_entry_form_footer.jspf"%>

<!--  Include SL footer -->
<%@include file="footers/sl_footer.jspf"%>