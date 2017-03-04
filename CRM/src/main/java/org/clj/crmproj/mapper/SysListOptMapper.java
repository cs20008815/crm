package org.clj.crmproj.mapper;

import org.clj.crmproj.entity.SysListOpt;

import java.util.List;
import java.util.Map;

public interface SysListOptMapper extends BaseMapper<SysListOpt, String>  {
    Integer deleteByPrimaryKey(String sid);

    Integer insert(SysListOpt record);

    Integer insertSelective(SysListOpt record);

    SysListOpt selectByPrimaryKey(String sid);

    Integer updateByPrimaryKeySelective(SysListOpt record);

    Integer updateByPrimaryKey(SysListOpt record);

    List<Map> selectByOther(Map map);
}