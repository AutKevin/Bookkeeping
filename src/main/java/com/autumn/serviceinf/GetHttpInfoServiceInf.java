package com.autumn.serviceinf;

import com.autumn.mapper.GetHttpInfoMapper;
import com.autumn.pojo.GPSPojo;
import com.autumn.pojo.UserPosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Autumn on 2018/7/16.
 */
@Service
public interface GetHttpInfoServiceInf {

    @Autowired
    GetHttpInfoMapper getHttpInfoMapper = null;

    /**
     * 添加位置
     * @param
     * @return
     */
    public int getGPS(GPSPojo gpsPojo);

    /**
     * 获取GPS最新位置
     * @return
     */
    public List<UserPosition> getGPSForWeb(String uid);

    /**
     * 获取位置
     * @param uid
     * @param time
     * @return
     */
    public List<UserPosition> getRout(String uid, String time);

}
