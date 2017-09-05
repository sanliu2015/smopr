package com.thinkgem.jeesite.modules.fund.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.fund.entity.FundParamCode;

/**
 * 基金字典码表DAO接口
 * @author plq
 * @version 2017-08-31
 */
@MyBatisDao
public interface FundParamCodeDao extends CrudDao<FundParamCode> {
	
}