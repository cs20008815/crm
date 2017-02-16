package org.clj.crmproj.mapper;

import org.clj.crmproj.entity.SD;

public interface SDMapper {
    int deleteByPrimaryKey(String id);

    int insert(SD record);

    int insertSelective(SD record);

    SD selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SD record);

    int updateByPrimaryKey(SD record);
}