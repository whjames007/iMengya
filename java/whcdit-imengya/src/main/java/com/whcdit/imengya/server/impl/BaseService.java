package com.whcdit.imengya.server.impl;

import java.util.Date;

import com.github.pagehelper.PageHelper;
import com.whcdit.imengya.model.BaseModel;
import com.whcdit.imengya.server.IBaseService;
import com.whcdit.imengya.utils.WhcditConstants;
import com.whcdit.imengya.utils.WhcditTools;

public class BaseService implements IBaseService {
	
	@Override
	public void settingValid(BaseModel param) {
		param.setDataStatusFlag(WhcditConstants.VALID);

	}

	@Override
	public void settingInvalid(BaseModel param) {
		param.setDataStatusFlag(WhcditConstants.INVALID);
	}

	@Override
	public void settingNoid(BaseModel param, Integer noid) {
		settingValid(param);
		param.setNoid(noid);
	}

	@Override
	public void settingWithInsert(BaseModel param, String desc) {
		settingValid(param); // 自动有效
		Integer uid=param.getUid();		
		Date d = new Date();
		param.setFirstCreateBy(uid);
		param.setFirstCreateDate(d);
		String description = null;		
		if (WhcditTools.strNullEmpty(desc)) {
			String pd = param.getDataChangeDesc();
			if (WhcditTools.strNullEmpty(pd)) {
				description = "【Java程序新增的数据】";
			} else {
				description = param.getDataChangeDesc();
			}
		} else {
			description = desc;
		}
		param.setDataChangeDesc(description);
		param.setLastUpdateBy(uid);
		param.setLastUpdateDate(d);
	}

	@Override
	public void settingWithDelete(BaseModel param, String desc) {
		this.settingWithUpdate(param, desc);
		this.settingInvalid(param); // 强制失效
	}

	@Override
	public void settingWithUpdate(BaseModel param, String desc) {
		settingValid(param); // 自动有效
		Integer uid=param.getUid();	
		String description = null;		
		if (WhcditTools.strNullEmpty(desc)) {
			String pd = param.getDataChangeDesc();
			if (WhcditTools.strNullEmpty(pd)) {
				description = "【Java程序更新了此数据】";
			} else {
				description = param.getDataChangeDesc();
			}
		} else {
			description = desc;
		}
		param.setDataChangeDesc(description);
		param.setLastUpdateBy(uid);
		param.setLastUpdateDate(new Date());
	}

	@Override
	public void schedulerWithInsert(BaseModel param, String desc) {
		Integer uid = 20; // 定时任务的用户ID默认为20
		param.setUid(uid);
		this.settingWithInsert(param, desc);
	}

	@Override
	public void schedulerWithUpdate(BaseModel param, String desc) {
		Integer uid = 20; // 定时任务的用户ID默认为20
		param.setUid(uid);
		this.settingWithUpdate(param, desc);
	}

	@Override
	public void pageInit(BaseModel param) {
		// 暂时不考虑超级管理员
		settingValid(param);
		Integer pageNum = param.getPageNum();
		Integer pageSize = param.getPageSize();
		if (pageNum == null) {
			pageNum = 1;
		}
		if (pageSize == null) {
			pageSize = 10;
		}
		PageHelper.startPage(pageNum, pageSize);
	}
}
