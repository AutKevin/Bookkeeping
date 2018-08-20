package com.autumn.service;

import com.autumn.mapper.GetHttpInfoMapper;
import com.autumn.pojo.Concategory;
import com.autumn.pojo.GPSPojo;
import com.autumn.pojo.UserPosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * Created by Autumn on 2018/7/16.
 */
@Service
public class GetHttpInfoService_NoDubbo {

    @Autowired
    GetHttpInfoMapper getHttpInfoMapper = null;

    /**
     * 添加位置
     * @param
     * @return
     */
    public int getGPS(GPSPojo gpsPojo) {
        UserPosition position = new UserPosition();
        position.setId(UUID.randomUUID().toString());
        position.setUserId(gpsPojo.getUserId());
        position.setUserFlag(gpsPojo.getUserName());
        position.setLontitude(gpsPojo.getLontitude());
        position.setLatitude(gpsPojo.getLatitude());
        position.setTime(gpsPojo.getTime());
        position.setAddr(gpsPojo.getAddr());
        position.setLocationdescribe(gpsPojo.getLocationdescribe());
        return getHttpInfoMapper.insertGPS(position);
    }

    /**
     * 获取GPS最新位置
     * @return
     */
    public List<UserPosition> getGPSForWeb(String uid) {
        List<UserPosition> position = getHttpInfoMapper.getGPSForWeb(uid);
        return position;
    }

    /**
     * 获取位置
     * @param uid
     * @param time
     * @return
     */
    public List<UserPosition> getRout(String uid,String time) {
        List<UserPosition> position = getHttpInfoMapper.getRout(uid,time);
        return position;
    }

}
