package org.clj.crmproj.service.impl;

import org.clj.crmproj.entity.School;
import org.clj.crmproj.mapper.SchoolMapper;
import org.clj.crmproj.service.SchoolService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/11/27.
 */
@Service("schoolService")
public class SchoolServiceImpl implements SchoolService {

    @Resource
    private SchoolMapper schoolMapper;

    @Override
    public List<School> fandAll() {
        return schoolMapper.selectAll();
    }

    public List<School> selectByAttr1(Map map){
        return schoolMapper.selectByAttr1(map);
    }

    public int addSelective(School record){
        return schoolMapper.insertSelective(record);
    }

    public int removeByPrimaryKey(String sid){
        return schoolMapper.deleteByPrimaryKey(sid);
    }
}
