/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.fund.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.fund.entity.FundInfoOpen;
import com.thinkgem.jeesite.modules.fund.dao.FundInfoOpenDao;

/**
 * 基金信息披露Service
 * @author plq
 * @version 2017-09-07
 */
@Service
@Transactional(readOnly = true)
public class FundInfoOpenService extends CrudService<FundInfoOpenDao, FundInfoOpen> {

	public FundInfoOpen get(String id) {
		return super.get(id);
	}
	
	public List<FundInfoOpen> findList(FundInfoOpen fundInfoOpen) {
		return super.findList(fundInfoOpen);
	}
	
	public Page<FundInfoOpen> findPage(Page<FundInfoOpen> page, FundInfoOpen fundInfoOpen) {
		return super.findPage(page, fundInfoOpen);
	}
	
	@Transactional(readOnly = false)
	public void save(FundInfoOpen fundInfoOpen) {
		super.save(fundInfoOpen);
	}
	
	@Transactional(readOnly = false)
	public void delete(FundInfoOpen fundInfoOpen) {
		super.delete(fundInfoOpen);
	}
	
}