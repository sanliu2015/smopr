<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<title>元年金融</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/layui/css/layui.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/common/ynjf.css" />
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery/jquery-2.2.4.min.js"></script>
	<script type="text/javascript">
		var ctx = "${ctx}";
		var ctxStatic = "${ctxStatic}";
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
		<div style="padding: 15px;">内容主体区域</div>
	</div>
  </div>
  
  <div class="footer">
    <!-- 底部固定区域 -->
    © 2015-2017 Genesis Financial Service Co., Ltd
  </div>
</div>
<script src="${pageContext.request.contextPath}/static/layui/layui.js"></script>
<script src="${pageContext.request.contextPath}/static/common/ynjf.js?v2"></script>
<script>
//JavaScript代码区域
layui.use('element', function(){
  var element = layui.element;
});
</script>
</body>
</html>