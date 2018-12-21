$(document).ready(function(){
    $.ajax({
        url: web.basePath+'/adminIndex/getAlmanac',
        type:'post',
        dataType:'json',
        success:function(data){
            $("#day").text(data.day);
            $("#nongli").text(data.html.nongli);
            $("#suici").text(data.html.suici);
            $("#yi").text(data.html.yi);
            $("#ji").text(data.html.ji);
            $("#chong").text(data.html.chong);
            console.log("this is test")
        }
    });
});