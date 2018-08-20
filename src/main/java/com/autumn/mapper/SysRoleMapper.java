package com.autumn.mapper;

import com.autumn.pojo.SysRole;
import com.autumn.pojo.SysRoleExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysRoleMapper {
    /**
     * 根据用户id获取已绑定的角色
     * @param id
     * @return
     */
    List<SysRole> getBindedRole(String id);

    /**
     * 分页获取角色
     * @param pageNo
     * @param pageSize
     * @return
     */
    List<SysRole> getAllRoleByPage(@Param("currPage")Integer pageNo,@Param("pageSize")Integer pageSize);

    /**
     * 获取角色数量
     * @return
     */
    int getAllRolesCount();

    int countByExample(SysRoleExample example);

    int deleteByExample(SysRoleExample example);

    int deleteByPrimaryKey(String rolecode);

    int insert(SysRole record);

    int insertSelective(SysRole record);

    List<SysRole> selectByExample(SysRoleExample example);

    SysRole selectByPrimaryKey(String rolecode);

    int updateByExampleSelective(@Param("record") SysRole record, @Param("example") SysRoleExample example);

    int updateByExample(@Param("record") SysRole record, @Param("example") SysRoleExample example);

    int updateByPrimaryKeySelective(SysRole record);

    int updateByPrimaryKey(SysRole record);
}