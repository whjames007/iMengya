package com.whcdit.imengya.model;

public class SystemRoleRelation extends BaseModel {
    private Integer roleRelationId;

    private Integer systemRoleId;

    private Integer systemMenuId;

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

    public Integer getSystemMenuId() {
        return systemMenuId;
    }

    public void setSystemMenuId(Integer systemMenuId) {
        this.systemMenuId = systemMenuId;
    }
}