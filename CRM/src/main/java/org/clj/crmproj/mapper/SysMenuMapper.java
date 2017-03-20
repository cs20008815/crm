package org.clj.crmproj.mapper;

import org.clj.crmproj.entity.SysMenu;

import java.util.List;
import java.util.Map;

public interface SysMenuMapper extends BaseMapper<SysMenu, String>  {
    Integer deleteByPrimaryKey(String sid);

    Integer insert(SysMenu record);

    Integer insertSelective(SysMenu record);

    SysMenu selectByPrimaryKey(String sid);

    Integer updateByPrimaryKeySelective(SysMenu record);

    Integer updateByPrimaryKey(SysMenu record);

    List<Map> selectByOther(Map map);

    Integer selectCount(Map map);
}