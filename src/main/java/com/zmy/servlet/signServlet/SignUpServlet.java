package com.zmy.servlet.signServlet; /**
 * @Description
 * @version
 * @author Sam  Email:superdouble@yeah.net
 * @create 2022-03-18 17:38
 */

import com.zmy.dao.AccountDao;
import com.zmy.dao.Impl.accountDaoImpl;
import com.zmy.pojo.Account;
import com.zmy.pojo.Colunmn;
import com.zmy.service.AccountSaervice;
import com.zmy.service.AuthService;
import com.zmy.service.Impl.AccountSaerviceImpl;
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
    private final AccountSaervice accountSaervicea = new AccountSaerviceImpl();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("SignUpServlet");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (username.length() != 0 && password.length() != 0) {
//            Account account = signService.SignUp(username, password);
            Account account = accountSaervicea.getPrivateInfo(username);
            if (account != null) { //返回不为空登录成功
                if (account.getPassword().equals(password)) {
                    request.getSession().setAttribute("account", account);
                    // 查询所有账户
                    List<Account> allAccount = authService.getAllAccount();
                    request.getSession().setAttribute("allAccount", allAccount);
                    // 获取所有栏目
                    List<Colunmn> allColunmn = authService.getAllColunmn();
                    request.getSession().setAttribute("allColunmn", allColunmn);
                    // 获取头像名字
                    String fileName = accountSaervicea.getHeadPic(username);
                    request.getSession().setAttribute("fileName", fileName);
                    System.out.println("fileName = " + fileName);
                    response.sendRedirect("../../view/index.jsp");
                } else {
                    response.sendRedirect("../../view/Sign_up.jsp");
                }
            }
        } else {
            response.sendRedirect("../../view/Sign_up.jsp");
        }
    }
}
