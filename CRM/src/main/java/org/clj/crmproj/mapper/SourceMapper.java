package org.clj.crmproj.mapper;

import org.clj.crmproj.entity.Source;

import java.util.List;
import java.util.Map;

public interface SourceMapper {
    int deleteByPrimaryKey(String sid);

    int insert(Source record);

    int insertSelective(Source record);

    Source selectByPrimaryKey(String sid);

    int updateByPrimaryKeySelective(Source record);

    int updateByPrimaryKey(Source record);

    List<Source> selectAll();

    List<Source> selectByAttr1(Map map);
}