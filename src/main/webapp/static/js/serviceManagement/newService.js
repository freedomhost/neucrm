layui.use(['form','jquery','table','layer'],function(){
    var $ = layui.$,
        form = layui.form;

    //保存监听启用
    form.on('submit(save-btn)',function(obj) {
        //var data={};
        //var data=JSON.parse(obj.field);
        //var data=JSON.stringify( obj.field );
        data = obj.field;
        console.log($('#customerId option:selected').val());
        console.log($('#customerId option:selected').text());
        data.customerName=$('#customerId option:selected').text();
        console.log(JSON.stringify(data));
        $.post( '/service-management/save-edit',data,function(ms) {
            layer.msg(ms.msg);
            setTimeout(function () {
                location.reload();
            },800);

        });



    });
    //获取当前用户自动填写创建人
    $.get("/system-user/login-info",function(user) {
        $("#creationName").val(user.data.name);
    });

    //下拉框渲染
    // 找到所有客户

    $.get("/customer-info/customer-all",function(o){
        if(o.length!=0){
            o.forEach(function (value) {

                $("#customerId").append("<option value="+value.customerId+" >"+value.customerName+"</option>");
            });

        }
        else
            $("#userId").append("<option selected>"+"暂未设置"+"</option>");
           form.render();
    });


 $.post("/data-dict/get/服务类型",function(dict){

     if(dict.data.length!=0){
         dict.data.forEach(function (value) {

             $("#serviceType").append("<option value="+value.value+" >"+value.title+"</option>");
         });

     }
     else
         $("#serviceType").append("<option selected>"+"暂未设置"+"</option>");
     form.render();
        });
});
