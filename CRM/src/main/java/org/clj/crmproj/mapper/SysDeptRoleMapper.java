package org.clj.crmproj.mapper;

import org.clj.crmproj.entity.SysDeptRole;

import java.util.List;
import java.util.Map;

public interface SysDeptRoleMapper extends BaseMapper<SysDeptRole, String> {
    Integer deleteByPrimaryKey(String sid);

    Integer insert(SysDeptRole record);

    Integer insertSelective(SysDeptRole record);

    SysDeptRole selectByPrimaryKey(String sid);

    Integer updateByPrimaryKeySelective(SysDeptRole record);

    Integer updateByPrimaryKey(SysDeptRole record);

    List<Map> selectByOther(Map map);
}