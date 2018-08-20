package com.autumn.service;

import com.autumn.mapper.ConcategoryMapper;
import com.autumn.mapper.UsersMapper;
import com.autumn.pojo.Concategory;
import com.autumn.pojo.ConcategoryExample;
import com.autumn.pojo.SysModule;
import com.autumn.pojo.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Autumn on 2018/6/6.
 */
@Service
public class UserService {

    @Autowired
    public UsersMapper usersMapper;

    /**
     * 修改密码
     * @param userId
     * @param psw_new
     * @return
     */
    public boolean upPsw(String userId,String psw_new){
        return usersMapper.upPsw(userId,psw_new)>0?true:false;
    }

    /**
     * 分页获取所有用户
     * @return
     */
    public List<Users> getAllUsersByPage(String pageNo,String pageSize){
        List<Users> users = usersMapper.getAllUsersByPage(Integer.parseInt(pageNo),Integer.parseInt(pageSize));
        return users;
    }

    public int getAllUsersCount(){
        int count = usersMapper.getAllUsersCount();
        return count;
    }

    /**
     * 根据uid获取所有组成员
     * @param userId
     * @return
     */
    public List<Users> getAllUserByUid(String userId){
        List<Users> users = usersMapper.getAllUserByUid(userId);
        return users;
    }

    /**
     * 根据userCode获取user
     * @param userCode
     * @return
     */
    public Users getUserByUserCode(String userCode){
        Users user=usersMapper.getUserByUserCode(userCode);
        return user;
    }

}
