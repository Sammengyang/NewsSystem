<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Sam
  Date: 2022/3/18
  Time: 17:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <link href="../../css/main.css" rel="stylesheet">

</head>
<body>
<!-- 栏目管理 -->
<div class="AccountManagement_c" id="ColumnManagement_c">
    <h3>栏目管理
        <div class="amcl fr">
            <form method="post" action="/SerchColunmnServlet">
                <input type="text" placeholder="栏目名称" class="fl" name="SerchColName">
                <div class="search fl">
                    <button type="submit" class="search fl" style="margin: 0;border: none;padding: 0;background-color: transparent"><img src="../../images/search.png"></button>
                </div>
            </form>
        </div>
    </h3>
    <div class="AM_ct text_center">
        <c:if test="${sessionScope.account.role==1 or sessionScope.account.role==3}">
            <div class="AM_ct_in">
                <div class="add_btn df_btn fl" id="add_column_btn">添加</div>
                <div class="edit_btn df_btn fl" id="edit_column_btn">编辑</div>
                <div class="delete_btn df_btn fl" id="delete_column_btn">删除</div>
            </div>
        </c:if>
        <c:if test="${sessionScope.account.role==2}">
            <div class="add_btn df_btn fl" id="add_column_btn1" style="margin: 13px">添加</div>
            <div class="edit_btn df_btn fl" id="edit_column_btn1" style="margin-top: 13px">编辑</div>
            <div class="delete_btn df_btn fl" id="delete_column_btn1" style="margin-top: 13px">删除</div>
        </c:if>
    </div>

    <div class="list">
        <ul class="list_h">
            <li class="b20"><label><input type="checkbox" name="" style="display: none"><span>序号</span></label></li>
            <li class="b80"><label>栏目名称</label></li>
        </ul>
        <div class="list_b_c">
<%--            <ul class="list_null">--%>
<%--                <li class="text_center">未添加栏目！</li>--%>
<%--            </ul>--%>
            <c:forEach var="el" items="${allColunmn}">
                <ul class="list_b">
                    <li class="b20"><label><input type="radio" name="colid" value=${el.colid} ><span>${el.colid}</span></label></li>
                    <li class="b80"><label>${el.colName}</label></li>
                </ul>
            </c:forEach>
        </div>

        <div class="pull_page">
            <div class="fl pull_page_up"><a href="/ColManagementServlet?cpageNum=${sessionScope.cpageNum -1}">上一页</a></div>
            <ul>
                <li><a href="#">${sessionScope.cpageNum}</a></li>
            </ul>
            <div class="fl pull_page_down"><a href="/ColManagementServlet?cpageNum=${sessionScope.cpageNum +1}">下一页</a></div>
        </div>


    </div>
</div>


<!-- 添加栏目 -->
<div class="add_Account dn" id="add_column">
    <div class="add_Account_c">
        <div class="add_Account_h">
            <div class="add_Account_h_in">
                添加栏目
                <span class="fr add_Account_close"><img src="../../images/close.png"></span>
            </div>
        </div>
        <form action="/AddColunmnServlet" method="post">
            <div class="user_name user_i">
                <label>栏目名</label> <input type="text" placeholder="输入栏目名" name="colName">
            </div>
            <div class="user_password user_i">
                <label>序<i>调</i>号</label> <input type="text" placeholder="输入序号" name="colId">
            </div>
            <div class="add_Account_ok_btn text_center" >
                <button type="submit" id="add_column_ok_btn" class="add_Account_ok_btn text_center" style="margin: 0;border: none;padding: 0; background-color: transparent">确<i>啊</i>定</button>
            </div>
        </form>
    </div>
</div>

<!-- 编辑栏目 -->
<div class="add_Account dn" id="edit_column">
    <div class="add_Account_c">
        <div class="add_Account_h">
            <div class="add_Account_h_in">
                <span class="fr add_Account_close"><img src="../../images/close.png"></span>
                正在编辑“<span id="edit_colid"></span>”号栏目
            </div>
        </div>
        <form action="/editColunmnServlet" method="post">
            <div class="user_name user_i">
                <label>栏目名</label> <input type="text" placeholder="输入栏目名" name="editName">
            </div>
            <div class="user_password user_i">
                <label>序<i>调</i>号</label> <input type="text" placeholder="输入序号" name="editId">
            </div>
            <div class="add_Account_ok_btn text_center" >
                <button type="submit" id="edit_column_ok_btn" class="add_Account_ok_btn text_center" style="margin: 0;padding: 0;border: none;background-color: transparent">确<i>不</i>定</button>
            </div>
        </form>
    </div>
</div>

<!-- 删除栏目 -->
<div class="add_Account dn" id="delete_column">
    <div class="add_Account_c">
        <div class="add_Account_h">
            <div class="add_Account_h_in">
                删除栏目
                <span class="fr add_Account_close"><img src="../../images/close.png"></span>
            </div>
        </div>
        <div class="delete_text">确定删除“ <span id="del_colid"></span> ”栏目吗？</div>
        <div class="add_Account_ok_btn text_center" >
            <button type="button" id="delete_column_ok_btn" class="add_Account_ok_btn text_center" style="margin: 0;border: none;padding: 0;background-color: transparent">确<i>皮</i>定</button>
        </div>
    </div>
</div>


</body>
<script type="text/javascript" src="../../js/jquery-3.6.0.js"></script>
<script type="text/javascript" src="../../js/main.js"></script>
</html>
