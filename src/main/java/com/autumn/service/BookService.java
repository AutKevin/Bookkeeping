package com.autumn.service;

import com.autumn.mapper.AccountMapper;
import com.autumn.mapper.UsersMapper;
import com.autumn.pojo.Account;
import com.autumn.pojo.AccountExt;
import com.autumn.pojo.Users;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by Autumn on 2018/6/6.
 */
@Service
public class BookService {

    @Autowired
    public AccountMapper accountMapper;

    /**
     * 获取账单总数
     * @return
     */
    public Integer getAllBookCount(String userId,String cateCode_search, String money_search_start, String money_search_end, String time_search_start, String time_search_end, String remark_search) {
        return accountMapper.getAllBookCount(userId,cateCode_search,money_search_start,money_search_end,time_search_start,time_search_end,remark_search);
    }

    /**
     * 获取所有账单分页显示
     * @return
     */
    public List<AccountExt> getAllBookByPage(String userId,String cateCode_search, String money_search_start, String money_search_end, String time_search_start, String time_search_end, String remark_search,String pageNo,String pageSize) {
        return accountMapper.getAllBookByPage(userId, cateCode_search,money_search_start,money_search_end,time_search_start,time_search_end,remark_search,Integer.parseInt(pageNo),Integer.parseInt(pageSize));
    }
    /**
     * 添加账单
     * @param account
     * @return
     */
    public int addBook(Account account) {
        String id = UUID.randomUUID().toString();
        account.setId(id);
        if (account!=null&&(account.getTime()==null||account.getTime().trim().isEmpty())){
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String time = simpleDateFormat.format(new Date());
            account.setTime(time);
        }
        return accountMapper.insert(account);
    }

    /**
     * 更改
     * @param account
     * @return
     */
    public int editBook(Account account) {
        if (account.getTime().length()<=10) {
            account.setTime(account.getTime() + " 01:11:11");
        }
        return accountMapper.editBook(account);
    }

    /**
     * 删除账单
     * @param account
     * @return
     */
    public int delBook(Account account) {
        return accountMapper.deleteByID(account.getId());
    }

    /**
     * 根据id获取数据
     * @param id
     * @return
     */
    public AccountExt getBookById(String id){
        return accountMapper.getBookById(id);
    }

    /**
     * 获取当月总金额
     */
    public int getCountMoney(String userid) {
        return accountMapper.getCountMoney(userid);
    }
    /**
     * 获取上月总金额
     */
    public int getPreCountMoney(String userid){
        return accountMapper.getPreCountMoney(userid);
    }

    public static void main(String[] args) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = simpleDateFormat.format(new Date());
        System.out.println(time);
    }
}
