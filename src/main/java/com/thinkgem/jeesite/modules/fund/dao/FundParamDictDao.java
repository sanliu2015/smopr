/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.fund.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.fund.entity.FundParamDict;

/**
 * 基金字典管理DAO接口
 * @author plq
 * @version 2017-08-31
 */
@MyBatisDao
public interface FundParamDictDao extends CrudDao<FundParamDict> {
	
}