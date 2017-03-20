package org.clj.crmproj.controller;

import org.apache.commons.beanutils.BeanUtils;
import org.clj.crmproj.entity.SysMenu;
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
    private MenuService service;

    @Resource
    private MenuOptService menuOptService;

    @Resource
    private MenuLinkService menuLinkService;

    @Resource
    private RoleMenuService roleMenuService;

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
        resMap.put("pageData", service.queryByOther(requestMap));
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

        SysMenu addTable = new SysMenu();
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

        SysMenu addTable = new SysMenu();
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

        SysMenu addTable = new SysMenu();
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
            System.out.println("menu:------------------->" + menu.toString());
            menu.put("name", menu.get("attr1"));
            menu.put("id", menu.get("sid"));
            Map childrenMap = new HashMap();
            childrenMap.put("attr15", menu.get("sid"));
            List<Map> menuChildrens = menuService.queryByOther(childrenMap);
            for(Map menuChildren : menuChildrens){
                System.out.println("menuChildren:------------------->" + menuChildren.toString());
                menuChildren.put("name", menuChildren.get("attr1"));
                menuChildren.put("id", menuChildren.get("sid"));
                Map childrenMap2 = new HashMap();
                childrenMap2.put("attr2",menuChildren.get("sid"));
                List<Map> menuOpts = menuOptService.queryByOther(childrenMap2);
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
            Map map1 = new HashMap();
            map1.put("attr1", id);
            map1.put("attr15", menu.get("sid"));
            List<Map> menuChildrens = menuService.queryMenuBySid(map1);
            for(Map menuChildren : menuChildrens){
                superMenus.add(menuChildren);
                Map map2 = new HashMap();
                map2.put("attr1", menuChildren.get("sid"));
                map2.put("attr3", id);
                List<Map> menuLints = menuLinkService.queryByOther(map2);
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

        if(null != requestMap.get("menus")){
            List<Map> menus = (List<Map>) requestMap.get("menus");
            for(Map menu : menus){
                if(!menu.get("level").equals(2)){
                    List<Map> rolemenus = roleMenuService.queryByOther(menu);
                    if(rolemenus.size() > 0){
                        SysRoleMenu sysRoleMenu = new SysRoleMenu();
                        BeanUtils.populate(sysRoleMenu, rolemenus.get(0));
                        BeanUtils.populate(sysRoleMenu, menu);
                        sysRoleMenu.setAttr18(user.get("uid").toString());
                        sysRoleMenu.setAttr19(new Date().toLocaleString());
                        roleMenuService.editByPrimaryKeySelective(sysRoleMenu);
                    }else{
                        SysRoleMenu sysRoleMenu = new SysRoleMenu();
                        BeanUtils.populate(sysRoleMenu, menu);
                        sysRoleMenu.setAttr16(user.get("uid").toString());
                        sysRoleMenu.setAttr17(new Date().toLocaleString());
                        sysRoleMenu.setAttr18(user.get("uid").toString());
                        sysRoleMenu.setAttr19(new Date().toLocaleString());
                        roleMenuService.addSelective(sysRoleMenu);
                    }
                } else{
                    System.out.println(menu.toString());
                    Map menuLink = new HashMap();
                    menuLink.put("attr1",menu.get("menu2"));
                    menuLink.put("attr2",menu.get("attr2"));
                    menuLink.put("attr3", menu.get("attr1"));
                    menuLink.put("attr20", menu.get("attr20"));
                    List<Map> menuLinks = menuLinkService.queryByOther(menuLink);
                    if(menuLinks.size() > 0){
                        SysMenuLink sysMenuLink = new SysMenuLink();
                        BeanUtils.populate(sysMenuLink, menuLinks.get(0));
                        BeanUtils.populate(sysMenuLink, menuLink);
                        sysMenuLink.setAttr18(user.get("uid").toString());
                        sysMenuLink.setAttr19(new Date().toLocaleString());
                        menuLinkService.editByPrimaryKeySelective(sysMenuLink);
                    }else{
                        SysMenuLink sysMenuLink = new SysMenuLink();
                        BeanUtils.populate(sysMenuLink, menuLink);
                        sysMenuLink.setAttr16(user.get("uid").toString());
                        sysMenuLink.setAttr17(new Date().toLocaleString());
                        sysMenuLink.setAttr18(user.get("uid").toString());
                        sysMenuLink.setAttr19(new Date().toLocaleString());
                        menuLinkService.addSelective(sysMenuLink);
                    }
                }
            }
        }

        return new Response();
    }
}
