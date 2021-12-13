package com.whcdit.imengya.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.whcdit.imengya.model.ProjectDefectFlow;

@Mapper
public interface ProjectDefectFlowMapper {
    int deleteByPrimaryKey(Integer defectFlowId);

    int insert(ProjectDefectFlow record);

    int insertSelective(ProjectDefectFlow record);

    ProjectDefectFlow selectByPrimaryKey(Integer defectFlowId);

    int updateByPrimaryKeySelective(ProjectDefectFlow record);

    int updateByPrimaryKey(ProjectDefectFlow record);
}