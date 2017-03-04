package org.clj.crmproj.service;

import org.clj.crmproj.entity.SysGuestTmk;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/2/27.
 */
public interface GuestTmkService extends BaseService {
    int removeByPrimaryKey(String id);
    int add(SysGuestTmk record);
    int addSelective(SysGuestTmk record);
    SysGuestTmk queryByPrimaryKey(String id);
    int editByPrimaryKeySelective(SysGuestTmk record);
    int editByPrimaryKey(SysGuestTmk record);
    List<Map> queryByOther(Map record);
}
