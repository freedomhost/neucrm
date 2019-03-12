layui.use(['jquery'],function() {
    var $ = layui.$;
    $(document).ready(function () {
        //定时执行，10分钟后执行
        var t1 = window.setInterval(refreshCount, 1000*600);
        // var t1 = window.setInterval(refreshCount, 1000*1);
        function refreshCount() {
            var myDate = new Date();
            var a = myDate.getDay().toString();
            var b = myDate.getHours().toString(); //获取当前小时数(0-23)
            //为了便于演示
            /*var c = myDate.getMinutes().toString();
            if (a == 5 && b == 10 && c==0 ) {*/

            if (a == 4 && b != 2) {
                $.post('/customer-loss/creat',function (info) {
                    if(info.msg!=null)
                    layer.msg(info.msg);
                });
            }
            // console.log("ready");
            //去掉定时器的方法
            // window.clearTimeout(t1);

        }


    });

});
