package org.clj.crmproj.service;

import org.clj.crmproj.entity.SysGuestCc;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/2/27.
 */
public interface GuestCcService extends BaseService {
    int removeByPrimaryKey(String id);
    int add(SysGuestCc record);
    int addSelective(SysGuestCc record);
    SysGuestCc queryByPrimaryKey(String id);
    int editByPrimaryKeySelective(SysGuestCc record);
    int editByPrimaryKey(SysGuestCc record);
    List<Map> queryByOther(Map record);
}
