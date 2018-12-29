$(document).ready(function(){
    $(".nav li").first().addClass("active")

    //添加菜单点击事件
    $("a[name=addMenu]").on("click",function () {
        var parentMenuName = $(this).attr("attr_parent_name");
        $("#addMenuModalTitle").html("添加【<font color='red'>"+parentMenuName+"</font>】子菜单")
        $(".addSaveBut").attr("attr_parent_id",$(this).attr("attr_parent_id"));
    })

    $(".addSaveBut").on("click",function () {
       var parentId =  $(this).attr("attr_parent_id");
       var menuName =  $.trim($("#add_menu_name").val());
       var reqUrl =  $.trim($("#add_menu_link").val());
       var showMenu = $("input[name='addShowMenu']:checked").val();
        if(menuName == null || menuName == ""){
            alert("请输入菜单名称");
            return false;
        }
        if(reqUrl == null || reqUrl == ""){
            alert("请输入请求地址");
            return false;
        }
        $.ajax({
            url : web.basePath + "/adminMenuConf/addAdminMenuConf",
            data : {
                "parentMenuId":parentId,
                "menuName":menuName,
                "reqUrl":reqUrl,
                "showMenu":showMenu
            },
            type : "POST",
            success : function (data) {
                if(data.resCode != 0){
                    alert(data.msg);
                    return false;
                }
                window.location.href = web.basePath + "/adminMenuConf/toList";
            }
        });
    })

    //编辑菜单点击事件
    $("a[name='editMenuBut']").on("click",function () {
        $(".editSaveBut").attr("attr_id",$(this).attr("attr_id"));
        $("#box_menu_name").val($(this).attr("attr_name"));
        $("#box_menu_link").val($(this).attr("attr_link"));
        var showMenu = $(this).attr("attr_show");
        $.each($("input[name='showMenu']"), function () {
           var value = $(this).val();
           if(showMenu == value){
               $(this).prop("checked",true);
           }
        })
    });

    //编辑保存
    $(".editSaveBut").on("click",function () {
        var menuId = $(this).attr('attr_id');
        var menuName = $("#box_menu_name").val();
        var reqUrl = $("#box_menu_link").val();
        var showMenu = $("input[name='showMenu']:checked").val();

        if(menuName == null || menuName == ""){
            alert("请输入菜单名称");
            return false;
        }
        if(reqUrl == null || reqUrl == ""){
            alert("请输入请求地址");
            return false;
        }
        $.ajax({
            url : web.basePath + "/adminMenuConf/editAdminMenuConf",
            data : {"menuId":menuId,"menuName":menuName,"reqUrl":reqUrl,"showMenu":showMenu},
            type : "POST",
            success : function (data) {
                if(data.resCode != 0){
                    alert(data.msg);
                    return false;
                }
                window.location.href = web.basePath + "/adminMenuConf/toList";
            }
        });
    });

    //删除点击事件
    $("a[name='delMenuBut']").on("click",function () {
        var menuId = $(this).attr("attr_id");
        console.log(menuId)
        bootbox.confirm("确定删除所选择的菜单吗?", function(result) {
            if(!result) {
                return ;
            }
            $.ajax({
                type: 'POST',
                url:  web.basePath + "/adminMenuConf/deleteAdminMenuConf",
                data: {"menuId" : menuId},
                success: function(data){
                    if(data.resCode != 0){
                        alert(data.msg);
                        return;
                    }
                   window.location.reload();
                }
            });
        });
    })
});