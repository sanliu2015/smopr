/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.fund.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.fund.entity.FundInfoOpen;

/**
 * 基金信息披露DAO接口
 * @author plq
 * @version 2017-09-07
 */
@MyBatisDao
public interface FundInfoOpenDao extends CrudDao<FundInfoOpen> {
	
}