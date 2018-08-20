package com.autumn.mapper;

import com.autumn.pojo.*;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface AccountMapper {

    /*获取账簿总数*/
    Integer getAllBookCount(@Param("userId") String userId,@Param("cateCode_search") String cateCode_search,@Param("money_search_start") String money_search_start,@Param("money_search_end") String money_search_end,@Param("time_search_start") String time_search_start,@Param("time_search_end") String time_search_end,@Param("remark_search") String remark_search);
    /*获取所有记账簿*/
    List<AccountExt> getAllBookByPage(@Param("userId") String userId, @Param("cateCode_search") String cateCode_search,@Param("money_search_start") String money_search_start,@Param("money_search_end") String money_search_end,@Param("time_search_start") String time_search_start,@Param("time_search_end") String time_search_end,@Param("remark_search") String remark_search,@Param("currPage")Integer pageNo,@Param("pageSize")Integer pageSize);
    /*添加账单*/
    int insert(Account record);
    /*删除账单*/
    int deleteByID(String id);
    /*更改*/
    int editBook(Account record);
    /*获取总金额*/
    int getCountMoney(String user_id);
    /*获取上月总金额*/
    int getPreCountMoney(String user_id);
    /*根据id获取数据*/
    AccountExt getBookById(String id);

    /*获取已经使用的种类,报表用*/
    List<String> getUsedCate(@Param("userId") String userId,@Param("time") String time);

    /*获取消费类型饼状图*/
    List<Pie> getCatePie(@Param("userId") String userId,@Param("time") String time);

    /*根据月份获取当月所有天数*/
    List<String> getAllDayByMonth(@Param("userId") String userId,@Param("time") String time);

    /*根据月份获取日金额*/
    List<String> getDayMoneyByMonth(@Param("userId") String userId,@Param("time") String time);

    /*根据年份获取所有月份*/
    List<String> getAllMonth_Year(@Param("userId") String userId,@Param("time") String time);

    /*根据年份获取所有月份金额*/
    List<String> getAllMonthMoney_Year(@Param("userId") String userId,@Param("time") String time);

    /*-------------------------------------------------全部成员消费报表-------------------------------------------*/

    /*获取已经使用的种类,报表用*/
    List<String> getUsedCate_group(@Param("userId") String userId,@Param("time") String time);

    /*获取消费类型饼状图*/
    List<Pie> getCatePie_group(@Param("userId") String userId,@Param("time") String time);

    /*根据月份获取当月所有天数*/
    List<String> getAllDayByMonth_group(@Param("userId") String userId,@Param("time") String time);

    /*根据月份获取日金额*/
    List<String> getDayMoneyByMonth_group(@Param("userId") String userId,@Param("time") String time);

    /*根据年份获取所有月份*/
    List<String> getAllMonth_Year_group(@Param("userId") String userId,@Param("time") String time,@Param("cateCode") String cateCode);

    /*根据年份获取所有月份金额*/
    List<String> getAllMonthMoney_Year_group(@Param("userId") String userId,@Param("time") String time,@Param("cateCode") String cateCode);

    int countByExample(AccountExample example);

    int deleteByExample(AccountExample example);

    int insertSelective(Account record);

    List<Account> selectByExample(AccountExample example);

    Account selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Account record, @Param("example") AccountExample example);

    int updateByExample(@Param("record") Account record, @Param("example") AccountExample example);

    int updateByPrimaryKeySelective(Account record);

    int updateByPrimaryKey(Account record);
}