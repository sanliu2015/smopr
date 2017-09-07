/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.fund.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.fund.entity.FundInfo;

/**
 * 基金信息DAO接口
 * @author plq
 * @version 2017-09-06
 */
@MyBatisDao
public interface FundInfoDao extends CrudDao<FundInfo> {
	
}