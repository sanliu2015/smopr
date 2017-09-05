/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.fund.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.fund.entity.FundParamDict;
import com.thinkgem.jeesite.modules.fund.dao.FundParamDictDao;

/**
 * 基金字典管理Service
 * @author plq
 * @version 2017-08-31
 */
@Service
@Transactional(readOnly = true)
public class FundParamDictService extends CrudService<FundParamDictDao, FundParamDict> {

	public FundParamDict get(String id) {
		return super.get(id);
	}
	
	public List<FundParamDict> findList(FundParamDict fundParamDict) {
		return super.findList(fundParamDict);
	}
	
	public Page<FundParamDict> findPage(Page<FundParamDict> page, FundParamDict fundParamDict) {
		return super.findPage(page, fundParamDict);
	}
	
	@Transactional(readOnly = false)
	public void save(FundParamDict fundParamDict) {
		super.save(fundParamDict);
	}
	
	@Transactional(readOnly = false)
	public void delete(FundParamDict fundParamDict) {
		super.delete(fundParamDict);
	}
	
	
}