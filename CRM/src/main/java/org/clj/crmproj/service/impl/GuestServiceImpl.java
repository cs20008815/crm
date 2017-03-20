package org.clj.crmproj.service.impl;

import org.clj.crmproj.entity.SysGuest;
import org.clj.crmproj.mapper.BaseMapper;
import org.clj.crmproj.mapper.SysGuestMapper;
import org.clj.crmproj.service.GuestService;
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
public class GuestServiceImpl extends BaseServiceImpl implements GuestService {
    @Autowired
    private SysGuestMapper sysGuestMapper;

    @Override
    public BaseMapper getMapper(){
        return sysGuestMapper;
    }

    @Override
    public int removeByPrimaryKey(String id) {
        return sysGuestMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int add(SysGuest record) {
        return sysGuestMapper.insert(record);
    }

    @Override
    public int addSelective(SysGuest record) {
        return sysGuestMapper.insertSelective(record);
    }

    @Override
    public SysGuest queryByPrimaryKey(String id) {
        return sysGuestMapper.selectByPrimaryKey(id);
    }

    @Override
    public int editByPrimaryKeySelective(SysGuest record) {
        return sysGuestMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int editByPrimaryKey(SysGuest record) {
        return sysGuestMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Map> queryByOther(Map record) {
        return sysGuestMapper.selectByOther(record);
    }

    public List<Map> queryPage(Map record) {
        return sysGuestMapper.selectPage(record);
    }

    public List<Map> queryPageByMk(Map record) {
        return sysGuestMapper.selectPageByMk(record);
    }

    @Override
     public int queryCount(Map map){
        return sysGuestMapper.selectCount(map);
    }

    @Override
    public int addBatch(List<SysGuest> record){
        return sysGuestMapper.insertBatch(record);
    }
}