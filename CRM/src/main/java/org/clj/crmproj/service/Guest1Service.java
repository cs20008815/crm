package org.clj.crmproj.service;

import org.clj.crmproj.entity.Guest1;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/12/26.
 */
public interface Guest1Service {
    List<Map> fandByOpt(Map map);

    int newGuest(Guest1 guest);

    int editByPrimaryKeySelective(Guest1 guest);
}
