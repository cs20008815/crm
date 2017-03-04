package org.clj.crmproj.service.impl;

import org.clj.crmproj.entity.SysGuestQt;
import org.clj.crmproj.mapper.BaseMapper;
import org.clj.crmproj.mapper.SysGuestQtMapper;
import org.clj.crmproj.service.GuestQtService;
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
public class GuestQtServiceImpl extends BaseServiceImpl implements GuestQtService {
    @Autowired
    private SysGuestQtMapper sysGuestQtMapper;

    @Override
    public BaseMapper getMapper(){
        return sysGuestQtMapper;
    }

    @Override
    public int removeByPrimaryKey(String id) {
        return sysGuestQtMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int add(SysGuestQt record) {
        return sysGuestQtMapper.insert(record);
    }

    @Override
    public int addSelective(SysGuestQt record) {
        return sysGuestQtMapper.insertSelective(record);
    }

    @Override
    public SysGuestQt queryByPrimaryKey(String id) {
        return sysGuestQtMapper.selectByPrimaryKey(id);
    }

    @Override
    public int editByPrimaryKeySelective(SysGuestQt record) {
        return sysGuestQtMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int editByPrimaryKey(SysGuestQt record) {
        return sysGuestQtMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Map> queryByOther(Map record) {
        return sysGuestQtMapper.selectByOther(record);
    }
}