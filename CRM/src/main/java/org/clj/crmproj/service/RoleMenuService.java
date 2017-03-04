package org.clj.crmproj.service;

import org.clj.crmproj.entity.SysRoleMenu;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/2/27.
 */
public interface RoleMenuService extends BaseService {
    int removeByPrimaryKey(String id);
    int add(SysRoleMenu record);
    int addSelective(SysRoleMenu record);
    SysRoleMenu queryByPrimaryKey(String id);
    int editByPrimaryKeySelective(SysRoleMenu record);
    int editByPrimaryKey(SysRoleMenu record);
    List<Map> queryByOther(Map record);
}
