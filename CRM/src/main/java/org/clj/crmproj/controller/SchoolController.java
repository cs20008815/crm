package org.clj.crmproj.controller;

import org.apache.commons.beanutils.BeanUtils;
import org.clj.crmproj.entity.SysSchool;
import org.clj.crmproj.service.SchoolService;
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
 * Created by Administrator on 2017/3/1.
 */
@Controller
@RequestMapping("api/school")
public class SchoolController {
    @Resource
    private SchoolService schoolService;

    @RequestMapping(value = "/query/{id}")
    @ResponseBody
    public Response query(@PathVariable(value = "id") String id) throws Exception{
        Map reqMap = new HashMap();
        reqMap.put("sid",id);
        return new Response(schoolService.queryByOther(reqMap));
    }

    @RequestMapping(value = "/querySchoolPage")
    @ResponseBody
    public Response querySchoolPage(@RequestBody Map requestMap) throws Exception{
        Map resMap = new HashMap();
        resMap.put("pageCount", schoolService.queryCount(requestMap));
        resMap.put("pageData", schoolService.queryByOther(requestMap));
        return new Response(resMap);
    }

    @RequestMapping(value = "/querySchool")
    @ResponseBody
    public Response querySchool(@RequestBody Map requestMap) throws Exception{
        return new Response(schoolService.queryByOther(requestMap));
    }

    @RequestMapping(value = "/addSchool")
    @ResponseBody
    public Response addSchool(@RequestBody Map requestMap) throws Exception{
        Object o = EhcacheUtil.getInstance().get("user");
        if(null == o){
            return new Response("LOGIN_TIME_OUT","登陆超时");
        }
        Map user = (Map)o;

        SysSchool sysSchool = new SysSchool();
        BeanUtils.populate(sysSchool, requestMap);
        sysSchool.setAttr16(user.get("uid").toString());
        sysSchool.setAttr17(new Date().toLocaleString());
        sysSchool.setAttr18(user.get("uid").toString());
        sysSchool.setAttr19(new Date().toLocaleString());
        sysSchool.setAttr20("1");
        int i = schoolService.addSelective(sysSchool);
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

        SysSchool sysSchool = new SysSchool();
        BeanUtils.populate(sysSchool, requestMap);
        sysSchool.setAttr18(user.get("uid").toString());
        sysSchool.setAttr19(new Date().toLocaleString());
        int i = schoolService.editByPrimaryKeySelective(sysSchool);
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

        SysSchool sysSchool = new SysSchool();
        sysSchool.setSid(id);
        sysSchool.setAttr18(user.get("uid").toString());
        sysSchool.setAttr19(new Date().toLocaleString());
        sysSchool.setAttr20("0");
        int i = schoolService.editByPrimaryKeySelective(sysSchool);
        if(i > 0){
            return new Response();
        }else{
            return new Response("删除失败");
        }
    }
}
