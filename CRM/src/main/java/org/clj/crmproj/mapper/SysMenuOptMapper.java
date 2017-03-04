package org.clj.crmproj.mapper;

import org.clj.crmproj.entity.SysMenuOpt;

import java.util.List;
import java.util.Map;

public interface SysMenuOptMapper extends BaseMapper<SysMenuOpt, String>  {
    Integer deleteByPrimaryKey(String sid);

    Integer insert(SysMenuOpt record);

    Integer insertSelective(SysMenuOpt record);

    SysMenuOpt selectByPrimaryKey(String sid);

    Integer updateByPrimaryKeySelective(SysMenuOpt record);

    Integer updateByPrimaryKey(SysMenuOpt record);

    List<Map> selectByOther(Map map);
}