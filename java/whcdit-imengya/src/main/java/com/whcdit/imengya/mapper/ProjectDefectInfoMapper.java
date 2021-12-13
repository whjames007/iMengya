package com.whcdit.imengya.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.whcdit.imengya.model.ProjectDefectInfo;

@Mapper
public interface ProjectDefectInfoMapper {
    int deleteByPrimaryKey(Integer projectDefectId);

    int insert(ProjectDefectInfo record);

    int insertSelective(ProjectDefectInfo record);

    ProjectDefectInfo selectByPrimaryKey(Integer projectDefectId);

    int updateByPrimaryKeySelective(ProjectDefectInfo record);

    int updateByPrimaryKey(ProjectDefectInfo record);
}