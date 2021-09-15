package com.whcdit.imengya.model;

import java.util.List;

public class SystemMenuInfo extends BaseModel {
    private Integer systemMenuId;

    private String systemMenuName;

    private String systemMenuType;

    private String systemMenuIcon;

    private String systemMenuUrl;

    private Integer systemParentId;

    private String systemMenuClose;

    private String systemMenuDesc;
    
    private Integer roleRelationId; // 关联关系

    private Integer systemRoleId; // 关联关系
    
    private List<SystemMenuInfo> childs; // 子菜单集合

    private String systemFirstName; // 面包屑
    
    private String systemSecondName; // 面包屑
    
    private String systemThirdName; // 面包屑

    private boolean systemBoolClose; // 选项卡

    public Integer getSystemMenuId() {
        return systemMenuId;
    }

    public void setSystemMenuId(Integer systemMenuId) {
        this.systemMenuId = systemMenuId;
    }

    public String getSystemMenuName() {
        return systemMenuName;
    }

    public void setSystemMenuName(String systemMenuName) {
        this.systemMenuName = systemMenuName;
    }

    public String getSystemMenuType() {
        return systemMenuType;
    }

    public void setSystemMenuType(String systemMenuType) {
        this.systemMenuType = systemMenuType;
    }

    public String getSystemMenuIcon() {
        return systemMenuIcon;
    }

    public void setSystemMenuIcon(String systemMenuIcon) {
        this.systemMenuIcon = systemMenuIcon;
    }

    public String getSystemMenuUrl() {
        return systemMenuUrl;
    }

    public void setSystemMenuUrl(String systemMenuUrl) {
        this.systemMenuUrl = systemMenuUrl;
    }

    public Integer getSystemParentId() {
        return systemParentId;
    }

    public void setSystemParentId(Integer systemParentId) {
        this.systemParentId = systemParentId;
    }

    public String getSystemMenuClose() {
        return systemMenuClose;
    }

    public void setSystemMenuClose(String systemMenuClose) {
        this.systemMenuClose = systemMenuClose;
    }

    public String getSystemMenuDesc() {
        return systemMenuDesc;
    }

    public void setSystemMenuDesc(String systemMenuDesc) {
        this.systemMenuDesc = systemMenuDesc;
    }

	public Integer getRoleRelationId() {
		return roleRelationId;
	}

	public void setRoleRelationId(Integer roleRelationId) {
		this.roleRelationId = roleRelationId;
	}

	public Integer getSystemRoleId() {
		return systemRoleId;
	}

	public void setSystemRoleId(Integer systemRoleId) {
		this.systemRoleId = systemRoleId;
	}

	public List<SystemMenuInfo> getChilds() {
		return childs;
	}

	public void setChilds(List<SystemMenuInfo> childs) {
		this.childs = childs;
	}

	public String getSystemFirstName() {
		return systemFirstName;
	}

	public void setSystemFirstName(String systemFirstName) {
		this.systemFirstName = systemFirstName;
	}

	public String getSystemSecondName() {
		return systemSecondName;
	}

	public void setSystemSecondName(String systemSecondName) {
		this.systemSecondName = systemSecondName;
	}

	public String getSystemThirdName() {
		return systemThirdName;
	}

	public void setSystemThirdName(String systemThirdName) {
		this.systemThirdName = systemThirdName;
	}

	public boolean isSystemBoolClose() {
		return systemBoolClose;
	}

	public void setSystemBoolClose(boolean systemBoolClose) {
		this.systemBoolClose = systemBoolClose;
	}
}