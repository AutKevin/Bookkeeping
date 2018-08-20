package com.autumn.controller;

import com.autumn.pojo.Account;
import com.autumn.pojo.Concategory;
import com.autumn.pojo.Users;
import com.autumn.service.CommonService;
import com.autumn.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/6/4.
 */

@Controller
@RequestMapping("/manager/CommonController")
public class CommonController {

    @Autowired
    public CommonService commonService;

    /**
     *  查询所有类别
     * */
    @RequestMapping(value = "/getAllCate")
    @ResponseBody
    public Map getAllCate(HttpServletRequest request, HttpServletResponse response){
        List<Concategory> result = commonService.getAllCate();    //获取category集合
        Map map = new HashMap();
        map.put("value",result);   //将list放入key为value的map中
        return map;  //返回格式{"value":[{"cate_code":"cate1","cate_name":"用餐","cate_level":1}]}
    }

}