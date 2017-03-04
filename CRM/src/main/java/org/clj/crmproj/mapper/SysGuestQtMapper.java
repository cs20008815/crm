package org.clj.crmproj.mapper;

import org.clj.crmproj.entity.SysGuestQt;

import java.util.List;
import java.util.Map;

public interface SysGuestQtMapper extends BaseMapper<SysGuestQt, String>  {
    Integer deleteByPrimaryKey(String sid);

    Integer insert(SysGuestQt record);

    Integer insertSelective(SysGuestQt record);

    SysGuestQt selectByPrimaryKey(String sid);

    Integer updateByPrimaryKeySelective(SysGuestQt record);

    Integer updateByPrimaryKey(SysGuestQt record);

    List<Map> selectByOther(Map map);
}