package org.clj.crmproj.service;

import org.clj.crmproj.entity.Khfl;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/12/19.
 */
public interface KhflService {
    List<Khfl> fandAll();

    List<Khfl> fandByAttr1(Map map);

    int addSelective(Khfl record);

    int removeByPrimaryKey(String sid);
}
