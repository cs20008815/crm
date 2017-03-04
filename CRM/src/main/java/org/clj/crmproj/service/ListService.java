package org.clj.crmproj.service;

import org.clj.crmproj.entity.SysList;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/2/27.
 */
public interface ListService extends BaseService {
    int removeByPrimaryKey(String id);
    int add(SysList record);
    int addSelective(SysList record);
    SysList queryByPrimaryKey(String id);
    int editByPrimaryKeySelective(SysList record);
    int editByPrimaryKey(SysList record);
    List<Map> queryByOther(Map record);
}
