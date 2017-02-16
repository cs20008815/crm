package org.clj.crmproj.mapper;

import org.clj.crmproj.entity.RP;

public interface RPMapper {
    int deleteByPrimaryKey(String id);

    int insert(RP record);

    int insertSelective(RP record);

    RP selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(RP record);

    int updateByPrimaryKey(RP record);
}