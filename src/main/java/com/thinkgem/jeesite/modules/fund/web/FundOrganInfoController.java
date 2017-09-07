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
import com.thinkgem.jeesite.modules.fund.entity.FundOrganInfo;
import com.thinkgem.jeesite.modules.fund.service.FundOrganInfoService;

/**
 * 机构信息Controller
 * @author plq
 * @version 2017-09-06
 */
@Controller
@RequestMapping(value = "${adminPath}/fund/fundOrganInfo")
public class FundOrganInfoController extends BaseController {

	@Autowired
	private FundOrganInfoService fundOrganInfoService;
	
	@ModelAttribute
	public FundOrganInfo get(@RequestParam(required=false) String id) {
		FundOrganInfo entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = fundOrganInfoService.get(id);
		}
		if (entity == null){
			entity = new FundOrganInfo();
		}
		return entity;
	}
	
	@RequiresPermissions("fund:fundOrganInfo:view")
	@RequestMapping(value = {"list", ""})
	public String list(FundOrganInfo fundOrganInfo, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<FundOrganInfo> page = fundOrganInfoService.findPage(new Page<FundOrganInfo>(request, response), fundOrganInfo); 
		model.addAttribute("page", page);
		return "modules/fund/fundOrganInfoList";
	}

	@RequiresPermissions("fund:fundOrganInfo:view")
	@RequestMapping(value = "form")
	public String form(FundOrganInfo fundOrganInfo, Model model) {
		model.addAttribute("fundOrganInfo", fundOrganInfo);
		return "modules/fund/fundOrganInfoForm";
	}

	@RequiresPermissions("fund:fundOrganInfo:edit")
	@RequestMapping(value = "save")
	public String save(FundOrganInfo fundOrganInfo, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, fundOrganInfo)){
			return form(fundOrganInfo, model);
		}
		fundOrganInfoService.save(fundOrganInfo);
		addMessage(redirectAttributes, "保存基金信息成功");
		return "redirect:"+Global.getAdminPath()+"/fund/fundOrganInfo/?repage";
	}
	
	@RequiresPermissions("fund:fundOrganInfo:edit")
	@RequestMapping(value = "delete")
	public String delete(FundOrganInfo fundOrganInfo, RedirectAttributes redirectAttributes) {
		fundOrganInfoService.delete(fundOrganInfo);
		addMessage(redirectAttributes, "删除基金信息成功");
		return "redirect:"+Global.getAdminPath()+"/fund/fundOrganInfo/?repage";
	}

}