package com.zmy.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Sam  Email:superdouble@yeah.net
 * @Description
 * @create 2022-03-23 17:55
 */
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        // 设置编码格式
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        // 登录拦截
        // 先获取当前发起请求的URI地址
        String requestURI = req.getRequestURI();
        System.out.println("requestURI = " + requestURI);
        // 如果URI中包含"/Sign_up"或者"/SignIn"证明是登录,注册请求,不需要进行拦截
        if (requestURI.contains("/Sign_up") || requestURI.contains("/SignIn")) {
            // 放行
            chain.doFilter(request, response);
        } else  {
            Object account = req.getSession().getAttribute("account");
            if (account!=null){ // 登陆成功
                // 放行
                chain.doFilter(request, response);
            }else{
                resp.sendRedirect("../../Sign/Sign_up.jsp");
            }
        }
    }

    @Override
    public void destroy() {

    }
}
