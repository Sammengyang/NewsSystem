<%--
  Created by IntelliJ IDEA.
  User: Sam
  Date: 2022/3/10
  Time: 19:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆</title>
    <meta charset="utf-8">
    <script type="text/javascript" src="../js/jquery-3.6.0.js"></script>
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"
          integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">

    <!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap-theme.min.css"
          integrity="sha384-6pzBo3FDv/PJ8r2KRkGHifhEocL+1X2rVCTTkUfGk7/0pbek5mMa1upzvWbrUbOZ" crossorigin="anonymous">

    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"
            integrity="sha384-aJ21OjlMXNL5UyIl/XNwTMqvzeRMZH2w8c5cRVpzpU8Y5bApTppSuUkhZXN0VxHd"
            crossorigin="anonymous"></script>
    <link rel="stylesheet" type="text/css" href="../css/main.css">
    <script>
        $(function (){
            $("#send").click(function (){
                var tel = $("input[name='tel']").val();
                var reg = /^[1][3-9][0-9]{9}$/;
                if (tel !="" || reg.test(tel)){
                    alert(tel);
                    $.ajax({
                        type:"GET", // 提交数据类型
                        url:"/ChangePasswordServlet", // 提交到哪个服务器
                        data:"tel="+tel, // 提交的数据
                        dataType:"text", // 提交的数据类型
                        success:function (d){ // d 回调函数 ，服务器执行完之后，接收服务器响应的数据
                            if (d==tel){
                                // 按钮生效
                                $("#save").attr("disabled",false);
                            }else{
                                alert("请勿修改手机号！")
                                // 按钮失效
                                $("#save").attr("disabled",true);
                            }
                        },
                        error:function (d,errorThrown){
                            $("#div").text(d.responseText+" "+d.status+"  "+d.readyState+" "+errorThrown);
                        },
                    });
                }
            });

        });
    </script>
</head>
<body>
<div class="login_head">
    <div class="container">
        <img src="../images/logo.png">
    </div>
</div>
<div class="login_banner">
    <div class="container">
        <div class="login">
            <div class="login_in">
                <div class="login_h">后台登陆</div>
                <form action="/SignUpServlet" method="post">
                    <div class="user_login">
                        <input type="text" name="username" value="sys" placeholder="账号">
                        <input type="text" name="password" value="1" placeholder="密码">
                    </div>
                    <button class="login_btn" type="submit" >登陆</button>
                </form><br>
                <div>
                    <a class="btn-lg" href="SignIn.jsp">免费注册</a>
                    <a class="btn-lg" data-toggle="modal" data-target="#myModal">
                        忘记密码
                    </a>
                </div>
            </div>

        </div>
    </div>
</div>

<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">Change Password</h4>
            </div>
            <div class="modal-body">
                <form method="post" action="/ChangePasswordServlet">
                    <div class="form-group">
                        <label for="input3" class="col-sm-2 control-label">Tel</label>
                        <div class="col-sm-10">
                            <input type="tel" class="form-control" id="input3" name="tel" placeholder="Tel">
                        </div>
                    </div><br><br>
                    <div class="form-group">
                        <label for="input4" class="col-sm-2 control-label">Password</label>
                        <div class="col-sm-10">
                            <input type="password" class="form-control" id="input4" name="cpassword" placeholder="Password">
                        </div>
                    </div><br><br>
                    <div class="form-group">
                        <label for="input5" class="col-sm-2 control-label">rPassword</label>
                        <div class="col-sm-10">
                            <input type="password" class="form-control" id="input5" name="crPassword" placeholder="rPassword">
                        </div>
                    </div><br><br>
                    <div class="form-group">
                        <label for="input6" class="col-sm-2 control-label">Code</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="input6" name="code" placeholder="Code" style="width: 300px;display: inline">
                            <button type="button" id="send" class="btn btn-default" style="margin-left: 20px">获取验证码</button>
                        </div>
                    </div><br>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                        <button type="submit" id="save" class="btn btn-primary">Save changes</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<div class="login_end text_center">版权所有&copy;：电子股份有限公司  豫ICP备08102576号  未经授权本站内容禁止私自转载使用！</div>
</body>
</html>
