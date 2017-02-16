package org.clj.crmproj.service.impl;

import org.clj.crmproj.entity.Khfl;
import org.clj.crmproj.mapper.KhflMapper;
import org.clj.crmproj.service.KhflService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/12/19.
 */
@Service("khflService")
public class KhflServiceImpl implements KhflService {
    @Resource
    private KhflMapper khflMapper;

    public List<Khfl> fandAll(){
        return khflMapper.selectAll();
    }

    public List<Khfl> fandByAttr1(Map map){
        return khflMapper.selectByAttr1(map);
    }

    public int addSelective(Khfl record){
        return khflMapper.insertSelective(record);
    }

    public int removeByPrimaryKey(String sid){
        return khflMapper.deleteByPrimaryKey(sid);
    }
}
