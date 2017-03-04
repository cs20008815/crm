package org.clj.crmproj.mapper;

import org.clj.crmproj.entity.SysDept;

import java.util.List;
import java.util.Map;

public interface SysDeptMapper extends BaseMapper<SysDept, String> {
    Integer deleteByPrimaryKey(String sid);

    Integer insert(SysDept record);

    Integer insertSelective(SysDept record);

    SysDept selectByPrimaryKey(String sid);

    Integer updateByPrimaryKeySelective(SysDept record);

    Integer updateByPrimaryKey(SysDept record);

    List<Map> selectByOther(Map map);

    int selectCount(Map map);

    List<Map> selectPage(Map map);
}