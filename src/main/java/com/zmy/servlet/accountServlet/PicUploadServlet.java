package com.zmy.servlet.accountServlet; /**
 * @Description
 * @version
 * @author Sam  Email:superdouble@yeah.net
 * @create 2022-03-23 14:53
 */

import com.jspsmart.upload.*;
import com.zmy.pojo.Account;
import com.zmy.service.Impl.PictureServiceImpl;
import com.zmy.service.PictureService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.UUID;

@WebServlet(name = "PicUploadServlet", value = "/PicUploadServlet")
public class PicUploadServlet extends HttpServlet {

    private final PictureService pictureService = new PictureServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        Account account = (Account) req.getSession().getAttribute("account");
        String userName = account.getUserName();
        System.out.println("userName = " + userName);
        try {
            // 1.创建smartuploa对象
            SmartUpload smart = new SmartUpload();
            // 2. 初始化操作
            smart.initialize(getServletConfig(), req, response);
            // 设置文件类型 上传文件大小
//        smart.setAllowedFilesList("doc,jpg,png");
//        smart.setMaxFileSize(1024*1024*100*20);
            // 实现文件上传
            smart.upload();
            // 3. 获取request对象
            Request request = smart.getRequest();
            // 4. 将文件保存到服务器磁盘目录下
            Files files = smart.getFiles();
            // 5.  获取文件    获取上传文件个数
            int count = files.getCount();
            for (int i = 0; i < count; i++) {
                // 获取第一个文件
                File file = files.getFile(i);
                if (file != null && file.getSize() > 0){
                    // 6. 获取文件路径
                    String path = req.getServletContext().getRealPath("upload");
                    // 7. 获取文件类型
                    String ext = file.getFileExt();
                    // 对文件进行重命名
                    String newName = UUID.randomUUID().toString();
                    newName = newName +"."+ext; // 图片完整名字
                    // 保存到磁盘中
                    file.saveAs(path+"/"+newName);
                    System.out.println("newName = " + path+newName);
                    // 将名字存入session域中
                    req.getSession().setAttribute("fileName","/upload/"+newName);
                    // 将图片名字存入数据库中
                    pictureService.uploadPicture(userName,"/upload/"+newName);
                }
            }
        } catch (SmartUploadException e) {
            e.printStackTrace();
        }
        response.sendRedirect("../../view/index.jsp");
    }
}
