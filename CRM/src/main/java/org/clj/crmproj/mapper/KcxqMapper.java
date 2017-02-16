package org.clj.crmproj.mapper;

import org.clj.crmproj.entity.Kcxq;

import java.util.List;
import java.util.Map;

public interface KcxqMapper {
    int deleteByPrimaryKey(String sid);

    int insert(Kcxq record);

    int insertSelective(Kcxq record);

    Kcxq selectByPrimaryKey(String sid);

    int updateByPrimaryKeySelective(Kcxq record);

    int updateByPrimaryKey(Kcxq record);

    List<Kcxq> selectAll();

    List<Kcxq> selectByAttr1(Map map);
}