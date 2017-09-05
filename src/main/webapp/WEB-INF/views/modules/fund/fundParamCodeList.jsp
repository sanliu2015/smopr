<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>字典明细管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			
		});
		function page(n,s){
			$("#pageNo").val(n);
			$("#pageSize").val(s);
			$("#searchForm").submit();
        	return false;
        }
	</script>
</head>
<body style="padding:10px;">
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/fund/fundParamCode/dictCode=${fundParamCode.dictCode}">字典明细列表</a></li>
		<shiro:hasPermission name="fund:fundParamCode:edit"><li><a href="${ctx}/fund/fundParamCode/form?dictCode=${fundParamCode.dictCode}">字典明细添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="fundParamCode" action="${ctx}/fund/fundParamCode/" method="post" class="breadcrumb form-search">
		<form:hidden path="dictCode" />
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>代码：</label>
				<form:input path="code" htmlEscape="false" maxlength="200" class="input-medium"/>
			</li>
			<li><label>名称：</label>
				<form:input path="name" htmlEscape="false" maxlength="50" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>字典代码</th>
				<th>代码</th>
				<th>名称</th>
				<shiro:hasPermission name="fund:fundParamCode:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="fundParamCode">
			<tr>
				<td>
					${fundParamCode.dictCode}
				</td>
				<td><a href="${ctx}/fund/fundParamCode/form?id=${fundParamCode.id}">
					${fundParamCode.code}
				</a></td>
				<td>
					${fundParamCode.name}
				</td>
				<shiro:hasPermission name="fund:fundParamCode:edit"><td>
    				<a href="${ctx}/fund/fundParamCode/form?id=${fundParamCode.id}">修改</a>
					<a href="${ctx}/fund/fundParamCode/delete?id=${fundParamCode.id}" onclick="return confirmx('确认要删除该字典明细吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>