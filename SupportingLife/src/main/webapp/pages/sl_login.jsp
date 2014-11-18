<%-- sl_login.jsp --%>
<%-- SL Login Form --%>
<%-- Author: Timothy O'Sullivan --%>
<%-- Last Updated: 18/11/2014. --%>

<%--  Include SL Header --%>
<%@include file="headers/sl_header.jspf"%>

<%--  Include 'sl_login_header' header --%>
<%@include file="headers/sl_login_header.jspf"%>

<%--  Include sl_header (i.e. main navigation bar) --%>
<jsp:include page="sl_top_level_navigation.jsp" /> 

<div id="login-container" class="container">

	<!-- coloured banner to maintain visual consistency from carousel -->
	<!-- screen to login screen -->
	<div class="row-fluid">
		<div class="span12 item">
			<div id="sl-login-banner" class="box"></div>
		</div>
	</div>

	<h1>Supporting LIFE</h1>
		
	<!-- SL Login Form -->
	<spring:url var="authUrl" value="/static/j_spring_security_check"/>
	<form id="login-form" class="signin form-horizontal" action="${authUrl}" method="post">
		<div class="row">
			<div class="col-lg-12">
				<div class="control-group">
					<label for="username" class="control-label">User Name </label>
					<div class="controls">
						<input id="username" type="text" name="j_username" placeholder="Enter SL Username"/>
					</div>
				</div>
			</div>
			<div class="col-lg-12">
				<div class="control-group">
					<label for="password" class="control-label">Password </label>
					<div class="controls">
						<input id="password" type="password" name="j_password" placeholder="Enter Password"/>
					</div>
				</div>
			</div>
			<div class="col-lg-12">
				<input id="remember_me" type="checkbox" name="_spring_security_remember_me">
				<label for="remember_me" class="inline">Remember me</label>
			</div>
		</div>
		<div class="form-actions">
			<input type="hidden" name="save" value="contact">
			<button id="submit-button" name="commit" type="submit" class="btn btn-success">Sign In</button>
			<button id="reset-button" type="reset" class="btn">Reset</button>
		</div>			
	</form>

</div><!--  END: login-container -->

<!--  Include 'sl_login_footer' footer -->
<%@include file="footers/sl_login_footer.jspf"%>

<!--  Include SL footer -->
<%@include file="footers/sl_footer.jspf"%>