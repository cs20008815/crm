package org.clj.crmproj.service;

import org.clj.crmproj.entity.SysGuestMk;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/2/27.
 */
public interface GuestMkService extends BaseService {
    int removeByPrimaryKey(String id);
    int add(SysGuestMk record);
    int addSelective(SysGuestMk record);
    SysGuestMk queryByPrimaryKey(String id);
    int editByPrimaryKeySelective(SysGuestMk record);
    int editByPrimaryKey(SysGuestMk record);
    List<Map> queryByOther(Map record);
}
