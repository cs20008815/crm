package org.clj.crmproj.service.impl;

import org.clj.crmproj.entity.SysUserSchool;
import org.clj.crmproj.mapper.BaseMapper;
import org.clj.crmproj.mapper.SysUserSchoolMapper;
import org.clj.crmproj.service.UserSchoolService;
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
public class UserSchoolServiceImpl extends BaseServiceImpl implements UserSchoolService {
    @Autowired
    private SysUserSchoolMapper sysUserSchoolMapper;

    @Override
    public BaseMapper getMapper(){
        return sysUserSchoolMapper;
    }

    @Override
    public int removeByPrimaryKey(String id) {
        return sysUserSchoolMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int add(SysUserSchool record) {
        return sysUserSchoolMapper.insert(record);
    }

    @Override
    public int addSelective(SysUserSchool record) {
        return sysUserSchoolMapper.insertSelective(record);
    }

    @Override
    public SysUserSchool queryByPrimaryKey(String id) {
        return sysUserSchoolMapper.selectByPrimaryKey(id);
    }

    @Override
    public int editByPrimaryKeySelective(SysUserSchool record) {
        return sysUserSchoolMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int editByPrimaryKey(SysUserSchool record) {
        return sysUserSchoolMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Map> queryByOther(Map record) {
        return sysUserSchoolMapper.selectByOther(record);
    }
}