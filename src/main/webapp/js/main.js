$(function () {


    // 适配
    // iframe
    $(".AccountManagement_c_iframe").css("height", $(document).height());
    // 导航高度
    $(".nav_side").css("height", $(document).height() - 100);

    // iframe  链接
    $(".AccountManagement").click(function () {
        $(".AccountManagement_c_iframe iframe").attr("src", "account/AccountManagement.jsp")
    })
    $(".ColumnManagement").click(function () {
        $(".AccountManagement_c_iframe iframe").attr("src", "Column/ColumnManagement.jsp")
    })
    $(".NewsManagement").click(function () {
        $(".AccountManagement_c_iframe iframe").attr("src", "News/AlltheNews.jsp")
    })


    // pull page   翻页
    $(".pull_page ul li").click(function () {
        var index = $(this).index();
        if ($(this).hasClass("pull_page_df_btn")) {
            return;
        }
        $(this).addClass("on").siblings().removeClass("on");

    })

    // nav
    $(".nav_side>div").click(function () {
        var index = $(this).index();
        $(this).addClass("active").siblings().removeClass("active");
        $(".main_fx>div").eq(index).show().siblings().hide();
        if (index == 0) {
            $(".user_location span").text("账户管理");
        } else if (index == 1) {
            $(".user_location span").text("栏目管理");
        } else if (index == 2) {
            $(".user_location span").text("新闻管理");
        }
    })

    // 弹窗   all
    // z账户管理 -
    // 检测用户名是否可用
    $("#add_username").blur(function (){
        // 获取输入的名字
        var username = $("#add_username").val();
        $.ajax({
            type:"get",
            url:"/SignInServlet",
            data:"username="+username,
            dataType:"text",
            success:function (d){
                if (d=="success"){
                    alert("该用户名已被占用！");
                    $("#add_Account_ok_btn").attr("disabled",true);
                }else {
                    $("#add_Account_ok_btn").attr("disabled",false);
                }
            },
            error:function (d,data){
                alert("添加异常！");
            }
        });
    });



    // 添加账户
    $("#add_Account_btn").click(function () {
        $("#add_Account").fadeIn(100);
    })
    $(".add_Account_close").click(function () {
        $("#add_Account").fadeOut(100);
        $("#user_column").fadeOut(100);
        $("#delete_Account").fadeOut(100);
        $("#ac_Account").fadeOut(100);
        $("#add_column").fadeOut(100);
        $("#edit_column").fadeOut(100);
        $("#delete_column").fadeOut(100);
        $("#edit_news").fadeOut(100);
        $("#delete_news").fadeOut(100);
        $("#Set_admin").fadeOut(100);
    })

    // 检测用户名是否可用
    $("#edit_username").blur(function (){
        // 获取输入的名字
        var username = $("#edit_username").val();
        $.ajax({
            type:"get",
            url:"/SignInServlet",
            data:"username="+username,
            dataType:"text",
            success:function (d){
                if (d=="success"){
                    $("#edit_Account_ok_btn").attr("disabled",true);// 按钮失效
                    alert("该用户名已被占用！");
                }else {
                    $("#edit_Account_ok_btn").attr("disabled",false);// 生效
                }
            },
        });
    });


    // 编辑账户
    $("#edit_Account_btn").click(function () {
        //$("#user_column input[name='username']").val('aaaaa');
        var username = $("input:radio[name='username']:checked").val()
        $("#edit_name").html(username);
        if (typeof (username) == "undefined") {
            alert("请先选择操作账户！");
            $("#edit_Account_ok_btn").attr("disabled", true); // 按钮失效
        } else {
            $("#user_column").fadeIn(100);
            $("#edit_Account_ok_btn").attr("disabled", false); // 按钮生效
            //通过get请求先将元数据传递过去
            $.ajax({
                type: "get", // 请求类型
                url: "/EdtiAccountServlet",
                data: "username=" + username,// 请求数据
                dataType: "text", // 数据类型
            });
        }


    })
    //删除账户
    $("#delete_Account_btn").click(function () {
        var username = $("input:radio[name='username']:checked").val();
        $("#del_name").html(username);
        if (typeof (username) == "undefined") {
            alert("请先选择操作账户！");
            // $("#delete_Account_ok_btn").attr("disabled", true); // 按钮失效
        } else {
            $("#delete_Account").fadeIn(100);
            // 点击确定按钮，确认删除
            $("#delete_Account_ok_btn").click(function () {
                $("#delete_Account_ok_btn").attr("disabled", false); // 按钮生效
                $.ajax({
                    type: "post", // 请求类型
                    url: "/DelAccountServlet", // 接收请求的服务器
                    data: "username=" + username, // 发送的数据
                    dataType: "text",        // 数据类型
                });
            });
        }

    })
    // 栏目授权
    $("#ac_Account_btn").click(function () {
        // 获取选中的用户名
        var username = $("input:radio[name='username']:checked").val();
        $("#gant_name").html(username);
        if (typeof (username) == "undefined") {
            alert("请先选择操作账户！");
            $("#ac_Account_ok_btn").attr("disabled", true); // 按钮失效
        } else {
            $("#ac_Account").fadeIn(100);
            $("#ac_Account_ok_btn").attr("disabled", false); // 按钮生效
            $.ajax({
                type: "get", // 请求方式
                url: "/GrantServlet",     // 处理请求的服务器
                data: "username=" + username, // 数据
                dataType: "text", // 数据类型
            });
        }
    })

    // 账户授权
    $("#Set_admin_btn").click(function () {
        // 获取选中的用户名
        var username = $("input:radio[name='username']:checked").val();
        $("#gant_name").html(username);
        if (typeof (username) == "undefined") {
            alert("请先选择操作账户！");
            $("#ac_Account_ok_btn").attr("disabled", true); // 按钮失效
        } else {
            $("#Set_admin").fadeIn(100);
            $("#ac_Account_ok_btn").attr("disabled", false); // 按钮生效
            $.ajax({
                type: "get", // 请求方式
                url: "/SetAdminServlet",     // 处理请求的服务器
                data: "username=" + username, // 数据
                dataType: "text", // 数据类型
            });
        }
    })

    // // 注销账户
    // $("#Unsubscribe").click(function () {
    //     $.ajax({
    //         type:"post",
    //         url:"/UnsubscribeServlet",
    //     });
    // })


    // 栏目管理 -
    // 校验栏目和，栏目编号是否可用
    // 添加时
    $("input[name='colName']").blur(function (){
        var colName = $("input[name='colName']").val();
        $.ajax({
            type: "get", // 请求类型
            url: "/CheckColNameColIdServlet", // 接收请求的服务器
            data: "colName=" + colName, // 发送的数据
            dataType: "text",        // 数据类型
            success:function (d){
                if (d=="success"){
                    // 可用
                    $("#add_column_ok_btn").attr("disabled",false); // 按钮生效
                }else {
                    alert("栏目名重复！");
                    $("#add_column_ok_btn").attr("disabled",true); // 按钮失效
                }
            },
            error:function (d,data){
                alert("异常错误！")
            }
        });
    });
    $("input[name='colId']").blur(function (){
        var colId = $("input[name='colId']").val();
        $.ajax({
            type: "post", // 请求类型
            url: "/CheckColNameColIdServlet", // 接收请求的服务器
            data: "colId=" + colId, // 发送的数据
            dataType: "text",        // 数据类型
            success:function (d){
                if (d=="success"){
                    // 可用
                    alert("s")
                    $("#add_column_ok_btn").attr("disabled",false); // 按钮生效
                }else {
                    alert("栏目id重复！");
                    $("#add_column_ok_btn").attr("disabled",true); // 按钮失效
                }
            },
            error:function (d,data){
                alert("异常错误！")
            }
        });
    });

    // 编辑时
    $("input[name='editName']").blur(function (){
        alert("撒地方");
        var colName = $("input[name='editName']").val();
        $.ajax({
            type: "get", // 请求类型
            url: "/CheckColNameColIdServlet", // 接收请求的服务器
            data: "colName=" + colName, // 发送的数据
            dataType: "text",        // 数据类型
            success:function (d){
                if (d=="success"){
                    // 可用
                    $("#edit_column_ok_btn").attr("disabled",false); // 按钮生效
                }else {
                    alert("栏目名重复！");
                    $("#edit_column_ok_btn").attr("disabled",true); // 按钮失效
                }
            },
            error:function (d,data){
                alert("异常错误！")
            }
        });
    });
    $("input[name='editId']").blur(function (){
        alert("撒地方");
        var colId = $("input[name='editId']").val();
        $.ajax({
            type: "post", // 请求类型
            url: "/CheckColNameColIdServlet", // 接收请求的服务器
            data: "colId=" + colId, // 发送的数据
            dataType: "text",        // 数据类型
            success:function (d){
                if (d=="success"){
                    $("#edit_column_ok_btn").attr("disabled",false); // 按钮生效
                }else {
                    alert("栏目编号重复！")
                    $("#edit_column_ok_btn").attr("disabled",true); // 按钮失效
                }
            },
            error:function (d,data){
                alert("异常错误！")
            }
        });
    });



    // 添加栏目
    $("#add_column_btn").click(function () {
        $("#add_column").fadeIn(100);
    })
    // 编辑栏目
    $("#edit_column_btn").click(function () {
        // 获取选中的栏目id
        var colid = $("input:radio[name='colid']:checked").val();
        $("#edit_colid").html(colid);
        if (typeof (colid) == "undefined") {
            alert("请先选择栏目！")
            $("#edit_column_ok_btn").attr("disabled", true); // 按钮失效
        } else {
            $("#edit_column").fadeIn(100);
            $("#edit_column_ok_btn").attr("disabled", false); // 按钮生效
            $.ajax({
                type: "get",
                url: "/editColunmnServlet",
                data: "colid=" + colid,
                dataType: "text",
            });
        }
    })

    // 删除栏目
    $("#delete_column_btn").click(function () {
        // 获取选中的栏目id
        var colid = $("input:radio[name='colid']:checked").val();
        $("#del_colid").html(colid);
        if (typeof (colid) == "undefined") {
            alert("请先选择栏目！")
            $("#delete_column_ok_btn").attr("disabled", true); // 按钮失效
        } else {
            $("#delete_column").fadeIn(100);
            $("#delete_column_ok_btn").attr("disabled", false); // 按钮生效
            $.ajax({
                type: "post",
                url: "/delColunmnServlet",
                data: "colid=" + colid,
                dataType: "text",
            });
        }
    })

    $("#add_column_btn1").click(function () {
        alert("对不起，您的权限不足！");
    })
    // 编辑栏目
    $("#edit_column_btn1").click(function () {
        alert("对不起，您的权限不足！");
    })
    // 删除栏目
    $("#delete_column_btn1").click(function () {
        alert("对不起，您的权限不足！");
    })

// 新闻管理 --
    // 编辑
    $("#edit_new_btn").click(function () {
        // 获取选中的新闻
        var newId = $("input:radio[name='newsId']:checked").val();
        $("#edit_colid").html(newId);
        if (typeof (newId) == "undefined") {
            alert("请先选择新闻！")
            $("#edit_new_ok_btn").attr("disabled", true); // 按钮失效
        } else {
            $("#edit_news").fadeIn(100);
            $("#edit_new_ok_btn").attr("disabled", false); // 按钮生效
            $.ajax({
                type: "get",
                url: "/EditNewsServlet",
                data: "newId=" + newId,
                dataType: "text",
                success: function (d) {
                    if (d == "success") {
                        $("input[name='editTitle']").attr("value", d);
                    } else {
                        $("input[name='editTitle']").attr("value", d);
                    }
                },
                error: function (d, data) {
                    alert("编辑失败！")
                }
            });
        }

    })
    // 删除新闻
    $("#delete_new_btn").click(function () {
        // 获取选中的栏目id
        var newId = $("input:radio[name='newId']:checked").val();
        $("#del_colid").html(newId);
        if (typeof (newId) == "undefined") {
            alert("请先选择新闻！")
            $("#delete_new_ok_btn").attr("disabled", true); // 按钮失效
        } else {
            $("#delete_news").fadeIn(100);
            $("#delete_new_ok_btn").attr("disabled", false); // 按钮生效
            $.ajax({
                type: "post",
                url: "/DelNewsServlet",
                data: "newId=" + newId,
                dataType: "text",
            });
        }
    })


    // 编辑新闻
    $("#edit_new_btn1").click(function () {
        alert("对不起，您的权限不足！");
    })
    // 删除新闻
    $("#delete_new_btn1").click(function () {
        alert("对不起，您的权限不足！");
    })


// 导航栏
    // 账户管理
    $("#ac_Manage").click(function () {
        // window.location.href="/ManagementServlet";
        $.ajax({
            type: "post",
            url: "/ManagementServlet",
        });
    });
    // 栏目管理
    $("#col_Manage").click(function () {
        $.ajax({
            type: "post",
            url: "/ColManagementServlet",
        });
    });
    // 新闻管理
    $("#new_Manage").click(function () {
        $.ajax({
            type: "post",
            url: "/ShowAllNewsServlet",
        });
    });


    // 确定 btn
    $("#add_Account_ok_btn").click(function () {
        $("#add_Account").fadeOut(100);
    })
    $("#user_column_ok_btn").click(function () {
        $("#user_column").fadeOut(100);
    })
    $("#delete_Account_ok_btn").click(function () {
        $("#delete_Account").fadeOut(100);
    })
    $("#ac_Account_ok_btn").click(function () {
        $("#ac_Account").fadeOut(100);
    })
    $("#add_column_ok_btn").click(function () {
        $("#add_column ").fadeOut(100);
    })
    $("#edit_column_ok_btn").click(function () {
        $("#edit_column ").fadeOut(100);
    })

    $("#delete_column_ok_btn").click(function () {
        $("#delete_column").fadeOut(100);
    })


})