package org.clj.crmproj.service.impl;

import org.clj.crmproj.entity.SysSchool;
import org.clj.crmproj.mapper.BaseMapper;
import org.clj.crmproj.mapper.SysSchoolMapper;
import org.clj.crmproj.service.SchoolService;
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
public class SchoolServiceImpl extends BaseServiceImpl implements SchoolService {
    @Autowired
    private SysSchoolMapper sysSchoolMapper;

    @Override
    public BaseMapper getMapper(){
        return sysSchoolMapper;
    }

    @Override
    public int removeByPrimaryKey(String id) {
        return sysSchoolMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int add(SysSchool record) {
        return sysSchoolMapper.insert(record);
    }

    @Override
    public int addSelective(SysSchool record) {
        return sysSchoolMapper.insertSelective(record);
    }

    @Override
    public SysSchool queryByPrimaryKey(String id) {
        return sysSchoolMapper.selectByPrimaryKey(id);
    }

    @Override
    public int editByPrimaryKeySelective(SysSchool record) {
        return sysSchoolMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int editByPrimaryKey(SysSchool record) {
        return sysSchoolMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Map> queryByOther(Map record) {
        return sysSchoolMapper.selectByOther(record);
    }

    @Override
    public int queryCount(Map map){
        return sysSchoolMapper.selectCount(map);
    }
}