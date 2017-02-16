package org.clj.crmproj.mapper;

import org.clj.crmproj.entity.Dept;

import java.util.List;
import java.util.Map;

public interface DeptMapper {
    int deleteByPrimaryKey(String did);

    int insert(Dept record);

    int insertSelective(Dept record);

    Dept selectByPrimaryKey(String did);

    int updateByPrimaryKeySelective(Dept record);

    int updateByPrimaryKey(Dept record);

    List<Dept> selectAll();

    List<Dept> selectByAttr1(Map map);
}