layui.use(['form','jquery','table','layer'], function(){
    var table = layui.table;
    var $ = layui.$;
    var form = layui.form;

    var data;//解密
    var str = window.location.href.split("data=")[1];//解密
    if(str!=null)data= myUncode(str);//解密

    form.on('submit(save-btn)', function(obj){


         console.log("obj.field=="+obj.field);

              $.post('/service-user-allot/update-Assign-Or-Handle',obj.field,function (info) {

                  if(info.code==0)
                      $.post('/service-management/setAllotStatus/'+obj.field.serviceId,function(info){
                          if(info.code==0){
                              layer.msg(info.msg);
                              setTimeout(function () {
                                  window.location.href='assignService.html';
                              },500);
                          }
                      });
                  layer.msg(info.msg);
              });

        return false; //return true; //跳转。如果需要表单跳转，去掉这段即可。
    });

    if(data!=null) {
        //服务id
        if(data.id!=null)
            $("#serviceId").val(data.id);
        //服务类型
        if(data.serviceType!=null)
        {
            var typeTitle={};
            typeTitle["type"]="服务类型";
            typeTitle["value"]=data.serviceType;
            $.post('/data-dict/getDataDict',typeTitle,function (info) {
                $("#serviceTypeTitle").val(info.title);
            });

        }

        //概要
        if(data.outline!=null)
            $("#outline").val(data.outline);
        //客户
        if(data.customerName!=null)
            $("#customerName").val(data.customerName);
        //服务请求
        if(data. serviceReq!=null)
            $("#serviceReq").val(data.serviceReq);
        //创建人
        if(data. creationName!=null)
            $("#creationName").val(data.creationName);
        //创建时间
        if(data. creationTime!=null)
            $("#creationTime").val(data.creationTime);

        // 分配客户经理

            var customerMgr = $.get("/system-user/customer-mgr",function(o){
                if(o.length!=0){
                o.forEach(function (value) {
                    $("#userId").append("<option value="+value.id+" >"+value.name+"</option>");
                });

            }
                else
                    $("#userId").append("<option selected>"+"暂未设置"+"</option>");
                form.render();
    });


}
});

