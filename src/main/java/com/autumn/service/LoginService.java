package com.autumn.service;

import com.autumn.mapper.AccountMapper;
import com.autumn.mapper.UsersMapper;
import com.autumn.pojo.Account;
import com.autumn.pojo.SysModule;
import com.autumn.pojo.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Autumn on 2018/6/6.
 */
@Service
public class LoginService {

    @Autowired
    public UsersMapper usersMapper;

    public Users login(Users users){
        Users usersResult = usersMapper.selectByUserCodeAndPwd(users);
        return usersResult;
    }


    /**
     * 根据用户id获取菜单权限(包括所有一级菜单)
     * @param uid
     * @return
     */
    public List<SysModule> getModuleByUid(String uid){
        List<SysModule> modules = usersMapper.getModuleByUid(uid);
        return modules;
    }


}
