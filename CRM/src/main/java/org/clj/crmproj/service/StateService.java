package org.clj.crmproj.service;

import org.clj.crmproj.entity.State;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/12/8.
 */
public interface StateService {
    /**
     * 获取来源
     * @return User
     * @throws Exception
     */
    List<State> fandAll();

    List<State> fandByAttr1(Map map);

    int addSelective(State record);

    int removeByPrimaryKey(String sid);
}
