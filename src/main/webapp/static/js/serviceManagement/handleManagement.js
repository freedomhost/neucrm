layui.use(['form','jquery','table','layer'], function(){
    var table = layui.table;
    var $ = layui.$;
    var form = layui.form;

    var data;//解密
    var str = window.location.href.split("data=")[1];//解密
    if(str!=null)data= myUncode(str);//解密

    form.on('submit(save-btn)', function(obj){

            $.post('/service-user-allot/update-Assign-Or-Handle',obj.field,function (info) {

                if(info.code==0)
                    $.post('/service-management/setHandleStatus/'+obj.field.serviceId,function(info){
                        if(info.code==0){
                            layer.msg(info.msg);
                            setTimeout(function () {
                                window.location.href='handleService.html';
                            },500);
                        }
                    });
            });


      return false; //return true; //跳转。如果需要表单跳转，去掉这段即可。
    });

    if(data!=null) {
        //id
        if(data.id!=null)
            $("#id").val(data.id);

        //id
        if(data.serviceId!=null)
            $("#serviceId").val(data.serviceId);
        //服务类型
        if(data.serviceType!=null)
            $("#serviceType").val(data.serviceType);
        //serviceTypeTitle
        if(data.serviceTypeTitle!=null)
            $("#serviceTypeTitle").val(data.serviceTypeTitle);
        //概要
        if(data.outline!=null)
            $("#outline").val(data.outline);
        //客户
        if(data.customerName!=null)
            $("#customerName").val(data.customerName);


        //状态statusTitle
        if(data.statusTitle!=null)
            $("#statusTitle").val(data.statusTitle);
        //服务请求
        if(data. serviceReq!=null)
            $("#serviceReq").val(data.serviceReq);
        //创建人
        if(data. creationName!=null)
            $("#creationName").val(data.creationName);
        //创建时间
        if(data. creationTime!=null)
            $("#creationTime").val(data.creationTime);
        //userIdName分配客户经理
        if(data.userIdName!=null)
            $("#userIdName").val(data.userIdName);
        // 分配时间
        if(data.allotTime!=null)
            $("#allotTime").val(data.allotTime);
        // 处理人为当前用户


            $.get("/system-user/login-info",function(user) {
                $("#handleName").val(user.data.name);
            });


    }
});

