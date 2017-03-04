package org.clj.crmproj.service;

import org.clj.crmproj.entity.SysMenuLink;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/2/27.
 */
public interface MenuLinkService extends BaseService {
    int removeByPrimaryKey(String id);
    int add(SysMenuLink record);
    int addSelective(SysMenuLink record);
    SysMenuLink queryByPrimaryKey(String id);
    int editByPrimaryKeySelective(SysMenuLink record);
    int editByPrimaryKey(SysMenuLink record);
    List<Map> queryByOther(Map record);
}
