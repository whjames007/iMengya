package com.whcdit.imengya.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.whcdit.imengya.model.SystemRoleRelation;

@Mapper
public interface SystemRoleRelationMapper {
    int deleteByPrimaryKey(Integer roleRelationId);

    int insert(SystemRoleRelation record);

    int insertSelective(SystemRoleRelation record);

    SystemRoleRelation selectByPrimaryKey(Integer roleRelationId);

    int updateByPrimaryKeySelective(SystemRoleRelation record);

    int updateByPrimaryKey(SystemRoleRelation record);

//	List<SystemRoleRelation> selectWithRoleId(Integer rid);

	int deleteWithCondition(SystemRoleRelation param);
}