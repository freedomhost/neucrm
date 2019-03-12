layui.use(['form','jquery','table','layer'],function() {
    let form = layui.form,
        $ = layui.jquery,
        table = layui.table;
    layer = layui.layer;

    form.on('submit(dataDict)',function (data) {
        $.ajax({
            cache : true,
            type : "POST",
            url : "/data-dict/save",
            data : data.field, // 你的formid
            async : false,
            error : function(request) {
                parent.layer.alert("网络超时");
            },
            success : function(data) {
               parent.layer.msg(data.msg);
               var index = parent.layer.getFrameIndex(window.name);
               parent.layer.close(index);
               parent.window.location.reload();
            }
        });
    })

});

