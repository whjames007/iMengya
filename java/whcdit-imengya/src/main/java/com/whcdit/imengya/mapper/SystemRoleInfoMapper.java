package com.whcdit.imengya.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.whcdit.imengya.model.SystemRoleInfo;

@Mapper
public interface SystemRoleInfoMapper {
    int deleteByPrimaryKey(Integer systemRoleId);

    int insert(SystemRoleInfo record);

    int insertSelective(SystemRoleInfo record);

    SystemRoleInfo selectByPrimaryKey(Integer systemRoleId);

    int updateByPrimaryKeySelective(SystemRoleInfo record);

    int updateByPrimaryKey(SystemRoleInfo record);

	List<SystemRoleInfo> selectWithCondition(SystemRoleInfo param);
}