package org.clj.crmproj.mapper;

import org.clj.crmproj.entity.Yxcp;

import java.util.List;
import java.util.Map;

public interface YxcpMapper {
    int deleteByPrimaryKey(String sid);

    int insert(Yxcp record);

    int insertSelective(Yxcp record);

    Yxcp selectByPrimaryKey(String sid);

    int updateByPrimaryKeySelective(Yxcp record);

    int updateByPrimaryKey(Yxcp record);

    List<Yxcp> selectAll();

    List<Yxcp> selectByAttr1(Map map);
}