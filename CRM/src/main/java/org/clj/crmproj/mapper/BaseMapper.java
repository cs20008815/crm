package org.clj.crmproj.mapper;

/**
 * Created by Administrator on 2017/2/27.
 */

import java.io.Serializable;
import java.util.List;

public interface BaseMapper<T,ID extends Serializable> {
    Integer  deleteByPrimaryKey(ID id);
    Integer  insert(T record);
    Integer  insertSelective(T record);
    T selectByPrimaryKey(ID id);
    Integer  updateByPrimaryKeySelective(T record);
    Integer  updateByPrimaryKey(T record);
    List<T> selectByOther(T record);
}