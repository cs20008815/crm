package org.clj.crmproj.service;

import org.clj.crmproj.entity.SysSchoolDept;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/2/27.
 */
public interface SchoolDeptService extends BaseService {
    int removeByPrimaryKey(String id);
    int add(SysSchoolDept record);
    int addSelective(SysSchoolDept record);
    SysSchoolDept queryByPrimaryKey(String id);
    int editByPrimaryKeySelective(SysSchoolDept record);
    int editByPrimaryKey(SysSchoolDept record);
    List<Map> queryByOther(Map record);
}
