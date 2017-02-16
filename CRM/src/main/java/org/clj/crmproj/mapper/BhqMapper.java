package org.clj.crmproj.mapper;

import org.clj.crmproj.entity.Bhq;

import java.util.List;
import java.util.Map;

public interface BhqMapper {
    int deleteByPrimaryKey(String sid);

    int insert(Bhq record);

    int insertSelective(Bhq record);

    Bhq selectByPrimaryKey(String sid);

    int updateByPrimaryKeySelective(Bhq record);

    int updateByPrimaryKey(Bhq record);

    List<Bhq> selectAll();

    List<Bhq> selectByAttr1(Map map);
}