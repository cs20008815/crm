package org.clj.crmproj.controller;

import com.alibaba.fastjson.JSON;
import org.clj.crmproj.entity.Guest1;
import org.clj.crmproj.service.Guest1Service;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/12/26.
 */
@Controller
@RequestMapping("/Guest1")
public class Guest1Controller {
    @Resource
    Guest1Service guest1Service;

    @RequestMapping("/newGuest1")
    public void newGuest1 (HttpServletRequest request,
                          HttpServletResponse response) throws Exception{
        Guest1 guest1 = new Guest1();

        Map<String, String> user = (Map) request.getSession().getAttribute("user");

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(new Date());
        System.out.println(request.getSession().getAttribute("user"));
        guest1.setAttr1(user.get("uid"));
        guest1.setAttr2(user.get("schoolId"));
        guest1.setAttr3(dateString);
        guest1.setAttr4(request.getParameter("attr4"));
        guest1.setAttr5(request.getParameter("attr5"));
        guest1.setAttr6(request.getParameter("attr6"));
        guest1.setAttr11("1");

        System.out.println(request.getParameter("attr5"));
        System.out.println(request.getParameter("attr6"));

        int iCount = guest1Service.newGuest(guest1);
        Map jsonMap = new HashMap();
        if(iCount > 0){
            jsonMap.put("isSucc", "true");
        }else{
            jsonMap.put("isSucc", "false");
        }
        String json = JSON.toJSONString(jsonMap);
        response.getWriter().print(json);
    }

    @RequestMapping("/getGuest1ByOpt")
    public void getGuestByOpt (HttpServletRequest request,
                               HttpServletResponse response) throws Exception{
        String data = request.getParameter("data");
        Map map = (Map)JSON.parse(data);
        System.out.println(map.toString());
        List<Map> temp = guest1Service.fandByOpt(map);
        Map jsonMap = new HashMap();
        jsonMap.put("data", temp);
        String json = JSON.toJSONString(jsonMap);

        response.getWriter().print(json);
    }
}
