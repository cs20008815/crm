package org.clj.crmproj.mapper;

import org.clj.crmproj.entity.US;

public interface USMapper {
    int deleteByPrimaryKey(String id);

    int insert(US record);

    int insertSelective(US record);

    US selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(US record);

    int updateByPrimaryKey(US record);
}