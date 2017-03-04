package org.clj.crmproj.mapper;

import org.clj.crmproj.entity.SysUser;

import java.util.List;
import java.util.Map;

public interface SysUserMapper extends BaseMapper<SysUser, String>  {
    Integer deleteByPrimaryKey(String sid);

    Integer insert(SysUser record);

    Integer insertSelective(SysUser record);

    SysUser selectByPrimaryKey(String sid);

    Integer updateByPrimaryKeySelective(SysUser record);

    Integer updateByPrimaryKey(SysUser record);

    List<Map> selectByOther(Map map);
}