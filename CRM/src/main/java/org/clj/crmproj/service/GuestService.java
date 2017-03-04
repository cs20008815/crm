package org.clj.crmproj.service;

import org.clj.crmproj.entity.SysGuest;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/2/27.
 */
public interface GuestService extends BaseService {
    int removeByPrimaryKey(String id);
    int add(SysGuest record);
    int addSelective(SysGuest record);
    SysGuest queryByPrimaryKey(String id);
    int editByPrimaryKeySelective(SysGuest record);
    int editByPrimaryKey(SysGuest record);
    List<Map> queryByOther(Map record);
}
