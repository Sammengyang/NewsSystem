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
</head>
<body>
<div class="header">
    <div class="header_in">
        <img src="../images/tit.png">
        <a href="/SignOutServlet"><div class="quit text_center">安全退出</div></a>
    </div>

</div>
<div class="content ">
    <c:if test="${sessionScope.account.role==1}">
        <div class="user">
            <div class="user_status fl text_center">当前用户： <span>${sessionScope.account.userName}</span></div>
            <div class="user_location fl">当前： 首页-<span>账户管理</span>  </div>
        </div>
        <div class="nav_side text_center fl">
            <div class="nav AccountManagement active">账户管理</div>
            <div class="nav ColumnManagement">栏目管理</div>
            <div class="nav NewsManagement">新闻管理</div>
        </div>


        <div class="main_fx">
            <div class="AccountManagement_c_iframe">
                <iframe src="account/AccountManagement.jsp"></iframe>
            </div>
        </div>
    </c:if>


    <c:if test="">

    </c:if>
</div>
</body>
</html>