package org.clj.crmproj.mapper;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/11/12.
 */
public interface LoginMapper {
    Map login(Map map);

    List<Map> getMenu(Map map);
}
