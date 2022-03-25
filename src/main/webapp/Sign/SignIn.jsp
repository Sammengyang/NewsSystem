<%--
  Created by IntelliJ IDEA.
  User: Sam
  Date: 2022/3/12
  Time: 10:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
    <script src="/js/jquery-3.6.0.js" type="text/javascript"></script>
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">

    <!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap-theme.min.css" integrity="sha384-6pzBo3FDv/PJ8r2KRkGHifhEocL+1X2rVCTTkUfGk7/0pbek5mMa1upzvWbrUbOZ" crossorigin="anonymous">

    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js" integrity="sha384-aJ21OjlMXNL5UyIl/XNwTMqvzeRMZH2w8c5cRVpzpU8Y5bApTppSuUkhZXN0VxHd" crossorigin="anonymous"></script>

    <script type="text/javascript">
        $(function (){
            $("input[name='username']").blur(function (){
                var username = $("input[name='username']").val();
                $.ajax({
                    type:"GET", // 提交数据类型
                    url:"/SignInServlet", // 提交到哪个服务器
                    data:"username="+username, // 提交的数据
                    dataType:"text", // 提交的数据类型
                    success:function (d){ // d 回调函数 ，服务器执行完之后，接收服务器响应的数据
                        if (d=="success"){
                            $("span[id='span-sid']").html("账号已被使用");
                            // 按钮失效
                            $("#signin").attr("disabled",true);
                        }else{
                            $("span[id='span-sid']").html("");
                            // 按钮生效
                            $("#signin").attr("disabled",false);
                        }
                    },
                    error:function (d,errorThrown){
                        $("#div").text(d.responseText+" "+d.status+"  "+d.readyState+" "+errorThrown);
                    },
                });
            });
            $("input[id='send']").click(function (){
                var tel = $("input[name='tel']").val();
                alert(tel);
                $.ajax({
                    type:"GET", // 提交数据类型
                    url:"/SendSmsServlet", // 提交到哪个服务器
                    data:"tel="+tel, // 提交的数据
                    dataType:"text", // 提交的数据类型
                    success:function (d){ // d 回调函数 ，服务器执行完之后，接收服务器响应的数据
                        if (d=="success"){
                            alert("请注意查收！");
                        }else{
                            alert("短信发送失败！")
                        }
                    },
                    error:function (d,errorThrown){
                        $("#div").text(d.responseText+" "+d.status+"  "+d.readyState+" "+errorThrown);
                    },
                });
            });
        });
        function checkPwd(){
            var pwd = $("input[name='password']").val();
            var rpwd = $("input[name='rpassword']").val();
            if (pwd=="" || rpwd==""){
                $("#signin").attr("disabled",true);
            }else{
                $("#signin").attr("disabled",false);
            }
            if (pwd!=""){
                if (pwd==rpwd){
                    $("input[name='password']").css("border","2px green solid");
                    $("input[name='rpassword']").css("border","2px green solid");
                    // 按钮生效
                    $("#signin").attr("disabled",false);
                }else{
                    $("input[name='password']").css("border","2px red solid");
                    $("input[name='rpassword']").css("border","2px red solid");
                    // 按钮失效
                    $("#signin").attr("disabled",true);
                }
            }
        }
        function checkUserName(){
            var pwd = $("input[name='username']").val();
        }
    </script>
    <style>
        #login{
            margin-top: 300px;
            margin-left: 700px;
            width: 450px;
        }
        #exist{
            position: absolute;
            top: 310px;
            left: 1180px;
            font-size: 20px;
            color: red;
        }
        body{
            background-image: url("../images/canvas4.png");
            background-repeat: no-repeat;
        }
        .center-block {
            display: block;
            margin-left: auto;
            margin-right: auto;
        }
    </style>
</head>
<body>
    <%
        String role = "student";
        session.setAttribute("role",role);
    %>
<div id="login" class="center-block">
    <form action="/SignInServlet" method="post">
        <div class="input-group input-group-lg">
            <span class="input-group-addon" id="sname" >用户名</span>
            <input type="text" class="form-control" value="" name="username" onblur="checkUserName()" placeholder="UserName" aria-describedby="sizing-addon1">
        </div><br>
        <div class="input-group input-group-lg">
            <span class="input-group-addon" id="name" >用户名</span>
            <input type="text" class="form-control" value="" name="name" onblur="checkUserName()" placeholder="UserName" aria-describedby="sizing-addon1">
        </div><br>
        <div class="input-group input-group-lg">
            <span class="input-group-addon" id="password" >密码</span>
            <input type="password" class="form-control" value="" name="password" placeholder="password" aria-describedby="sizing-addon1">
        </div><br>
        <div class="input-group input-group-lg">
            <span class="input-group-addon" id="rpassword" >确认密码</span>
            <input type="password" class="form-control" value="" onblur="checkPwd()" name="rpassword" placeholder="password" aria-describedby="sizing-addon1">
        </div><br>
        <div class="input-group input-group-lg">
            <span class="input-group-addon" id="tel" >电话</span>
            <input type="text" class="form-control" value="" name="tel" placeholder="Tel" aria-describedby="sizing-addon1">
        </div><br>
        <div class="input-group input-group-lg">
            <input type="text" class="form-control" value="" name="code" placeholder="code" aria-describedby="sizing-addon1" style="width: 280px;margin-right: 20px">
            <input type="button" id="send" value="获取验证码" class="btn btn-default" style="width: 150px;height: 46px">
        </div><br>
        <button type="submit" id="signin" class="btn btn-default" style="width: 210px;height: 40px;margin-right: 25px">注册</button>
        <a href="Sign_up.jsp"><button type="button" class="btn btn-default" style="width: 210px;height: 40px" onclick="">登录</button></a>
    </form>
</div>
<div id="exist">
    <span id="span-sid"></span>
</div>
</body>
</html>
