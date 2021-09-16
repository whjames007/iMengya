package com.whcdit.imengya.model;

import java.util.List;

public class SystemRoleInfo extends BaseModel {
    private Integer systemRoleId;

    private String systemRoleName;

    private String systemRoleCode;

    private String systemRoleDesc;
    
    private List<SystemRoleRelation> relations; // 后台获取的关联菜单
    
    private List<SystemMenuInfo> menus; // 后台获取的关联菜单
    
    private List<Integer> leafs; // 前端传递的菜单ID集合

    public Integer getSystemRoleId() {
        return systemRoleId;
    }

    public void setSystemRoleId(Integer systemRoleId) {
        this.systemRoleId = systemRoleId;
    }

    public String getSystemRoleName() {
        return systemRoleName;
    }

    public void setSystemRoleName(String systemRoleName) {
        this.systemRoleName = systemRoleName;
    }

    public String getSystemRoleCode() {
        return systemRoleCode;
    }

    public void setSystemRoleCode(String systemRoleCode) {
        this.systemRoleCode = systemRoleCode;
    }

    public String getSystemRoleDesc() {
        return systemRoleDesc;
    }

    public void setSystemRoleDesc(String systemRoleDesc) {
        this.systemRoleDesc = systemRoleDesc;
    }

	public List<SystemRoleRelation> getRelations() {
		return relations;
	}

	public void setRelations(List<SystemRoleRelation> relations) {
		this.relations = relations;
	}

	public List<Integer> getLeafs() {
		return leafs;
	}

	public void setLeafs(List<Integer> leafs) {
		this.leafs = leafs;
	}

	public List<SystemMenuInfo> getMenus() {
		return menus;
	}

	public void setMenus(List<SystemMenuInfo> menus) {
		this.menus = menus;
	}
}