/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.fund.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.fund.entity.FundOrganInfo;
import com.thinkgem.jeesite.modules.fund.dao.FundOrganInfoDao;

/**
 * 机构信息Service
 * @author plq
 * @version 2017-09-06
 */
@Service
@Transactional(readOnly = true)
public class FundOrganInfoService extends CrudService<FundOrganInfoDao, FundOrganInfo> {

	public FundOrganInfo get(String id) {
		return super.get(id);
	}
	
	public List<FundOrganInfo> findList(FundOrganInfo fundOrganInfo) {
		return super.findList(fundOrganInfo);
	}
	
	public Page<FundOrganInfo> findPage(Page<FundOrganInfo> page, FundOrganInfo fundOrganInfo) {
		return super.findPage(page, fundOrganInfo);
	}
	
	@Transactional(readOnly = false)
	public void save(FundOrganInfo fundOrganInfo) {
		super.save(fundOrganInfo);
	}
	
	@Transactional(readOnly = false)
	public void delete(FundOrganInfo fundOrganInfo) {
		super.delete(fundOrganInfo);
	}
	
}