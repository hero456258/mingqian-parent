$(document).ready(function () {
    loadTableData();

    //跳转到添加用户页
    $("#addAdminAccount").on("click",function () {
        window.location.href = web.basePath + "/adminAccount/toAddAdminAccountPage"
    })

    //密码设置模态框弹起
    $("body").on("click","a[name='resetPwd']",function () {
        var userId = $(this).attr("attr_id");
        console.log(userId)
        var realName = $(this).attr("attr_name");
        $("#boxRealName").html(realName);
        $(".modalSaveBut").attr("attr_id",userId);
    })

    //修改密码
    $(".modalSaveBut").on("click",function () {
        var userId = $(this).attr("attr_id");
        var password = $.trim($("#newPwd").val());
        if(password == null || password == ""){
            $("#newPwd").focus();
            alert("新密码不能为空！");
            return false;
        }
        var newPwd = $.trim($("#reNewPwd").val());
        if(newPwd == null || newPwd == ""){
            $("#reNewPwd").focus();
            alert("确认新密码不能为空！");
            return false;
        }
        if(password != newPwd){
            alert("两次密码不一致，请重试！");
            return false;
        }

        $.ajax({
            url : web.basePath + "/adminAccount/resetPwd",
            data : {"userId":userId,"password":password},
            type : "POST",
            success : function (data) {
                if(data.resCode != 0){
                    alert(data.msg);
                    return false;
                }
                $(".close").click();
            }
        });

    })
});

function loadTableData(isV, obj, showWarning) {
    $('#userTable').DataTable({
        "ajax": {
            "url": web.basePath + "/adminAccount/adminAccountList",
            data: function (d, s) {// 传入后台参数
                var start = s._iDisplayStart / s._iDisplayLength + 1;
                var rows = s._iDisplayLength;

                d = {};
                d.name = $("#name").val();
                d.start = start;
                d.rows = rows;
                return d;
            },
            "type": "POST",
            dataFilter: function (data) {
                var data = jQuery.parseJSON(data);
                var json = {};
                json.recordsTotal = data.result.sum;
                json.recordsFiltered = data.result.sum;
                json.data = data.result.data;
                return JSON.stringify(json);
            }
        },
        "language": {
            "info": "当前第 _PAGE_ 页，共 _TOTAL_ 条记录",
            "emptyTable": "暂无数据",
            "loadingRecords": "loading..."
        },
        "oClasses": {
            "sRowEmpty": "dataTables_empty text-center"
        },
        "bLengthChange": false,
        "bInfo": true,
        "searching": false,
        "processing": false,
        "bPaginate": true,
        "serverSide": true,
        "bDestroy": true,
        "ordering": false,
        "columns": [
            {
                "data": "userId", "title": "序号", "width": "5%",
                "render": function (data, type, row, meta) {
                    // 显示行号
                    var startIndex = meta.settings._iDisplayStart;
                    return startIndex + meta.row + 1;
                }
            },
            {"data": "loginName", "title": "用户名", "width": "15%"},
            {"data": "realName", "title": "姓名", "width": "15%"},
            {"data": "roleName", "title": "角色", "width": "15%"},
            {
                "data": "email", "title": "邮箱", "width": "20%", "render": function (data) {
                return nullToString(data);
            }
            },
            {
                "data": "departmentName", "title": "部门", "width": "10%", "render": function (data) {
                return nullToString(data);
            }
            },
            {
                "data": "status", "title": "账户状态", "width": "10%",
                "render": function (data, type, full, meta) {
                    if (data == 0) {
                        return '禁用';
                    }
                    if (data == 1) {
                        return '启用';
                    }
                }
            },
            {
                "data": "userId", "sClass": "hiddenCol", "title": "操作", "width": "10%", "bVisible": true,
                "render": function (data, type, full, meta) {
                    return '<a href="javascript:editAdminAccount(' + data + ')">编辑</a> | <a href="javascript:void(0)" name="resetPwd" attr_id="' + data + '" ' +
                        'attr_name="' + full.realName + '" data-toggle="modal" data-target="#setPwdModal">设置密码</a> | <a href="javascript:deleteAdminAccount(' + data + ')">删除</a>';
                }
            }
        ]
    });
}
    function editAdminAccount(id) {
        window.location.href = web.basePath +  "/adminAccount/toEditAdminAccountPage?id="+id;
    }

    function deleteAdminAccount(id) {

        bootbox.confirm("将进行删除操作，请确认?", function(result) {
            if(result) {
                $.ajax({
                    url : web.basePath + "/adminAccount/deleteAdminAccount",
                    data : {
                        "userId":id
                    },
                    type : "POST",
                    success : function (data) {
                        if(data.resCode != 0){
                            alert(data.msg);
                            return false;
                        }
                        alert("提交完成");
                        window.location.reload();
                    }
                });

            }else{

            }
        });
    }