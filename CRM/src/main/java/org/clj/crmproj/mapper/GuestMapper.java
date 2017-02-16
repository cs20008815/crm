package org.clj.crmproj.mapper;

import org.clj.crmproj.entity.Guest;

import java.util.List;
import java.util.Map;

public interface GuestMapper {
    int deleteByPrimaryKey(String uid);

    int insert(Guest record);

    int insertSelective(Guest record);

    Guest selectByPrimaryKey(String uid);

    int updateByPrimaryKeySelective(Guest record);

    int updateByPrimaryKey(Guest record);

    List<Map> selectByOpt(Map map);

    Map selectCount(Map map);
}