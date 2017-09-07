/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.fund.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 基金信息披露Entity
 * @author plq
 * @version 2017-09-07
 */
public class FundInfoOpen extends DataEntity<FundInfoOpen> {
	
	private static final long serialVersionUID = 1L;
	private String fundCode;		// 基金代码
	private String noticeTitle;		// 公告标题
	private String noticeContent;		// 公告内容（如果是文件，怎代表相对地址）
	private String isFile;		// 是否纯文件标识（0代表否，1代表是）
	private String noticeDate;		// 公告日期
	private String noticeTime;		// 公告时间
	private String noticeType;		// 公告类型
	
	public FundInfoOpen() {
		super();
	}

	public FundInfoOpen(String id){
		super(id);
	}

	@Length(min=0, max=50, message="基金代码长度必须介于 0 和 50 之间")
	public String getFundCode() {
		return fundCode;
	}

	public void setFundCode(String fundCode) {
		this.fundCode = fundCode;
	}
	
	@Length(min=0, max=500, message="公告标题长度必须介于 0 和 500 之间")
	public String getNoticeTitle() {
		return noticeTitle;
	}

	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}
	
	public String getNoticeContent() {
		return noticeContent;
	}

	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}
	
	@Length(min=0, max=1, message="是否纯文件标识（0代表否，1代表是）长度必须介于 0 和 1 之间")
	public String getIsFile() {
		return isFile;
	}

	public void setIsFile(String isFile) {
		this.isFile = isFile;
	}
	
	@Length(min=0, max=10, message="公告日期长度必须介于 0 和 10 之间")
	public String getNoticeDate() {
		return noticeDate;
	}

	public void setNoticeDate(String noticeDate) {
		this.noticeDate = noticeDate;
	}
	
	@Length(min=0, max=10, message="公告时间长度必须介于 0 和 10 之间")
	public String getNoticeTime() {
		return noticeTime;
	}

	public void setNoticeTime(String noticeTime) {
		this.noticeTime = noticeTime;
	}
	
	@Length(min=0, max=10, message="公告类型长度必须介于 0 和 10 之间")
	public String getNoticeType() {
		return noticeType;
	}

	public void setNoticeType(String noticeType) {
		this.noticeType = noticeType;
	}
	
}