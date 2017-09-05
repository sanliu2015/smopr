var layerAreaSize = [ $(window).width() * 0.8 + 'px', $(window).height() * 0.8 + 'px' ]; // layer弹出层默认值

// layer
layui.use('layer', function(){
	var layer = layui.layer;
});    

function personInf() {
	var option = {
		title : "个人信息",
		url : ctx + "/sys/user/frt/info"
	};

	layerOpen(option);

}

function modifyPwd() {
	var option = {
		title : "修改密码",
		url : ctx + "/sys/user/frt/modifyPwd"
	};
	layerOpen(option);
}

function layerOpen(opt) {
	var defaults = {
		id : 'layerForm',
		title : '',
		area : layerAreaSize,
		url : null,
		scrollbar : true,
		fixed : false, // 不固定
		maxmin : true,
		isOutAnim : false, // 默认情况下true，关闭层时会有一个过度动画。如果你不想开启，设置 false 即可
		maxFlag : false,
		success : function() {
		},
		yes : function() {
		},
		cancel : function() {
		},
		data : {}
	// 预留，暂时没用到
	}
	var option = $.extend({}, defaults, opt), content = null;
	if (option.scrollbar) {
		content = [ option.url ]
	} else {
		content = [ option.url, 'no' ]
	}

	var index = layer.open({
		type : 2,
		id : option.id,
		title : option.title,
		content : option.url,
		area : option.area,
		fixed : option.fixed, // 不固定
		maxmin : option.maxmin,
		isOutAnim : option.isOutAnim,
		success : function(layero, index) {
			option.success(option.id, index);
		},
		yes : function(index, layero) {
			option.yes(index, option.id);
		},
		cancel : function(index, layero) { //
			option.cancel(index, option.id);
		}
	});

	if (option.maxFlag) {
		layer.full(index);
	}

}