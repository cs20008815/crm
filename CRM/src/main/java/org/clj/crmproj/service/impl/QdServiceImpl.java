package org.clj.crmproj.service.impl;

import org.clj.crmproj.entity.Qd;
import org.clj.crmproj.mapper.QdMapper;
import org.clj.crmproj.service.QdService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/12/16.
 */
@Service("qdService")
public class QdServiceImpl implements QdService {
    @Resource
    private QdMapper qdMapper;

    public List<Qd> fandAll(){
        return qdMapper.selectAll();
    }

    public List<Qd> fandByAttr1(Map map){
        return qdMapper.selectByAttr1(map);
    }

    public int addSelective(Qd record){
        return qdMapper.insertSelective(record);
    }

    public int removeByPrimaryKey(String sid){
        return qdMapper.deleteByPrimaryKey(sid);
    }
}
