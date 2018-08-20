package com.autumn.controller;

import com.autumn.pojo.Page;
import com.autumn.pojo.SysRole;
import com.autumn.pojo.Users;
import com.autumn.service.LoginService;
import com.autumn.service.RoleService;
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
@RequestMapping("/manager/roleController")
public class RoleController {

    @Autowired
    public RoleService roleService;

    /**
     * 获取所有角色
     * @return
     */
    @RequestMapping("getAllRole")
    @ResponseBody
    public List<SysRole> getAllRole(){
        List<SysRole> result = roleService.getAllRole();
        return result;
    }

    /**
     * 根据用户id获取已经绑定的角色
     * @param id
     * @return
     */
    @RequestMapping("getBindedRole")
    @ResponseBody
    public List<SysRole> getBindedRole(String id){
        List<SysRole> result = roleService.getBindedRole(id);
        return result;
    }

    /**
     * 绑定角色
     * @param userCode
     * @param roleCodes
     * @return
     */
    @RequestMapping("bindRole")
    @ResponseBody
    public Map bindRole(String userCode,String roleCodes){
        int r = roleService.bindRole(userCode,roleCodes);
        Map result = new HashMap();
        result.put("success",r>0?true:false);
        return result;
    }

    @RequestMapping("bindModule")
    @ResponseBody
    public Map bindModule(String roleCode,String mids){
        int r = roleService.bindModule(roleCode,mids);
        Map result = new HashMap();
        result.put("success",r>0?true:false);
        return result;
    }

    /**
     * 获取所有角色
     * @return
     */
    @RequestMapping("getAllRoleByPage")
    @ResponseBody
    public Page getAllRoleByPage(Integer pageNo,Integer pageSize){
        List<SysRole> result = roleService.getAllRoleByPage(pageNo,pageSize);
        int totals = roleService.getAllRolesCount();
        Page page = new Page();
        page.setTotal(totals+"");
        page.setRows(result);
        return page;
    }

}