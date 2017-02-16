package org.clj.crmproj.service;

import org.clj.crmproj.entity.School;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/11/27.
 */
public interface SchoolService {
    /**
     * 获取学校
     * @return User
     * @throws Exception
     */
    List<School> fandAll();

    List<School> selectByAttr1(Map map);

    int addSelective(School record);

    int removeByPrimaryKey(String sid);
}
