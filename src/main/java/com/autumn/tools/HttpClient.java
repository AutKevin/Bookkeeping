package com.autumn.tools;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HttpClient {
    public static void main(String[] args) throws IOException {
        post("使用HttpClient发送数据");
    }

    public static void post(String data) throws IOException {
        //实例化httpclient
        CloseableHttpClient httpclient = HttpClients.createDefault();
        //创建post实例
        HttpPost httpPost = new HttpPost("http://www.52zt.online:8088/Bookkeeping/HttpInfoController/getAndroid");
        httpPost.setHeader("Content-type", "application/x-www-form-urlencoded");

        //添加参数
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("data", data));

        //将参数放入post实例
        httpPost.setEntity(new UrlEncodedFormEntity(params,"UTF-8"));

        //httpclient执行发送操作返回response
        CloseableHttpResponse response = httpclient.execute(httpPost);

        // 返回
        try {
            HttpEntity entity = response.getEntity();
            String result = EntityUtils.toString(entity);

            System.out.println("返回状态"+response.getStatusLine());
            System.out.println("返回内容:"+result);

            EntityUtils.consume(entity);
        } catch (IOException e1) {
            e1.printStackTrace();
        } finally {
            //关闭response
            response.close();
        }
    }
}
