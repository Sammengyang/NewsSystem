package com.zmy.servlet.signServlet; /**
 * @Description
 * @version
 * @author Sam  Email:superdouble@yeah.net
 * @create 2022-03-18 17:38
 */

import com.zmy.pojo.Account;
import com.zmy.pojo.Colunmn;
import com.zmy.service.AuthService;
import com.zmy.service.Impl.AuthServiceImpl;
import com.zmy.service.Impl.SignServiceImpl;
import com.zmy.service.SignService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SignUpServlet", value = "/SignUpServlet")
public class SignUpServlet extends HttpServlet {
    private final SignService signService = new SignServiceImpl();
    private final AuthService authService = new AuthServiceImpl();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("SignUpServlet");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (username.length()!=0&&password.length()!=0){
            Account account = signService.SignUp(username, password);
            if (account!=null){ //返回不为空登录成功
                request.getSession().setAttribute("account",account);
                // 查询所有账户
                List<Account> allAccount = authService.getAllAccount();
                request.getSession().setAttribute("allAccount",allAccount);
                // 获取所有栏目
                List<Colunmn> allColunmn = authService.getAllColunmn();
                request.getSession().setAttribute("allColunmn",allColunmn);
                response.sendRedirect("../../view/index.jsp");
            }
        }else{
            response.sendRedirect("../../view/Sign_up.jsp");
        }
    }
}
