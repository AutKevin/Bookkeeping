package com.autumn.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

/**
 * Created by Administrator on 2018/6/6.
 */
public class Dispatcher extends org.springframework.web.servlet.DispatcherServlet {
    private static final long serialVersionUID = -7677752525845571027L;
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        String appName = config.getInitParameter("appName").trim();
        config.getServletContext().setAttribute("appName", appName);
    }
}
