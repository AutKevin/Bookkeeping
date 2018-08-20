package com.autumn.pojo;

/**
 * Created by Autumn on 2018/6/21.
 */
public class AccountExt extends Account{
    private String cate_name;
    private String user_name;



    public String getCate_name() {
        return cate_name;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public void setCate_name(String cate_name) {
        this.cate_name = cate_name;
    }
}
