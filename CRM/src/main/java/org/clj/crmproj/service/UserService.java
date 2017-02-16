package org.clj.crmproj.service;

import org.clj.crmproj.entity.User;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/12/19.
 */
public interface UserService {
    List<User> fandByAttr1(Map map);

    int editByPrimaryKeySelective(User user);

    int addUser(User user);
}
