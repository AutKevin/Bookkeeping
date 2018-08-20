package com.autumn.controller;

import com.autumn.pojo.Page;
import com.autumn.pojo.Users;
import com.autumn.service.LoginService;
import com.autumn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
@RequestMapping("/manager/userController")
public class UserController {

    @Autowired
    public UserService userService;

    @Autowired
    public LoginService loginService;

    /**
     * 更改密码
     * @param userId
     * @param userCode
     * @param psw_old
     * @param psw_new
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/upPsw")
    @ResponseBody
    public Map upPsw(String userId,String userCode, String psw_old, String psw_new, HttpServletRequest request, HttpServletResponse response){
        Users users = new Users();
        users.setUsercode(userCode);
        users.setPwd(psw_old);
        Users result_user = loginService.login(users);
        Map map = new HashMap();
        if (result_user==null){
            map.put("success",false);
            map.put("oldPswWrong",true);
            return map;
        }
        boolean result = userService.upPsw(userId,psw_new);
        map.put("success",result);
        return map;
    }

    @RequestMapping("/upPswByAdmin")
    @ResponseBody
    public Map upPswByAdmin(String userId, String psw_new, HttpServletRequest request, HttpServletResponse response){
        Map map = new HashMap();
        boolean result = userService.upPsw(userId,psw_new);
        map.put("success",result);
        return map;
    }

    /**
     * 分页显示用户
     * @param pageNo
     * @param pageSize
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/getAllUser")
    @ResponseBody
    public Page getAllUsers(String pageNo,String pageSize,HttpServletRequest request, HttpServletResponse response){
        pageNo=pageNo==null?"1":pageNo;   //当前页码
        pageSize=pageSize==null?"5":pageSize;   //页面大小
        List<Users> result_users = userService.getAllUsersByPage(pageNo,pageSize);
        int usersCount = userService.getAllUsersCount();
        Page page = new Page();
        page.setTotal(usersCount+"");
        page.setRows(result_users);
        return page;
    }

    /**
     * 获取当前登录用户的所有组成员
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/getAllUserByUid")
    @ResponseBody
    public Map getAllUserByUid(HttpServletRequest request, HttpServletResponse response){
        String userId = ((Users)request.getSession().getAttribute("user")).getId().toString();
        List<Users> result_users = userService.getAllUserByUid(userId);
        Map map = new HashMap();
        map.put("value",result_users);   //将list放入key为value的map中
        return map;
    }

}