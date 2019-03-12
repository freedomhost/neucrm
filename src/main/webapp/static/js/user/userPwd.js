$(function() {// 初始化内容
    $.get('/system-user/login-info',function(info){
        $('#id').val(info.data.id);
/*        $('#name').val(info.data.name);
        $('#logName').val(info.data.logName);
        $('#roleName').val(info.data.roleName);*/
    });
});

layui.use(['form','jquery','table','layer'],function() {
    let form = layui.form,
        $ = layui.jquery,
        table = layui.table;
        layer = layui.layer;

    form.verify({
        pass: [
            /^[\S]{6,12}$/,'密码必须6到12位，且不能出现空格'
        ],
        repass: function(value) {
            console.log(value);
            var repassvalue = $('#NewlogPwd').val();
            console.log(repassvalue);
            if (value != repassvalue) {
                return '两次输入的密码不一致!';
            }
        }
    });

    form.on('submit(userPwd)',function (data) {
        console.log(data.field);
        /*$.post('/system-user/save',data.field,function (info) {
            var index = parent.layer.getFrameIndex(window.name);
            parent.layer.close(index);
            /!* layer.msg(info.msg());
            layer.close();*!/
        });*/
        $.ajax({
            cache : true,
            type : "POST",
            url : "/system-user/updatePwd",
            data : data.field, // 你的formid
            async : false,
            error : function(request) {
                parent.layer.alert("网络超时");
            },
            success : function(data) {
                //判断当前密码输入是否正确 0正确
                if (data.code ==0){
                    parent.layer.msg(data.msg);
                    $.post('/system-user/logout',function (info) {
                        // console.log(info.code);
                        // console.log(info.msg);
                        // console.log( parent.window.location.href);
                        setTimeout(function () {
                            parent.window.location.reload();
                        },1000);
                    });
                    var index = parent.layer.getFrameIndex(window.name);
                    parent.layer.close(index);
                }else {
                    parent.layer.msg(data.msg);
                }
            }
        });
    });

});

