package com.whcdit.imengya.model;

import java.util.Date;

public class ProjectDefectInfo extends BaseModel {
    private Integer projectDefectId;

    private Integer projectDataId;

    private String projectDefectSn;

    private String projectDefectSource;

    private String projectDefectType;

    private String projectDefectOs;

    private String projectDefectBrowser;

    private String projectDefectPriority;

    private Integer defectFounderId;

    private Date defectFounderTime;

    private String projectDefectStatus;

    private Integer defectHandleId;

    private Date defectHandleTime;

    private String projectDefectRemark;

    public Integer getProjectDefectId() {
        return projectDefectId;
    }

    public void setProjectDefectId(Integer projectDefectId) {
        this.projectDefectId = projectDefectId;
    }

    public Integer getProjectDataId() {
        return projectDataId;
    }

    public void setProjectDataId(Integer projectDataId) {
        this.projectDataId = projectDataId;
    }

    public String getProjectDefectSn() {
        return projectDefectSn;
    }

    public void setProjectDefectSn(String projectDefectSn) {
        this.projectDefectSn = projectDefectSn;
    }

    public String getProjectDefectSource() {
        return projectDefectSource;
    }

    public void setProjectDefectSource(String projectDefectSource) {
        this.projectDefectSource = projectDefectSource;
    }

    public String getProjectDefectType() {
        return projectDefectType;
    }

    public void setProjectDefectType(String projectDefectType) {
        this.projectDefectType = projectDefectType;
    }

    public String getProjectDefectOs() {
        return projectDefectOs;
    }

    public void setProjectDefectOs(String projectDefectOs) {
        this.projectDefectOs = projectDefectOs;
    }

    public String getProjectDefectBrowser() {
        return projectDefectBrowser;
    }

    public void setProjectDefectBrowser(String projectDefectBrowser) {
        this.projectDefectBrowser = projectDefectBrowser;
    }

    public String getProjectDefectPriority() {
        return projectDefectPriority;
    }

    public void setProjectDefectPriority(String projectDefectPriority) {
        this.projectDefectPriority = projectDefectPriority;
    }

    public Integer getDefectFounderId() {
        return defectFounderId;
    }

    public void setDefectFounderId(Integer defectFounderId) {
        this.defectFounderId = defectFounderId;
    }

    public Date getDefectFounderTime() {
        return defectFounderTime;
    }

    public void setDefectFounderTime(Date defectFounderTime) {
        this.defectFounderTime = defectFounderTime;
    }

    public String getProjectDefectStatus() {
        return projectDefectStatus;
    }

    public void setProjectDefectStatus(String projectDefectStatus) {
        this.projectDefectStatus = projectDefectStatus;
    }

    public Integer getDefectHandleId() {
        return defectHandleId;
    }

    public void setDefectHandleId(Integer defectHandleId) {
        this.defectHandleId = defectHandleId;
    }

    public Date getDefectHandleTime() {
        return defectHandleTime;
    }

    public void setDefectHandleTime(Date defectHandleTime) {
        this.defectHandleTime = defectHandleTime;
    }

    public String getProjectDefectRemark() {
        return projectDefectRemark;
    }

    public void setProjectDefectRemark(String projectDefectRemark) {
        this.projectDefectRemark = projectDefectRemark;
    }
}