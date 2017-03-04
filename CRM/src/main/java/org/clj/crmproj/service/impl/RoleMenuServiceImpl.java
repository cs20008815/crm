package org.clj.crmproj.service.impl;

import org.clj.crmproj.entity.SysRoleMenu;
import org.clj.crmproj.mapper.BaseMapper;
import org.clj.crmproj.mapper.SysRoleMenuMapper;
import org.clj.crmproj.service.RoleMenuService;
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
public class RoleMenuServiceImpl extends BaseServiceImpl implements RoleMenuService {
    @Autowired
    private SysRoleMenuMapper sysRoleMenuMapper;

    @Override
    public BaseMapper getMapper(){
        return sysRoleMenuMapper;
    }

    @Override
    public int removeByPrimaryKey(String id) {
        return sysRoleMenuMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int add(SysRoleMenu record) {
        return sysRoleMenuMapper.insert(record);
    }

    @Override
    public int addSelective(SysRoleMenu record) {
        return sysRoleMenuMapper.insertSelective(record);
    }

    @Override
    public SysRoleMenu queryByPrimaryKey(String id) {
        return sysRoleMenuMapper.selectByPrimaryKey(id);
    }

    @Override
    public int editByPrimaryKeySelective(SysRoleMenu record) {
        return sysRoleMenuMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int editByPrimaryKey(SysRoleMenu record) {
        return sysRoleMenuMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Map> queryByOther(Map record) {
        return sysRoleMenuMapper.selectByOther(record);
    }
}