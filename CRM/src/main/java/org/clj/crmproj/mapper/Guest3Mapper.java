package org.clj.crmproj.mapper;

import org.clj.crmproj.entity.Guest3;

public interface Guest3Mapper {
    int deleteByPrimaryKey(String sid);

    int insert(Guest3 record);

    int insertSelective(Guest3 record);

    Guest3 selectByPrimaryKey(String sid);

    int updateByPrimaryKeySelective(Guest3 record);

    int updateByPrimaryKey(Guest3 record);
}