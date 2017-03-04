package org.clj.crmproj.mapper;

import org.clj.crmproj.entity.SysLog;

import java.util.List;
import java.util.Map;

public interface SysLogMapper extends BaseMapper<SysLog, String>  {
    Integer deleteByPrimaryKey(String sid);

    Integer insert(SysLog record);

    Integer insertSelective(SysLog record);

    SysLog selectByPrimaryKey(String sid);

    Integer updateByPrimaryKeySelective(SysLog record);

    Integer updateByPrimaryKey(SysLog record);

    List<Map> selectByOther(Map map);
}