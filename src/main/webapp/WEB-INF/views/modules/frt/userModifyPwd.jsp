<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>用户信息</title>
	<meta name="decorator" content="form"/>
	<script type="text/javascript">
	$(document).ready(function() {
		$("#inputForm").validate({
			submitHandler: function(form){
				$('#inputForm').ajaxSubmit({
					url : "${ctx}/sys/user/frt/modifyPwdSubmit",  
					type : "post",  
					dataType : "json", 
					beforeSend : function(XMLHttpRequest) {
						layer.load();	// 遮罩
					},
					success:function(responseText, statusText, xhr, $form){
						layer.closeAll('loading');
						if(responseText.code == "1"){  
							layer.msg('修改密码成功!', {icon: 1, time: 1000}, function(){
								closeCurrentLayer();
			                });  
			            }else{  
			                layer.msg(responseText.msg, {icon: 0});  
			            }  
					},
					error:function(data) {
						layer.closeAll('loading');
						layer.alert(data.responseText, {icon: 5, area: ['800px','450px']});
					}
				});
			},
			errorElement: "em",
			errorPlacement: function ( error, element ) {
				// Add the `help-block` class to the error element
				error.addClass( "help-block" );
				if ( element.prop( "type" ) === "checkbox" ) {
					error.insertAfter( element.parent().parent() );
				} else {
					error.insertAfter( element );
				}
			},
			highlight: function ( element, errorClass, validClass ) {
				$( element ).parents( "div[class^=col-sm]" ).addClass( "has-error" ).removeClass( "has-success" );
			},
			unhighlight: function (element, errorClass, validClass) {
				$( element ).parents( "div[class^=col-sm]" ).addClass( "has-success" ).removeClass( "has-error" );
			}
		});
		
	});
	
	</script>
</head>
<body>
	<form:form id="inputForm" modelAttribute="user" class="form-horizontal" style="padding-top:10px;">
		<form:hidden path="id"/>
		<div class="form-group">
			<label class="col-sm-4 control-label"><span class="mstin">*</span>旧密码：</label>
			<div class="col-sm-4">
				<input id="oldPassword" name="oldPassword" type="password" value="" maxlength="50" minlength="3" class="form-control required"/>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-4 control-label"><span class="mstin">*</span>新密码：</label>
			<div class="col-sm-4">
				<input id="newPassword" name="newPassword" type="password" value="" maxlength="50" minlength="3" class="form-control required"/>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-4 control-label"><span class="mstin">*</span>确认新密码：</label>
			<div class="col-sm-4">
				<input id="confirmNewPassword" name="confirmNewPassword" type="password" value="" maxlength="50" minlength="3" class="form-control required" equalTo="#newPassword"/>
			</div>
		</div>
		<div class="bottomBtn">
			<input id="btnSubmit" class="btn btn-primary" type="submit" value="确 定"/>&nbsp;
			<input id="btnCancel" class="btn btn-default" type="button" value="返 回" onclick="closeCurrentLayer();"/>
		</div>
	</form:form>
</body>
</html>