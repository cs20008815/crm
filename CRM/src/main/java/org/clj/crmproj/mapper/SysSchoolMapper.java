package org.clj.crmproj.mapper;

import org.clj.crmproj.entity.SysSchool;

import java.util.List;
import java.util.Map;

public interface SysSchoolMapper extends BaseMapper<SysSchool, String>  {
    Integer deleteByPrimaryKey(String sid);

    Integer insert(SysSchool record);

    Integer insertSelective(SysSchool record);

    SysSchool selectByPrimaryKey(String sid);

    Integer updateByPrimaryKeySelective(SysSchool record);

    Integer updateByPrimaryKey(SysSchool record);

    List<Map> selectByOther(Map map);

    Integer selectCount(Map map);
}