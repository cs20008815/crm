package org.clj.crmproj.service;

import org.clj.crmproj.entity.SysUser;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/2/27.
 */
public interface UserService extends BaseService {
    int removeByPrimaryKey(String id);
    int add(SysUser record);
    int addSelective(SysUser record);
    SysUser queryByPrimaryKey(String id);
    int editByPrimaryKeySelective(SysUser record);
    int editByPrimaryKey(SysUser record);
    List<Map> queryByOther(Map record);
    List<Map> queryUserByMap();
    Map queryUserById(Map map);
}
