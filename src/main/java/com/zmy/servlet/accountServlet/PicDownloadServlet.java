package com.zmy.servlet.accountServlet; /**
 * @Description
 * @version
 * @author Sam  Email:superdouble@yeah.net
 * @create 2022-03-23 14:53
 */

import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;
import com.zmy.pojo.Account;
import com.zmy.service.Impl.PictureServiceImpl;
import com.zmy.service.PictureService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "PicDownloadServlet", value = "/PicDownloadServlet")
public class PicDownloadServlet extends HttpServlet {

    private final PictureService pictureService = new PictureServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("PicDownloadServlet");
        // 获取登录人
        Account account = (Account) request.getSession().getAttribute("account");
        String userName = account.getUserName();
        // 获取头像地址
        String path = pictureService.DownloadPic(userName);
        SmartUpload upload = new SmartUpload();
        try {
            upload.initialize(getServletConfig(),request,response);
            if (path!=null){
                upload.downloadFile(path);
                response.sendRedirect("../../view/index.jsp");
            }else {
                response.sendRedirect("../../view/index.jsp");
            }
        } catch (SmartUploadException e) {
            e.printStackTrace();
        }
    }
}
