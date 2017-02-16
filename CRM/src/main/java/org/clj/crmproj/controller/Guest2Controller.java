package org.clj.crmproj.controller;

import com.alibaba.fastjson.JSON;
import org.clj.crmproj.entity.Guest2;
import org.clj.crmproj.service.Guest2Service;
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
 * Created by Administrator on 2017/2/12.
 */
@Controller
@RequestMapping("/Guest2")
public class Guest2Controller {
    @Resource
    Guest2Service guest2Service;

    @RequestMapping("/newGuest2")
    public void newGuest2 (HttpServletRequest request,
                           HttpServletResponse response) throws Exception{
        Guest2 guest2 = new Guest2();

        Map<String, String> user = (Map) request.getSession().getAttribute("user");

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(new Date());
        guest2.setAttr1(user.get("uid"));
        guest2.setAttr2(user.get("schoolId"));
        guest2.setAttr3(dateString);
        guest2.setAttr4(request.getParameter("attr4"));
        guest2.setAttr5(request.getParameter("attr5"));
        guest2.setAttr6(request.getParameter("attr6"));
        guest2.setAttr7(request.getParameter("attr7"));
        guest2.setAttr11("1");

        int iCount = guest2Service.newGuest(guest2);
        Map jsonMap = new HashMap();
        if(iCount > 0){
            jsonMap.put("isSucc", "true");
        }else{
            jsonMap.put("isSucc", "false");
        }
        String json = JSON.toJSONString(jsonMap);
        response.getWriter().print(json);
    }

    @RequestMapping("/getGuest2ByOpt")
    public void getGuest2ByOpt (HttpServletRequest request,
                               HttpServletResponse response) throws Exception{
        String data = request.getParameter("data");
        Map map = (Map) JSON.parse(data);
        List<Guest2> temp = guest2Service.fandByOpt(map);
        Map jsonMap = new HashMap();
        jsonMap.put("data", temp);
        String json = JSON.toJSONString(jsonMap);

        response.getWriter().print(json);
    }
}
