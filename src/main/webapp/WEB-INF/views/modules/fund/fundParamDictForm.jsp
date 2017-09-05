<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>基金字典管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			//$("#name").focus();
			$("#inputForm").validate({
				submitHandler: function(form){
					loading('正在提交，请稍等...');
					form.submit();
				},
				errorContainer: "#messageBox",
				errorPlacement: function(error, element) {
					$("#messageBox").text("输入有误，请先更正。");
					if (element.is(":checkbox")||element.is(":radio")||element.parent().is(".input-append")){
						error.appendTo(element.parent().parent());
					} else {
						error.insertAfter(element);
					}
				}
			});
		});
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/fund/fundParamDict/">基金字典列表</a></li>
		<li class="active"><a href="${ctx}/fund/fundParamDict/form?id=${fundParamDict.id}">基金字典<shiro:hasPermission name="fund:fundParamDict:edit">${not empty fundParamDict.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="fund:fundParamDict:edit">查看</shiro:lacksPermission></a></li>
		<li><a href="${ctx}/fund/fundParamCode/listDetail/">字典明细列表</a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="fundParamDict" action="${ctx}/fund/fundParamDict/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>		
		<div class="control-group">
			<label class="control-label">字典代码：</label>
			<div class="controls">
				<form:input path="dictCode" htmlEscape="false" maxlength="200" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">字典名称：</label>
			<div class="controls">
				<form:input path="dictName" htmlEscape="false" maxlength="50" class="input-xlarge "/>
			</div>
		</div>
		<div class="form-actions">
			<shiro:hasPermission name="fund:fundParamDict:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>