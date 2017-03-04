package org.clj.crmproj.service;

import org.clj.crmproj.entity.SysGuestQt;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/2/27.
 */
public interface GuestQtService extends BaseService {
    int removeByPrimaryKey(String id);
    int add(SysGuestQt record);
    int addSelective(SysGuestQt record);
    SysGuestQt queryByPrimaryKey(String id);
    int editByPrimaryKeySelective(SysGuestQt record);
    int editByPrimaryKey(SysGuestQt record);
    List<Map> queryByOther(Map record);
}
