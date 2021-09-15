package com.whcdit.imengya.server;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.whcdit.imengya.model.SystemMenuInfo;
import com.whcdit.imengya.model.SystemRoleInfo;
import com.whcdit.imengya.model.SystemUserInfo; 

public interface ISystemService extends IBaseService {
	// 项目系列
	public int userAdd(SystemUserInfo param);

	public int userDel(SystemUserInfo param);

	public int userEdit(SystemUserInfo param);

	public PageInfo<SystemUserInfo> userPage(SystemUserInfo param);

	public boolean userRepeat(SystemUserInfo param);

	public List<SystemUserInfo> userList(SystemUserInfo param);

	public void userLogin(SystemUserInfo user);

	// 角色系列
	public List<SystemRoleInfo> roleList(SystemRoleInfo param);

//	public PageInfo<SystemRoleInfo> rolePage(SystemRoleInfo param);
//
//	public int roleEdit(SystemRoleInfo param);
//
//	// 菜单系列
//	public SystemMenuInfo menuTree(SystemMenuInfo param);

	public List<SystemMenuInfo> menuList(SystemMenuInfo param);

//	public int menuEdit(SystemMenuInfo param);
//
//	// 参数配置系列
//	public int configAdd(SystemConfigInfo param);
//
//	public int configDel(SystemConfigInfo param);
//
//	public int configEdit(SystemConfigInfo param);
//
//	public PageInfo<SystemConfigInfo> configPage(SystemConfigInfo param);
//
//	public Integer calendarBuild(SystemCalendarInfo param);
//
//	public int calendarEdit(SystemCalendarInfo param);
//
//	public List<SystemCalendarInfo> calendarList(SystemCalendarInfo param);
//
//	public List<SystemCalendarInfo> calendarDist(SystemCalendarInfo param);
//
//	/**
//	 * 【定时任务编辑】【宋鹏-18091】【武汉】【2020-08-23】
//	 */
//	public int cronEdit(SystemCronInfo param, String desc);
//
//	/**
//	 * 【定时任务列表查询】【宋鹏-18091】【武汉】【2020-08-23】
//	 */
//	public List<SystemCronInfo> cronList(SystemCronInfo param);
//
//	public int deptAdd(SystemDepartmentInfo param);
//
//	public int deptDel(SystemDepartmentInfo param);
//
//	public int deptEdit(SystemDepartmentInfo param);
//
//	public List<SystemDepartmentInfo> deptList(SystemDepartmentInfo param);
//
//	public PageInfo<SystemDepartmentInfo> deptPage(SystemDepartmentInfo param);
//
//	public String deptCheck(SystemDepartmentInfo param);
//
//	public int centerAdd(SystemCenterInfo param);
//
//	public String centerCheck(SystemCenterInfo param);
//
//	public int centerDel(SystemCenterInfo param);
//
//	public int centerEdit(SystemCenterInfo param);
//
//	public List<SystemCenterInfo> centerList(SystemCenterInfo param);

}
