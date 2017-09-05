package com.thinkgem.jeesite.modules.fund.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 基金字典码表Entity
 * @author plq
 * @version 2017-05-17
 */
public class FundParamCode extends DataEntity<FundParamCode> {
	
	private static final long serialVersionUID = 1L;
	private String dictCode;		// 字典code
	private String code;		// 代码
	private String name;		// 名称
	
	public FundParamCode() {
		super();
	}

	public FundParamCode(String id){
		super(id);
	}

	@Length(min=0, max=50, message="字典代码长度必须介于 0 和 50 之间")
	public String getDictCode() {
		return dictCode;
	}

	public void setDictCode(String dictCode) {
		this.dictCode = dictCode;
	}
	
	@Length(min=1, max=200, message="代码长度必须介于 1 和 200 之间")
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	@Length(min=1, max=50, message="名称长度必须介于 1 和 50 之间")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}