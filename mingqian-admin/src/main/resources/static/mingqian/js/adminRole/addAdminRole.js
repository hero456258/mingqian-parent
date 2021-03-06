$(document).ready(function () {
    //全选
    $("input[name = 'menuAllCheck']").on("click",function () {
        //true代表选中，false代表未选中
        var currentCheck = $(this).is(":checked");
        if(currentCheck){
            //设置子菜单为选中
            $("input[type='checkbox']").prop("checked",true);
        }else{
            //设置子菜单为不选中
            $("input[type='checkbox']").prop("checked",false);
        }
    });

    //顶层菜单全选效果
    $("input[name='parentMenu']").on("click",function () {
        var currentCheck = $(this).prop("checked");
        if(currentCheck){
            //设置子菜单为选中
            $(this).parents(".menuDiv").find(".childMenuDiv input").prop("checked",true);
        }else{
            //设置子菜单为不选中
            $(this).parents(".menuDiv").find(".childMenuDiv input").prop("checked",false);
        }
    })

    //添加操作
    $("#saveBtn").on("click",function () {
        var roleName = $.trim($("input[name=roleName]").val());
        if(roleName == null || roleName == ""){
            alert("请输入角色名称！");
            return false;
        }
        var roleDesc = $.trim($("input[name=roleDesc]").val());
        if(roleDesc == null || roleDesc == ""){
            alert("请输入角色描述！");
            return false;
        }

        var menuIds = [];
         $("input[name='childMenu']:checked").each(function () {
             menuIds.push($(this).val());
         });
         var  param = {};
         param.roleName = roleName;
         param.roleDesc = roleDesc;
         param.menuIds = menuIds;
        $.ajax({
            url: web.basePath + '/adminRole/addAdminRole',
            data: JSON.stringify(param),
            type:'post',
            contentType : "application/json",
            success:function(data){
                if(data.resCode !== 0){
                    alert(data.msg);
                    return false;
                }
                alert("添加成功！");
                history.back(-1);
            }

        });




    })
});