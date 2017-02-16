package org.clj.crmproj.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import org.clj.crmproj.entity.School;
import org.clj.crmproj.service.SchoolService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/11/27.
 */

@Controller
@RequestMapping("/School")
public class SchoolController {

    @Resource
    private SchoolService schoolService;

    @RequestMapping(value = "/getSchool",method = RequestMethod.POST)
    public void getAllSchool(HttpServletRequest request,
    HttpServletResponse response) throws Exception{
        List<School> tempSchool = schoolService.fandAll();
        String json = JSON.toJSONString(tempSchool);
        response.getWriter().print(json);
    }

    @RequestMapping(value = "/addSchool",method = RequestMethod.POST)
    public void addSchool(HttpServletRequest request,
                             HttpServletResponse response) throws Exception{
        School school = new School();
        school.setAttr1(request.getParameter("attr1"));
        int i = schoolService.addSelective(school);

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

    @RequestMapping(value = "/removeSchool",method = RequestMethod.POST)
    public void removeSchool(HttpServletRequest request,
                          HttpServletResponse response) throws Exception{
        int i = schoolService.removeByPrimaryKey(request.getParameter("sid"));

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
}
