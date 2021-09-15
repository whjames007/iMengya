package com.whcdit.imengya.model;

import java.util.Date;


public class SystemUserInfo extends BaseModel {

	private Integer systemUserId;

	private String systemUserType;

	private String systemUserAccount;

	private String systemUserNickname;

	private Integer systemRoleId;

	private String systemUserPassword;

	private String systemUserImage;

	private String checkQuestionFlag;

	private String checkQuestionFirst;

	private String checkQuestionSecond;

	private String checkQuestionThird;

	private Date lastLoginTime;

	private String checkAnswerFirst;

	private String checkAnswerSecond;

	private String checkAnswerThird;

	private String systemRoleName; // 前端分页查询

	private SystemMenuInfo menu; // 携带菜单权限
 
	public String getSystemRoleName() {
		return systemRoleName;
	}

	public void setSystemRoleName(String systemRoleName) {
		this.systemRoleName = systemRoleName;
	}

	public SystemMenuInfo getMenu() {
		return menu;
	}

	public void setMenu(SystemMenuInfo menu) {
		this.menu = menu;
	}

	public Integer getSystemUserId() {
		return systemUserId;
	}

	public void setSystemUserId(Integer systemUserId) {
		this.systemUserId = systemUserId;
	}

	public String getSystemUserType() {
		return systemUserType;
	}

	public void setSystemUserType(String systemUserType) {
		this.systemUserType = systemUserType;
	}

	public String getSystemUserAccount() {
		return systemUserAccount;
	}

	public void setSystemUserAccount(String systemUserAccount) {
		this.systemUserAccount = systemUserAccount;
	}

	public String getSystemUserNickname() {
		return systemUserNickname;
	}

	public void setSystemUserNickname(String systemUserNickname) {
		this.systemUserNickname = systemUserNickname;
	}

	public Integer getSystemRoleId() {
		return systemRoleId;
	}

	public void setSystemRoleId(Integer systemRoleId) {
		this.systemRoleId = systemRoleId;
	}

	public String getSystemUserPassword() {
		return systemUserPassword;
	}

	public void setSystemUserPassword(String systemUserPassword) {
		this.systemUserPassword = systemUserPassword;
	}

	public String getSystemUserImage() {
		return systemUserImage;
	}

	public void setSystemUserImage(String systemUserImage) {
		this.systemUserImage = systemUserImage;
	}

	public String getCheckQuestionFlag() {
		return checkQuestionFlag;
	}

	public void setCheckQuestionFlag(String checkQuestionFlag) {
		this.checkQuestionFlag = checkQuestionFlag;
	}

	public String getCheckQuestionFirst() {
		return checkQuestionFirst;
	}

	public void setCheckQuestionFirst(String checkQuestionFirst) {
		this.checkQuestionFirst = checkQuestionFirst;
	}

	public String getCheckQuestionSecond() {
		return checkQuestionSecond;
	}

	public void setCheckQuestionSecond(String checkQuestionSecond) {
		this.checkQuestionSecond = checkQuestionSecond;
	}

	public String getCheckQuestionThird() {
		return checkQuestionThird;
	}

	public void setCheckQuestionThird(String checkQuestionThird) {
		this.checkQuestionThird = checkQuestionThird;
	}

	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public String getCheckAnswerFirst() {
		return checkAnswerFirst;
	}

	public void setCheckAnswerFirst(String checkAnswerFirst) {
		this.checkAnswerFirst = checkAnswerFirst;
	}

	public String getCheckAnswerSecond() {
		return checkAnswerSecond;
	}

	public void setCheckAnswerSecond(String checkAnswerSecond) {
		this.checkAnswerSecond = checkAnswerSecond;
	}

	public String getCheckAnswerThird() {
		return checkAnswerThird;
	}

	public void setCheckAnswerThird(String checkAnswerThird) {
		this.checkAnswerThird = checkAnswerThird;
	}
}