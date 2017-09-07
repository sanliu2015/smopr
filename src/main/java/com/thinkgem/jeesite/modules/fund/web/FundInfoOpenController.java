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
import com.thinkgem.jeesite.modules.fund.entity.FundInfoOpen;
import com.thinkgem.jeesite.modules.fund.service.FundInfoOpenService;

/**
 * 基金信息披露Controller
 * @author plq
 * @version 2017-09-07
 */
@Controller
@RequestMapping(value = "${adminPath}/fund/fundInfoOpen")
public class FundInfoOpenController extends BaseController {

	@Autowired
	private FundInfoOpenService fundInfoOpenService;
	
	@ModelAttribute
	public FundInfoOpen get(@RequestParam(required=false) String id) {
		FundInfoOpen entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = fundInfoOpenService.get(id);
		}
		if (entity == null){
			entity = new FundInfoOpen();
		}
		return entity;
	}
	
	@RequiresPermissions("fund:fundInfoOpen:view")
	@RequestMapping(value = {"list", ""})
	public String list(FundInfoOpen fundInfoOpen, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<FundInfoOpen> page = fundInfoOpenService.findPage(new Page<FundInfoOpen>(request, response), fundInfoOpen); 
		model.addAttribute("page", page);
		return "modules/fund/fundInfoOpenList";
	}

	@RequiresPermissions("fund:fundInfoOpen:view")
	@RequestMapping(value = "form")
	public String form(FundInfoOpen fundInfoOpen, Model model) {
		model.addAttribute("fundInfoOpen", fundInfoOpen);
		return "modules/fund/fundInfoOpenForm";
	}

	@RequiresPermissions("fund:fundInfoOpen:edit")
	@RequestMapping(value = "save")
	public String save(FundInfoOpen fundInfoOpen, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, fundInfoOpen)){
			return form(fundInfoOpen, model);
		}
		fundInfoOpenService.save(fundInfoOpen);
		addMessage(redirectAttributes, "保存基金信息披露成功");
		return "redirect:"+Global.getAdminPath()+"/fund/fundInfoOpen/?repage";
	}
	
	@RequiresPermissions("fund:fundInfoOpen:edit")
	@RequestMapping(value = "delete")
	public String delete(FundInfoOpen fundInfoOpen, RedirectAttributes redirectAttributes) {
		fundInfoOpenService.delete(fundInfoOpen);
		addMessage(redirectAttributes, "删除基金信息披露成功");
		return "redirect:"+Global.getAdminPath()+"/fund/fundInfoOpen/?repage";
	}

}