package org.clj.crmproj.test;

import com.alibaba.fastjson.JSON;
import org.apache.log4j.Logger;

import org.clj.crmproj.entity.User;
import org.clj.crmproj.service.LoginService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/11/8.
 */

@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})

public class TestMyBatis {

    private static Logger logger = Logger.getLogger(TestMyBatis.class);

    @Resource
    private LoginService loginService = null;

    @Test
    public void test1() {
        Map map = new HashMap();
        map.put("username","");
        map.put("password", "");

        Map user = loginService.login(map);

        logger.info(JSON.toJSONString(user));
    }

}
