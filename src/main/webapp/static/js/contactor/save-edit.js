layui.use(['form','jquery','table','layer'], function(){
    var table = layui.table,
        form=layui.form,
        $ = layui.$;
    var customerId;
    if(window.location.href.split("customerId=")[1] != null){//新建联系人
        customerId = window.location.href.split("customerId=")[1];
    }else{
        if(window.location.href.split("data=")[1] != null){//编辑联系人
            var data = myUncode(window.location.href.split("data=")[1]);
            console.log(data);
            customerId = data.customerId;
            if(data.id!=null)
                $('#id').val(data.id);
            if(data.name!=null)
                $('#name').val(data.name);
            if(data.job!=null)
                $('#job').val(data.job);
            if(data.phone!=null)
                $('#phone').val(data.phone);
            if(data.tel!=null)
                $('#tel').val(data.tel);
            if(data.remark!=null)
                $('#remark').val(data.remark);

            if(data.sex==='男')
                $('#sex-f').attr('checked', 'false');
            else if(data.sex==='女')
                $('#sex-m').attr('checked','true');

            form.render('radio');

        }
    }

    form.verify({
        tel: function(value, item){ //value：表单的值、item：表单的DOM对象
            if(!(/^(\d+)(\-{0,1}(\d+))$/.test(value))){
                return '办公电话格式不正确！！';
            }
            if(value==''){
                return '办公电话不能为空！！';
            }
        }
    });

    form.on('submit(save-btn)', function(obj){
       var data = {}
        $('#contactor').serializeArray().forEach(function(val){
            data[val.name] = val.value;
        });
        data['customerId']=customerId;

        $.post('/customer-contact/save-edit',data,function (info) {
            layer.msg(info.msg);
            setTimeout(function () {
                parent.layer.close(parent.layer.getFrameIndex(window.name));
            },500);
        });

        //parent.layer.close(parent.layer.getFrameIndex(window.name));
        return false;
    });


});