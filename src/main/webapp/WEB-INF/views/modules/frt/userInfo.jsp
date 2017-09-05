<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>用户信息</title>
	<meta name="decorator" content="form"/>
</head>
<body>
	<form:form id="inputForm" modelAttribute="user" class="form-horizontal" style="padding-top:10px;">
		<form:hidden path="id"/>
		<div class="form-group">
			<label class="control-label col-sm-2">用户名：</label>
			<div class="col-sm-10">
				<p class="form-control-static">${user.loginName}</p>
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2">姓名：</label>
			<div class="col-sm-10">
				<p class="form-control-static">${user.name}</p>
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2">邮箱：</label>
			<div class="col-sm-10">
				<p class="form-control-static">${user.email}</p>
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2">电话：</label>
			<div class="col-sm-10">
				<p class="form-control-static">${user.phone}</p>
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2">手机号：</label>
			<div class="col-sm-10">
				<p class="form-control-static">${user.mobile}</p>
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2">上次登录：</label>
			<div class="col-sm-10">
				<p class="form-control-static">
				IP: ${user.oldLoginIp}&nbsp;&nbsp;&nbsp;&nbsp;时间：<fmt:formatDate value="${user.oldLoginDate}" type="both" dateStyle="full"/>
				</p>
			</div>
		</div>
		<div class="bottomBtn">
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="closeCurrentLayer();"/>
		</div>
	</form:form>
</body>
</html>