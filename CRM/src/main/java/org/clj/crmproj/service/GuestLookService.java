package org.clj.crmproj.service;

import org.clj.crmproj.entity.SysGuest;
import org.clj.crmproj.entity.SysGuestLook;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/2/27.
 */
public interface GuestLookService extends BaseService {
    int removeByPrimaryKey(String id);
    int add(SysGuestLook record);
    int addSelective(SysGuestLook record);
    SysGuestLook queryByPrimaryKey(String id);
    int editByPrimaryKeySelective(SysGuestLook record);
    int editByPrimaryKey(SysGuestLook record);
    List<Map> queryByOther(Map record);
    int queryCount(Map map);
    int addBatch(List<SysGuestLook> record);
}
