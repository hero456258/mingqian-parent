$(document).ready(function () {

    //添加部门操作
    $("#saveBtn").on("click", function () {
       var departmentName = $.trim($("#name").val());
       if(departmentName == null || departmentName == ""){
           alert("部门名称不能为空！");
           return false;
       }
       var departmentDesc = $.trim($("#descript").val());
       if(departmentDesc == null || departmentDesc == ""){
           alert("部门描述不能为空！");
           return false;
       }

        $.ajax({
            url: web.basePath + '/department/addAdminDepartment',
            data:{
                departmentName : departmentName,
                departmentDesc : departmentDesc
            },
            type:'post',
            success:function(data){
               if(data.resCode != 0){
                    alert(data.msg);
                    return false;
               }
               alert("添加成功");
               history.back(-1);
            }

        });

    })
});