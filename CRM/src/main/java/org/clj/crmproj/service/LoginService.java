package org.clj.crmproj.service;

import org.clj.crmproj.entity.User;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/11/7.
 */
public interface LoginService {
    /**
     * 用户登录
     * @return User
     * @throws Exception
     */
    Map login(Map map);

    List<Map> getMenu(Map map);
}
