package org.clj.crmproj.service.impl;

import org.clj.crmproj.entity.*;
import org.clj.crmproj.mapper.*;
import org.clj.crmproj.service.BaseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/1/21.
 */
@Service("baseService")
public class BaseServiceImpl implements BaseService {
    @Resource
    private BhqMapper bhqMapper;
    @Resource
    private DeptMapper deptMapper;
    @Resource
    private RoleMapper roleMapper;
    @Resource
    private PermMapper permMapper;
    @Resource
    private UserPermMapper userPermMapper;

    public List<Bhq> fandBhqAll(){
        return bhqMapper.selectAll();
    }

    public List<Bhq> fandBhqByAttr1(Map map){
        return bhqMapper.selectByAttr1(map);
    }

    public int addBhqSelective(Bhq record){
        return bhqMapper.insertSelective(record);
    }

    public int editBhqSelective(Bhq record){
        return bhqMapper.updateByPrimaryKeySelective(record);
    }

    public int removeBhqByPrimaryKey(String sid){
        return bhqMapper.deleteByPrimaryKey(sid);
    }

    //dept
    public List<Dept> fandDeptAll(){
        return deptMapper.selectAll();
    }

    public List<Dept> fandDeptByAttr1(Map map){
        return deptMapper.selectByAttr1(map);
    }

    public int addDeptSelective(Dept record){
        return deptMapper.insertSelective(record);
    }

    public int editDeptSelective(Dept record){
        return deptMapper.updateByPrimaryKeySelective(record);
    }

    public int removeDeptByPrimaryKey(String sid){
        return deptMapper.deleteByPrimaryKey(sid);
    }

    //Role
    public List<Role> fandRoleAll(){
        return roleMapper.selectAll();
    }

    public List<Role> fandRoleByAttr1(Map map){
        return roleMapper.selectByAttr1(map);
    }

    public int addRoleSelective(Role record){
        return roleMapper.insertSelective(record);
    }

    public int editRoleSelective(Role record){
        return roleMapper.updateByPrimaryKeySelective(record);
    }

    public int removeRoleByPrimaryKey(String sid){
        return roleMapper.deleteByPrimaryKey(sid);
    }

    //Perm
    public List<Perm> fandPermAll(){
        return permMapper.selectAll();
    }

    public List<Perm> fandPermByAttr1(Map map){
        return permMapper.selectByAttr1(map);
    }

    public int addPermSelective(Perm record){
        return permMapper.insertSelective(record);
    }

    public int editPermSelective(Perm record){
        return permMapper.updateByPrimaryKeySelective(record);
    }

    public int removePermByPrimaryKey(String sid){
        return permMapper.deleteByPrimaryKey(sid);
    }

    //Perm
    public List<UserPerm> fandUserPermByAttr1(Map map){
        return userPermMapper.selectByOther(map);
    }

    public int addUserPermSelective(UserPerm record){
        return userPermMapper.insertSelective(record);
    }

    public int removeUserPermByPrimaryKey(UserPerm record){
        return userPermMapper.updateByPrimaryKeySelective(record);
    }
}
