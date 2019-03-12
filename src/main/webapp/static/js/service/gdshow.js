layui.use(['form','jquery','table','layer'], function(){
    var table = layui.table;
    var $ = layui.$;
    var form = layui.form;

    var data;//解密
    var str = window.location.href.split("data=")[1];//解密
    if(str!=null)data= myUncode(str);//解密
    if(data!=null) {
        if (data.id != null)
            $("#id").val(data.id);

        if (data.serviceId != null)
            $("#serviceId").val(data.serviceId);


        if (data.serviceTypeTitle != null)
            $("#serviceTypeTitle").val(data.serviceTypeTitle);

        if (data.outline != null)
            $("#outline").val(data.outline);

        if (data.customerName != null)
            $("#customerName").val(data.customerName);

        if (data.creationId != null)
            $("#creationId").val(data.creationId);

        // if (data.creationTime != null)
        //     $("#creationTime").val(data.creationTime);

        // if (data.userIdName != null)
        //     $("#userIdName").val(data.userIdName);

        if (data.creationName != null)
            $("#creationName").val(data.creationName);

        if (data.serviceReq != null)
            $("#serviceReq").val(data.serviceReq);

        if (data.serviceHandle != null)
            $("#serviceHandle").val(data.serviceHandle);

        if (data.handleTime != null)
            $("#handleTime").val(data.handleTime);

        if (data.allotTime != null)
            $("#allotTime").val(data.allotTime);

        if (data.creationTime != null)
            $("#creationTime").val(data.creationTime);

        // if (data.allotTime != null)
        //     $("#allotTime").val(data.allotTime);

        if (data.handleName != null)
            $("#handleName").val(data.handleName);

        if (data.userIdName != null)
            $("#userIdName").val(data.userIdName);


        // if (data.status != null)
        //   $("#status").val(data.status);
        if (data.statusTitle != null)
            $("#statusTitle").val(data.statusTitle);





        if (data.handleResult != null)
            $("#handleResult").val(data.handleResult);

        if (data.satisfaction != null){
            var xx='';
            for(var i = 0;i<data.satisfaction;i++){
                xx+='☆';
            }
            $("#satisfaction").val(xx);

        }

        // if(data.satisfaction!=null) {
        //     var list=$("#satisfaction option").each(function (index,element) {
        //         if (element.value===data.satisfaction){
        //             element.selected = true;
        //         }
        //     });
        //
        // }else{
        //     $("#customerSatisfaction").append("<option selected>"+"暂未设置"+"</option>");
        // }


        // if (data.satisfaction != null)
        //     $("#satisfaction").val(data.satisfaction);
        // if (data.handleResult != null)
        //     $("#handleResult").val(data.handleResult);
    }
    form.render();
});