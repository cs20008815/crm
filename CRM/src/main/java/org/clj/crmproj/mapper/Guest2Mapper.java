package org.clj.crmproj.mapper;

import org.clj.crmproj.entity.Guest2;

import java.util.List;
import java.util.Map;

public interface Guest2Mapper {
    int deleteByPrimaryKey(String sid);

    int insert(Guest2 record);

    int insertSelective(Guest2 record);

    Guest2 selectByPrimaryKey(String sid);

    int updateByPrimaryKeySelective(Guest2 record);

    int updateByPrimaryKey(Guest2 record);

    List<Guest2> selectByOther(Map map);
}