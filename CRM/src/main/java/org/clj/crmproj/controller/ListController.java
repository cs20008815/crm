package org.clj.crmproj.controller;

import org.clj.crmproj.service.ListOptService;
import org.clj.crmproj.service.ListService;
import org.clj.crmproj.util.Response;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/3/8.
 */
@Controller
@RequestMapping("api/list")
public class ListController {
    @Resource
    private ListService service;

    @Resource
    private ListOptService optService;

    @RequestMapping(value = "/query/{id}")
    @ResponseBody
    public Response query(@PathVariable(value = "id") String id, @RequestBody Map requestMap) throws Exception{
        requestMap.put("attr2", id);
        return new Response(optService.queryByOther(requestMap));
    }
}
