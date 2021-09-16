package com.whcdit.imengya.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.whcdit.imengya.model.SystemMenuInfo;
import com.whcdit.imengya.model.SystemRoleInfo;

@Mapper
public interface SystemMenuInfoMapper {
    int deleteByPrimaryKey(Integer systemMenuId);

    int insert(SystemMenuInfo record);

    int insertSelective(SystemMenuInfo record);

    SystemMenuInfo selectByPrimaryKey(Integer systemMenuId);

    int updateByPrimaryKeySelective(SystemMenuInfo record);

    int updateByPrimaryKey(SystemMenuInfo record);

	List<SystemMenuInfo> selectWithCondition(SystemMenuInfo param);

	List<SystemMenuInfo> selectWithRole(SystemRoleInfo role);
}