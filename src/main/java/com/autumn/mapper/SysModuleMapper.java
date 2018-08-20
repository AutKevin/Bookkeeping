package com.autumn.mapper;

import com.autumn.pojo.SysModule;
import com.autumn.pojo.SysModuleExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysModuleMapper {

    /**
     * 获取所有菜单
     * @return
     */
    List<SysModule> getAllModules();

    /**
     * 根据角色编码获取绑定的菜单
     * @param roleCode
     * @return
     */
    public List<SysModule> getModulesByRoleCode(String roleCode);

    /**
     * 同时删除多个菜单
     * @param ids
     * @return
     */
    int delModules(@Param("ids")String ids);

    /**
     * 获取单条菜单详细信息
     * @param moduleCode
     * @return
     */
    public SysModule getSingleData(String moduleCode);

    int countByExample(SysModuleExample example);

    int deleteByExample(SysModuleExample example);

    int deleteByPrimaryKey(String modulecode);

    int insert(SysModule record);

    int insertSelective(SysModule record);

    List<SysModule> selectByExample(SysModuleExample example);

    SysModule selectByPrimaryKey(String modulecode);

    int updateByExampleSelective(@Param("record") SysModule record, @Param("example") SysModuleExample example);

    int updateByExample(@Param("record") SysModule record, @Param("example") SysModuleExample example);

    int updateByPrimaryKeySelective(SysModule record);

    int updateByPrimaryKey(SysModule record);
}