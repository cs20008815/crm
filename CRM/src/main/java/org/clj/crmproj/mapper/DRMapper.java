package org.clj.crmproj.mapper;

import org.clj.crmproj.entity.DR;

public interface DRMapper {
    int deleteByPrimaryKey(String id);

    int insert(DR record);

    int insertSelective(DR record);

    DR selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DR record);

    int updateByPrimaryKey(DR record);
}