package org.clj.crmproj.service;

import org.clj.crmproj.entity.SysRole;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/2/27.
 */
public interface RoleService extends BaseService {
    int removeByPrimaryKey(String id);
    int add(SysRole record);
    int addSelective(SysRole record);
    SysRole queryByPrimaryKey(String id);
    int editByPrimaryKeySelective(SysRole record);
    int editByPrimaryKey(SysRole record);
    List<Map> queryByOther(Map record);
    int queryCount(Map map);
    List<Map> queryPage(Map record);
}
