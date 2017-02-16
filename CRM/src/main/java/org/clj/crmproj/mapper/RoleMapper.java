package org.clj.crmproj.mapper;

import org.clj.crmproj.entity.Role;

import java.util.List;
import java.util.Map;

public interface RoleMapper {
    int deleteByPrimaryKey(String rid);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(String rid);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    List<Role> selectAll();

    List<Role> selectByAttr1(Map map);
}