package org.clj.crmproj.service;

import org.clj.crmproj.entity.Kcxq;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/12/19.
 */
public interface KcxqService {
    List<Kcxq> fandAll();

    List<Kcxq> fandByAttr1(Map map);

    int addSelective(Kcxq record);

    int removeByPrimaryKey(String sid);
}
