package com.autumn.service;

import com.autumn.mapper.SysRoleMapper;
import com.autumn.mapper.SysRoleModuleMapper;
import com.autumn.mapper.SysUserRoleMapper;
import com.autumn.mapper.UsersMapper;
import com.autumn.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * Created by Autumn on 2018/6/6.
 */
@Service
public class RoleService {

    @Autowired
    public SysRoleMapper roleMapper;

    @Autowired
    public SysUserRoleMapper userRoleMapper;

    @Autowired
    public SysRoleModuleMapper roleModuleMapper;
    /**
     * 获取所有角色
     * @return
     */
    public List<SysRole> getAllRole(){
        List<SysRole> result = roleMapper.selectByExample(null);
        return result;
    }

    /**
     * 分页显示所有角色
     * @param pageNo
     * @param pageSize
     * @return
     */
    public List<SysRole> getAllRoleByPage(Integer pageNo,Integer pageSize){
        List<SysRole> result = roleMapper.getAllRoleByPage(pageNo,pageSize);
        return result;
    }

    /**
     * 获取角色总数量
     * @return
     */
    public int getAllRolesCount(){
        int result = roleMapper.getAllRolesCount();
        return result;
    }

    /**
     * 根据用户id获取已经绑定的角色
     * @param id
     * @return
     */
    public List<SysRole> getBindedRole(String id){
        List<SysRole> result = roleMapper.getBindedRole(id);
        return result;
    }

    /**
     * 绑定角色
     * @param userCode
     * @param roleCodes
     * @return
     */
    public int bindRole(String userCode,String roleCodes){
        int delCount = deleteRolesByUid(userCode);  //原有的关系
        roleCodes = roleCodes.substring(0,roleCodes.length()-1);  //截掉末尾的逗号
        String[] roleCodeArr = roleCodes.split(",");
        int result = 0;

        for(int i =0;i<roleCodeArr.length;i++){
            SysUserRole sysUserRole = new SysUserRole();
            sysUserRole.setUrid(UUID.randomUUID().toString());
            sysUserRole.setUsercode(userCode);
            sysUserRole.setRolecode(roleCodeArr[i]);
            result = userRoleMapper.insert(sysUserRole);
            if (result==0){
                return 0;
            }
        }
        return result;
    }

    /**
     * 删除角色绑定的用户
     * @param uid
     * @return
     */
    public int deleteRolesByUid(String uid){
        SysUserRoleExample sysUserRoleExample = new SysUserRoleExample();
        SysUserRoleExample.Criteria criteria = sysUserRoleExample.createCriteria();
        criteria.andUsercodeEqualTo(uid);
        return userRoleMapper.deleteByExample(sysUserRoleExample);
    }

    /**
     * 根据角色绑定菜单
     * @param roleCode
     * @param mids
     * @return
     */
    public int bindModule(String roleCode,String mids){
        int delCount = deleteModulesByRoleId(roleCode);  //原有的关系
        mids = mids.substring(0,mids.length()-1);  //截掉末尾的逗号
        String[] moduleCodeArr = mids.split(",");
        int result = 0;

        for(int i =0;i<moduleCodeArr.length;i++){
            SysRoleModule roleModule = new SysRoleModule();
            roleModule.setRmid(UUID.randomUUID().toString());
            roleModule.setRolecode(roleCode);
            roleModule.setModulecode(moduleCodeArr[i]);
            result = roleModuleMapper.insert(roleModule);
            if (result==0){
                return 0;
            }
        }
        return result;
    }

    /**
     * 根据角色编码删除角色绑定的菜单关系
     * @param roleCode
     * @return
     */
    public int deleteModulesByRoleId(String roleCode){
        SysRoleModuleExample sysRoleModuleExample = new SysRoleModuleExample();
        SysRoleModuleExample.Criteria criteria = sysRoleModuleExample.createCriteria();
        criteria.andRolecodeEqualTo(roleCode);
        return roleModuleMapper.deleteByExample(sysRoleModuleExample);
    }
}
