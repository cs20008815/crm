package org.clj.crmproj.service;

import org.clj.crmproj.entity.SysListOpt;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/2/27.
 */
public interface ListOptService extends BaseService {
    int removeByPrimaryKey(String id);
    int add(SysListOpt record);
    int addSelective(SysListOpt record);
    SysListOpt queryByPrimaryKey(String id);
    int editByPrimaryKeySelective(SysListOpt record);
    int editByPrimaryKey(SysListOpt record);
    List<Map> queryByOther(Map record);
}
