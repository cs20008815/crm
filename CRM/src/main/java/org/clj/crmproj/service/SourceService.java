package org.clj.crmproj.service;

import org.clj.crmproj.entity.Source;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/11/28.
 */
public interface SourceService {

    /**
     * 获取来源
     * @return User
     * @throws Exception
     */
    List<Source> fandAll();

    List<Source> fandByAttr1(Map map);

    int addSelective(Source record);

    int removeByPrimaryKey(String sid);
}
