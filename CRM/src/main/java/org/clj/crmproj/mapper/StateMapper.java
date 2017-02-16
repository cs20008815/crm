package org.clj.crmproj.mapper;

import org.clj.crmproj.entity.State;

import java.util.List;
import java.util.Map;

public interface StateMapper {
    int deleteByPrimaryKey(String sid);

    int insert(State record);

    int insertSelective(State record);

    State selectByPrimaryKey(String sid);

    int updateByPrimaryKeySelective(State record);

    int updateByPrimaryKey(State record);

    List<State> selectAll();

    List<State>selectByAttr1(Map map);
}