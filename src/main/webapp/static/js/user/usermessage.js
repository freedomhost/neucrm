$(function() {// 初始化内容
    $.get('/system-user/login-info',function(info){
        $('#id').val(info.data.id);
        $('#name').val(info.data.name);
        $('#logName').val(info.data.logName);
        $('#roleName').val(info.data.roleName);
    });
});

layui.use(['form','jquery','table','layer'],function() {
    let form = layui.form,
        $ = layui.jquery,
        table = layui.table;
        layer = layui.layer;

    form.on('submit(user)',function (data) {
        console.log(data.field);
        /*$.post('/system-user/save',data.field,function (info) {
            var index = parent.layer.getFrameIndex(window.name);
            parent.layer.close(index);
            /!*layer.msg(info.msg());
            layer.close();*!/
        });*/
        $.ajax({
            cache : true,
            type : "POST",
            url : "/system-user/save",
            data : data.field, // 你的formid
            async : false,
            error : function(request) {
                parent.layer.alert("网络超时");
            },
            success : function(data) {
                    parent.layer.msg("操作成功");
                    parent.location.reload();
                    var index = parent.layer.getFrameIndex(window.name);
                    parent.layer.close(index);
            }
        });
    });

});

