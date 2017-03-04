package org.clj.crmproj.service.impl;

import org.clj.crmproj.entity.SysGuestTmk;
import org.clj.crmproj.mapper.BaseMapper;
import org.clj.crmproj.mapper.SysGuestTmkMapper;
import org.clj.crmproj.service.GuestTmkService;
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
public class GuestTmkServiceImpl extends BaseServiceImpl implements GuestTmkService {
    @Autowired
    private SysGuestTmkMapper sysGuestTmkMapper;

    @Override
    public BaseMapper getMapper(){
        return sysGuestTmkMapper;
    }

    @Override
    public int removeByPrimaryKey(String id) {
        return sysGuestTmkMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int add(SysGuestTmk record) {
        return sysGuestTmkMapper.insert(record);
    }

    @Override
    public int addSelective(SysGuestTmk record) {
        return sysGuestTmkMapper.insertSelective(record);
    }

    @Override
    public SysGuestTmk queryByPrimaryKey(String id) {
        return sysGuestTmkMapper.selectByPrimaryKey(id);
    }

    @Override
    public int editByPrimaryKeySelective(SysGuestTmk record) {
        return sysGuestTmkMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int editByPrimaryKey(SysGuestTmk record) {
        return sysGuestTmkMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Map> queryByOther(Map record) {
        return sysGuestTmkMapper.selectByOther(record);
    }
}