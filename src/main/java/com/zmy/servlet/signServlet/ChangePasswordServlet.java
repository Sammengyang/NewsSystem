package com.zmy.servlet.signServlet; /**
 * @Description
 * @version
 * @author Sam  Email:superdouble@yeah.net
 * @create 2022-03-19 11:14
 */

import com.zmy.Utils.SendSmsUtil;
import com.zmy.service.Impl.SignServiceImpl;
import com.zmy.service.SignService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ChangePasswordServlet", value = "/ChangePasswordServlet")
public class ChangePasswordServlet extends HttpServlet {
    private final SignService signService = new SignServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("ChangePasswordServlet");
        String tel = request.getParameter("tel");
        String cpassword = request.getParameter("cpassword");
        String code = SendSmsUtil.SendSms(tel);
        request.getSession().setAttribute("tel",tel);
        request.getSession().setAttribute("code",code);
        PrintWriter out = response.getWriter();
        if (code!=null){
            out.write(tel);
            out.flush();
            out.close();
        }else{
            out.write("false");
            out.flush();
            out.close();
        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String tel1 = (String) request.getSession().getAttribute("tel");
        System.out.println(tel1);
        String code1 = (String) request.getSession().getAttribute("code");
        String tel = request.getParameter("tel");
        System.out.println(tel);
        String cpassword = request.getParameter("cpassword");
        String code = request.getParameter("code");
        System.out.println(code);
        if (tel.equals(tel1)&&code1.equals(code)){
            int i = signService.ChangePassword(tel, cpassword);
            response.sendRedirect("../../Sign/Sign_up.jsp");
        }else{
            response.sendRedirect("../../Sign/Sign_up.jsp");
        }
    }
}
