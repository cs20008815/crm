package org.clj.crmproj.service.impl;

import org.clj.crmproj.entity.SysGuestMk;
import org.clj.crmproj.mapper.BaseMapper;
import org.clj.crmproj.mapper.SysGuestMkMapper;
import org.clj.crmproj.service.GuestMkService;
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
public class GuestMkServiceImpl extends BaseServiceImpl implements GuestMkService {
    @Autowired
    private SysGuestMkMapper sysGuestMkMapper;

    @Override
    public BaseMapper getMapper(){
        return sysGuestMkMapper;
    }

    @Override
    public int removeByPrimaryKey(String id) {
        return sysGuestMkMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int add(SysGuestMk record) {
        return sysGuestMkMapper.insert(record);
    }

    @Override
    public int addSelective(SysGuestMk record) {
        return sysGuestMkMapper.insertSelective(record);
    }

    @Override
    public SysGuestMk queryByPrimaryKey(String id) {
        return sysGuestMkMapper.selectByPrimaryKey(id);
    }

    @Override
    public int editByPrimaryKeySelective(SysGuestMk record) {
        return sysGuestMkMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int editByPrimaryKey(SysGuestMk record) {
        return sysGuestMkMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Map> queryByOther(Map record) {
        return sysGuestMkMapper.selectByOther(record);
    }
}