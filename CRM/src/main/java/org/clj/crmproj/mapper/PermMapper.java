package org.clj.crmproj.mapper;

import org.clj.crmproj.entity.Perm;

import java.util.List;
import java.util.Map;

public interface PermMapper {
    int deleteByPrimaryKey(String pid);

    int insert(Perm record);

    int insertSelective(Perm record);

    Perm selectByPrimaryKey(String pid);

    int updateByPrimaryKeySelective(Perm record);

    int updateByPrimaryKey(Perm record);

    List<Perm> selectAll();

    List<Perm> selectByAttr1(Map map);
}