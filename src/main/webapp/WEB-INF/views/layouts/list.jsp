<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<%@ taglib prefix="sitemesh" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<!DOCTYPE html>
<%-- <html style="overflow-x:auto;overflow-y:auto;"> --%>
<html>
<head>
	<meta name="renderer" content="webkit">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
	<meta http-equiv="Expires" content="0">
	<meta http-equiv="Cache-Control" content="no-cache">
	<meta http-equiv="Cache-Control" content="no-store">
	<title><sitemesh:title/></title>
	<!-- CSS -->
	<link href="${ctxStatic}/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
	<link href="${ctxStatic}/bootstrap/3.3.6/css/font-awesome.min.css" rel="stylesheet">
	<link href="${ctxStatic}/jquery-select2/4.0.3/css/select2.min.css" rel="stylesheet">
	<link href="${ctxStatic}/jquery-select2/4.0.3/css/select2-bootstrap.min.css" rel="stylesheet">
	<link href="${ctxStatic}/layui/css/layui.css" rel="stylesheet">
	<link href="${ctxStatic}/bootstrap-jqgrid/ui.jqgrid-bootstrap.css" rel="stylesheet">
	<link href="${ctxStatic}/common/ynjf.css" rel="stylesheet">
	<!-- JS -->
	<script src="${ctxStatic}/jquery/jquery-2.2.4.min.js" type="text/javascript"></script>
	<script src="${ctxStatic}/json2/json2.js" type="text/javascript"></script>
	<script src="${ctxStatic}/jquery-form/jquery.form.min.js" type="text/javascript"></script>
	<script src="${ctxStatic}/jquery-validation/1.17.0/jquery.validate.min.js"></script>
	<script src="${ctxStatic}/jquery-validation/1.17.0/localization/messages_zh.min.js"></script>
	<script src="${ctxStatic}/My97DatePicker/WdatePicker.js" type="text/javascript"></script>
	<script src="${ctxStatic}/bootstrap/3.3.6/js/bootstrap.min.js" type="text/javascript"></script>
	<script src="${ctxStatic}/bootstrap-jqgrid/jquery.jqGrid.min.js"></script>
	<script src="${ctxStatic}/bootstrap-jqgrid/grid.locale-cn.js"></script>
	<script src="${ctxStatic}/layui/layui.js"></script>
	<script src="${ctxStatic}/jquery-select2/4.0.3/js/select2.full.min.js"></script>
	<script src="${ctxStatic}/jquery-select2/4.0.3/js/zh-CN.js"></script>
	<script src="${ctxStatic}/common/ynjf.js"></script>
	<!--[if lt IE 9]>
	<script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
	<script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
	<![endif]-->
	<script type="text/javascript">
	var ctx = "${ctx}";
	var ctxStatic = "${ctxStatic}";
	</script>	
	<sitemesh:head/>
</head>
<body>
	<sitemesh:body/>
	<%-- <script type="text/javascript">
	layui.use('layer', function() {
		var layer = layui.layer;
	});    
	</script> --%>
</body>
</html>