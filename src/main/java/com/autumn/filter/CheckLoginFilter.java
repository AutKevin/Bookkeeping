package com.autumn.filter;

import com.autumn.pojo.Users;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 是否登录判断
 */
public class CheckLoginFilter implements Filter {

    private String USER ="";

    private String ROOTPATH;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.USER = filterConfig.getInitParameter("user").trim();
        this.ROOTPATH = filterConfig.getInitParameter("rootPath");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        Object userid = null;
        HttpServletResponse res=(HttpServletResponse)response;
        HttpServletRequest req=(HttpServletRequest)request;
        Users users = (Users)req.getSession().getAttribute(USER);
        if (users!=null){
            userid =users.getId();
        }

        System.out.println("req.getRequestURI():"+req.getRequestURI());

        if(isShakedown(3018,3,16))
        {
            System.out.println("系统试用期已到，请联系商务！");
            res.sendRedirect(ROOTPATH+"?rtnCode=200");
        }else if(req.getRequestURI().contains("/loginController/login")||req.getRequestURI().contains("/loginController/loginForAndroid")){   //当时登录请求时,继续往下执行
            filterChain.doFilter(req, res);
        }else if(userid==null||userid.toString().trim().isEmpty())  //跳到登录页
        {
            //System.out.println("CheckLoginFilter userid:"+userid);
            System.out.println("CheckLoginFilter userId is null");
            res.sendRedirect(ROOTPATH);
        }else{   //继续往下执行
            //System.out.println("CheckLoginFilter chain.doFilter");
            filterChain.doFilter(req, res);
        }
    }

    @Override
    public void destroy() {
        if(this.USER !=null&&this.USER.trim().isEmpty())
        {
            this.USER ="";
        }

        if(this.ROOTPATH!=null&&this.ROOTPATH.trim().isEmpty())
        {
            this.ROOTPATH="";
        }
    }

    //试用期判断
    public static boolean isShakedown(int year,int month,int day)
    {
        Date date = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();// 获取一个Claender实例
        cal.set(year, month-1, day);
        Date endDate;
        try {
            endDate = sf.parse(sf.format(cal.getTime()));
            if (date.getTime() > endDate.getTime()) {
                return true;
            }
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return true;
        }
        return false;
    }
}
