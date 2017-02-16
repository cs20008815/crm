package org.clj.crmproj.mapper;

import org.clj.crmproj.entity.UserPerm;

import java.util.List;
import java.util.Map;

public interface UserPermMapper {
    int deleteByPrimaryKey(String sid);

    int insert(UserPerm record);

    int insertSelective(UserPerm record);

    UserPerm selectByPrimaryKey(String sid);

    int updateByPrimaryKeySelective(UserPerm record);

    int updateByPrimaryKey(UserPerm record);

    List<UserPerm> selectByOther(Map map);
}