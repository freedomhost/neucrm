layui.use(['form','jquery','table','layer'],function(){
    var form = layui.form,
        $ = layui.jquery,
        table = layui.table,
        layer = layui.layer;

    //监听启用
    form.on('submit(save-btn)',function(data){
        $.post('/draw-plan/save-edit',data.field,function (info) {
            layer.msg(info.msg);
            setTimeout(function () {
                var index = parent.layer.getFrameIndex(window.name);
                parent.layer.close(index);//关闭当前页
            },500);
        });
        return false;
    });

});