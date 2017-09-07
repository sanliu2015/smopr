/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.fund.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 机构信息Entity
 * @author plq
 * @version 2017-09-06
 */
public class FundOrganInfo extends DataEntity<FundOrganInfo> {
	
	private static final long serialVersionUID = 1L;
	private String organCode;		// 机构代码
	private String organName;		// 机构名称
	private String organType;		// 区别各类机构
	private String discName;		// 信息披露负责人姓名
	private String discTel;		// 信息披露负责人电话
	private String discEmail;		// 信息披露负责人email
	private String fax;		// 传真
	private String registerAddr;		// 注册地址
	private String officeAddr;		// 办公地址
	private String postCode;		// 邮政编码
	private String legalRepresentative;		// 法定代表人
	private String organReport;		// 报告
	private String situationDescription;		// 情况说明
	private String commitment;		// 遵规守信
	private String finConfirm;		// 财务确认
	private Date sdate;		// 开始日期
	private Date edate;		// 结束日期
	private String dataSource;		// data_source
	private String isDel;		// is_del
	
	public FundOrganInfo() {
		super();
	}

	public FundOrganInfo(String id){
		super(id);
	}

	@Length(min=0, max=40, message="机构代码长度必须介于 0 和 40 之间")
	public String getOrganCode() {
		return organCode;
	}

	public void setOrganCode(String organCode) {
		this.organCode = organCode;
	}
	
	@Length(min=0, max=200, message="机构名称长度必须介于 0 和 200 之间")
	public String getOrganName() {
		return organName;
	}

	public void setOrganName(String organName) {
		this.organName = organName;
	}
	
	@Length(min=0, max=20, message="区别各类机构长度必须介于 0 和 20 之间")
	public String getOrganType() {
		return organType;
	}

	public void setOrganType(String organType) {
		this.organType = organType;
	}
	
	@Length(min=0, max=120, message="信息披露负责人姓名长度必须介于 0 和 120 之间")
	public String getDiscName() {
		return discName;
	}

	public void setDiscName(String discName) {
		this.discName = discName;
	}
	
	@Length(min=0, max=60, message="信息披露负责人电话长度必须介于 0 和 60 之间")
	public String getDiscTel() {
		return discTel;
	}

	public void setDiscTel(String discTel) {
		this.discTel = discTel;
	}
	
	@Length(min=0, max=60, message="信息披露负责人email长度必须介于 0 和 60 之间")
	public String getDiscEmail() {
		return discEmail;
	}

	public void setDiscEmail(String discEmail) {
		this.discEmail = discEmail;
	}
	
	@Length(min=0, max=60, message="传真长度必须介于 0 和 60 之间")
	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}
	
	@Length(min=0, max=200, message="注册地址长度必须介于 0 和 200 之间")
	public String getRegisterAddr() {
		return registerAddr;
	}

	public void setRegisterAddr(String registerAddr) {
		this.registerAddr = registerAddr;
	}
	
	@Length(min=0, max=200, message="办公地址长度必须介于 0 和 200 之间")
	public String getOfficeAddr() {
		return officeAddr;
	}

	public void setOfficeAddr(String officeAddr) {
		this.officeAddr = officeAddr;
	}
	
	@Length(min=0, max=20, message="邮政编码长度必须介于 0 和 20 之间")
	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	
	@Length(min=0, max=40, message="法定代表人长度必须介于 0 和 40 之间")
	public String getLegalRepresentative() {
		return legalRepresentative;
	}

	public void setLegalRepresentative(String legalRepresentative) {
		this.legalRepresentative = legalRepresentative;
	}
	
	@Length(min=0, max=2000, message="报告长度必须介于 0 和 2000 之间")
	public String getOrganReport() {
		return organReport;
	}

	public void setOrganReport(String organReport) {
		this.organReport = organReport;
	}
	
	@Length(min=0, max=2000, message="情况说明长度必须介于 0 和 2000 之间")
	public String getSituationDescription() {
		return situationDescription;
	}

	public void setSituationDescription(String situationDescription) {
		this.situationDescription = situationDescription;
	}
	
	@Length(min=0, max=2000, message="遵规守信长度必须介于 0 和 2000 之间")
	public String getCommitment() {
		return commitment;
	}

	public void setCommitment(String commitment) {
		this.commitment = commitment;
	}
	
	@Length(min=0, max=2000, message="财务确认长度必须介于 0 和 2000 之间")
	public String getFinConfirm() {
		return finConfirm;
	}

	public void setFinConfirm(String finConfirm) {
		this.finConfirm = finConfirm;
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
	
	@Length(min=0, max=10, message="data_source长度必须介于 0 和 10 之间")
	public String getDataSource() {
		return dataSource;
	}

	public void setDataSource(String dataSource) {
		this.dataSource = dataSource;
	}
	
	@Length(min=0, max=10, message="is_del长度必须介于 0 和 10 之间")
	public String getIsDel() {
		return isDel;
	}

	public void setIsDel(String isDel) {
		this.isDel = isDel;
	}
	
}