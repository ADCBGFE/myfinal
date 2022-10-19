package com.myhome.web.login.model;

import java.util.Objects;

import javax.validation.constraints.NotNull;

public class MemberDTO {
	@NotNull
	private String mbId;
	private String mbPw;
	private String mbPn;
	private String mbEmail;
	private String mbName;
	private String dobDate;
	
	public String getMbId() {
		return mbId;
	}
	public void setMbId(String mbId) {
		this.mbId = mbId;
	}
	public String getMbPw() {
		return mbPw;
	}
	public void setMbPw(String mbPw) {
		this.mbPw = mbPw;
	}
	public String getMbPn() {
		return mbPn;
	}
	public void setMbPn(String mbPn) {
		this.mbPn = mbPn;
	}
	public String getMbEmail() {
		return mbEmail;
	}
	public void setMbEmail(String mbEmail) {
		this.mbEmail = mbEmail;
	}
	public String getMbName() {
		return mbName;
	}
	public void setMbName(String mbName) {
		this.mbName = mbName;
	}
	public String getDobDate() {
		return dobDate;
	}
	public void setDobDate(String dobDate) {
		this.dobDate = dobDate;
	}
 
	
	
}