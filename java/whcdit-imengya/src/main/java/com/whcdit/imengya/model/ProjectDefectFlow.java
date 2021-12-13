package com.whcdit.imengya.model;

import java.util.Date;

public class ProjectDefectFlow extends BaseModel {
    private Integer defectFlowId;

    private Integer projectDefectId;

    private String defectFlowType;

    private Integer flowSenderId;

    private Date defectFlowTime;

    private Integer flowReceiverId;

    private String defectFlowDesc;

    public Integer getDefectFlowId() {
        return defectFlowId;
    }

    public void setDefectFlowId(Integer defectFlowId) {
        this.defectFlowId = defectFlowId;
    }

    public Integer getProjectDefectId() {
        return projectDefectId;
    }

    public void setProjectDefectId(Integer projectDefectId) {
        this.projectDefectId = projectDefectId;
    }

    public String getDefectFlowType() {
        return defectFlowType;
    }

    public void setDefectFlowType(String defectFlowType) {
        this.defectFlowType = defectFlowType;
    }

    public Integer getFlowSenderId() {
        return flowSenderId;
    }

    public void setFlowSenderId(Integer flowSenderId) {
        this.flowSenderId = flowSenderId;
    }

    public Date getDefectFlowTime() {
        return defectFlowTime;
    }

    public void setDefectFlowTime(Date defectFlowTime) {
        this.defectFlowTime = defectFlowTime;
    }

    public Integer getFlowReceiverId() {
        return flowReceiverId;
    }

    public void setFlowReceiverId(Integer flowReceiverId) {
        this.flowReceiverId = flowReceiverId;
    }

    public String getDefectFlowDesc() {
        return defectFlowDesc;
    }

    public void setDefectFlowDesc(String defectFlowDesc) {
        this.defectFlowDesc = defectFlowDesc;
    }
}