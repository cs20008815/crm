package org.clj.crmproj.mapper;

import org.clj.crmproj.entity.SysGuestTmk;

import java.util.List;
import java.util.Map;

public interface SysGuestTmkMapper extends BaseMapper<SysGuestTmk, String>  {
    Integer deleteByPrimaryKey(String sid);

    Integer insert(SysGuestTmk record);

    Integer insertSelective(SysGuestTmk record);

    SysGuestTmk selectByPrimaryKey(String sid);

    Integer updateByPrimaryKeySelective(SysGuestTmk record);

    Integer updateByPrimaryKey(SysGuestTmk record);

    List<Map> selectByOther(Map map);
}