package org.clj.crmproj.mapper;

import org.clj.crmproj.entity.SysGuestMk;

import java.util.List;
import java.util.Map;

public interface SysGuestMkMapper extends BaseMapper<SysGuestMk, String>  {
    Integer deleteByPrimaryKey(String sid);

    Integer insert(SysGuestMk record);

    Integer insertSelective(SysGuestMk record);

    SysGuestMk selectByPrimaryKey(String sid);

    Integer updateByPrimaryKeySelective(SysGuestMk record);

    Integer updateByPrimaryKey(SysGuestMk record);

    List<Map> selectByOther(Map map);
}