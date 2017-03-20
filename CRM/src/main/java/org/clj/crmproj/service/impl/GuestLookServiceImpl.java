package org.clj.crmproj.service.impl;

import org.clj.crmproj.entity.SysGuest;
import org.clj.crmproj.entity.SysGuestLook;
import org.clj.crmproj.mapper.BaseMapper;
import org.clj.crmproj.mapper.SysGuestLookMapper;
import org.clj.crmproj.service.GuestLookService;
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
public class GuestLookServiceImpl extends BaseServiceImpl implements GuestLookService {
    @Autowired
    private SysGuestLookMapper mapper;

    @Override
    public BaseMapper getMapper(){
        return mapper;
    }

    @Override
    public int removeByPrimaryKey(String id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public int add(SysGuestLook record) {
        return mapper.insert(record);
    }

    @Override
    public int addSelective(SysGuestLook record) {
        return mapper.insertSelective(record);
    }

    @Override
    public SysGuestLook queryByPrimaryKey(String id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public int editByPrimaryKeySelective(SysGuestLook record) {
        return mapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int editByPrimaryKey(SysGuestLook record) {
        return mapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Map> queryByOther(Map record) {
        return mapper.selectByOther(record);
    }

    @Override
     public int queryCount(Map map){
        return mapper.selectCount(map);
    }

    @Override
    public int addBatch(List<SysGuestLook> record){
        return mapper.insertBatch(record);
    }
}