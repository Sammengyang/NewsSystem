<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>新闻发布管理平台</title>
    <meta name="description" content="">
    <meta name="keywords" content="">
    <link href="../css/main.css" rel="stylesheet">
    <script type="text/javascript" src="/js/jquery-3.6.0.js"></script>
    <script type="text/javascript" src="../js/main.js"></script>
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">

    <!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap-theme.min.css" integrity="sha384-6pzBo3FDv/PJ8r2KRkGHifhEocL+1X2rVCTTkUfGk7/0pbek5mMa1upzvWbrUbOZ" crossorigin="anonymous">

    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js" integrity="sha384-aJ21OjlMXNL5UyIl/XNwTMqvzeRMZH2w8c5cRVpzpU8Y5bApTppSuUkhZXN0VxHd" crossorigin="anonymous"></script>
</head>
<body>
<div class="header">
    <div style="float: right;margin-right: 10px">
        <c:if test="${sessionScope.fileName == null}">
            <a href="#" data-toggle="modal" data-target="#myModal"><img src="../images/canvas4.png" alt="" class="img-circle" style="width: 60px;height: 60px;margin: 8px"></a>
        </c:if>
        <c:if test="${sessionScope.fileName != null}">
            <a href="#" data-toggle="modal" data-target="#myModal"><img src=${sessionScope.fileName} alt="" class="img-circle" style="width: 60px;height: 60px;margin: 8px"></a>
        </c:if>
    </div>
    <div class="header_in">
        <img src="../images/tit.png">
        <a href="/SignOutServlet"><div class="quit text_center">安全退出</div></a>
    </div>

</div>
<div class="content ">
        <div class="user">
            <div class="user_status fl text_center">当前用户：
                <span>${sessionScope.account.userName}</span>
            </div>
            <div class="user_location fl">当前： 首页-<span>账户管理</span></div>
        </div>
        <div class="nav_side text_center fl">
            <div class="nav AccountManagement active" id="ac_Manage">账户管理</div>
            <div class="nav ColumnManagement" id="col_Manage">栏目管理</div>
            <div class="nav NewsManagement" id="new_Manage">新闻管理</div>
        </div>


        <div class="main_fx">
            <div class="AccountManagement_c_iframe">
                <iframe src="account/AccountManagement.jsp"></iframe>
            </div>
        </div>
</div>


<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">头像预览</h4>
            </div>
            <div style="margin-left: 100px">
                <form action="/PicUploadServlet" method="post" enctype="multipart/form-data">
                    <div>
                        <img src=>
                        <img src=${sessionScope.fileName} alt="" style="width: 400px;height: 400px">
                    </div>
                    <div class="form-group">
                        <label for="exampleInputFile">File input</label>
                        <input type="file" id="exampleInputFile" name="file">
                        <a href="/PicDownloadServlet">下载头像</a>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                        <input type="submit" class="btn btn-primary" value="Save changes">
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>