package org.clj.crmproj.mapper;

import org.clj.crmproj.entity.SysList;

import java.util.List;
import java.util.Map;

public interface SysListMapper extends BaseMapper<SysList, String>  {
    Integer deleteByPrimaryKey(String sid);

    Integer insert(SysList record);

    Integer insertSelective(SysList record);

    SysList selectByPrimaryKey(String sid);

    Integer updateByPrimaryKeySelective(SysList record);

    Integer updateByPrimaryKey(SysList record);

    List<Map> selectByOther(Map map);
}