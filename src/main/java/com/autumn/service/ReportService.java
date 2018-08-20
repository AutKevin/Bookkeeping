package com.autumn.service;

import com.autumn.mapper.AccountMapper;
import com.autumn.mapper.UsersMapper;
import com.autumn.pojo.Pie;
import com.autumn.pojo.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 消费类型报表
 */
@Service
public class ReportService {

    @Autowired
    public AccountMapper accountMapper;
    /*饼状图,类型*/
    public List<String> getUsedCate(String userId,String time){
        List<String> result = accountMapper.getUsedCate(userId,time);
        return result;
    }

    /*饼状图,类型及金额*/
    public List<Pie> getCatePie(String userId,String time){
        return accountMapper.getCatePie(userId,time);
    }

    /*获取月份的天*/
    public List<String> getAllDayByMonth(String userId,String time){
        List<String> result = accountMapper.getAllDayByMonth(userId,time);
        return result;
    }

    /*获取月份的每一天的金额*/
    public List<String> getDayMoneyByMonth(String userId,String time){
        List<String> result = accountMapper.getDayMoneyByMonth(userId,time);
        return result;
    }

    /*根据年份获取月份*/
    public List<String> getAllMonth_Year(String userId,String time){
        List<String> result = accountMapper.getAllMonth_Year(userId,time);
        return result;
    }

    /*根据年份获取每月消费的总额*/
    public List<String> getAllMonthMoney_Year(String userId,String time){
        List<String> result = accountMapper.getAllMonthMoney_Year(userId,time);
        return result;
    }
    /*-------------------------------------------------全部成员消费报表-------------------------------------------*/
    /*饼状图,类型*/
    public List<String> getUsedCate_group(String userId,String time){
        List<String> result = accountMapper.getUsedCate_group(userId,time);
        return result;
    }

    /*饼状图,类型及金额*/
    public List<Pie> getCatePie_group(String userId,String time){
        return accountMapper.getCatePie_group(userId,time);
    }

    /*获取月份的天*/
    public List<String> getAllDayByMonth_group(String userId,String time){
        List<String> result = accountMapper.getAllDayByMonth_group(userId,time);
        return result;
    }

    /*获取月份的每一天的金额*/
    public List<String> getDayMoneyByMonth_group(String userId,String time){
        List<String> result = accountMapper.getDayMoneyByMonth_group(userId,time);
        return result;
    }

    /*根据年份获取月份*/
    public List<String> getAllMonth_Year_group(String userId,String time,String cateCode){
        List<String> result = accountMapper.getAllMonth_Year_group(userId,time,cateCode);
        return result;
    }

    /*根据年份获取每月消费的总额*/
    public List<String> getAllMonthMoney_Year_group(String userId,String time,String cateCode){
        List<String> result = accountMapper.getAllMonthMoney_Year_group(userId,time,cateCode);
        return result;
    }
}
