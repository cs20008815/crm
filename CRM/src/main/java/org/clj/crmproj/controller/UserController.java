package org.clj.crmproj.controller;

import org.clj.crmproj.entity.SysUser;
import org.clj.crmproj.service.DeptRoleService;
import org.clj.crmproj.service.RoleService;
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
    @Resource
    private RoleService roleService;
    @Resource
    private DeptRoleService deptRoleService;

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

    @RequestMapping(value = "/query")
    @ResponseBody
    public Response query(@RequestBody Map requestMap) throws Exception{
        Object o = EhcacheUtil.getInstance().get("user");
        if(null == o){
            return new Response("LOGIN_TIME_OUT","登陆超时");
        }
        Map user = (Map)o;

        return new Response(userService.queryByOther(requestMap));
    }

    @RequestMapping(value = "/queryUserByDept")
    @ResponseBody
    public Response queryUserByDept(@RequestBody Map requestMap) throws Exception{
        Object o = EhcacheUtil.getInstance().get("user");
        if(null == o){
            return new Response("LOGIN_TIME_OUT","登陆超时");
        }
        Map user = (Map)o;
        Map roleMap = new HashMap();
        roleMap.put("attr3",user.get("roleId"));
        List<Map> roles = roleService.queryByOther(roleMap);
        List<SysUser> sysUsers = new ArrayList<SysUser>();
        for(Map role : roles){
            Map deptRoleMap = new HashMap();
            deptRoleMap.put("attr2", role.get("sid"));
            List<Map> deptRoles = deptRoleService.queryByOther(deptRoleMap);
            for(Map deptRole : deptRoles){
                sysUsers.add(userService.queryByPrimaryKey(deptRole.get("attr3").toString()));
            }
        }
        return new Response(sysUsers);
    }
}
