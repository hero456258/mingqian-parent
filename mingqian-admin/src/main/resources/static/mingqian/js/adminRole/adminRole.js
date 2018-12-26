$(document).ready(function () {
    loadTableData();

    $("#select").click(function () {
        $('#adminRoleListTab').DataTable().draw(false);
    });

    $("#addAdminRole").on("click",function () {
        window.location.href = web.basePath + "/adminRole/toAddAdminRolePage";
    })
});


function loadTableData(isV, obj, showWarning) {
    $('#adminRoleListTab').DataTable({
        "ajax": {
            "url": web.basePath + "/adminRole/adminRoleList",
            data: function (d, s) {// 传入后台参数
                var start = s._iDisplayStart / s._iDisplayLength + 1;
                var rows = s._iDisplayLength;

                d = {};
                d.roleName = $("#roleName").val();
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
        "columns" : [ {"data" : "roleId" ,"title":"角色ID","width":"15%"},
            {"data" : "roleName" ,"title":"角色名称","width":"20%"},
            {"data" : "roleDesc"  ,"title":"角色描述","width":"20%"},
            {"data" : "createTime" ,"title":"创建时间","width":"25%"},
            {"data" : "roleId","sClass":"hiddenCol"  ,"title":"操作","width":"20%","bVisible": true,
                "render": function ( data, type, full, meta ) {
                    return '<a href="javascript:showRolePermission(' + data + ')">查看权限</a>&nbsp;'+
                        '<a href="'+web.basePath+'/adminRole/toEditAdminRolePermissionPage?roleId='+data+'">编辑</a>&nbsp;'+
                        '<a href="javascript:void(0);" onclick="deleteRole('+data+')">删除</a>&nbsp;';
                }}
        ]
    });
}

function showRolePermission(roleId){
    window.location.href = web.basePath +"/adminRole/showRolePermission?roleId=" + roleId;
}

function deleteRole(roleId) {
    bootbox.confirm("确定删除所选择的角色吗?", function(result) {
        if(!result) {
            return;
        }
        $.ajax({
            type: 'POST',
            url:  web.basePath + "/adminRole/deleteAdminRole",
            data: {"roleId" : roleId},
            success: function(data){
                if(data.resCode != 0){
                    alert(data.msg);
                    return;
                }
                $('#adminRoleListTab').DataTable().draw( false );
            }
        });
    });
}