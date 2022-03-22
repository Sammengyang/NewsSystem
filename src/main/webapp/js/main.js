$(function(){

    
    // 适配
    // iframe
    $(".AccountManagement_c_iframe").css("height",$(document).height());
    // 导航高度
    $(".nav_side").css("height",$(document).height()-100);
    
    // iframe  链接
    $(".AccountManagement").click(function(){
        $(".AccountManagement_c_iframe iframe").attr("src","account/AccountManagement.jsp")
    })
    $(".ColumnManagement").click(function(){
        $(".AccountManagement_c_iframe iframe").attr("src","Column/ColumnManagement.jsp")
    })
    $(".NewsManagement").click(function(){
        $(".AccountManagement_c_iframe iframe").attr("src","News/NewsManagement.jsp")
    })


	// pull page   翻页
	$(".pull_page ul li").click(function(){
		var index =$(this).index();
		if( $(this).hasClass("pull_page_df_btn")){
			return;
		}
		$(this).addClass("on").siblings().removeClass("on");

	})

	// nav
	$(".nav_side>div").click(function(){
		var index = $(this).index();
		$(this).addClass("active").siblings().removeClass("active");
		$(".main_fx>div").eq(index).show().siblings().hide();
        if( index == 0 ){
            $(".user_location span").text("账户管理");
        }else if( index == 1){
            $(".user_location span").text("栏目管理");
        }else if( index == 2){
            $(".user_location span").text("新闻管理");
        }
	})

	// 弹窗   all
	// z账户管理 -
	// 添加账户
    $("#add_Account_btn").click(function(){
        $("#add_Account").fadeIn(100);
    })
    $(".add_Account_close").click(function(){
        $("#add_Account").fadeOut(100);
        $("#user_column").fadeOut(100);
        $("#delete_Account").fadeOut(100);
        $("#ac_Account").fadeOut(100);
        $("#add_column").fadeOut(100);
        $("#edit_column").fadeOut(100);
        $("#delete_column").fadeOut(100);
    })
    // 编辑账户
    $("#edit_Account_btn").click(function(){
        $("#user_column").fadeIn(100);
		//$("#user_column input[name='username']").val('aaaaa');
        var username = $("input:radio[name='username']:checked").val()

        $("#edit_name").html(username);
        //通过get请求先将元数据传递过去
        $.ajax({
            type: "get", // 请求类型
            url: "/EdtiAccountServlet",
            data: "username="+username,// 请求数据
            dataType: "text", // 数据类型
        });


    })
    //删除账户
    $("#delete_Account_btn").click(function(){
        $("#delete_Account").fadeIn(100);
        var username = $("input:radio[name='username']:checked").val();
        $("#del_name").html(username);
        // 点击确定按钮，确认删除
        $("#delete_Account_ok_btn").click(function (){
            $.ajax({
                type:"post", // 请求类型
                url:"/DelAccountServlet", // 接收请求的服务器
                data:"username="+username, // 发送的数据
                dataType:"text",        // 数据类型
                success:function (d){ // 回调函数
                    if (d=="success"){
                        alert("删除成功！");
                    }else{
                        alert("删除失败！");
                    }
                },
                error:function (d,data){
                    alert("删除异常！")
                }
            });
        });

    })
    // 编辑账户
    $("#ac_Account_btn").click(function(){
        $("#ac_Account").fadeIn(100);
        // 获取选中的用户名
        var username = $("input:radio[name='username']:checked").val();
        $("#gant_name").html(username);
        alert(username);
        $.ajax({
            type:"get", // 请求方式
            url:"/GrantServlet",     // 处理请求的服务器
            data:"username="+username, // 数据
            dataType:"text", // 数据类型
        })
    })


    // 栏目管理 -
    $("#add_column_btn").click(function(){
        $("#add_column").fadeIn(100);
    })
    // 编辑栏目
    $("#edit_column_btn").click(function(){
        $("#edit_column").fadeIn(100);
    })
    // 删除栏目
    $("#delete_column_btn").click(function(){
        $("#delete_column").fadeIn(100);
    })

    // 确定 btn 
    $("#add_Account_ok_btn").click(function(){
        $("#add_Account").fadeOut(100);
    })
    $("#user_column_ok_btn").click(function(){
        $("#user_column").fadeOut(100);
    })
    $("#delete_Account_ok_btn").click(function(){
        $("#delete_Account").fadeOut(100);
    })
    $("#ac_Account_ok_btn").click(function(){
        $("#ac_Account").fadeOut(100);
    })
    $("#add_column_ok_btn").click(function(){
        $("#add_column ").fadeOut(100);
    })
    $("#edit_column_ok_btn").click(function(){
        $("#edit_column ").fadeOut(100);
    })

    $("#delete_column_ok_btn").click(function(){
        $("#delete_column").fadeOut(100);
    })


})