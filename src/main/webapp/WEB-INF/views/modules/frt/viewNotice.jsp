<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>信息披露</title>
	<style type="text/css">
		/* 动态详细页 */
		.zixun_bg{background: #fff;border: 1px solid #c7c7c7;}
		.zixun_detail{color: #666;font-size: 14px; width:1000px; margin: 0 auto}
		.zixun_detail .tit{border-bottom: 1px solid #c7c7c7;color:#333;font-size: 18px;line-height: 56px;width: 100%; text-align: center;}
		.zixun_detail .source{padding:0px 30px;}
		.zixun_detail .size a{padding:0px 2px;color:#666;}
		.zixun_detail .info{ text-align: center;font-size: 12px;color: #858585;padding: 12px 0 15px 0;}
		.zixun_detail .detail{ line-height: 26px;width: 706px;margin: 0px auto;overflow: hidden;}
		.zixun_detail .detail p{/*text-indent: 2em;*/text-align:justify;-ms-text-justify:inter-ideograph;
		text-justify:inter-ideograph;
		-moz-text-align:justify;/*ff*/
		-webkit-text-align:justify;/*chrome 20+*/}
		.zixun_detail .share{width: 706px;margin: 0px auto; overflow: hidden;padding:0px 0;height: 60px;}
		.zixun_detail .share p{ padding-top: 10px;}
		.zixun_detail .share span{margin-top: 3px;}
		.zixun_box .detailPage{padding:10px 0;width: 902px;margin:0px auto;overflow: hidden;}
		.zixun_box .detailPage a{color:#004b97;}
	</style>
</head>
<body style="background: #eeeeee;">
	<div class="zixun_bg zixun_detail">
			<div class="tit">关于旗下部分基金增加泉州银行为销售机构并参加费率优惠活动的公告</div>
			<div class="info">
				<span class="date"><fmt:formatDate value="${notice.createDate}" pattern="yyyy-MM-dd HH:mm:ss"/></span>
				<span class="source">来源: 元年金融</span>
			</div>
			<div class="detail" id="detailSize">
				${notice.noticeContent}
			</div>
			<!-- 彭禄泉 -->
			<%-- 
			<div class="share">
				<p class="fr">
					<span class="fl">分享至：</span>
					<a href="javascript:;" class="xinlang fl"><img src="/images/zixun/icon_07.gif" alt=""></a>
					<a href="javascript:;" class="qq fl" style="margin-left: 5px;"><img src="/images/zixun/icon_08.gif" alt=""></a>
				</p>
			</div>
			--%>
		</div>
</body>
</html>