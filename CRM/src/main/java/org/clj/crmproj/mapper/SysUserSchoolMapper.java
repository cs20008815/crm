package org.clj.crmproj.mapper;

import org.clj.crmproj.entity.SysUserSchool;

import java.util.List;
import java.util.Map;

public interface SysUserSchoolMapper extends BaseMapper<SysUserSchool, String>  {
    Integer deleteByPrimaryKey(String sid);

    Integer insert(SysUserSchool record);

    Integer insertSelective(SysUserSchool record);

    SysUserSchool selectByPrimaryKey(String sid);

    Integer updateByPrimaryKeySelective(SysUserSchool record);

    Integer updateByPrimaryKey(SysUserSchool record);

    List<Map> selectByOther(Map map);
}