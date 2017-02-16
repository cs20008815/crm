package org.clj.crmproj.mapper;

import org.clj.crmproj.entity.Guest4;

public interface Guest4Mapper {
    int deleteByPrimaryKey(String sid);

    int insert(Guest4 record);

    int insertSelective(Guest4 record);

    Guest4 selectByPrimaryKey(String sid);

    int updateByPrimaryKeySelective(Guest4 record);

    int updateByPrimaryKey(Guest4 record);
}