<%--  Include SL Header --%>
<%@include file="headers/sl_header.jspf"%>
<%--  Include 'sl_news' header --%>
<%@include file="headers/sl_news_header.jspf"%>

<%--  Include sl_header (i.e. main navigation bar) --%>
<jsp:include page="sl_top_level_navigation.jsp" />

<div id="news-container" class="container">

	<!-- coloured banner to maintain visual consistency from carousel -->
	<!-- screen to reporting screens -->
	<div class="row-fluid">
		<div class="span12 item">
			<div id="sl-news-banner" class="box"></div>
		</div>
	</div>

	<h1>Latest News</h1>	
			
	<!-- =========================================== FEATURETTES ================================================= -->

	<c:forEach items="${newsItems}" var="newsItem">
		<hr class="featurette-divider">
		
		<div class="row featurette">
			<div id="knowledge-base-icon-container" class="col-md-5">
				<img src="${newsItem.pictureStringFormat}"/>
			</div>
			<div class="col-md-7">
				<h2>${newsItem.headline}</h2>
				<h3>
					<span class="text-muted">${newsItem.newsDate}</span>
				</h3>
				<br>
				<p class="lead">
					${newsItem.entry}
				</p>
			</div>
		</div>
	</c:forEach>
	<!-- /END THE FEATURETTES -->

</div>

<!--  Include 'sl_news' footer -->
<%@include file="footers/sl_news_footer.jspf"%>

<!--  Include SL footer -->
<%@include file="footers/sl_footer.jspf"%>