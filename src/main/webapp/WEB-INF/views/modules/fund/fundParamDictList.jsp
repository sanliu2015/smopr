<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>基金字典管理</title>
	<meta name="decorator" content="default"/>
	<script src="${ctxStatic}/layer/3.0.3/layer.js" type="text/javascript"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			
		});
		function page(n,s){
			$("#pageNo").val(n);
			$("#pageSize").val(s);
			$("#searchForm").submit();
        	return false;
        }
		
		function layerOpen(dictCode, dictName) {
			layer.open({
				  title:dictName,
				  type: 2,
				  area: ['800px', '530px'],
				  fixed: false, //不固定
				  maxmin: true,
				  content: '${ctx}/fund/fundParamCode/?dictCode=' + dictCode
				});
			
		}
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/fund/fundParamDict/">基金字典列表</a></li>
		<shiro:hasPermission name="fund:fundParamDict:edit"><li><a href="${ctx}/fund/fundParamDict/form">基金字典添加</a></li></shiro:hasPermission>
		<li><a href="${ctx}/fund/fundParamCode/listDetail/">字典明细列表</a></li>
	</ul>
	<form:form id="searchForm" modelAttribute="fundParamDict" action="${ctx}/fund/fundParamDict/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>字典代码：</label>
				<form:input path="dictCode" htmlEscape="false" maxlength="200" class="input-medium"/>
			</li>
			<li><label>字典名称：</label>
				<form:input path="dictName" htmlEscape="false" maxlength="50" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<div class="col-sm-6">
	<table id="contentTable" class="table table-striped table-bordered table-condensed col-sm-6">
		<thead>
			<tr>
				<th>字典代码</th>
				<th>字典名称</th>
				<shiro:hasPermission name="fund:fundParamDict:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="fundParamDict">
			<tr>
				<td><a href="${ctx}/fund/fundParamDict/form?id=${fundParamDict.id}">
					${fundParamDict.dictCode}
				</a></td>
				<td>
					${fundParamDict.dictName}
				</td>
				<shiro:hasPermission name="fund:fundParamDict:edit"><td>
    				<a href="${ctx}/fund/fundParamDict/form?id=${fundParamDict.id}">修改</a>
					<a href="${ctx}/fund/fundParamDict/delete?id=${fundParamDict.id}" onclick="return confirmx('确认要删除该基金字典吗？', this.href)">删除</a>
					<a href="javascript:;" onclick="layerOpen('${fundParamDict.dictCode}', '${fundParamDict.dictName}')">查看明细</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	
	<div class="pagination">${page}</div>
	</div>
</body>
</html>