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
import com.thinkgem.jeesite.modules.fund.entity.FundParamCode;
import com.thinkgem.jeesite.modules.fund.service.FundParamCodeService;

/**
 * 基金字典码表Controller
 * @author plq
 * @version 2017-05-17
 */
@Controller
@RequestMapping(value = "${adminPath}/fund/fundParamCode")
public class FundParamCodeController extends BaseController {

	@Autowired
	private FundParamCodeService fundParamCodeService;
	
	@ModelAttribute
	public FundParamCode get(@RequestParam(required=false) String id, @RequestParam(required=false) String dictCode) {
		FundParamCode entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = fundParamCodeService.get(id);
		}
		if (entity == null){
			entity = new FundParamCode();
			entity.setDictCode(dictCode);
		}
		return entity;
	}
	
	@RequiresPermissions("fund:fundParamCode:view")
	@RequestMapping(value = {"list", ""})
	public String list(FundParamCode fundParamCode, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<FundParamCode> page = fundParamCodeService.findPage(new Page<FundParamCode>(request, response), fundParamCode); 
		model.addAttribute("page", page);
		return "modules/fund/fundParamCodeList";
	}
	
	@RequestMapping(value = {"listDetail"})
	public String listDetail(FundParamCode fundParamCode, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<FundParamCode> page = fundParamCodeService.findPage(new Page<FundParamCode>(request, response), fundParamCode); 
		model.addAttribute("page", page);
		return "modules/fund/fundParamCodeListDetail";
	}

	@RequiresPermissions("fund:fundParamCode:view")
	@RequestMapping(value = "form")
	public String form(FundParamCode fundParamCode, Model model) {
		model.addAttribute("fundParamCode", fundParamCode);
		return "modules/fund/fundParamCodeForm";
	}

	@RequiresPermissions("fund:fundParamCode:edit")
	@RequestMapping(value = "save")
	public String save(FundParamCode fundParamCode, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, fundParamCode)){
			return form(fundParamCode, model);
		}
		fundParamCodeService.save(fundParamCode);
		addMessage(redirectAttributes, "保存字典码表成功");
		return "redirect:"+Global.getAdminPath()+"/fund/fundParamCode/?dictCode=" + fundParamCode.getDictCode();	// 字典下的字典码表明细
	}
	
	@RequiresPermissions("fund:fundParamCode:edit")
	@RequestMapping(value = "delete")
	public String delete(FundParamCode fundParamCode, RedirectAttributes redirectAttributes) {
		fundParamCodeService.delete(fundParamCode);
		addMessage(redirectAttributes, "删除字典码表成功");
		return "redirect:"+Global.getAdminPath()+"/fund/fundParamCode/?dictCode=" + fundParamCode.getDictCode();
	}
	
	@RequiresPermissions("fund:fundParamCode:view")
	@RequestMapping(value = "formDetail")
	public String formDetail(FundParamCode fundParamCode, Model model, HttpServletRequest request) {
		String operate = request.getParameter("operate");
		if ("add".equals(operate)) {
			fundParamCode.setId("");
			fundParamCode.setCode("");
			fundParamCode.setName("");
		}
		model.addAttribute("fundParamCode", fundParamCode);
		return "modules/fund/fundParamCodeFormDetail";
	}

	@RequiresPermissions("fund:fundParamCode:edit")
	@RequestMapping(value = "saveDetail")
	public String saveDetail(FundParamCode fundParamCode, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, fundParamCode)){
			return form(fundParamCode, model);
		}
		
		fundParamCodeService.save(fundParamCode);
		addMessage(redirectAttributes, "保存字典码表成功");
		return "redirect:"+Global.getAdminPath()+"/fund/fundParamCode/listDetail";
	}
	
	@RequiresPermissions("fund:fundParamCode:edit")
	@RequestMapping(value = "deleteDetail")
	public String deleteDetail(FundParamCode fundParamCode, RedirectAttributes redirectAttributes) {
		fundParamCodeService.delete(fundParamCode);
		addMessage(redirectAttributes, "删除字典码表成功");
		return "redirect:"+Global.getAdminPath()+"/fund/fundParamCode/listDetail";
	}

}