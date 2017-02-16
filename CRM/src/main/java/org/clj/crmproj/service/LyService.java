package org.clj.crmproj.service;

import org.clj.crmproj.entity.Ly;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/12/16.
 */
public interface LyService {
    List<Ly> fandAll();

    List<Ly> fandByAttr1(Map map);

    int addSelective(Ly record);

    int removeByPrimaryKey(String sid);
}
