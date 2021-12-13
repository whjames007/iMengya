package com.whcdit.imengya.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.whcdit.imengya.model.ProjectMemberInfo;

@Mapper
public interface ProjectMemberInfoMapper {
    int deleteByPrimaryKey(Integer projectMemberId);

    int insert(ProjectMemberInfo record);

    int insertSelective(ProjectMemberInfo record);

    ProjectMemberInfo selectByPrimaryKey(Integer projectMemberId);

    int updateByPrimaryKeySelective(ProjectMemberInfo record);

    int updateByPrimaryKey(ProjectMemberInfo record);
}