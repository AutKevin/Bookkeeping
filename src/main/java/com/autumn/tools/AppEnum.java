package com.autumn.tools;

/**
 * Created by Autumn on 2018/7/12.
 */
public enum AppEnum {
    ZFB("zfb","com.eg.android.AlipayGphone"),
    WX("wx","com.tencent.mm"),
    QQEnum("qq","com.tencent.mobileqq");

    //字段
    private String appCode;
    private String appFullPack;
    //构造函数
    AppEnum(String appCode,String appFullPack) {
        this.appCode = appCode;
        this.appFullPack = appFullPack;
    }
    //获取枚举中的数据
    public String getAppCode() {
        return appCode;
    }
    //获取枚举中的数据
    public String getAppFullPack() {
        return appFullPack;
    }
}
