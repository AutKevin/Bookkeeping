package com.autumn.service;

import com.autumn.mapper.SysModuleMapper;
import com.autumn.mapper.SysRoleMapper;
import com.autumn.mapper.SysRoleModuleMapper;
import com.autumn.mapper.SysUserRoleMapper;
import com.autumn.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * Created by Autumn on 2018/6/6.
 */
@Service
public class ModuleService {

    @Autowired
    public SysModuleMapper moduleMapper;
    /**
     * 获取所有菜单
     * @return
     */
    public List<SysModule> getAllModules(){
        List<SysModule> modules = moduleMapper.getAllModules();
        return modules;
    }

    /**
     * 根据角色code获取绑定的菜单
     * @param roleCode
     * @return
     */
    public List<SysModule> getModulesByRoleCode(String roleCode){
        List<SysModule> modules = moduleMapper.getModulesByRoleCode(roleCode);
        return modules;
    }

    /**
     * 根据id获取消息
     * @param moduleCode
     * @return
     */
    public SysModule getSingleData(String moduleCode) {
        SysModule result = moduleMapper.getSingleData(moduleCode);
        return result;
    }

    /**
     * 添加
     * @param sysModule
     * @return
     */
    public int addModule(SysModule sysModule) {
        sysModule.setModuleCode(UUID.randomUUID().toString());
        int result = moduleMapper.insertSelective(sysModule);
        return result;
    }

    /**
     * 删除多个菜单
     * @param ids
     * @return
     */
    public int delModules(String ids) {
        int result = moduleMapper.delModules(ids);
        return result;
    }
    public int upModule(SysModule module) {
        int result = moduleMapper.updateByPrimaryKeySelective(module);
        return result;
    }

    /**
     * 修改层级关系
     * @param selfId
     * @param parentId
     * @return
     */
    public int changeJoin(String selfId,String parentId) {
        SysModule module = new SysModule();
        module.setModuleCode(selfId);
        module.setParentCode(parentId);
        int result = moduleMapper.updateByPrimaryKeySelective(module);
        return result;
    }

    /**
     * 根据菜单名查询是否存在菜单
     * @param sysModule
     * @return true有 false无
     */
    public boolean getModuleNumByModuleName(SysModule sysModule) {
        SysModuleExample sysModuleExample = new SysModuleExample();
        SysModuleExample.Criteria criteria = sysModuleExample.createCriteria();
        criteria.andModulenameEqualTo(sysModule.getModuleName());

        List<SysModule> result = moduleMapper.selectByExample(sysModuleExample);
        if (result==null||result.size()==0){
            return false;
        }
        return true;
    }
}
