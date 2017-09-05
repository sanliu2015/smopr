<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="keywords" content="" />
    <meta name="description" content="" />
    <title>登录页</title>
    <%-- <link rel="stylesheet" type="text/css" href="${fns:getConfig('web.staticFile.urlName')}/css/reset.css" /> --%>
    <link rel="stylesheet" type="text/css" href="${ctxStatic}/org/css/reset.css" />
    <link rel="stylesheet" type="text/css" href="${ctxStatic}/org/css/common.css" />
    <link rel="stylesheet" type="text/css" href="${ctxStatic}/org/css/yui.css">
    <link rel="stylesheet" type="text/css" href="${ctxStatic}/org/font/iconfont.css">
    <link rel="stylesheet" type="text/css" href="${ctxStatic}/org/css/style.css" />
    <link rel="stylesheet" type="text/css" href="${ctxStatic}/jquery-validation/1.11.0/jquery.validate.min.css" />
    <script type="text/javascript" src="${ctxStatic}/org/js/jquery.min.js"></script>
	<script type="text/javascript" src="${ctxStatic}/jquery-validation/1.11.0/jquery.validate.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/layer/3.0.3/layer.js"></script>
	<style type="text/css">
		.hide{display: none;}
		#messageBox label{display:inline-block}
		label.error{background:none;width:180px;padding-left:50px;text-align:center;font-weight:normal;color:#C00;margin:0;}
	</style>
    <script type="text/javascript">
		$(document).ready(function() {
			$("#loginForm").validate({
				rules: {
					validateCode: {
						remote: "${pageContext.request.contextPath}/servlet/validateCodeServlet"
					}
				},
				messages: {
					validateCode: {remote: "验证码不正确."}
				},
				errorLabelContainer: "#messageBox",
				errorPlacement: function(error, element) {
					error.appendTo($("#loginError").parent());
				} 
			});
			
			$(".adver").keydown(function(event){ 
				if(event.keyCode == 13){ 
					login();
				}
			}); 
			
		});
		// 如果在框架或在对话框中，则弹出提示并跳转到首页
		if(self.frameElement && self.frameElement.tagName == "IFRAME" || $('#left').length > 0 || $('.jbox').length > 0){
			alert('未登录或登录超时。请重新登录，谢谢！');
			top.location = "${ctx}";
		}
		
		function login() {
			if ($("#username").val() == "") {
				layer.alert("用户名不能为空！", {icon: 5, end: function(){
					parent.$("#username").focus();
				}});  
				return false;
			}
			if ($("#password").val() == "") {
				layer.alert("密码不能为空！", {icon: 5, end: function(){
					parent.$("#password").focus();
				}});  
				return false;
			}
			if ($("#validateCode").val() == "") {
				layer.alert("验证码不能为空！", {icon: 5, end: function(){
					parent.$("#validateCode").focus();
				}});  
				return false;
			}
			$("#loginForm").submit();
		}
	</script>
</head>

<body>
    <!--topNav begin-->
    
    <div class="head">
        <!-- <div class="clear mgCenter w1190">
           <a href="javascript:void(0)" class="adv fl">元年金融私募基金中后平台</a>
           <div class="fr headBoxR f20">
              好产品，就选<span class="red">好买</span>！ <span class="red pl10 pr10">400-700-9665</span>
    7×24免费导购热线</div>
        </div> -->
    </div>
    
    <div class="adver">
        <div class="w1190 mgCenter clear" align="center">
            <form class="adverLogin mt40" id="loginForm" action="${ctx}/login" method="post">
                <h4>用户登录</h4>
                <div class="yui-form-cell mt30 mb20 clear">
                    <label class="cell-left f14 w50 tar pr10" for="username">用户名</label>
                    <div class="cell-right">
                        <input id="username" name="username" type="text" class="yui-input w230" placeholder="请输入用户名" value="${username}">
                    </div>
			    </div>
               <div class="yui-form-cell mb20 clear">
                    <label class="cell-left f14 w50 tar pr10" for="password">密码</label>
                    <div class="cell-right">
                        <input id="password" name="password" type="password" class="yui-input w230" placeholder="请输入密码">
                    </div>
			    </div>
               <div class="yui-form-cell mb20 clear">
                    <label class="cell-left f14 w50 tar pr10" for="validateCode">验证码</label>
                    <div class="cell-right validate">
                        <input type="text" name="validateCode" id="validateCode" class="yui-input w230" placeholder="看不清？点击图片刷新">
                        <img id="checkCode" src="${pageContext.request.contextPath}/servlet/validateCodeServlet" onclick="refreshCode();" alt="">
                        <div class="bcInfo w240 clear">
                            <%-- <div class="yui-checkbox mt6 fl">
                                <label><i class="iconfont">&#xe606;</i></label><input type="checkbox" name="" hidden=""><span>记住密码</span>
                            </div> --%>
                            <div class="mt6 fl">
                            	<input type="checkbox" id="rememberMe" name="rememberMe" style="vertical-align:middle;"/>记住密码
                            </div>	
                            <div class="yui-checkbox mt6 fr bcInfo">
                                <a href="${pageContext.request.contextPath}${fns:getAdminPath()}/sys/user/retrievePwdPage" target="_blank">忘记密码/修改密码？</a>
                            </div>
                        </div>
                    </div>
			    </div>
                <div id="messageBox" class="alert alert-error ${empty message ? 'hide' : ''}" >
                	<label id="loginError" class="error">${message}</label>
                </div>
                <a href="javascript:void(0)" onclick="login();" class="btn-style-a mt20 db">登 录</a>
                <div class="bcInfo tac mt15">没有账户 去<a href="${pageContext.request.contextPath}${fns:getAdminPath()}/register">注册</a></div>
            </form>
        </div>
    </div>
    
    <script src="${ctxStatic}/org/js/foot.js"></script>
    <script type="text/javascript" src="${ctxStatic}/org/js/yui.js"></script>
    <script type="text/javascript" src="${ctxStatic}/org/js/main.js"></script>
	<script type="text/javascript">
		function refreshCode() {
			$("#checkCode").attr("src", "${pageContext.request.contextPath}/servlet/validateCodeServlet?"+new Date().getTime());
		}
	</script>
</body>
</html>