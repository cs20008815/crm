package org.clj.crmproj.service.impl;

import org.clj.crmproj.entity.SysList;
import org.clj.crmproj.mapper.BaseMapper;
import org.clj.crmproj.mapper.SysListMapper;
import org.clj.crmproj.service.ListService;
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
public class ListServiceImpl extends BaseServiceImpl implements ListService {
    @Autowired
    private SysListMapper sysListMapper;

    @Override
    public BaseMapper getMapper(){
        return sysListMapper;
    }

    @Override
    public int removeByPrimaryKey(String id) {
        return sysListMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int add(SysList record) {
        return sysListMapper.insert(record);
    }

    @Override
    public int addSelective(SysList record) {
        return sysListMapper.insertSelective(record);
    }

    @Override
    public SysList queryByPrimaryKey(String id) {
        return sysListMapper.selectByPrimaryKey(id);
    }

    @Override
    public int editByPrimaryKeySelective(SysList record) {
        return sysListMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int editByPrimaryKey(SysList record) {
        return sysListMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Map> queryByOther(Map record) {
        return sysListMapper.selectByOther(record);
    }
}