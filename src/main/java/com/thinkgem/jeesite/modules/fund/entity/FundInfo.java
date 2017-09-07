/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.fund.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 基金信息Entity
 * @author plq
 * @version 2017-09-06
 */
public class FundInfo extends DataEntity<FundInfo> {
	
	private static final long serialVersionUID = 1L;
	private String fundCode;		// 基金代码
	private String fundName;		// 基金名称
	private String fundHandler;		// 管理人
	private String fundTrustee;		// 托管人
	private String fundRegister;	// 基金注册机构
	private String fundOperMode;		// 基金运作方式
	private String fundType;		// 基金类型 证券 股权 创投 其他
	private String inveScope;		// 投资范围
	private String isFof;		// 是否FOF
	private String inveForm;		// 投资风格
	private Date fundSdate;		// 基金成立日
	private String duration;		// 存续期
	private String perfBenc;		// 业绩基准
	private String isClassify;		// 是否分级
	private String repayType;		// 业绩报酬计提方式
	private String repayPerfBenc;		// 业绩报酬的业绩基准
	private Long repayPro;		// 业绩报酬计提比例
	private String fundAdvisor;		// 投资顾问
	private String netValueCycle;		// 净值披露周期
	private String isClear;		// 是否清算结束
	private Date fundClearDate;		// 清算日期
	private Date sdate;		// 数据开始时间
	private Date edate;		// 数据截止时间
	private String dataSource;		// 数据来源 0-GP3WH 1-导入 2-公开市场 3-GFOP
	
	public FundInfo() {
		super();
	}

	public FundInfo(String id){
		super(id);
	}

	@Length(min=1, max=10, message="基金代码长度必须介于 1 和 10 之间")
	public String getFundCode() {
		return fundCode;
	}

	public void setFundCode(String fundCode) {
		this.fundCode = fundCode;
	}
	
	@Length(min=1, max=500, message="基金名称长度必须介于 1 和 500 之间")
	public String getFundName() {
		return fundName;
	}

	public void setFundName(String fundName) {
		this.fundName = fundName;
	}
	
	@Length(min=0, max=500, message="管理人长度必须介于 0 和 500 之间")
	public String getFundHandler() {
		return fundHandler;
	}

	public void setFundHandler(String fundHandler) {
		this.fundHandler = fundHandler;
	}
	
	@Length(min=0, max=500, message="托管人长度必须介于 0 和 500 之间")
	public String getFundTrustee() {
		return fundTrustee;
	}

	public void setFundTrustee(String fundTrustee) {
		this.fundTrustee = fundTrustee;
	}
	
	@Length(min=0, max=500, message="注册登记人长度必须介于 0 和 500 之间")
	public String getFundRegister() {
		return fundRegister;
	}

	public void setFundRegister(String fundRegister) {
		this.fundRegister = fundRegister;
	}

	@Length(min=0, max=500, message="基金运作方式长度必须介于 0 和 500 之间")
	public String getFundOperMode() {
		return fundOperMode;
	}

	public void setFundOperMode(String fundOperMode) {
		this.fundOperMode = fundOperMode;
	}
	
	@Length(min=0, max=500, message="基金类型 证券 股权 创投 其他长度必须介于 0 和 500 之间")
	public String getFundType() {
		return fundType;
	}

	public void setFundType(String fundType) {
		this.fundType = fundType;
	}
	
	@Length(min=0, max=500, message="投资范围长度必须介于 0 和 500 之间")
	public String getInveScope() {
		return inveScope;
	}

	public void setInveScope(String inveScope) {
		this.inveScope = inveScope;
	}
	
	@Length(min=0, max=500, message="是否FOF长度必须介于 0 和 500 之间")
	public String getIsFof() {
		return isFof;
	}

	public void setIsFof(String isFof) {
		this.isFof = isFof;
	}
	
	@Length(min=0, max=500, message="投资风格长度必须介于 0 和 500 之间")
	public String getInveForm() {
		return inveForm;
	}

	public void setInveForm(String inveForm) {
		this.inveForm = inveForm;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getFundSdate() {
		return fundSdate;
	}

	public void setFundSdate(Date fundSdate) {
		this.fundSdate = fundSdate;
	}
	
	@Length(min=0, max=11, message="存续期长度必须介于 0 和 11 之间")
	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}
	
	@Length(min=0, max=500, message="业绩基准长度必须介于 0 和 500 之间")
	public String getPerfBenc() {
		return perfBenc;
	}

	public void setPerfBenc(String perfBenc) {
		this.perfBenc = perfBenc;
	}
	
	@Length(min=0, max=8, message="是否分级长度必须介于 0 和 8 之间")
	public String getIsClassify() {
		return isClassify;
	}

	public void setIsClassify(String isClassify) {
		this.isClassify = isClassify;
	}
	
	@Length(min=0, max=500, message="业绩报酬计提方式长度必须介于 0 和 500 之间")
	public String getRepayType() {
		return repayType;
	}

	public void setRepayType(String repayType) {
		this.repayType = repayType;
	}
	
	@Length(min=0, max=500, message="业绩报酬的业绩基准长度必须介于 0 和 500 之间")
	public String getRepayPerfBenc() {
		return repayPerfBenc;
	}

	public void setRepayPerfBenc(String repayPerfBenc) {
		this.repayPerfBenc = repayPerfBenc;
	}
	
	public Long getRepayPro() {
		return repayPro;
	}

	public void setRepayPro(Long repayPro) {
		this.repayPro = repayPro;
	}
	
	@Length(min=0, max=500, message="投资顾问长度必须介于 0 和 500 之间")
	public String getFundAdvisor() {
		return fundAdvisor;
	}

	public void setFundAdvisor(String fundAdvisor) {
		this.fundAdvisor = fundAdvisor;
	}
	
	@Length(min=0, max=500, message="净值披露周期长度必须介于 0 和 500 之间")
	public String getNetValueCycle() {
		return netValueCycle;
	}

	public void setNetValueCycle(String netValueCycle) {
		this.netValueCycle = netValueCycle;
	}
	
	@Length(min=0, max=8, message="是否清算结束长度必须介于 0 和 8 之间")
	public String getIsClear() {
		return isClear;
	}

	public void setIsClear(String isClear) {
		this.isClear = isClear;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getFundClearDate() {
		return fundClearDate;
	}

	public void setFundClearDate(Date fundClearDate) {
		this.fundClearDate = fundClearDate;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getSdate() {
		return sdate;
	}

	public void setSdate(Date sdate) {
		this.sdate = sdate;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getEdate() {
		return edate;
	}

	public void setEdate(Date edate) {
		this.edate = edate;
	}
	
	@Length(min=0, max=1, message="数据来源 0-GP3WH 1-导入 2-公开市场 3-GFOP长度必须介于 0 和 1 之间")
	public String getDataSource() {
		return dataSource;
	}

	public void setDataSource(String dataSource) {
		this.dataSource = dataSource;
	}
	
}