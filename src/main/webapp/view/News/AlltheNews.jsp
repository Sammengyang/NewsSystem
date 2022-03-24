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
<!-- 新闻管理 -->
<div class="AccountManagement_c" id="ColumnManagement_c">
    <h3>发布历史
        <div class="amcl fr">
           <form action="/SerchNewsServlet" method="post"><%-- 查询 --%>
                <select class="fl NewsManagement_search" name="SerchColName">
                    <c:forEach items="${respColunmn}" var="el">
                        <option value=${el.colName}>${el.colName}</option>
                    </c:forEach>
                </select>
                <input type="text" placeholder="标题名" class="fl" name="SerchTitle" value="">
                <div class="search fl">
                    <button type="submit" class="search fl" style="margin: 0;border: none;padding: 0;background-color: transparent"><img src="../../images/search.png"></button>
                </div>
            </form>
        </div>
    </h3>
    <div class="AM_ct text_center">
        <c:if test="${sessionScope.account.role==1 or sessionScope.account.role==3}">
            <div class="AM_ct_in">
                <a href="NewsManagement.jsp"><div class="add_btn df_btn fl" id="add_new_btn">发布</div></a>
                <div class="edit_btn df_btn fl" id="edit_new_btn">编辑</div>
                <div class="delete_btn df_btn fl" id="delete_new_btn">删除</div>
            </div>
        </c:if>
        <c:if test="${sessionScope.account.role==2}">
            <a href="NewsManagement.jsp"><div class="add_btn df_btn fl" id="add_new_btn1" style="margin: 13px">发布</div></a>
            <div class="edit_btn df_btn fl" id="edit_new_btn1" style="margin-top: 13px">编辑1</div>
            <div class="delete_btn df_btn fl" id="delete_new_btn1" style="margin-top: 13px">删除1</div>
        </c:if>
    </div>

    <div class="list">
        <ul class="list_h">
            <li class="b20"><label><input type="checkbox" name="" style="display: none"><span>新闻编号</span></label></li>
            <li><label>新闻标题</label></li>
            <li style="margin-left: 250px"><label>栏目名称</label></li>
            <li style="margin-left: 250px"><label>发布时间</label></li>
            <li style="margin-left: 150px"><label>操作</label></li>
        </ul>
        <div class="list_b_c">
            <c:forEach var="el" items="${newsList}">
                <ul class="list_b">
                    <li class="b20"><label><input type="radio" name="newsId" value=${el.newId} ><span>${el.newId}</span></label></li>
                    <li class="b20"><label>${el.title}</label></li>
                    <li class="b20"><label>${el.colunmns.colName}</label></li>
                    <li class="b20"><label>${el.postTime}</label></li>
                </ul>
            </c:forEach>
        </div>

        <div class="pull_page">
            <div class="fl pull_page_up"><a href="/ShowAllNewsServlet?npageNum=${sessionScope.npageNum -1 }">上一页</a></div>
            <ul>
                <li><a href="#">${sessionScope.npageNum}</a></li>
            </ul>
            <div class="fl pull_page_down"><a href="/ShowAllNewsServlet?npageNum=${sessionScope.npageNum + 1}">下一页</a></div>
        </div>


    </div>
</div>


<!-- 编辑新闻 -->
<div class="add_Account dn" id="edit_news">
    <div class="add_Account_c">
        <div class="add_Account_h">
            <div class="add_Account_h_in">
                <span class="fr add_Account_close"><img src="../../images/close.png"></span>
                正在编辑“<span id="edit_colid"></span>”号新闻
            </div>
        </div>

        <form action="/EditNewsServlet" method="post">
            <div class="user_name user_i">
                <label>新闻标题</label> <input type="text" placeholder="输入新标题" name="editTitle" value="">
            </div>
            <div class="user_password user_i" style="margin-bottom: 50px;background-color: transparent">
                <select class="fl NewsManagement_search" name ="EditColName">
                    <c:forEach items="${respColunmn}" var="el">
                        <option value=${el.colName}>${el.colName}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="add_Account_ok_btn text_center" >
                <button type="submit" id="edit_new_ok_btn" class="add_Account_ok_btn text_center" style="margin: 0;padding: 0;border: none;background-color: transparent">确<i>不</i>定</button>
            </div>
        </form>
    </div>
</div>

<!-- 删除新闻 -->
<div class="add_Account dn" id="delete_news">
    <div class="add_Account_c">
        <div class="add_Account_h">
            <div class="add_Account_h_in">
                删除新闻
                <span class="fr add_Account_close"><img src="../../images/close.png"></span>
            </div>
        </div>
        <div class="delete_text">确定删除“ <span id="del_colid"></span> ”栏目吗？</div>
        <div class="add_Account_ok_btn text_center" >
            <button type="button" id="delete_new_ok_btn" class="add_Account_ok_btn text_center" style="margin: 0;border: none;padding: 0;background-color: transparent">确<i>皮</i>定</button>
        </div>
    </div>
</div>


</body>
<script type="text/javascript" src="../../js/jquery-3.6.0.js"></script>
<script type="text/javascript" src="../../js/main.js"></script>
</html>