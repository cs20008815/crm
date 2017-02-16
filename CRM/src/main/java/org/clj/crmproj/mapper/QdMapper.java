package org.clj.crmproj.mapper;

import org.clj.crmproj.entity.Qd;

import java.util.List;
import java.util.Map;

public interface QdMapper {
    int deleteByPrimaryKey(String sid);

    int insert(Qd record);

    int insertSelective(Qd record);

    Qd selectByPrimaryKey(String sid);

    int updateByPrimaryKeySelective(Qd record);

    int updateByPrimaryKey(Qd record);

    List<Qd> selectAll();

    List<Qd> selectByAttr1(Map map);
}