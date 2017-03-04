package org.clj.crmproj.mapper;

import org.clj.crmproj.entity.SysGuestCc;

import java.util.List;
import java.util.Map;

public interface SysGuestCcMapper extends BaseMapper<SysGuestCc, String> {
    Integer deleteByPrimaryKey(String sid);

    Integer insert(SysGuestCc record);

    Integer insertSelective(SysGuestCc record);

    SysGuestCc selectByPrimaryKey(String sid);

    Integer updateByPrimaryKeySelective(SysGuestCc record);

    Integer updateByPrimaryKey(SysGuestCc record);

    List<Map> selectByOther(Map map);
}