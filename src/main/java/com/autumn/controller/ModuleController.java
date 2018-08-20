package com.autumn.controller;

import com.autumn.mapper.UsersMapper;
import com.autumn.pojo.Page;
import com.autumn.pojo.SysModule;
import com.autumn.pojo.SysRole;
import com.autumn.service.LoginService;
import com.autumn.service.ModuleService;
import com.autumn.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/6/4.
 */

@Controller
@RequestMapping("/manager/moduleController")
public class ModuleController {

    @Autowired
    public ModuleService moduleService;


    /**
     * 获取所有菜单(已绑定打钩)
     * 分配权限用
     * @return
     */
    @RequestMapping("getAllModules")
    @ResponseBody
    public List<SysModule> getAllModules(String roleCode){
        List<SysModule> result = moduleService.getAllModules();
        List<SysModule> binded = moduleService.getModulesByRoleCode(roleCode);
        Iterator<SysModule> iterator = result.iterator();
        /*遍历所有菜单*/
        while (iterator.hasNext()){
            SysModule module= iterator.next();
            /*遍历所有已绑定的菜单*/
            Iterator<SysModule> iterator_binded = binded.iterator();
            while (iterator_binded.hasNext()){
                SysModule module_binded= iterator_binded.next();
                if (module.getModuleCode().equals(module_binded.getModuleCode())){
                    module.setChecked("true");
                }
            }

        }
        return result;
    }


    /**
     * 获取所有菜单
     * @return
     */
    @RequestMapping("getTreeList")
    @ResponseBody
    public List<SysModule> getTreeList() {
        List<SysModule> result = moduleService.getAllModules();
        return result;
    }

    /**
     * 根据id获取单条菜单信息
     * @param moduleCode
     * @return
     */
    @RequestMapping("getSingleData")
    @ResponseBody
    public Map getSingleData(String moduleCode) {
        SysModule result = moduleService.getSingleData(moduleCode);
        Map map = new HashMap();
        map.put("moduleData",result);
        return map;
    }

    @RequestMapping("addModule")
    @ResponseBody
    public Map addModule(SysModule module) {
        Map map = new HashMap();
        boolean b = moduleService.getModuleNumByModuleName(module);
        if (b){
            map.put("exist","existName");
            return map;
        }
        int r = moduleService.addModule(module);
        map.put("success",r>0?true:false);
        return map;
    }

    /**
     * 删除
     * @param ids
     * @return
     */
    @RequestMapping("delModule")
    @ResponseBody
    public Map delModule(String ids) {
        Map map = new HashMap();
        int r = moduleService.delModules(ids);
        map.put("success",r>0?true:false);
        return map;
    }

    /**
     * 修改
     * @param module
     * @return
     */
    @RequestMapping("upModule")
    @ResponseBody
    public Map upModule(SysModule module) {
        Map map = new HashMap();
        int r = moduleService.upModule(module);
        map.put("success",r>0?true:false);
        return map;
    }

    /**
     * 菜单层级关系
     * @param selfId
     * @param parentId
     * @return
     */
    @RequestMapping("changeJoin")
    @ResponseBody
    public Map changeJoin(String selfId,String parentId) {
        Map map = new HashMap();
        int r = moduleService.changeJoin(selfId,parentId);
        map.put("success",r>0?true:false);
        return map;
    }

}