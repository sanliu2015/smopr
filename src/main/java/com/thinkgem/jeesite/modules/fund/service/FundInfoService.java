/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.fund.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.fund.entity.FundInfo;
import com.thinkgem.jeesite.modules.fund.dao.FundInfoDao;

/**
 * 基金信息Service
 * @author plq
 * @version 2017-09-06
 */
@Service
@Transactional(readOnly = true)
public class FundInfoService extends CrudService<FundInfoDao, FundInfo> {

	public FundInfo get(String id) {
		return super.get(id);
	}
	
	public List<FundInfo> findList(FundInfo fundInfo) {
		return super.findList(fundInfo);
	}
	
	public Page<FundInfo> findPage(Page<FundInfo> page, FundInfo fundInfo) {
		return super.findPage(page, fundInfo);
	}
	
	@Transactional(readOnly = false)
	public void save(FundInfo fundInfo) {
		super.save(fundInfo);
	}
	
	@Transactional(readOnly = false)
	public void delete(FundInfo fundInfo) {
		super.delete(fundInfo);
	}
	
}