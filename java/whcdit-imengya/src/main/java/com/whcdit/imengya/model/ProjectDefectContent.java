package com.whcdit.imengya.model;

public class ProjectDefectContent extends BaseModel {
    private Integer defectContentId;

    private Integer projectDefectId;

    private String defectContentType;

    private String defectContentDetail;

    private Integer defectFlowId;

    public Integer getDefectContentId() {
        return defectContentId;
    }

    public void setDefectContentId(Integer defectContentId) {
        this.defectContentId = defectContentId;
    }

    public Integer getProjectDefectId() {
        return projectDefectId;
    }

    public void setProjectDefectId(Integer projectDefectId) {
        this.projectDefectId = projectDefectId;
    }

    public String getDefectContentType() {
        return defectContentType;
    }

    public void setDefectContentType(String defectContentType) {
        this.defectContentType = defectContentType;
    }

    public String getDefectContentDetail() {
        return defectContentDetail;
    }

    public void setDefectContentDetail(String defectContentDetail) {
        this.defectContentDetail = defectContentDetail;
    }

    public Integer getDefectFlowId() {
        return defectFlowId;
    }

    public void setDefectFlowId(Integer defectFlowId) {
        this.defectFlowId = defectFlowId;
    }
}