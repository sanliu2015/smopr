package com.thinkgem.jeesite.modules.frt.web;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.thinkgem.jeesite.common.mapper.JsonMapper;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.frt.service.FrontService;
import com.thinkgem.jeesite.modules.sys.utils.QueryMap;
import com.thinkgem.jeesite.modules.sys.utils.UserUtils;

@Controller
@RequestMapping(value = "${adminPath}/frt")
public class FrontController extends BaseController {

	@Autowired
	private FrontService frontService;
	
	@RequestMapping(value = {"/netInfo/list"})
	@ResponseBody
	public String queryNetValue(@RequestParam(required = false) Map<String, Object> params, HttpServletRequest request, HttpServletResponse response) {
		QueryMap queryMap = new QueryMap();
		queryMap.putAll(params);
		queryMap.put("fundCode", UserUtils.getUser().getFundCode());
		Map<String, Object> layuiTableMap = frontService.queryNetValue(new Page<Map<String, Object>>(queryMap.get("pageNo"), queryMap.get("pageSize")), queryMap);
		return JsonMapper.toJsonString(layuiTableMap);
	}
	
	@RequestMapping(value = {"/fundInfoOpen/list"})
	@ResponseBody
	public String queryFundInfoOpen(@RequestParam(required = false) Map<String, Object> params, HttpServletRequest request, HttpServletResponse response) {
		QueryMap queryMap = new QueryMap();
		queryMap.putAll(params);
		queryMap.put("fundCode", UserUtils.getUser().getFundCode());
		Map<String, Object> pageData = frontService.queryFundInfoOpen(new Page<Map<String, Object>>(queryMap.get("pageNo"), queryMap.get("pageSize")), queryMap);
		return JsonMapper.toJsonString(pageData);
	}
	
	
	
}
