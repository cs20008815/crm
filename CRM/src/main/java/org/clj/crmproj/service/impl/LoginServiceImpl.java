package org.clj.crmproj.service.impl;

import org.clj.crmproj.entity.User;
import org.clj.crmproj.mapper.LoginMapper;
import org.clj.crmproj.mapper.UserMapper;
import org.clj.crmproj.service.LoginService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/11/7.
 */
@Service("loginService")
public class LoginServiceImpl implements LoginService {

    @Resource
    private LoginMapper loginMapper;

    @Override
    public Map login(Map map) {
        return loginMapper.login(map);
    }

    @Override
    public List<Map> getMenu(Map map){
        return loginMapper.getMenu(map);
    }
}
