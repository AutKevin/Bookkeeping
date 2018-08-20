package com.autumn.controller;

import com.autumn.pojo.Account;
import com.autumn.pojo.AccountExt;
import com.autumn.pojo.Page;
import com.autumn.pojo.Users;
import com.autumn.redis.RedisTool;
import com.autumn.service.BookService;
import com.autumn.service.LoginService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/6/4.
 */

@Controller
@RequestMapping("/manager/bookController")
public class BookController {

    @Autowired
    public BookService bookService;

    @Autowired
    RedisTool redisTool;
    /**
     * 查询
     * @param pageNo
     * @param pageSize
     * @param cateCode_search
     * @param money_search_start
     * @param money_search_end
     * @param time_search_start
     * @param time_search_end
     * @param remark_search
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/getAllBook")
    @ResponseBody
    public Page getAllBook(String pageNo,String pageSize,String cateCode_search,String money_search_start,String money_search_end,String time_search_start,String time_search_end,String remark_search,HttpServletRequest request,HttpServletResponse response) throws IOException {
       pageNo=pageNo==null?"1":pageNo;   //当前页码
        pageSize=pageSize==null?"5":pageSize;   //页面大小
        String userId = ((Users)request.getSession().getAttribute("user")).getId().toString();
        /*从redis中读取*/
        //key参数
        /*String redis_key = this.getClass().getName() +"."+ Thread.currentThread().getStackTrace()[1].getMethodName(); //包名.类名.方法名
        */
        //field参数
        /*String paramString = "userId"+userId+"pageNo:"+pageNo+"pageSize"+pageSize+"cateCode_search"+cateCode_search+"money_search_start"+money_search_start+"money_search_end"+money_search_end+"time_search_start"+time_search_start+"time_search_end"+time_search_end+"remark_search"+remark_search;
        if(redisTool.getReids(redis_key,paramString)!="none"){  //读取
            Page page = null;
            try {
                page = new ObjectMapper().readValue(redisTool.getReids(redis_key,paramString),Page.class);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            return page;
        }*/

        //
        //获取当前页数据
        List<AccountExt> list = bookService.getAllBookByPage(userId,cateCode_search,money_search_start,money_search_end,time_search_start,time_search_end,remark_search,pageNo,pageSize);
        //获取总数据大小
        int totals = bookService.getAllBookCount(userId,cateCode_search,money_search_start,money_search_end,time_search_start,time_search_end,remark_search);
        //封装返回结果
        Page page = new Page();
        page.setTotal(totals+"");
        page.setRows(list);

        /*存入redis中*/
        //String jsonResult =  new ObjectMapper().writeValueAsString(page);
        //redisTool.setReids(redis_key,paramString,jsonResult);

        return page;
    }

    /**
     * 增加
     * @param account
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/addBook")
    @ResponseBody
    public boolean addBook(Account account, HttpServletRequest request,HttpServletResponse response){
        //String cateCode,String money,String remark,String time
        String userId = ((Users)request.getSession().getAttribute("user")).getId().toString();
        account.setUserId(userId);
        int result = bookService.addBook(account);
        return result==1?true:false;
    }

    /**
     * 删除
     * @param account
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/delBook")
    @ResponseBody
    public boolean delBook(Account account,HttpServletRequest request,HttpServletResponse response){
        int result = bookService.delBook(account);
        return result==1?true:false;
    }

    /**
     * 更改
     * @param account
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/upBook")
    @ResponseBody
    public boolean upBook(Account account, HttpServletRequest request,HttpServletResponse response){
        String userId = ((Users)request.getSession().getAttribute("user")).getId().toString();
        account.setUserId(userId);
        int result = bookService.editBook(account);
        return result>=1?true:false;
    }

    /**
     * 根据id获取账单信息
     * @param id
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/getBookById/{id}")
    @ResponseBody
    public AccountExt getPreCountMoney(@PathVariable String id, HttpServletRequest request, HttpServletResponse response){
        AccountExt result = bookService.getBookById(id);
        return result;
    }

    /**
     * 获取当月消费总额
     * */
    @RequestMapping("/getCountMoney")
    @ResponseBody
    public int getCountMoney(HttpServletRequest request,HttpServletResponse response){
        String userId = ((Users)request.getSession().getAttribute("user")).getId().toString();
        int sum = bookService.getCountMoney(userId);
        return sum;
    }

    /**
     * 获取上月消费总额
     * */
    @RequestMapping("/getPreCountMoney")
    @ResponseBody
    public int getPreCountMoney(HttpServletRequest request,HttpServletResponse response){
        String userId = ((Users)request.getSession().getAttribute("user")).getId().toString();
        int sum = bookService.getPreCountMoney(userId);
        return sum;
    }
}