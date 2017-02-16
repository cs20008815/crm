package org.clj.crmproj.service.impl;

import org.clj.crmproj.entity.Guest1;
import org.clj.crmproj.mapper.Guest1Mapper;
import org.clj.crmproj.service.Guest1Service;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/12/26.
 */
@Service("guest1Service")
public class Guest1ServiceImpl implements Guest1Service {

    @Resource
    private Guest1Mapper guest1Mapper;

    public List<Map> fandByOpt(Map map) {
        return guest1Mapper.selectByOpt(map);
    }

    public int newGuest(Guest1 guest) {
        return guest1Mapper.insertSelective(guest);
    }

    public int editByPrimaryKeySelective(Guest1 guest){
        return guest1Mapper.updateByPrimaryKeySelective(guest);
    }

}
