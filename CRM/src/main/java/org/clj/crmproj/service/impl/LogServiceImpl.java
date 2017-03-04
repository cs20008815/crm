package org.clj.crmproj.service.impl;

import org.clj.crmproj.entity.SysLog;
import org.clj.crmproj.mapper.BaseMapper;
import org.clj.crmproj.mapper.SysLogMapper;
import org.clj.crmproj.service.LogService;
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
public class LogServiceImpl extends BaseServiceImpl implements LogService {
    @Autowired
    private SysLogMapper sysLogMapper;

    @Override
    public BaseMapper getMapper(){
        return sysLogMapper;
    }

    @Override
    public int removeByPrimaryKey(String id) {
        return sysLogMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int add(SysLog record) {
        return sysLogMapper.insert(record);
    }

    @Override
    public int addSelective(SysLog record) {
        return sysLogMapper.insertSelective(record);
    }

    @Override
    public SysLog queryByPrimaryKey(String id) {
        return sysLogMapper.selectByPrimaryKey(id);
    }

    @Override
    public int editByPrimaryKeySelective(SysLog record) {
        return sysLogMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int editByPrimaryKey(SysLog record) {
        return sysLogMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Map> queryByOther(Map record) {
        return sysLogMapper.selectByOther(record);
    }
}