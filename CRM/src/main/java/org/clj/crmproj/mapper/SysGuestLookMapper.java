package org.clj.crmproj.mapper;

import org.clj.crmproj.entity.SysGuestLook;

import java.util.List;
import java.util.Map;

public interface SysGuestLookMapper extends BaseMapper<SysGuestLook, String> {
    Integer deleteByPrimaryKey(String sid);

    Integer insert(SysGuestLook record);

    Integer insertSelective(SysGuestLook record);

    SysGuestLook selectByPrimaryKey(String sid);

    Integer updateByPrimaryKeySelective(SysGuestLook record);

    Integer updateByPrimaryKey(SysGuestLook record);

    List<Map> selectByOther(Map map);

    Integer selectCount(Map map);

    Integer insertBatch(List<SysGuestLook> record);
}