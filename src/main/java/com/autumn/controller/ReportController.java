package com.autumn.controller;

import com.autumn.pojo.Pie;
import com.autumn.pojo.Users;
import com.autumn.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by Administrator on 2018/6/4.
 */

@Controller
@RequestMapping("/manager/reportController")
public class ReportController {
    @Autowired
    public ReportService reportService;

    /**
     *  获取所用类型
     * */
    @RequestMapping(value = "/getUsedCate")
    @ResponseBody
    public List<String> getUsedCate(String time,HttpServletRequest request, HttpServletResponse response){
        String userId = ((Users)request.getSession().getAttribute("user")).getId().toString();
         return reportService.getUsedCate(userId,time);
    }

    /**
     * 获取饼状图数据
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/getCatePie")
    @ResponseBody
    public List<Pie> getCatePie(String time, HttpServletRequest request, HttpServletResponse response){
        String userId = ((Users)request.getSession().getAttribute("user")).getId().toString();
         return reportService.getCatePie(userId,time);
    }

    /*获取月份的天报表*/
    @RequestMapping(value = "/getAllDayByMonth")
    @ResponseBody
    public List<String> getAllDayByMonth(String time,HttpServletRequest request, HttpServletResponse response){
        String userId = ((Users)request.getSession().getAttribute("user")).getId().toString();
        return reportService.getAllDayByMonth(userId,time);
    }

    /*获取月份的每一天的金额*/
    @RequestMapping(value = "/getDayMoneyByMonth")
    @ResponseBody
    public List<String> getDayMoneyByMonth(String time,HttpServletRequest request, HttpServletResponse response){
        String userId = ((Users)request.getSession().getAttribute("user")).getId().toString();
        return reportService.getDayMoneyByMonth(userId,time);
    }

    /*根据年份获取月份*/
    @RequestMapping(value = "/getAllMonth_Year")
    @ResponseBody
    public List<String> getAllMonth_Year(String time,HttpServletRequest request, HttpServletResponse response){
        String userId = ((Users)request.getSession().getAttribute("user")).getId().toString();
        return reportService.getAllMonth_Year(userId,time);
    }

    /*根据年份获取每月消费的总额*/
    @RequestMapping(value = "/getAllMonthMoney_Year")
    @ResponseBody
    public List<String> getAllMonthMoney_Year(String time,HttpServletRequest request, HttpServletResponse response){
        String userId = ((Users)request.getSession().getAttribute("user")).getId().toString();
        return reportService.getAllMonthMoney_Year(userId,time);
    }


    /*-------------------------------------------------全部成员消费报表-------------------------------------------*/
    /**
     *  获取所用类型
     * */
    @RequestMapping(value = "/getUsedCate_group")
    @ResponseBody
    public List<String> getUsedCate_group(String time,HttpServletRequest request, HttpServletResponse response){
        String userId = ((Users)request.getSession().getAttribute("user")).getId().toString();
         return reportService.getUsedCate_group(userId,time);
    }

    /**
     * 获取饼状图数据
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/getCatePie_group")
    @ResponseBody
    public List<Pie> getCatePie_group(String time, HttpServletRequest request, HttpServletResponse response){
        String userId = ((Users)request.getSession().getAttribute("user")).getId().toString();
         return reportService.getCatePie_group(userId,time);
    }

    /*获取月份的天报表*/
    @RequestMapping(value = "/getAllDayByMonth_group")
    @ResponseBody
    public List<String> getAllDayByMonth_group(String time,HttpServletRequest request, HttpServletResponse response){
        String userId = ((Users)request.getSession().getAttribute("user")).getId().toString();
        return reportService.getAllDayByMonth_group(userId,time);
    }

    /*获取月份的每一天的金额*/
    @RequestMapping(value = "/getDayMoneyByMonth_group")
    @ResponseBody
    public List<String> getDayMoneyByMonth_group(String time,HttpServletRequest request, HttpServletResponse response){
        String userId = ((Users)request.getSession().getAttribute("user")).getId().toString();
        return reportService.getDayMoneyByMonth_group(userId,time);
    }

    /*根据年份获取月份*/
    @RequestMapping(value = "/getAllMonth_Year_group")
    @ResponseBody
    public List<String> getAllMonth_Year_group(String time,String cateCode,HttpServletRequest request, HttpServletResponse response){
        String userId = ((Users)request.getSession().getAttribute("user")).getId().toString();
        return reportService.getAllMonth_Year_group(userId,time,cateCode);
    }

    /*根据年份获取每月消费的总额*/
    @RequestMapping(value = "/getAllMonthMoney_Year_group")
    @ResponseBody
    public List<String> getAllMonthMoney_Year_group(String time,String cateCode,HttpServletRequest request, HttpServletResponse response){
        String userId = ((Users)request.getSession().getAttribute("user")).getId().toString();
        return reportService.getAllMonthMoney_Year_group(userId,time,cateCode);
    }
}