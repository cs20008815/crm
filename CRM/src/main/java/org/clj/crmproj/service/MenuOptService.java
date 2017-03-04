package org.clj.crmproj.service;

import org.clj.crmproj.entity.SysMenuOpt;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/2/27.
 */
public interface MenuOptService extends BaseService {
    int removeByPrimaryKey(String id);
    int add(SysMenuOpt record);
    int addSelective(SysMenuOpt record);
    SysMenuOpt queryByPrimaryKey(String id);
    int editByPrimaryKeySelective(SysMenuOpt record);
    int editByPrimaryKey(SysMenuOpt record);
    List<Map> queryByOther(Map record);
}
