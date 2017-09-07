package com.thinkgem.jeesite.modules.sys.utils;

import java.util.HashMap;

import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.modules.sys.entity.User;

@SuppressWarnings("rawtypes")
public class QueryMap extends HashMap<String, Object> {

	private static final long serialVersionUID = -4107366701800450232L;
	/*
	 * 分页对象
	 */
	protected Page page;
	/*
	 * 当前登录用户
	 */
	protected User currentUser;
	
	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}
	
	@JsonIgnore
	@XmlTransient
	public User getCurrentUser() {
		if(currentUser == null){
			currentUser = UserUtils.getUser();
		}
		return currentUser;
	}
	
	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}
	
}
