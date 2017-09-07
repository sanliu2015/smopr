<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>基金信息披露管理</title>
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
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/fund/fundInfoOpen/">基金信息披露列表</a></li>
		<shiro:hasPermission name="fund:fundInfoOpen:edit"><li><a href="${ctx}/fund/fundInfoOpen/form">基金信息披露添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="fundInfoOpen" action="${ctx}/fund/fundInfoOpen/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>基金代码：</label>
				<form:input path="fundCode" htmlEscape="false" maxlength="50" class="input-medium"/>
			</li>
			<li><label>公告标题：</label>
				<form:input path="noticeTitle" htmlEscape="false" maxlength="500" class="input-medium"/>
			</li>
			<li><label>公告类型：</label>
				<form:input path="noticeType" htmlEscape="false" maxlength="10" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>基金代码</th>
				<th>公告标题</th>
				<th>公告日期</th>
				<th>公告类型</th>
				<th>create_by</th>
				<th>create_date</th>
				<th>update_date</th>
				<th>remarks</th>
				<shiro:hasPermission name="fund:fundInfoOpen:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="fundInfoOpen">
			<tr>
				<td><a href="${ctx}/fund/fundInfoOpen/form?id=${fundInfoOpen.id}">
					${fundInfoOpen.fundCode}
				</a></td>
				<td>
					${fundInfoOpen.noticeTitle}
				</td>
				<td>
					${fundInfoOpen.noticeDate}
				</td>
				<td>
					${fundInfoOpen.noticeType}
				</td>
				<td>
					${fundInfoOpen.createBy.id}
				</td>
				<td>
					<fmt:formatDate value="${fundInfoOpen.createDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					<fmt:formatDate value="${fundInfoOpen.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${fundInfoOpen.remarks}
				</td>
				<shiro:hasPermission name="fund:fundInfoOpen:edit"><td>
    				<a href="${ctx}/fund/fundInfoOpen/form?id=${fundInfoOpen.id}">修改</a>
					<a href="${ctx}/fund/fundInfoOpen/delete?id=${fundInfoOpen.id}" onclick="return confirmx('确认要删除该基金信息披露吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>