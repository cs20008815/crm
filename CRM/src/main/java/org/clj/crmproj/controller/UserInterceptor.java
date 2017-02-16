package org.clj.crmproj.controller;

import com.alibaba.fastjson.JSON;
import org.clj.crmproj.entity.User;
import org.clj.crmproj.service.LoginService;
import org.clj.crmproj.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/")
public class UserInterceptor {

    @Resource
    private LoginService loginService;

    @RequestMapping(value = "/login")
    public String login(HttpServletRequest request,
                        HttpServletResponse response) throws Exception{
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if("".equals(username) || "".equals(password)){
            request.setAttribute("loginErr", "请填写账号与密码！！！");
            return "login";
        }

        Map map = new HashMap();
        map.put("user", username);
        map.put("pwd", password);

        Map<String, String> user = loginService.login(map);
        if(null == user){
            request.setAttribute("loginErr", "账号或密码错误！！！");
            return "login";
        } else {
            request.getSession().setAttribute("user", user);
            return "index";
        }
    }

    @RequestMapping(value = "/userlogin")
    @ResponseBody
    public Response userlogin(HttpServletRequest request, @RequestBody Map requestMap) throws Exception{
        String username = requestMap.get("username")==null?"":requestMap.get("username").toString().trim();
        String password = requestMap.get("password")==null?"":requestMap.get("password").toString().trim();

        if("".equals(username) || "".equals(password)){
            return new Response("请填写账号与密码！！！");
        }else{
            Map map = new HashMap();
            map.put("user", username);
            map.put("pwd", password);

            Map<String, String> user = loginService.login(map);
            if(null == user){
                return new Response("账号或密码错误！！！");
            } else {
                //EhcacheUtil.getInstance().put("user",user);
                request.getSession().setAttribute("user", user);
                return new Response();
            }
        }
    }

    @RequestMapping(value = "/getMenu")
    public void getMenu(HttpServletRequest request,
                        HttpServletResponse response) throws Exception{

        //System.out.println(EhcacheUtil.getInstance().get("user").toString());
        Map<String, String> user = (Map) request.getSession().getAttribute("user");
        String menuid = request.getParameter("menuid");

        Map map = new HashMap();
        map.put("user", user.get("roleId"));
        map.put("menuid", menuid);

        List<Map> temp = loginService.getMenu(map);
        Map jsonMap = new HashMap();
        jsonMap.put("isSucc","true");
        jsonMap.put("data", temp);
        String json = JSON.toJSONString(jsonMap);

        response.getWriter().print(json);
    }

    @RequestMapping(value = "/preHandle")
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception
    {
        System.out.println("--------------------------------------preHandle---------------------------------------------");
        if (request.getSession().getAttribute("user") == null)//判断session里是否有用户信息
        {
            if (request.getHeader("x-requested-with") != null
                    && request.getHeader("x-requested-with")
                    .equalsIgnoreCase("XMLHttpRequest"))//如果是ajax请求响应头会有，x-requested-with；
            {
                response.setHeader("sessionstatus", "timeout");//在响应头设置session状态
                return false;
            }

        }
        return true;
    }

    /**
     * 默认首页控制器
     */
    @RequestMapping("/index")
    public ModelAndView index(HttpServletRequest request, HttpServletResponse response){
        return new ModelAndView("login");
    }

    /**
     * 默认首页控制器
     */
    @RequestMapping("/queryguest")
    public String queryguest(HttpServletRequest request, HttpServletResponse response){
        return "guest/queryguest";
    }

    @RequestMapping("/queryguest0")
    public String queryguest0(HttpServletRequest request, HttpServletResponse response){
        return "guest/queryguest0";
    }

    /**
     * 默认首页控制器
     */
    @RequestMapping("/addguest")
    public String addguest(HttpServletRequest request, HttpServletResponse response){
        return "guest/addguest";
    }

    /**
     * 默认首页控制器
     */
    @RequestMapping("/addguestdetail")
    public String addguestdetail(HttpServletRequest request, HttpServletResponse response){
        return "guest/addguestdetail";
    }

    /**
     * 默认首页控制器
     */
    @RequestMapping("/allotGuest")
    public String allotGuest(HttpServletRequest request, HttpServletResponse response){
        return "guest/allotguest";
    }


    /**
     * 默认首页控制器
     */
    @RequestMapping("/schoolSetting")
    public String schoolSetting(HttpServletRequest request, HttpServletResponse response){
        return "setting/school";
    }

    /**
     * 默认首页控制器
     */
    @RequestMapping("/deptSetting")
    public String deptSetting(HttpServletRequest request, HttpServletResponse response){
        return "setting/dept";
    }

    /**
     * 默认首页控制器
     */
    @RequestMapping("/roleSetting")
    public String roleSetting(HttpServletRequest request, HttpServletResponse response){
        return "setting/role";
    }

    /**
     * 默认首页控制器
     */
    @RequestMapping("/permSetting")
    public String permSetting(HttpServletRequest request, HttpServletResponse response){
        return "setting/perm";
    }

    /**
     * 默认首页控制器
     */
    @RequestMapping("/stateSetting")
    public String stateSetting(HttpServletRequest request, HttpServletResponse response){
        return "setting/state";
    }

    @RequestMapping("/qdSetting")
    public String qdSetting(HttpServletRequest request, HttpServletResponse response){
        return "setting/qudao";
    }

    @RequestMapping("/lySetting")
    public String lySetting(HttpServletRequest request, HttpServletResponse response){
        return "setting/laiyuan";
    }

    @RequestMapping("/tgdSetting")
    public String tgdSetting(HttpServletRequest request, HttpServletResponse response){
        return "setting/tuiguangdian";
    }

    @RequestMapping("/yxcpSetting")
    public String yxcpSetting(HttpServletRequest request, HttpServletResponse response){
        return "setting/yixiangchanpin";
    }

    @RequestMapping("/kcxqSetting")
    public String kcxqSetting(HttpServletRequest request, HttpServletResponse response){
        return "setting/kechengxuqiu";
    }

    @RequestMapping("/khflSetting")
    public String khflSetting(HttpServletRequest request, HttpServletResponse response){
        return "setting/kehufenlei";
    }

    @RequestMapping("/guestdetail")
    public String guestdetail(HttpServletRequest request, HttpServletResponse response){
        return "guest/guestdetail";
    }

    @RequestMapping("/guestdetail0")
    public String guestdetail0(HttpServletRequest request, HttpServletResponse response){
        return "guest/guestdetail0";
    }

    @RequestMapping("/guestdetail1")
    public String guestdetail1(HttpServletRequest request, HttpServletResponse response){
        return "guest/guestdetail1";
    }

    @RequestMapping("/myguset")
    public String myguset(HttpServletRequest request, HttpServletResponse response){
        return "guest/myguest";
    }

    @RequestMapping("/addguestfollow")
    public String addguestfollow(HttpServletRequest request, HttpServletResponse response){
        return "guest/addguestfollow";
    }

    @RequestMapping("/addguestfollow1")
    public String addguestfollow1(HttpServletRequest request, HttpServletResponse response){
        return "guest/addguestfollow1";
    }

    @RequestMapping("/bhqSetting")
    public String bhqSetting(HttpServletRequest request, HttpServletResponse response){
        return "setting/baohuqi";
    }

    @RequestMapping("/qxSetting")
    public String qxSetting(HttpServletRequest request, HttpServletResponse response){
        return "setting/quanxian";
    }

    @RequestMapping("/fenpei0")
    public String fenpei0(HttpServletRequest request, HttpServletResponse response){
        return "guest/fenpei0";
    }
}