package org.clj.crmproj.mapper;

import org.clj.crmproj.entity.Khfl;

import java.util.List;
import java.util.Map;

public interface KhflMapper {
    int deleteByPrimaryKey(String sid);

    int insert(Khfl record);

    int insertSelective(Khfl record);

    Khfl selectByPrimaryKey(String sid);

    int updateByPrimaryKeySelective(Khfl record);

    int updateByPrimaryKey(Khfl record);

    List<Khfl> selectAll();

    List<Khfl> selectByAttr1(Map map);
}