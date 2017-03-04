package org.clj.crmproj.service.impl;

import org.clj.crmproj.entity.SysSchoolDept;
import org.clj.crmproj.mapper.BaseMapper;
import org.clj.crmproj.mapper.SysSchoolDeptMapper;
import org.clj.crmproj.service.SchoolDeptService;
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
public class SchoolDeptServiceImpl extends BaseServiceImpl implements SchoolDeptService {
    @Autowired
    private SysSchoolDeptMapper sysSchoolDeptMapper;

    @Override
    public BaseMapper getMapper(){
        return sysSchoolDeptMapper;
    }

    @Override
    public int removeByPrimaryKey(String id) {
        return sysSchoolDeptMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int add(SysSchoolDept record) {
        return sysSchoolDeptMapper.insert(record);
    }

    @Override
    public int addSelective(SysSchoolDept record) {
        return sysSchoolDeptMapper.insertSelective(record);
    }

    @Override
    public SysSchoolDept queryByPrimaryKey(String id) {
        return sysSchoolDeptMapper.selectByPrimaryKey(id);
    }

    @Override
    public int editByPrimaryKeySelective(SysSchoolDept record) {
        return sysSchoolDeptMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int editByPrimaryKey(SysSchoolDept record) {
        return sysSchoolDeptMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Map> queryByOther(Map record) {
        return sysSchoolDeptMapper.selectByOther(record);
    }
}