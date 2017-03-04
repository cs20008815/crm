package org.clj.crmproj.service;

import org.clj.crmproj.entity.SysDeptRole;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/2/27.
 */
public interface DeptRoleService extends BaseService {
    int removeByPrimaryKey(String id);
    int add(SysDeptRole record);
    int addSelective(SysDeptRole record);
    SysDeptRole queryByPrimaryKey(String id);
    int editByPrimaryKeySelective(SysDeptRole record);
    int editByPrimaryKey(SysDeptRole record);
    List<Map> queryByOther(Map record);
}
