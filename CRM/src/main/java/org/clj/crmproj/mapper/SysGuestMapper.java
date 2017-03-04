package org.clj.crmproj.mapper;

import org.clj.crmproj.entity.SysGuest;

import java.util.List;
import java.util.Map;

public interface SysGuestMapper extends BaseMapper<SysGuest, String>  {
    Integer deleteByPrimaryKey(String sid);

    Integer insert(SysGuest record);

    Integer insertSelective(SysGuest record);

    SysGuest selectByPrimaryKey(String sid);

    Integer updateByPrimaryKeySelective(SysGuest record);

    Integer updateByPrimaryKey(SysGuest record);

    List<Map> selectByOther(Map map);
}