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
import com.thinkgem.jeesite.modules.fund.entity.FundParamDict;
import com.thinkgem.jeesite.modules.fund.service.FundParamDictService;

/**
 * 基金字典管理Controller
 * @author plq
 * @version 2017-05-17
 */
@Controller
@RequestMapping(value = "${adminPath}/fund/fundParamDict")
public class FundParamDictController extends BaseController {

	@Autowired
	private FundParamDictService fundParamDictService;
	
	@ModelAttribute
	public FundParamDict get(@RequestParam(required=false) String id) {
		FundParamDict entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = fundParamDictService.get(id);
		}
		if (entity == null){
			entity = new FundParamDict();
		}
		return entity;
	}
	
	@RequiresPermissions("fund:fundParamDict:view")
	@RequestMapping(value = {"list", ""})
	public String list(FundParamDict fundParamDict, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<FundParamDict> page = fundParamDictService.findPage(new Page<FundParamDict>(request, response), fundParamDict); 
		model.addAttribute("page", page);
		return "modules/fund/fundParamDictList";
	}

	@RequiresPermissions("fund:fundParamDict:view")
	@RequestMapping(value = "form")
	public String form(FundParamDict fundParamDict, Model model) {
		model.addAttribute("fundParamDict", fundParamDict);
		return "modules/fund/fundParamDictForm";
	}

	@RequiresPermissions("fund:fundParamDict:edit")
	@RequestMapping(value = "save")
	public String save(FundParamDict fundParamDict, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, fundParamDict)){
			return form(fundParamDict, model);
		}
		fundParamDictService.save(fundParamDict);
		addMessage(redirectAttributes, "保存基金字典成功");
		return "redirect:"+Global.getAdminPath()+"/fund/fundParamDict/?repage";
	}
	
	@RequiresPermissions("fund:fundParamDict:edit")
	@RequestMapping(value = "delete")
	public String delete(FundParamDict fundParamDict, RedirectAttributes redirectAttributes) {
		fundParamDictService.delete(fundParamDict);
		addMessage(redirectAttributes, "删除基金字典成功");
		return "redirect:"+Global.getAdminPath()+"/fund/fundParamDict/?repage";
	}
	

}