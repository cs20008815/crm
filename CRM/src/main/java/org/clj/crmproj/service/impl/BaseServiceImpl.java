package org.clj.crmproj.service.impl;

import org.clj.crmproj.entity.*;
import org.clj.crmproj.mapper.*;
import org.clj.crmproj.service.BaseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/2/20.
 */
@Service("baseService")
public abstract class BaseServiceImpl<T,ID extends Serializable> implements BaseService<T,ID> {

    public abstract BaseMapper getMapper();

    @Override
    public int removeByPrimaryKey(ID id){
        return getMapper().deleteByPrimaryKey(id);
    }

    @Override
    public int add(T record){
        return getMapper().insert(record);
    }

    @Override
    public int addSelective(T record){
        return getMapper().insertSelective(record);
    }

    @Override
    public T queryByPrimaryKey(ID id){
        return (T)getMapper().selectByPrimaryKey(id);
    }

    @Override
    public int editByPrimaryKeySelective(T record){
        return getMapper().updateByPrimaryKeySelective(record);
    }

    @Override
    public int editByPrimaryKey(T record){
        return getMapper().updateByPrimaryKey(record);
    }

    @Override
    public List<T> queryByOther(T record){
        return getMapper().selectByOther(record);
    }
}
