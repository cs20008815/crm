package org.clj.crmproj.controller;

import org.apache.commons.beanutils.BeanUtils;
import org.clj.crmproj.entity.SysDept;
import org.clj.crmproj.entity.SysSchool;
import org.clj.crmproj.service.DeptService;
import org.clj.crmproj.util.EhcacheUtil;
import org.clj.crmproj.util.Response;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/3/3.
 */
@Controller
@RequestMapping("api/dept")
public class DeptController {
    @Resource
    private DeptService service;

    @RequestMapping(value = "/query/{id}")
    @ResponseBody
    public Response query(@PathVariable(value = "id") String id) throws Exception{
        Map reqMap = new HashMap();
        reqMap.put("sid",id);
        return new Response(service.queryByOther(reqMap));
    }

    @RequestMapping(value = "/queryDept")
    @ResponseBody
    public Response queryDept(@RequestBody Map requestMap) throws Exception{
        return new Response(service.queryPage(requestMap));
    }

    @RequestMapping(value = "/queryPage")
    @ResponseBody
    public Response queryPage(@RequestBody Map requestMap) throws Exception{
        Map resMap = new HashMap();
        resMap.put("pageCount", service.queryCount(requestMap));
        resMap.put("pageData", service.queryPage(requestMap));
        return new Response(resMap);
    }

    @RequestMapping(value = "/add")
    @ResponseBody
    public Response add(@RequestBody Map requestMap) throws Exception{
        Object o = EhcacheUtil.getInstance().get("user");
        if(null == o){
            return new Response("LOGIN_TIME_OUT","登陆超时");
        }
        Map user = (Map)o;

        SysDept addTable = new SysDept();
        BeanUtils.populate(addTable, requestMap);
        addTable.setAttr16(user.get("uid").toString());
        addTable.setAttr17(new Date().toLocaleString());
        addTable.setAttr18(user.get("uid").toString());
        addTable.setAttr19(new Date().toLocaleString());
        addTable.setAttr20("1");
        int i = service.addSelective(addTable);
        if(i > 0){
            return new Response();
        }else{
            return new Response("添加失败");
        }
    }

    @RequestMapping(value = "/edit")
    @ResponseBody
    public Response edit(@RequestBody Map requestMap) throws Exception{
        Object o = EhcacheUtil.getInstance().get("user");
        if(null == o){
            return new Response("LOGIN_TIME_OUT","登陆超时");
        }
        Map user = (Map)o;

        SysDept addTable = new SysDept();
        BeanUtils.populate(addTable, requestMap);
        addTable.setAttr18(user.get("uid").toString());
        addTable.setAttr19(new Date().toLocaleString());
        int i = service.editByPrimaryKeySelective(addTable);
        if(i > 0){
            return new Response();
        }else{
            return new Response("修改失败");
        }
    }

    @RequestMapping(value = "/remove/{id}")
    @ResponseBody
    public Response remove(@PathVariable(value = "id") String id){
        Object o = EhcacheUtil.getInstance().get("user");
        if(null == o){
            return new Response("LOGIN_TIME_OUT","登陆超时");
        }
        Map user = (Map)o;

        SysDept addTable = new SysDept();
        addTable.setSid(id);
        addTable.setAttr18(user.get("uid").toString());
        addTable.setAttr19(new Date().toLocaleString());
        addTable.setAttr20("0");
        int i = service.editByPrimaryKeySelective(addTable);
        if(i > 0){
            return new Response();
        }else{
            return new Response("删除失败");
        }
    }
}
