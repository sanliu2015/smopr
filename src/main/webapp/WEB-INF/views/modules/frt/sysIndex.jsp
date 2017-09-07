<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<title>元年金融</title>
	<link rel="stylesheet" href="${ctxStatic}/layui/css/layui.css" />
	<link rel="stylesheet" href="${ctxStatic}/common/ynjf.css" />
	<script type="text/javascript" src="${ctxStatic}/jquery/jquery-2.2.4.min.js"></script>
	<script type="text/javascript">
		var ctx = "${ctx}";
		var ctxStatic = "${ctxStatic}";
		function personInf() {
			var option = {
				title : "个人信息",
				area : ['800px', '450px'],
				url : ctx + "/sys/user/frt/info"
			};

			layerOpen(option);

		}
		function modifyPwd() {
			var option = {
				title : "修改密码",
				area : ['800px', '400px'],
				url : ctx + "/sys/user/frt/modifyPwd"
			};
			layerOpen(option);
		}
		

	</script>
</head>
<body>
<div class="layui-layout layui-layout-admin">
  <div class="layui-header">
    <div class="layui-logo">元年金融信息披露平台</div>
    
    <%-- 
    <!-- 头部区域（可配合layui已有的水平导航） -->
    <ul class="layui-nav layui-layout-left">
      <li class="layui-nav-item"><a href="">首页</a></li>
      <li class="layui-nav-item">
        <a href="javascript:;">其它系统</a>
        <dl class="layui-nav-child">
          <dd><a href="">邮件管理</a></dd>
          <dd><a href="">消息管理</a></dd>
          <dd><a href="">授权管理</a></dd>
        </dl>
      </li>
    </ul>
    --%>
    
    <ul class="layui-nav layui-layout-right">
      <li class="layui-nav-item">
       <%-- <a href="javascript:;">
          <img src="http://t.cn/RCzsdCq" class="layui-nav-img">
          贤心
        </a> --%>
          您好, ${fns:getUser().name}
        <dl class="layui-nav-child">
          <dd><a href="javascript:;" onclick="personInf();">个人信息</a></dd>
          <dd><a href="javascript:;" onclick="modifyPwd();">修改密码</a></dd>
        </dl>
      </li>
      <li class="layui-nav-item"><a href="${ctx}/logout">退出</a></li>
    </ul>
  </div>
  
  <div class="wrap-div">
    <!-- 内容主体区域 -->
    <div class="w1000 mgCenter">
		<!-- <div style="padding: 15px;">内容主体区域</div> -->
		<div class="layui-tab layui-tab-brief" lay-filter="tabBrief">
		  <ul class="layui-tab-title">
		    <li class="layui-this">基金概况</li>
		    <li>净值表现</li>
		    <li>信息披露</li>
		  </ul>
		  <div class="layui-tab-content" style="height: 100px;">
		    <div class="layui-tab-item layui-show">
		    	<table class="layui-table">
		    		 <colgroup>
					    <col width="50%">
					    <col width="50%">
					  </colgroup>
					<tbody>
						<tr>
							<td>基金名称：${fundInfo.fundName}</td>
							<td>注册登记人：${fundInfo.registerName}</td>
						</tr>
						<tr>
							<td>基金代码：${fundInfo.fundCode}</td>
							<td>基金管理人：${fundInfo.handlerName}</td>
						</tr>
						<tr>
							<td>基金类型：${fundInfo.fundType}</td>
							<td>基金托管人：${fundInfo.trusteeName}</td>
						</tr>
						<tr>
							<td>运作方式：${fundInfo.operMode}</td>
							<td>基金经理：${fundInfo.managerName}</td>
						</tr>
						<tr>
							<td>基金合同生效日期：${fundInfo.foundDate}</td>
							<td></td>
						</tr>
					</tbody>
				</table>
		    </div>
		    <div class="layui-tab-item">
		    	<div class="demoTable">
				  净值日期：
				  <div class="layui-inline">
				    <input class="layui-input" name="dataDates" id="dataDates" autocomplete="off">
				  </div>
				  - <div class="layui-inline">
				  	<input class="layui-input" name="dataDatee" id="dataDatee" autocomplete="off">
				  </div>
				  <button class="layui-btn" id="searchBtn">搜索</button>
				</div>
		    	<table id="layuiDataGrid"></table>
		    </div>
		    <div class="layui-tab-item">内容5</div>
		  </div>
		</div> 
	</div>
  </div>
  
  <div class="footer">
    <!-- 底部固定区域 -->
    © 2015-2017 Genesis Financial Service Co., Ltd
  </div>
</div>
<script src="${pageContext.request.contextPath}/static/layui/layui.js"></script>
<script src="${pageContext.request.contextPath}/static/common/ynjf.js?v5"></script>
<script>
//JavaScript代码区域
layui.use(['element','table','laypage','laydate'], function(){
  var element = layui.element;
  var table = layui.table;
  var laypage = layui.laypage;
  var laydate = layui.laydate;
  laydate.render({
	    elem: '#dataDates' //指定元素
  });
  laydate.render({
	    elem: '#dataDatee' //指定元素
});
  var tableIns = table.render({
	  elem: '#layuiDataGrid' //指定原始表格元素选择器（推荐id选择器）
		  ,skin: 'line' //行边框风格
			  ,even: true //开启隔行背景
			  ,height: 'full-250'
	  ,cols: [[ //标题栏
	            {field: 'dataDate', title: '净值日期', width: 300},
	            {field: 'netValue', title: '单位净值', width: 300},
	            {field: 'sumValue', title: '累计净值', width: 300}
	          ]]
	  ,page: true
	  ,limits: [30,100,200,300,500]
	  ,limit: 30
	  ,request: {
		  pageName: 'pageNo' //页码的参数名称，默认：page
			  ,limitName: 'pageSize' //每页数据量的参数名，默认：limit
			} 
  ,response: {
	  statusName: 'code' //数据状态的字段名称，默认：code
		  ,statusCode: 0 //成功的状态码，默认：0
		  ,msgName: 'msg' //状态信息的字段名称，默认：msg
		  ,countName: 'count' //数据总数的字段名称，默认：count
		  ,dataName: 'data' //数据列表的字段名称，默认：data
		}      
	});
  
  
  	element.on('tab(tabBrief)', function(data){
	    if (this.innerHTML == "净值表现") {
	    	tableIns.reload({
	    		url:'${ctx}/frt/netInfo/list',
	    		where: {
					 dataDates: $("#dataDates").val(), 
					 dataDatee: $("#dataDatee").val()
				 } //设定异步数据
	    	});
	    }
	  });
  	
  	$("#searchBtn").bind("click", function(){
  		tableIns.reload({
  			where: {
				 dataDates: $("#dataDates").val(), 
				 dataDatee: $("#dataDatee").val()
			 } 
  		});
	});
});

</script>
</body>
</html>