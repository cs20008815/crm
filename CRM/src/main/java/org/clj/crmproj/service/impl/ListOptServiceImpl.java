package org.clj.crmproj.service.impl;

import org.clj.crmproj.entity.SysListOpt;
import org.clj.crmproj.mapper.BaseMapper;
import org.clj.crmproj.mapper.SysListOptMapper;
import org.clj.crmproj.service.ListOptService;
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
public class ListOptServiceImpl extends BaseServiceImpl implements ListOptService {
    @Autowired
    private SysListOptMapper sysListOptMapper;

    @Override
    public BaseMapper getMapper(){
        return sysListOptMapper;
    }

    @Override
    public int removeByPrimaryKey(String id) {
        return sysListOptMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int add(SysListOpt record) {
        return sysListOptMapper.insert(record);
    }

    @Override
    public int addSelective(SysListOpt record) {
        return sysListOptMapper.insertSelective(record);
    }

    @Override
    public SysListOpt queryByPrimaryKey(String id) {
        return sysListOptMapper.selectByPrimaryKey(id);
    }

    @Override
    public int editByPrimaryKeySelective(SysListOpt record) {
        return sysListOptMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int editByPrimaryKey(SysListOpt record) {
        return sysListOptMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Map> queryByOther(Map record) {
        return sysListOptMapper.selectByOther(record);
    }
}