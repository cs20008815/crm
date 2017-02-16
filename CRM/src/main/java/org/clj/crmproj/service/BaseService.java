package org.clj.crmproj.service;

import org.clj.crmproj.entity.*;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/1/21.
 */
public interface BaseService {
    List<Bhq> fandBhqAll();

    List<Bhq> fandBhqByAttr1(Map map);

    int addBhqSelective(Bhq record);

    int editBhqSelective(Bhq record);

    int removeBhqByPrimaryKey(String sid);

    List<Dept> fandDeptAll();

    List<Dept> fandDeptByAttr1(Map map);

    int addDeptSelective(Dept record);

    int editDeptSelective(Dept record);

    int removeDeptByPrimaryKey(String sid);

    List<Role> fandRoleAll();

    List<Role> fandRoleByAttr1(Map map);

    int addRoleSelective(Role record);

    int editRoleSelective(Role record);

    int removeRoleByPrimaryKey(String sid);

    List<Perm> fandPermAll();

    List<Perm> fandPermByAttr1(Map map);

    int addPermSelective(Perm record);

    int editPermSelective(Perm record);

    int removePermByPrimaryKey(String sid);

    List<UserPerm> fandUserPermByAttr1(Map map);

    int addUserPermSelective(UserPerm record);

    int removeUserPermByPrimaryKey(UserPerm record);
}
