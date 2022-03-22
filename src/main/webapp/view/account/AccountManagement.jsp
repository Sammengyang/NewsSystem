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
</head>
<body>
<div class="AccountManagement_c " id="AccountManagement_c">
    <h3>账户管理
        <div class="amcl fr">
            <input type="text" placeholder="用户名" class="fl" name="">
            <div class="search fl"><img src="../../images/search.png"></div>
        </div>
    </h3>
    <c:if test="${sessionScope.account.role==1}">
        <div class="AM_ct text_center">
            <div class="AM_ct_in">
                <div class="add_btn df_btn fl" id="add_Account_btn">添加</div>
                <div class="edit_btn df_btn fl" id="edit_Account_btn">编辑</div>
                <div class="delete_btn df_btn fl" id="delete_Account_btn">删除</div>
                <div class="fr df_btn ac_btn" id="ac_Account_btn">账号授权</div>
            </div>
        </div>
    </c:if>
    <c:if test="${sessionScope.account.role!=1}">
        <div class="AM_ct text_center">
            <div class="delete_btn df_btn fl" id="delete_Account_btn1">注销账号</div>
            <div class="fr df_btn ac_btn" id="ac_Account_btn1">修改个人信息</div>
        </div>
    </c:if>
    <div class="list">
        <ul class="list_h">
            <li class="b20"><label><span>用户名</span></label></li>
            <li class="b20"><label>密码</label></li>
            <li class="b60"><label>授权形式</label></li>
        </ul>
        <div class="list_b_c">
            <ul class="list_null">
                <li class="text_center">未添加管理员账户！</li>
            </ul>
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
        &nbsp;&nbsp;正在给 “<span id="gant_name"></span>”账户授权
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

</body>
<script type="text/javascript" src="../../js/jquery-3.6.0.js"></script>
<script type="text/javascript" src="../../js/main.js"></script>
</html>
