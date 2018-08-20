package com.autumn.controller;

import com.autumn.pojo.*;
import com.autumn.redis.RedisTool;
import com.autumn.service.BookService;
import com.autumn.service.GetHttpInfoService_NoDubbo;
import com.autumn.service.UserService;
import com.autumn.serviceinf.GetHttpInfoServiceInf;
import com.autumn.tools.AppEnum;
import com.autumn.tools.DateTool;
import com.autumn.tools.FileTool;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Controller
@RequestMapping("/HttpInfoController")
public class GetHttpInfoController {

    @Autowired
    public BookService bookService;

    @Autowired
    public UserService userService;

    @Autowired
    RedisTool redisTool;

    /*@Autowired
    @Qualifier("getHttpInfoServicefromdubbo")
    public GetHttpInfoServiceInf getHttpInfoService;*/
    @Autowired
    public GetHttpInfoService_NoDubbo getHttpInfoService;

    @RequestMapping("/getAndroid")
    @ResponseBody
    public String getAndroid(HttpServletRequest request, HttpServletResponse response) {
        String data = request.getParameter("data");
        String rootPath = "/root/";
        String path= rootPath+"Android.log";  //总文件路径

        MsgPojo msgPojo = null;
        try {
             msgPojo = new ObjectMapper().readValue(data, MsgPojo.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //判断是什么消息,分别写入指定文件
        if(msgPojo.getAppName().equals(AppEnum.QQEnum.getAppFullPack())){
            String qqPath = rootPath+msgPojo.getUserName()+"_"+AppEnum.QQEnum.getAppCode()+".log";
            FileTool.writeToFile(qqPath,data);
        }else if(msgPojo.getAppName().equals(AppEnum.WX.getAppFullPack())){
            String wxPath = rootPath+msgPojo.getUserName()+"_"+AppEnum.WX.getAppCode()+".log";
            FileTool.writeToFile(wxPath,data);
        }else if(msgPojo.getAppName().equals(AppEnum.ZFB.getAppFullPack())){
            String zfbPath = rootPath+msgPojo.getUserName()+"_"+AppEnum.ZFB.getAppCode()+".log";
            FileTool.writeToFile(zfbPath,data);
            //判断是否为消费消息
            if(msgPojo.getTitle().equals("交易提醒")&&msgPojo.getContext().contains("你有一笔")&&msgPojo.getContext().contains("元的支出，点此查看详情。")){
                //读取金额
                Pattern  pattern= Pattern.compile("([1-9]\\d*\\.?\\d*)|(0\\.\\d*[1-9])");
                Matcher ma=pattern.matcher(msgPojo.getContext());
                while(ma.find()){
                    boolean result = addBook(Double.parseDouble(ma.group()),msgPojo.getUserName());
                    FileTool.writeToFile(zfbPath,"消费一笔"+ma.group()+"金额,记账"+result+"");
                }
            }
        }else{
            if(msgPojo.getUserName()!=null&&!msgPojo.getAppName().equals("")){
                path = rootPath+msgPojo.getUserName()+"_Android.log";
            }
        }

        //写入总文件
        FileTool.writeToFile(path,data);
        return "success";
    }

    /**
     * 添加金额,监控支付宝消息用
     * @param money
     * @return
     */
    public boolean addBook(double money,String userCode){
        Users user = userService.getUserByUserCode(userCode);
        Account account = new Account();
        account.setUserId(user.getId());
        account.setCateCode("weizhi");   //类型未知
        account.setTime(DateTool.getNowTime());   //默认今天
        account.setMoney((int) (money*100));
        int result = bookService.addBook(account);
        return result==1?true:false;
    }

    /**
     * 获取移动端gps
     * @param request
     * @param response
     * @return
     * @throws IOException
     */
    @RequestMapping("/getGPS")
    @ResponseBody
    public String getGPS(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String rootPath = "/root/";
        String path= rootPath+"Android.log";  //总文件路径
        String data = request.getParameter("data");
        //jackson转换为实体
        ObjectMapper mapper = new ObjectMapper();
        GPSPojo gpsPojo = mapper.readValue(data, GPSPojo.class);

        if (gpsPojo==null){
            FileTool.writeToFile(path,"记录位置失败,获取数据为空");
            return "false";
        }
        getHttpInfoService.getGPS(gpsPojo);
        String result = gpsPojo.toString();
        //写入总文件
        FileTool.writeToFile(path,"记录位置"+result);
        return "success";
    }

    /**
     * 展示定位
     * @param request
     * @param response
     * @return
     * @throws IOException
     */
    @RequestMapping("/getGPSForWeb")
    @ResponseBody
    public List<UserPosition> getGPSForWeb(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String userId = ((Users)request.getSession().getAttribute("user")).getId().toString();
        List<UserPosition> position= getHttpInfoService.getGPSForWeb(userId);
        return position;
    }

    @RequestMapping("/getRout")
    @ResponseBody
    public List<UserPosition> getRout(String userId,String time,HttpServletRequest request, HttpServletResponse response) throws IOException {
        if(userId==null||userId.isEmpty()){
            userId = ((Users)request.getSession().getAttribute("user")).getId().toString();
        }
        /*time = "2018";*/
        /*从redis中读取*/
        //key参数
        String redis_key = this.getClass().getName() +"."+ Thread.currentThread().getStackTrace()[1].getMethodName(); //包名.类名.方法名
        //field参数
        String paramString = "userId"+userId+"time:"+time;
        if(redisTool.getReids(redis_key,paramString)!="none"){  //读取
            List<UserPosition> redis_result = null;
            try {
                redis_result = new ObjectMapper().readValue(redisTool.getReids(redis_key,paramString),List.class);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            return redis_result;
        }
        List<UserPosition> position= getHttpInfoService.getRout(userId,time);
        /*存入redis中*/
        String jsonResult =  new ObjectMapper().writeValueAsString(position);
        redisTool.setReids(redis_key,paramString,jsonResult);
        return position;
    }
}