<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>基金信息管理</title>
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
		<li><a href="${ctx}/fund/fundInfo/">基金信息列表</a></li>
		<li class="active"><a href="${ctx}/fund/fundInfo/form?id=${fundInfo.id}">基金信息<shiro:hasPermission name="fund:fundInfo:edit">${not empty fundInfo.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="fund:fundInfo:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="fundInfo" action="${ctx}/fund/fundInfo/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>		
		<div class="control-group">
			<label class="control-label">基金代码：</label>
			<div class="controls">
				<form:input path="fundCode" htmlEscape="false" maxlength="10" class="input-xlarge required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">基金名称：</label>
			<div class="controls">
				<form:input path="fundName" htmlEscape="false" maxlength="500" class="input-xlarge required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">管理人：</label>
			<div class="controls">
				<form:input path="fundHandler" htmlEscape="false" maxlength="500" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">托管人：</label>
			<div class="controls">
				<form:input path="fundTrustee" htmlEscape="false" maxlength="500" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">基金运作方式：</label>
			<div class="controls">
				<form:input path="fundOperMode" htmlEscape="false" maxlength="500" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">基金类型 证券 股权 创投 其他：</label>
			<div class="controls">
				<form:input path="fundType" htmlEscape="false" maxlength="500" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">投资范围：</label>
			<div class="controls">
				<form:input path="inveScope" htmlEscape="false" maxlength="500" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">是否FOF：</label>
			<div class="controls">
				<form:input path="isFof" htmlEscape="false" maxlength="500" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">投资风格：</label>
			<div class="controls">
				<form:input path="inveForm" htmlEscape="false" maxlength="500" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">基金成立日：</label>
			<div class="controls">
				<input name="fundSdate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate "
					value="<fmt:formatDate value="${fundInfo.fundSdate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">存续期：</label>
			<div class="controls">
				<form:input path="duration" htmlEscape="false" maxlength="11" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">业绩基准：</label>
			<div class="controls">
				<form:input path="perfBenc" htmlEscape="false" maxlength="500" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">是否分级：</label>
			<div class="controls">
				<form:input path="isClassify" htmlEscape="false" maxlength="8" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">业绩报酬计提方式：</label>
			<div class="controls">
				<form:input path="repayType" htmlEscape="false" maxlength="500" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">业绩报酬的业绩基准：</label>
			<div class="controls">
				<form:input path="repayPerfBenc" htmlEscape="false" maxlength="500" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">业绩报酬计提比例：</label>
			<div class="controls">
				<form:input path="repayPro" htmlEscape="false" maxlength="18" class="input-xlarge  digits"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">投资顾问：</label>
			<div class="controls">
				<form:input path="fundAdvisor" htmlEscape="false" maxlength="500" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">净值披露周期：</label>
			<div class="controls">
				<form:input path="netValueCycle" htmlEscape="false" maxlength="500" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">是否清算结束：</label>
			<div class="controls">
				<form:input path="isClear" htmlEscape="false" maxlength="8" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">清算日期：</label>
			<div class="controls">
				<input name="fundClearDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate "
					value="<fmt:formatDate value="${fundInfo.fundClearDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">数据开始时间：</label>
			<div class="controls">
				<input name="sdate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate "
					value="<fmt:formatDate value="${fundInfo.sdate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">数据截止时间：</label>
			<div class="controls">
				<input name="edate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate "
					value="<fmt:formatDate value="${fundInfo.edate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">数据来源 0-GP3WH 1-导入 2-公开市场 3-GFOP：</label>
			<div class="controls">
				<form:input path="dataSource" htmlEscape="false" maxlength="1" class="input-xlarge "/>
			</div>
		</div>
		<div class="form-actions">
			<shiro:hasPermission name="fund:fundInfo:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>