package com.autumn.pojo;

public class Account {
    private String id;

    private String cateCode;

    private String userId;

    private Integer money;

    private String remark;

    private String time;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getCateCode() {
        return cateCode;
    }

    public void setCateCode(String cateCode) {
        this.cateCode = cateCode == null ? null : cateCode.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    @Override
    public String toString() {
        return "Account{" +
                "id='" + id + '\'' +
                ", cateCode='" + cateCode + '\'' +
                ", userId='" + userId + '\'' +
                ", money=" + money +
                ", remark='" + remark + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}