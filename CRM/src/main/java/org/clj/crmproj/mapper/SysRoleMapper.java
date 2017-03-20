package org.clj.crmproj.mapper;

import org.clj.crmproj.entity.SysRole;

import java.util.List;
import java.util.Map;

public interface SysRoleMapper extends BaseMapper<SysRole, String>  {
    Integer deleteByPrimaryKey(String sid);

    Integer insert(SysRole record);

    Integer insertSelective(SysRole record);

    SysRole selectByPrimaryKey(String sid);

    Integer updateByPrimaryKeySelective(SysRole record);

    Integer updateByPrimaryKey(SysRole record);

    List<Map> selectByOther(Map map);

    int selectCount(Map map);

    List<Map> selectPage(Map map);
}