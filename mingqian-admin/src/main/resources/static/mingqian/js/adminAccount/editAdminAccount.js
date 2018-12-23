$(document).ready(function () {
    var status = $("#state").val();
    if($("#a1").val() == status){
        $("#a1").attr("checked", true);
    }
    if($("#a2").val() == status){
        $("#a2").attr("checked", true);
    }


    //添加用户
    $("#saveBtn").on("click", function () {

        //用户id
        var userId = $("#userId").val();
        //登录名
        var loginName = $.trim($("#username").val());
        if (loginName == null || loginName == "" || loginName.length <= 0) {
            alert("用户名不能为空！");
            return false;
        }

        //真实姓名
        var realName = $.trim($("#name").val());
        if (realName == null || realName == "" || realName.length <= 0) {
            alert("姓名不能为空！");
            return false;
        }

        //登录密码
        var loginPwd = $.trim($("#password").val());
        if (loginPwd == null || loginPwd == "" || loginPwd.length <= 0) {
            alert("登录密码不能为空！");
            return false;
        }

        //email
        var email = $.trim($("#email").val());
        if (email == null || email == "" || email.length <= 0) {
            alert("电子邮箱不能为空！");
            return false;
        }

        //部门
        var departmentId = $.trim($("#department").val());
        if (departmentId == 0 || departmentId == "" || departmentId.length <= 0) {
            alert("部门不能为空！");
            return false;
        }

        //角色
        var roleId = $.trim($("#role").val());
        if (roleId == 0 || roleId == "" || roleId.length <= 0) {
            alert("角色不能为空！");
            return false;
        }

        //状态
        var status = $.trim($("#status input[type=radio]:checked").val());

        var addUserParam = {};
        addUserParam.userId = userId;
        addUserParam.loginName = loginName;
        addUserParam.realName = realName;
        addUserParam.loginPwd = loginPwd;
        addUserParam.email = email;
        addUserParam.departmentId = departmentId;
        addUserParam.roleId = roleId;
        addUserParam.status = status;

        //发起添加ajx操作
        $.ajax({
            url: web.basePath + '/adminAccount/updateAdminAccount',
            data: JSON.stringify(addUserParam),
            type: 'post',
            contentType: "application/json; charset=utf-8",
            success: function (data) {
                if (data.resCode != 0) {
                    alert(data.msg);
                    return false;
                }
                alert("修改成功！");
                history.back(-1);
            }
        });

    })
});
