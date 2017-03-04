package org.clj.crmproj.mapper;

import org.clj.crmproj.entity.SysUser;

import java.util.List;
import java.util.Map;

public interface SysLoginMapper {
    Map loginByMap(Map map);

    List<Map> menuByMap(Map map);
}