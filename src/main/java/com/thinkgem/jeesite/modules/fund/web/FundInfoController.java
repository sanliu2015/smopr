/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.fund.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.modules.fund.entity.FundInfo;
import com.thinkgem.jeesite.modules.fund.service.FundInfoService;

/**
 * 基金信息Controller
 * @author plq
 * @version 2017-09-06
 */
@Controller
@RequestMapping(value = "${adminPath}/fund/fundInfo")
public class FundInfoController extends BaseController {

	@Autowired
	private FundInfoService fundInfoService;
	
	@ModelAttribute
	public FundInfo get(@RequestParam(required=false) String id) {
		FundInfo entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = fundInfoService.get(id);
		}
		if (entity == null){
			entity = new FundInfo();
		}
		return entity;
	}
	
	@RequiresPermissions("fund:fundInfo:view")
	@RequestMapping(value = {"list", ""})
	public String list(FundInfo fundInfo, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<FundInfo> page = fundInfoService.findPage(new Page<FundInfo>(request, response), fundInfo); 
		model.addAttribute("page", page);
		return "modules/fund/fundInfoList";
	}

	@RequiresPermissions("fund:fundInfo:view")
	@RequestMapping(value = "form")
	public String form(FundInfo fundInfo, Model model) {
		model.addAttribute("fundInfo", fundInfo);
		return "modules/fund/fundInfoForm";
	}

	@RequiresPermissions("fund:fundInfo:edit")
	@RequestMapping(value = "save")
	public String save(FundInfo fundInfo, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, fundInfo)){
			return form(fundInfo, model);
		}
		fundInfoService.save(fundInfo);
		addMessage(redirectAttributes, "保存基金信息成功");
		return "redirect:"+Global.getAdminPath()+"/fund/fundInfo/?repage";
	}
	
	@RequiresPermissions("fund:fundInfo:edit")
	@RequestMapping(value = "delete")
	public String delete(FundInfo fundInfo, RedirectAttributes redirectAttributes) {
		fundInfoService.delete(fundInfo);
		addMessage(redirectAttributes, "删除基金信息成功");
		return "redirect:"+Global.getAdminPath()+"/fund/fundInfo/?repage";
	}

}