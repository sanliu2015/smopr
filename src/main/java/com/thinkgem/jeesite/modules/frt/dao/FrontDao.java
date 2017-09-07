package com.thinkgem.jeesite.modules.frt.dao;

import java.util.List;
import java.util.Map;

import com.thinkgem.jeesite.common.persistence.BaseDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.sys.utils.QueryMap;

@MyBatisDao
public interface FrontDao extends BaseDao {

	List<Map<String, Object>> queryNetValue(QueryMap queryMap);

	Map<String, Object> findFundInfo(String fundCode);

}
