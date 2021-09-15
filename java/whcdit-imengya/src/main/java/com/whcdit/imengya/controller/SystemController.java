package com.whcdit.imengya.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.whcdit.imengya.model.SystemUserInfo;
import com.whcdit.imengya.server.ISystemService;
import com.whcdit.imengya.utils.WhcditConstants;
import com.whcdit.imengya.utils.WhcditResponse;
import com.whcdit.imengya.utils.WhcditTools;


@RestController
@RequestMapping("/system")
public class SystemController {

	@Autowired
	private ISystemService systemService;
	
	private static final String puser = "/user/";

	@PostMapping(puser+ "login")
	public Object userLogin(@RequestBody SystemUserInfo param) {
		WhcditResponse<SystemUserInfo> res = new WhcditResponse<>();
		String account = param.getSystemUserAccount();
		String pass = param.getSystemUserPassword();
		SystemUserInfo pu = new SystemUserInfo();
		pu.setSystemUserAccount(account);
		List<SystemUserInfo> list = systemService.userList(pu);
		if (WhcditTools.listNullEmpty(list)) {
			res.buildFailure(WhcditConstants.WHCDIT_RESPONSE_30001, "账号或密码错误");
		} else {
			SystemUserInfo target = list.get(0);
			String tacco = target.getSystemUserAccount();
			String tpass = target.getSystemUserPassword();
			if (tacco.equals(account) && tpass.equals(pass)) {
				// 验证通过，获取其权限菜单
				systemService.userLogin(target);
				res.buildSuccess(target, null, null);
			} else {
				res.buildFailure(WhcditConstants.WHCDIT_RESPONSE_30001, "账号或密码错误");
			}
		}
		return res;
	}

	@PostMapping(puser+ "add")
	public Object userAdd(@RequestBody SystemUserInfo param) {
		WhcditResponse<SystemUserInfo> res = new WhcditResponse<>();
		try {
			if (systemService.userRepeat(param)) {
				res.buildFailure(WhcditConstants.WHCDIT_RESPONSE_30002, "用户帐号重复");
			} else {
				param.setLastLoginTime(new Date(0));
				systemService.userAdd(param);
				res.buildSuccess(param, null, null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.buildFailure(WhcditConstants.WHCDIT_RESPONSE_20001, e.getMessage());
		}
		return res;
	}
}
