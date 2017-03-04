package org.clj.crmproj.service;

import org.clj.crmproj.entity.SysDept;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/2/27.
 */
public interface DeptService extends BaseService {
    int removeByPrimaryKey(String id);
    int add(SysDept record);
    int addSelective(SysDept record);
    SysDept queryByPrimaryKey(String id);
    int editByPrimaryKeySelective(SysDept record);
    int editByPrimaryKey(SysDept record);
    List<Map> queryByOther(Map record);
    int queryCount(Map map);
    List<Map> queryPage(Map record);
}
