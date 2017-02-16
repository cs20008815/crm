package org.clj.crmproj.controller;

import com.alibaba.fastjson.JSON;
import org.clj.crmproj.entity.Guest;
import org.clj.crmproj.entity.User;
import org.clj.crmproj.service.GuestService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Administrator on 2016/11/30.
 */

@Controller
@RequestMapping("/Guest")
public class GuestController {
    @Resource
    GuestService guestService;

    @RequestMapping("/getGuestByOpt")
    public void getGuestByOpt (HttpServletRequest request,
                               HttpServletResponse response) throws Exception{
        String data = request.getParameter("data");
        Map map = (Map)JSON.parse(data);
        Map total = guestService.fandCount(map);
        List<Map> temp = guestService.fandByOpt(map);
        Map jsonMap = new HashMap();
        jsonMap.put("total",total);
        jsonMap.put("data", temp);
        String json = JSON.toJSONString(jsonMap);

        response.getWriter().print(json);
    }

    @RequestMapping("/getGuestByMy")
    public void getGuestByMy (HttpServletRequest request,
                               HttpServletResponse response) throws Exception{

        Map<String, String> user = (Map) request.getSession().getAttribute("user");
        if(null != user){
            String data = request.getParameter("data");
            Map map = (Map)JSON.parse(data);
            map.put("attr2",user.get("uid"));
            List<Map> temp = guestService.fandByOpt(map);
            Map jsonMap = new HashMap();
            jsonMap.put("data", temp);
            String json = JSON.toJSONString(jsonMap);

            response.getWriter().print(json);
        }
    }

    @RequestMapping("/newGuest")
    public void newGuest (HttpServletRequest request,
                               HttpServletResponse response) throws Exception{
        Guest guest = new Guest();
        System.out.println("newGuest");
        Map<String, String> user = (Map) request.getSession().getAttribute("user");
        //System.out.println(user.get());

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = formatter.format(new Date());

        System.out.println(dateString);

        guest.setAttr1(user.get("uid"));
        guest.setAttr5(new Date().getTime() + "");
        guest.setAttr6(request.getParameter("guestname"));
        guest.setAttr8(request.getParameter("bdate"));
        guest.setAttr9(request.getParameter("sex"));
        guest.setAttr10(request.getParameter("phone"));
        guest.setAttr11(request.getParameter("school"));
        guest.setAttr12(request.getParameter("address"));
        guest.setAttr13(request.getParameter("grade"));
        guest.setAttr14(request.getParameter("zhongxin"));
        guest.setAttr15(request.getParameter("qudao"));
        guest.setAttr16(request.getParameter("laiyuan"));
        guest.setAttr17(request.getParameter("tuiguangdian"));
        guest.setAttr18(request.getParameter("beizhu"));
        guest.setAttr19(request.getParameter("yixiangchanpin"));
        guest.setAttr20(request.getParameter("kechengxuqiu"));
        guest.setAttr21(request.getParameter("kehufenlei"));
        guest.setAttr22(dateString);
        guest.setAttr27("1");//状态
        int iCount = guestService.newGuest(guest);
        System.out.println(iCount);
        Map jsonMap = new HashMap();
        jsonMap.put("isSucc","true");
        String json = JSON.toJSONString(jsonMap);

        response.getWriter().print(json);
    }

    @RequestMapping("/editGuest")
    public void editGuest (HttpServletRequest request,
                          HttpServletResponse response) throws Exception{
        String attr27 = request.getParameter("attr27");
        String userId = request.getParameter("userId");
        String guests = request.getParameter("guestList");
        String[] guestList = guests.split(",");
        System.out.println("userId:"+userId);
        System.out.println("guestList:"+guestList);
        for(String temp : guestList){
            Guest guest = new Guest();
            guest.setUid(temp);
            guest.setAttr2(userId);
            guest.setAttr27(attr27);
            guestService.editByPrimaryKeySelective(guest);
        }

        Map jsonMap = new HashMap();
        jsonMap.put("isSucc", "true");
        String json = JSON.toJSONString(jsonMap);

        response.getWriter().print(json);
    }

    @RequestMapping("/editGuest1")
    public void editGuest1 (HttpServletRequest request,
                           HttpServletResponse response) throws Exception{
        String uid = request.getParameter("sid");
        String attr27 = request.getParameter("attr27");
        String userId = request.getParameter("userId");
        String attr23 = request.getParameter("attr23");


        Guest guest = new Guest();
        guest.setUid(uid);
        guest.setAttr4(userId);
        guest.setAttr27(attr27);
        guest.setAttr23(attr23);
        guestService.editByPrimaryKeySelective(guest);

        Map jsonMap = new HashMap();
        jsonMap.put("isSucc", "true");
        String json = JSON.toJSONString(jsonMap);

        response.getWriter().print(json);
    }

    public boolean notNull(String str){
        if(null != str && !"".equals(str)){
            return true;
        }
        return false;
    }

}
