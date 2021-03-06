package com.thinkgem.jeesite.modules.frt.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Maps;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.BaseService;
import com.thinkgem.jeesite.modules.frt.dao.FrontDao;
import com.thinkgem.jeesite.modules.sys.utils.QueryMap;

@Service
@Transactional(readOnly = false)
public class FrontService extends BaseService {

	@Autowired
	private FrontDao dao;
	
	/**
	 * 查询基金信息
	 * @param fundCode
	 * @return
	 */
	public Map<String, Object> findFundInfo(String fundCode) {
		return dao.findFundInfo(fundCode);
	}
	
	/**
	 * 基金净值
	 * @param page
	 * @param queryMap
	 * @return
	 */
	public Map<String, Object> queryNetValue(Page<Map<String, Object>> page, QueryMap queryMap) {
		queryMap.setPage(page);
		page.setList(dao.queryNetValue(queryMap));
		Map<String, Object> tempMap = Maps.newHashMap();
		tempMap.put("code", 0);		// 成功为0
		tempMap.put("msg", "");
		tempMap.put("count", page.getCount());
		tempMap.put("data", page.getList());
		return tempMap;
	}

	/**
	 * 基金信息披露
	 * @param page
	 * @param queryMap
	 * @return
	 */
	public Map<String, Object> queryFundInfoOpen(Page<Map<String, Object>> page, QueryMap queryMap) {
		queryMap.setPage(page);
		page.setList(dao.queryFundInfoOpen(queryMap));
		Map<String, Object> tempMap = Maps.newHashMap();
		tempMap.put("code", 0);		// 成功为0
		tempMap.put("msg", "");
		tempMap.put("count", page.getCount());
		tempMap.put("data", page.getList());
		return tempMap;
	}

	

}
