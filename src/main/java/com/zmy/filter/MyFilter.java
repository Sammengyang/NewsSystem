package com.zmy.filter;

import com.zmy.pojo.Account;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author Sam  Email:superdouble@yeah.net
 * @Description
 * @create 2022-03-23 17:55
 */
/*
    非法访问拦截
        拦截资源
            拦截所有的资源 "/*"
        1. 放行指定页面，不用登录就能访问的页面 （登录，注册）
        2. 静态资源，放行（image，js,css文件）
        3. 指定操作，放行（无需登录就能进行的操作，登录操作，注册操作）
        4. 登录状态，放行，判断session中的用户信息是否为空
 */
@WebFilter("/*")
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("过滤器初始化");
    }

    /**
     *  过滤方法
     * @param request
     * @param response
     * @param chain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        // 设置编码格式
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        // 先获取当前发起请求的URI地址

        String requestURI = req.getRequestURI();
        System.out.println("requestURI = " + requestURI);

        // 1. 登录和注册页面 放行
        // 如果URI中包含"/Sign_up"或者"/SignIn"证明是登录,注册请求,不需要进行拦截
        if (requestURI.contains("/Sign_up.jsp") || requestURI.contains("/SignIn.jsp") || requestURI.equals("/")) {
            // 放行
            chain.doFilter(request, response);
            return;
        }

           // 2. 静态资源放行，（image，js,css文件）
        if (requestURI.contains("/js") ||requestURI.contains("/css")||requestURI.contains("/images")){
            // 放行
            chain.doFilter(request, response);
            return;
        }

//        // 3. 指定操作，放行（无需登录就能进行的操作，登录操作，注册操作）
        if (requestURI.contains("/SignUpServlet") || requestURI.contains("/SignInServlet")){
            // 放行
            chain.doFilter(request, response);
            return;
        }
        //  4. 登录状态，放行，判断session中的用户信息是否为空
        Object account = req.getSession().getAttribute("account");
        if (account!=null){ // 登陆成功
            // 放行
            chain.doFilter(request, response);
            return;
        }else{
            resp.sendRedirect("../../Sign/Sign_up.jsp");
        }


        // 用户未登录时，拦截请求到登录页面
        resp.sendRedirect("../../Sign/Sign_up.jsp");

    }

    @Override
    public void destroy() {
        System.out.println("过滤器销毁");
    }
}
