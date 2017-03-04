package org.clj.crmproj.service.impl;

import org.clj.crmproj.entity.SysMenu;
import org.clj.crmproj.mapper.BaseMapper;
import org.clj.crmproj.mapper.SysLoginMapper;
import org.clj.crmproj.mapper.SysMenuMapper;
import org.clj.crmproj.mapper.SysQueryMapper;
import org.clj.crmproj.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/2/28.
 */
@Service
@Transactional(value="transactionManager")
public class MenuServiceImpl extends BaseServiceImpl implements MenuService {
    @Autowired
    private SysMenuMapper sysMenuMapper;

    @Autowired
    private SysLoginMapper sysLoginMapper;

    @Autowired
    private SysQueryMapper sysQueryMapper;

    @Override
    public BaseMapper getMapper(){
        return sysMenuMapper;
    }

    @Override
    public int removeByPrimaryKey(String id) {
        return sysMenuMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int add(SysMenu record) {
        return sysMenuMapper.insert(record);
    }

    @Override
    public int addSelective(SysMenu record) {
        return sysMenuMapper.insertSelective(record);
    }

    @Override
    public SysMenu queryByPrimaryKey(String id) {
        return sysMenuMapper.selectByPrimaryKey(id);
    }

    @Override
    public int editByPrimaryKeySelective(SysMenu record) {
        return sysMenuMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int editByPrimaryKey(SysMenu record) {
        return sysMenuMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Map> queryByOther(Map record) {
        return sysMenuMapper.selectByOther(record);
    }

    @Override
    public List<Map> userMenu(Map map){
        return sysLoginMapper.menuByMap(map);
    }

    @Override
    public List<Map> queryMenuBySid(Map map){
        return sysQueryMapper.queryMenuByRoleId(map);
    }
}