<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<div class="page-box" id="loadPage">
	<div style="margin-top: 200px;">
		<img alt="Loading" src='<spring:url value="/resources/images/ajax-loader.gif"/>'>
	</div>
</div>

<script type="text/javascript">
$(function(){
	$('form[name=dataForm]').submit(function(){
		$('#loadPage').show();
	});
	$('#viewDataBtn').click(function(){
		$('#loadPage').show();
	});
});

</script>