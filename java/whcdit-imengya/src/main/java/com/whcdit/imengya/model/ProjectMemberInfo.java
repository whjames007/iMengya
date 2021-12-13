package com.whcdit.imengya.model;

import java.util.Date;

public class ProjectMemberInfo extends BaseModel {
    private Integer projectMemberId;

    private Integer projectDataId;

    private String projectMemberType;

    private Integer memberUserId;

    private Date memberJoinTime;

    private String projectMemberDesc;

    public Integer getProjectMemberId() {
        return projectMemberId;
    }

    public void setProjectMemberId(Integer projectMemberId) {
        this.projectMemberId = projectMemberId;
    }

    public Integer getProjectDataId() {
        return projectDataId;
    }

    public void setProjectDataId(Integer projectDataId) {
        this.projectDataId = projectDataId;
    }

    public String getProjectMemberType() {
        return projectMemberType;
    }

    public void setProjectMemberType(String projectMemberType) {
        this.projectMemberType = projectMemberType;
    }

    public Integer getMemberUserId() {
        return memberUserId;
    }

    public void setMemberUserId(Integer memberUserId) {
        this.memberUserId = memberUserId;
    }

    public Date getMemberJoinTime() {
        return memberJoinTime;
    }

    public void setMemberJoinTime(Date memberJoinTime) {
        this.memberJoinTime = memberJoinTime;
    }

    public String getProjectMemberDesc() {
        return projectMemberDesc;
    }

    public void setProjectMemberDesc(String projectMemberDesc) {
        this.projectMemberDesc = projectMemberDesc;
    }
}