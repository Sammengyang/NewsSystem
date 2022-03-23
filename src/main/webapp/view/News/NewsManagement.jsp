<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Sam
  Date: 2022/3/18
  Time: 17:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="../../css/main.css" rel="stylesheet">
</head>
<body>
<!-- 新闻管理 -->
<div class="AccountManagement_c" id="NewsManagement_c">
    <h3>新闻管理

    </h3>
    <div class="list" id="release_news">
        <ul class="list_h">
            <li class="b80"><label>发布新闻</label></li>
            <li><label><a href="/ShowAllNewsServlet" style="color: #33698a">历史发布</a></label></li>
        </ul>
        <div class="list_b_c" id="release_news_in">
            <div class="release_news">
                <form action="/PostNewsServlet" method="post">
                    <div class="news_title">
                        <label class="text_center">标题</label>
                        <input type="text" placeholder="填写标题" name="title">
                    </div>
                    <div class="column_name">
                        <label class="text_center">栏目</label>
                        <select class="column_name_release" name="PostColName">
                            <c:forEach items="${respColunmn}" var="el">
                                <option value=${el.colName}>${el.colName}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <textarea class="release_news_content" rows="50" cols="60" name="content" placeholder="编辑正文"></textarea>
                    <div class="release_news_ok_btn text_center">
                        <button type="submit" class="release_news_ok_btn text_center" style="margin: 0;padding: 0;border: none; background-color: transparent; ">发<i>我</i>布</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
<script type="text/javascript" src="../../js/jquery-3.6.0.js"></script>
<script type="text/javascript" src="../../js/main.js"></script>
</html>
