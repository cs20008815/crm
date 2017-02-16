package org.clj.crmproj.service;

import org.clj.crmproj.entity.Yxcp;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/12/18.
 */
public interface YxcpService {
    List<Yxcp> fandAll();

    List<Yxcp> fandByAttr1(Map map);

    int addSelective(Yxcp record);

    int removeByPrimaryKey(String sid);
}
