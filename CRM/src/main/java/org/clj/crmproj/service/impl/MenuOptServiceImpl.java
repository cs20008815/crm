package org.clj.crmproj.service.impl;

import org.clj.crmproj.entity.SysMenuOpt;
import org.clj.crmproj.mapper.BaseMapper;
import org.clj.crmproj.mapper.SysMenuOptMapper;
import org.clj.crmproj.service.MenuOptService;
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
public class MenuOptServiceImpl extends BaseServiceImpl implements MenuOptService {
    @Autowired
    private SysMenuOptMapper sysMenuOptMapper;

    @Override
    public BaseMapper getMapper(){
        return sysMenuOptMapper;
    }

    @Override
    public int removeByPrimaryKey(String id) {
        return sysMenuOptMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int add(SysMenuOpt record) {
        return sysMenuOptMapper.insert(record);
    }

    @Override
    public int addSelective(SysMenuOpt record) {
        return sysMenuOptMapper.insertSelective(record);
    }

    @Override
    public SysMenuOpt queryByPrimaryKey(String id) {
        return sysMenuOptMapper.selectByPrimaryKey(id);
    }

    @Override
    public int editByPrimaryKeySelective(SysMenuOpt record) {
        return sysMenuOptMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int editByPrimaryKey(SysMenuOpt record) {
        return sysMenuOptMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Map> queryByOther(Map record) {
        return sysMenuOptMapper.selectByOther(record);
    }
}