package com.whcdit.imengya.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.whcdit.imengya.model.ProjectDataInfo;

@Mapper
public interface ProjectDataInfoMapper {
    int deleteByPrimaryKey(Integer projectDataId);

    int insert(ProjectDataInfo record);

    int insertSelective(ProjectDataInfo record);

    ProjectDataInfo selectByPrimaryKey(Integer projectDataId);

    int updateByPrimaryKeySelective(ProjectDataInfo record);

    int updateByPrimaryKey(ProjectDataInfo record);
}