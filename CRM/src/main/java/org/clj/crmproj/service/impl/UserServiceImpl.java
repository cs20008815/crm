package org.clj.crmproj.service.impl;

import org.clj.crmproj.entity.User;
import org.clj.crmproj.mapper.UserMapper;
import org.clj.crmproj.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/12/19.
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    public List<User> fandByAttr1(Map map){
        return userMapper.selectByAttr1(map);
    }

    public int editByPrimaryKeySelective(User user){ return userMapper.updateByPrimaryKeySelective(user); }

    public int addUser(User user){ return userMapper.insertSelective(user); }
}
