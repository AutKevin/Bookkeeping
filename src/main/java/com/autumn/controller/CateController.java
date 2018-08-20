package com.autumn.controller;

import com.autumn.pojo.*;
import com.autumn.service.CateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by Administrator on 2018/6/4.
 */

@Controller
@RequestMapping("/manager/cateController")
public class CateController {

    @Autowired
    public CateService cateService;

    /**
     * 查询
     * @param pageNo
     * @param pageSize
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/getAllCate")
    @ResponseBody
    public Page getAllCate(String pageNo,String pageSize,HttpServletRequest request,HttpServletResponse response){
        pageNo=pageNo==null?"1":pageNo;   //当前页码
        pageSize=pageSize==null?"5":pageSize;   //页面大小
        //获取当前页数据
        List<Concategory> list = cateService.getAllCateByPage(pageNo,pageSize);
        //获取总数据大小
        int totals = cateService.getAllCate();
        //封装返回结果
        Page page = new Page();
        page.setTotal(totals+"");
        page.setRows(list);
        return page;
    }

    /**
     * 增加
     * @param cate
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/addCate")
    @ResponseBody
    public String addCate(Concategory cate, HttpServletRequest request, HttpServletResponse response){
        boolean b = cateService.getCountByCode(cate);
        if (b){
            return "{\"success\":\"false2\",\"msg\":\"此编码已存在\"}";
        }
        int result = cateService.addCate(cate);
        return result>=1?"{\"success\":\"true\"}":"{\"success\":\"false\"}";
    }

    /**
     * 删除
     * @param cate
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/delCate")
    @ResponseBody
    public String delCate(Concategory cate, HttpServletRequest request, HttpServletResponse response){
        boolean b = cateService.getCountByCode(cate);
        if (b){
            return "{\"success\":\"false2\",\"msg\":\"此编码已被使用,不可删除\"}";
        }
        int result = cateService.delCate(cate);
        return result==1?"{\"success\":\"true\"}":"{\"success\":\"false1\"}";
    }

}