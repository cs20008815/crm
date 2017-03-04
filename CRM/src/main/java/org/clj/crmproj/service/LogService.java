package org.clj.crmproj.service;

import org.clj.crmproj.entity.SysLog;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/2/27.
 */
public interface LogService extends BaseService {
    int removeByPrimaryKey(String id);
    int add(SysLog record);
    int addSelective(SysLog record);
    SysLog queryByPrimaryKey(String id);
    int editByPrimaryKeySelective(SysLog record);
    int editByPrimaryKey(SysLog record);
    List<Map> queryByOther(Map record);
}
