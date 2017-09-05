/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.fund.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.common.utils.CacheUtils;
import com.thinkgem.jeesite.modules.fund.entity.FundParamCode;
import com.thinkgem.jeesite.modules.fund.utils.FundParamDictUtils;
import com.thinkgem.jeesite.modules.fund.dao.FundParamCodeDao;

/**
 * 基金字典码表Service
 * @author plq
 * @version 2017-08-31
 */
@Service
@Transactional(readOnly = true)
public class FundParamCodeService extends CrudService<FundParamCodeDao, FundParamCode> {

	public FundParamCode get(String id) {
		return super.get(id);
	}
	
	public List<FundParamCode> findList(FundParamCode fundParamCode) {
		return super.findList(fundParamCode);
	}
	
	public Page<FundParamCode> findPage(Page<FundParamCode> page, FundParamCode fundParamCode) {
		return super.findPage(page, fundParamCode);
	}
	
	@Transactional(readOnly = false)
	public void save(FundParamCode fundParamCode) {
		super.save(fundParamCode);
		CacheUtils.remove(FundParamDictUtils.CACHE_DICT_MAP);
	}
	
	@Transactional(readOnly = false)
	public void delete(FundParamCode fundParamCode) {
		super.delete(fundParamCode);
	}
	
}