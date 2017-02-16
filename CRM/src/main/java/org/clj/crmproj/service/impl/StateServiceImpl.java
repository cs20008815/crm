package org.clj.crmproj.service.impl;

import org.clj.crmproj.entity.State;
import org.clj.crmproj.mapper.StateMapper;
import org.clj.crmproj.service.StateService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/12/8.
 */
@Service("stateService")
public class StateServiceImpl implements StateService {
    @Resource
    private StateMapper stateMapper;

    @Override
    public List<State> fandAll(){
        return stateMapper.selectAll();
    }

    public List<State> fandByAttr1(Map map){
        return stateMapper.selectByAttr1(map);
    }

    public int addSelective(State record){
        return stateMapper.insertSelective(record);
    }

    public int removeByPrimaryKey(String sid){
        return stateMapper.deleteByPrimaryKey(sid);
    }
}
