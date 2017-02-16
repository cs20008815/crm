package org.clj.crmproj.service.impl;

import org.clj.crmproj.entity.Guest2;
import org.clj.crmproj.mapper.Guest2Mapper;
import org.clj.crmproj.service.Guest2Service;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/2/12.
 */
@Service("guest2Service")
public class Guest2ServiceImpl implements Guest2Service {
    @Resource
    private Guest2Mapper guest2Mapper;

    public List<Guest2> fandByOpt(Map map) {
        return guest2Mapper.selectByOther(map);
    }

    public int newGuest(Guest2 guest) {
        return guest2Mapper.insertSelective(guest);
    }

    public int editByPrimaryKeySelective(Guest2 guest){
        return guest2Mapper.updateByPrimaryKeySelective(guest);
    }
}
