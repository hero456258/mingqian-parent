
function autoLogin() {
    var userName = $("#loginUserName").val();
    var password = $("#loginPassword").val();
    if (userName == null || userName == "") {
        $("#loginUserName").focus();
        return;
    }
    if (password == null || password == "") {
        $("#loginPassword").focus();
        return;
    }
    $.ajax({
        url: "/login/login",
        type: "POST",
        data: {"userName": userName, "password": password},
        success: function (data) {
            if (data.resCode != "000") {
                alert(data.msg);
                return;
            }
            console.log(web.basePath+"/adminIndex/index")
            window.location.href =web.basePath+"/adminIndex/index";//yiban 别加域名，邦死，
            return true;
        }
    });


}
