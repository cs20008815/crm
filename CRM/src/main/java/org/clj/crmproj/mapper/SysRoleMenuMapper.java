package org.clj.crmproj.mapper;

import org.clj.crmproj.entity.SysRoleMenu;

import java.util.List;
import java.util.Map;

public interface SysRoleMenuMapper extends BaseMapper<SysRoleMenu, String>  {
    Integer deleteByPrimaryKey(String sid);

    Integer insert(SysRoleMenu record);

    Integer insertSelective(SysRoleMenu record);

    SysRoleMenu selectByPrimaryKey(String sid);

    Integer updateByPrimaryKeySelective(SysRoleMenu record);

    Integer updateByPrimaryKey(SysRoleMenu record);

    List<Map> selectByOther(Map map);

    Integer insertOrUpdate(SysRoleMenu record);
}