$(function () {
    loadTableData();
    $("#addDepartment").click(function () {
        window.location.href = web.basePath + "/department/toAdd";
    });

    $("#select").click(function () {
        $('#departmentTable').DataTable().draw(false);
    });
});

function loadTableData(isV, obj, showWarning) {
    $('#departmentTable').DataTable({
        "ajax": {
            "url":  "/department/departmentList",
            data: function (d, s) {// 传入后台参数
                var start = s._iDisplayStart / s._iDisplayLength + 1;
                var rows = s._iDisplayLength;

                d = {};
                d.departmentName=$("#department").val();
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
            {"data": "id", "title": "部门编号"},
            {"data": "departmentName", "title": "部门名称"},
            {"data": "departmentDesc", "title": "部门描述"},
            {
                "data": "id", "sClass": "hiddenCol", "title": "操作", "bVisible": true,
                "render": function (data, type, full, meta) {
                    return '<a href="javascript:redactDepartment(' + data + ')">编辑</a> | <a href="javascript:deleteDepartment(' + data + ')">删除</a>';
                }
            }
        ]
    });

}


function redactDepartment(id) {
    window.location.href = web.basePath + "/department/toRedact?id=" + id;
}

function deleteDepartment(id) {

    bootbox.confirm("将进行删除操作，请确认?", function(result) {
        if(result) {

            $.ajax({
                url: web.basePath + "/department/deleteDepartment",
                data: {
                    "id": id
                },
                type: "POST",
                success: function (data) {
                    if (data.resCode != 0) {
                        alert(data.msg);
                        return false;
                    }
                    alert("提交完成");
                    window.location.href = web.basePath + "/department/toList";
                }
            });

        }else{

        }
    });

}


