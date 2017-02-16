package org.clj.crmproj.service.impl;

import org.clj.crmproj.entity.Guest;
import org.clj.crmproj.mapper.GuestMapper;
import org.clj.crmproj.service.GuestService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/11/30.
 */
@Service("guestService")
public class GuestServiceImpl implements GuestService {
    @Resource
    private GuestMapper guestMapper;

    public List<Map> fandByOpt(Map map) {
        return guestMapper.selectByOpt(map);
    }

    public Map fandCount(Map map) {
        return guestMapper.selectCount(map);
    }

    public int newGuest(Guest guest) {
        return guestMapper.insertSelective(guest);
    }

    public int editByPrimaryKeySelective(Guest guest){
        return guestMapper.updateByPrimaryKeySelective(guest);
    }
}
