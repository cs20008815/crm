package org.clj.crmproj.service;

import org.clj.crmproj.entity.Guest2;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/2/12.
 */
public interface Guest2Service {
    List<Guest2> fandByOpt(Map map);

    int newGuest(Guest2 guest);

    int editByPrimaryKeySelective(Guest2 guest);
}
