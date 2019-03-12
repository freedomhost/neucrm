layui.use(['form','jquery','table','layer'], function(){
    var table = layui.table;
    var $ = layui.$;
    var form = layui.form;

    var data;//解密
    var str = window.location.href.split("data=")[1];//解密
    if(str!=null)data= myUncode(str);//解密
    console.log(data);
    form.on('submit(save-btn)', function(obj){
        layer.confirm('你确定要流失当前客户吗？',{icon:3,anim:0,skin:'layui-layer-lan'},function(index){

            $.post('/customer-loss/edit1',obj.field,function (info) {
                layer.msg(info.msg);
                setTimeout(function () {
                    layer.close(index);
                    window.location.href="../customer/loss.html";
                },500);
            });
        });
        return true; //跳转。如果需要表单跳转，去掉这段即可。
    });

    $("#tem-btn").click(function () {
        window.location.href="../customer/temloss.html?data="+str;
    });
    if(data!=null) {
        //判断是不是负责经理
        $.post('/system-user/login-info',function (info) {
            //不是负责经理
            if(info.data.name!=data.customerMgr){
                $("#fieldset").attr("disabled",true);
                $("#id").attr("disabled",true);
                $("#customerName").attr("disabled",true);
                $("#customerMgr").attr("disabled",true);
                $("#lastOrderTime").attr("disabled",true);
                $("#pauseWay").attr("disabled",true);
                $("#lossReason").attr("disabled",true);
                $("#msg").css("display","inline-block");
            }else{
                $("#save-btn").css("display","inline-block");
            }
        })
        //客户id
        if(data.id!=null)
            $("#id").val(data.id);
        //客户名字
        if(data.customerName!=null)
            $("#customerName").val(data.customerName);
        if(data.customerMgr!=null)
            $("#customerMgr").val(data.customerMgr);
        if(data.lastOrderTime!=null)
            $("#lastOrderTime").val(data.lastOrderTime);
        if(data.pauseWay!=null)
            $("#pauseWay").val(data.pauseWay);

    }

    form.render();
});