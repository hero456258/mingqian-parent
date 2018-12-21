$(document).ready(function(){
    $("#saveBtn").on("click",function () {
        var id = $.trim($("#departmentId").val());
        var departmentName = $.trim($("#departmentName").val());
        var departmentDesc = $.trim($("#departmentDesc").val());

        if(departmentName == "" || departmentName == null){
            alert("部门名称不能为空！");
            return false;
        }

        if(departmentDesc == "" || departmentDesc == null){
            alert("部门描述不能为空！");
            return false;
        }

        $.ajax({
            url:web.basePath + '/department/modifyDepartment',
            data:{
                id:id,
                departmentName:departmentName,
                departmentDesc:departmentDesc
            },
            type:'post',
            dataType:'json',
            success:function(data){
                if(data.resCode != 0){
                    alert(data.msg);
                    return false;
                }
                alert("修改完成");
                window.location.href = web.basePath + "/department/toList";
            }

        });

    })
});