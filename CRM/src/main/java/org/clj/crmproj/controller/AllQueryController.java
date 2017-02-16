package org.clj.crmproj.controller;

import com.alibaba.fastjson.JSON;
import org.clj.crmproj.entity.*;
import org.clj.crmproj.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/12/8.
 */
@Controller
@RequestMapping("/Query")
public class AllQueryController {
    @Resource
    StateService stateService;

    @Resource
    SourceService sourceService;

    @Resource
    SchoolService schoolService;

    @Resource
    QdService qdService;

    @Resource
    LyService lyService;

    @Resource
    YxcpService yxcpService;

    @Resource
    KcxqService kcxqService;

    @Resource
    KhflService khflService;

    @Resource
    UserService userService;

    @Resource
    BaseService baseService;


    //状态
    @RequestMapping("/queryStateByattr1")
    public void queryStateByattr1(HttpServletRequest request,
                           HttpServletResponse response) throws Exception{

        Map jsonMap = new HashMap();
        jsonMap.put("attr1", request.getParameter("attr1"));

        String json = JSON.toJSONString(stateService.fandByAttr1(jsonMap));
        response.getWriter().print(json);
    }

    @RequestMapping(value = "/addState",method = RequestMethod.POST)
    public void addState(HttpServletRequest request,
                        HttpServletResponse response) throws Exception{
        State temp = new State();
        temp.setAttr1(request.getParameter("attr1"));
        temp.setAttr3("1");
        int i = stateService.addSelective(temp);

        if (i > 0){
            Map jsonMap = new HashMap();
            jsonMap.put("isSucc","true");
            String json = JSON.toJSONString(jsonMap);

            response.getWriter().print(json);
        }else{
            Map jsonMap = new HashMap();
            jsonMap.put("isSucc","false");
            String json = JSON.toJSONString(jsonMap);

            response.getWriter().print(json);
        }
    }

    @RequestMapping(value = "/removeState",method = RequestMethod.POST)
    public void removeState(HttpServletRequest request,
                           HttpServletResponse response) throws Exception{
        int i = stateService.removeByPrimaryKey(request.getParameter("sid"));

        if (i > 0){
            Map jsonMap = new HashMap();
            jsonMap.put("isSucc","true");
            String json = JSON.toJSONString(jsonMap);

            response.getWriter().print(json);
        }else{
            Map jsonMap = new HashMap();
            jsonMap.put("isSucc","false");
            String json = JSON.toJSONString(jsonMap);

            response.getWriter().print(json);
        }
    }

    //
    @RequestMapping("/sourceState")
    public void sourceState(HttpServletRequest request,
                           HttpServletResponse response) throws Exception{
        String json = JSON.toJSONString(sourceService.fandAll());
        response.getWriter().print(json);
    }

    @RequestMapping("/querySchoolByattr1")
    public void querySchoolByattr1(HttpServletRequest request,
                           HttpServletResponse response) throws Exception{

        Map jsonMap = new HashMap();
        jsonMap.put("attr1",request.getParameter("attr1"));

        String json = JSON.toJSONString(schoolService.selectByAttr1(jsonMap));
        response.getWriter().print(json);
    }

    @RequestMapping("/querySourceByattr1")
    public void querySourceByattr1(HttpServletRequest request,
                                   HttpServletResponse response) throws Exception{

        Map jsonMap = new HashMap();
        jsonMap.put("attr1", request.getParameter("attr1"));

        String json = JSON.toJSONString(sourceService.fandByAttr1(jsonMap));
        response.getWriter().print(json);
    }

    //渠道
    @RequestMapping("/queryQdByattr1")
    public void queryQdByattr1(HttpServletRequest request,
                                   HttpServletResponse response) throws Exception{

        Map jsonMap = new HashMap();
        jsonMap.put("attr1", request.getParameter("attr1"));

        String json = JSON.toJSONString(qdService.fandByAttr1(jsonMap));
        response.getWriter().print(json);
    }

    @RequestMapping(value = "/addQd",method = RequestMethod.POST)
    public void addQd(HttpServletRequest request,
                          HttpServletResponse response) throws Exception{
        Qd temp = new Qd();
        temp.setAttr1(request.getParameter("attr1"));
        temp.setAttr3("1");
        int i = qdService.addSelective(temp);

        if (i > 0){
            Map jsonMap = new HashMap();
            jsonMap.put("isSucc","true");
            String json = JSON.toJSONString(jsonMap);

            response.getWriter().print(json);
        }else{
            Map jsonMap = new HashMap();
            jsonMap.put("isSucc","false");
            String json = JSON.toJSONString(jsonMap);

            response.getWriter().print(json);
        }
    }

    @RequestMapping(value = "/removeQd",method = RequestMethod.POST)
    public void removeQd(HttpServletRequest request,
                             HttpServletResponse response) throws Exception{
        int i = qdService.removeByPrimaryKey(request.getParameter("sid"));

        if (i > 0){
            Map jsonMap = new HashMap();
            jsonMap.put("isSucc","true");
            String json = JSON.toJSONString(jsonMap);

            response.getWriter().print(json);
        }else{
            Map jsonMap = new HashMap();
            jsonMap.put("isSucc","false");
            String json = JSON.toJSONString(jsonMap);

            response.getWriter().print(json);
        }
    }

    //来源
    @RequestMapping("/queryLyByattr1")
    public void queryLyByattr1(HttpServletRequest request,
                               HttpServletResponse response) throws Exception{

        Map jsonMap = new HashMap();
        jsonMap.put("attr1", request.getParameter("attr1"));

        String json = JSON.toJSONString(lyService.fandByAttr1(jsonMap));
        response.getWriter().print(json);
    }

    @RequestMapping(value = "/addLy",method = RequestMethod.POST)
    public void addLy(HttpServletRequest request,
                      HttpServletResponse response) throws Exception{
        Ly temp = new Ly();
        temp.setAttr1(request.getParameter("attr1"));
        temp.setAttr3("1");
        int i = lyService.addSelective(temp);

        if (i > 0){
            Map jsonMap = new HashMap();
            jsonMap.put("isSucc","true");
            String json = JSON.toJSONString(jsonMap);

            response.getWriter().print(json);
        }else{
            Map jsonMap = new HashMap();
            jsonMap.put("isSucc","false");
            String json = JSON.toJSONString(jsonMap);

            response.getWriter().print(json);
        }
    }

    @RequestMapping(value = "/removeLy",method = RequestMethod.POST)
    public void removeLy(HttpServletRequest request,
                         HttpServletResponse response) throws Exception{
        int i = lyService.removeByPrimaryKey(request.getParameter("sid"));

        if (i > 0){
            Map jsonMap = new HashMap();
            jsonMap.put("isSucc","true");
            String json = JSON.toJSONString(jsonMap);

            response.getWriter().print(json);
        }else{
            Map jsonMap = new HashMap();
            jsonMap.put("isSucc","false");
            String json = JSON.toJSONString(jsonMap);

            response.getWriter().print(json);
        }
    }

    //推广点
    @RequestMapping(value = "/queryTgdByattr1",method = RequestMethod.POST)
    public void queryTgdByattr1(HttpServletRequest request,
                             HttpServletResponse response) throws Exception{

        Map jsonMap = new HashMap();
        jsonMap.put("attr1", request.getParameter("attr1"));

        String json = JSON.toJSONString(sourceService.fandByAttr1(jsonMap));
        response.getWriter().print(json);
    }

    @RequestMapping(value = "/addTgd",method = RequestMethod.POST)
    public void addTgd(HttpServletRequest request,
                      HttpServletResponse response) throws Exception{
        Source temp = new Source();
        temp.setAttr1(request.getParameter("attr1"));
        temp.setAttr3("1");
        int i = sourceService.addSelective(temp);

        if (i > 0){
            Map jsonMap = new HashMap();
            jsonMap.put("isSucc","true");
            String json = JSON.toJSONString(jsonMap);

            response.getWriter().print(json);
        }else{
            Map jsonMap = new HashMap();
            jsonMap.put("isSucc","false");
            String json = JSON.toJSONString(jsonMap);

            response.getWriter().print(json);
        }
    }

    @RequestMapping(value = "/removeTgd",method = RequestMethod.POST)
    public void removeTgd(HttpServletRequest request,
                         HttpServletResponse response) throws Exception{
        int i = sourceService.removeByPrimaryKey(request.getParameter("sid"));

        if (i > 0){
            Map jsonMap = new HashMap();
            jsonMap.put("isSucc","true");
            String json = JSON.toJSONString(jsonMap);

            response.getWriter().print(json);
        }else{
            Map jsonMap = new HashMap();
            jsonMap.put("isSucc","false");
            String json = JSON.toJSONString(jsonMap);

            response.getWriter().print(json);
        }
    }

    //意向产品类型
    @RequestMapping(value = "/queryYxcpByattr1",method = RequestMethod.POST)
    public void queryYxcpByattr1(HttpServletRequest request,
                                HttpServletResponse response) throws Exception{

        Map jsonMap = new HashMap();
        jsonMap.put("attr1", request.getParameter("attr1"));

        String json = JSON.toJSONString(yxcpService.fandByAttr1(jsonMap));
        response.getWriter().print(json);
    }

    @RequestMapping(value = "/addYxcp",method = RequestMethod.POST)
    public void addYxcp(HttpServletRequest request,
                       HttpServletResponse response) throws Exception{
        Yxcp temp = new Yxcp();
        temp.setAttr1(request.getParameter("attr1"));
        temp.setAttr3("1");
        int i = yxcpService.addSelective(temp);

        if (i > 0){
            Map jsonMap = new HashMap();
            jsonMap.put("isSucc","true");
            String json = JSON.toJSONString(jsonMap);

            response.getWriter().print(json);
        }else{
            Map jsonMap = new HashMap();
            jsonMap.put("isSucc","false");
            String json = JSON.toJSONString(jsonMap);

            response.getWriter().print(json);
        }
    }

    @RequestMapping(value = "/removeYxcp",method = RequestMethod.POST)
    public void removeYxcp(HttpServletRequest request,
                          HttpServletResponse response) throws Exception{
        int i = yxcpService.removeByPrimaryKey(request.getParameter("sid"));

        if (i > 0){
            Map jsonMap = new HashMap();
            jsonMap.put("isSucc","true");
            String json = JSON.toJSONString(jsonMap);

            response.getWriter().print(json);
        }else{
            Map jsonMap = new HashMap();
            jsonMap.put("isSucc","false");
            String json = JSON.toJSONString(jsonMap);

            response.getWriter().print(json);
        }
    }

    //课程需求
    @RequestMapping(value = "/queryKcxqByattr1",method = RequestMethod.POST)
    public void queryKcxqByattr1(HttpServletRequest request,
                                 HttpServletResponse response) throws Exception{

        Map jsonMap = new HashMap();
        jsonMap.put("attr1", request.getParameter("attr1"));

        String json = JSON.toJSONString(kcxqService.fandByAttr1(jsonMap));
        response.getWriter().print(json);
    }

    @RequestMapping(value = "/addKcxq",method = RequestMethod.POST)
    public void addKcxq(HttpServletRequest request,
                        HttpServletResponse response) throws Exception{
        Kcxq temp = new Kcxq();
        temp.setAttr1(request.getParameter("attr1"));
        temp.setAttr3("1");
        int i = kcxqService.addSelective(temp);

        if (i > 0){
            Map jsonMap = new HashMap();
            jsonMap.put("isSucc","true");
            String json = JSON.toJSONString(jsonMap);

            response.getWriter().print(json);
        }else{
            Map jsonMap = new HashMap();
            jsonMap.put("isSucc","false");
            String json = JSON.toJSONString(jsonMap);

            response.getWriter().print(json);
        }
    }

    @RequestMapping(value = "/removeKcxq",method = RequestMethod.POST)
    public void removeKcxq(HttpServletRequest request,
                           HttpServletResponse response) throws Exception{
        int i = kcxqService.removeByPrimaryKey(request.getParameter("sid"));

        if (i > 0){
            Map jsonMap = new HashMap();
            jsonMap.put("isSucc","true");
            String json = JSON.toJSONString(jsonMap);

            response.getWriter().print(json);
        }else{
            Map jsonMap = new HashMap();
            jsonMap.put("isSucc","false");
            String json = JSON.toJSONString(jsonMap);

            response.getWriter().print(json);
        }
    }

    //客户分类
    @RequestMapping(value = "/queryKhflByattr1",method = RequestMethod.POST)
    public void queryKhflByattr1(HttpServletRequest request,
                                 HttpServletResponse response) throws Exception{

        Map jsonMap = new HashMap();
        jsonMap.put("attr1", request.getParameter("attr1"));

        String json = JSON.toJSONString(khflService.fandByAttr1(jsonMap));
        response.getWriter().print(json);
    }

    @RequestMapping(value = "/addKhfl",method = RequestMethod.POST)
    public void addKhfl(HttpServletRequest request,
                        HttpServletResponse response) throws Exception{
        Khfl temp = new Khfl();
        temp.setAttr1(request.getParameter("attr1"));
        temp.setAttr3("1");
        int i = khflService.addSelective(temp);

        if (i > 0){
            Map jsonMap = new HashMap();
            jsonMap.put("isSucc","true");
            String json = JSON.toJSONString(jsonMap);

            response.getWriter().print(json);
        }else{
            Map jsonMap = new HashMap();
            jsonMap.put("isSucc","false");
            String json = JSON.toJSONString(jsonMap);

            response.getWriter().print(json);
        }
    }

    @RequestMapping(value = "/removeKhfl",method = RequestMethod.POST)
    public void removeKhfl(HttpServletRequest request,
                           HttpServletResponse response) throws Exception{
        int i = khflService.removeByPrimaryKey(request.getParameter("sid"));

        if (i > 0){
            Map jsonMap = new HashMap();
            jsonMap.put("isSucc","true");
            String json = JSON.toJSONString(jsonMap);

            response.getWriter().print(json);
        }else{
            Map jsonMap = new HashMap();
            jsonMap.put("isSucc","false");
            String json = JSON.toJSONString(jsonMap);

            response.getWriter().print(json);
        }
    }

    //员工查询
    @RequestMapping(value = "/queryUserByattr1",method = RequestMethod.POST)
    public void queryUserByattr1(HttpServletRequest request,
                                 HttpServletResponse response) throws Exception{

        Map jsonMap = new HashMap();
        jsonMap.put("attr3", request.getParameter("attr3"));

        String json = JSON.toJSONString(userService.fandByAttr1(jsonMap));
        response.getWriter().print(json);
    }

    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    public void addUser(HttpServletRequest request,
                                 HttpServletResponse response) throws Exception{

        User temp = new User();
        temp.setAttr1(request.getParameter("attr1"));
        temp.setAttr2(request.getParameter("attr2"));
        temp.setAttr3(request.getParameter("attr3"));
        temp.setAttr4(request.getParameter("attr4"));
        temp.setAttr5(request.getParameter("attr5"));
        temp.setAttr6(request.getParameter("attr6"));
        temp.setAttr7(request.getParameter("attr7"));
        temp.setAttr8(request.getParameter("attr8"));
        temp.setAttr9(request.getParameter("attr9"));
        temp.setAttr10(request.getParameter("attr10"));
        temp.setAttr20("1");

        int i = userService.addUser(temp);

        if (i > 0){
            Map jsonMap = new HashMap();
            jsonMap.put("isSucc","true");
            String json = JSON.toJSONString(jsonMap);

            response.getWriter().print(json);
        }else{
            Map jsonMap = new HashMap();
            jsonMap.put("isSucc","false");
            String json = JSON.toJSONString(jsonMap);

            response.getWriter().print(json);
        }
    }

    @RequestMapping(value = "/editUser",method = RequestMethod.POST)
    public void editUser(HttpServletRequest request,
                        HttpServletResponse response) throws Exception{

    }

    @RequestMapping(value = "/removeUser",method = RequestMethod.POST)
    public void removeUser(HttpServletRequest request,
                         HttpServletResponse response) throws Exception{
        User temp = new User();
        temp.setUid(request.getParameter("sid"));
        temp.setAttr20("0");
        int i = userService.editByPrimaryKeySelective(temp);

        if (i > 0){
            Map jsonMap = new HashMap();
            jsonMap.put("isSucc","true");
            String json = JSON.toJSONString(jsonMap);

            response.getWriter().print(json);
        }else{
            Map jsonMap = new HashMap();
            jsonMap.put("isSucc","false");
            String json = JSON.toJSONString(jsonMap);

            response.getWriter().print(json);
        }
    }

    //保护期
    @RequestMapping(value = "/queryBhqByattr1",method = RequestMethod.POST)
    public void queryBhqByattr1(HttpServletRequest request,
                                 HttpServletResponse response) throws Exception{

        Map jsonMap = new HashMap();
        jsonMap.put("attr1", request.getParameter("attr1"));

        String json = JSON.toJSONString(baseService.fandBhqByAttr1(jsonMap));
        response.getWriter().print(json);
    }

    @RequestMapping(value = "/addBhq",method = RequestMethod.POST)
    public void addBhq(HttpServletRequest request,
                        HttpServletResponse response) throws Exception{
        Bhq temp = new Bhq();
        temp.setAttr1(request.getParameter("attr1"));
        temp.setAttr4("1");
        int i = baseService.addBhqSelective(temp);

        if (i > 0){
            Map jsonMap = new HashMap();
            jsonMap.put("isSucc","true");
            String json = JSON.toJSONString(jsonMap);

            response.getWriter().print(json);
        }else{
            Map jsonMap = new HashMap();
            jsonMap.put("isSucc","false");
            String json = JSON.toJSONString(jsonMap);

            response.getWriter().print(json);
        }
    }

    @RequestMapping(value = "/editBhq",method = RequestMethod.POST)
    public void editBhq(HttpServletRequest request,
                          HttpServletResponse response) throws Exception{
        Bhq temp = new Bhq();
        temp.setSid(request.getParameter("sid"));
        temp.setAttr3(request.getParameter("attr3"));
        temp.setAttr2(request.getParameter("attr2"));
        temp.setAttr4("1");

        int i = baseService.editBhqSelective(temp);

        if (i > 0){
            Map jsonMap = new HashMap();
            jsonMap.put("isSucc","true");
            String json = JSON.toJSONString(jsonMap);

            response.getWriter().print(json);
        }else{
            Map jsonMap = new HashMap();
            jsonMap.put("isSucc","false");
            String json = JSON.toJSONString(jsonMap);

            response.getWriter().print(json);
        }
    }

    @RequestMapping(value = "/removeBhq",method = RequestMethod.POST)
    public void removeBhq(HttpServletRequest request,
                           HttpServletResponse response) throws Exception{
        int i = baseService.removeBhqByPrimaryKey(request.getParameter("sid"));

        if (i > 0){
            Map jsonMap = new HashMap();
            jsonMap.put("isSucc","true");
            String json = JSON.toJSONString(jsonMap);

            response.getWriter().print(json);
        }else{
            Map jsonMap = new HashMap();
            jsonMap.put("isSucc","false");
            String json = JSON.toJSONString(jsonMap);

            response.getWriter().print(json);
        }
    }

    //部门
    @RequestMapping(value = "/queryDeptByattr1",method = RequestMethod.POST)
    public void queryDeptByattr1(HttpServletRequest request,
                                HttpServletResponse response) throws Exception{

        Map jsonMap = new HashMap();
        jsonMap.put("attr1", request.getParameter("attr1"));

        String json = JSON.toJSONString(baseService.fandDeptByAttr1(jsonMap));
        response.getWriter().print(json);
    }

    @RequestMapping(value = "/addDept",method = RequestMethod.POST)
    public void addDept(HttpServletRequest request,
                       HttpServletResponse response) throws Exception{
        Dept temp = new Dept();
        temp.setAttr1(request.getParameter("attr1"));
        temp.setAttr4("1");
        int i = baseService.addDeptSelective(temp);

        if (i > 0){
            Map jsonMap = new HashMap();
            jsonMap.put("isSucc","true");
            String json = JSON.toJSONString(jsonMap);

            response.getWriter().print(json);
        }else{
            Map jsonMap = new HashMap();
            jsonMap.put("isSucc","false");
            String json = JSON.toJSONString(jsonMap);

            response.getWriter().print(json);
        }
    }

    @RequestMapping(value = "/editDept",method = RequestMethod.POST)
    public void editDept(HttpServletRequest request,
                        HttpServletResponse response) throws Exception{
        Dept temp = new Dept();
        temp.setSid(request.getParameter("sid"));
        temp.setAttr3(request.getParameter("attr3"));
        temp.setAttr2(request.getParameter("attr2"));
        temp.setAttr4("1");

        int i = baseService.editDeptSelective(temp);

        if (i > 0){
            Map jsonMap = new HashMap();
            jsonMap.put("isSucc","true");
            String json = JSON.toJSONString(jsonMap);

            response.getWriter().print(json);
        }else{
            Map jsonMap = new HashMap();
            jsonMap.put("isSucc","false");
            String json = JSON.toJSONString(jsonMap);

            response.getWriter().print(json);
        }
    }

    @RequestMapping(value = "/removeDept",method = RequestMethod.POST)
    public void removeDept(HttpServletRequest request,
                          HttpServletResponse response) throws Exception{
        int i = baseService.removeDeptByPrimaryKey(request.getParameter("sid"));

        if (i > 0){
            Map jsonMap = new HashMap();
            jsonMap.put("isSucc","true");
            String json = JSON.toJSONString(jsonMap);

            response.getWriter().print(json);
        }else{
            Map jsonMap = new HashMap();
            jsonMap.put("isSucc","false");
            String json = JSON.toJSONString(jsonMap);

            response.getWriter().print(json);
        }
    }

    //角色
    @RequestMapping(value = "/queryRoleByattr1",method = RequestMethod.POST)
    public void queryRoleByattr1(HttpServletRequest request,
                                 HttpServletResponse response) throws Exception{

        Map jsonMap = new HashMap();
        jsonMap.put("attr1", request.getParameter("attr1"));

        String json = JSON.toJSONString(baseService.fandRoleByAttr1(jsonMap));
        response.getWriter().print(json);
    }

    @RequestMapping(value = "/addRole",method = RequestMethod.POST)
    public void addRole(HttpServletRequest request,
                        HttpServletResponse response) throws Exception{
        Role temp = new Role();
        temp.setAttr1(request.getParameter("attr1"));
        temp.setAttr3("1");
        temp.setAttr4("1");
        int i = baseService.addRoleSelective(temp);

        if (i > 0){
            Map jsonMap = new HashMap();
            jsonMap.put("isSucc","true");
            String json = JSON.toJSONString(jsonMap);

            response.getWriter().print(json);
        }else{
            Map jsonMap = new HashMap();
            jsonMap.put("isSucc","false");
            String json = JSON.toJSONString(jsonMap);

            response.getWriter().print(json);
        }
    }

    @RequestMapping(value = "/editRole",method = RequestMethod.POST)
    public void editRole(HttpServletRequest request,
                         HttpServletResponse response) throws Exception{
        Role temp = new Role();
        temp.setSid(request.getParameter("sid"));
        temp.setAttr3(request.getParameter("attr3"));
        temp.setAttr2(request.getParameter("attr2"));
        temp.setAttr4("1");

        int i = baseService.editRoleSelective(temp);

        if (i > 0){
            Map jsonMap = new HashMap();
            jsonMap.put("isSucc","true");
            String json = JSON.toJSONString(jsonMap);

            response.getWriter().print(json);
        }else{
            Map jsonMap = new HashMap();
            jsonMap.put("isSucc","false");
            String json = JSON.toJSONString(jsonMap);

            response.getWriter().print(json);
        }
    }

    @RequestMapping(value = "/removeRole",method = RequestMethod.POST)
    public void removeRole(HttpServletRequest request,
                           HttpServletResponse response) throws Exception{
        int i = baseService.removeRoleByPrimaryKey(request.getParameter("sid"));

        if (i > 0){
            Map jsonMap = new HashMap();
            jsonMap.put("isSucc","true");
            String json = JSON.toJSONString(jsonMap);

            response.getWriter().print(json);
        }else{
            Map jsonMap = new HashMap();
            jsonMap.put("isSucc","false");
            String json = JSON.toJSONString(jsonMap);

            response.getWriter().print(json);
        }
    }

    //权限
    @RequestMapping(value = "/queryPermByattr1",method = RequestMethod.POST)
    public void queryPermByattr1(HttpServletRequest request,
                                 HttpServletResponse response) throws Exception{

        Map jsonMap = new HashMap();
        jsonMap.put("attr1", request.getParameter("attr1"));

        String json = JSON.toJSONString(baseService.fandPermByAttr1(jsonMap));
        response.getWriter().print(json);
    }

    @RequestMapping(value = "/addPerm",method = RequestMethod.POST)
    public void addPerm(HttpServletRequest request,
                        HttpServletResponse response) throws Exception{
        Perm temp = new Perm();
        temp.setAttr1(request.getParameter("attr1"));
        temp.setAttr4("1");
        int i = baseService.addPermSelective(temp);

        if (i > 0){
            Map jsonMap = new HashMap();
            jsonMap.put("isSucc","true");
            String json = JSON.toJSONString(jsonMap);

            response.getWriter().print(json);
        }else{
            Map jsonMap = new HashMap();
            jsonMap.put("isSucc","false");
            String json = JSON.toJSONString(jsonMap);

            response.getWriter().print(json);
        }
    }

    @RequestMapping(value = "/editPerm",method = RequestMethod.POST)
    public void editPerm(HttpServletRequest request,
                         HttpServletResponse response) throws Exception{
        Perm temp = new Perm();
        temp.setSid(request.getParameter("sid"));
        temp.setAttr3(request.getParameter("attr3"));
        temp.setAttr2(request.getParameter("attr2"));
        temp.setAttr4("1");

        int i = baseService.editPermSelective(temp);

        if (i > 0){
            Map jsonMap = new HashMap();
            jsonMap.put("isSucc","true");
            String json = JSON.toJSONString(jsonMap);

            response.getWriter().print(json);
        }else{
            Map jsonMap = new HashMap();
            jsonMap.put("isSucc","false");
            String json = JSON.toJSONString(jsonMap);

            response.getWriter().print(json);
        }
    }

    @RequestMapping(value = "/removePerm",method = RequestMethod.POST)
    public void removePerm(HttpServletRequest request,
                           HttpServletResponse response) throws Exception{
        int i = baseService.removePermByPrimaryKey(request.getParameter("sid"));

        if (i > 0){
            Map jsonMap = new HashMap();
            jsonMap.put("isSucc","true");
            String json = JSON.toJSONString(jsonMap);

            response.getWriter().print(json);
        }else{
            Map jsonMap = new HashMap();
            jsonMap.put("isSucc","false");
            String json = JSON.toJSONString(jsonMap);

            response.getWriter().print(json);
        }
    }

    //用户-权限
    @RequestMapping(value = "/queryUserPermByattr1",method = RequestMethod.POST)
    public void queryUserPermByattr1(HttpServletRequest request,
                                 HttpServletResponse response) throws Exception{

        Map jsonMap = new HashMap();
        String userid = request.getParameter("userid");
        jsonMap.put("userid", userid);
        if(null != request.getParameter("reqdata1") || null != request.getParameter("reqdata2")){
            String addPerm = request.getParameter("reqdata1");
            String delPerm = request.getParameter("reqdata2");
            String[] list1 = addPerm.split(",");
            String[] list2 = delPerm.split(",");
            for(String str : list1){
                jsonMap.put("permid", str);
                List<UserPerm> tempList = baseService.fandUserPermByAttr1(jsonMap);
                if(tempList.size() == 0){
                    UserPerm userPerm = new UserPerm();
                    userPerm.setUserid(userid);
                    userPerm.setPermid(str);
                    userPerm.setAttr4("1");
                    baseService.addUserPermSelective(userPerm);
                }
            }
            for(String str : list2){
                System.out.println("list2-"+str);
                jsonMap.put("permid", str);
                List<UserPerm> tempList = baseService.fandUserPermByAttr1(jsonMap);
                if(tempList.size() != 0){
                    UserPerm tempUserPerm = tempList.get(0);
                    tempUserPerm.setAttr4("0");
                    baseService.removeUserPermByPrimaryKey(tempUserPerm);
                }
            }
            Map retMap = new HashMap();
            retMap.put("isSucc","true");
            String json = JSON.toJSONString(retMap);

            response.getWriter().print(json);
        }else{
            String json = JSON.toJSONString(baseService.fandUserPermByAttr1(jsonMap));
            response.getWriter().print(json);
        }
    }
}
