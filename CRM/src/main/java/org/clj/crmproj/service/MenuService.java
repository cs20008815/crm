package org.clj.crmproj.service;

import org.clj.crmproj.entity.SysMenu;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/2/27.
 */
public interface MenuService extends BaseService {
    int removeByPrimaryKey(String id);
    int add(SysMenu record);
    int addSelective(SysMenu record);
    SysMenu queryByPrimaryKey(String id);
    int editByPrimaryKeySelective(SysMenu record);
    int editByPrimaryKey(SysMenu record);
    List<Map> queryByOther(Map record);
    List<Map> userMenu(Map map);
    List<Map> queryMenuBySid(Map map);
}
