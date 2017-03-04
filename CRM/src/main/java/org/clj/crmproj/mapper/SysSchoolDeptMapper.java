package org.clj.crmproj.mapper;

import org.clj.crmproj.entity.SysSchoolDept;

import java.util.List;
import java.util.Map;

public interface SysSchoolDeptMapper extends BaseMapper<SysSchoolDept, String>  {
    Integer deleteByPrimaryKey(String sid);

    Integer insert(SysSchoolDept record);

    Integer insertSelective(SysSchoolDept record);

    SysSchoolDept selectByPrimaryKey(String sid);

    Integer updateByPrimaryKeySelective(SysSchoolDept record);

    Integer updateByPrimaryKey(SysSchoolDept record);

    List<Map> selectByOther(Map map);
}