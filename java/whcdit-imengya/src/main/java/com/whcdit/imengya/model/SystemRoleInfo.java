package com.whcdit.imengya.model;

public class SystemRoleInfo extends BaseModel {
    private Integer systemRoleId;

    private String systemRoleName;

    private String systemRoleCode;

    private String systemRoleDesc;

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
}