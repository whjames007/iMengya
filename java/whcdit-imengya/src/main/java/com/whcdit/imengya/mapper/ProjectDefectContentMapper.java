package com.whcdit.imengya.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.whcdit.imengya.model.ProjectDefectContent;

@Mapper
public interface ProjectDefectContentMapper {
    int deleteByPrimaryKey(Integer defectContentId);

    int insert(ProjectDefectContent record);

    int insertSelective(ProjectDefectContent record);

    ProjectDefectContent selectByPrimaryKey(Integer defectContentId);

    int updateByPrimaryKeySelective(ProjectDefectContent record);

    int updateByPrimaryKey(ProjectDefectContent record);
}