package org.clj.crmproj.mapper;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.clj.crmproj.util.ReflectionUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/2/28.
 */
public abstract class AbstractBaseMapper <T, ID extends Serializable> implements
        BaseMapper<T, ID> {
    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    private Class<?> entityMapperClass;

    protected BaseMapper<T, ID> getBaseMapper() {
        SqlSession session = sqlSessionFactory.openSession();
        entityMapperClass = ReflectionUtil.getMatcherMapper(getClass());
        @SuppressWarnings("unchecked")
        BaseMapper<T, ID> baseMapper = (BaseMapper<T, ID>) session
                .getMapper(entityMapperClass);
        return baseMapper;
    }

    public SqlSessionFactory getSqlSessionFactory() {
        return sqlSessionFactory;
    }

    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @Override
    public Integer deleteByPrimaryKey(ID id){
        return getBaseMapper().deleteByPrimaryKey(id);
    }

    @Override
    public Integer insert(T record){
        return getBaseMapper().insert(record);
    }

    @Override
    public Integer  insertSelective(T record){
        return getBaseMapper().insertSelective(record);
    }

    @Override
    public T selectByPrimaryKey(ID id){
        return getBaseMapper().selectByPrimaryKey(id);
    }

    @Override
    public Integer  updateByPrimaryKeySelective(T record){
        return getBaseMapper().updateByPrimaryKeySelective(record);
    }

    @Override
    public Integer  updateByPrimaryKey(T record){
        return getBaseMapper().updateByPrimaryKey(record);
    }

    @Override
    public List<T> selectByOther(T record){
        return getBaseMapper().selectByOther(record);
    }
}
