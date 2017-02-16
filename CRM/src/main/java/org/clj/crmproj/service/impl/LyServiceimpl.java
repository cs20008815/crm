package org.clj.crmproj.service.impl;

import org.clj.crmproj.entity.Ly;
import org.clj.crmproj.mapper.LyMapper;
import org.clj.crmproj.service.LyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/12/16.
 */
@Service("LyService")
public class LyServiceimpl implements LyService {
    @Resource
    private LyMapper lyMapper;

    public List<Ly> fandAll(){
        return lyMapper.selectAll();
    }

    public List<Ly> fandByAttr1(Map map){
        return lyMapper.selectByAttr1(map);
    }

    public int addSelective(Ly record){
        return lyMapper.insertSelective(record);
    }

    public int removeByPrimaryKey(String sid){
        return lyMapper.deleteByPrimaryKey(sid);
    }
}
