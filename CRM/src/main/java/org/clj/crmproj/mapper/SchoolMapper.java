package org.clj.crmproj.mapper;

import org.clj.crmproj.entity.School;

import java.util.List;
import java.util.Map;

public interface SchoolMapper {
    int deleteByPrimaryKey(String sid);

    int insert(School record);

    int insertSelective(School record);

    School selectByPrimaryKey(String sid);

    int updateByPrimaryKeySelective(School record);

    int updateByPrimaryKey(School record);

    List<School> selectAll();

    List<School> selectByAttr1(Map map);
}