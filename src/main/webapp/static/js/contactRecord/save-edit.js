layui.use(['form','jquery','table','layer','laydate'], function(){
    var table = layui.table,
        form=layui.form,
        laydate=layui.laydate;
        $ = layui.$;
    var customerId;

    if(window.location.href.split("customerId=")[1] != null){//新建
        customerId = window.location.href.split("customerId=")[1];
    }else{
        if(window.location.href.split("data=")[1] != null){//编辑
            var data = myUncode(window.location.href.split("data=")[1]);
            customerId = data.customerId;
            if(data.id!=null)
                $('#id').val(data.id);
            if(data.contactTime!=null)
                $('#contactTime').val(data.contactTime);
            if(data.place!=null)
            $('#place').val(data.place);
            if(data.outline!=null)
                $('#outline').val(data.outline);
            if(data.detailedInfo!=null)
                $('#detailedInfo').text(data.detailedInfo);
            if(data.remarks!=null)
                $('#remarks').val(data.remarks);
        }
    }

    laydate.render({
        elem: '#contactTime'
    });
    form.on('submit(save-btn)', function(obj){
       var vals = {}
        $('#contactRecord').serializeArray().forEach(function(val){
            vals[val.name] = val.value;
        });
        vals['customerId']=customerId;
        vals['contactTime']= vals['contactTime']+" 00:00:00";
        console.log(vals);
        $.post('/contact-record/save-edit',vals,function (info) {
            layer.msg(info.msg);
            setTimeout(function () {
                parent.layer.close(parent.layer.getFrameIndex(window.name));
            },500);
        });

        return false;
    });


});