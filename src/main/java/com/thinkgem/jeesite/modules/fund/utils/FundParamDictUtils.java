package com.thinkgem.jeesite.modules.fund.utils;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.thinkgem.jeesite.common.mapper.JsonMapper;
import com.thinkgem.jeesite.common.utils.CacheUtils;
import com.thinkgem.jeesite.common.utils.SpringContextHolder;
import com.thinkgem.jeesite.modules.fund.dao.FundParamCodeDao;
import com.thinkgem.jeesite.modules.fund.entity.FundParamCode;

/**
 * 基金参数字典工具类
 * @author luquan.peng
 *
 */
public class FundParamDictUtils {

	private static FundParamCodeDao dictDao = SpringContextHolder.getBean(FundParamCodeDao.class);

	public static final String CACHE_DICT_MAP = "fundParamCodeMap";
	
	// 根据code获取显示的name值  例如传入01,fundType,显示股权类基金
	public static String getDictLabel(String code, String dictCode, String defaulLabel){
		if (StringUtils.isNotBlank(dictCode) && StringUtils.isNotBlank(code)){
			for (FundParamCode fundParamCode : getDictList(dictCode)){
				if (dictCode.equals(fundParamCode.getDictCode()) && code.equals(fundParamCode.getCode())){
					return fundParamCode.getName();
				}
			}
		}
		return defaulLabel;
	}
	
	public static String getDictLabels(String values, String dictCode, String defaulLabel){
		if (StringUtils.isNotBlank(dictCode) && StringUtils.isNotBlank(values)){
			List<String> valueList = Lists.newArrayList();
			for (String value : StringUtils.split(values, ",")){
				valueList.add(getDictLabel(value, dictCode, defaulLabel));
			}
			return StringUtils.join(valueList, ",");
		}
		return defaulLabel;
	}
	
	
	public static List<FundParamCode> getDictList(String dictCode){
		return getDictListByOrder(dictCode, null);
	}
	
	public static List<FundParamCode> getDictListByOrder(String dictCode, String intOrder){
		@SuppressWarnings("unchecked")
		Map<String, List<FundParamCode>> dictMap = (Map<String, List<FundParamCode>>)CacheUtils.get(CACHE_DICT_MAP);
		if (dictMap == null) {
			dictMap = Maps.newHashMap();
			for (FundParamCode dict : dictDao.findAllList(new FundParamCode())){
				List<FundParamCode> dictList = dictMap.get(dict.getDictCode());
				if (dictList != null){
					dictList.add(dict);
				}else{
					dictMap.put(dict.getDictCode(), Lists.newArrayList(dict));
				}
			}
			CacheUtils.put(CACHE_DICT_MAP, dictMap);
		}
		List<FundParamCode> dictList = dictMap.get(dictCode);
		if (dictList == null){
			dictList = Lists.newArrayList();
		} else {
			if ("0".equals(intOrder)) {	// code转整形升序
				Collections.sort(dictList, new Comparator<FundParamCode>() {
					@Override
					public int compare(FundParamCode o1, FundParamCode o2) {
						return new Double(o1.getCode()).compareTo(new Double(o2.getCode()));
					}

				});
			} else if ("1".equals(intOrder)) {
				Collections.sort(dictList, new Comparator<FundParamCode>() {
					@Override
					public int compare(FundParamCode o1, FundParamCode o2) {
						return new Double(o2.getCode()).compareTo(new Double(o1.getCode()));
					}

				});
			} else {
				Collections.sort(dictList, new Comparator<FundParamCode>() {
					@Override
					public int compare(FundParamCode o1, FundParamCode o2) {
						return o1.getCode().compareTo(o2.getCode());
					}
				});
			}
		}
		return dictList;
	}
	
	/**
	 * 根据名称获取value值
	 * @param label
	 * @param type
	 * @param defaultLabel
	 * @return
	 */
	public static String getDictValue(String name, String dictCode, String defaultValue){
		if (StringUtils.isNotBlank(dictCode) && StringUtils.isNotBlank(name)){
			for (FundParamCode dict : getDictList(dictCode)){
				if (dictCode.equals(dict.getDictCode()) && name.equals(dict.getName())){
					return dict.getCode();
				}
			}
		}
		return defaultValue;
	}

	
	/**
	 * 返回字典列表（JSON）
	 * @param type
	 * @return
	 */
	public static String getDictListJson(String dictCode){
		return JsonMapper.toJsonString(getDictList(dictCode));
	}

	
}
