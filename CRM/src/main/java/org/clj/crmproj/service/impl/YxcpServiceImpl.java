package org.clj.crmproj.service.impl;

import org.clj.crmproj.entity.Yxcp;
import org.clj.crmproj.mapper.YxcpMapper;
import org.clj.crmproj.service.YxcpService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/12/18.
 */
@Service("yxcpService")
public class YxcpServiceImpl implements YxcpService {
    @Resource
    private YxcpMapper yxcpMapper;

    @Override
    public List<Yxcp> fandAll() {
        return yxcpMapper.selectAll();
    }

    public List<Yxcp> fandByAttr1(Map map){
        return yxcpMapper.selectByAttr1(map);
    }

    public int addSelective(Yxcp record){
        return yxcpMapper.insertSelective(record);
    }

    public int removeByPrimaryKey(String sid){
        return yxcpMapper.deleteByPrimaryKey(sid);
    }
}
