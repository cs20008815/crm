package org.clj.crmproj.service.impl;

import org.clj.crmproj.entity.SysRole;
import org.clj.crmproj.mapper.BaseMapper;
import org.clj.crmproj.mapper.SysRoleMapper;
import org.clj.crmproj.service.RoleService;
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
public class RoleServiceImpl extends BaseServiceImpl implements RoleService {
    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Override
    public BaseMapper getMapper(){
        return sysRoleMapper;
    }

    @Override
    public int removeByPrimaryKey(String id) {
        return sysRoleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int add(SysRole record) {
        return sysRoleMapper.insert(record);
    }

    @Override
    public int addSelective(SysRole record) {
        return sysRoleMapper.insertSelective(record);
    }

    @Override
    public SysRole queryByPrimaryKey(String id) {
        return sysRoleMapper.selectByPrimaryKey(id);
    }

    @Override
    public int editByPrimaryKeySelective(SysRole record) {
        return sysRoleMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int editByPrimaryKey(SysRole record) {
        return sysRoleMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Map> queryByOther(Map record) {
        return sysRoleMapper.selectByOther(record);
    }
}