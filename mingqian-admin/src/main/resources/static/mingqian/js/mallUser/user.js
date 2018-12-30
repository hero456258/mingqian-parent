$(document).ready(function(){
    //分页查询
    loadTableData();

    //搜索事件
    $("#select").on("click",function () {
        $('#departmentTable').DataTable().draw(false);
    })

    //导出excel事件
    $("#exportEcxel").on("click",function () {
        var userName = $.trim($("#userName").val());
        window.open(web.basePath+"/user/exportExcel?userName="+userName);
    })
});
function loadTableData(isV, obj, showWarning) {
    $('#departmentTable').DataTable({
        "ajax": {
            "url":  web.basePath+ "/user/userListMessage",
            data: function (d, s) {// 传入后台参数
                var start = s._iDisplayStart / s._iDisplayLength + 1;
                var rows = s._iDisplayLength;

                d = {};
                d.userName=$("#userName").val();
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
        "language":{
            "info": "当前第 _PAGE_ 页，共 _TOTAL_ 条记录",
            "emptyTable": "暂无数据",
            "loadingRecords": "loading..."
        },
        "oClasses" : {
            "sRowEmpty":"dataTables_empty text-center"
        },
        "bLengthChange" : false,
        "bInfo": true,
        "searching": false,
        "processing": false,
        "bPaginate": true,
        "serverSide": true,
        "bDestroy": true,
        "ordering": false,
        "columns": [
            {"data": "id", "title": "会员编号"},
            {"data": "userName", "title": "用户名称"},
            {"data": "userCard", "title": "身份证号"},
            {"data": "userAddress", "title": "用户住址"},
            {"data": "userSchool", "title": "用户学校"},
            {"data": "userSpecialty", "title": "用户专业"},
            {
                "data": "id", "sClass": "hiddenCol", "title": "操作", "bVisible": true,
                "render": function (data, type, full, meta) {
                    return '<a href="javascript:modifyDepartment(' + data + ')">编辑</a> | <a href="javascript:deleteDepartment(' + data + ')">删除</a>';
                }
            }
        ]
    });

}