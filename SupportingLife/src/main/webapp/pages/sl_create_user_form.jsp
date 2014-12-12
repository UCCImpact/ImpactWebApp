<%-- sl_create_user_form.jsp --%>
<%-- SL Create User Form --%>
<%-- Author: Timothy O'Sullivan --%>
<%-- Last Updated: 20/11/2014. --%>

<%--  Include SL Header --%>
<%@include file="headers/sl_header.jspf"%>

<%--  Include 'sl_create_user_form_header' header --%>
<%@include file="headers/sl_create_user_form_header.jspf"%>

<%--  Include sl_header (i.e. main navigation bar) --%>
<jsp:include page="sl_top_level_navigation.jsp" /> 

<div id="user-creation-container" class="container">

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

	<h1 id="page-header-title">Create SL User Account</h1>
		
	<!-- User Creation Form -->
	<form:form method="POST" action="../user/create" modelAttribute="userCreationForm" class="form-horizontal" id="user-creation-form">
		<div class="row col-md-12">
			<div class="col-md-offset-4">
				<div class="control-group input-group">				
					<div class="controls">
						<input type="hidden" id="userIdValid" value="">
						<span><form:label for="user-id" class="control-label" path="userId">Username: </form:label></span>
						<span><form:input type="text" path="userId" placeholder="Enter User Id"/></span>
						<span class="addon"><i id="valid-userid-icon" class="fa fa-thumbs-o-up"></i></span>
						<span class="addon"><i id="invalid-userid-icon" class="fa fa-times"></i></span>
					</div>
				</div>
				
				<div class="control-group input-group">
					<div class="controls">
						<span><form:label for="password" class="control-label" path="password">Password: </form:label></span>
						<span><form:input type="password" path="password" placeholder="Enter Password"/></span>
					</div>
				</div>	
				
				<div class="control-group input-group">
					<div class="controls">
						<span><form:label for="first-name" class="control-label" path="firstName">First Name: </form:label></span>
						<span><form:input type="text"	path="firstName" placeholder="Enter First Name"/></span>
					</div>
				</div>

				<div class="control-group input-group">
					<div class="controls">
						<span><form:label for="surname" class="control-label" path="surname">Surname: </form:label></span>
						<span><form:input type="text" path="surname" placeholder="Enter Surname"/></span>
					</div>
				</div>
				<div class="control-group input-group">
					<div class="controls checkboxes">
						<form:checkbox id="ccmRole" path="ccmRole" class="prettyCheckable"/>
						<form:checkbox id="imciRole" path="imciRole" class="prettyCheckable"/>
						<form:checkbox id="adminRole" path="adminRole" class="prettyCheckable"/>
					</div>
				</div>
			</div>
		</div> <!-- end row -->
		<div class="form-actions">
			<input type="hidden" id="userCreated" value="${userCreated}">
			<button id="submit-button" type="submit" class="btn btn-success">Create</button>
			<button id="reset-button" type="reset" class="btn">Reset</button>
		</div>
	</form:form>

	
</div><!--  END: ccm-demographic-report-form -->

<!--  Include 'sl_create_user_form_footer' footer -->
<%@include file="footers/sl_create_user_form_footer.jspf"%>

<!--  Include SL footer -->
<%@include file="footers/sl_footer.jspf"%>