package com.whcdit.imengya.model;

import java.util.Date;

public class BaseModel {

	protected Integer uid; // 通用参数：用户ID

	protected Integer noid; // 通用参数：非本id（主要用于编辑功能的校验方法中）

	protected Integer pageNum;// 通用参数：分页插件的页数

	protected Integer pageSize;// 通用参数：分页插件的行数

	protected Date dateBegin; // 通用参数：查询的开始时间

	protected Date dateEnd; // 通用参数：查询的结束时间

	protected Integer firstCreateBy; // 运维字段：初始创建人员

	protected Date firstCreateDate; // 运维字段：初始创建时间

	protected String dataStatusFlag; // 运维字段：数据状态标识

	protected Integer dataRegionId; // 运维字段：数据区域ID

	protected String dataChangeType; // 运维字段：数据变化类型

	protected String dataChangeDesc; // 运维字段：数据变化描述

	protected Integer lastUpdateBy; // 运维字段：最后修改人员

	protected Date lastUpdateDate; // 运维字段：最后修改日期

	protected String firstCreateName; // 辅助字段：初始创建者的昵称

	protected String lastUpdateName;// 辅助字段：最后修改者的昵称

	protected String secondAccount; // 辅助字段：二验框账号

	protected String secondPassword;// 辅助字段：二验框密码

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public Integer getNoid() {
		return noid;
	}

	public void setNoid(Integer noid) {
		this.noid = noid;
	}

	public Integer getPageNum() {
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Date getDateBegin() {
		return dateBegin;
	}

	public void setDateBegin(Date dateBegin) {
		this.dateBegin = dateBegin;
	}

	public Date getDateEnd() {
		return dateEnd;
	}

	public void setDateEnd(Date dateEnd) {
		this.dateEnd = dateEnd;
	}

	public Integer getFirstCreateBy() {
		return firstCreateBy;
	}

	public void setFirstCreateBy(Integer firstCreateBy) {
		this.firstCreateBy = firstCreateBy;
	}

	public Date getFirstCreateDate() {
		return firstCreateDate;
	}

	public void setFirstCreateDate(Date firstCreateDate) {
		this.firstCreateDate = firstCreateDate;
	}

	public String getDataStatusFlag() {
		return dataStatusFlag;
	}

	public void setDataStatusFlag(String dataStatusFlag) {
		this.dataStatusFlag = dataStatusFlag;
	}

	public Integer getDataRegionId() {
		return dataRegionId;
	}

	public void setDataRegionId(Integer dataRegionId) {
		this.dataRegionId = dataRegionId;
	}

	public String getDataChangeType() {
		return dataChangeType;
	}

	public void setDataChangeType(String dataChangeType) {
		this.dataChangeType = dataChangeType;
	}

	public String getDataChangeDesc() {
		return dataChangeDesc;
	}

	public void setDataChangeDesc(String dataChangeDesc) {
		this.dataChangeDesc = dataChangeDesc;
	}

	public Integer getLastUpdateBy() {
		return lastUpdateBy;
	}

	public void setLastUpdateBy(Integer lastUpdateBy) {
		this.lastUpdateBy = lastUpdateBy;
	}

	public Date getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	public String getFirstCreateName() {
		return firstCreateName;
	}

	public void setFirstCreateName(String firstCreateName) {
		this.firstCreateName = firstCreateName;
	}

	public String getLastUpdateName() {
		return lastUpdateName;
	}

	public void setLastUpdateName(String lastUpdateName) {
		this.lastUpdateName = lastUpdateName;
	}

	public String getSecondAccount() {
		return secondAccount;
	}

	public void setSecondAccount(String secondAccount) {
		this.secondAccount = secondAccount;
	}

	public String getSecondPassword() {
		return secondPassword;
	}

	public void setSecondPassword(String secondPassword) {
		this.secondPassword = secondPassword;
	}

}