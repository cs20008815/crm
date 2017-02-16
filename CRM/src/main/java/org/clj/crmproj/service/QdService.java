package org.clj.crmproj.service;

import org.clj.crmproj.entity.Qd;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/12/16.
 */
public interface QdService {
    List<Qd> fandAll();

    List<Qd> fandByAttr1(Map map);

    int addSelective(Qd record);

    int removeByPrimaryKey(String sid);
}
