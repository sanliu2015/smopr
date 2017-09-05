<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>用户信息</title>
	<meta name="decorator" content="form"/>
</head>
<body>
	<%-- form:form id="inputForm" modelAttribute="user" class="form-horizontal" style="padding-top:10px;">
		<form:hidden path="id"/>
		<div class="form-group">
			<label class="col-sm-2 control-label ">用户名：</label>
			<div class="col-sm-8">
				<p class="form-control-static">${user.loginName}</p>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label ">姓名：</label>
			<div class="col-sm-8">
				<p class="form-control-static">${user.name}</p>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label ">邮箱：</label>
			<div class="col-sm-8">
				<p class="form-control-static">${user.email}</p>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label ">电话：</label>
			<div class="col-sm-8">
				<p class="form-control-static">${user.phone}</p>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label ">手机号：</label>
			<div class="col-sm-8">
				<p class="form-control-static">${user.mobile}</p>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label ">上次登录：</label>
			<div class="col-sm-8">
				<p class="form-control-static">
				IP: ${user.oldLoginIp}&nbsp;&nbsp;&nbsp;&nbsp;时间：<fmt:formatDate value="${user.oldLoginDate}" type="both" dateStyle="full"/>
				</p>
			</div>
		</div>
		<div class="bottomBtn">
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="closeCurrentLayer();"/>
		</div>
	</form:form> --%>
	<div class="container-fluid" style="padding-top:10px;">
		<div class="row border-bottom">
		    <div class="col-xs-4 txt-right">用户名：</div>
		    <div class="col-xs-6">${user.loginName}</div>
	  	</div>
	  	<div class="row border-bottom">
		    <div class="col-xs-4 txt-right">姓名：</div>
		    <div class="col-xs-6">${user.name}</div>
	  	</div>
	  	<div class="row border-bottom">
		    <div class="col-xs-4 txt-right">邮箱：</div>
		    <div class="col-xs-6">${user.phone}</div>
	  	</div>
	  	<div class="row border-bottom">
		    <div class="col-xs-4 txt-right">电话：</div>
		    <div class="col-xs-6">${user.phone}</div>
	  	</div>
	  	<div class="row border-bottom">
		    <div class="col-xs-4 txt-right">手机：</div>
		    <div class="col-xs-6">${user.mobile}</div>
	  	</div>
	  	<div class="row border-bottom">
		    <div class="col-xs-4 txt-right">上次登录：</div>
		    <div class="col-xs-6">IP: ${user.oldLoginIp}&nbsp;&nbsp;&nbsp;&nbsp;时间：<fmt:formatDate value="${user.oldLoginDate}" type="both" dateStyle="full"/></div>
	  	</div>
	</div>
		<div class="bottomBtn">
			<input id="btnCancel" class="btn btn-default" type="button" value="返 回" onclick="closeCurrentLayer();"/>
		</div>
</body>
</html>