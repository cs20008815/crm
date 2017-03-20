package org.clj.crmproj.controller;

import org.apache.commons.beanutils.BeanUtils;
import org.clj.crmproj.entity.SysDeptRole;
import org.clj.crmproj.entity.SysRole;
import org.clj.crmproj.entity.SysSchoolDept;
import org.clj.crmproj.entity.SysUserSchool;
import org.clj.crmproj.service.*;
import org.clj.crmproj.util.EhcacheUtil;
import org.clj.crmproj.util.Response;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.*;

/**
 * Created by Administrator on 2017/2/20.
 */
@Controller
@RequestMapping("api/role")
public class RoleController {
    @Resource
    private SchoolService schoolService;

    @Resource
    private DeptService deptService;

    @Resource
    private RoleService roleService;

    @Resource
    private UserSchoolService userSchoolService;

    @Resource
    private SchoolDeptService schoolDeptService;

    @Resource
    private DeptRoleService deptRoleService;

    @Resource
    private RoleService service;

    @RequestMapping(value = "/query/{id}")
    @ResponseBody
    public Response query(@PathVariable(value = "id") String id) throws Exception{
        Map reqMap = new HashMap();
        reqMap.put("sid",id);
        return new Response(service.queryByOther(reqMap));
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

        SysRole addTable = new SysRole();
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

        SysRole addTable = new SysRole();
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

        SysRole addTable = new SysRole();
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

    @RequestMapping(value = "/queryRoleList")
    @ResponseBody
    public Response queryRoleList(@RequestBody Map requestMap) throws Exception{
        Map map = new HashMap();
        List<Map> schools = schoolService.queryByOther(map);
        for(Map school : schools){
            school.put("name", school.get("attr1"));
            school.put("id", school.get("sid"));
            school.put("nocheck", true);
            Map deptMap = new HashMap();
            deptMap.put("attr2",school.get("sid"));
            List<Map> depts = deptService.queryByOther(deptMap);
            for(Map dept : depts){
                dept.put("name", dept.get("attr1"));
                dept.put("id", dept.get("sid"));
                dept.put("nocheck", true);
                Map roleMap = new HashMap();
                roleMap.put("attr2",dept.get("sid"));
                List<Map> roles = roleService.queryByOther(roleMap);
                for(Map role : roles){
                    role.put("name", role.get("attr1"));
                    role.put("id", role.get("sid"));
                    role.put("children", new ArrayList<Map>());
                }
                dept.put("children", roles);
            }
            school.put("children", depts);
        }


        return new Response(schools);
    }

    @RequestMapping(value = "/editRole")
    @ResponseBody
    public Response editRole(@RequestBody Map requestMap) throws Exception{
        Object o = EhcacheUtil.getInstance().get("user");
        if(null == o){
            return new Response("LOGIN_TIME_OUT","登陆超时");
        }
        Map user = (Map)o;

        Map reqUser = (Map)requestMap.get("user");
        Map reqSchool = (Map)requestMap.get("school");
        Map reqDept = (Map)requestMap.get("dept");
        Map reqRole = (Map)requestMap.get("role");
        Map userSchoolMap = new HashMap();
        userSchoolMap.put("attr1",reqUser.get("uid"));
        List<Map> userSchools = userSchoolService.queryByOther(userSchoolMap);
        if(userSchools.size() > 0){
            SysUserSchool sysUserSchool = new SysUserSchool();
            BeanUtils.populate(sysUserSchool, userSchools.get(0));
            sysUserSchool.setAttr1(reqUser.get("uid").toString());
            sysUserSchool.setAttr2(reqSchool.get("sid").toString());
            sysUserSchool.setAttr18(user.get("uid").toString());
            sysUserSchool.setAttr19(new Date().toLocaleString());
            userSchoolService.editByPrimaryKeySelective(sysUserSchool);
        }else{
            userSchoolMap.put("attr2", reqSchool.get("sid"));
            userSchoolMap.put("attr16", user.get("uid").toString());
            userSchoolMap.put("attr17", new Date().toLocaleString());
            userSchoolMap.put("attr18", user.get("uid").toString());
            userSchoolMap.put("attr19", new Date().toLocaleString());
            userSchoolMap.put("attr20", "1");
            SysUserSchool sysUserSchool = new SysUserSchool();
            BeanUtils.populate(sysUserSchool, userSchoolMap);
            userSchoolService.addSelective(sysUserSchool);
        }

        Map schoolDeptMap = new HashMap();
        schoolDeptMap.put("attr3", reqUser.get("uid"));
        List<Map> schoolDepts = schoolDeptService.queryByOther(schoolDeptMap);
        if(schoolDepts.size() > 0){
            SysSchoolDept sysSchoolDept = new SysSchoolDept();
            BeanUtils.populate(sysSchoolDept, schoolDepts.get(0));
            sysSchoolDept.setAttr1(reqSchool.get("sid").toString());
            sysSchoolDept.setAttr2(reqDept.get("sid").toString());
            sysSchoolDept.setAttr3(reqUser.get("uid").toString());
            sysSchoolDept.setAttr18(user.get("uid").toString());
            sysSchoolDept.setAttr19(new Date().toLocaleString());
            schoolDeptService.editByPrimaryKeySelective(sysSchoolDept);
        }else{
            schoolDeptMap.put("attr1", reqSchool.get("sid"));
            schoolDeptMap.put("attr2", reqDept.get("sid"));
            schoolDeptMap.put("attr16", user.get("uid").toString());
            schoolDeptMap.put("attr17", new Date().toLocaleString());
            schoolDeptMap.put("attr18", user.get("uid").toString());
            schoolDeptMap.put("attr19", new Date().toLocaleString());
            schoolDeptMap.put("attr20", "1");
            SysSchoolDept sysSchoolDept = new SysSchoolDept();
            BeanUtils.populate(sysSchoolDept, schoolDeptMap);
            schoolDeptService.addSelective(sysSchoolDept);
        }

        Map deptRoleMap = new HashMap();
        deptRoleMap.put("attr3", reqUser.get("uid"));
        List<Map> deptRoles = deptRoleService.queryByOther(deptRoleMap);
        if(deptRoles.size() > 0){
            SysDeptRole sysDeptRole = new SysDeptRole();
            BeanUtils.populate(sysDeptRole, deptRoles.get(0));
            sysDeptRole.setAttr1(reqDept.get("sid").toString());
            sysDeptRole.setAttr2(reqRole.get("sid").toString());
            sysDeptRole.setAttr3(reqUser.get("uid").toString());
            sysDeptRole.setAttr18(user.get("uid").toString());
            sysDeptRole.setAttr19(new Date().toLocaleString());

            deptRoleService.editByPrimaryKeySelective(sysDeptRole);
        }else{
            deptRoleMap.put("attr1", reqDept.get("sid"));
            deptRoleMap.put("attr2", reqRole.get("sid"));
            deptRoleMap.put("attr16", user.get("uid").toString());
            deptRoleMap.put("attr17", new Date().toLocaleString());
            deptRoleMap.put("attr18", user.get("uid").toString());
            deptRoleMap.put("attr19", new Date().toLocaleString());
            deptRoleMap.put("attr20", "1");
            SysDeptRole sysDeptRole = new SysDeptRole();
            BeanUtils.populate(sysDeptRole, deptRoleMap);
            deptRoleService.addSelective(sysDeptRole);
        }

        return new Response();
    }
}
