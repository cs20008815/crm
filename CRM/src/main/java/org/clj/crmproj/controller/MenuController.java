package org.clj.crmproj.controller;

import org.clj.crmproj.entity.SysMenuLink;
import org.clj.crmproj.entity.SysRoleMenu;
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
 * Created by Administrator on 2017/2/19.
 */
@Controller
@RequestMapping("api/menu")
public class MenuController {
    @Resource
    private MenuService menuService;

    @Resource
    private MenuOptService menuOptService;

    @Resource
    private MenuLinkService menuLinkService;

    @Resource
    private RoleMenuService roleMenuService;

    @RequestMapping(value = "")
    @ResponseBody
    public Response getMenu() throws Exception{
        Object o = EhcacheUtil.getInstance().get("user");
        if(null == o){
            return new Response("LOGIN_TIME_OUT","登陆超时");
        }
        Map user = (Map)o;

        Map map = new HashMap();
        map.put("attr15", "0");
        map.put("attr1", user.get("roleId"));
        List<Map> menu = menuService.userMenu(map);
        for(Map temp : menu){
            map.put("attr15", temp.get("sid"));
            map.put("attr1", user.get("roleId"));
            List<Map> menu2 = menuService.userMenu(map);
            temp.put("menu", menu2);
        }
        return new Response(menu);
    }

    @RequestMapping(value = "/queryMenuList")
    @ResponseBody
    public Response queryMenuList() throws Exception{
        Map map = new HashMap();
        map.put("attr15", "0");
        List<Map> menus = menuService.queryByOther(map);
        for(Map menu : menus){
            menu.put("name", menu.get("attr1"));
            menu.put("id", menu.get("sid"));
            map.put("attr15", menu.get("sid"));
            List<Map> menuChildrens = menuService.queryByOther(map);
            for(Map menuChildren : menuChildrens){
                menuChildren.put("name", menuChildren.get("attr1"));
                menuChildren.put("id", menuChildren.get("sid"));
                map.clear();
                map.put("attr2",menuChildren.get("sid"));
                List<Map> menuOpts = menuOptService.queryByOther(map);
                for(Map menuOpt : menuOpts){
                    menuOpt.put("name", menuOpt.get("attr1"));
                    menuOpt.put("id", menuOpt.get("sid"));
                    menuOpt.put("value", menuOpt.get("attr1"));
                }
                menuChildren.put("children", menuOpts);
            }
            menu.put("children", menuChildrens);
        }
        return new Response(menus);
    }

    @RequestMapping(value = "/queryMenuByRoleId/{id}")
    @ResponseBody
    public Response queryMenuByRoleId(@PathVariable(value = "id") String id) throws Exception{
        Map map = new HashMap();
        map.put("attr1", id);
        map.put("attr15", "0");
        List superMenus = new ArrayList();
        List<Map> menus = menuService.queryMenuBySid(map);
        for(Map menu : menus){
            superMenus.add(menu);
            map.put("attr15", menu.get("sid"));
            List<Map> menuChildrens = menuService.queryMenuBySid(map);
            for(Map menuChildren : menuChildrens){
                superMenus.add(menuChildren);
                map.clear();
                map.put("attr1", menuChildren.get("sid"));
                map.put("attr3", id);
                List<Map> menuLints = menuLinkService.queryByOther(map);
                for(Map menuOpt : menuLints){
                    Map menuMap = new HashMap();
                    menuMap.put("sid", menuOpt.get("attr2"));
                    List<Map> menuOptChildrens = menuOptService.queryByOther(menuMap);
                    for(Map menuOptChildren : menuOptChildrens){
                        superMenus.add(menuOptChildren);
                    }
                }
            }
        }

        return new Response(superMenus);
    }

    @RequestMapping(value = "/editMenuByRoleId/{id}")
    @ResponseBody
    public Response editMenuByRoleId(@PathVariable(value = "id") String id,@RequestBody Map requestMap) throws Exception{
        Object o = EhcacheUtil.getInstance().get("user");
        if(null == o){
            return new Response("LOGIN_TIME_OUT","登陆超时");
        }
        Map user = (Map)o;

        Map map = new HashMap();
        map.put("attr1", id);
        List<Map> roleMenus = roleMenuService.queryByOther(map);
        for(Map roleMenu : roleMenus){
            SysRoleMenu sysRoleMenu = new SysRoleMenu();
            sysRoleMenu.setSid(roleMenu.get("sid").toString());
            sysRoleMenu.setAttr20("0");

            Map menuLinkMap = new HashMap();
            menuLinkMap.put("attr1", roleMenu.get("attr2").toString());
            menuLinkMap.put("attr3", id);
            List<Map> menuLinks = menuLinkService.queryByOther(menuLinkMap);
            for(Map menuLink : menuLinks){
                SysMenuLink sysMenuLink = new SysMenuLink();
                sysMenuLink.setSid(menuLink.get("sid").toString());
                sysMenuLink.setAttr20("0");
                menuLinkService.editByPrimaryKeySelective(sysMenuLink);
            }
            roleMenuService.editByPrimaryKeySelective(sysRoleMenu);
        }

        if(null != requestMap.get("menus")){
            List<Map> menus = (List<Map>) requestMap.get("menus");
            for(Map menu : menus){
                if(!menu.get("level").equals(2)){
                    SysRoleMenu sysRoleMenu = new SysRoleMenu();
                    sysRoleMenu.setAttr1(id);
                    sysRoleMenu.setAttr2(menu.get("sid").toString());
                    sysRoleMenu.setAttr16(user.get("uid").toString());
                    sysRoleMenu.setAttr17(new Date().toLocaleString());
                    sysRoleMenu.setAttr18(user.get("uid").toString());
                    sysRoleMenu.setAttr19(new Date().toLocaleString());
                    sysRoleMenu.setAttr20("1");
                    roleMenuService.addSelective(sysRoleMenu);
                }else{
                    SysMenuLink sysMenuLink = new SysMenuLink();
                    sysMenuLink.setAttr1(menu.get("attr2").toString());
                    sysMenuLink.setAttr2(menu.get("sid").toString());
                    sysMenuLink.setAttr3(id);
                    sysMenuLink.setAttr16(user.get("uid").toString());
                    sysMenuLink.setAttr17(new Date().toLocaleString());
                    sysMenuLink.setAttr18(user.get("uid").toString());
                    sysMenuLink.setAttr19(new Date().toLocaleString());
                    sysMenuLink.setAttr20("1");
                    menuLinkService.addSelective(sysMenuLink);
                }
            }
        }

        return new Response();
    }
}
