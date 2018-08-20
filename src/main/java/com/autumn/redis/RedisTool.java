package com.autumn.redis;

import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.io.UnsupportedEncodingException;

/**
 * Created by Autumn on 2018/7/25.
 */
public class RedisTool {

    @Autowired
    JedisClient jedisClient;

    public JedisClient getJedisClient() {
        return jedisClient;
    }

    public void setJedisClient(JedisClient jedisClient) {
        this.jedisClient = jedisClient;
    }

    public RedisTool() {
    }

    /**
     * 查询是否存在
     * @Pa
     * @param paramString 参数拼接成的字符串
     * @return 存在返回json字符串,不存在返回none
     * @throws UnsupportedEncodingException
     */
    public String getReids(String key,String paramString){
        //String key = this.getClass().getName() +"."+ Thread.currentThread().getStackTrace()[1].getMethodName(); //包名.类名.方法名
        String field = paramString;    //方法参数
        if (jedisClient.hget(key, field)!=null) {    //判断redis中是否存在
            String result = jedisClient.hget(key, field);
            System.out.println("从redis中取"+result);
            //向客户端输出
            return result;
        }
        return "none";
    }


    /**
     * 向redis中添加
     * @param paramString 参数拼接成的字符串
     * @param jsonObject 结果- 缓存到redis中的字符串
     * @throws UnsupportedEncodingException
     */
    public void setReids(String key,String paramString,String jsonObject) throws UnsupportedEncodingException {
        String field = paramString;
        //String key = this.getClass().getName() +"."+ Thread.currentThread().getStackTrace()[1].getMethodName(); //包名.类名.方法名
        jedisClient.hset(key, field, jsonObject);
        jedisClient.expire(key, 60);     //经常更新的数据可以设置过期时间,单位秒
    }
}
