package com.zmy.servlet.signServlet; /**
 * @Description
 * @version
 * @author Sam  Email:superdouble@yeah.net
 * @create 2022-03-18 20:49
 */

import com.zmy.Utils.SendSmsUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "SendSmsServlet", value = "/SendSmsServlet")
public class SendSmsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
        System.out.println("SendSmsServlet");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String tel = request.getParameter("tel");
        System.out.println(tel);
        // 获取验证码
        String code = SendSmsUtil.SendSms(tel);
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        if (code!=null){
            out.write("success");
            out.flush();
            out.close();
            request.getSession().setAttribute("code",code);
            // 短信发送成功，转发到SignInServlet
            request.getRequestDispatcher("/SignInServlet").forward(request,response);
        }else {
            out.write("false");
            out.flush();
            out.close();
        }

    }
}
