package com.autumn.mapper;

import com.autumn.pojo.SysModule;
import com.autumn.pojo.Users;
import com.autumn.pojo.UsersExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UsersMapper {

    /**
     * 根据用户名和密码查询user
     * @param users
     * @return
     */
    Users selectByUserCodeAndPwd(Users users);

    /**
     * 根据用户id获取菜单权限(包括所有一级菜单)
     * @param uid
     * @return
     */
    List<SysModule> getModuleByUid(String uid);


    /**
     * 更新密码
     * @param userId
     * @param psw_new
     * @return
     */
    int upPsw(@Param("userId") String userId, @Param("psw_new") String psw_new);

    /**
     * 分页获取所有用户
     * @return
     */
    List<Users> getAllUsersByPage(@Param("currPage")Integer pageNo,@Param("pageSize")Integer pageSize);

    /**
     * 获取用户总数-分页用
     * @return
     */
    int getAllUsersCount();

    /**
     * 根据uid获取所属组的所有成员
     * @param userId
     * @return
     */
    public List<Users> getAllUserByUid(String userId);


    /*根据userCode获取user*/
    Users getUserByUserCode(String userCode);

    int countByExample(UsersExample example);

    int deleteByExample(UsersExample example);

    int deleteByPrimaryKey(String id);

    int insert(Users record);

    int insertSelective(Users record);

    List<Users> selectByExample(UsersExample example);

    Users selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Users record, @Param("example") UsersExample example);

    int updateByExample(@Param("record") Users record, @Param("example") UsersExample example);

    int updateByPrimaryKeySelective(Users record);

    int updateByPrimaryKey(Users record);
}