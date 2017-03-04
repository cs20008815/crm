package org.clj.crmproj.service.impl;

import org.clj.crmproj.entity.SysUser;
import org.clj.crmproj.mapper.BaseMapper;
import org.clj.crmproj.mapper.SysQueryMapper;
import org.clj.crmproj.mapper.SysUserMapper;
import org.clj.crmproj.service.UserService;
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
public class UserServiceImpl extends BaseServiceImpl implements UserService {
    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private SysQueryMapper sysQueryMapper;

    @Override
    public BaseMapper getMapper(){
        return sysUserMapper;
    }

    @Override
    public int removeByPrimaryKey(String id) {
        return sysUserMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int add(SysUser record) {
        return sysUserMapper.insert(record);
    }

    @Override
    public int addSelective(SysUser record) {
        return sysUserMapper.insertSelective(record);
    }

    @Override
    public SysUser queryByPrimaryKey(String id) {
        return sysUserMapper.selectByPrimaryKey(id);
    }

    @Override
    public int editByPrimaryKeySelective(SysUser record) {
        return sysUserMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int editByPrimaryKey(SysUser record) {
        return sysUserMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Map> queryByOther(Map record) {
        return sysUserMapper.selectByOther(record);
    }

    @Override
    public List<Map> queryUserByMap(){
        return sysQueryMapper.queryUserByMap();
    }

    @Override
    public Map queryUserById(Map map){
        return sysQueryMapper.queryUserById(map);
    }

}