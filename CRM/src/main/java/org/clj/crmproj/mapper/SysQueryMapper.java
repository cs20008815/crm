package org.clj.crmproj.mapper;

import java.util.List;
import java.util.Map;

public interface SysQueryMapper {
    List<Map> queryUserByMap();

    Map queryUserById(Map map);

    List<Map> queryMenuByUserId(Map map);

    List<Map> queryMenuByRoleId(Map map);
}