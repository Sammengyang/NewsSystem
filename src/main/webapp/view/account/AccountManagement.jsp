<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%  request.setCharacterEncoding( "utf-8");%>
<% response.setCharacterEncoding("utf-8"); %>
<%--
  Created by IntelliJ IDEA.
  User: Sam
  Date: 2022/3/18
  Time: 17:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <link href="../../css/main.css" rel="stylesheet">
    <script type="text/javascript" src="../../js/jquery-3.6.0.js"></script>
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">

    <!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap-theme.min.css" integrity="sha384-6pzBo3FDv/PJ8r2KRkGHifhEocL+1X2rVCTTkUfGk7/0pbek5mMa1upzvWbrUbOZ" crossorigin="anonymous">

    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js" integrity="sha384-aJ21OjlMXNL5UyIl/XNwTMqvzeRMZH2w8c5cRVpzpU8Y5bApTppSuUkhZXN0VxHd" crossorigin="anonymous"></script>
</head>
<body>
<div class="AccountManagement_c " id="AccountManagement_c">
    <h3>账户管理
        <div class="amcl fr">
            <form action="/SerchAccountServlet" method="post">
                <input type="text" placeholder="用户名" class="fl" name="serch_username">
                <div class="search fl">
                    <button type="submit" class="search fl" style="margin: 0;border: none;padding: 0;background-color: transparent"><img src="../../images/search.png"></button>
                </div>
            </form>
        </div>
    </h3>
    <c:if test="${sessionScope.account.role==1 or sessionScope.account.role==3}">
        <div class="AM_ct text_center">
            <div class="AM_ct_in">
                <div class="add_btn df_btn fl" id="add_Account_btn" >添加</div>
                <div class="edit_btn df_btn fl" id="edit_Account_btn">编辑</div>
                <div class="delete_btn df_btn fl" id="delete_Account_btn">删除</div>
                <div class="fr df_btn ac_btn">
                    <button type="button" class="fr df_btn ac_btn" style="margin:0;padding: 0;border: none;background-color: transparent" data-toggle="modal" data-target="#myModal">查看个人信息</button>
                </div>
                <div class="fr df_btn ac_btn">
                    <button type="button" class="fr df_btn ac_btn" id="Set_admin" style="margin:0;padding: 0;border: none;background-color: transparent">设置管理员</button>
                </div>
                <div class="fr df_btn ac_btn" id="ac_Account_btn">账号授权</div>
            </div>
        </div>
    </c:if>
    <c:if test="${sessionScope.account.role == 2}">
        <div class="AM_ct text_center">
            <div class="fr df_btn ac_btn" id="ChangeInfo" style="margin-top: 13px">
                <button type="button" class="fr df_btn ac_btn" id="privateInfo" style="margin:0;padding: 0;border: none;background-color: transparent" data-toggle="modal" data-target="#myModal">查看个人信息</button>
            </div>
        </div>
    </c:if>
    <div class="list">
        <ul class="list_h">
            <li class="b20"><label><input type="checkbox" name="" style="display: none"><span>用户名</span></label></li>
            <li class="b20"><label>密码</label></li>
            <li class="b60"><label>授权形式</label></li>
        </ul>
        <div class="list_b_c">
<%--            <ul class="list_null">--%>
<%--                <li class="text_center">未添加管理员账户！</li>--%>
<%--            </ul>--%>
            <c:if test="${sessionScope.account.role==1 or sessionScope.account.role==3}">
                <c:forEach items="${allAccount}" var="el">
                    <ul class="list_b">
                        <li class="b20"><label><input type="radio" name="username" value=${el.userName} ><span>${el.userName}</span></label></li>
                        <li class="b20"><label>${el.password}</label></li>
                        <li class="b60"><label>
                            <c:forEach items="${el.colunmns}" var="col">
                                <span>${col.colName}</span>
                            </c:forEach>
                        </label></li>
                    </ul>
                </c:forEach>
            </c:if>
            <c:if test="${sessionScope.account.role==2}">
                <c:forEach items="${allAccount}" var="el">
                    <ul class="list_b">
                        <li class="b20"><label><input type="radio" name="username" value=${el.userName} ><span>${el.userName}</span></label></li>
                        <li class="b20"><label>******</label></li>
                        <li class="b60"><label>
                            <c:forEach items="${el.colunmns}" var="col">
                                <span>${col.colName}</span>
                            </c:forEach>
                        </label></li>
                    </ul>
                </c:forEach>
            </c:if>
        </div>
        <div class="pull_page">
            <div class="fl pull_page_up">上一页</div>
            <ul>
                <li class="on">1</li>
                <li>2</li>
                <li>3</li>
                <li>4</li>
                <li class="pull_page_df_btn">…</li>
                <li>12</li>
            </ul>
            <div class="fl pull_page_down">下一页</div>
        </div>


    </div>
</div>


<!-- 弹窗 -->
<!-- 添加账户 -->
<div class="add_Account dn" id="add_Account">
    <div class="add_Account_c">
        <div class="add_Account_h">
            <div class="add_Account_h_in">
                添加账户
                <span class="fr add_Account_close"><img src="../../images/close.png"></span>
            </div>
        </div>
        <form action="/AddAcountServlet" method="post">
            <div class="user_name user_i">
                <label>用户名</label>
                <input type="text" placeholder="输入用户名" name="username" value="">
            </div>
            <div class="user_password user_i">
                <label>密<i>调</i>码</label>
                <input type="password" placeholder="输入密码" name="password" value="">
            </div>
            <div class="add_Account_ok_btn text_center">
                <button type="submit" class="add_Account_ok_btn text_center" id="add_Account_ok_btn" style="margin: 0;padding: 0;border: none; background-color: transparent; ">确<i>皮</i>定</button>
            </div>
        </form>
    </div>
</div>

<!-- 账户编辑 -->
<div class="add_Account dn" id="user_column">
    <div class="add_Account_c">
        <div class="add_Account_h">
            <div class="add_Account_h_in">
                编辑账户
                <span class="fr add_Account_close"><img src="../../images/close.png"></span>
            </div>
        </div>
            <form action="/EdtiAccountServlet" method="post">
                <div class="column_now ">正在编辑 “<span id="edit_name"></span>”账户</div>
                <div class="user_name user_i">
                    <label>用户名</label>
                    <input type="text" placeholder="输入用户名" name="editName" value="">
                </div>
                <div class="user_password user_i">
                    <label>密<i>调</i>码</label>
                    <input type="password" placeholder="输入密码" name="editPassword" value="">
                </div>
                <div class="add_Account_ok_btn text_center">
                    <button type="submit" class="add_Account_ok_btn text_center" id="edit_Account_ok_btn" style="margin: 0;padding: 0;border: none; background-color: transparent; ">确<i>皮</i>定</button>
                </div>
            </form>
    </div>
</div>

<!-- 删除账户 -->
<div class="add_Account dn" id="delete_Account">
    <div class="add_Account_c">
        <div class="add_Account_h">
            <div class="add_Account_h_in">
                删除账户
                <span class="fr add_Account_close"><img src="../../images/close.png"></span>
            </div>
        </div>
        <div class="delete_text">确定删除“ <span id="del_name"></span> ”账户吗？</div>
        <div class="add_Account_ok_btn text_center" >
            <button type="button" class="add_Account_ok_btn text_center" id="delete_Account_ok_btn" style="margin: 0;padding: 0;border: none; background-color: transparent;">确<i>皮</i>定</button>
        </div>
    </div>
</div>

<!-- 账户授权 -->
<div class="add_Account dn" id="ac_Account">
    <div class="add_Account_c">
        <div class="add_Account_h">
            <div class="add_Account_h_in">
                账户栏目授权
                <span class="fr add_Account_close"><img src="../../images/close.png"></span>
            </div>
        </div>
        &nbsp;&nbsp;正在给“<span id="gant_name"></span>”账户授权
        <form method="post" action="/GrantServlet">
            <ul>
    <%--            <li><label><input type="checkbox" name="">&nbsp;<span>教务处</span></label></li>--%>
                   <c:forEach items="${allColunmn}" var="el">
                       <li><label><input type="checkbox" name="colunmn" value=${el.colName}>&nbsp;<span>${el.colName}</span></label></li>
                   </c:forEach>
            </ul>
            <div class="add_Account_ok_btn text_center" >
                <button type="submit" class="add_Account_ok_btn text_center" id="ac_Account_ok_btn" style="margin: 0;padding: 0;border: none; background-color: transparent;">保<i>呀</i>存</button>
            </div>
        </form>
    </div>
</div>

<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">Private Information</h4>
            </div>
            <form action="/ChangeInfoServlet" method="post">
                <div class="modal-body">
                    <div class="input-group">
                        <span class="input-group-addon" id="sizing-addon">用户名</span>
                        <input type="text" class="form-control" value="${account.userName}" name="username"  aria-describedby="sizing-addon2">
                    </div><br>
                    <div class="input-group">
                        <span class="input-group-addon" id="sizing-addon1">密码</span>
                        <input type="text" class="form-control" value="${account.password}" name="password" aria-describedby="sizing-addon2">
                    </div><br>
                    <div class="input-group">
                        <span class="input-group-addon" id="sizing-addon3">手机号</span>
                        <input type="text" class="form-control" value="${account.tel}" name="tel" aria-describedby="sizing-addon2">
                    </div><br>
                    <div class="input-group">
                        <c:if test="${account.role==1}">
                            <span class="input-group-addon" id="sizing-addon4">权限等级</span>
                            <input type="text" class="form-control" value="超级管理员" readonly="readonly" aria-describedby="sizing-addon2">
                        </c:if>
                        <c:if test="${account.role==2}">
                            <span class="input-group-addon" id="sizing-addon4">权限等级</span>
                            <input type="text" class="form-control" value="普通账户" readonly="readonly" aria-describedby="sizing-addon2">
                        </c:if>
                        <c:if test="${account.role==3}">
                            <span class="input-group-addon" id="sizing-addon4">权限等级</span>
                            <input type="text" class="form-control" value="管理员" readonly="readonly" aria-describedby="sizing-addon2">
                        </c:if>
                    </div><br>
                    <c:set var="col" value=""></c:set>
                    <c:forEach items="${account.colunmns}" var="col">
                        <c:set var="col" value="${col.colName}"></c:set>
                        <c:set var="str">${col},${str}</c:set>
                    </c:forEach>
                    <div class="input-group">
                        <span class="input-group-addon" id="sizing-addon5">栏目</span>
                        <input type="text" class="form-control" readonly="readonly" aria-describedby="sizing-addon2" value="${str}" >
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-primary">Save changes</button>
                </div>
            </form>
        </div>
    </div>
</div>

</body>
<script type="text/javascript" src="../../js/main.js"></script>
</html>
