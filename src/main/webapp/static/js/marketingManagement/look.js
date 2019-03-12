layui.use(['form','jquery','table','layer'], function(){
    var table = layui.table;
    var $ = layui.$;
    var form = layui.form;

    var data;//解密
    var str = window.location.href.split("data=")[1];//解密
    if(str!=null)data= myUncode(str);//解密

    if(data!=null) {
        //客户编号
        if(data.id!=null){
            $("#opportunityId").val(data.id);
        }
        //机会来源
        if(data.opportunitySource!=null)
            $("#opportunitySource").val(data.opportunitySource);
        //客户名称
        if(data.name!=null)
            $("#name").val(data.name);
        //成功几率
        if(data.successProbability!=null)
            $("#successProbability").val(data.successProbability);
        //概要
        if(data.outline!=null)
            $("#outline").val(data.outline);
        //联系人
        if(data.contacts!=null)
            $("#contacts").val(data.contacts);
        //联系电话
        if(data.contactsTel!=null)
            $("#contactsTel").val(data.contactsTel);
        //机会描述
        if(data.opportunityDesc!=null)
            $("#opportunityDesc").val(data.opportunityDesc);
        //创建人
        if(data.foundName!=null)
            $("#foundName").val(data.foundName);
        //创建时间
        if(data.creationTime!=null)
            $("#creationTime").val(data.creationTime);
        //指派给
        if(data.assignName!=null)
            $("#assignName").val(data.assignName);
        //指派时间
        if(data.assignTime!=null)
            $("#assignTime").val(data.assignTime);
    }
    form.render();
});

