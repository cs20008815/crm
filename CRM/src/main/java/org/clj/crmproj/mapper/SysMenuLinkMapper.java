package org.clj.crmproj.mapper;

import org.clj.crmproj.entity.SysMenuLink;

import java.util.List;
import java.util.Map;

public interface SysMenuLinkMapper extends BaseMapper<SysMenuLink, String>  {
    Integer deleteByPrimaryKey(String sid);

    Integer insert(SysMenuLink record);

    Integer insertSelective(SysMenuLink record);

    SysMenuLink selectByPrimaryKey(String sid);

    Integer updateByPrimaryKeySelective(SysMenuLink record);

    Integer updateByPrimaryKey(SysMenuLink record);

    List<Map> selectByOther(Map map);
}