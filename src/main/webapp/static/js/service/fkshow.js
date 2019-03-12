layui.use(['form','jquery','table','layer'], function(){
    var table = layui.table;
    var $ = layui.$;
    var form = layui.form;

    var data;//解密
    var str = window.location.href.split("data=")[1];//解密
    if(str!=null)data= myUncode(str);//解密

    form.on('submit(save-btn)', function(obj){
        layer.confirm('你确定要执行此操作吗？',{icon:3,anim:0,skin:'layui-layer-lan'},function(index){
            console.log("*********************");
            console.log(obj.field);
               if(obj.field.satisfaction>=3){
                  obj.field.status=3;}
                  else{
                   obj.field.serviceHandle=null;
                   obj.field.handleName=null;

                   obj.field.handleResult=null;
                   obj.field.satisfaction=0;
                   obj.field.status=1;
             }
              console.log(obj.field);
            // var val={};
            // val['handleResult']=obj.field.handleResult;
            // val['satisfaction']=obj.field.satisfaction;
            // val['uid']=obj.field.uid;

            // console.log(val);
            $.post('/service-user-allot/feedbackEdit',obj.field,function (info) {
                if(info.code==0){
                    if(obj.field.status) {
                        obj.field.id=obj.field.serviceId;
                        $.post('/service-management/feedbackEdit', obj.field, function (info) {
                            if(info.code==0){
                                layer.msg(info.msg);
                                setTimeout(function () {
                                    window.location.href='list.html';
                                },500);
                            }

                            // layer.close(index);
                        });
                    }
                }
                layer.msg(info.msg);
                // layer.close(index);
            });
            console.log("managementfeedbackwai="+JSON.stringify(obj.field));




            // $.post('/service-management//setStatus/'+obj.field.id,function (idfo) {
            //
            //     layer.msg(idfo.msg);
            //     layer.close(index);
            // });
        });
        return true; //跳转。如果需要表单跳转，去掉这段即可。
    });
    if(data!=null) {
        if (data.id != null)
            $("#id").val(data.id);

        if (data.serviceId != null)
            $("#serviceId").val(data.serviceId);

        if (data.userIdName != null)
            $("#userIdName").val(data.userIdName);

        if (data.userId != null)
            $("#userId").val(data.userId);


        if (data.serviceTypeTitle != null)
            $("#serviceTypeTitle").val(data.serviceTypeTitle);

        if (data.outline != null)
            $("#outline").val(data.outline);

        if (data.customerName != null)
            $("#customerName").val(data.customerName);

        if (data.creationId != null)
            $("#creationId").val(data.creationId);

        if (data.creationTime != null)
             $("#creationTime").val(data.creationTime);

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

        if (data.handleName != null)
            $("#handleName").val(data.handleName);

         // if (data.status != null)
         //   $("#status").val(data.status);
         if (data.statusTitle != null)
             $("#statusTitle").val(data.statusTitle);





        if (data.handleResult != null)
            $("#handleResult").val(data.handleResult);

         if (data.satisfaction != null)
             $("#satisfaction").val(data.satisfaction);
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
