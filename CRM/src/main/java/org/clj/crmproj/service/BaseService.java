package org.clj.crmproj.service;

import org.clj.crmproj.entity.*;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/2/20.
 */
public interface BaseService<T,ID extends Serializable> {
    int removeByPrimaryKey(ID id);
    int add(T record);
    int addSelective(T record);
    T queryByPrimaryKey(ID id);
    int editByPrimaryKeySelective(T record);
    int editByPrimaryKey(T record);
    List<T> queryByOther(T record);
}
