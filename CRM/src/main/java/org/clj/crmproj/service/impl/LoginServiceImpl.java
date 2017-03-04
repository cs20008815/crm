package org.clj.crmproj.service.impl;

import org.clj.crmproj.mapper.SysLoginMapper;
import org.clj.crmproj.service.LoginService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/2/18.
 */
@Service("loginService")
public class LoginServiceImpl implements LoginService {

    @Resource
    private SysLoginMapper sysLoginMapper;

    @Override
    public Map userLogin(Map map){
        return sysLoginMapper.loginByMap(map);
    }
}
