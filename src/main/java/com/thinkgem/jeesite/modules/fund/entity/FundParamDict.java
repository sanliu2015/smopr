package com.thinkgem.jeesite.modules.fund.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 基金字典管理Entity
 * @author plq
 * @version 2017-05-17
 */
public class FundParamDict extends DataEntity<FundParamDict> {
	
	private static final long serialVersionUID = 1L;
	private String dictCode;		// 字典代码
	private String dictName;		// 字典名称
	
	public FundParamDict() {
		super();
	}

	public FundParamDict(String id){
		super(id);
	}

	@Length(min=0, max=50, message="字典代码长度必须介于 0 和 50 之间")
	public String getDictCode() {
		return dictCode;
	}

	public void setDictCode(String dictCode) {
		this.dictCode = dictCode;
	}
	
	@Length(min=0, max=50, message="字典名称长度必须介于 0 和 50 之间")
	public String getDictName() {
		return dictName;
	}

	public void setDictName(String dictName) {
		this.dictName = dictName;
	}
	
}