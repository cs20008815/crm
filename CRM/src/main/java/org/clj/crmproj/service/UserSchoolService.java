package org.clj.crmproj.service;

import org.clj.crmproj.entity.SysUserSchool;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/2/27.
 */
public interface UserSchoolService extends BaseService {
    int removeByPrimaryKey(String id);
    int add(SysUserSchool record);
    int addSelective(SysUserSchool record);
    SysUserSchool queryByPrimaryKey(String id);
    int editByPrimaryKeySelective(SysUserSchool record);
    int editByPrimaryKey(SysUserSchool record);
    List<Map> queryByOther(Map record);
}
