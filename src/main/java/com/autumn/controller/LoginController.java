package com.autumn.controller;

import com.autumn.pojo.Account;
import com.autumn.pojo.SysModule;
import com.autumn.pojo.Users;
import com.autumn.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/6/4.
 */

@Controller
@RequestMapping("/manager/loginController")
public class LoginController {
    @Autowired
    public LoginService loginService;

    /**
     *  登录页
     * */
    @RequestMapping(value = "/login")
    public String login(Users users, HttpServletRequest request, HttpServletResponse response){
        Users userResult = loginService.login(users);
        if (userResult!=null){
            request.getSession().setAttribute("user",userResult);
            return "index";
        }
        return "login";
    }

    /**
     * 安卓端用户登录
     * @param users
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/loginForAndroid")
    @ResponseBody
    public Users loginForAndroid(Users users, HttpServletRequest request, HttpServletResponse response){
        Users userResult = loginService.login(users);
        if (userResult!=null){
            request.getSession().setAttribute("user",userResult);
            return userResult;
        }
        return userResult;
    }

    /**
     * 退出
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/loginOut")
    public String loginOut(HttpServletRequest request, HttpServletResponse response){
        request.getSession().setAttribute("user",null);
        return "login";
    }

    @RequestMapping("/loginpage/{id}")
    public String loginpage(@PathVariable String id){
        Account account = null;//loginService.login(id);
        if (account==null) {
            return "login";   //返回springmvc中配置的/WEB-INF/jsp/login.jsp
        }else {
            return "" +
                    "index";    //返回springmvc中配置的/WEB-INF/jsp/index.jsp
        }
    }

    /**
     * 根据用户id获取菜单权限
     * @return
     */
    @RequestMapping("/loadpermissions")
    @ResponseBody
    List<SysModule> getModuleByUid(String uid, HttpServletRequest request, HttpServletResponse response){
        //所有绑定的菜单,以及包括
        List<SysModule> modules = loginService.getModuleByUid(uid);
        //最终的List<SysModule>集合,存储一级菜单
        List<SysModule> result=new ArrayList<SysModule>();

        //建立模块层次结构
        for(int i=0;i<modules.size();i++){
            SysModule m=modules.get(i);  //遍历模块

            if(m.getParentCode()!=null&&m.getParentCode().equals("0")&&(m.getModulePath()==null||m.getModulePath().isEmpty())){   //判断是否为一级目录,一级目录父级code为0
                resetModules(m,modules);   //给一级目录添加子菜单
                if (m.getChildren().size()>0){   //当一级目录中存在子菜单时
                    result.add(m);   //将一级目录添加到list中
                }
            }else if(m.getParentCode()!=null&&m.getParentCode().equals("0")&&m.getModulePath()!=null&&!m.getModulePath().isEmpty()){
                //当一级为菜单,不是目录时,直接添加
                result.add(m);
            }
        }
        return result;
    }

    /**
     * 为m设置子节点
     * @param m  父节点
     * @param ms 在ms中找到m的子节点
     * void
     */
    private void resetModules(SysModule m,List<SysModule> ms){
        for(int i=0;i<ms.size();i++){   //循环modules
            SysModule c=ms.get(i);    //获取module
            if (c.getParentCode()!=null&&c.getParentCode()!="") {  //当module的父code不为空时,即是子菜单

                if(c.getParentCode().equals(m.getModuleCode())){   //如果module的的父code等于m的code,也就是遍历到的module是m的子菜单

                    if(c.getModulePath()==null||c.getModulePath().trim().equals("")){   //如果它的路径是空时,即这个module是个二级目录
                        resetModules(c,ms);    //继续找这个二级目录下的菜单.
                        if(c.getChildren().size()>0){   //如果module的子菜单大于0时
                            m.getChildren().add(c);    //把这个二级菜单c加入到m中
                        }
                    }else if(c.getModulePath()!=null&&!c.getModulePath().trim().equals("")){  //当路径不为空时,即是m的子菜单.
                        m.getChildren().add(c);   //直接加入到m
                    }
                }

            }
        }
    }
}