package org.clj.crmproj.service.impl;

import org.clj.crmproj.entity.SysDept;
import org.clj.crmproj.entity.SysDeptRole;
import org.clj.crmproj.mapper.BaseMapper;
import org.clj.crmproj.mapper.SysDeptMapper;
import org.clj.crmproj.mapper.SysDeptRoleMapper;
import org.clj.crmproj.service.DeptRoleService;
import org.clj.crmproj.service.DeptService;
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
public class DeptServiceImpl extends BaseServiceImpl implements DeptService {
    @Autowired
    private SysDeptMapper sysDeptMapper;

    @Override
    public BaseMapper getMapper(){
        return sysDeptMapper;
    }

    @Override
    public int removeByPrimaryKey(String id) {
        return sysDeptMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int add(SysDept record) {
        return sysDeptMapper.insert(record);
    }

    @Override
    public int addSelective(SysDept record) {
        return sysDeptMapper.insertSelective(record);
    }

    @Override
    public SysDept queryByPrimaryKey(String id) {
        return sysDeptMapper.selectByPrimaryKey(id);
    }

    @Override
    public int editByPrimaryKeySelective(SysDept record) {
        return sysDeptMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int editByPrimaryKey(SysDept record) {
        return sysDeptMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Map> queryByOther(Map record) {
        return sysDeptMapper.selectByOther(record);
    }

    @Override
    public List<Map> queryPage(Map record) {
        return sysDeptMapper.selectPage(record);
    }

    @Override
    public int queryCount(Map map){
        return sysDeptMapper.selectCount(map);
    }
}