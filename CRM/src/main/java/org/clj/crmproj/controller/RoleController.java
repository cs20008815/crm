package org.clj.crmproj.controller;

import org.apache.commons.beanutils.BeanUtils;
import org.clj.crmproj.entity.SysDeptRole;
import org.clj.crmproj.entity.SysSchoolDept;
import org.clj.crmproj.entity.SysUserSchool;
import org.clj.crmproj.service.*;
import org.clj.crmproj.util.EhcacheUtil;
import org.clj.crmproj.util.Response;
import org.springframework.stereotype.Controller;
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
                    role.put("children", new ArrayList<>());
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
            System.out.println("userSchools:------" + userSchools.toString());
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
            System.out.println("schoolDepts:------" + schoolDepts.toString());
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
            System.out.println("deptRoles:------" + deptRoles.toString());
            SysDeptRole sysDeptRole = new SysDeptRole();
            BeanUtils.populate(sysDeptRole, schoolDepts.get(0));
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
