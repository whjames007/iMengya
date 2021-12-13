package com.whcdit.imengya.model;

public class ProjectDataInfo extends BaseModel {
    private Integer projectDataId;

    private String projectDataType;

    private String projectDataCode;

    private String projectDataName;

    public Integer getProjectDataId() {
        return projectDataId;
    }

    public void setProjectDataId(Integer projectDataId) {
        this.projectDataId = projectDataId;
    }

    public String getProjectDataType() {
        return projectDataType;
    }

    public void setProjectDataType(String projectDataType) {
        this.projectDataType = projectDataType;
    }

    public String getProjectDataCode() {
        return projectDataCode;
    }

    public void setProjectDataCode(String projectDataCode) {
        this.projectDataCode = projectDataCode;
    }

    public String getProjectDataName() {
        return projectDataName;
    }

    public void setProjectDataName(String projectDataName) {
        this.projectDataName = projectDataName;
    }
}