package org.clj.crmproj.service.impl;

import org.clj.crmproj.entity.SysMenuLink;
import org.clj.crmproj.mapper.BaseMapper;
import org.clj.crmproj.mapper.SysMenuLinkMapper;
import org.clj.crmproj.service.MenuLinkService;
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
public class MenuLinkServiceImpl extends BaseServiceImpl implements MenuLinkService {
    @Autowired
    private SysMenuLinkMapper sysMenuLinkMapper;

    @Override
    public BaseMapper getMapper(){
        return sysMenuLinkMapper;
    }

    @Override
    public int removeByPrimaryKey(String id) {
        return sysMenuLinkMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int add(SysMenuLink record) {
        return sysMenuLinkMapper.insert(record);
    }

    @Override
    public int addSelective(SysMenuLink record) {
        return sysMenuLinkMapper.insertSelective(record);
    }

    @Override
    public SysMenuLink queryByPrimaryKey(String id) {
        return sysMenuLinkMapper.selectByPrimaryKey(id);
    }

    @Override
    public int editByPrimaryKeySelective(SysMenuLink record) {
        return sysMenuLinkMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int editByPrimaryKey(SysMenuLink record) {
        return sysMenuLinkMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Map> queryByOther(Map record) {
        return sysMenuLinkMapper.selectByOther(record);
    }
}