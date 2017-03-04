package org.clj.crmproj.service;

import org.clj.crmproj.entity.SysSchool;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/2/27.
 */
public interface SchoolService extends BaseService {
    int removeByPrimaryKey(String id);
    int add(SysSchool record);
    int addSelective(SysSchool record);
    SysSchool queryByPrimaryKey(String id);
    int editByPrimaryKeySelective(SysSchool record);
    int editByPrimaryKey(SysSchool record);
    List<Map> queryByOther(Map record);
    int queryCount(Map map);
}
