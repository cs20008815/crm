package org.clj.crmproj.service.impl;

import org.clj.crmproj.entity.Kcxq;
import org.clj.crmproj.mapper.KcxqMapper;
import org.clj.crmproj.service.KcxqService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/12/19.
 */
@Service("kcxqService")
public class KcxqServiceImpl implements KcxqService {
    @Resource
    private KcxqMapper kcxqMapper;

    public List<Kcxq> fandAll(){
        return kcxqMapper.selectAll();
    }

    public List<Kcxq> fandByAttr1(Map map){
        return kcxqMapper.selectByAttr1(map);
    }

    public int addSelective(Kcxq record){
        return kcxqMapper.insertSelective(record);
    }

    public int removeByPrimaryKey(String sid){
        return kcxqMapper.deleteByPrimaryKey(sid);
    }
}
