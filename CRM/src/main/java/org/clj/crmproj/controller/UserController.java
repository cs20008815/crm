package org.clj.crmproj.controller;

import org.clj.crmproj.service.UserService;
import org.clj.crmproj.util.EhcacheUtil;
import org.clj.crmproj.util.Response;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/2/20.
 */
@Controller
@RequestMapping("api/user")
public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping(value = "/queryUserList")
    @ResponseBody
    public Response queryUserList() throws Exception{
        List<Map> users = userService.queryUserByMap();
        for(Map user : users){
            user.put("name", user.get("userName"));
            user.put("id", user.get("uid"));
        }
        return new Response(users);
    }

    @RequestMapping(value = "/queryUser/{id}")
    @ResponseBody
    public Response queryUser(@PathVariable(value = "id") String id) throws Exception{
        Map map = new HashMap();
        map.put("sid",id);
        Map user = userService.queryUserById(map);

        return new Response(user);
    }
}
