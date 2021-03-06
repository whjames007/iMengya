package com.whcdit.imengya.server.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageInfo;
import com.whcdit.imengya.mapper.SystemMenuInfoMapper;
import com.whcdit.imengya.mapper.SystemRoleInfoMapper;
import com.whcdit.imengya.mapper.SystemRoleRelationMapper;
import com.whcdit.imengya.mapper.SystemUserInfoMapper;
import com.whcdit.imengya.model.SystemMenuInfo;
import com.whcdit.imengya.model.SystemRoleInfo;
import com.whcdit.imengya.model.SystemRoleRelation;
import com.whcdit.imengya.model.SystemUserInfo;
import com.whcdit.imengya.server.ISystemService;
import com.whcdit.imengya.utils.WhcditConstants;
import com.whcdit.imengya.utils.WhcditTools;

@Service
public class SystemService extends BaseService implements ISystemService {

	@Autowired
	private SystemUserInfoMapper systemUserInfoMapper;

	@Autowired
	private SystemRoleInfoMapper systemRoleInfoMapper;

	@Autowired
	private SystemRoleRelationMapper systemRoleRelationMapper;

	@Autowired
	private SystemMenuInfoMapper systemMenuInfoMapper;

//	@Autowired
//	private SystemConfigInfoMapper systemConfigInfoMapper;
//
//	@Autowired
//	private SystemCalendarInfoMapper systemCalendarInfoMapper;
//
//	@Autowired
//	private SystemCronInfoMapper systemCronInfoMapper;
//
//	@Autowired
//	private SystemDepartmentInfoMapper systemDepartmentInfoMapper;
//
//	@Autowired
//	private SystemCenterInfoMapper systemCenterInfoMapper;

	private static final Logger log = LoggerFactory.getLogger(SystemService.class);

	@Transactional
	@Override
	public int userAdd(SystemUserInfo param) {
		// 不论是新增还是编辑，都要重构账号名称的联合字段
		super.settingWithInsert(param, "新增一条用户数据");
		return systemUserInfoMapper.insertSelective(param);
	}

	@Transactional
	@Override
	public int userDel(SystemUserInfo param) {
		super.settingWithDelete(param, "假删除一条用户数据");
		int res = systemUserInfoMapper.updateByPrimaryKeySelective(param);
		return res;
	}

	@Override
	public int userEdit(SystemUserInfo param) {
		// 不论是新增还是编辑，都要重构账号名称的联合字段
		super.settingWithUpdate(param, "修改一条用户数据");
		int res = systemUserInfoMapper.updateByPrimaryKeySelective(param);
		return res;
	}

	@Override
	public PageInfo<SystemUserInfo> userPage(SystemUserInfo param) {
		super.pageInit(param);
		List<SystemUserInfo> list = systemUserInfoMapper.selectWithMorethan(param);
		PageInfo<SystemUserInfo> res = new PageInfo<>(list);
		return res;
	}

	@Override
	public boolean userRepeat(SystemUserInfo param) {
		boolean bool = true;
		SystemUserInfo check = new SystemUserInfo();
		super.settingNoid(check, param.getSystemUserId());
		check.setSystemUserAccount(param.getSystemUserAccount());
		List<SystemUserInfo> list = this.userList(check);
		if (WhcditTools.listNullEmpty(list)) {
			// 不重复就返回假
			bool = false;
		} else {
			// 出现重复就返回真
			bool = true;
			log.warn("【用户账号[{}]有重复】", param.getSystemUserAccount());
		}
		return bool;
	}

	@Override
	public List<SystemUserInfo> userList(SystemUserInfo param) {
		super.settingValid(param);
		return systemUserInfoMapper.selectWithCondition(param);
	}

	@Override
	public void userLogin(SystemUserInfo param) {
		// 先更新最后登录时间
		SystemUserInfo psui = new SystemUserInfo();
		psui.setSystemUserId(param.getSystemUserId());
		psui.setLastLoginTime(new Date());
		systemUserInfoMapper.updateByPrimaryKeySelective(psui);
		// 获取登录者的角色信息
		SystemRoleInfo role = systemRoleInfoMapper.selectByPrimaryKey(param.getSystemRoleId());
		param.setSystemRoleName(role.getSystemRoleName());
		// 获取登录者所属角色的菜单树
		SystemMenuInfo root = findRoleMenu(param.getSystemRoleId());
		param.setMenu(root);
	}

	private SystemMenuInfo findRoleMenu(Integer rid) {
		// 1、获取全部菜单数据
		List<SystemMenuInfo> menus = this.menuList(new SystemMenuInfo());
		// 构造根节点
		SystemMenuInfo root = findSingleMenu(1, menus);
		root.setChilds(new ArrayList<>());

		// 获取某角色的关联关系的菜单
		SystemMenuInfo prel = new SystemMenuInfo();
		super.settingValid(prel);
		prel.setSystemRoleId(rid);
		List<SystemMenuInfo> relations = this.menuList(prel);

		// 基于此不完整的关联关系，重构完整架构（因为数据库中保存的是前端tree组件提供的不完整菜单ID，可能包含根节点，也可能包含分支节点）
		Map<Integer, SystemMenuInfo> branchs = new TreeMap<>();
		for (SystemMenuInfo rel : relations) {
			Integer mid = rel.getSystemMenuId();
			String mtype = rel.getSystemMenuType();
			if (WhcditConstants.ROOT.equals(mtype)) {
				// 如果关联关系中有根节点，忽略掉
				continue;
			} else if (WhcditConstants.BRANCH.equals(mtype)) {
				// 如果是分支节点，先检查集合中有无自己，如果没有，则放入map集合
				SystemMenuInfo branch = branchs.get(rel.getSystemMenuId());
				if (null == branch) {
					rel.setChilds(new ArrayList<>());
					branchs.put(mid, rel);
				} else {
					// 如果已经有自己了，就算了
					continue;
				}
			} else {
				// 如果是叶节点，先检查map集合中是否有自己的上级？
				Integer pid = rel.getSystemParentId();
				SystemMenuInfo parent = branchs.get(pid);
				if (null == parent) {
					// 如果map集合中没有自己的上级，要倒追溯其上级分支节点
					parent = findSingleMenu(pid, menus);
					parent.setChilds(new ArrayList<>());
					branchs.put(pid, parent);
				}
				// 存储三级导航URL和判断可关闭布尔标识，服务于前端选项卡组件和面包屑组件
				rel.setSystemFirstName(root.getSystemMenuName());
				rel.setSystemSecondName(parent.getSystemMenuName());
				rel.setSystemThirdName(rel.getSystemMenuName());
				// 判断可关闭布尔标识
				boolean clo = WhcditConstants.YES.equals(rel.getSystemMenuClose()) ? true : false;
				rel.setSystemBoolClose(clo);
				// 将叶节点放入其上级分支节点的集合
				branchs.get(pid).getChilds().add(rel);
			}
		}
		branchs.forEach((k, v) -> {
			root.getChilds().add(v);
		});
		return root;
	}

	private SystemMenuInfo findSingleMenu(Integer id, List<SystemMenuInfo> menus) {
		SystemMenuInfo res = null;
		for (SystemMenuInfo m : menus) {
			Integer mid = m.getSystemMenuId();
			if (id.equals(mid)) {
				res = m;
				break;
			}
		}
		return res;
	}

	@Override
	public List<SystemRoleInfo> roleList(SystemRoleInfo param) {
		super.settingValid(param);
		return systemRoleInfoMapper.selectWithCondition(param);
	}

	@Override
	public PageInfo<SystemRoleInfo> rolePage(SystemRoleInfo param) {
		super.pageInit(param);
		List<SystemRoleInfo> list = systemRoleInfoMapper.selectWithCondition(param);
		// 获取每个角色的权限菜单数据
		for (SystemRoleInfo role : list) {
			List<SystemMenuInfo> menus = systemMenuInfoMapper.selectWithRole(role);
			role.setMenus(menus);
		}
		PageInfo<SystemRoleInfo> res = new PageInfo<>(list);
		return res;
	}

	@Transactional
	@Override
	public int roleEdit(SystemRoleInfo param) {
		super.settingWithUpdate(param, "修改一条角色数据");
		int res = systemRoleInfoMapper.updateByPrimaryKeySelective(param);
		// 先清理目标角色的关联关系
		SystemRoleRelation psrr = new SystemRoleRelation();
		psrr.setSystemRoleId(param.getSystemRoleId());
		systemRoleRelationMapper.deleteWithCondition(psrr);
		// 再重构目标角色的关联关系（维持前端tree组件提供的不完整菜单ID，可能包含根节点，也可能包含分支节点，留待登录方法中进行倒追溯）
		psrr.setUid(param.getUid());
		for (Integer lid : param.getLeafs()) {
			super.settingWithInsert(psrr, "重构目标角色的关联关系（维持前端tree组件提供的不完整菜单ID，可能包含根节点，也可能包含分支节点，留待登录方法中进行倒追溯）");
			psrr.setSystemMenuId(lid);
			psrr.setRoleRelationId(null);
			systemRoleRelationMapper.insertSelective(psrr);
		}
		return res;
	}

	@Override
	public SystemMenuInfo menuTree(SystemMenuInfo param) {
		SystemMenuInfo root = systemMenuInfoMapper.selectByPrimaryKey(1);
		SystemMenuInfo pbranch = new SystemMenuInfo();
		super.settingValid(pbranch);
		pbranch.setSystemParentId(root.getSystemMenuId());
		List<SystemMenuInfo> branchs = systemMenuInfoMapper.selectWithCondition(pbranch);
		for (SystemMenuInfo bra : branchs) {
			SystemMenuInfo pleaf = new SystemMenuInfo();
			super.settingValid(pleaf);
			pleaf.setSystemParentId(bra.getSystemMenuId());
			List<SystemMenuInfo> leafs = systemMenuInfoMapper.selectWithCondition(pleaf);
			bra.setChilds(leafs);
		}
		root.setChilds(branchs);
		return root;
	}

	@Override
	public List<SystemMenuInfo> menuList(SystemMenuInfo param) {
		super.settingValid(param);
		return systemMenuInfoMapper.selectWithCondition(param);
	}

	@Override
	public int menuEdit(SystemMenuInfo param) {
		super.settingWithUpdate(param, "修改菜单数据");
		return systemMenuInfoMapper.updateByPrimaryKeySelective(param);
	}

//	@Override
//	public int configAdd(SystemConfigInfo param) {
//		super.settingWithInsert(param, "新增一条参数配置数据");
//		int res = systemConfigInfoMapper.insertSelective(param);
//		return res;
//	}
//
//	@Override
//	public int configDel(SystemConfigInfo param) {
//		super.settingWithUpdate(param, "假删除一条参数配置数据");
//		super.settingInvalid(param);
//		int res = systemConfigInfoMapper.updateByPrimaryKeySelective(param);
//		return res;
//	}
//
//	@Override
//	public int configEdit(SystemConfigInfo param) {
//		super.settingWithUpdate(param, "修改一条参数配置数据");
//		int res = systemConfigInfoMapper.updateByPrimaryKeySelective(param);
//		return res;
//	}
//
//	@Override
//	public PageInfo<SystemConfigInfo> configPage(SystemConfigInfo param) {
//		super.pageInit(param);
//		List<SystemConfigInfo> list = systemConfigInfoMapper.selectWithCondition(param);
//		PageInfo<SystemConfigInfo> res = new PageInfo<>(list);
//		return res;
//	}
//
//	@Override
//	public Integer calendarBuild(SystemCalendarInfo param) {
//		Integer num = 0;
//		Integer year = param.getSystemCalendarYear();
//		Calendar cal = Calendar.getInstance(); // 获得当前日期对象
//		cal.clear(); // 清除信息
//		cal.set(Calendar.YEAR, year);
//		for (int i = 0; i < 12; i++) {
//			cal.set(Calendar.MONTH, i);
//			cal.set(Calendar.DAY_OF_MONTH, 1);
//			int max = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
//			for (int j = 1; j <= max; j++) {
//				cal.set(Calendar.DAY_OF_MONTH, j);
//				SystemCalendarInfo info = new SystemCalendarInfo();
//				info.setUid(param.getUid());
//				super.settingWithInsert(param, "构造日期数据");
//				Date date = cal.getTime();
//				info.setSystemCalendarTime(date);
//				info.setSystemCalendarYear(year);
//				info.setSystemCalendarMonth(i + 1);
//				info.setSystemCalendarDay(j);
//				info.setSystemCalendarType(WhcditConstants.YES);
//				info.setSystemCalendarDesc("工作日");
//				if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
//					info.setSystemCalendarType(WhcditConstants.NO);
//					info.setSystemCalendarDesc("周六双休");
//				}
//				if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
//					info.setSystemCalendarType(WhcditConstants.NO);
//					info.setSystemCalendarDesc("周日双休");
//				}
//				systemCalendarInfoMapper.insertSelective(info);
//				num++;
//			}
//		}
//		return num;
//	}
//
//	@Override
//	public int calendarEdit(SystemCalendarInfo param) {
//		super.settingWithUpdate(param, "每一次日历变更，都要影响忙闲基础数据");
//		int num = systemCalendarInfoMapper.updateWithCondition(param);
//		log.info("每一次日历变更，都要影响忙闲基础数据");
//		enterpriseService.appoCalendarEdit(param);
//		return num;
//	}
//
//	@Override
//	public List<SystemCalendarInfo> calendarList(SystemCalendarInfo param) {
//		super.settingValid(param);
//		return systemCalendarInfoMapper.selectWithCondition(param);
//	}
//
//	@Override
//	public List<SystemCalendarInfo> calendarDist(SystemCalendarInfo param) {
//		super.settingValid(param);
//		return systemCalendarInfoMapper.selectWithDistinct(param);
//	}
//
//	@Override
//	public int cronEdit(SystemCronInfo param, String desc) {
//		if (WhcditTools.strNullEmpty(desc)) {
//			desc = "数据变更啦！";
//		}
//		super.settingWithUpdate(param, desc);
//
//		return systemCronInfoMapper.updateByPrimaryKeySelective(param);
//	}
//
//	@Override
//	public List<SystemCronInfo> cronList(SystemCronInfo param) {
//		super.settingValid(param);
//		return systemCronInfoMapper.selectWithCondition(param);
//	}
//
//	@Override
//	public int deptAdd(SystemDepartmentInfo param) {
//		super.settingWithInsert(param, "新增一条部门数据");
//		int res = systemDepartmentInfoMapper.insertSelective(param);
//		return res;
//	}
//
//	@Override
//	public int deptDel(SystemDepartmentInfo param) {
//		super.settingWithUpdate(param, "假删除一条部门数据");
//		super.settingInvalid(param);
//		int res = systemDepartmentInfoMapper.updateByPrimaryKeySelective(param);
//		return res;
//	}
//
//	@Override
//	public int deptEdit(SystemDepartmentInfo param) {
//		super.settingWithUpdate(param, "修改一条部门数据");
//		int res = systemDepartmentInfoMapper.updateByPrimaryKeySelective(param);
//		return res;
//	}
//
//	@Override
//	public List<SystemDepartmentInfo> deptList(SystemDepartmentInfo param) {
//		super.settingValid(param);
//		return systemDepartmentInfoMapper.selectWithCondition(param);
//	}
//
//	@Override
//	public PageInfo<SystemDepartmentInfo> deptPage(SystemDepartmentInfo param) {
//		super.pageInit(param);
//		List<SystemDepartmentInfo> list = systemDepartmentInfoMapper.selectWithMorethan(param);
//		PageInfo<SystemDepartmentInfo> res = new PageInfo<>(list);
//		return res;
//	}
//
//	@Override
//	public String deptCheck(SystemDepartmentInfo param) {
//		SystemUserInfo psu = new SystemUserInfo();
//		super.settingValid(psu);
//		psu.setSystemDepartmentId(param.getSystemDepartmentId());
//		List<SystemUserInfo> users = this.userList(psu);
//		if (WhcditTools.listNullEmpty(users)) {
//			return WhcditConstants.SUCCESS;
//		} else {
//			return WhcditConstants.WHCDIT_RESPONSE_30005;
//		}
//	}
//
//	@Override
//	public int centerAdd(SystemCenterInfo param) {
//		super.settingWithInsert(param, "新增一条中心数据");
//		return systemCenterInfoMapper.insertSelective(param);
//	}
//
//	@Override
//	public String centerCheck(SystemCenterInfo param) {
//		return null;
//	}
//
//	@Override
//	public int centerDel(SystemCenterInfo param) {
//		super.settingWithUpdate(param, "假删除一条中心数据");
//		super.settingInvalid(param);
//		return systemCenterInfoMapper.updateByPrimaryKeySelective(param);
//	}
//
//	@Override
//	public int centerEdit(SystemCenterInfo param) {
//		super.settingWithUpdate(param, "修改一条中心数据");
//		return systemCenterInfoMapper.updateByPrimaryKeySelective(param);
//	}
//
//	@Override
//	public List<SystemCenterInfo> centerList(SystemCenterInfo param) {
//		super.settingValid(param);
//		return systemCenterInfoMapper.selectWithCondition(param);
//	}
}
