layui.use(['form','jquery','table','layer','laydate'], function(){
        var table = layui.table,
        form=layui.form,
        $ = layui.$;
        laydate = layui.laydate;

    //日期时间选择器
    laydate.render({
        elem: '#creationTime'
        ,type: 'datetime'
    });

    form.verify({
        range: function (value, item) {
            if (value !== '' && !/^\d+$/.test(value)) {
                return "请输入正整数";
            }
            if(value > 100){
                return "数值超出范围";
            }
        },

        postInt:function (value, item) {
            if (value !== '' && !/^\d+$/.test(value)) {
                return "请输入正整数";
            }
        },
    });

    form.on('submit(save-btn)', function(obj){
        var data = {}
        $('#soptunity').serializeArray().forEach(function(val){
            data[val.name] = val.value;
        });
        $.post('/sopt/save-edit',data,function (info) {
            layer.msg(info.msg);
            parent.layer.close(parent.layer.getFrameIndex(window.name));
            parent.window.location.reload();
        });
        return false;
    });
});