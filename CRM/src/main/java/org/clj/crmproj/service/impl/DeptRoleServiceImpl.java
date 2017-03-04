package org.clj.crmproj.service.impl;

import org.clj.crmproj.entity.SysDeptRole;
import org.clj.crmproj.mapper.BaseMapper;
import org.clj.crmproj.mapper.SysDeptRoleMapper;
import org.clj.crmproj.service.DeptRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/2/27.
 */
@Service
@Transactional(value="transactionManager")
public class DeptRoleServiceImpl extends BaseServiceImpl implements DeptRoleService {
    @Autowired
    private SysDeptRoleMapper sysDeptRoleMapper;

    @Override
    public BaseMapper getMapper(){
        return sysDeptRoleMapper;
    }

    @Override
    public int removeByPrimaryKey(String id) {
        return sysDeptRoleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int add(SysDeptRole record) {
        return sysDeptRoleMapper.insert(record);
    }

    @Override
    public int addSelective(SysDeptRole record) {
        return sysDeptRoleMapper.insertSelective(record);
    }

    @Override
    public SysDeptRole queryByPrimaryKey(String id) {
        return sysDeptRoleMapper.selectByPrimaryKey(id);
    }

    @Override
    public int editByPrimaryKeySelective(SysDeptRole record) {
        return sysDeptRoleMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int editByPrimaryKey(SysDeptRole record) {
        return sysDeptRoleMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Map> queryByOther(Map record) {
        return sysDeptRoleMapper.selectByOther(record);
    }
}
