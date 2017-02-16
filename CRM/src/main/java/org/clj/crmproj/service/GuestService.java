package org.clj.crmproj.service;

import org.clj.crmproj.entity.Guest;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/11/30.
 */
public interface GuestService {
    /**
     * 获取客户信息
     * @return User
     * @throws Exception
     */
    List<Map> fandByOpt(Map map);

    /**
     * 获取客户总数
     * @return count
     * @throws Exception
     */
    Map fandCount(Map map);

    int newGuest(Guest guest);

    int editByPrimaryKeySelective(Guest guest);
}
