package org.clj.crmproj.service.impl;

import org.clj.crmproj.entity.Source;
import org.clj.crmproj.mapper.SourceMapper;
import org.clj.crmproj.service.SourceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/11/28.
 */
@Service("sourceService")
public class SourceServiceImpl implements SourceService {
    @Resource
    private SourceMapper sourceMapper;

    @Override
    public List<Source> fandAll() {
        return sourceMapper.selectAll();
    }

    @Override
    public List<Source> fandByAttr1(Map map){ return sourceMapper.selectByAttr1(map); }

    @Override
    public int addSelective(Source record){
        return sourceMapper.insertSelective(record);
    }

    @Override
    public int removeByPrimaryKey(String sid){
        return sourceMapper.deleteByPrimaryKey(sid);
    }
}
