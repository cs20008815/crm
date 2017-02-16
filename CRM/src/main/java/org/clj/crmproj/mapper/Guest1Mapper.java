package org.clj.crmproj.mapper;

import org.clj.crmproj.entity.Guest1;

import java.util.List;
import java.util.Map;

public interface Guest1Mapper {
    int deleteByPrimaryKey(String sid);

    int insert(Guest1 record);

    int insertSelective(Guest1 record);

    Guest1 selectByPrimaryKey(String sid);

    int updateByPrimaryKeySelective(Guest1 record);

    int updateByPrimaryKey(Guest1 record);

    List<Map> selectByOpt(Map map);
}