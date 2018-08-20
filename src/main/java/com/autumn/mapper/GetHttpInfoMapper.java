package com.autumn.mapper;

import com.autumn.pojo.Account;
import com.autumn.pojo.AccountExt;
import com.autumn.pojo.UserPosition;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Autumn on 2018/7/16.插入信息
 */
public interface GetHttpInfoMapper {
    /*获取移动端数据*/
    int insertGPS(UserPosition position);


    /*获取最新位置-页面展示用*/
    List<UserPosition> getGPSForWeb(@Param("userId") String userId);

    /*获取一天内移动路径-页面展示用*/
    List<UserPosition> getRout(@Param("userId") String userId,@Param("time") String time);
}
