package org.clj.crmproj.controller;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.clj.crmproj.entity.SysGuest;
import org.clj.crmproj.entity.SysGuestLook;
import org.clj.crmproj.entity.SysGuestTmk;
import org.clj.crmproj.service.GuestLookService;
import org.clj.crmproj.service.GuestService;
import org.clj.crmproj.service.GuestTmkService;
import org.clj.crmproj.util.EhcacheUtil;
import org.clj.crmproj.util.Response;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.annotation.Resource;
import java.io.*;
import java.util.*;

/**
 * Created by Administrator on 2017/3/8.
 */
@Controller
@RequestMapping("api/guest")
public class GuestController {
    @Resource
    private GuestService service;

    @Resource
    private GuestLookService guestLookService;

    @Resource
    private GuestTmkService guestTmkService;

    @RequestMapping(value = "/query/{id}")
    @ResponseBody
    public Response query(@PathVariable(value = "id") String id) throws Exception{
        SysGuest sysGuest = service.queryByPrimaryKey(id);
        Map reqMap = new HashMap();
        reqMap.put("attr1", sysGuest.getSid());
        Map respMap = guestLookService.queryByOther(reqMap).get(0);
        respMap.put("sid",sysGuest.getSid());
        respMap.put("attr1",sysGuest.getAttr1());
        return new Response(respMap);
    }

    @RequestMapping(value = "/queryGuest")
    @ResponseBody
    public Response queryGuest(@RequestBody Map requestMap) throws Exception{
        return new Response(service.queryByOther(requestMap));
    }

    @RequestMapping(value = "/queryPageByMk")
    @ResponseBody
    public Response queryPageByMk(@RequestBody Map requestMap) throws Exception{
        Object o = EhcacheUtil.getInstance().get("user");
        if(null == o){
            return new Response("LOGIN_TIME_OUT","登陆超时");
        }
        Map user = (Map)o;
        Map resMap = new HashMap();
        requestMap.put("userid",user.get("uid").toString());
        resMap.put("pageCount", service.queryCountByMk(requestMap));
        resMap.put("pageData", service.queryPageByMk(requestMap));
        return new Response(resMap);
    }

    @RequestMapping(value = "/queryPage")
    @ResponseBody
    public Response queryPage(@RequestBody Map requestMap) throws Exception{
        Object o = EhcacheUtil.getInstance().get("user");
        if(null == o){
            return new Response("LOGIN_TIME_OUT","登陆超时");
        }
        Map user = (Map)o;
        Map resMap = new HashMap();
        requestMap.put("userid",user.get("uid").toString());
        resMap.put("pageCount", service.queryCount(requestMap));
        resMap.put("pageData", service.queryPage(requestMap));
        return new Response(resMap);
    }

    @RequestMapping(value = "/queryPageTMK")
    @ResponseBody
    public Response queryPageTMK(@RequestBody Map requestMap) throws Exception{
        Object o = EhcacheUtil.getInstance().get("user");
        if(null == o){
            return new Response("LOGIN_TIME_OUT","登陆超时");
        }
        Map user = (Map)o;
        Map resMap = new HashMap();
        requestMap.put("attr5",user.get("uid").toString());
        resMap.put("pageCount", service.queryCount(requestMap));
        resMap.put("pageData", service.queryPage(requestMap));
        return new Response(resMap);
    }

    @RequestMapping(value = "/addGuestForTMK")
    @ResponseBody
    public Response addGuestForTMK(@RequestBody Map requestMap) throws Exception{
        Object o = EhcacheUtil.getInstance().get("user");
        if(null == o){
            return new Response("LOGIN_TIME_OUT","登陆超时");
        }
        Map user = (Map)o;

        String [] guestIds= requestMap.get("data").toString().split(",");
        String userId = requestMap.get("user").toString();
        for(String str : guestIds){
            SysGuest sysGuest = new SysGuest();
            sysGuest.setSid(str);
            sysGuest.setAttr5(userId);
            sysGuest.setAttr18(user.get("uid").toString());
            sysGuest.setAttr19(new Date().toLocaleString());
            sysGuest.setAttr20("1");
            service.editByPrimaryKeySelective(sysGuest);
        }
        return new Response();
    }

    @RequestMapping(value = "/add")
    @ResponseBody
    public Response add(@RequestBody Map requestMap) throws Exception{
        Object o = EhcacheUtil.getInstance().get("user");
        if(null == o){
            return new Response("LOGIN_TIME_OUT","登陆超时");
        }
        Map user = (Map)o;

        SysGuest addTable = new SysGuest();
        addTable.setAttr1(requestMap.get("attr1").toString());
        addTable.setAttr2(requestMap.get("attr2").toString());
        String phone = requestMap.get("attr2").toString();
        String phone2 = (phone.substring(0,3) + "****" + phone.substring(7, phone.length()));
        addTable.setAttr3(phone2);
        addTable.setAttr16(user.get("uid").toString());
        addTable.setAttr17(new Date().toLocaleString());
        addTable.setAttr18(user.get("uid").toString());
        addTable.setAttr19(new Date().toLocaleString());
        addTable.setAttr20("1");

        SysGuestLook sysGuestLook = new SysGuestLook();
        BeanUtils.populate(sysGuestLook, requestMap);
        sysGuestLook.setAttr1(addTable.getSid());
        sysGuestLook.setAttr16(user.get("uid").toString());
        sysGuestLook.setAttr17(new Date().toLocaleString());
        sysGuestLook.setAttr18(user.get("uid").toString());
        sysGuestLook.setAttr19(new Date().toLocaleString());
        sysGuestLook.setAttr20("1");

        int i = service.addSelective(addTable);
        int ii = guestLookService.addSelective(sysGuestLook);
        if(i > 0){
            return new Response();
        }else{
            return new Response("添加失败");
        }
    }

    @RequestMapping(value = "/edit")
    @ResponseBody
    public Response edit(@RequestBody Map requestMap) throws Exception{
        Object o = EhcacheUtil.getInstance().get("user");
        if(null == o){
            return new Response("LOGIN_TIME_OUT","登陆超时");
        }
        Map user = (Map)o;

        SysGuest addTable = new SysGuest();
        addTable.setSid(requestMap.get("sid").toString());
        addTable.setAttr1(requestMap.get("attr1").toString());
        addTable.setAttr2(requestMap.get("attr2").toString());
        String phone = requestMap.get("attr2").toString();
        String phone2 = (phone.substring(0,3) + "****" + phone.substring(7, phone.length()));
        addTable.setAttr3(phone2);
        addTable.setAttr18(user.get("uid").toString());
        addTable.setAttr19(new Date().toLocaleString());
        addTable.setAttr20("1");

        SysGuestLook sysGuestLook = new SysGuestLook();
        Map reqMap = new HashMap();
        reqMap.put("attr1", addTable.getSid());
        Map respMap = guestLookService.queryByOther(reqMap).get(0);
        BeanUtils.populate(sysGuestLook, requestMap);
        sysGuestLook.setSid(respMap.get("sid").toString());
        sysGuestLook.setAttr1(addTable.getSid());
        sysGuestLook.setAttr18(user.get("uid").toString());
        sysGuestLook.setAttr19(new Date().toLocaleString());
        sysGuestLook.setAttr20("1");
        int i = service.editByPrimaryKeySelective(addTable);
        int ii = guestLookService.editByPrimaryKeySelective(sysGuestLook);
        if(i > 0){
            return new Response();
        }else{
            return new Response("修改失败");
        }
    }

    @RequestMapping(value = "/remove/{id}")
    @ResponseBody
    public Response remove(@PathVariable(value = "id") String id){
        Object o = EhcacheUtil.getInstance().get("user");
        if(null == o){
            return new Response("LOGIN_TIME_OUT","登陆超时");
        }
        Map user = (Map)o;

        SysGuest addTable = new SysGuest();
        addTable.setSid(id);
        addTable.setAttr18(user.get("uid").toString());
        addTable.setAttr19(new Date().toLocaleString());
        addTable.setAttr20("0");
        int i = service.editByPrimaryKeySelective(addTable);
        if(i > 0){
            return new Response();
        }else{
            return new Response("删除失败");
        }
    }

    @RequestMapping(value = "/importFile")
    @ResponseBody
    public Response importFile(@RequestParam(value = "uploadFile") MultipartFile uploadFile){
        Long uploadFileSize = uploadFile.getSize();
        int badData = 0;
        int goodData = 0;
        int countData = 0;
        if(uploadFileSize > 0){
            Object o = EhcacheUtil.getInstance().get("user");
            if(null == o){
                return new Response("LOGIN_TIME_OUT","登陆超时");
            }
            Map user = (Map)o;

            CommonsMultipartFile cf = (CommonsMultipartFile)uploadFile;
            //这个myfile是MultipartFile的
            DiskFileItem fi = (DiskFileItem) cf.getFileItem();
            File tempFile = fi.getStoreLocation();

            try {
                XSSFWorkbook xssfWorkbook = new XSSFWorkbook(tempFile);
                XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(0);
                int rowstart = xssfSheet.getFirstRowNum();
                int rowEnd = xssfSheet.getLastRowNum();
                List<SysGuest> list = new ArrayList<SysGuest>();
                List<SysGuestLook> list2 = new ArrayList<SysGuestLook>();
                for(int i=1;i<=rowEnd;i++){
                    countData++;
                    XSSFRow row = xssfSheet.getRow(i);
                    if(null == row) {
                        continue;
                    }
                    Map mapppp = new HashMap();
                    for(int k=1;k<=15;k++){
                        XSSFCell cell = row.getCell(k-1);
                        if(null==cell || "".equals(cell.toString())) {
                            mapppp.put("attr" + k, "空");
                        }else{
                            if(cell.getCellType() == HSSFCell.CELL_TYPE_FORMULA){
                                mapppp.put("attr" + k, cell.getStringCellValue());
                            }else{
                                mapppp.put("attr" + k, cell.toString());
                            }
                        }
                    }
                    SysGuest addTable = new SysGuest();
                    addTable.setAttr1(mapppp.get("attr1").toString());
                    addTable.setAttr2(mapppp.get("attr2").toString());
                    String phone = mapppp.get("attr2").toString();
                    String phone2 = (phone.substring(0,3) + "****" + phone.substring(7, phone.length()));
                    addTable.setAttr3(phone2);
                    addTable.setAttr16(user.get("uid").toString());
                    addTable.setAttr17(new Date().toLocaleString());
                    addTable.setAttr18(user.get("uid").toString());
                    addTable.setAttr19(new Date().toLocaleString());
                    addTable.setAttr20("1");

                    list.add(addTable);

                    SysGuestLook sysGuestLook = new SysGuestLook();
                    BeanUtils.populate(sysGuestLook, mapppp);
                    sysGuestLook.setAttr1(addTable.getSid());
                    sysGuestLook.setAttr16(user.get("uid").toString());
                    sysGuestLook.setAttr17(new Date().toLocaleString());
                    sysGuestLook.setAttr18(user.get("uid").toString());
                    sysGuestLook.setAttr19(new Date().toLocaleString());
                    sysGuestLook.setAttr20("1");

                    list2.add(sysGuestLook);
                }
                int s = service.addBatch(list);
                int ss = guestLookService.addBatch(list2);
                if(s > 0){
                    goodData = s;
                }else{
                    badData++;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            return new Response("S","共"+countData+"条数据，成功："+goodData+"条数据，失败："+badData+"条数据!");
        }else{
            return new Response();
        }
    }
}

//                    int cellStart = row.getFirstCellNum();
//                    int cellEnd = row.getLastCellNum();
//                    row.getCell(0).toString();
//                    for(int k=cellStart;k<=cellEnd;k++){
//                        XSSFCell cell = row.getCell(k);
//                        SysGuest sysGuest = new SysGuest();
//                        if(null==cell) {
//                            sysGuest.setAttr1("");
//                        }else{
//                            sysGuest.setAttr1("");
//                        }
//                        if(null==cell) {
//                            System.out.print("空   ");
//                            continue;
//                        }else{
//                            System.out.print(cell.toString()+ "   ");
//                        }


//                        switch (cell.getCellType()){
//
//                            case HSSFCell.CELL_TYPE_NUMERIC: // 数字
//                                System.out.print(cell.getNumericCellValue()
//                                        + "   ");
//                                break;
//                            case HSSFCell.CELL_TYPE_STRING: // 字符串
//                                System.out.print(cell.getStringCellValue()
//                                        + "   ");
//                                break;
//                            case HSSFCell.CELL_TYPE_BOOLEAN: // Boolean
//                                System.out.println(cell.getBooleanCellValue()
//                                        + "   ");
//                                break;
//                            case HSSFCell.CELL_TYPE_FORMULA: // 公式
//                                System.out.print(cell.getCellFormula() + "   ");
//                                break;
//                            case HSSFCell.CELL_TYPE_BLANK: // 空值
//                                System.out.println(" ");
//                                break;
//                            case HSSFCell.CELL_TYPE_ERROR: // 故障
//                                System.out.println(" ");
//                                break;
//                            default:
//                                System.out.print("未知类型   ");
//                                break;
//                        }
//                    }
//                    System.out.print("\n");