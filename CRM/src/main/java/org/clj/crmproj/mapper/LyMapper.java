package org.clj.crmproj.mapper;

import org.clj.crmproj.entity.Ly;

import java.util.List;
import java.util.Map;

public interface LyMapper {
    int deleteByPrimaryKey(String sid);

    int insert(Ly record);

    int insertSelective(Ly record);

    Ly selectByPrimaryKey(String sid);

    int updateByPrimaryKeySelective(Ly record);

    int updateByPrimaryKey(Ly record);

    List<Ly> selectAll();

    List<Ly> selectByAttr1(Map map);
}