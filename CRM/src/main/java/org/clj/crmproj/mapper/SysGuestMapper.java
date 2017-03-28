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

    List<Map> selectPage(Map map);

    List<Map> selectPageTMK(Map map);

    List<Map> selectPageByMk(Map map);

    Integer selectCount(Map map);

    Integer selectCountTMK(Map map);

    Integer selectCountByMk(Map map);

    Integer insertBatch(List<SysGuest> record);
}